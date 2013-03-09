package com.onlineshopping.orderdetails;

import com.onlineshopping.ConnectionPool;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author vedisoft
 */
public class orderdetailsDAO {

    ConnectionPool c = null;
    Connection conn = null;

    public void create(orderdetailsBean bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "insert into orderdetails(oid,productid,quantity)" + " values(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getOid());
            pstmt.setInt(2, bean.getProductid());
            pstmt.setInt(3, bean.getQuantity());
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void edit(orderdetailsBean bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "update orderdetails set oid=? , productid=? , quantity=? where odid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getOid());
            pstmt.setInt(2, bean.getProductid());
            pstmt.setInt(3, bean.getQuantity());
            pstmt.setInt(4, bean.getOdid());
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
            String sql = "delete from orderdetails where odid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<orderdetailsBean> findAll() {
        ArrayList<orderdetailsBean> al = new ArrayList<orderdetailsBean>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select odid,oid,productid,quantity from orderdetails";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                orderdetailsBean bean = new orderdetailsBean();
                bean.setOdid(rs.getInt("odid"));
                bean.setOid(rs.getInt("oid"));
                bean.setProductid(rs.getInt("productid"));
                bean.setQuantity(rs.getInt("quantity"));
                al.add(bean);
            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

    public orderdetailsBean find(int id) {
        orderdetailsBean bean = new orderdetailsBean();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from orderdetails where odid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setOdid(rs.getInt("odid"));
                bean.setOid(rs.getInt("oid"));
                bean.setProductid(rs.getInt("productid"));
                bean.setQuantity(rs.getInt("quantity"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
        return bean;
    }
    public static void main(String[] args) {
//       orderdetailsDAO rd= new orderdetailsDAO();
//       ArrayList<orderdetailsBean> r=rd.findAll();
//       for(orderdetailsBean r1:r)
//       {System.out.println(r1.getProductid());
//       }

//        orderdetailsBean bean = new orderdetailsBean(2, 5, 7, 7);
//        orderdetailsDAO cd = new orderdetailsDAO();
//        cd.create(bean);

//        orderdetailsBean bean = new orderdetailsBean(2, 6, 5, 9);
//        orderdetailsDAO cd = new orderdetailsDAO();
//        cd.edit(bean);

//        orderdetailsBean bean = new orderdetailsBean();
//        orderdetailsDAO cd = new orderdetailsDAO();
//        cd.remove(2);

        orderdetailsDAO cd = new orderdetailsDAO();
        orderdetailsBean bean = cd.find(1);
        System.out.println(bean.getProductid());



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
