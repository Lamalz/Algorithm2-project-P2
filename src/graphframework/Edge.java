
package graphframework;

public class Edge {
    int weight;
    public Vertex source , destination;
    
    //constructor
    public Edge(){
                
    } 
    //constructor
    public Edge(Vertex source, Vertex destination,int weight) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }
    public void displayInfo(){
    System.out.println(source +" "+ destination +" "+weight);
    }

}