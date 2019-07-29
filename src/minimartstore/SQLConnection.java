/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimartstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import minimartstore.Entity.Product;

/**
 *
 * @author dbabu
 */
public class SQLConnection {
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
      Connection conn = null;
     public void CloseConnection()
     {
          if (conn != null) {
            try {
                conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println("Error While CLosig Connection");
                    e.printStackTrace();
                    }
     }
     }
     public Connection connect() {
        try {
            // db parameters
            if(conn==null){
            String url = "jdbc:sqlite:/Users/dbabu/Personal/minimart/minimartsqlLite/minimart.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            }
            System.out.println("Connection to SQLite has been established.");            
        } catch (SQLException e) {
            System.out.println("Error While Creating Connection");
            System.out.println(e.getMessage());
        }
        return conn;
    }
      public <T> ArrayList<T>  selectAll(String tableName, Class<T> type) {
        String sql = "SELECT * FROM "+tableName;
       ArrayList<T> dataList = new ArrayList<>();
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            // loop through the result set
            while (rs.next()) {
                if(type ==Product.class)
                {
                    Product product = new Product();
                    product.setProductName(rs.getString("ProductName"));
                    product.setExpiryDate(LocalDate.parse(rs.getString("ExpiryDate"),formatter));
                    product.setTotalPurchasedQty(Integer.parseInt(rs.getString("TotalPurchasedQty")));
                    product.setTotalAvailableQty(Integer.parseInt(rs.getString("TotalAvailableQty")));
                    product.setThresholdQty(Integer.parseInt(rs.getString("ThresholdQty")));
                    product.setMrpWithoutTax(Float.parseFloat(rs.getString("MRPWithOutTax")));
                    product.setRpWithoutTax(Float.parseFloat(rs.getString("RPWithOutTax")));
                    product.setMmpWithoutTax(Float.parseFloat(rs.getString("MMPriceWithOutTax")));
                    product.setCgst(Float.parseFloat(rs.getString("CGST")));
                    product.setSgst(Float.parseFloat(rs.getString("SGST")));
                    product.setGst(Float.parseFloat(rs.getString("Tax")));
                    product.setCreatedDate(LocalDate.parse(rs.getString("CreatedDate"),formatter));
                    product.setCreatedBy(rs.getString("CreatedBy"));
                    product.setModifiedDate(LocalDate.parse(rs.getString("ModifiedDate"),formatter));
                    product.setModifiedBy(rs.getString("ModifiedBy"));
                    dataList.add((T)product);
                    System.out.println(rs.getString("ProductName"));
              }
            }            
        } catch ( SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally{
            CloseConnection();
        }
        return dataList;
    }
     public static void main(String[] args) {
         SQLConnection sqlConnection= new SQLConnection();
//        sqlConnection.selectAll();
    }
    
}
