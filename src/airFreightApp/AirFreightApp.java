/*
 * Algorithm 2 project part 2
 * Date: 4 june 2023
 */
package airFreightApp;


import graphframework.DBAllSourceSPAlg;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AirFreightApp {
    
      public static void main(String[] args) throws FileNotFoundException {
      Scanner readFrom = new Scanner(System.in);

        // welcome msg 
        System.out.println( "\t\t\t\tWELCOME TO OUR SYSTEM\n"
                + " Where we will compute the shortest path between every pair of locations using Dijkstra algorithm \n");

        System.out.println("\t\t  (1) Requirement 1 Using ReadfromGraph()  \n"
                + "\t\t  (2) Requirement 2 Using MakeGraph()      \n");

        // Read User Input for the Selected Requirement 
        System.out.print("Select Requirement Number :   ");

        int userInput = readFrom.nextInt(); // read from user Option of the Requirement
        
        
        // make sure user enter within option
        while (userInput != 1 && userInput != 2) {
            System.out.println("Wrong Selection. ");
            System.out.print("Select Requirement Number : ");
            userInput = readFrom.nextInt();
        }
        
        // create object of AFRouteMap
        AFRouteMap map = new AFRouteMap();
        
        //Requirement 1: read from file
        if (userInput == 1) {
            map.readGraphFromFile();
            DBAllSourceSPAlg s = new DBAllSourceSPAlg();
            s.computeDijkstraBasedSPAlg(map);    
         }// End of Requirement 1
         
        //Requirement 2: make garph 
        else if (userInput == 2) {
           map.makeGraph(20,30);
           Long start= System.nanoTime();
           DBAllSourceSPAlg s = new DBAllSourceSPAlg();
           s.computeDijkstraBasedSPAlg(map);    
           Long duration = (System.nanoTime() - start)/1000000;
           System.out.println("Time: "+duration +"ms"); 
        }// End of Requirement 2
        readFrom.close();
      }
}
