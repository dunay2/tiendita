/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu.Stock.Computers;

import Utils.Menu.Stock.MenuAddItemCommonEntriesHeader;
import Utils.Menu.MenuStruct;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuComputer {

    // addCommonItemEntries
    //Input menu
    public static ArrayList<MenuStruct> addResponseEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = MenuAddItemCommonEntriesHeader.addResponseEntries("");
        entries.add(new MenuStruct("output", "Introduzca MHz procesador del artículo"));
        entries.add(new MenuStruct("output", "Introduzca cantidad RAM del artículo"));
        entries.add(new MenuStruct("output", "Introduzca tamaño del disco"));
     


        return entries;
    }

}
