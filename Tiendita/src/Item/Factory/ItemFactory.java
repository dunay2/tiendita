/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item.Factory;

import Item.Electrodomestic;
import Item.Factory.Computer.Components.*;
import Item.Factory.Computer.Computers.*;
import Item.Factory.Home.*;
import Item.Factory.Image.*;
import Item.Factory.Phones.*;
import Item.Factory.Sound.*;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class ItemFactory {
//1. Vendedor 2. Tecnico 3. Financiero"));

    /**
     * Clase que representa la factura de items
     * @param ElectroType
     * @param key
     * @param responseValues
     * @return
     * @throws Exception
     */

    public static Electrodomestic getElectrodomestic(int ElectroType, String key, ArrayList<String> responseValues) throws Exception {

        switch (ElectroType) {

////////////////COMPUTER COMPONENTS
            case 31111:
                return new IniKeyboard(key, responseValues);
            case 31112:
                return new IniMemory(key, responseValues);

            case 31113:
                return new IniMouse(key, responseValues);
            case 31114:
                return new IniPrinter(key, responseValues);

            case 31115:
                return new IniProcesor(key, responseValues);
            case 31121:
                return new IniPda(key, responseValues);
            case 31122:
                return new IniLabtop(key, responseValues);
            case 31123:
                return new IniDesktop(key, responseValues);
            case 31124:
                return new IniNoteBook(key, responseValues);

//Fin ordenadores
            //////HOGAR
            case 3121:
                return new IniDishWasher(key, responseValues);

            case 3122:
                return new IniFridge(key, responseValues);
            case 3123:
                return new IniHoover(key, responseValues);
            case 3124:
                return new IniWashingMachine(key, responseValues);

            case 3131://Móviles
                return new IniMobil(key, responseValues);
            case 3132://Fijos
                return new IniPhone(key, responseValues);

            case 3141://Plasma
                return new IniPlasma(key, responseValues);
            case 3142://Led
                return new IniLed(key, responseValues);
            case 3151://Altavoces
                return new IniAltavoces(key, responseValues);
            case 3152://Auriculares
                return new IniAuriculares(key, responseValues);
            case 3153://Minicadena
                return new IniMinicadena(key, responseValues);

            default:
//Ha habido un error de programación, falta agregar elemento
                throw new Exception("El elemento no se encuentra en la factoria--> public class ItemFactory");

        }

    }

}