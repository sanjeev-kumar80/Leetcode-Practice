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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1=list1;
        ListNode temp2=list2;

        ListNode temp=new ListNode(0);
        ListNode t1=temp;

        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                t1.next=temp1;
                temp1=temp1.next;
            }
            else{
                t1.next=temp2;
                temp2=temp2.next;
            }
            t1=t1.next;
        }
        if(temp1!=null){
            t1.next=temp1;
        }
        else{
            t1.next=temp2;
    }
        return temp.next;
    }
}