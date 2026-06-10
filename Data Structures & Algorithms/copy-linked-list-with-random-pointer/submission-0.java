/*
// Definition for a Node.
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
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        Map<Node, Node> mp = new HashMap<>();

        Node curr = head;
        while(curr != null){ //1. Create copy of each node
            mp.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while(curr != null){ // 2. Connect next and random
            Node copy = mp.get(curr);
            copy.next = mp.get(curr.next);
            copy.random = mp.get(curr.random);
            curr = curr.next;
        }

        return mp.get(head);

        
    }
}
