
package com.onlineshopping.category;

/**
 *
 * @author deepak
 */
public class categoryBean {

    int categoryid;
    String categoryname;
    String categorydetails;

    public categoryBean(){
//    categoryid = 0 ;
//    categoryname=new String();
//    categorydetails=new String();
    }

    public categoryBean(int categotyid, String categoryname, String categorydetails) {
        this.categoryid = categotyid;
        this.categoryname = categoryname;
        this.categorydetails = categorydetails;
    }

    public categoryBean(String categoryname, String categorydetails) {
        this.categoryname = categoryname;
        this.categorydetails = categorydetails;
    }


    public String getCategorydetails() {
        return categorydetails;
    }

    public void setCategorydetails(String categorydetails) {
        this.categorydetails = categorydetails;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categotyid) {
        this.categoryid = categotyid;
    }


    





}
