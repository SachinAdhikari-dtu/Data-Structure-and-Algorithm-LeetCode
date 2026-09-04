
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        if(size==n)return head.next;
        int k=size-n-1;
        temp=head;
        while(k-->0){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;

    }
}