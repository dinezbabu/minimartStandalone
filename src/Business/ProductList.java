/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import static Utility.Constant.PRODUCTTABLE;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import minimartstore.Entity.Product;
import minimartstore.SQLConnection;

/**
 *
 * @author dbabu
 */
public class ProductList {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    private ArrayList<Product> productList;
    SQLConnection sqlConnection=null;

    
    public ProductList() {
      productList = new ArrayList<Product>();
   }
    public void delete(Product product) {
        //Need IMplementation
        String sql = "DELETE FROM "+PRODUCTTABLE+" Where ProductName=?";
         try (Connection conn = this.connect();
             PreparedStatement stmt  = conn.prepareStatement(sql);)
         {
            stmt.setString(1, product.getProductName());
            stmt.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
   }
    public void Update(Product product) {
        //Need IMplementation
        String sql = "UPDATE "+PRODUCTTABLE+" SET ProductName=?,"
                + "ExpiryDate=?,"
                +"TotalPurchasedQty=?,"
                +"TotalAvailableQty=?,"
                +"ThresholdQty=?,"
                + "MRPWithOutTax=?,"
                + "RPWithOutTax=?,"
                + "MMPriceWithOutTax=?,"
                + "CGST=?,"
                + "SGST=?,"
                + "Tax=?,"
                + "ModifiedDate=?,"
                + "ModifiedBy=?"
                +" Where ProductName=?";
         try (Connection conn = this.connect();
             PreparedStatement stmt  = conn.prepareStatement(sql);)
         {
            stmt.setString(1, product.getProductName());
            stmt.setString(2,product.getExpiryDate().format(formatter));
            stmt.setInt(3, product.getTotalPurchasedQty());
            stmt.setInt(4, product.getTotalAvailableQty());
            stmt.setInt(5, product.getThresholdQty());
            stmt.setFloat(6, product.getMrpWithoutTax());
            stmt.setFloat(7, product.getRpWithoutTax());
            stmt.setFloat(8, product.getMmpWithoutTax());
            stmt.setFloat(9, product.getCgst());
            stmt.setFloat(10, product.getSgst());
            stmt.setFloat(11, product.getGst());
            stmt.setString(12, LocalDate.now().format(formatter));
            stmt.setString(13, product.getModifiedBy());
            stmt.setString(14, product.getProductName());
            stmt.executeUpdate();
            System.out.println("Data Updated for Product"+product.getProductName());
         }
         catch(Exception e){
             e.printStackTrace();
         }
   }
    
    public void add(Product product) {
        //Need IMplementation
        String sql = "INSERT INTO "+PRODUCTTABLE+" (ProductName,ExpiryDate,TotalPurchasedQty,TotalAvailableQty,ThresholdQty,MRPWithOutTax,RPWithOutTax,MMPriceWithOutTax,CGST,SGST,Tax,CreatedDate,CreatedBy,ModifiedDate,ModifiedBy)"+
                "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         try (Connection conn = this.connect();
             PreparedStatement stmt  = conn.prepareStatement(sql);)
         {
            stmt.setString(1, product.getProductName());
            stmt.setString(2,product.getExpiryDate().format(formatter));
            stmt.setInt(3, product.getTotalPurchasedQty());
            stmt.setInt(4, product.getTotalAvailableQty());
            stmt.setInt(5, product.getThresholdQty());
            stmt.setFloat(6, product.getMrpWithoutTax());
            stmt.setFloat(7, product.getRpWithoutTax());
            stmt.setFloat(8, product.getMmpWithoutTax());
            stmt.setFloat(9, product.getCgst());
            stmt.setFloat(10, product.getSgst());
            stmt.setFloat(11, product.getGst());
            stmt.setString(12, LocalDate.now().format(formatter));
            stmt.setString(13, product.getCreatedBy());
            stmt.setString(14, LocalDate.now().format(formatter));
            stmt.setString(15, product.getModifiedBy());
            stmt.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
   }
    
    public ArrayList<Product> getProduct() {
      return productList;
   }
    
    private Connection connect()
    {
         sqlConnection= sqlConnection==null? new SQLConnection(): sqlConnection;
         return sqlConnection.connect();
    }
    
    public ArrayList<Product> readallProduct(String search)
    {
        String sql;
         if(search.trim().isEmpty())
          sql= "SELECT * FROM "+PRODUCTTABLE;
         else
          sql="SELECT * FROM "+PRODUCTTABLE+" where ProductName like '%"+search+"%' ";
         ArrayList<Product> dataList = new ArrayList<>();
         try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            // loop through the result set
            while (rs.next()) {
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
                    dataList.add(product);
                    System.out.println(rs.getString("ProductName"));
            }            
        } catch ( SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return dataList;
    }
    
    
}
