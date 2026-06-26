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
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        int n=length(head);
        int arr []=new int [n];
       for(int i=0;i<n;i++){
        arr[i]=head.val;
        head=head.next;
       }
       Arrays.sort(arr);
       ListNode t1=new ListNode(9);
       ListNode t=t1;

      for(int i=0;i<n;i++){
    t.next = new ListNode(arr[i]);
    t = t.next;
}
       return t1.next;
    }
    public int length(ListNode head){
        int temp=0;
        while(head!=null){
            temp++;
            head=head.next;
        }
        return temp;
    }
}