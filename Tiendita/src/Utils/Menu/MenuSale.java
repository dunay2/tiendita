/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu;

import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuSale extends MenuBase {

    //Propósito: Menú principal de ventas
    //Menu añadir producto al carrito
    //Padre: mnuMain
    //Menú mnuTransaction
    static protected ArrayList<MenuStruct> transactionEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("mnuSell", "Realizar una Venta"));
        entries.add(new MenuStruct("mnuReturnItem", "Realizar una Devolución"));
        entries.add(new MenuStruct("", "Listar Facturas"));
        entries.add(new MenuStruct("mnuSearchInvoice", "Buscar una Factura"));
        entries.add(new MenuStruct("tail", "Volver al Menú Principal"));

        return entries;
    }
    //Propósito: Menú principal de ventas
    //Menu añadir producto al carrito
    //Padre: mnuMain
    //Menú mnuTransaction

    static protected ArrayList<MenuStruct> transactionSaleEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("mnuQuery", "Consultar el importe actual"));
        entries.add(new MenuStruct("mnuAddItemToCart", "Añadir Producto al Carrito"));
        entries.add(new MenuStruct("mnuBuying", "Cobrar Compra"));

        entries.add(new MenuStruct("tail", "Cancelar venta"));

        return entries;
    }

    static protected ArrayList<MenuStruct> transactionCancelEntries(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca la Referencia de Factura:"));
          entries.add(new MenuStruct("output", "Introduzca la Referencia de Producto:"));

        return entries;
    }

   
    static protected ArrayList<MenuStruct> transactionSearchInvoices(String parentMnuName) {
        //15. mnuTransaction
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca la Referencia de Factura:"));
       

        return entries;
    }
    
    //Menu añadir producto al carrito
    //Padre: mnuTransaction
    //Menú mnuAddItemToCart
    static protected ArrayList<MenuStruct> addItemToCartEntries(String parentMnuName) {
        //16 mnuAddItemToCart

        //Input menu
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca código de artículo"));
        entries.add(new MenuStruct("output", "Introduzca cantidad"));

        return entries;
    }

    //Menu obtener codigo producto 
    //Padre: mnuAddItemToCart
    //Menú output
    static protected ArrayList<MenuStruct> getItemCode(String parentMnuName) {
        //getItemCode

        //Input menu
        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("output", "Introduzca código de artículo"));

        return entries;
    }

    //Propósito: Agregar entradas al menú forma de pago
    //Menu seguir comprando
    //Padre: mnuBuying
    //Menú mnuPaymentType
    static protected ArrayList<MenuStruct> paymentTypeEntries(String parentMnuName) {

        ArrayList<MenuStruct> entries = new ArrayList();
        //6. mnuPaymentType   

        entries.add(new MenuStruct("mnuCash", "Efectivo"));
        entries.add(new MenuStruct("mnuCard", "Tarjeta"));
        entries.add(new MenuStruct("mnuFinance", "Financiado"));
        entries.add(new MenuStruct("tail", "Cancelar"));

        return entries;

    }
    //Propósito: Agregar entrada con mensaje financiacion
    //Menu seguir comprando
    //Padre: ???
    //Menú mensaje

    /**
     *
     * @param parentMnuName
     * @return
     */
    static protected ArrayList<MenuStruct> createFinanceMessage(String parentMnuName) {

        //18. 
        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("", "Por favor, para terminar la compra pase por el departamento financiero e indique su DNI"));
//el hijo es main, es tail
        return entries;

    }

    //Propósito: Agregar clientes
    //Padre: mnuBuying
    //Menú mnuAddClient
    static protected ArrayList<MenuStruct> addClientEntriesNoID(String parentMnuName) {
//Input menu
        //1. mnuAddClient
        return MenuClient.addClientEntriesNoID("mnuBuying");

    }

    static protected ArrayList<MenuStruct> getClientIdEntries(String parentMnuName) {
//Input menu

        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("output,mnuBuyGetClientId", "Introduzca DNI del cliente"));
        entries.add(new MenuStruct("output", "Introduzca nombre"));
        entries.add(new MenuStruct("output", "Introduzca Apellido"));
        entries.add(new MenuStruct("output", "Introduzca Domicilio"));
        entries.add(new MenuStruct("output", "Introduzca email"));

        return entries;
    }

}