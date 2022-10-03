package DAY6;

public class palindrome_linked_list {
    // globally declared
    // the idea is to reach out to end of the list using recursion and start
    // comparing by incrementing
    // trav and decremneting endNode
    ListNode trav;

    public boolean isPalindrome(ListNode head) {
        trav = head;
        return check(head);
    }

    public boolean check(ListNode cur) {
        if (cur.next == null) {
            return cur.val == trav.val;
        }
        if (!check(cur.next))
            return false;
        trav = trav.next;
        return trav.val == cur.val;
    }
}