package com.ankur.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Bill implements Serializable {
    private int id;
    private int customerId;
    private int unitsConsumed;
    private double totalAmount;
    private LocalDate billDate;

    // Constructors, getters and setters
    public Bill() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public int getUnitsConsumed() { return unitsConsumed; }
    public void setUnitsConsumed(int unitsConsumed) { this.unitsConsumed = unitsConsumed; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public LocalDate getBillDate() { return billDate; }
    public void setBillDate(LocalDate billDate) { this.billDate = billDate; }
}