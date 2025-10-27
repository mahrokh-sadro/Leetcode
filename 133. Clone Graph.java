// Given a reference of a node in a connected undirected graph.

// Return a deep copy (clone) of the graph.

// Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

// class Node {
//     public int val;
//     public List<Node> neighbors;
// }

 

// Test case format:

// For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

// An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

// The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return  null;
        }

        Node newNode=new Node(node.val);
        Map<Node,Node> map=new HashMap<>();
        map.put(node,newNode);
        Queue<Node> que=new LinkedList<>();
        que.add(node);

        while(!que.isEmpty()){
            Node polled=que.poll();
            for(Node neighbor:polled.neighbors){
               if(!map.containsKey(neighbor)){
                  Node newNeighbor=new Node(neighbor.val);
                  map.put(neighbor,newNeighbor);
                  que.add(neighbor);
               }
               map.get(polled).neighbors.add(map.get(neighbor));
            }
        }

        return newNode;


    }
}


//Time: O(V + E)
//Space: O(V + E)