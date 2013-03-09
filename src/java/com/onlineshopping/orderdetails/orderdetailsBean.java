/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.onlineshopping.orderdetails;

/**
 *
 * @author deepak
 */
public class orderdetailsBean {

    int odid;
    int oid;
    int productid;
    int quantity;

    public orderdetailsBean(){
        odid = 0;
        oid = 0;
        productid = 0;
        quantity = 0;
    }

    public orderdetailsBean(int odid, int oid, int productid, int quantity) {
        this.odid = odid;
        this.oid = oid;
        this.productid = productid;
        this.quantity = quantity;
    }

    public int getOdid() {
        return odid;
    }

    public void setOdid(int odid) {
        this.odid = odid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
