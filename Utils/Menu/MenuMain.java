/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu;

import Utils.Menu.Stock.MenuStock;
import java.util.ArrayList;
import Utils.Menu.Stock.Computers.*;
import Utils.Menu.Stock.Computers.Components.*;

/**
 *
 * @author ashh412
 */
public class MenuMain extends MenuBase {

    static private MenuNode rootNode;

    //Propósito: Agregar entradas al menú principal
    //Padre: null
    //Menú mnuMain
    static public MenuNode getRootNode() {

        if (rootNode == null) {
            rootNode = new MenuNode(null, 0, "rootMenu", "", null);
            mainMenuEntries("rootMenu");

        }
        return rootNode;

    }

    static protected void mainMenuEntries(String parentMnuName) {

        ArrayList<MenuStruct> entries = new ArrayList();

//Creamos el nodo raíz mnuMain
        //Menu principal
        entries.add(new MenuStruct("mnuTransaction", "Gestión de Ventas"));
        entries.add(new MenuStruct("mnuClient", "Gestión de Clientes"));
        entries.add(new MenuStruct("mnuStock", "Gestión de Stock"));
        entries.add(new MenuStruct("mnuEmployee", "Gestión de Empleados"));
        entries.add(new MenuStruct("mnuEmployee", "Gestión de Reparaciones"));
        entries.add(new MenuStruct("mnuExit", "Salir de la aplicación"));

        convertToChildNode(parentMnuName, entries);
        addTransactionMnu();
        addClientMnu();
        addStockMnu();
        addEmployeeMnu();
    }

    private static void addEmployeeMnu() {
        ArrayList<MenuStruct> entries = new ArrayList();

        MenuEmployee.employeeEntries("mnuEmployee").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuEmployee", entries);
        entries.clear();

        //Propósito: Agregar clientes
        //Padre: mnuClient
        //Menú mnuAddClient
        MenuEmployee.addEmployeeEntries("mnuAddEmployee").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuAddEmployee", entries);
        entries.clear();

        //Propósito: Editar clientes
        //Padre: mnuClient
        //Menú mnuEditClient
        MenuEmployee.editEmployeeEntries("mnuEditEmployee").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuEditEmployee", entries);
        entries.clear();

        //Propósito: Deshabilitar clientes
        //Padre: mnuClient
        //Menú mnuDeleteClient
        MenuEmployee.editEmployeeEntries("mnuDeleteEmployee").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuDeleteEmployee", entries);
        entries.clear();

        //Propósito: Buscar clientes
        //Padre: mnuClient
        //Menú mnuSearchClient
        MenuEmployee.searchEmployeeEntries("mnuSearchEmployee").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuSearchEmployee", entries);
        entries.clear();
    }

    private static void addTransactionMnu() {
        ArrayList<MenuStruct> entries = new ArrayList();

        //menú principal
        MenuSale.transactionEntries("mnuTransaction").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuTransaction", entries);
        entries.clear();

        //menú vender
        MenuSale.transactionSaleEntries("mnuSell").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuSell", entries);
        entries.clear();

        //Devolver
        MenuSale.transactionCancelEntries("mnuReturnItem").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuReturnItem", entries);
        entries.clear();

        //Agregar items al carrito
        MenuSale.addItemToCartEntries("mnuAddItemToCart").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuAddItemToCart", entries);
        entries.clear();

        //Obtener id cliente
        MenuSale.getClientIdEntries("mnuBuying").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuBuying", entries);
        entries.clear();

        MenuSale.paymentTypeEntries("mnuBuyGetClientId").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuBuyGetClientId", entries);
        entries.clear();

    }

    private static void addClientMnu() {
        ArrayList<MenuStruct> entries = new ArrayList();

        MenuClient.clientEntries("mnuClient").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuClient", entries);
        entries.clear();

        //Propósito: Agregar clientes
        //Padre: mnuClient
        //Menú mnuAddClient
        MenuClient.addClientEntries("mnuAddClient").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuAddClient", entries);
        entries.clear();

        //Propósito: Editar clientes
        //Padre: mnuClient
        //Menú mnuEditClient
        MenuClient.editClientEntries("mnuEditClient").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuEditClient", entries);
        entries.clear();

        //Propósito: Deshabilitar clientes
        //Padre: mnuClient
        //Menú mnuDeleteClient
        MenuClient.deleteClientEntries("mnuDeleteClient").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuDeleteClient", entries);
        entries.clear();
        //Propósito: Buscar clientes
        //Padre: mnuClient
        //Menú mnuSearchClient

        MenuClient.searchClientEntries("mnuSearchClient").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuSearchClient", entries);
        entries.clear();

    }

    private static void addStockMnu() {
        ArrayList<MenuStruct> entries = new ArrayList();
//Menú principal de la rama
        MenuStock.stockEntries("mnuStock").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuStock", entries);
        entries.clear();

        //Propósito: Agregar 
        //Padre: mnuStock
        //Menú mnuAddItem
        MenuStock.addItemEntries("mnuAddItem").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuAddItem", entries);
        entries.clear();

        //Propósito: Editar 
        //Padre: mnuStock
        //Menú mnuEditItem
        MenuStock.editItemEntries("mnuEditItem").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuEditItem", entries);
        entries.clear();

        //Propósito: Deshabilitar 
        //Padre: mnuStock
        //Menú mnuDeleteItem
        MenuStock.deleteItemEntries("mnuDeleteItem").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuDeleteItem", entries);
        entries.clear();

        //Propósito: Buscar 
        //Padre: mnuItem
        //Menú searchItem
        MenuStock.searchItemEntries("mnuSearchItem").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuSearchItem", entries);
        entries.clear();

        //Propósito: Menú genérico ordenadores 
        //Padre: mnuAddItem
        //Menú mnuComputerSection
        MenuStock.computerSectionEntries("mnuGenComputers").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuGenComputers", entries);
        entries.clear();

        //Propósito: Menú Componentes 
        //Padre: mnuGenComputers
        //Menú mnuComponents
        MenuStock.addComputerComponentEntries("mnuComponents").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuComponents", entries);
        entries.clear();

        MenuKeyboard.addResponseEntries("mnuKeyboard").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuKeyboard", entries);
        entries.clear();

        MenuMouse.addResponseEntries("mnuMouse").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuMouse", entries);
        entries.clear();

        MenuProcesor.addResponseEntries("mnuProcesor").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuProcesor", entries);
        entries.clear();
        
        MenuMemory.addResponseEntries("mnuMemory").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuMemory", entries);
        entries.clear();
        
        MenuPrinter.addResponseEntries("mnuPrinter").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuPrinter", entries);
        entries.clear();
        
//Fin componentes

        //Propósito: Menú Equipos 
        //Padre: mnuGenComputers
        //Menú mnuComputers
        MenuStock.addComputerTypeEntries("mnuComputers").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuComputers", entries);
        entries.clear();

        MenuPda.addResponseEntries("mnuPda").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuPda", entries);
        entries.clear();

        MenuLabtop.addResponseEntries("mnuLabtop").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuLabtop", entries);
        entries.clear();

        MenuDesktop.addResponseEntries("mnuDesktop").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuDesktop", entries);
        entries.clear();

        MenuNoteBook.addResponseEntries("mnuNoteBook").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuNoteBook", entries);
        entries.clear();

//       
//
        //Propósito: Menú Equipos 
        //Padre: mnuGenComputers
        //Menú mnuComponents
        MenuStock.addComputerTypeEntries("mnuComputers").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuComputers", entries);
        entries.clear();

        //Propósito: Menú genérico Hogar 
        //Padre: mnuAddItem
        //Menú mnuHome
        MenuStock.addHomeEntries("mnuHome").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuHome", entries);
        entries.clear();

        //Propósito: Menú genérico telefonía 
        //Padre: mnuAddItem
        //Menú mnuGenPhone
        MenuStock.addPhoneEntries("mnuGenPhone").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuGenPhone", entries);
        entries.clear();

        //Propósito: Menú genérico telefonía 
        //Padre: mnuAddItem
        //Menú mnuGenPhone
        MenuStock.addImageEntries("mnuImage").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuImage", entries);
        entries.clear();

        //Propósito: Menú genérico telefonía 
        //Padre: mnuAddItem
        //Menú mnuGenPhone
        MenuStock.addSoundEntries("mnuSound").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuSound", entries);
        entries.clear();

//         MenuStock.addFridgeEntries("mnuFamily").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//        convertToChildNode("mnuFamily", entries);
//        entries.clear();
//        
//          MenuStock.addFridgeEntries("addCommonItemEntries").forEach((menuStruct) -> {
//            entries.add(menuStruct);
//        });
//        convertToChildNode("addCommonItemEntries", entries);
//        entries.clear();
    }

    //Propósito: Agregar entradas al menú cancelar venta
    //Padre: mnuMain
    //Menú input menu
    static protected void cancelTransactionEntries(String parentMnuName) {
        //21. mnuCancelTransaction  

//Input menu
        ArrayList<MenuStruct> entries = new ArrayList();
        entries.add(new MenuStruct("", "Introduzca el código de la factura a cancelar"));

        convertToChildNode(parentMnuName, entries);

    }
}
