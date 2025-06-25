package com.ankur.dao;

import com.ankur.model.Bill;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {
    
    public boolean addBill(Bill bill) {
        String sql = "INSERT INTO bills (customer_id, units, amount, bill_date) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false); // Start transaction
            
            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, bill.getCustomerId());
                ps.setInt(2, bill.getUnitsConsumed());
                ps.setDouble(3, bill.getTotalAmount());
                ps.setDate(4, Date.valueOf(bill.getBillDate()));
                
                int affectedRows = ps.executeUpdate();
                if (affectedRows == 0) {
                    conn.rollback();
                    return false;
                }
                
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        bill.setId(generatedKeys.getInt(1));
                    }
                }
                
                conn.commit();
                return true;
            }
        } catch (SQLException e) {
            if (conn != null) {
                try { conn.rollback(); } 
                catch (SQLException ex) { ex.printStackTrace(); }
            }
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                try { conn.close(); } 
                catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }

    public List<Bill> getAllBills() {
        List<Bill> bills = new ArrayList<>();
        String sql = "SELECT * FROM bills ORDER BY bill_date DESC";
        
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setCustomerId(rs.getInt("customer_id"));
                bill.setUnitsConsumed(rs.getInt("units"));
                bill.setTotalAmount(rs.getDouble("amount"));
                bill.setBillDate(rs.getDate("bill_date").toLocalDate());
                bills.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bills;
    }

    public boolean deleteBill(int id) {
        String sql = "DELETE FROM bills WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static double calculateBillAmount(int units) {
        if (units <= 100) return units * 5.0;
        else if (units <= 300) return units * 7.0;
        else return units * 10.0;
    }
}