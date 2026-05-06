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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode tail = dummy;
        for(int i = 1; i < left ; i++){
           tail = tail.next;
        }

        ListNode curr = tail.next;
        ListNode reverseTail = curr;
        ListNode prev = null;
        ListNode next;

        for(int i = left ; i <= right ; i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        tail.next = prev;
        reverseTail.next = curr;

        return dummy.next;
    }
}