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
public class StringsSol {
    
    public static String compressBad(String s){
        //Compress string e.g. aabccca -> 2a1b3c1a
        
        StringBuilder news = new StringBuilder();
        
        char prevChar = s.charAt(0);
        char curChar;
        int count = 1;
        for (int i = 1; i < s.length(); i++){
            curChar = s.charAt(i);
            if(curChar != prevChar){
                news.append(count);
                news.append(prevChar);
                prevChar = curChar;
                count = 0;
            }
            count++;
        }
        news.append(count);
        news.append(prevChar);
        
        return news.toString();
    }
}
