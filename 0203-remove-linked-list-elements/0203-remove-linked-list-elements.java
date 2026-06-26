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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
       // if(head.val==val) return null;
        ListNode temp=new ListNode(0);
        ListNode t1=temp;
        while(head!=null){
            if(head.val!=val){
                t1.next=head;
                t1=t1.next;
            }
            head=head.next;
            t1.next=null;
        }
        return temp.next;
        
    }
}