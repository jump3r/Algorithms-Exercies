/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.exercises;

import java.util.List;

/**
 *
 * @author anton
 */
public class ABaseSolClass {
    public static void println(){
        System.out.println();
    }
    
    public static void print(int p){
        System.out.println(p);
    }
    public static void print(String p){
        System.out.println(p);
    }
    public static void print(char[] cs){
        for (int i = 0; i < cs.length; i++){
            System.out.print(cs[i]);
            System.out.print(',');
        }
        println();
    }
    public static void print(int[] ints){
        for (int i = 0; i < ints.length; i++){
            System.out.print(ints[i]);
            System.out.print(',');
        }   
        println();
    }
    public static void print(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            print(matrix[i]);
        }
        println();
    }
    
    public static void print(LinkedListSol ll){
        if (ll == null) System.out.print("null");
        while (ll != null){
            System.out.print(ll.v + ", ");
            ll = ll.next;
        }
        println();
    }  
    public static void print(boolean b){
        System.out.println(b);
    }
    /*
    public static void print(List<Integer> ar){//Method resolution occurs at compile time and doesn't consider type parameters.
        System.out.println(ar.toString());
    }    
    */
    public static void printar(List<Integer> ar){
        System.out.print(ar.toString());
    }
    public static void print(List<List<Integer>> ars){
        for(List<Integer> ar : ars){
            printar(ar);
        }
        System.out.println();
    }
    
}
