//146. LRU Cache

class LRUCache{

    private class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    } 
    
    Map<Integer,Node> cache=new HashMap<>();
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key){
        if(!cache.containsKey(key)){
           return -1;
        } 

        var node=cache.get(key);
        remove(node);
        addToHead(node);
        return node.value;
    }
    
    public void put(int key,int value){
        if(cache.containsKey(key)){
          Node node=cache.get(key);
          remove(node);
          addToHead(node);
          node.value=value;
        }
        else{
          Node node=new Node(key,value);
          cache.put(key,node);
          addToHead(node);
        }

        if(cache.size()>capacity){
            Node lru=tail.pre;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void remove(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    private void addToHead(Node node){
        node.next=head.next;
        node.pre=head; 
        head.next.pre=node;
        head.next=node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */