/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.onlineshopping.order;

/**
 *
 * @author deepak
 */
public class MasterOrder {



private String productname;
private double productprice,subtotal;
private  int productid,quantity;


    public MasterOrder() {
    }

    public MasterOrder(String productname, double productprice, double subtotal, int productid, int quantity) {
        this.productname = productname;
        this.productprice = productprice;
        this.subtotal = subtotal;
        this.productid = productid;
        this.quantity = quantity;
    }


   	void setData(String productname, double productprice, double subtotal, int productid, int quantity)
	{
        this.productname = productname;
        this.productprice = productprice;
        this.subtotal = subtotal;
        this.productid = productid;
        this.quantity = quantity;

        }



           	void setData1(int productid,String productname, double productprice)
	{
        this.productname = productname;
        this.productprice = productprice;
        this.productid = productid;
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

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }


    
}
