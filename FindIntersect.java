package com.rev;

public class FindIntersect {

//Java program to get intersection point of two linked list

 static Node headA, headB;

 static class Node {

     int data;
     Node next;

     Node(int d)
     {
         data = d;
         next = null;
     }
 }

 /*function to get the intersection point of two linked
 lists headA and headB */
 int getNode()
 {
     int c1 = getCount(headA);
     int c2 = getCount(headB);
     int d;

     if (c1 > c2) {
         d = c1 - c2;
         return _getIntesectionNode(d, headA, headB);
     }
     else {
         d = c2 - c1;
         return _getIntesectionNode(d, headB, headA);
     }
 }

 /* function to get the intersection point of two linked
  lists headA and headB where headA has d more nodes than
  headB */
 int _getIntesectionNode(int d, Node node1, Node node2)
 {
     int i;
     Node current1 = node1;
     Node current2 = node2;
     for (i = 0; i < d; i++) {
         if (current1 == null) {
             return -1;
         }
         current1 = current1.next;
     }
     while (current1 != null && current2 != null) {
         if (current1.data == current2.data) {
             return current1.data;
         }
         current1 = current1.next;
         current2 = current2.next;
     }

     return -1;
 }

 /*Takes head pointer of the linked list and
 returns the count of nodes in the list */
 int getCount(Node node)
 {
     Node current = node;
     int count = 0;

     while (current != null) {
         count++;
         current = current.next;
     }

     return count;
 }

 public static void main(String[] args)
 {
     FindIntersect list = new FindIntersect();

     // creating first linked list
     list.headA = new Node(2);
     list.headA.next = new Node(4);
     list.headA.next.next = new Node(8);
     list.headA.next.next.next = new Node(16);
     list.headA.next.next.next.next = new Node(32);

     // creating second linked list
     list.headB = new Node(4);
     list.headB.next = new Node(16);
     list.headB.next.next = new Node(30);

     System.out.println("The node of intersection is " + list.getNode());
 }
}

