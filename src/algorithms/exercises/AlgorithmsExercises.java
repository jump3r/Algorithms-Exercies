/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.exercises;



public class AlgorithmsExercises extends ABaseSolClass {
        
    public static void main(String[] args) {
        
        //print(BasesSol.convertToBase("F10", 16));
        
        //print(ArraysSol.replaceSpaces(new char[] {'a','b',' ','c',' ',' ',' '}, 4));
        
        //print(StringsSol.compressBad("aabccca"));
        
        int [][] matrix = new int[][]
                        { 
                        new int[] {1,2,3,4},
                        new int[] {5,6,7,8},
                        new int[] {9,10,11,12},
                        new int[] {13,14,15,16}
                        };                
        //ArraysSol.turnMatrix(matrix);
        
        matrix[2][1] = 0;        
        //print(ArraysSol.setToZeros(matrix));
        LinkedListSol head = new LinkedListSol(1, new LinkedListSol(2, new LinkedListSol(3)));
        //print(LinkedListSol.removeDups(head));
        //print(LinkedListSol.removeDupsNoBuf(head));
        //LinkedListSol.deleteCurrent(head); print(head);
        //print(LinkedListSol.partitionAroundX2(head, 2));
        LinkedListSol newHead = null;
        LinkedListSol.reverseLinkedList(head);
        print (head);
    }
    
}
