/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimartstore.Entity;

/**
 *
 * @author dbabu
 */
public class BasketProduct {
  private String basketId;
    private String productId;
    private String promotionId;
    private String promotionName;
    private String variant;
    private String variantValue;
    private int quantity;
    private float mrpWithoutTax;
    private float rpWithoutTax;
    private float mmpWithoutTax;
    private float cgst;
    private float sgst;
    private float gst;
    private String barCode;
    private String productName;
    private String createdBy;
    private String modifiedBy;
    
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    } 

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getVariantValue() {
        return variantValue;
    }

    public void setVariantValue(String variantValue) {
        this.variantValue = variantValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
}
