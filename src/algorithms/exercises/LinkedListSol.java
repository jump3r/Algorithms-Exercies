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
        this.next = null;
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
    
    public static LinkedListSol reverseLinkedList(LinkedListSol head, LinkedListSol prev){
        //Reverse linked list and return head
        if (head == null){
            return null;
        } else if (head.next == null){ 
            head.next = prev;
            return head;
        }
        
        LinkedListSol newHead = reverseLinkedList(head.next, head);        
        
        head.next = prev;
        
        return newHead;
    }
    
    public static LinkedListSol addLinkedLists(LinkedListSol list1, LinkedListSol list2){
        //Arithmetically add values of two linked lists
        //Can pad instead. Find length before iterating through lists
        LinkedListSol sum = null;
        list1 = reverseLinkedList(list1, null);
        list2 = reverseLinkedList(list2, null);
        
        int carry = 0;
        while (list2 != null || list1 != null){
            int val1 = 0;
            int val2 = 0;
            
            if(list1 != null) {
                val1 = list1.v;
                list1 = list1.next;
            }
            if(list2 != null) {
                val2 = list2.v;
                list2 = list2.next;
            }
                        
            int newV = val1 + val2 + carry;
            if (newV > 9){
                newV = newV - 10;
                carry = 1;
            }else{
                carry = 0;
            }
            
            LinkedListSol node = new LinkedListSol(newV, sum);
            sum = node;
        }        
        
        if (carry > 0){
            LinkedListSol node = new LinkedListSol(carry, sum);
            sum = node;
        }
        return sum;
    }
    
    public static int LinkedListLength(LinkedListSol ll){
        if (ll == null) return 0;
        if (ll.next == null) return 1;
        return 1 + LinkedListLength(ll.next);
    }
    public static LinkedListSol padListBy(LinkedListSol listToPad, int padBy){
        while(padBy != 0){
            LinkedListSol zeroNode = new LinkedListSol(0, listToPad);
            listToPad = zeroNode;
        }
        return listToPad;
    }
    public static LinkedListSol addEqualLengthLinkedListsRecursively(LinkedListSol list1, LinkedListSol list2, int carry){
        
        if (list1 == null && list2 == null && carry == 0 ){
            return null;
        }else if (list1 == null && list2 == null){
            return new LinkedListSol(carry, null);
        }
        
        int sum = list1.v + list2.v + carry;
        int newV;
        if(sum > 9){
            carry = 1;
            sum = sum - 10;
        }
        else{
            carry = 0;
        }
        LinkedListSol nextNode = addEqualLengthLinkedListsRecursively(list1.next, list2.next, carry);
        LinkedListSol currNode = new LinkedListSol(sum, nextNode);
        
        return currNode;
    }
    public static LinkedListSol addLinkedListsPadZeroes(LinkedListSol list1, LinkedListSol list2){
        //Arithmetically add values of two linked lists
        //Pad instead if different sizes
        //Methods: LinkedListLength, padListBy, addEqualLengthLinkedListsRecursively, reverseLinkedList
        int len1 = LinkedListLength(list1);
        int len2 = LinkedListLength(list2);
        
        int padBy = 0;
        if(len1 > len2){
            list2 =  padListBy(list2, len1 - len2);
        }else if(len2 > len1) {
            list1 =  padListBy(list1, len1 - len2);
        }        
            
        return addEqualLengthLinkedListsRecursively(reverseLinkedList(list1, null), reverseLinkedList(list2, null), 0);
    }
}
