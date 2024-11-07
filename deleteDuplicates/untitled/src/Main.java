import org.w3c.dom.ls.LSInput;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode head = deleteDuplicates(n1);
        printList(head);
    }
    public static void printList(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        // 消除所有重复节点，那么必须保存开始的非重复节点
        ListNode l = head;
        ListNode pre = dummyNode;
        ListNode r;
        while(l != null){
            r = l.next;
            if(r != null && r.val == l.val){
                while(r != null && r.val == l.val){
                    r = r.next;
                }
                pre.next = r;
                l = r;
            }else{
                l = l.next;
                pre = pre.next;
            }
        }
        return dummyNode.next;
    }


}