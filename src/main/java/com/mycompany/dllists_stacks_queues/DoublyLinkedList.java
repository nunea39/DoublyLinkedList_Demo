
package com.mycompany.dllists_stacks_queues;

/**
 *
 * @author MoaathAlrajab
 */
class Node {
   public int data;
   public Node next;
   public Node previous;

   public Node(int initialData) {
      data = initialData;
      next = null;
      previous = null;
   }
}

public class DoublyLinkedList {
   private Node head;
   private Node tail;
    
   public DoublyLinkedList() {
      head = null;
      tail = null;
   }
    
   public void append(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         tail.next = newNode;
         newNode.previous = tail;
         tail = newNode;
      }
   }
   
   public void prepend(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         newNode.next = head;
         head.previous = newNode;
         head = newNode;
      }
   }
   
   public void printList() {
      Node node = head;
      while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
      }
      System.out.println();
   }
   
   public void insertAfter(Node currentNode, Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else if (currentNode == tail) {
         tail.next = newNode;
         newNode.previous = tail;
         tail = newNode;
      }
      else {
         Node successor = currentNode.next;
         newNode.next = successor;
         newNode.previous = currentNode;
         currentNode.next = newNode;
         successor.previous = newNode;
      }
   }
   
   public void remove(Node currentNode) {
      Node successor = currentNode.next;
      Node predecessor = currentNode.previous;
      
      if (successor != null)
         successor.previous = predecessor;
         
      if (predecessor != null)
         predecessor.next = successor;
         
      if (currentNode == head)
         head = successor;
         
      if (currentNode == tail)
         tail = predecessor;
   }
    public int extractFirst() throws Exception{
       if(head == null){
           throw new Exception("No data found");
       }
       else{
           return head.data;
       }
       
   }
    public int extractLast() throws Exception{
     if(tail == null){
         throw new Exception("No data found");
     }
     else{
         return tail.data;
     }

   }
    //complete returning the last 3 elements 
   public int find(int obj){
       int index=0;
       Node node = head;
       while(node != null){
           if(node.data == obj){
           } else {
               return index;
           }
           node= node.next;
           index++;
       }
       return -1;
   }
        @Override
        public String toString(){
            String tmp ="The content of the list are: ";
            Node node = head;
          while (node != null) {
             tmp+=node.data + " ";
             node = node.next;
            }
          return tmp;            
        }
        
     }
