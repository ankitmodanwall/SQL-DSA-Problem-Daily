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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(-1,null);
        ListNode temp = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0)
        {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            int sum = v1+v2+carry;
            carry = sum/10;
            ListNode newnode = new ListNode(sum%10);
            temp.next = newnode;
            temp = newnode;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        dummy = dummy.next;
        return reverse(dummy);
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null,temp = head,temp1;
        while(temp != null)
        {
            temp1 = temp.next;
            temp.next = prev;
            prev = temp;
            temp = temp1;
        }
        return prev;
    }
}