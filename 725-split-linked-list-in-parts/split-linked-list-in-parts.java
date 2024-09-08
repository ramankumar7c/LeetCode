/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode curr = root;

        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int minPartSize = length / k;
        int remainder = length % k;

        curr = root;
        for (int i = 0; i < k; i++) {
            ListNode head = curr;
            int currentPartSize = minPartSize + (remainder-- > 0 ? 1 : 0);

            for (int j = 0; j < currentPartSize - 1 && curr != null; j++)
                curr = curr.next;

            if (curr != null) {
                ListNode nextPartHead = curr.next;
                curr.next = null;
                curr = nextPartHead;
            }
            ans[i] = head;
        }
        return ans;
    }
}