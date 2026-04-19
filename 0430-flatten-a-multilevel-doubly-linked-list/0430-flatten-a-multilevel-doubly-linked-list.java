/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }
        Node curr = head;
        while(curr != null){
            if(curr.child != null){
                Node after = curr.next;
                curr.next = flatten(curr.child);
                curr.next.prev = curr;
                curr.child = null;

                while(curr.next != null){
                    curr = curr.next;
                }
                if(after != null){
                    curr.next = after;
                    after.prev = curr;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}