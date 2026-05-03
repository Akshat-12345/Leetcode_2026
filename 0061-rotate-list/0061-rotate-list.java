/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        int size = 1;
        ListNode tail = head;

        while(tail.next != null){
            tail = tail.next;
            size++;
        }
        
        k = k % size;
        
        tail.next = head;
        ListNode prev = head;
        int i = 1;
        int val = size - k;

        while(i < val){
            prev = prev.next;
            i++;
        }
        
        head = prev.next;
        prev.next = null;
        
        return head;
    }
}