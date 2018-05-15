/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

 
import ScreenInterfaces.TextInterface;
import Utils.Menu.MenuNode;
import Item.Electrodomestic;
import Item.Factory.ItemFactory;
import Samples.AddTest;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashh412 Propósito: hacer de gestor clase Items. Extiende la clase
 * TextDatabase mediante emplatemanager lo que le da persistencia
 *
 */
public class StockManager extends TemplateManager {

    Electrodomestic item = null;
    private HashMap<String, Electrodomestic> electrodomestics = new HashMap<>();

    private static StockManager instance = null;    //Singleton Singleton Pattern

    //Singleton Singleton Pattern
    /**
     *
     */
    protected StockManager() {
        // Exists only to defeat instantiation.
    }
    //Singleton Singleton Pattern

    /**
     *
     * @return
     */
    public static StockManager getInstance() {
        if (instance == null) {
            instance = new StockManager();
        }
        return instance;
    }

    /**
     *
     * @param itemCode
     * @param amount
     */
    public void buyItems(String itemCode, int amount) {

    }

//Devuelve todo el listado de Electrodomestic
    @Override
    public HashMap<String, Electrodomestic> getAll() {

        return electrodomestics;

    }

    //Propósito: Cargar el HM con el stock
    /**
     *
     */
    public void load() {

        electrodomestics = super.load("Electrodomestic");

    }

    @Override
    public boolean handleProcess(MenuNode[] enode) {
        MenuNode node = enode[0];

        switch (node.getValue()) {

            case 3121://Lavaplatos
            case 3122://Neveras
            case 3123://Aspiraadoras
            case 3124://Lavadoras

            case 3131://Móviles
            case 3132://Fijos

            case 3141://Plasma
            case 3142://Led

            case 3151://Altavoces
            case 3152://Auriculares
            case 3153://Minicadenas

            case 31121://  1. PDA'S
            case 31122:// 2. Portatiles
            case 31123:// 3. Sobremesa
            case 31124:// 4. NoteBooks

            case 31111:// 1. Teclados
            case 31112://2. Memorias
            case 31113://3. Ratones
            case 31114: //4. Impresoras
            case 31115: //5. Procesadores

                createObject(enode);
                return true;

          
            //32. Modificar Item Stock
            case 32:
                update(node);
                return true;
            //33. Eliminar Item Stock
            case 33:
                return true; //no implementado
            //34. Listar eletrodomésticos
            case 34:
                list();
                return true;
            //Agregar items de prueba
            case 35:
                AddTest.addTestComponents();

                return true;
            case 36://Buscar producto

                StringBuilder outString = new StringBuilder();
                Electrodomestic electrodomestic = (Electrodomestic) search(node, outString);
                print(electrodomestic);
                return true;

        }
        return false;//Seguimos profundizando
    }

    ///////////////////////////////////////////////////
    //Propósito: crear un nuevo electrodoméstico con los datos de entrada de consola
    @Override
    public Electrodomestic createObject(MenuNode[] enode) {

        String key;//Referencia de item
        MenuNode node = enode[0];
        ArrayList<String> listResponseData; //Array con el valor de los atributos de los objetos

        //Obtenemos referencia al primer nodo hijo para comprobar si existen datos
        //comprobacion de respuesta
        MenuNode childNode = node.getChildNodes().get(0);
        //Convertimos los nodos en parametros

//creacion estandar
//No hay datos en los nodos hijos
        if (childNode.getResponseValue() == null) {
            StringBuilder outString = new StringBuilder();
            //Comprobamos que el identificador de item no exista
            Electrodomestic e = (Electrodomestic) search(node, outString);
            //No existe, guardamos la clave para realizar la creacion del nuevo objeto
            if (e == null) {
                key = outString.toString();
            } else {//Hemos encontrado coincidencias
                childNode.clearResponse();
                System.out.println("El registro ya existe");
                TextInterface.pressKey();
                return null;
            }
        } //Creación por búsqueda, ya hemos obtenido el identificador
        else {
            key = childNode.getResponseValue();
        }

        //Convertimos los nodos en una lista
        listResponseData = node.convertTreeChildToListIdx();

        childNode.clearResponse();

        int ElectroType = node.getValue();
//Llamamos a la factoría para que nos devuelva el tipo correcto de objeto
        item = getItem(ElectroType, key, listResponseData);

        add(item);
        //Guardar los datos 

        save(electrodomestics);

        return item;
    }

    
    
    private Electrodomestic getItem(int ElectroType, String key, ArrayList<String> responseValues) {

        try {
            return ItemFactory.getElectrodomestic(ElectroType, key, responseValues);
        } catch (Exception ex) {
            Logger.getLogger(StockManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Cree el objeto");
        }
        return null;

    }

    //Propósito: 
    //Buscar la clave en el HashMapy devolver el objeto si existe
    @Override
    public Electrodomestic search(MenuNode node, StringBuilder outString) {

        outString.append(node.getChildNodes().get(0).getResponse());

        Electrodomestic electrodomestic = searchElectrodomestic(outString.toString());
        if (electrodomestic != null) {

            return electrodomestic;

        }
        return null;
    }

    @Override
    public void print(Electrodomestic e) {

        if (e == null) {
            System.out.println("el electrodoméstico no existe");
            TextInterface.pressKey();
            return;
        }

        printHeader();
        listFormat(e);
    }

    private void printHeader() {
        System.out.printf("%-20s%-20s%-40s%-20s%-20s%-20s\n", "CODIGO", "NOMBRE", "DESCRIPCION", "PRECIO COMPRA", "PRECIO VENTA", "UNIDADES");
    }

    /**
     *
     * @param e
     * @return
     */
    public Electrodomestic searchElectrodomestic(String e) {
        if (electrodomestics.containsKey(e)) {
            //Si encontramos el elemento en la búsqueda devolvemos el elemento
            return electrodomestics.get(e);
        }
        return null;
    }

    @Override
    public void delete(Electrodomestic e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Electrodomestic item) {

        if (electrodomestics.containsKey(item.getCode())) {
            System.out.println("No se puede introducir el electrodomestico. El código esta repetido.");
            return false;
        }

        try {
            //Agregamos una electrodoméstico al hasmap
            electrodomestics.put(item.getCode(), item);
            return true;

        } catch (Exception e) {
            System.out.println("No se puede introducir el electrodoméstico. Ha habido un error.");
            return false;
        }

    }

    @Override
    public Object get(int rollNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* Display content using Iterator*/
//        Set set = hmap.entrySet();
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry mentry = (Map.Entry) iterator.next();
//            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
//            System.out.println(mentry.getValue());
//        }
//
//        /* Get values based on key*/
//        String var = hmap.get(2);
//        System.out.println("Value at index 2 is: " + var);
//
//        /* Remove values based on key*/
//        hmap.remove(3);
//        System.out.println("Map key and values after removal:");
//        Set set2 = hmap.entrySet();
//        Iterator iterator2 = set2.iterator();
//        while (iterator2.hasNext()) {
//            Map.Entry mentry2 = (Map.Entry) iterator2.next();
//            System.out.print("Key is: " + mentry2.getKey() + " & Value is: ");
//            System.out.println(mentry2.getValue());
//        }
    // }
    //propósito: leer los datos introducidos por consola
    @Override
    public void update(MenuNode node) {
        StringBuilder outString = new StringBuilder();
        Electrodomestic electrodomestic = search(node, outString);
        Boolean hasChange = false;

        if (electrodomestic != null) {
            ArrayList<String> nodesData = node.convertTreeChildToListIdx();
            int i = 0;
//electrodomestic
            String auxStr = nodesData.get(i);
            if (!nodesData.get(i++).isEmpty()) {
                electrodomestic.setName(auxStr);
                hasChange = true;
            }
            auxStr = nodesData.get(i);
            if (!nodesData.get(i++).isEmpty()) {
                electrodomestic.setDescription(auxStr);
                hasChange = true;
            }
            auxStr = nodesData.get(i);
            if (!nodesData.get(i++).isEmpty()) {
                electrodomestic.setBoughtPrice(Double.valueOf(auxStr));
                hasChange = true;
            }
            auxStr = nodesData.get(i);
            if (!nodesData.get(i++).isEmpty()) {
                electrodomestic.setSellPrice(Double.valueOf(auxStr));
                hasChange = true;
            }
            auxStr = nodesData.get(i);
            if (!nodesData.get(i++).isEmpty()) {
                electrodomestic.setQuantity(parseInt(auxStr));
                hasChange = true;

            }

        } else {
            System.out.println("El electrodoméstico no existe");
            TextInterface.pressKey();
        }

        if (hasChange == true) {
            save(electrodomestics);
        }
    }

    /**
     *
     */
    public void refresh() {
        save(electrodomestics);
    }

    //Propósito: Listar los Electrodomestic por consola
    @Override
    public void list() {

        Iterator<Map.Entry<String, Electrodomestic>> it = electrodomestics.entrySet().iterator();
        printHeader();

        while (it.hasNext()) {

            listFormat(it.next().getValue());
        }
        TextInterface.pressKey();
    }

    private void listFormat(Electrodomestic item) {

        System.out.printf("%-20s%-20s%-40s%-20s%-20s%-20s%n", item.getCode(), item.getName(), item.getDescription(), item.getBoughtPrice(), item.getSellPrice(), item.getQuantity());

    }

}