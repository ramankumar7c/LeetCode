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
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++)
            fast = fast.next;

        if (fast == null)
            return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newNode = slow.next;
        slow.next = slow.next.next;

        return head;
    }
}

// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         int count = 0;
//         ListNode temp = head;
//         while (temp != null) {
//             count++;
//             temp = temp.next;
//         }
//         if (count == n) {
//             ListNode newHead = head.next;
//             return newHead;
//         }

//         ListNode temp1 = head;
//         int res = count - n;
//         while (temp1 != null) {
//             res--;
//             if (res == 0)
//                 break;
//             temp1 = temp1.next;
//         }
//         ListNode newNode = temp1.next;
//         temp1.next = temp1.next.next;

//         return head;
//     }
// }