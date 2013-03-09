package com.onlineshopping.customer;

import com.onlineshopping.ConnectionPool;
import com.onlineshopping.category.categoryBean;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author vedisoft
 */
public class customerDAO {

    ConnectionPool c = null;
    Connection conn = null;

    public void create(customerBean bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "insert into customer(customername,address,phone,email,username,password)" + " values(?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getCustomername());
            pstmt.setString(2, bean.getAddress());
            pstmt.setString(3, bean.getPhone());
            pstmt.setString(4, bean.getEmail());
            pstmt.setString(5, bean.getUsername());
            pstmt.setString(6, bean.getPassword());
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
			String sql = "select customerid,customername from customer";
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

    public void edit(customerBean bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "update customer set customername=? , address=? , phone=? , email=? , username=? , password=? where customerid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getCustomername());
            pstmt.setString(2, bean.getAddress());
            pstmt.setString(3, bean.getPhone());
            pstmt.setString(4, bean.getEmail());
            pstmt.setString(5, bean.getUsername());
            pstmt.setString(6, bean.getPassword());
            pstmt.setInt(7, bean.getCustomerid());
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public int check1(String un, String pw) {

        int count = 0;
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "SELECT count(*) FROM customer where username='" + un + "' and password='" + pw + "'";
            System.out.println("aaaaa" + sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            count = rs.getInt(1);
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return count;
    }



    public void remove(int id) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "delete from customer where customerid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<customerBean> findAll() {
        ArrayList<customerBean> al = new ArrayList<customerBean>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select customerid,customername,address,phone,email,username,password from customer";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                customerBean bean = new customerBean();
                bean.setCustomerid(rs.getInt("customerid"));
                bean.setCustomername(rs.getString("customername"));
                bean.setAddress(rs.getString("address"));
                bean.setPhone(rs.getString("phone"));
                bean.setEmail(rs.getString("email"));
                bean.setUsername(rs.getString("username"));
                bean.setPassword(rs.getString("password"));
                al.add(bean);
            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

    public customerBean find(int id) {
        customerBean bean = new customerBean();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from customer where customerid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setCustomerid(rs.getInt("customerid"));
                bean.setCustomername(rs.getString("customername"));
                bean.setAddress(rs.getString("address"));
                bean.setPhone(rs.getString("phone"));
                bean.setEmail(rs.getString("email"));
                bean.setUsername(rs.getString("username"));
                bean.setPassword(rs.getString("password"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
        return bean;
    }
    public static void main(String[] args) {
//       customerDAO rd= new customerDAO();
//       ArrayList<customerBean> r=rd.findAll();
//       for(customerBean r1:r)
//       {System.out.println(r1.getCustomername());
//       }
        
        customerBean bean = new customerBean(1,"deepak", "patwari colony Sehore", "7879544770", "deepak.sisodiya@gmail.com", "deepak", "deepak");
        customerDAO cd = new customerDAO();
        cd.create(bean);

//        customerBean bean = new customerBean(19, "nerendra", "delhi","6868953478", "narendra.sisodiya@gmail.com", "narendra", "narendrabhai");
//        customerDAO cd = new customerDAO();
//        cd.edit(bean);

//         customerBean bean = new customerBean();
//         customerDAO cd = new customerDAO();
//         cd.remove(2);

//        customerDAO cd = new customerDAO();
//        customerBean bean = cd.find(1);
//        System.out.println(bean.getCustomername());



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
