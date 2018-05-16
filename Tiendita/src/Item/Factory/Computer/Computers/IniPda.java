/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item.Factory.Computer.Computers;
import Item.Family.Computers.Pda;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class IniPda extends Pda {

    public IniPda(String code) {
        super(code);
    }

    /**
     *
     * @param key
     * @param response
     */
    public IniPda(String key, ArrayList<String> response) {

        super(key);
        int i = 0;

        super.setName(response.get(i++));
        super.setBrand(response.get(i++));
        super.setDescription(response.get(i++));
        super.setMhz(response.get(i++));
        super.setRam(response.get(i++));
        super.setHddSize(response.get(i++));
        
           super.setAutonomy(response.get(i++));
        super.setInches(response.get(i++));
     
        
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
