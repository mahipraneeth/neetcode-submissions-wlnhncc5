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
    public void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null){
            return;
        }
        // identify first Half and break
        ListNode i = head;
        ListNode j = head;
        while(j.next != null && j.next.next != null) {
            i=i.next;
            j=j.next.next;
        }
        ListNode secondHalf = i.next;
        i.next = null;

        //reverse second half
        ListNode prev = null;
        ListNode curr = secondHalf;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // merge them
        ListNode rightHead = prev;
        curr = head;
        while(rightHead != null) {
            ListNode temp = curr.next;
            curr.next = rightHead;
            rightHead = rightHead.next;
            curr.next.next = temp;
            curr = curr.next.next;
        }
    }
}
