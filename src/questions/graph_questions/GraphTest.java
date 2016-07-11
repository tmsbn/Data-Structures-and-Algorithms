package questions.graph_questions;

import base.DSABase;
import base.GraphQuestions;
import data_structures.Graph;

/**
 * Created by tmsbn on 7/9/16.
 */
public class GraphTest extends GraphQuestions implements DSABase {

    @Override
    public void execute() {

        Graph graph = new Graph();
        graph.addNode('A');
        graph.addNode('B');
        graph.addNode('C');
        graph.addNode('D');
        graph.addNode('E');
        graph.addNode('F');

        graph.addEdge('A', 'B', 5);
        graph.addEdge('A', 'D', 9);
        graph.addEdge('A', 'E', 2);
        graph.addEdge('B', 'C', 2);
        graph.addEdge('C', 'D', 3);
        graph.addEdge('D', 'F', 2);
        graph.addEdge('E', 'F', 3);


        graph.printGraph();
        graph.findShortestDistanceFromSource('A');


    }
}
