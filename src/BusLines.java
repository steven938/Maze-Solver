import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

public class BusLines {

    private Graph graph;
    private int width, length, maxChanges;
    private int start, end;
    private int numChanges = 0;

    /**
     * Constructor for building a city map with its bus lines from
     * the input file. If the input file does not exist, this method should throw a MapException.
     * Read below to learn about the format of the input file.
     * @param inputFile
     * @throws MapException
     */
    public BusLines(String inputFile) throws MapException {
        try(BufferedReader in = new BufferedReader(new FileReader(inputFile))) {
            String line1 = in.readLine();
            String[] props = line1.split(" ");
            if(props.length < 4) {
                throw new MapException("Error reading first line of input file");
            }

            width = Integer.parseInt(props[1]);
            length = Integer.parseInt(props[2]);
            maxChanges = Integer.parseInt(props[3]);
            int counter = 0;
            int numline = 0;
            graph = new Graph(width * length);

            while((line1 = in.readLine()) != null) {
                String line2 = in.readLine();
                if(line2 != null && line1.length() != line2.length()) {
                    throw new MapException("Error due to lines having inconsistent length");
                }

                for(int i = 0; i < line1.length(); i++) {
                    if(i % 2 == 0) {
                        if(line2 != null) {
                            char c = line2.charAt(i);
                            if(c != ' ') {
                                graph.insertEdge(new GraphNode(counter), new GraphNode(counter + width), c);
                            }
                        }
                        if(line1.charAt(i) == 'S')
                            start = numline * width + i/2;
                        else if(line1.charAt(i) == 'D')
                            end = numline * width + i/2;
                    } else {
                        char c = line1.charAt(i);
                        if(c != ' ') {
                            graph.insertEdge(new GraphNode(counter), new GraphNode(counter + 1), c);
                        }
                        counter++;
                    }
                }
                counter++;
                numline++;
                if(line2 == null) {
                    break;
                }
            }
        } catch (IOException | GraphException e) {
            throw new MapException(e.getMessage());
        }
    }

    /**
     * Returns the graph representing the map. This method throws a MapException
     * if the graph could not be created.
     * @return
     * @throws MapException
     */
    public Graph getGraph() throws MapException {
        return graph;
    }

    /**
     * Returns a Java Iterator containing the nodes along the path
     * from the starting point to the destination, if such a path exists. If the path does not exist,
     * this method returns the value null. For example for the map and path described above the
     * Iterator returned by this method should contain the nodes 0, 1, 5, 6, and 10.
     * @return
     */
    public Iterator<GraphNode> trip() {
        Stack<GraphNode> path = new Stack<>();
        int numChanges = 0;
        findPath(start, path);
        if(path.isEmpty())
            return null;
        return path.iterator();
    }

    private void findPath(int name, Stack<GraphNode> path){
        try{
            if(!path.isEmpty() && path.peek().getName() == end)
                return;
            GraphNode current = graph.getNode(name);
            current.setMark(true);
            path.push(current);
            if(current.getName()==end)
                return;
            Iterator<GraphEdge> adjNodes = graph.incidentEdges(current);
            while(adjNodes.hasNext()){
                GraphEdge edge = adjNodes.next();
                if(changeBus(edge.getBusLine(), path)){
                    if(numChanges+1 > maxChanges)
                        continue;
                }
                GraphNode nextNode = (edge.firstEndpoint().getName()!=name) ? edge.firstEndpoint(): edge.secondEndpoint();
                if(graph.getNode(nextNode.getName()).getMark())
                    continue;
                findPath(nextNode.getName(), path);
            }
            graph.getNode(name).setMark(false);
            path.pop();
            if(!path.isEmpty()){ // FIX
                GraphEdge DeletedEdge = graph.getEdge(new GraphNode(name), path.peek()); // FIX
                if(changeBus(DeletedEdge.getBusLine(), path)) // FIX
                    numChanges--; // FIX
            }
        }catch (GraphException e){
            ;
        }
    }

    /**
     * Returns True if the current bus is a different from the previous bus line
     * Returns False if the current bus line is the same as the previous bus line
     * @param currentBusLine
     * @param path
     * @return
     */
    private boolean changeBus(char currentBusLine, Stack<GraphNode> path) throws GraphException {
        if(path.empty())
            return false;
        GraphNode prev = path.pop();
        if(path.isEmpty()){
            path.push(prev);
            return false;
        }
        GraphEdge edge = graph.getEdge(prev, path.peek());
        path.push(prev);
        return(edge.getBusLine() != currentBusLine);
    }

}

