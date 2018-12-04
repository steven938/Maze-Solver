public class GraphEdge {
    private GraphNode node1, node2;
    private char busLine;
    /**
     * The first two parameters are the endpoints of the edge. The last parameter is the bus line to
     * which the street represented by the edge belongs. Each bus line has a name that consists of
     * a single character: Either a digit or a letter, except ’S’ and ’D’ which are used to mark the
     * starting point and the destination. For example ’a’, ’I’, and ’2’ might be the names of three
     * bus lines. Note that case matters, so a bus line might have name ’a’ and another might have
     * name ’A’. There might be bus lines called ’s’ or ’d’, but no bus line can be called ’S’ or ’D’.
     * @param u
     * @param v
     * @param busLine
     */
    GraphEdge(GraphNode u, GraphNode v, char busLine){
        this.node1 = u;
        this.node2 = v;
        this.busLine = busLine;
    }

    /**
     * Returns the first endpoint of the edge.
     * @return
     */
    GraphNode firstEndpoint(){
        return node1;
    }

    /**
     * Returns the second endpoint of the edge.
     * @return
     */
    GraphNode secondEndpoint(){
        return node2;
    }

    /**
     * Returns the name of the busLine to which the edge belongs.
     * @return
     */
    char getBusLine(){
        return busLine;
    }
}
