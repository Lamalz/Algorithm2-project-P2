
package graphframework;

/*
implementation of the Dijkstra-based shortest path algorithm for 
computing the shortest path from each vertex to the rest of the vertices, which is located in the
computeDijkstraBasedSPAlg() method
*/
public class DBAllSourceSPAlg extends ShortestPathAlgorithm {
    
    public void computeDijkstraBasedSPAlg(Graph graph){
        SingleSourceSPAlg s = new SingleSourceSPAlg();
        for (int i = 0; i < graph.verticesNo; i++) {
            s.computeDijkstraAlg(graph, i);
            for (int j = 0; j < graph.verticesNo; j++) {
                graph.vertices.get(j).isVisited = false;
            }
        }
    }   
}
