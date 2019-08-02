/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import Business.ProductList;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;
import minimartstore.Entity.Product;

/**
 *
 * @author dbabu
 */
public class ProductTableModel extends AbstractTableModel {
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
         DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( "E MMM dd HH:mm:ss z uuuu" )
                                       .withLocale( Locale.getDefault() );
   private ArrayList<Product> prodList;
      private String[] columnNames = {"ProductName","ExpiryDate","TotalPurchasedQty","TotalAvailableQty","ThresholdQty","MRPWithoutTax","RPWithoutTax","MMPriceWithoutTax","CGST","SGST","GST"};
   public ProductTableModel(){}
      public ProductTableModel(ProductList productList,String search) {
        this.prodList = productList.readallProduct(search);   
   }
    public int getRowCount() {
      int size;
      if (prodList == null) {
         size = 0;
      }
      else {
         size = prodList.size();
      }
      return size;    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }
 
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        Product row = prodList.get(rowIndex);
        try{
        if (columnIndex == 0) {
            row.setProductName(aValue.toString());
      }
      else if (columnIndex == 1) {
         row.setExpiryDate(LocalDate.parse(aValue.toString(),formatter));
      }
      else if (columnIndex == 2) {
            row.setTotalPurchasedQty(Integer.parseInt(aValue.toString()));
      }
      else if(columnIndex==3){
      row.setTotalAvailableQty(Integer.parseInt(aValue.toString()));
      }
      else if (columnIndex == 4) {
            row.setThresholdQty(Integer.parseInt(aValue.toString()));
      }else if (columnIndex == 5) {
            row.setMrpWithoutTax(Float.parseFloat(aValue.toString()));
      }
      else if (columnIndex == 6) {
            row.setRpWithoutTax(Float.parseFloat(aValue.toString()));
      }
      else if (columnIndex == 7) {
            row.setMmpWithoutTax(Float.parseFloat(aValue.toString()));
      }
      else if (columnIndex == 8) {
            row.setCgst(Float.parseFloat(aValue.toString()));
      }
      else if (columnIndex == 9) {
            row.setSgst(Float.parseFloat(aValue.toString()));
      }
      else if (columnIndex == 10) {
            row.setGst(Float.parseFloat(aValue.toString()));
      }
        ProductList productList = new ProductList();
      productList.Update(row); 
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
    @Override
    public int getColumnCount() { 
        return columnNames.length;
    }
     public String getColumnName(int col) {
      return columnNames[col];
    }
     
//     public Class getColumnClass(int col) {
//      if (col == 2) {
//         return Double.class;
//      }
//      else {
//         return String.class;
//      }
//   }
       public void removeRow(int row) {
        prodList.remove(row);
    }
    @Override
    public Object getValueAt(int row, int col) {
      Object temp = null;
  if (col == 0) {
         temp = prodList.get(row).getProductName();
      }
      else if (col == 1) {
         temp = LocalDate.parse(prodList.get(row).getExpiryDate().toString()).format(formatter);
      }
      else if (col == 2) {
         temp = prodList.get(row).getTotalPurchasedQty();
      }
      else if (col == 3) {
         temp = prodList.get(row).getTotalAvailableQty();
      }
      else if (col == 4) {
         temp = prodList.get(row).getThresholdQty();
      }else if (col == 5) {
         temp = prodList.get(row).getMrpWithoutTax();
      }
      else if (col == 6) {
         temp = prodList.get(row).getRpWithoutTax();
      }
      else if (col == 7) {
         temp = prodList.get(row).getMmpWithoutTax();
      }
      else if (col == 8) {
         temp = prodList.get(row).getCgst();
      }
      else if (col == 9) {
         temp = prodList.get(row).getSgst();
      }
      else if (col == 10) {
         temp = prodList.get(row).getGst();
      }
      
      return temp;    
    }
    
}
