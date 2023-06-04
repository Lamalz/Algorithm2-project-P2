
package graphframework;

import java.util.Comparator;
// this calss is used bey the Dijkstra algorithm
public class QNode {
    Vertex vertex;
    Vertex parent;
    int d;
}
// helps to compare the d in QNode objects to arrange them
class QNodeComparator implements Comparator<QNode>{

    @Override
    public int compare(QNode q1, QNode q2) {
         if(q1.d > q2.d){
             return 1;
         }
         else if (q1.d < q2.d){
             return -1;
         }
       return 0;          
    }
    
} 
