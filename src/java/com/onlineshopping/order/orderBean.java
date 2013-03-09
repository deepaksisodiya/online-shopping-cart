/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.onlineshopping.order;

/**
 *
 * @author deepak
 */
public class orderBean {

    int orderid;
    String orderdate;
    int customerid;
    float orderamount;
    String paymentreceived;

public orderBean(){
    orderid = 0;
    orderdate = new String();
    customerid = 0;
    orderamount = 0;
    paymentreceived = new String();
}

    public orderBean(int orderid, String orderdate, int customerid, float orderamount, String paymentreceived) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.customerid = customerid;
        this.orderamount = orderamount;
        this.paymentreceived = paymentreceived;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public float getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(float orderamount) {
        this.orderamount = orderamount;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getPaymentreceived() {
        return paymentreceived;
    }

    public void setPaymentreceived(String paymentreceived) {
        this.paymentreceived = paymentreceived;
    }


}
