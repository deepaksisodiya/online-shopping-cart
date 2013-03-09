package com.onlineshopping.product;

import com.onlineshopping.ConnectionPool;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author vedisoft
 */
public class productDAO {

    ConnectionPool c = null;
    Connection conn = null;

    public void create(productBean bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "insert into product(categoryid,productname,productprice,stockinhand,dangerlevel)" + " values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getCategoryid());
            pstmt.setString(2, bean.getProductname());
            pstmt.setFloat(3, bean.getProductprice());
            pstmt.setInt(4, bean.getStockinhand());
            pstmt.setInt(5, bean.getDangerlevel());
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
			String sql = "select productid,productname from product ";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				rows+= " <option value="+rs.getInt(1)+"> " +"  "+rs.getString(2)+"\n";
			}
		c.putConnection(conn) ;
		}
		catch(Exception e) {
			System.out.println(e);
 		}
		return rows;
	}

    public ArrayList<productBean> findProductsForCategory(int id) {
        ArrayList<productBean> al = new ArrayList<productBean>();
        try {
            Connection conn = null;
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select productname,productprice,productid from product where categoryid=" + id;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                productBean roomBean = new productBean();
                roomBean.setProductname(rs.getString(1));
                roomBean.setProductprice(rs.getFloat(2));
                roomBean.setProductid(rs.getInt(3));

                al.add(roomBean);
            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }


    
    
    public void edit(productBean bean) {
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "update product set categoryid=? , productname=? , productprice=? , stockinhand=?, dangerlevel=? where productid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getCategoryid());
            pstmt.setString(2, bean.getProductname());
            pstmt.setFloat(3, bean.getProductprice());
            pstmt.setInt(4, bean.getStockinhand());
            pstmt.setInt(5, bean.getDangerlevel());
            pstmt.setInt(6, bean.getProductid());
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
            String sql = "delete from product where productid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            c.putConnection(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<productBean> findAll() {
        ArrayList<productBean> al = new ArrayList<productBean>();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select productid,categoryid,productname,productprice,stockinhand,dangerlevel from product";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                productBean bean = new productBean();
                bean.setProductid(rs.getInt("productid"));
                bean.setCategoryid(rs.getInt("categoryid"));
                bean.setProductname(rs.getString("productname"));
                bean.setProductprice(rs.getFloat("productprice"));
                bean.setStockinhand(rs.getInt("stockinhand"));
                bean.setDangerlevel(rs.getInt("dangerlevel"));
                al.add(bean);
            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return al;
    }

    public productBean find(int id) {
        productBean bean = new productBean();
        try {
            if (c == null) {
                c = ConnectionPool.getInstance();
                c.initialize();
            }
            conn = c.getConnection();
            String sql = "select * from product where productid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setProductid(rs.getInt("productid"));
                bean.setCategoryid(rs.getInt("categoryid"));
                bean.setProductname(rs.getString("productname"));
                bean.setProductprice(rs.getFloat("productprice"));
                bean.setStockinhand(rs.getInt("stockinhand"));
                bean.setDangerlevel(rs.getInt("dangerlevel"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
        return bean;
    }
    public static void main(String[] args) {
       productDAO cd = new productDAO();
       ArrayList<productBean> r = cd.findAll();
       for(productBean r1 : r)
       System.out.println(r1.getProductid());


//        productBean bean = new productBean(2, 3, "laptop", 20000, 100, 10);
//        productDAO cd = new productDAO();
//        cd.create(bean);

//        productBean bean = new productBean(2, 4, "books", 150, 500, 100);
//        productDAO cd = new productDAO();
//        cd.edit(bean);

//        productBean bean = new productBean();
//        productDAO cd = new productDAO();
//        cd.remove(2);

//        productDAO cd = new productDAO();
//        productBean bean = cd.find(1);
//        System.out.println(bean.getProductname());

    }
}
