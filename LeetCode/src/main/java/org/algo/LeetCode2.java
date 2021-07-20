package org.algo;


import java.util.LinkedList;
import java.util.Stack;

/**
 *  1）倒转链表
 *  2）两数相加，超过10，考虑进位
 */
public class LeetCode2 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4,l1);
        ListNode l3 = new ListNode(2,l2);

        ListNode node = l3;


        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(6,l4);
        ListNode l6 = new ListNode(5,l5);
        node = l6;

        ListNode newNode = addTwoNumbers(l3,l6);
        while(newNode != null){
            System.out.print(""+newNode.val);
            newNode = newNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//        Stack<Integer> s1 = new Stack<Integer>();
//        Stack<Integer> s2 = new Stack<Integer>();
        //改用linkedlist实现，性能考虑 jdk stack 用vector实现，线程安全的。
        LinkedList<Integer> s1 = new LinkedList<>();
        LinkedList<Integer> s2 = new LinkedList<>();
        while(l1 != null){
            s1.addFirst(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.addFirst(l2.val);
            l2 = l2.next;
        }
        int carry=0;
        ListNode head = null;
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0){
            int sum = carry;
            sum += s1.isEmpty()? 0: s1.removeFirst();
            sum += s2.isEmpty()? 0: s2.removeFirst();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }
}
class ListNode {

    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
