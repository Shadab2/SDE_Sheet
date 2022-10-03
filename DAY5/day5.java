package DAY5;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class delete_node_in_a_linked_list {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

// ---------------------------------------------------------------------------------------

class merge_two_sorted_list {

    // Approach#1 using recursion
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // this condition is not important
        if (list1 == null && list2 == null)
            return list1;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }

    // Approach #2 using iteration
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode trav = head;

        while (list1 != null && list2 != null) {
            trav.next = new ListNode();
            trav = trav.next;
            if (list1.val < list2.val) {
                trav.val = list1.val;
                list1 = list1.next;
            } else {
                trav.val = list2.val;
                list2 = list2.next;
            }
        }

        if (list1 != null)
            trav.next = list1;
        if (list2 != null)
            trav.next = list2;

        return head.next;
    }
}

// ------------------------------------------------------------------------------------------------

class middle_of_the_linked_list {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // slow and fast pointer
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null)
            slow = slow.next;
        return slow;
    }
}

// ---------------------------------------------------------------------------------------

class nth_node_from_end_of_list {

    // Approach #1 using two passes
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0, count = 1;
        ListNode trav = head;
        while (trav != null) {
            trav = trav.next;
            length++;
        }
        trav = head;
        if (length - n == 0)
            return head.next;
        while (trav != null) {
            if (length - count == n) {
                trav.next = trav.next.next;
                break;
            }
            trav = trav.next;
            count++;
        }
        return head;
    }

    // Approach #2 using a single pass
    // fast forwarding fast pointer n step after so that when it reached null , slow
    // is at nth node from last
    public ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode newHead = new ListNode(0);
        ListNode slow = newHead, fast = newHead;
        newHead.next = head;
        while (n-- > 0)
            fast = fast.next;

        // when fast is null we slow would be at nth node from last
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}

// ------------------------------------------------------------------------------------

class reverse_linked_list {

    // Approach #1 recusrive
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        // important to set head.next to null otherwise cycle at the orginal head of the
        // node
        head.next = null;
        return newHead;
    }

    // Approach #2 iterative
    public ListNode reverseListIterative(ListNode head) {
        ListNode cur = head, prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
