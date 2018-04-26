/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Person.Client.Client;
import Person.Employee.Cashier;
import ScreenInterfaces.TextInterface;
import Utils.Node;
import Utils.ShoppingCart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import Utils.Record.Record;
import Utils.Record.Sale;
import item.Electrodomestic;
//Crear un numero de factura

/**
 *
 * @author ashh412
 */
public class SaleManager extends OperationsManager {

    private Client client;
    private Cashier cashier;//Lo declaramos como objeto para poder usar sus métodos
    private final ShoppingCart shoppingCart;
    //  private final HashMap<String, Record> history = new HashMap<>();
    private final ClientManager clientManager;
    private final StockManager stockManager;
    private String operCode = "INVOICE ".concat(String.valueOf(size()));
    private static SaleManager instance = null;    //Singleton  Pattern

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    //Singleton Singleton Pattern
    protected SaleManager(Cashier cashier, ClientManager clientManager, StockManager stockManager) {
        this.cashier = cashier;
        shoppingCart = new ShoppingCart(this.cashier.getDni());
        this.clientManager = clientManager;
        this.stockManager = stockManager;

    }
    //Singleton Singleton Pattern

    public static SaleManager getInstance(Cashier cashier, ClientManager clientManager, StockManager stockManager) {
        if (instance == null) {
            instance = new SaleManager(cashier, clientManager, stockManager);
        }
        return instance;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    @Override
    public Object get(int rollNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Node callTailMenu(Node node) {
        return node.getChildNodes().get(node.getChildNodes().size() - 1);
    }

    @Override
    public Record createObject(Node[] enode) {

        Node node = enode[0];

        //1. buscar cliente y si no existe crearlo
        StringBuilder outString = new StringBuilder();

        //Devolvemos el código introducido por teclado en el StringBuilder de salida
        client = (Client) clientManager.search(node, outString);

        //Si el cliente no existe lo creamos
        if (client == null) {
            client = clientManager.createObject(enode);
        }
//continuamos por el menu
        enode[0] = callTailMenu(node);

        operCode = "INVOICE".concat(String.valueOf(size()));
        System.out.println(">>>>>>>>>>>>>" + operCode);
        return null;
    }

    @Override
    public boolean handleProcess(Node[] enode) {
        Node node = enode[0];

        switch (node.getValue()) {

            case 5:
                list();
                TextInterface.pressKey();
                return true;

            //Consultar el importe actual
            case 11:
                itemList();
                return true;
            //"12. Añadir electrodomestico al carrito"
            case 12:
                addItem(node);
                return true;

            //13. Cobrar Compra
            case 13:
                //identificar al cliente o solicitar alta 

                createObject(enode);

//Seguimos navegando por los hijos
                return false;

            //Crear carrito aleatorio
            //Cancelar venta
            case 14:
                clearShoppingCart();
                return true;

            case 1341://pago en efectivo
                finishTransaction();
                enode[0] = callMainMenu(node);
                return true;

            case 1342://Tarjeta
                finishTransaction();
                enode[0] = callMainMenu(node);
                return true;

            case 1343://Financiado
                finishTransaction();

                return false;
            case 13431://Mensaje final financiado
                enode[0] = callMainMenu(node);

        }
        return false;//Profundiza
    }

    private void finishTransaction() {
        //continuar aqui, sacar el resto de nodos hijos con la forma de pago
        //Si financia pasar a financiacion
//Guardamos la compra

//agregamos en la ficha de cliente el código de operacion
        client.addOperation(operCode);
        clientManager.save();

        //Agregamos y guardamos todos los datos de la venta
        add(new Sale(operCode, client.getDni(), cashier.getDni(), shoppingCart));
        save();
    }

    public Sale getSale(String operCod) {

//                 StringBuilder outString = new StringBuilder();
//                Client client = (Client) search(node, outString);
//                printRecord(client);
        Sale sale = (Sale) searchRecord(operCod);
        if (sale != null) {

            //printHeader();
            listFormat(sale);

            return sale;

        }
        return null;
    }

    private void openCreditLine() {

        //crear credito para el cliente
    }

    private void clearShoppingCart() {
        for (byte i = 0; i < shoppingCart.getItems().size(); i++) {
            shoppingCart.removeItem(i);
        }
    }

    private double getTotalAmount() {

        return shoppingCart.getTotalAmount();
    }

    private void addItem(Node node) {

        int i = 0;

        StringBuilder outString = new StringBuilder();
        Electrodomestic item = stockManager.search(node, outString);
        if (item == null) {
            return;
        }

        ArrayList<String> nodesData = node.convertTreeChildToListIdx();

        String itemCode = item.getCode();
        Byte amount = Byte.parseByte(nodesData.get(i++));
        Double cost = amount * item.getSellPrice();

        shoppingCart.addItem(itemCode, cost, amount);
    }
//Proposito: Listar elementos del carrito. Dar formato

    private void itemList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Fecha:" + shoppingCart.getSalesDate());
        printHeader();

        if (!shoppingCart.getItems().isEmpty()) {
            if (shoppingCart.getItems().size() > 0) {
                shoppingCart.getItems().forEach((ShoppingCart.Line line) -> {

                    String s = line.getLineNumber() + " ";
                    s = s.concat(line.getItemCode().concat(" "));
                    s = s.concat(String.valueOf(line.getPrice()).concat(" "));
                    s = s.concat(String.valueOf(line.getAmount()).concat(" "));
                    s = s.concat(String.valueOf(line.getPrice() * line.getAmount()));

                    System.out.println(s);

                });
            }
        }

        System.out.println("TOTAL AMOUNT:" + getTotalAmount());
        TextInterface.pressKey();
    }

//    @Override
//    public void list() {
//      
//
//    }
    private void printHeader() {

        System.out.printf("%-2s%-10s%-40s%-20s\n", "LINE", "CODE", "DESCRIPTION", "PRICE");

    }

    @Override
    public void update(Node e) {
        Byte i = 1;

        //  e.addItem("", 0, i);
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(Record e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Record search(Node node, StringBuilder outString) {
        return null;

    }

}

/*

 
//ventas de productos e inventarios
public class Ventasproductos {
    static void inventarioyventa(String x){
    String resultado="venta";
    resultado="inventario";
    int opcion=3;
   while (opcion != 0){
     opcion=Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para la venta o 2 para el inventario")); 
        switch(opcion){
           
            case 1:
       
                int a=0;
                int codigo=1; 
            
                while(codigo != -1){
               
                codigo=VentanaProductos.seleccionProducto();
             
           
               
               
              JOptionPane.showMessageDialog(null, "El Valor Total a pagar es:"+ a);
                break;
               
            
              
                JOptionPane.showMessageDialog(null,"hay tomate!"  );
        
break;
    }
       }
   }

    /**
     * @param args the command line arguments
 */
 /*
    public static void main(String[] args) {
        // TODO code application logic here
        String resultado="0";
Ventasproductos.inventarioyventa(resultado);
    }

//    //intervinient
//    //role (clasgetname)
////deprecated
//    private void saveTransaction() { ////         
/////ESTRUCTURA DEL NODO: 0 (REPAIR || SELL)
//// cliCode  empCode  List --> (0)ShoppingCart
/////llamada
//////              List l = null;
//////          ShoppingCart shoppingCart;
//////          l.add(shoppingCart);
//////
//////          node.setList(l);
//////            }
//        ////         
/////ESTRUCTURA DEL NODO: 0 (REPAIR || SELL)
//// cliCode  empCode  List --> (0)ShoppingCart
//
//        Node node = new Node(0, null, "SALES");
//        Node childNode = new Node(0, node, client.getDni());
//        node.addChild(node);
//        childNode = new Node(1, node, client.getDni());
//        node.addChild(node);
//        childNode = new Node(2, node, cashier.getDni());
//        node.addChild(node);
/////llamada
//        List<ShoppingCart> list = new ArrayList<>();
//
//        list.add(shoppingCart);
//
//        //   node.setList(list);
//    }

 */
