
package graphframework;
import java.util.ArrayList;
import java.util.Collections;
/*
implementation of the algorithm responsible for computing the 
shortest path for a specified source, which is located in the computeDijkstraAlg()method
*/
public class SingleSourceSPAlg extends ShortestPathAlgorithm {
    ArrayList <QNode> result;
    public void computeDijkstraAlg(Graph graph, int source){
        ArrayList <QNode> pq = new ArrayList<>();
        
        // initilize d with inifinty and add it to the queue
        for (int i = 0; i < graph.verticesNo; i++) {
            QNode ob = new QNode();
            ob.vertex = graph.vertices.get(i); // all vertcies 
            ob.parent = graph.vertices.get(i);
            ob.d = Integer.MAX_VALUE;
        
            pq.add(ob);
         
        }
        // update the d of the source vertex to 0 
        pq.get(source).d = 0;
      
        result = new ArrayList<>();
        
        for (int i = 0; i < graph.verticesNo; i++) {
            Collections.sort(pq, new QNodeComparator());
            QNode u = pq.get(0);
            pq.remove(0);

            u.vertex.isVisited = true;
            
            result.add(u);
            for (int j = 0; j < u.vertex.adjList.size(); j++) { // every vertex that is adjecent to u
                if(u.vertex.adjList.get(j).destination.isVisited == false){ // and this vertex is not in result list (i.e. its is not visited)
                    Vertex v = u.vertex.adjList.get(j).destination; // adj vertex
                    QNode dv = findElement(pq,v); // the d of the adj vertex
                   
                    if(u.d + u.vertex.adjList.get(j).weight < dv.d){ 
                        pq.remove(dv);
                        QNode ob = new QNode();  
                        ob.vertex = v;
                        ob.d = u.d + u.vertex.adjList.get(j).weight; // update the d
                       
                        ob.parent = u.vertex; // update parent
                      
                        pq.add(ob);
                        
                    }       
                }
            }
            
        }
        // print the paths from source to all vertices  
        System.out.println("------------------------------------------------------------------------");
        System.out.println("The starting point location is "+result.get(0).vertex.label);
        System.out.println("The route from location "+result.get(0).vertex.label+" to the rest of the locations are: \n");
        for (int i = 1; i < result.size(); i++) {
            if(result.get(i).d != Integer.MAX_VALUE && result.get(i).d > 0){
            System.out.print("Loc."+result.get(0).vertex.label+":");
            result.get(0).vertex.displayInfo();
            printPath(result,result.get(i));
            System.out.println("  route length: "+result.get(i).d);
            }
        }

    } 
    //--------------------------------------------------------------------------
    public QNode findElement(ArrayList <QNode> arr ,Vertex v){
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).vertex.equals(v))
                return arr.get(i);
        }
        return null;    
    }
    public void printPath(ArrayList <QNode> arr ,QNode z){
        if(z.vertex == z.parent) {
        }
        else{
            QNode p = findElement(arr,z.parent);
            printPath(arr,p);
            System.out.print(" Loc."+z.vertex.label+":");
            z.vertex.displayInfo();
        } 
    }
}