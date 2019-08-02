/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimartstore.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author dbabu
 */
public class Product {
    private String productName;
    private String barCode;
    private LocalDate expiryDate;
    private int totalPurchasedQty;
    private int totalAvailableQty;
    private int thresholdQty;
    private float mrpWithoutTax;
    private float rpWithoutTax;
    private float mmpWithoutTax;
    private float cgst;
    private float sgst;
    private float gst;
    private LocalDate createdDate;
    private String createdBy;
    private LocalDate modifiedDate;
    private String modifiedBy;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getTotalPurchasedQty() {
        return totalPurchasedQty;
    }

    public void setTotalPurchasedQty(int totalPurchasedQty) {
        this.totalPurchasedQty = totalPurchasedQty;
    }

    public int getTotalAvailableQty() {
        return totalAvailableQty;
    }

    public void setTotalAvailableQty(int totalAvailableQty) {
        this.totalAvailableQty = totalAvailableQty;
    }

    public int getThresholdQty() {
        return thresholdQty;
    }

    public void setThresholdQty(int thresholdQty) {
        this.thresholdQty = thresholdQty;
    }

    public float getMrpWithoutTax() {
        return mrpWithoutTax;
    }

    public void setMrpWithoutTax(float mrpWithoutTax) {
        this.mrpWithoutTax = mrpWithoutTax;
    }

    public float getRpWithoutTax() {
        return rpWithoutTax;
    }

    public void setRpWithoutTax(float rpWithoutTax) {
        this.rpWithoutTax = rpWithoutTax;
    }

    public float getMmpWithoutTax() {
        return mmpWithoutTax;
    }

    public void setMmpWithoutTax(float mmpWithoutTax) {
        this.mmpWithoutTax = mmpWithoutTax;
    }

    public float getCgst() {
        return cgst;
    }

    public void setCgst(float cgst) {
        this.cgst = cgst;
    }

    public float getSgst() {
        return sgst;
    }

    public void setSgst(float sgst) {
        this.sgst = sgst;
    }

    public float getGst() {
        return gst;
    }

    public void setGst(float gst) {
        this.gst = gst;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    } 
    public Product(){}
    public Product(String productName)
    {
                this.productName = productName;
    }
    public Product(String barCode, String productName, LocalDate expiryDate, int totalPurchasedQty, int totalAvailableQty, int thresholdQty, float mrpWithoutTax, float rpWithoutTax, float mmpWithoutTax, float cgst, float sgst, float gst,  String createdBy, String modifiedBy) {
        this.barCode= barCode;
        this.productName = productName;
        this.expiryDate = expiryDate;
        this.totalPurchasedQty = totalPurchasedQty;
        this.totalAvailableQty = totalAvailableQty;
        this.thresholdQty = thresholdQty;
        this.mrpWithoutTax = mrpWithoutTax;
        this.rpWithoutTax = rpWithoutTax;
        this.mmpWithoutTax = mmpWithoutTax;
        this.cgst = cgst;
        this.sgst = sgst;
        this.gst = gst;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }
    
}
