package gpl;
/**
 * GPL Example
 * Runtime variability and monolithic implementation
 *
 * @author Roberto E. Lopez-Herrejon
 * ETS-LOGTI
 */
// Note: Code for UNDIRECTED and DIRECTED is the same. Changes at places are only when graphs have weights.
// *************************************************************************

/**
 * Class the represents the edges of the graph
 *
 * @author rlopez
 */
public class Edge extends Neighbor {
    public Vertex start;
    //#if Weighted
    public int weight;
    
    public Edge(Vertex the_start, Vertex the_end) {
        start = the_start;
        end = the_end;
    }
    
    public Edge(Vertex the_start, Vertex the_end, int the_weight) {
        this(the_start, the_end);
        weight = the_weight;
    }
    
    public void adjustAdorns(Edge the_edge) {
        //#if Weighted
        weight = the_edge.weight;
        //#endif
    }
    
    public void display() {
        System.out.print(" start=" + start.name + " end=" + end.name);
        //#if Weighted
        System.out.print(" weight=" + weight);
        //#endif
        System.out.println();
    }
    //#endif
    
    public String toString() {
        String result = " start=" + start.name + " end=" + end.name;
        //#if Weighted
        result = result + " weight=" + weight;
        //#endif       
        return result;
    }
} // of Edge
