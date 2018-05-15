/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item.Factory.Computer.Components;
 
import  Item.Family.Computers.Components.Memory;

import java.util.ArrayList;

/**
 * 
 * @author ashh412
 */
public class IniMemory extends Memory {

    /**
     *
     * @param key
     * @param response
     */
    public IniMemory(String key, ArrayList<String> response) {

        super(key);
        int i = 0;
 
        super.setName(response.get(i++));
        super.setBrand(response.get(i++));
        super.setDescription(response.get(i++));
        super.setCapacity(response.get(i++));
        super.setGuaranty(response.get(i++));
        super.setBoughtPrice(Double.valueOf(response.get(i++)));
        super.setSellPrice(Double.valueOf(response.get(i++)));
        super.setQuantity(Integer.valueOf(response.get(i++)));
    }

}