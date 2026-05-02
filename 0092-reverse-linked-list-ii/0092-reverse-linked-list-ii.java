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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        for(int i = 1 ; i < left ; i++){
            temp = temp.next;
        }
        
        ListNode curr = temp.next;
        ListNode next ;
        ListNode prev = null;
        ListNode tail = curr;

        for(int i = left ; i <= right ;i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }

        temp.next = prev;
        tail.next = curr;

        return dummy.next;

    }
}