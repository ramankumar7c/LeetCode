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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode middle = middleNode(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);
        return mergeTwoLists(left, right);
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null)
            current.next = list1;
        else
            current.next = list2;

        return dummy.next;
    }
}

// Brute Force Solution
// class Solution {
//     public ListNode sortList(ListNode head) {
//         if (head == null || head.next == null)
//             return head;
//         List<Integer> list = new ArrayList<>();
//         ListNode temp = head;
//         while (temp != null) {
//             list.add(temp.val);
//             temp = temp.next;
//         }
//         Collections.sort(list);
//         temp = head;
//         for (int val : list) {
//             temp.val = val;
//             temp = temp.next;
//         }
//         return head;
//     }
// }