/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        // use bfs algorithm to traverse the graph and get all nodes.
        ArrayList<Node> nodes =getNodes(node);
        //create new nodes and old->new
        HashMap<Node,Node> mapping =new HashMap<>();
        for( Node n : nodes){
            mapping.put(n,new Node(n.val,new ArrayList<Node>()));
        }
        
        //copy neighbors
        for(Node n :nodes ){
            Node newNode= mapping.get(n);
            for(Node nb: n.neighbors){
                newNode.neighbors.add(mapping.get(nb));
            }
        }
        return mapping.get(node);
    }
    
    private ArrayList<Node> getNodes(Node node){
        Queue<Node> queue =new LinkedList<Node>();
        HashSet<Node> Set = new HashSet<>();
        
        queue.offer(node);
        Set.add(node);
        while(!queue.isEmpty()){
            Node head =queue.poll();
            for (Node neighbor : head.neighbors){
                if(!Set.contains(neighbor)){
                    Set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<Node>(Set);
    }
    
}
