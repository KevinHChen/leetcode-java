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

        if (head==null) return head;

        // get list len
        int len = 0;
        ListNode right = head;
        while(right!=null) {
            right=right.next;
            len++;
        }
        if (k>len) k=k%len;
        if (k % len == 0) return head; //key step, to avoid rotation


        right = head;
        while(k>0&&right!=null) {
            k--;
            right=right.next;
        }

        //find the break point
        ListNode left = head;
        while (right.next!=null) {
            left=left.next;
            right=right.next;
        }

        //shall break after `left`
        ListNode newHead = left.next;
        left.next=null;
        right.next=head;
        return newHead;
    }
}
