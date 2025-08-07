/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;

            if (temp1 == temp2)
                return temp1;

            if (temp1 == null)
                temp1 = headB;

            if (temp2 == null)
                temp2 = headA;
        }
        return temp1;
    }
}

// Brute Force Solution
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         HashMap<ListNode,Integer>visited=new HashMap<>();
//         ListNode temp=headA;
//         while(temp!=null){
//             visited.put(temp,visited.getOrDefault(temp,0)+1);
//             temp=temp.next;
//         }
//         temp=headB;
//         while(temp!=null){
//             if(visited.containsKey(temp))
//             return temp;
//             temp=temp.next;
//         }
//         return null;
//     }
// }