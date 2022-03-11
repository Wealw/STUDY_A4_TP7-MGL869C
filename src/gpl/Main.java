package gpl;
/**
 * GPL Example
 * Runtime variability and monolithic implementation
 *
 * @author Roberto E. Lopez-Herrejon
 * ETS-LOGTI
 */

import java.io.*;

/**
 * Main class for GPL example
 * @author Roberto E. Lopez-Herrejon
 */
public class Main {
    // ***********************************************************************
    // Definition of variables to indicate that a feature is selected or not
    // Core features, initialized to false because they must be set nonetheless in the configuration input/file
    
    /** Definition of arguments
     * [0] Name of Benchmark file
     * [1] Name of starting vertex, ex.  v0
     * [2] ... names of features that are selected for execution
     */
    public static void main(String[] args) {
        // Step 0: Verify consistency of product configuration
        displayConfigurationValues();
        System.out.println("Well formed configuration");
        // Step 1: create graph object
        Graph g = new Graph();
        // Step 2: sets up the benchmark file to read
        g.openBenchmark(args[0]);
        // Step 3: reads number of vertices, number of edges and weights
        int num_vertices = 0;
        int num_edges    = 0;
        try {
            num_vertices = g.readNumber();
            num_edges = g.readNumber();
            // ignores the additional description files
            g.readNumber();   // undirected, directed
            g.readNumber();   // self loops
            g.readNumber();   // unique
        } catch (IOException e) {
            System.out.println("Error while reading benchmark file configuration values");
            System.exit(0);
        }
        System.out.println("Benchmark file read");
        // Step 4: reserves space for vertices, edges and weights
        Vertex[] V             = new Vertex[num_vertices];
        int[]    startVertices = new int[num_edges];
        int[]    endVertices   = new int[num_edges];
        //#if Weighted
        int[] weights = new int[num_edges];
        //#endif
        // Step 5: creates the vertices objects
        int i = 0;
        for (i = 0; i < num_vertices; i++) {
            V[i] = new Vertex().assignName("v" + i);
            g.addVertex(V[i]);
        }
        // Step 6: reads the edges
        try {
            for (i = 0; i < num_edges; i++) {
                startVertices[i] = g.readNumber();
                endVertices[i] = g.readNumber();
            }
        } catch (IOException e) {
            System.out.println("Error while reading the edges");
            System.exit(0);
        }
        // Step 7: reads the weights
        //#if Weighted
        try {
            for (i = 0; i < num_edges; i++)
                weights[i] = g.readNumber();
        } catch (IOException e) {
            System.out.println("Error while reading the weigths");
            System.exit(0);
        }
        //#endif
        // Stops the benchmark reading
        g.stopBenchmark();
        // Step 8: Adds the edges
        for (i = 0; i < num_edges; i++) {
            //#if Weighted
            g.addAnEdge(V[startVertices[i]], V[endVertices[i]], weights[i]);
            //#else
//@                g.addAnEdge(V[startVertices[i]], V[endVertices[i]]);
            //#endif
        }
        // Executes the selected features
        Graph.startProfile();
        g.run(g.findsVertex(args[1]));
        Graph.stopProfile();
        g.display();
        Graph.resumeProfile();
        // End profiling
        Graph.endProfile();
    } // main
    
    
    /**
     * Shows the names of the selected features
     */
    private static void displayConfigurationValues() {
        StringBuffer configuration = new StringBuffer();
        //#if GPL
//@            configuration.append("GPL ");
        //#endif
        //#if PROG
//@            configuration.append("PROG ");
        //#endif
        //#if Bench
        configuration.append("BENCH ");
        //#endif
        //#if Undirected
//@            configuration.append("UNDIRECTED ");
        //#endif
        //#if Directed
        configuration.append("DIRECTED ");
        //#endif
        //#if Weighted
        configuration.append("WEIGHTED ");
        //#endif
        //#if DFS
//@            configuration.append("DFS ");
        //#endif
        //#if BFS
        configuration.append("BFS ");
        //#endif
        //#if Number
        configuration.append("NUMBER ");
        //#endif
        //#if Cycle
//@            configuration.append("CYCLE ");
        //#endif
        //#if Connected
//@            configuration.append("CONNECTED ");
        //#endif
        //#if StronglyConnected
//@            configuration.append("STRONGLYCONNECTED ");
        //#endif
        //#if MSTPrim
//@            configuration.append("MSTPRIM ");
        //#endif
        //#if MSTKruskal
//@            configuration.append("MSTKRUSKAL ");
        //#endif
        //#if Shortestpath
        configuration.append("SHORTESTPATH ");
        //#endif
        System.out.println("Input configuration: " + configuration);
    } // of displayConfigurationValues
}
