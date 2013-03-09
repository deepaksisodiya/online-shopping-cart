package com.onlineshopping.category;

import com.onlineshopping.ConnectionPool;
import com.onlineshopping.customer.customerBean;
import com.onlineshopping.customer.customerDAO;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author vedisoft
 */
public class categoryDAO {

    ConnectionPool c = null;
    Connection conn = null;

    public void create(categoryBean bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "insert into category(categoryname,categorydetails)" + " values(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getCategoryname());
            pstmt.setString(2, bean.getCategorydetails());
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void edit(categoryBean bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "update category set categoryname=? , categorydetails=? where categoryid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getCategoryname());
            pstmt.setString(2, bean.getCategorydetails());
            pstmt.setInt(3, bean.getCategoryid());
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
public String getOptions() {
		String rows =new String();
		try{
			if(c == null) {
				c = ConnectionPool.getInstance();
				c.initialize();
			}
			conn = c.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select categoryid,categoryname from category ";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				rows+= " <option value="+rs.getInt(1)+"> " +"  "+rs.getString(2)  +"\n";
			}
		c.putConnection(conn) ;
		}
		catch(Exception e) {
			System.out.println(e);
 		}
		return rows;
	}

    public void remove(int id) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "delete from category where categoryid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<categoryBean> findAll() {
        ArrayList<categoryBean> al = new ArrayList<categoryBean>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from category";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                categoryBean b = new categoryBean();
                b.setCategoryid(rs.getInt("categoryid"));
                b.setCategoryname(rs.getString("categoryname"));
                b.setCategorydetails(rs.getString("categorydetails"));
                al.add(b);
            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }


    public categoryBean find(int id) {
        categoryBean bean = new categoryBean();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from category where categoryid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setCategoryid(rs.getInt("categoryid"));
                bean.setCategoryname(rs.getString("categoryname"));
                bean.setCategorydetails(rs.getString("categorydetails"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
        return bean;
    }
    public static void main(String[] args) {
//         categoryDAO rd= new categoryDAO();
//         ArrayList<categoryBean> r=rd.findAll();
//         for(categoryBean r1:r)
//
//         {
//             System.out.println(r1.getCategoryid());
//          }

        categoryBean cb=new categoryBean("electronics","mobile");
        categoryDAO cd=new categoryDAO();
        cd.create(cb);

//        categoryBean bean=new categoryBean(2,"deepka", "sisodiya");
//        categoryDAO cd = new categoryDAO();
//        cd.edit(bean);
        
//        categoryBean bean=new categoryBean();
//        categoryDAO cd = new categoryDAO();
//        cd.remove(1);


//        categoryDAO cd = new categoryDAO();
//        categoryBean bean = cd.find(2);
//        System.out.println(bean.getCategoryname());


    }
}
