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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            if (numsSet.contains(curr.val)) {
                if (prev != null)
                    prev.next = curr.next;
                else
                    head = curr.next;
            } else
                prev = curr;
            curr = curr.next;
        }
        return head;
    }
}