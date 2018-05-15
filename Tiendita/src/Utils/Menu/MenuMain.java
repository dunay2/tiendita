/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu;

import Utils.Menu.Stock.Phones.MenuPhone;
import Utils.Menu.Stock.MenuStock;
import java.util.ArrayList;
import Utils.Menu.Stock.Computers.*;
import Utils.Menu.Stock.Computers.Components.*;
import Utils.Menu.Stock.Home.*;
import Utils.Menu.Stock.Image.*;
import Utils.Menu.Stock.Sound.*;
import Utils.Menu.Stock.Phones.*;

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
        entries.add(new MenuStruct("mnuRepair", "Gestión de Reparaciones"));
        entries.add(new MenuStruct("mnuCredit", "Gestión de Créditos"));
        entries.add(new MenuStruct("mnuOffer", "Gestión de Promociones"));
        entries.add(new MenuStruct("mnuExit", "Salir de la aplicación"));

        convertToChildNode(parentMnuName, entries);
        addTransactionMnu();
        addClientMnu();
        addStockMnu();
        addEmployeeMnu();
        addRepairMnu();
        addCreditMnu();
        addOfferMnu();

    }

    /**
     *
     * @return
     */
    private static void addOfferMnu() {

        ArrayList<MenuStruct> entries = new ArrayList();

        MenuOffer.offerEntries("mnuOffer").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuOffer", entries);
        entries.clear();

        MenuOffer.createPromoEntries("mnuCreatePromo").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuListPromoCli", entries);
        entries.clear();

        //Propósito: Listar promo
        //Padre: mnuOffer
        //Menú mnuListPromoCli
        MenuOffer.listPromoCliEntries("mnuListPromoCli").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuListPromoCli", entries);
        entries.clear();

  
        
        MenuOffer.addPromoCliEntries("mnuAddPromoCli").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuAddPromoCli", entries);
        entries.clear();

        MenuOffer.promoSendEntries("mnuPromoSend").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuPromoSend", entries);


       



    }

    /**
     *
     */
    private static void addEmployeeMnu() {
        ArrayList<MenuStruct> entries = new ArrayList();

        MenuEmployee.employeeEntries("mnuEmployee").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuEmployee", entries);
        entries.clear();

        //Propósito: Agregar Employee
        //Padre: mnuEmployee
        //Menú mnuAddEmployee
        MenuEmployee.addEmployeeEntries("mnuAddEmployee").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuAddEmployee", entries);
        entries.clear();

        //Propósito: Editar Employee
        //Padre: mnuEmployee
        //Menú mnuEditEmployee
        MenuEmployee.editEmployeeEntries("mnuEditEmployee").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuEditEmployee", entries);
        entries.clear();

        //Propósito: Deshabilitar clientes
        //Padre: mnuClient
        //Menú mnuDeleteEmployee
        MenuEmployee.deleteEmployeeEntries("mnuDeleteEmployee").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuDeleteEmployee", entries);
        entries.clear();

        //Propósito: Buscar clientes
        //Padre: mnuEmployee
        //Menú mnuSearchEmployee
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

        //Consultar factura
        MenuSale.transactionSearchInvoices("mnuSearchInvoice").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuSearchInvoice", entries);
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

    /**
     *
     */
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

    /**
     *
     *
     *
     */
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

        MenuMobil.addResponseEntries("mnuMobil").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuMobil", entries);
        entries.clear();

        MenuPhone.addResponseEntries("mnuPhone").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuPhone", entries);
        entries.clear();

        MenuPlasma.addResponseEntries("mnuPlasma").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuPlasma", entries);
        entries.clear();

        MenuLed.addResponseEntries("mnuLed").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuLed", entries);
        entries.clear();
        MenuAltavoces.addResponseEntries("mnuAltavoces").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuAltavoces", entries);
        entries.clear();

        MenuAuriculares.addResponseEntries("mnuAuriculares").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuAuriculares", entries);
        entries.clear();

        MenuMinicadena.addResponseEntries("mnuMinicadena").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuMinicadena", entries);
        entries.clear();

        MenuFridge.addResponseEntries("mnuFridge").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuFridge", entries);
        entries.clear();

        MenuDishWasher.addResponseEntries("mnuDishWasher").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuDishWasher", entries);
        entries.clear();

        MenuHoover.addResponseEntries("mnuHoover").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuHoover", entries);
        entries.clear();

        MenuWashingMachine.addResponseEntries("mnuWashingMachine").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuWashingMachine", entries);
        entries.clear();

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

    private static void addRepairMnu() {
        ArrayList<MenuStruct> entries = new ArrayList();

        //menú principal
        MenuRepair.repairEntries("mnuRepair").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuRepair", entries);
        entries.clear();

        //menú abrir parte
        MenuRepair.openParteEntries("mnuOpenPart").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuOpenPart", entries);
        entries.clear();

        //Buscar
        MenuRepair.hndRepairSearchEntries("mnuRepairSearch").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuRepairSearch", entries);
        entries.clear();

//Cambiar el estado de una reparacion
        MenuRepair.hndRepairHndEntries("mnuHndRepairCode").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuHndRepairCode", entries);
        entries.clear();

        MenuRepair.hndRepairStatusEntries("mnuRepChangeStatus").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuRepChangeStatus", entries);
        entries.clear();

        MenuRepair.mnuRepairAddCommentEntries("mnuRepRep").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuRepRep", entries);
        entries.clear();

        MenuRepair.mnuRepairAddCommentEntries("mnuRepPending").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuRepPending", entries);
        entries.clear();

        MenuRepair.mnuRepairAddCommentEntries("mnuRepStop").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuRepStop", entries);
        entries.clear();

        MenuRepair.mnuRepairAddCommentEntries("mnuRepTest").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuRepTest", entries);
        entries.clear();

        MenuRepair.mnuRepairAddCommentEntries("mnuRepFinish").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuRepFinish", entries);
        entries.clear();

        MenuRepair.ChekcInvoiceItemEntries("mnuChekcInvoiceItem").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuChekcInvoiceItem", entries);
        entries.clear();

        MenuRepair.mnuRepairListentries("mnuRepairList").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuRepairList", entries);
        entries.clear();

    }

    private static void addCreditMnu() {
        ArrayList<MenuStruct> entries = new ArrayList();
//Menú principal de la rama
        MenuCredit.financeEntries("mnuCredit").forEach(menu -> entries.add(menu));
        convertToChildNode("mnuCredit", entries);
        entries.clear();
    }

}
