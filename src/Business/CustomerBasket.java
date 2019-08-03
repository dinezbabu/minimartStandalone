/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import static Utility.Constant.BASKETTABLE;
import static Utility.Constant.PRODUCTTABLE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import minimartstore.Entity.BasketProduct;
import minimartstore.Entity.Product;
import minimartstore.SQLConnection;
/**
 *
 * @author dbabu
 */
public class CustomerBasket {
    SQLConnection sqlConnection=null;
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
     private String basketID;
     private static Connection conn;

     public CustomerBasket()
     {
         conn = this.connect();
     }
     private Connection connect()
    {
         sqlConnection= sqlConnection==null? new SQLConnection(): sqlConnection;
         return sqlConnection.connect();
    }
     
     private void getBasketID() throws SQLException{
         String sql ="SELECT  id FROM Basket ORDER BY id DESC LIMIT 1";
          try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                                  basketID = "Basket_"+(Integer.parseInt(rs.getString("id"))+1);
            }
            }
          catch(Exception e){
              e.printStackTrace();
          }
          finally{
              connect().close();
          }
     }
     
      public void add(ArrayList<BasketProduct> productList) {
          int totalPurchaseQty=0;
        String sql2 ="SELECT  id FROM "+BASKETTABLE+" ORDER BY id DESC LIMIT 1";
        String sql = "INSERT INTO "+BASKETTABLE+" (ProductName,BarCode,Quantity,MRPWithOutTax,RPWithOutTax,MMPriceWithOutTax,CGST,SGST,Tax,CreatedDate,CreatedBy,ModifiedDate,ModifiedBy,BasketId)"+
                "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        String sql3 = "UPDATE "+PRODUCTTABLE+" SET "
                + "TotalAvailableQty=?"
                +" Where BarCode=?";
        if(conn!=null)
        {
         try (PreparedStatement stmt  = conn.prepareStatement(sql);
                 Statement stmt1  = conn.createStatement();
                 ResultSet rs    = stmt1.executeQuery(sql2);
                 PreparedStatement stmt3  = conn.prepareStatement(sql3))
         {
             while (rs.next()) {
                                  basketID = "Basket_"+(Integer.parseInt(rs.getString("id"))+1);
            }
            for(BasketProduct product: productList) 
            {
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getBarCode());
            stmt.setInt(3, product.getQuantity());
            stmt.setFloat(4, product.getMrpWithoutTax());
            stmt.setFloat(5, product.getRpWithoutTax());
            stmt.setFloat(6, product.getMmpWithoutTax());
            stmt.setFloat(7, product.getCgst());
            stmt.setFloat(8, product.getSgst());
            stmt.setFloat(9, product.getGst());
            stmt.setString(10, LocalDate.now().format(formatter));
            stmt.setString(11, product.getCreatedBy());
            stmt.setString(12, LocalDate.now().format(formatter));
            stmt.setString(13, product.getModifiedBy());
            stmt.setString(14, basketID);
            stmt.executeUpdate();
            String sql4="Select * from "+PRODUCTTABLE+" Where BarCode="+ product.getBarCode();
            Statement stmt2  = conn.createStatement();
            ResultSet rs1    = stmt2.executeQuery(sql4);
            while (rs1.next()) {
                                  totalPurchaseQty = Integer.parseInt(rs1.getString("TotalAvailableQty"));
            }
                System.out.println("totalPurchaseQty "+totalPurchaseQty);
            if(totalPurchaseQty <=0)
                throw new Exception(product.getBarCode() + "Out of Invemtory");
            stmt3.setInt(1,totalPurchaseQty-product.getQuantity());
            stmt3.setString(2,product.getBarCode());
            stmt3.executeUpdate();
            }
         }
         catch(Exception e){
             e.printStackTrace();
         }
        }
   }
     
       public void delete(Product product) {
        //Need IMplementation
        String sql = "DELETE FROM "+PRODUCTTABLE+" Where Barcode=?";
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
     public BasketProduct readSingleProduct(String barCode){
         if(!barCode.trim().isEmpty())
         {
          String sql="SELECT * FROM "+PRODUCTTABLE+" where Barcode="+barCode;
         try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            BasketProduct basket = new BasketProduct();
            while (rs.next()) {
                    basket.setProductName(rs.getString("ProductName"));
                    basket.setQuantity(1);
                    basket.setMrpWithoutTax(Float.parseFloat(rs.getString("MRPWithOutTax")));
                    basket.setRpWithoutTax(Float.parseFloat(rs.getString("RPWithOutTax")));
                    basket.setMmpWithoutTax(Float.parseFloat(rs.getString("MMPriceWithOutTax")));
                    basket.setCgst(Float.parseFloat(rs.getString("CGST")));
                    basket.setSgst(Float.parseFloat(rs.getString("SGST")));
                    basket.setGst(Float.parseFloat(rs.getString("Tax")));
                    basket.setBarCode(rs.getString("BarCode"));
            }
            return basket;
        } catch ( SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
     }
        return null;
    }
}
