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
        ListNode head = rotateRight(n1, 3);
        printList(head);
    }
    public static void printList(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int count = 1;
        // 找到最后一个节点
        while(temp != null && temp.next != null){
            temp = temp.next;
            count++;
        }
        k = k % count;

        ListNode pre = new ListNode();
        ListNode cur = head;
        pre.next = head;
        int index = 0;
        while(index != count - k && cur != null){
            index++;
            cur = cur.next;
            pre = pre.next;
        }
        if(cur == null){
            return head;
        }else{
            pre.next = null;
            temp = cur;
            while(temp != null && temp.next != null){
                temp = temp.next;
            }
            temp.next = head;
            return cur;
        }
    }
}