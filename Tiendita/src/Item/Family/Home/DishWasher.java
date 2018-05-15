/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item.Family.Home;

import Item.Electrodomestic;

/**
 *
 * @author ashh412
 */
public class DishWasher extends  Electrodomestic{
    
    public DishWasher(String code) {
        super(code);
    }
    
private String waterConsume;

    public String getWaterConsume() {
        return waterConsume;
    }

    public void setWaterConsume(String waterConsume) {
        this.waterConsume = waterConsume;
    }

    
}
