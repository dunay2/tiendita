package Shop;


/*Scanner*/

/**
 *
 * @author ashh412
 */

public abstract class Shop implements IBusiness {

    private String name;

    private String fiscalID;
//Mantenemos un ArrayList de departamentos

    /**
     *
     * @return
     */
    public String getFiscalID() {
        return fiscalID;
    }

    /**
     *
     * @param fiscalID
     */
    public void setFiscalID(String fiscalID) {
        this.fiscalID = fiscalID;
    }



 
//
//    private Store store;
//
//    private Store commonStore;

    @Override
    public void open() {
    }

    @Override
    public void close() {
    }

    @Override
    public void addClient() {
    }


    @Override
    public void updateClient() {
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}