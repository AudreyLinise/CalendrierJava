/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author Audrey
 */
public class ModuleTest {
    /**
     * Test : "Les modules ont une couleur, un nom et une abbréviation distinct des autres"
     */
    @Test
    public void UniciteTest(){
        Module.init();
        boolean isCouleur = false;
        boolean isNom = false;
        boolean isAbbreviation = false;
        List<Module> modules = new ArrayList<>(Module.moduleList.values());
        
        for(int i=0; i<modules.size(); i++){
      
            for(int j=i+1; j<modules.size(); j++){
                isNom |= modules.get(i).getNomModule().equals(modules.get(j).getNomModule());
                isCouleur |= modules.get(i).getCouleurModule().equals(modules.get(j).getCouleurModule());
                isAbbreviation |= modules.get(i).getAbbModule().equals(modules.get(j).getAbbModule());
            }
        }
        assertFalse(isNom);
        assertFalse(isCouleur);
        assertFalse(isAbbreviation);
        
    }
}
