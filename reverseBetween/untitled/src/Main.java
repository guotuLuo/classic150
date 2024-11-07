import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = reverseBetween(n1, 1, 1);
        printList(head);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 0;
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pl = new ListNode();
        pl.next = dummyNode;
        ListNode l = dummyNode;
        while(count < left){
            l = l.next;
            pl = pl.next;
            count++;
        }
        ListNode t = l;
        ListNode cur = l.next;
        //  现在l 指向左端点，pl指向左端点前面的端点

        while(count <= right && l != null){
            cur = l.next;
            l.next = pl.next;
            pl.next = l;
            l = cur;
            count++;
        }
        t.next = cur;
        return dummyNode.next;
    }

    public static void printList(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}