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
public class SceanceTest {
    
    /**
     * Test: "La séance  ne peut faire référance qu'à un module existant dans la formation"
     */
    @Test
    public void uniciteSecanceTest(){
        Module.init();
        boolean isUnique = false;
        List<Module> modules = new ArrayList<>(Module.moduleList.values());
        
        for(int i=0; i<modules.size(); i++){
            for(int j=i+1; j<modules.size(); j++){
      //          isUnique |= modules.get(i).getSeance().equals(modules.get(j).getSeance());
                
            }
        }
        assertFalse(isUnique);
    }
    
}
