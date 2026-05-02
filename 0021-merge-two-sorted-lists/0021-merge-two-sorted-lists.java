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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr = new ListNode(-1);
        ListNode l = curr;
        while(list1 != null && list2 != null){
            if(list1.val >= list2.val){
                l.next = list2;
                l = l.next;
                list2 = list2.next;
            }else{
                l.next = list1;
                l = l.next;
                list1 = list1.next;
            }
        }

        while(list1 != null){
            l.next = list1;
            list1 = list1.next;
            l = l.next;
        }

        while(list2 != null){
            l.next = list2;
            list2 = list2.next;
            l = l.next;
        }

        return curr.next;
    }
}