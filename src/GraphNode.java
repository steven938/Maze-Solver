public class GraphNode {
    private int name;
    private boolean mark;
    /**
     *  This is the constructor for the class and it creates an unmarked node
     * (see below) with the given name. The name of a node is an integer value between 0 and n−1,
     * where n is the number of nodes in the graph.
     *
     * A node can be marked with a value that is either true or false using method setMark. This
     * is useful when traversing the graph to know which vertices have already been visited.
     * @param name
     */
    GraphNode(int name){
        this.name = name;
        this.mark = false;
    }

    /**
     *Marks the node with the specified value.
     * @param mark
     */
    void setMark(boolean mark){
        this.mark = mark;
    }

    /**
     *  Returns the value with which the node has been marked.
     * @return
     */
    boolean getMark(){
        return mark;
    }

    /**
     * Returns the name of the node.
     * @return
     */
    int getName(){
        return name;
    }
}
