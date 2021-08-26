import java.util.HashMap;

public class MyHashMap {
    static class Node{
        int key,value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public int get(int key){
        int idx = getIndex(key);
        Node now = nodes[idx];

        if(now != null){
            if(now.key == key){
                return now.value;
            }else{
                while(now != null){
                    if(now.key == key){
                        return now.value;
                    }
                    now = now.next;
                }
            }
        }
        return - 1;
    }

    public void put(int key, int value){
        int idx = getIndex(key);
        Node now = nodes[idx],tmp = now;
        if(tmp != null){
            Node prev = null;
            while(tmp != null){
                if(tmp.key == key){
                    tmp.value = value;
                    return;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            tmp = prev;
        }

        Node node = new Node(key,value);
        if(tmp != null){
            tmp.next = node;
        }else{
            nodes[idx] = node;
        }
    }
    private final int CAPACITY = 10000;

    Node[] nodes = new Node[CAPACITY];

    private  int getIndex(int key){
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        return hash % CAPACITY;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        map.put(1,2);
        map.put(2,3);
        System.out.println(map.get(1));
        System.out.println(map.get(2));

    }
}
