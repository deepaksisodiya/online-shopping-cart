/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.onlineshopping.customer;

/**
 *
 * @author deepak
 */
public class customerBean {

    int customerid;
    String customername ;
    String address ;
    String phone ;
    String email ;
    String username ;
    String password ;

public customerBean(){
    customerid = 0;
    customername = new String();
    address = new String();
    phone = new String();
    email = new String();
    username = new String();
    password = new String();

}

    public customerBean(int customerid, String customername, String address, String phone, String email, String username, String password) {
        this.customerid = customerid;
        this.customername = customername;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
