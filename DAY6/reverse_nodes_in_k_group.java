package DAY6;

// tags : Implmentation , LinkedList, Hard
public class reverse_nodes_in_k_group {
    // first traverse k nodes from the beginning , keep track of the precedessor of
    // the first node of such k group
    // reverse the first node of the kth group , and carefully set relevant pointers
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0, head);
        ListNode prev = newHead, cur = head, next = cur;
        int count = 0;
        while (cur != null) {
            if (count == k - 1) {
                next = cur.next;
                // importannt to unlink the cur.next from the group
                cur.next = null;
                ListNode revHead = reverse(prev.next);
                prev.next.next = next;
                cur = prev.next;
                prev.next = revHead;
                prev = cur;

            }
            cur = cur.next;
            count = (count + 1) % k;
        }
        return newHead.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head, prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // Approach #2 using only recursion
    // solution from discussion
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup1(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}

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
