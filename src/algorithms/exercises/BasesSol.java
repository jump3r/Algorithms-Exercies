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
public class BasesSol extends ABaseSolClass {
    
    
    public static int convertToBase(String number, int base){
        
        if (base < 2 || (base > 10 && base != 16)){
            return -1;
        }
        
        int result = 0;
        int len = number.length();
        
        for (int i = 0; i < len; i++){
            int digit = digitToValue(number.charAt(i));
            if(digit < 0 || digit > base){
                return -1;
            }
            
            int exp = len - i - 1;
            result += digit * Math.pow(base, exp);
        }
        
        return result;
    }
    
    public static int digitToValue(char d){
        switch(d){
            case 'A':
                return 10;                
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
        }
        
        int result;
        try{
            result = Integer.parseInt(String.valueOf(d));                        
        } catch(NumberFormatException e){
            result = -1;
        }
        return result;
    }
    
}
