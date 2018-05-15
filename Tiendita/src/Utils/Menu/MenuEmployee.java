/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu;

import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class MenuEmployee extends MenuBase {

    //Propósito: Agregar entradas al menú empleados
    //Padre: mnuMain
    //Menú mnuEmployee

    /**
     *
     * @param parentMnuName
     * @return
     */
    static protected ArrayList<MenuStruct> employeeEntries(String parentMnuName) {

        //1. mnuEmployee
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("mnuAddEmployee", "Agregar Empleado"));
        entries.add(new MenuStruct("mnuEditEmployee", "Actualizar Empleado "));
        entries.add(new MenuStruct("mnuDeleteEmployee", "Eliminar Empleado"));
        entries.add(new MenuStruct("mnuListEmployee", "Listar Empleados"));
        entries.add(new MenuStruct("mnuSearchEmployee", "Buscar Empleado"));
        entries.add(new MenuStruct("tail", "Volver al Menú Principal"));

        return entries;
    }
    //Identificar el tipo de empleado a crear para asignarle un rol
    
//Propósito: Agregar entradas al menú agregar empleados
    //Padre: mnuEmployee
    //Menú mnuAddEmployee

    /**
     *
     * @param parentMnuName
     * @return
     */

    static protected ArrayList<MenuStruct> addEmployeeEntries(String parentMnuName) {

        //9. mnuAddEmployee
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca DNI del Empleado"));
        entries.add(new MenuStruct("output", "Introduzca nombre del Empleado"));
        entries.add(new MenuStruct("output", "Introduzca Apellido del Empleado "));
        entries.add(new MenuStruct("output", "Introduzca Domicilio"));
        entries.add(new MenuStruct("output", "Introduzca Teléfono"));
        entries.add(new MenuStruct("output", "Introduzca rol: 1. Vendedor 2. Gestor de clientes 3. BackOfTheHouse 4. RRHH 5. Reparador  6. Financiero 7. Comercial "));





//            employeeManager.add(employee);
//            employee = (Employee) PersonFactory.getPerson(2, "2");
//            employee.setFirstName("Clerk");
//            employeeManager.add(employee);
//
//            employee = (Employee) PersonFactory.getPerson(3, "3");
//            employee.setFirstName("BackOfTheHouse");
//            employeeManager.add(employee);
//
//            employee = (Employee) PersonFactory.getPerson(4, "4");
//            employee.setFirstName("Clerk");
//            employeeManager.add(employee);
//
//            employee = (Employee) PersonFactory.getPerson(5, "5");
//            employee.setFirstName("Engineer");
//            employeeManager.add(employee);
//
//            employee = (Employee) PersonFactory.getPerson(5, "Engineer 1");
//            employee.setFirstName("Engineer");
//            employeeManager.add(employee);
//            employee = (Employee) PersonFactory.getPerson(5, "Engineer 2");
//            employee.setFirstName("Engineer");
//            employeeManager.add(employee);
//
//            employee = (Employee) PersonFactory.getPerson(6, "6");
//            employee.setFirstName("FAssintance");
//            employeeManager.add(employee);
//
//            employee = (Employee) PersonFactory.getPerson(7, "7");
//            employee.setFirstName("SalesMan");
//            employeeManager.add(employee);
//        
        return entries;
    }
//Propósito: Agregar entradas al menú editar empleados
    //Padre: mnuEmployee
    //Menú mnuEditEmployee

    /**
     *
     * @param parentMnuName
     * @return
     */
    static protected ArrayList<MenuStruct> editEmployeeEntries(String parentMnuName) {
//Input Menu
        //10. mnuEditEmployee    
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca DNI del Empleado"));
        entries.add(new MenuStruct("output", "Introduzca nombre del Empleado"));
        entries.add(new MenuStruct("output", "Introduzca Apellido del Empleado "));
        entries.add(new MenuStruct("output", "Introduzca Direccion"));
        entries.add(new MenuStruct("output", "Telefono"));
        entries.add(new MenuStruct("tail", "Volver al Menú Principal"));

        return entries;

    }
    //Propósito: Agregar entradas al menú borrar empleados
    //Padre: mnuEmployee
    //Menú mnuDeleteEmployee

    /**
     *
     * @param parentMnuName
     * @return
     */
    static protected ArrayList<MenuStruct> deleteEmployeeEntries(String parentMnuName) {

        //3. mnuDeleteEmployee  
        ArrayList<MenuStruct> entries = new ArrayList();

        entries.add(new MenuStruct("output", "Introduzca DNI del Empleado"));

        return entries;
    }

    //Propósito: Agregar menú búsqueda de empleado

    /**
     *
     * @param parentMnuName
     * @return
     */
    static protected ArrayList<MenuStruct> searchEmployeeEntries(String parentMnuName) {
        ArrayList<MenuStruct> entries = new ArrayList();
        //4. mnuSearchEmployee    
        entries.add(new MenuStruct("output", "Introduzca DNI del Empleado"));

        return entries;
    }
}