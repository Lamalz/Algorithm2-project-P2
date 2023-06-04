
package graphframework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Class Graph should have createVertex() & createEdge() methods that need to be overridden by Location & Route subclasses.

public abstract class  Graph {
    int verticesNo;
    int edgeNo;
    boolean isDigraph;
    ArrayList <Vertex> vertices;
    //----------------------------------------------------------------------
    public Graph() {
        
    }
    public Graph(int verticesNo, int edgeNo, ArrayList<Vertex> vertices) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.vertices = vertices;
    }  
    //---------------------------------------------------------------------
    public void makeGraph(int verticesNo,int edgeNo){
        isDigraph = true;
        vertices= new ArrayList<>();
        setData(verticesNo,edgeNo,vertices);
        
        //creating verticesNo of vertices  
        for (int i = 0; i < verticesNo; i++) {
            Vertex v = createVertex(vertices,Integer.toString(i),false);     
        }
        //adding edges between all vertices to make sure it is connected  
        //and give them random weights from 1 - 40
        for (int i = 0; i < verticesNo - 1; i++) {
            int w = (int) (1 + Math.random() * 40);
            addEdge(vertices.get(i), vertices.get(i + 1), w); 
        }
        //adding the remaining edges between 2 random vertices
        int remEdges = edgeNo - (verticesNo - 1);
        for (int i = 0; i < remEdges; i++) {
            // randomly select two vertices to create an edge between them
            Vertex v = vertices.get((int)( Math.random() * verticesNo));
            Vertex u = vertices.get((int)( Math.random() * verticesNo));
            int w = (int) (1 + Math.random() * 40); // random weight
            
            // if the edge already exits between the two vertices then skip this iteration
            if(v.getLabel().equals(u.getLabel())){
                i--;
                continue;
            }  
            // if the edge is between the same vertex then skip this iteration
            boolean flag = false;
            for (int j = 0; j < v.adjList.size(); j++) {
                if(v.adjList.get(j).destination.getLabel().equals(u.getLabel())){
                    i--;
                    flag = true;
                }
            }
            if(flag){
                continue;
            }
            
            // add an edge between them
            addEdge(v, u, w);
        }
        // to print the adjeceny list of the random graph
        /*for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i).getLabel());
            for (int j = 0; j < vertices.get(i).adjList.size(); j++) {
                System.out.print("--->"+vertices.get(i).adjList.get(j).destination.label);
            }
            System.out.println();
        }*/        
    }
    //----------------------------------------------------------------------
    public void readGraphFromFile() throws FileNotFoundException{  
        
        //create file object
        File file = new File("C:\\Users\\U\\Documents\\Ninth semester\\خوارزم 2\\AlgorithmProjectPart2\\src\\graphframework\\graph.txt");
        try{
            //scanner
            Scanner input = new Scanner(file);
            String aa= input.nextLine();
            if (aa.equalsIgnoreCase("digraph 0")){
                isDigraph=false;
            }
            else{
                isDigraph=true;
            }
            
        //read verts and edges number from file
        verticesNo= input.nextInt();
        edgeNo= input.nextInt(); 
        //create array list reprsenting the list of vertcies 
        vertices= new ArrayList<>();
        
        //place data in graph object
        setData(verticesNo,edgeNo,vertices);
        //Graph graph = new Graph (verticesNo,edgeNo,vertices);
        
        while(input.hasNext()){
            String v = input.next();
            Vertex v1 = createVertex(vertices,v, false);
            
            String u = input.next();
            Vertex u1 = createVertex(vertices,u, false);
            
            int w = input.nextInt();
            
            addEdge(v1,u1,w); 
        }
        // to print the adjeceny list of the read graph
        /*for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i).getLabel());
            for (int j = 0; j < vertices.get(i).adjList.size(); j++) {
                System.out.print("--->"+vertices.get(i).adjList.get(j).destination.label);
            }
            System.out.println();
        }*/ 
        
        }catch(FileNotFoundException ex){
            System.out.println("not found");
        }
    } 
    public void addEdge(Vertex v, Vertex u, int w){
        Edge line = createEdge(v,u,w);
        v.adjList.add(line);
        if(!isDigraph){
            Edge line2 = createEdge(u,v,w);
            u.adjList.add(line2);
        }
    }
    public abstract Vertex createVertex(ArrayList <Vertex> vertices,String label,boolean isVisited);
    
    public abstract Edge createEdge(Vertex v, Vertex u,int w);
    
///////////////////////////////////////////////////////////////
    public void setData(int verticesNo,int edgeNo,ArrayList<Vertex> vertices) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.vertices = vertices;
    }
}


