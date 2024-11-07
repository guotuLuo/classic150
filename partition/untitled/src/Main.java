import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode head = partition(n1, 3);
        printList(head);
    }
    public static void printList(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode();
        ListNode p = head1;
        ListNode head2 = new ListNode();
        ListNode q = head2;
        ListNode temp = head;
        while(temp != null){
            if(temp.val < x){
                p.next = temp;
                p = p.next;
            }else {
                q.next = temp;
                q = q.next;
            }
            temp = temp.next;
        }
        q.next = null;
        p.next = head2.next;
        return head1.next;
    }
}