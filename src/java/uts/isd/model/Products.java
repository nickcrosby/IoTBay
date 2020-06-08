/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

/**
 *
 * @author Karl Silis
 */
public class Products {
//PRODUCTID, PRODUCTNAME, PRODUCTDESCRIPTION, PRODUCTCOST,PRODUCTRETAILPRICE, PRODUCTSTOCK
    //Registration data fields
    private int productId;
    private String productName;
    private String productDescription;
    private double productCost;
    private double productRP;
    private int productStock;

    //Initialise constructor with user fields
    public Products(int productId, String productName, String productDescription, double productCost, double productRP, int productStock) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCost = productCost;
        this.productRP = productRP;
        this.productStock = productStock;
    }
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public double getProductRP() {
        return productRP;
    }

    public void setProductRP(double productRP) {
        this.productRP = productRP;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
    
}
