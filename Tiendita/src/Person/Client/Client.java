package Person.Client;

import Person.Person;
import java.util.Date;

/**
 * Un cliente
 *
 * @author ashh412
 */
public class Client extends Person {

    private static final long serialVersionUID = -2873344211410398459L;

    /**
     * Constructor
     *
     * @param dni
     * @param firstName
     * @param lastName
     * @param address
     * @param email
     */
    public Client(String dni, String firstName, String lastName, String address, String email) {
        super(dni, firstName, lastName, address, email);
    }

    private Date sendDate;//Fecha de comunicación
    //Contructor básico

    public Client(String dni) {
        super(dni);
    }

    public Date getSendDate() {
        return this.sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

}
