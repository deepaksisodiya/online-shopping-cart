package com.onlineshopping.order;

import com.onlineshopping.ConnectionPool;
import com.onlineshopping.customer.customerBean;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author vedisoft
 */
public class orderDAO {

    ConnectionPool c = null;
    Connection conn = null;

    public void create(orderBean bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "insert into order1(orderdate,customerid,orderamount,paymentreceived) values(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getOrderdate());
            pstmt.setInt(2, bean.getCustomerid());
            pstmt.setFloat(3, bean.getOrderamount());
            pstmt.setString(4, bean.getPaymentreceived());
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void edit(orderBean bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "update order1 set orderdate=? , customerid=? , orderamount=? , paymentreceived=? where orderid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getOrderdate());
            pstmt.setInt(2, bean.getCustomerid());
            pstmt.setFloat(3, bean.getOrderamount());
            pstmt.setString(4, bean.getPaymentreceived());
            pstmt.setInt(5, bean.getOrderid());
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void remove(int id) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "delete from order1 where orderid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<orderBean> findAll() {
        ArrayList<orderBean> al = new ArrayList<orderBean>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select orderid,orderdate,customerid,orderamount,paymentreceived from order1";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                orderBean bean = new orderBean();
                bean.setOrderid(rs.getInt("orderid"));
                bean.setOrderdate(rs.getString("orderdate"));
                bean.setCustomerid(rs.getInt("customerid"));
                bean.setOrderamount(rs.getFloat("orderamount"));
                bean.setPaymentreceived(rs.getString("paymentreceived"));
                al.add(bean);
            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

    public orderBean find(int id) {
        orderBean bean = new orderBean();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from order1 where orderid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setOrderid(rs.getInt("orderid"));
                bean.setOrderdate(rs.getString("orderdate"));
                bean.setCustomerid(rs.getInt("customerid"));
                bean.setOrderamount(rs.getFloat("orderamount"));
                bean.setPaymentreceived(rs.getString("paymentreceived"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
        return bean;
    }
    public static void main(String[] args) {
//       orderDAO rd= new orderDAO();
//       ArrayList<orderBean> r=rd.findAll();
//       for(orderBean r1:r)
//       {System.out.println(r1.getOrderdate());
//       }

        orderBean bean = new orderBean(1,"2012-03-03",1,156,"No");
        orderDAO cd = new orderDAO();
        cd.create(bean);

//        orderBean bean = new orderBean(1,"2012-04-28",1,245,"yes");
//        orderDAO cd = new orderDAO();
//        cd.edit(bean);

//        orderBean bean = new orderBean();
//        orderDAO cd = new orderDAO();
//        cd.remove(1);

//        orderDAO cd = new orderDAO();
//        orderBean bean = cd.find(2);
//        System.out.println(bean.getOrderdate());
//




    }
}
/*
Vedisoft Software and Education Services Pvt. Ltd.<br/>
275, Zone II, M.P.Nagar,
Bhopal.
Ph: 0755-4076207,208<br/>
Email: contact@vedisoft.com<br/>
Web: www.vedisoft.com<br/>
Courses : Java, .NET, PHP, C/C++, Web Designing
Certifications : OCJP, OCP, CCNA
Major and Minor Training and Projects
 */
