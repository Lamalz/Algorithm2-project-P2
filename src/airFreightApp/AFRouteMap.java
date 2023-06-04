
package airFreightApp;

import graphframework.Edge;
import graphframework.Graph;
import graphframework.Vertex;
import java.util.ArrayList;

// Calss AFRouteMap contains the methods createVertex & createEdge that was overriden from Class Graph
public class AFRouteMap extends Graph{
    @Override
    public Vertex createVertex(ArrayList <Vertex> vertices,String label,boolean isVisited){
        Vertex v;
        // to make sure a vertex doesnt enter the array more than one time
        for (int i = 0; i < vertices.size(); i++) {
            if(vertices.get(i).getLabel().equals(label)){
                    v = vertices.get(i);
                    return v;
            }
        }       
        v = new Location(label,isVisited);
        vertices.add(v); 
        return v; 
        }
    
    @Override
    public Edge createEdge(Vertex v, Vertex u,int w){
        return new Route(v,u,w);
    }
    
}
