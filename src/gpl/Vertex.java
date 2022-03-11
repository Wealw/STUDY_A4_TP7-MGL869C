package gpl;
/**
 * GPL Example
 * Runtime variability and monolithic implementation
 *
 * @author Roberto E. Lopez-Herrejon
 * ETS-LOGTI
 */
// undirected and Directed have the same code


import java.util.LinkedList;
import java.util.Objects;
// *********************************************************************

/**
 * Class the represents the vertices of the graph
 * @author rlopez
 *
 */
public class Vertex {
    //#if BFS
    static LinkedList<Vertex> Queue = new LinkedList<Vertex>();
    public LinkedList<Neighbor> neighbors;
    public String               name;
//    public void VertexConstructor() {
//  
//    }
    //#if BFS || DFS
    public boolean visited;
    //#if Number
    public int VertexNumber;
    //#if Shortestpath
    public String predecessor; // the name of the predecessor if any
    public int    dweight; // weight so far from s to it
    
    public Vertex() {
        name = null;
        neighbors = new LinkedList<Neighbor>();
        //#if BFS || DFS
        visited = false;
        //#endif
    }
    
    public Vertex assignName(String name) {
        this.name = name;
        return this;
    }
    //#endif
    
    public void addNeighbor(Neighbor n) {
        neighbors.add(n);
    }
    
    public boolean equals(Object o) {
        boolean result = false;
        if (!(o instanceof Vertex v))
            return false;
        if (Objects.equals(v.name, this.name))
            result = true;
        return result;
    }
    //#endif
    //#if DFS
//@        
//@        public void dftNodeSearch(WorkSpace w) {
//@            Vertex v;
//@            // Step 1: Do preVisitAction.
//@            // If we've already visited this node return
//@            w.preVisitAction(this);
//@            if (visited)
//@                return;
//@            // Step 2: else remember that we've visited and
//@            //         visit all neighbors
//@            visited = true;
//@            for (Neighbor n : neighbors) {
//@                v = n.end;
//@                w.checkNeighborAction(this, v);
//@                v.dftNodeSearch(w);
//@            }
//@            // Step 3: do postVisitAction now
//@            w.postVisitAction(this);
//@        } // of dftNodeSearch
//@        
    //#endif
    
    public void display() {
        //#if Shortestpath
        System.out.print("Pred " + predecessor + " DWeight " + dweight + " ");
        //#endif
        //#if StronglyConnected
//@
//@            System.out.print(" FinishTime -> " + finishTime + " SCCNo -> " + strongComponentNumber);
//@
        //#endif
        //#if Connected
//@            System.out.print(" comp# " + componentNumber + " ");
//@
        //#endif
        //#if MSTKruskal
//@            if (representative == null)
//@                System.out.print("Rep null ");
//@            else
//@                System.out.print(" Rep " + representative.name + " ");
//@
        //#endif
        //#if MSTPrim
//@
//@            System.out.print(" Pred " + pred + " Key " + key + " ");
//@
        //#endif
        //#if Cycle
//@
//@            System.out.print(" VertexCycle# " + VertexCycle + " ");
//@
        //#endif
        //#if Number
        System.out.print(" # " + VertexNumber + " ");
        //----
        //#endif
        //#if BFS
        if (visited)
            System.out.print("  visited ");
        else
            System.out.println(" !visited ");
        //#endif
        System.out.print(" Node " + name + " connected to: ");
        for (Neighbor theNeighbor : neighbors) {
            //#if Undirected
//@
//@                System.out.print(theNeighbor.end.name + ", ");
//@
            //#endif
            //#if Directed
            Vertex v = theNeighbor.end;
            System.out.print(v.name + ", ");
            //#endif
        } // for all the vertices
        System.out.println();
    } // of display
    //#endif
    //#if Cycle
//@        
//@        public int VertexCycle;
//@        public int VertexColor; // white ->0, gray ->1, black->2
//@        
    //#endif
//#if MSTPrim
//@    
//@    public String pred; // the predecessor vertex if any
//@    public int    key; // weight so far from s to it
//@    
//#endif
    //#if MSTKruskal
//@        
//@        public Vertex             representative;
//@        public LinkedList<Vertex> members;
//@        
    //#endif
    //#if Connected
//@        
//@        public int componentNumber;
//@        
    //#endif
    //#if StronglyConnected
//@        
//@        public int finishTime;
//@        public int strongComponentNumber;
//@        
    //#endif
    
    public void init_vertex(WorkSpace w) {
        visited = false;
        w.init_vertex(this);
    }

    public void bftNodeSearch(WorkSpace w) {
        Vertex v;
        Vertex header;
        // Step 1: if preVisitAction is true or if we've already
        //         visited this node
        w.preVisitAction(this);
        if (visited)
            return;
        // Step 2: Mark as visited, put the unvisited neighbors in the queue
        //     and make the recursive call on the first element of the queue
        //     if there is such if not you are done
        visited = true;
        // Step 3: do postVisitAction now, you are no longer going through the
        // node again, mark it as black
        w.postVisitAction(this);
        // enqueues the vertices not visited
        for (Neighbor n : neighbors) {
            v = n.end;
            // if the neighbor has not been visited then enqueue
            if (!v.visited)
                Queue.add(v);
        }
        // while there is something in the queue
        while (Queue.size() != 0) {
            header = Queue.get(0);
            Queue.remove(0);
            header.bftNodeSearch(w);
        } // while there is a vertex pending to visit
    } // of bfsNodeSearch
    //#endif
} // class Vertex
