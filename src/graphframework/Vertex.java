
package graphframework;

import java.util.LinkedList;

public class Vertex {
    String label;
    boolean isVisited = false;
    public LinkedList <Edge> adjList;
    //constructor
    public Vertex(String label) {
        this.label = label;
    }
    //constructor
    public Vertex(String lable,boolean isVisted) {
        this.label = lable;
        this.isVisited =  isVisted;
        adjList = new LinkedList<>();
    }
    //constructor
    public Vertex() {
        adjList = new LinkedList<>();
    }
    public void displayInfo(){
   System.out.println(""+label+" "+isVisited+" "+adjList);
}
    public String getLabel() {
        return label;
    }    
}