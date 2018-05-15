package Managers;

import DataBase.TextDatabase;
import Person.Client.Client;
import Person.Employee.SalesMan;
import ScreenInterfaces.TextInterface;
import Utils.Menu.MenuNode;
import Utils.Offer;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ashh412
 */
public class OfferManager extends TextDatabase {

    private HashMap<String, Offer> offers;

    private static OfferManager instance = null;    //Singleton  Pattern

    private SalesMan salesMan;
    private final ClientManager clientManager;

    /**
     * Singleton Singleton Pattern
     *
     *
     * @param clientManager
     */
    protected OfferManager(ClientManager clientManager) {
        this.offers = new HashMap();
        this.clientManager = clientManager;
    }

    public static OfferManager getInstance(ClientManager clientManager) {
        if (instance == null) {
            instance = new OfferManager(clientManager);
        }
        return instance;
    }

    public boolean handleProcess(MenuNode[] enode) {
        MenuNode node = enode[0];
        Offer offer;
        StringBuilder outString = new StringBuilder();

        switch (node.getValue()) {
            case 71:    //Crear una promocion 

                if (createObject(enode) != null) {
                    return true;
                }
                return true;

            case 72: //  Listar las promociones
                list();
                TextInterface.pressKey();
                return true;

            case 73: // Listar los clientes de una promocion

                listClient(enode);
                TextInterface.pressKey();
                return true;

            case 74://Agregrar cliente a promocion

                addClientToPromo(enode);

                TextInterface.pressKey();
                return true;

            case 75: // Enviar correo a listado"));
                //codigo promo
                //Obtenerla del hm y enviar

                sendMail(enode);

                TextInterface.pressKey();
                return true;

            case 76: //Volver al Menú Principal
                return false;

        }
        return false;
    }

    public void list() {

        offers.forEach((code, offer) -> System.out.println("Código: " + code + " Descripción: " + offer.getOfferDesc()));

    }

    public boolean add(Offer e) {
        offers.put(e.getOfferId(), e);
        return true;
    }

    public Offer search(MenuNode e, StringBuilder outString) {

        searchOffer("");
        return null;
    }

    //Crear promoción
    public Offer createObject(MenuNode[] enode) {
        MenuNode node = enode[0];
        //Introduzca un identificador para la promocion
        //introduzca el texto de la promocion
        ArrayList<String> nodesData = node.convertTreeChildToListIdxFrom(0);

        Offer offer = new Offer(nodesData.get(0), nodesData.get(1));

        offers.put(offer.getOfferId(), offer);

        save(offers);
        return offer;
    }

    /**
     * Propósito: Buscar la clave en el HashMap y devolver el objeto si existe
     *
     *
     * @param e
     * @return
     */
    public Offer searchOffer(String e) {

        if (offers.containsKey(e)) {
            //Si encontramos el elemento en la búsqueda devolvemos el elemento
            return offers.get(e);
        }
        return null;

    }

    public SalesMan getSalesMan() {
        return salesMan;
    }

    /**
     * Lista los clientes de una promo
     *
     * @param PromoCode
     */
    public void listClient(String PromoCode) {

        Offer offer = searchOffer(PromoCode);
        if (offer != null) {
            offer.printClients();
        }

    }

    /**
     * Busca a partir de la información capturada en un nodo
     *
     * @param enode
     */
    private void listClient(MenuNode[] enode) {
        MenuNode node = enode[0];
        ArrayList<String> nodesData = node.convertTreeChildToListIdxFrom(0);

        listClient(nodesData.get(0));
    }

    /**
     *
     *
     * Establece el operador de la operación
     *
     * @param salesMan
     */
    public void setSalesMan(SalesMan salesMan) {
        this.salesMan = salesMan;
    }

    /**
     * Carga la coleccion
     */
    public void load() {
        offers = super.load("Offer");

    }

    /**
     * Privado. Agrega cliente a promo a partir de nodo
     *
     *
     */
    private void addClientToPromo(MenuNode[] enode) {
        MenuNode node = enode[0];

        ArrayList<String> nodesData = node.convertTreeChildToListIdxFrom(0);

        addClientToPromo(nodesData.get(0), nodesData.get(1));

    }

    /**
     * Publico. Agrega cliente a promo a partir String
     *
     *
     * @param codPromo
     * @param clientId
     * @return boolean
     */
    public boolean addClientToPromo(String codPromo, String clientId) {
        Offer offer = offers.get(codPromo);
        if (offer == null) {
            System.out.println("La promoción no existe");
            return false;

        }

        Client client = (Client) clientManager.searchPerson(clientId);
        if (client == null) {
            System.out.println("El cliente no existe");
            return false;
        }

        offer.addClient(client.getDni(), client);
        save(offers);
        System.out.println("Cliente agregado");
        return true;
    }

    private boolean sendMail(String operCode) {
        Offer offer = searchOffer(operCode);
        if (offer != null) {
            offer.sendMail();

            save(offers);

            return true;
        }
        System.out.println("La promoción no existe");
        return false;

    }

    public void sendMail(MenuNode[] enode) {

        MenuNode node = enode[0];

        ArrayList<String> nodesData = node.convertTreeChildToListIdxFrom(0);
        sendMail(nodesData.get(0));

    }

}
