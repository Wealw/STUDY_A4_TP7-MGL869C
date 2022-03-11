//#condition Number

package gpl;


/**
 * GPL Example
 * Runtime variability and monolithic implementation
 *
 * @author Roberto E. Lopez-Herrejon
 * ETS-LOGTI
 */

public class NumberWorkSpace extends WorkSpace {
    int vertexCounter;
    
    public NumberWorkSpace() {
        vertexCounter = 0;
    }
    
    public void preVisitAction(Vertex v) {
        // This assigns the values on the way in
        if (!v.visited)
            v.VertexNumber = vertexCounter++;
    }
}
