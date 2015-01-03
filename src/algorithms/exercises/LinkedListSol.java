/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.exercises;

import java.util.HashMap;
import java.util.Map;

public class LinkedListSol {
    
    public int v;
    public LinkedListSol next;
    
    public LinkedListSol(int v){
        this.v = v;
    }
    public LinkedListSol(int v, LinkedListSol next){
        this(v);
        this.next = next;
    }
    
    public static LinkedListSol removeDups(LinkedListSol h){
        //Remove duplicates 
        Map<Integer, Integer> m = new HashMap();
        LinkedListSol head = h;
        LinkedListSol prev = h;
        while (head != null){
            
            if (m.containsKey(head.v)){
                prev.next = head.next;                
            }else{
                m.put(head.v, 1);                
                prev = head;
            }
            head = head.next;
        }
        return h;
    }
    public static LinkedListSol removeDupsNoBuf(LinkedListSol h){
        LinkedListSol head = h;
        LinkedListSol prev,curr;
        while(head != null){
            
            curr = head;
            while(curr.next != null){
                if(curr.next.v == head.v){
                    curr.next = curr.next.next;                    
                }else{
                    curr = curr.next;
                }                
            }
            head = head.next;
        }
        return h;
    }
    
    public static boolean deleteCurrent(LinkedListSol m){
        //Given the middle element delete it, 1...5 -> middle -> 7...11
        
        if (m.next == null){
            return false;
        }
        LinkedListSol head = m.next;
        while( head.next != null ){
            m.v = head.v;
            m = head;
            head = head.next;
        }
        m.v = head.v;
        m.next = null;         
        
        return true;
    }
    
    public static LinkedListSol partitionAroundX(LinkedListSol llist, int x){
        LinkedListSol head = null;
        LinkedListSol middle = null;
        LinkedListSol beforeX = null;
        LinkedListSol afterX = null;
        
        while(llist != null){
            if(llist.v < x){
                if(beforeX == null){
                    head = llist;
                    beforeX = llist;
                }
                else{
                    beforeX.next = llist;
                    beforeX = llist;
                }
            }else{
                if(afterX == null){
                    middle = llist;
                    afterX = llist;
                }
                else{
                    afterX.next = llist;
                    afterX = llist;
                }
            }
            llist = llist.next;
        }
        
        if (head != null){
            if(middle != null){
                afterX.next = null;
            }
            beforeX.next = middle;            
        }else{
            head = middle;
        }
        return head;
    }
    
    public static LinkedListSol partitionAroundX2(LinkedListSol llist, int x){
        
        LinkedListSol before = null;
        LinkedListSol after = null;
        
        while(llist != null){  
            LinkedListSol cur = llist;
            llist = llist.next;
            cur.next = null;
            if( cur.v < x){
                cur.next = before;
                before = cur;                        
            }else{
                cur.next = after;
                after = cur;                
            }            
        }
        
        if (before == null){
            return after;
        }
        
        if(after != null){
            LinkedListSol it = before; 
            while(it.next != null){
                it = it.next;
            }
            it.next = after;
        }
        
        return before;
    }
    
    public static LinkedListSol reverseLinkedList(LinkedListSol head){
        
        if (head == null){
            return null;
        } else if (head.next == null){            
            return head;
        }
        
        LinkedListSol parent = reverseLinkedList(head.next);
        head.next = null;
        parent.next = head;
        return head;        
    }
}
