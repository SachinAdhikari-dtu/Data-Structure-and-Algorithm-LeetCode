
class Solution {
    public static ListNode  reverse(ListNode head){
        if(head==null)return null;
        ListNode curr=head;
        ListNode prev=null;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }return prev;
    }
    public static ListNode add(ListNode l1 , ListNode l2){
        int c=0;
        ListNode temp=new ListNode(-1);
        ListNode ans=temp;
        while(l1!=null||l2!=null||c>0){
            int m=c;
            if(l1!=null){
                m+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                m+=l2.val;
                l2=l2.next;
            }
            ListNode l=new ListNode(m%10);
            ans.next=l;
            ans=ans.next;
            c=m/10;
        }

        return temp.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
        ListNode ans=add(l1,l2);
        return ans;
    }
}