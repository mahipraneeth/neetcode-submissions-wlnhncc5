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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr;
            for(int i=0; i<n; i++){
                temp = temp.next;
            }
            if(temp == null){
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if(prev == null) {
            head = curr.next;
        }else{
            prev.next = curr.next;
        }
        return head;
    }
}
