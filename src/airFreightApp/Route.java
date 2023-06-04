
package airFreightApp;

import graphframework.Edge;
import graphframework.Vertex;

public class Route extends Edge {
    //constructor
    public Route(Vertex source, Vertex destination,int weight){
        super(source,destination,weight);
    }
    //constructor
    public Route(){
        this.source = new Location(); 
        this.destination = new Location(); 
    }
    // this method is overriden from Clas Edge
    @Override
    public void displayInfo(){
        super.displayInfo();
    }
}
   
