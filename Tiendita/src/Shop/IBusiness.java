package Shop;

public interface IBusiness {
//Abre el comercio
    public void open();
//Cierra el comercio
    public void close();
//Agrega un cliente al sistema
    public void addClient();
//Actualiza la información de un cliente
    public void updateClient();
 //Establece o actualiza el nombre de un negocio
    public void setName(String name);
 //Devuelve el nombre de un negocio
    public String getName();
    
    
}
