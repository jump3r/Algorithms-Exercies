/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.exercises;

import java.util.ArrayList;
import java.util.List;

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
    
    public static int[][] setToZeros(int[][] matrix){
        //Set to zeroes all intersecting rows and columns with zero at center 
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }        
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if (rows[i] || columns[j]){
                    matrix[i][j] = 0;
                }
            }
        }        
        return matrix;
    }
    
    public static List<List<Integer>> removeAndRolloverArrays(int elind, int arind){
        List<Integer> ar1 = new ArrayList();
        ar1.add(1);ar1.add(2);ar1.add(3);
        List<Integer> ar2 = new ArrayList();
        ar2.add(1);ar2.add(2);ar2.add(3);
        List<Integer> ar3 = new ArrayList();
        ar3.add(1);ar3.add(2);
        List<List<Integer>> ars = new ArrayList();        
        ars.add(ar1); ars.add(ar2); ars.add(ar3);
        //[[1,2,3],[1,2,3],]
        int maxSize = 3;
        int arIndex = arind;
        int elIndex = elind;
        
        while(true){
        
            if (elIndex + 1 == ars.get(arIndex).size() && 
                    (ars.size() == arIndex + 1 || ars.get(arIndex+1).isEmpty() )){
                ars.get(arIndex).remove(elIndex);
                break;
            }
            
            int elToMove = elIndex;
            int arToMove = arIndex;
            if(elIndex == maxSize - 1){
                elToMove = 0;
                arToMove++;
            }else {
                elToMove++;                
            }
            print(ars);
            ars.get(arIndex).add(elIndex, ars.get(arToMove).get(elToMove));
            ars.get(arIndex).remove(elIndex+1);
            
            arIndex = arToMove;
            elIndex = elToMove;            
        }
        
        return ars;
    }
}
