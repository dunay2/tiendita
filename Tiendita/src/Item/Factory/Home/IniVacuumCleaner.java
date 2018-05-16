/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item.Factory.Home;


import Item.Family.Home.Hoover;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class IniVacuumCleaner extends Hoover {

    /**
     *
     * @param key
     * @param response
     */
    public IniVacuumCleaner(String key, ArrayList<String> response) {
        
        super(key);
        int i = 0;
        
     
        
        super.setName(response.get(i++));
        super.setBrand(response.get(i++));
        super.setDescription(response.get(i++));
        
        super.setWidth(Integer.valueOf(response.get(i++)));
        super.setHeigth(Integer.valueOf(response.get(i++)));
        super.setDepth(Integer.valueOf(response.get(i++)));
        super.setPower(response.get(i++));
        super.setEnergyCertification(response.get(i++));
        
        super.setGuaranty(response.get(i++));
try {
            super.setBoughtPrice(Double.valueOf(response.get(i++)));

        } catch (NumberFormatException e) {
            super.setBoughtPrice(0);
        }

        try {
            super.setSellPrice(Double.valueOf(response.get(i++)));

        } catch (NumberFormatException e) {
            super.setSellPrice(0);
        }

        try {
            super.setQuantity(Integer.valueOf(response.get(i++)));

        } catch (NumberFormatException e) {
            super.setQuantity(0);
        }
    }
}
