/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item.Factory.Sound;

import Item.Components.Sound;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;
/**
 *
 * @author ashh412
 */
public class IniAuriculares extends Sound {
    private static final long serialVersionUID = -2873344211410398459L;
   /** Define la inicialización de un objeto de tipo
     *
     * @param key
     * @param response
     */
    public IniAuriculares(String key, ArrayList<String> response) {

        super(key);
        int i = 0;

        

        super.setName(response.get(i++));
        super.setBrand(response.get(i++));
        super.setDescription(response.get(i++));
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