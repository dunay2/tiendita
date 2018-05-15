/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.Factory.Home;

import Item.Family.Home.Fridge;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class IniFridge extends Fridge {

    /**
     *
     * @param key
     * @param response
     */
    public IniFridge(String key, ArrayList<String> response) {

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
        
        super.setMaxCapacity(response.get(i++));
        super.setFreezermaxCapacity(response.get(i++));
        super.setDrowers(response.get(i++));

        super.setGuaranty(response.get(i++));
        super.setBoughtPrice(Double.valueOf(response.get(i++)));
        super.setSellPrice(Double.valueOf(response.get(i++)));
        super.setQuantity(Integer.valueOf(response.get(i++)));
    }
}
