/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class ShoppingCart implements Serializable {

    public class Line implements Serializable{//Estructura privada que contiene el pedido

        private byte lineNumber;
        private String itemCode;
        private int amount;
        private double price;

        public byte getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(byte lineNumber) {
            this.lineNumber = lineNumber;
        }

        public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
    // En el shopping cart los items son líneas(con un código), no electrodomesticos
    // Es una lista poco extensa a la que podemos acceder por indice
    //No hay que realizar búsquedas y el acceso a elementos es directo    
    private String invoiceCode;
    private String cashierCode;
    private String clientCode;
    private LocalDateTime salesDate;//Fecha de compra
    private double totalAmount = 0; // Precio de la compra
    private byte lineNumber;//Control de entradas en el carrito

    private ArrayList<Line> items ;

    public ShoppingCart(String cashierCode) {
        items=new ArrayList();
        
        this.cashierCode = cashierCode;

        //establecer la fecha por defecto 
        this.salesDate = LocalDateTime.now();
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getClient() {
        return clientCode;
    }

    public void setClient(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getCashier() {
        return cashierCode;
    }

    public void setCashier(String cashierCode) {
        this.cashierCode = cashierCode;
    }

    public LocalDateTime getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(LocalDateTime salesDate) {
        this.salesDate = salesDate;
    }

    public ArrayList<Line> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addItem(String itemCode, double itemPrice, int amount) {
        Line line = new Line();

        line.setLineNumber(this.lineNumber++);
        line.setItemCode(itemCode);
        line.setPrice(itemPrice);
        line.setAmount(amount);

        items.add(line);

        totalAmount = totalAmount + line.price * line.amount;
    }

    public void removeItem(int lineNumber) {

        Line line = items.get(lineNumber);

        items.remove(line);
        totalAmount = totalAmount - line.getPrice();
    }

}
