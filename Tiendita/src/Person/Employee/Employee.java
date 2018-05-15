package Person.Employee;

import Person.Person;
import Utils.Record.Record;
import java.util.List;

/**
 *
 * @author ashh412
 * 
 * Generico empleado
 */
public abstract class Employee extends Person {

    /**
     * 
     */
    private static final long serialVersionUID = -2873344211410398459L;
    private int rol;

    public int getRol() {
        return rol;
    }



    /**
     *
     * @param dni
     */
    public Employee(String dni) {
        super(dni);
    }

    /**
     *
     * @param dni
     * @param firstName
     * @param lastName
     * @param address
     * @param phone
     * @param rol
     */
    public Employee(String dni, String firstName, String lastName, String address, String phone, int rol) {
        super(dni, firstName, lastName, address, phone);
        this.rol = rol;

    }

    /**
     *
     */
    public void pagarNomina() {
    }
    
      @Override
    public List<Record> getOperations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOperation(Record e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}