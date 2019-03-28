/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        
        ArrayList<DirectedGraphNode> result =new ArrayList<>();
        
        if(graph ==null) {
            return result;
        }
        //1 count indegree
        Map<DirectedGraphNode,Integer> myIndegree =getIndegree(graph);
        
        //2 bfs
        Queue<DirectedGraphNode> queue= new LinkedList<>();
        for(DirectedGraphNode node : graph){
            if(myIndegree.get(node)==0){
                queue.offer(node);
                result.add(node);
            }
        }
        
        while (!queue.isEmpty()){
            DirectedGraphNode node =queue.poll();
            for(DirectedGraphNode n : node.neighbors){
                myIndegree.put(n,myIndegree.get(n)-1 );
                if(myIndegree.get(n)==0 ){
                    queue.offer(n);
                    result.add(n);
                }
            }
            
        }
        return result;
        
    }
    
    private Map<DirectedGraphNode,Integer> getIndegree(ArrayList<DirectedGraphNode> graph){
        Map<DirectedGraphNode,Integer> map = new HashMap<>();
        for(DirectedGraphNode node : graph ){
            map.put(node,0);
        }
        for(DirectedGraphNode node : graph ){
            for(DirectedGraphNode neighbor : node.neighbors){
              
                map.put(neighbor, map.get(neighbor)+1);
                    
            
            
            }
        }
        
        return map;
    }
    
    
    
    
    
    
    
    
}
