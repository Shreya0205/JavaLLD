import java.util.HashMap;

public class LRU {

    int capacity;
    HashMap<Integer, Node> keys;
    HashMap<Node, Integer> reverseKeys;
    Node head;
    Node tail;
    int totalNodes;

    public LRU(int capacity){
        this.capacity = capacity;
        this.totalNodes = 0;
        this.head = null;
        this.tail = null;
        this.keys = new HashMap<>();
        this.reverseKeys =  new HashMap<>();
    }

    public synchronized void put(int key, int value){

        Node node = new Node(value);
        if(totalNodes == capacity){
            Node lastSecNode = this.tail.prev;
            lastSecNode.next = null;
            int tailKey = reverseKeys.get(this.tail);
            System.out.println("removed key " + tailKey);
            this.keys.remove(tailKey);
            this.reverseKeys.remove(this.tail);
            this.tail = lastSecNode;

            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
        else{
            if(this.head == null){
                this.head = node;
                this.tail = node;
            }
            else{
                this.head.prev = node;
                node.next = this.head;
                this.head = node;
            }
            this.totalNodes ++;
        }
        this.keys.put(key, node);
        this.reverseKeys.put(node, key);
    }

    public synchronized void get(int key){
        Node node = this.keys.get(key);

        if (node == null)
            System.out.println("Key " + key + " does not exist");
        else {
            System.out.println("Key " + key + " have value " + node.value);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;

            node.next = this.head;
            this.head = node;

        }
    }

}
