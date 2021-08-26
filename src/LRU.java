import java.util.HashMap;
import java.util.Map;

public class LRU {
    class LinkNode{
        int key;
        int value;
        LinkNode prev;
        LinkNode next;
        public LinkNode(){}
        public LinkNode(int key,int value){this.key = key;this.value = value;}
    }
    private Map<Integer,LinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LinkNode head, tail;
    public LRU(int capacity){
        this.capacity = capacity;
        this.size = 0;
        head = new LinkNode();
        tail = new LinkNode();
        head.next = tail;
        tail.prev = head;

    }
    public int get(int key){
        LinkNode node = cache.get(key);
        if(node == null){return -1;}
        movetoHead(node);
        return node.value;
    }
    public void movetoHead(LinkNode node){
        removeNode(node);
        addToHead(node);
    }
    public void removeNode(LinkNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addToHead(LinkNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    public void put(int key,int value){
        LinkNode node = cache.get(key);
        if(node != null){
            node.value = value;
            movetoHead(node);
        }else{
            LinkNode newNode = new LinkNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size > capacity){
                LinkNode tail = removeTail();
                cache.remove(tail);
                size--;
            }

        }
    }
    public LinkNode removeTail(){
        LinkNode res = tail.prev;
        removeNode(res);
        return res;
    }
    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1,2);
        lru.put(2,3);
        System.out.println(lru.get(1));
        lru.put(2,4);
        System.out.println(lru.get(2));
    }
}
