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
public class ArraysSol extends ABaseSolClass {
    
    public static char[] replaceSpaces(char [] chars, int trueLen){
        //Replace spaces with %20
        int allLen = 0;
        for (int i = 0; i < trueLen; i++){
            if (chars[i] == ' '){
                allLen += 2;
            }
            allLen += 1;
        }
        
        for (trueLen -= 1; trueLen != 0; trueLen--){
                        
            if (chars[trueLen] == ' '){                
                chars[--allLen] = '0';
                chars[--allLen] = '2';
                chars[--allLen] = '%';
                
            }else{
                chars[--allLen] = chars[trueLen];
            }  
        }
        return chars;
    }
    
    public static int[][] turnMatrix(int [][] matrix){
        int len = matrix.length;
        for(int layer = 0; layer < matrix.length/2; layer ++){
            int beg = layer;
            int end = matrix.length - layer - 1;
            
            for(int i = beg; i < end; i++){
                
                int top = matrix[layer][i];
                //left to top
                matrix[layer][i] = matrix[len - i - 1][len - end - 1];
                //bottom to left
                matrix[len - i - 1][len - end - 1] = matrix[end][len - i - 1];
                //right to bottom
                matrix[end][len - i - 1] = matrix[i][end];
                //top to right
                matrix[i][end] = top;//matrix[layer][i];
                
                //print(matrix);
            }            
        }
        
        return matrix;
    }
}
