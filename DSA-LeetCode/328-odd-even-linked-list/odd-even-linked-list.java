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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)return head;
        ListNode h=head;
        ListNode h2=head.next;
        ListNode t=h;
        ListNode t2=h2;
        while(t.next!=null && t2.next!=null){
            t.next=t.next.next;
            t=t.next;
            t2.next=t2.next.next;
            t2=t2.next;
        }
        t.next=h2;
        return head;
    }
}