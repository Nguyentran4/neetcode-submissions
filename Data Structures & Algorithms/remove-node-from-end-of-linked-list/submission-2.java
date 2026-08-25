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
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }

        int target = len - n;
        if(target == 0) return head.next;

        cur = head;
        for(int i = 0; i < target - 1; i++){
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return head;
    }
}
