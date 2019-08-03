/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import Business.CustomerBasket;
import Business.ProductList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import javax.swing.table.AbstractTableModel;
import minimartstore.Entity.BasketProduct;
import minimartstore.Entity.Product;

/**
 *
 * @author dbabu
 */
public class CustomerBasketModel extends AbstractTableModel{
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
         DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( "E MMM dd HH:mm:ss z uuuu" )
                                       .withLocale( Locale.getDefault() );
   public static ArrayList<BasketProduct> prodList;
   CustomerBasket customerProductList = new CustomerBasket();
      private String[] columnNames = {"ProductName","Quantity","MRPWithoutTax","RPWithoutTax","MMPriceWithoutTax","CGST","SGST","GST"};
   public CustomerBasketModel(){}
      public CustomerBasketModel(CustomerBasket customerProductList,String search) {
      if(!search.isEmpty())
      {
       if(prodList.size() > 0){
       this.prodList.stream().forEach(prod ->{
          if(!prod.getBarCode().equals(search))
                      this.prodList.add(customerProductList.readSingleProduct(search));   
       });
      }
      else
                                this.prodList.add(customerProductList.readSingleProduct(search));   

   }
   }
    public boolean addProduct(BasketProduct basketProduct)
   {
       try{
           
           if(basketProduct.getProductName()!=null )
           {
               if(prodList.size()>0)
               {
                    for(BasketProduct basketprod: prodList)
                    {
                            if(basketprod.getBarCode().equals(basketProduct.getBarCode())){
                                basketprod.setQuantity(basketprod.getQuantity()+1);
                                return true;
                            }
                    }
                    prodList.add(basketProduct);
                    return true;
               }
               else
               {
                                 prodList.add(basketProduct);
                                 return true;
               }
           }
           
       }
       catch(Exception e){
           return false;
       }
       return false;
   }
    
    public void insertCustomerProductToDB()
    {
        customerProductList.add(prodList);
    }
    
   public BasketProduct getProduct(String barCode)
   {
       try{
           return customerProductList.readSingleProduct(barCode);
       }
       catch(Exception e){
       }
       return null;
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
         switch (columnIndex) {
         case 1:
             return true;
         default:
             return false;
      }
    }
 
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        BasketProduct row = prodList.get(rowIndex);
        try{
        if (columnIndex == 0) {
            row.setProductName(aValue.toString());
      }
        else if (columnIndex == 1) {
            row.setQuantity(Integer.parseInt(aValue.toString()));
      }
      else if (columnIndex == 2) {
            row.setMrpWithoutTax(Float.parseFloat(aValue.toString()));
      }
      else if (columnIndex == 3) {
            row.setRpWithoutTax(Float.parseFloat(aValue.toString()));
      }
      else if (columnIndex == 4) {
            row.setMmpWithoutTax(Float.parseFloat(aValue.toString()));
      }
      else if (columnIndex == 5) {
            row.setCgst(Float.parseFloat(aValue.toString()));
      }
      else if (columnIndex == 6) {
            row.setSgst(Float.parseFloat(aValue.toString()));
      }
      else if (columnIndex == 7) {
            row.setGst(Float.parseFloat(aValue.toString()));
      }
        CustomerBasket customerBasket = new CustomerBasket();
      //customerBasket.add(row); 
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
      try{
          if(!prodList.get(row).equals(null)){
      if (col == 0) {
         temp = prodList.get(row).getProductName();
      }
      else if (col == 1) {
         temp = prodList.get(row).getQuantity();
      }else if (col == 2) {
         temp = prodList.get(row).getMrpWithoutTax();
      }
      else if (col == 3) {
         temp = prodList.get(row).getRpWithoutTax();
      }
      else if (col == 4) {
         temp = prodList.get(row).getMmpWithoutTax();
      }
      else if (col == 5) {
         temp = prodList.get(row).getCgst();
      }
      else if (col == 6) {
         temp = prodList.get(row).getSgst();
      }
      else if (col == 7) {
         temp = prodList.get(row).getGst();
      }
          }
      }
      catch(Exception e){
          e.printStackTrace();
      }
      
      return temp;    
    }
    
   
}
