package DAY5;

public class merge_two_sorted_list {

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
