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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for(int i=0; i<lists.length; i++){
            if(result == null){
                result = lists[i];
            }else{
                result = getSorted(result, lists[i]);
            }
        }
        return result;
    }

    private ListNode getSorted(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode leftPointer = l1;
        ListNode rightPointer = l2;

        while(leftPointer != null || rightPointer != null){
            if(leftPointer == null){
                curr.next = rightPointer;
                rightPointer = null;
            }else if(rightPointer == null){
                curr.next = leftPointer;
                leftPointer = null;
            }else{
                if(leftPointer.val < rightPointer.val){
                    curr.next = leftPointer;
                    leftPointer = leftPointer.next;
                }else{
                    curr.next = rightPointer;
                    rightPointer = rightPointer.next;
                }
            }
            curr= curr.next;
        }
        return dummy.next;
    }
}
