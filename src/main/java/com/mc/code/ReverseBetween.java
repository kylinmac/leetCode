package com.mc.code;

/**
 * @author macheng
 * @date 2021/3/18 10:50
 */
public class ReverseBetween {

    public static class ListNode {
    int val;
    ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3)));
        new ReverseBetween().reverseBetween(head,1,3);
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        ListNode le=null;
        ListNode ri=null;
        ListNode current=head;

        for(int i=0;i<right+1;i++){
            if(i==(left-2)){
                le=current;
            }else if(i==(right)){
                ri=current;
                break;
            }
            current=current.next;
        }
        ListNode lh= reserve(le==null?head:le.next,right-left,ri);

        if(le == null){
            return lh;
        }else{
            le.next=lh;
            return head;
        }

    }


    private ListNode reserve(ListNode head,int n,ListNode ri){

        ListNode cur=head.next;
        ListNode before=head;
        ListNode next=head.next.next;
        int i=0;
        do {
            cur.next=before;
            before=cur;
            cur=next;
            next=next==null?null:next.next;

            i++;
        }while (i<n);
        head.next=ri;
        return before;

    }

}
