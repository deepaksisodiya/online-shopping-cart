/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.onlineshopping.product;

/**
 *
 * @author deepak
 */
public class productBean {

    int productid;
    int categoryid;
    String productname;
    float productprice;
    int stockinhand;
    int dangerlevel;

    public productBean(){
        productid = 0;
        categoryid = 0;
        productname = new String();
        productprice = 0;
        stockinhand = 0;
        dangerlevel = 0;
    }

    public productBean(int productid, int categoryid, String productname, float productprice, int stockinhand, int dangerlevel) {
        this.productid = productid;
        this.categoryid = categoryid;
        this.productname = productname;
        this.productprice = productprice;
        this.stockinhand = stockinhand;
        this.dangerlevel = dangerlevel;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getDangerlevel() {
        return dangerlevel;
    }

    public void setDangerlevel(int dangerlevel) {
        this.dangerlevel = dangerlevel;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public float getProductprice() {
        return productprice;
    }

    public void setProductprice(float productprice) {
        this.productprice = productprice;
    }

    public int getStockinhand() {
        return stockinhand;
    }

    public void setStockinhand(int stockinhand) {
        this.stockinhand = stockinhand;
    }
    
}
