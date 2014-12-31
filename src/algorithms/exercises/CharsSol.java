/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.exercises;

/**
 *
 * @author anton
 */
public class CharsSol extends ABaseSolClass {
    
    public static boolean allUniqueChars(String str){
        //For lower case only a - z
        int vals = 0;
        
        for(int i = 0; i < str.length(); i++){
            int asci = str.charAt(i) - 'a';
            asci = 1 << asci;
            if( (vals & asci) != 0 ){
                return false;
            }
            vals |= asci;
        }
        
        return true;
    }
}
