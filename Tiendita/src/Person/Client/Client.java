package Person.Client;

import Person.Person;

public class Client extends Person {

    private static final long serialVersionUID = -2873344211410398459L;

    public Client(String dni, String firstName, String lastName ,String address, String email) {
        super(dni, firstName, lastName, address, email );
    }

    //Contructor básico
    public Client(String dni) {
        super(dni);
    }

}