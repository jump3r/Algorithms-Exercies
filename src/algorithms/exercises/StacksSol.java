/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.exercises;

import java.util.Stack;

public class StacksSol extends ABaseSolClass{
    public static Stack<Integer> sortStackWithExtraStack(Stack<Integer> st){
        
        Stack<Integer> buf = new Stack();        
        
        while (!st.isEmpty()){
            int tmp = st.pop();
            while(!buf.isEmpty() && tmp < buf.peek()){
                st.push(buf.pop());                
            }
            buf.push(tmp);
        }    
        return buf;
    }
}
