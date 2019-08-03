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

    
     private Connection connect()
    {
         sqlConnection= sqlConnection==null? new SQLConnection(): sqlConnection;
         return sqlConnection.connect();
    }
      public void add(BasketProduct product) {
        //Need IMplementation
        String sql = "INSERT INTO "+BASKETTABLE+" (ProductName,BarCode,Quantity,MRPWithOutTax,RPWithOutTax,MMPriceWithOutTax,CGST,SGST,Tax,CreatedDate,CreatedBy,ModifiedDate,ModifiedBy)"+
                "Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
         try (Connection conn = this.connect();
             PreparedStatement stmt  = conn.prepareStatement(sql);)
         {
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getBarCode());
            stmt.setString(3, product.getBarCode());
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
            stmt.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
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
