//148. Sort List

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
        if(head==null || head.next==null){
            return head;
        }

        ListNode mid=getMiddle(head);
        ListNode rightHead=mid.next;
        mid.next=null;

        ListNode left=sortList(head);
        ListNode right=sortList(rightHead);

        return merge(left,right);
    }

    private ListNode getMiddle(ListNode head){
        if(head==null){
            return null;
        }

        var slow=head;
        var fast=head.next;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1,ListNode l2){
        var dummy=new ListNode(-1);
        var dummyHead=dummy;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                dummy.next=l1;
                l1=l1.next;
            }
            else{
                dummy.next=l2;
                l2=l2.next;
            }
            dummy=dummy.next;
        }

        if(l1!=null){
            dummy.next=l1;
        }
        if(l2!=null){
            dummy.next=l2;
        }

        return dummyHead.next;
    }
}