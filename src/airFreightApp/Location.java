
package airFreightApp;

import graphframework.Vertex;

public class Location extends Vertex {
    private String city;
    //constructor
    public Location(String label, boolean isVisited){
        super(label, isVisited);
        int num = (int) (1 + Math.random() * 10);
        this.city = " City "+ num;
    }
    //constructor
    public Location() {
        
    }
    // this method is overriden from Clas Vertex
    @Override
    public void displayInfo(){
        System.out.print(city+" -");
    }
}
    
