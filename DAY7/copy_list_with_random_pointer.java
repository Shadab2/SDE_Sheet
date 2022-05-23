package DAY7;

import java.util.*;

//tags: Implementation , Medium

public class copy_list_with_random_pointer {
    // Approach #1 using only one map
    // first make copy of next and values;
    // in second traversal search in the map original random values and search
    // equivalent in new list
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Node, Node> equiv = new HashMap<>();
        Node newHead = new Node(0);
        Node trav = head, copy = newHead;

        while (trav != null) {
            newHead.next = new Node(trav.val);
            equiv.put(trav, newHead.next);
            trav = trav.next;
            newHead = newHead.next;
        }
        trav = head;
        newHead = copy.next;
        while (trav != null) {
            if (trav.random != null) {
                newHead.random = equiv.get(trav.random);
            }
            trav = trav.next;
            newHead = newHead.next;
        }
        return copy.next;

    }

    // Appraoch #2 using same appoach differnet implementation and using two maps
    public Node copyRandomList1(Node head) {
        Node newHead = new Node(0), t1 = head, t2 = newHead;
        Map<Node, Integer> map = new HashMap<>();
        Map<Integer, Node> rmap = new HashMap<>();

        int count = 0;
        while (t1 != null) {
            t2.next = new Node(t1.val);
            t2 = t2.next;
            map.put(t1, count);
            rmap.put(count, t2);
            t1 = t1.next;
            count++;
        }
        t1 = head;
        t2 = newHead.next;
        while (t1 != null) {
            if (t1.random != null) {
                count = map.get(t1.random);
                t2.random = rmap.get(count);
            }
            t1 = t1.next;
            t2 = t2.next;
        }

        return newHead.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
