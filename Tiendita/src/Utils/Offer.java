package Utils;

import Person.Client.Client;
import Person.Comunications.ICommunication;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author ashh412
 */
public class Offer implements ICommunication, Serializable {

    private final String offerId;
    private final String offerDesc;
    private final HashMap<String, Client> hmClients;
    private Date sendDate;

    /**
     *
     * @param clientId
     * @param client
     */
    @Override
    public void addClient(String clientId, Client client) {

        hmClients.put(clientId, client);
    }

    public Offer(String offerId, String offerDesc) {
        this.hmClients = new HashMap();

        this.offerId = offerId;
        this.offerDesc = offerDesc;

    }

    /**
     *
     * @return
     */
    @Override
    public String getOfferId() {
        return offerId;
    }

    /**
     *
     * @return
     */
    @Override
    public String getOfferDesc() {
        return offerDesc;
    }

    /**
     *
     * @return
     */
    @Override
    public HashMap getHmClients() {
        return hmClients;
    }

    /**
     * Propósito: Enviar correo
     */
    @Override
    public void sendMail() {

        hmClients.forEach((String code, Client client) -> {
            sendMail(client);
        });

        Calendar rightNow = Calendar.getInstance();

        sendDate = rightNow.getTime();
    }

    /**
     *
     * @param clientRecord
     */
    private void sendMail(Client client) {

        //Comprobamos las condiciones de envío
        if (checkSendMailConditions(client.getSendDate())) {
            System.out.println("Correo enviado a " + client.getEmail());

            System.out.println("Estimado/a Señor/a " + client.getLastName() + " " + offerDesc);

            //Guardamos la fecha de envío
            Calendar rightNow = Calendar.getInstance();
            client.setSendDate(rightNow.getTime());

        } else {
            System.out.println("El cliente " + client.getFirstName() + " ya ha recibido la promocion");
        }

    }

    /**
     *
     * Propósito: Comprobar las condiciones de envío de un correo
     *
     * @param cr ClientRecord
     * @return boolean: Verdadero si se puede realizar la operación Rules: la
     * diferencia entre la fecha del primer envio y el nuevo debe ser superior a
     * 1 año
     */
    private boolean checkSendMailConditions(Date date) {

        if (date == null) {
            return true;
        }
        Calendar rightNow = Calendar.getInstance();

        Date fechaFinal = rightNow.getTime();

        Date fechaInicial = date;

        //supera 1 año
        return (((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000) > 365);

    }

    public Date getSendDate() {
        return sendDate;
    }

    public void printClients() {

        hmClients.forEach((code, clientRecord) -> System.out.println("Código: " + code + " Descripción: " + clientRecord.getFirstName()));

    }

}
