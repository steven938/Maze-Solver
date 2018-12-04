import java.util.Iterator;
import java.util.Vector;

/**
 * My implementation of Graph:
 * A Vector of GraphNodes is used to store the nodes in the graph.
 * A 2D Vector (Matrix) containing GraphEdges is used to store the edges in the graph.
 */
public class Graph {
    private Vector<GraphNode> nodeList;
    private Vector<Vector<GraphEdge>> matrix;

    /**
     * Creates a graph with n nodes and no edges. This is the constructor for the class.
     * The names of the nodes are 0, 1, . . . , n−1.
     * @param n
     */
    Graph(int n){

    }

    /**
     *Adds an edge connecting u and
     * v and belonging to the specified bus line. This method throws a GraphException if either
     * node does not exist or if in the graph there is already an edge connecting the given nodes.
     * @param u
     * @param v
     * @param busLine
     */
    void insertEdge(GraphNode u, GraphNode v, char busLine) throws GraphException{

    }

    /**
     * Returns the node with the specified name. If no node with
     * this name exists, the method should throw a GraphException.
     * @param name
     * @return
     * @throws GraphException if name does not exist
     */
    GraphNode getNode(int name) throws GraphException{

    }

    /**
     *Returns a Java Iterator storing all
     * the edges incident on node u. It returns null if u does not have any edges incident on it.
     * @param u
     * @return
     * @throws GraphException if u or v are not nodes of graph
     */
    Iterator<GraphEdge> incidentEdges(GraphNode u){

    }

    /**
     * Returns the edge connecting nodes u
     * and v. This method throws a GraphException if there is no edge between u and v.
     * @param u
     * @param v
     * @return
     * @throws GraphException if u or v are not nodes of graph
     */
    GraphEdge getEdge(GraphNode u, GraphNode v) throws GraphException{

    }

    /**
     * Returns true if nodes u and v are
     * adjacent; it returns false otherwise.
     * @param u
     * @param v
     * @throws GraphException if u or v are not nodes of graph
     * @return
     */
    boolean areAdjacent(GraphNode u, GraphNode v) throws GraphException{

    }

}
