package data_structures;

/**
 * Created by tmsbn on 7/9/16.
 */
public class GraphNode {

    public GraphNode(Object name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public GraphNode(Object name) {
        this.name = name;
    }

    Object name;
    int weight;


}
