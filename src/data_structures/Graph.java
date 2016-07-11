package data_structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tmsbn on 7/9/16.
 */
public class Graph {

    private Map<Object, ArrayList<GraphNode>> graphData = new HashMap<>();

    public void addNode(Object object) {

        if (graphData.get(object) == null)
            graphData.put(object, new ArrayList<GraphNode>());
        else
            throw new IllegalArgumentException("This node already exists");
    }

    public void addEdge(Object src, Object dest, int weight) {

        if (graphData.get(src) == null) {
            throw new IllegalArgumentException("Source does not exist");
        } else if (graphData.get(dest) == null) {
            throw new IllegalArgumentException("Destination does not exist");
        } else {
            addAdjacencyNode(graphData.get(src), dest, weight);
            addAdjacencyNode(graphData.get(dest), src, weight);

        }
    }


    public void findShortestDistanceFromSource(Object sourceVertex) {

        if (graphData.get(sourceVertex) == null) {
            System.out.println("Cannot find vertex in graphData");

        } else {


            //We will use hash map to store the distance and parentgit  information
            HashMap<Object, NodeInfo> nodeInfoMap = new HashMap<>();

            for (Object key : graphData.keySet()) {
                NodeInfo nodeInfo = new NodeInfo();
                if (key == sourceVertex) {
                    nodeInfo.distance = 0;
                }
                nodeInfoMap.put(key, nodeInfo);

            }

            while (true) {

                //get node with minimum distance
                Object minKey = getMinUnvisited(nodeInfoMap);

                //If all nodes are visited, then break out of the while loop
                if (minKey == null) break;

                //get the minimum distance node and set visited as true
                NodeInfo sourceNoteInfo = nodeInfoMap.get(minKey);
                sourceNoteInfo.visited = true;

                //get adjacent nodes of source node
                ArrayList<GraphNode> nodes = graphData.get(minKey);

                for (GraphNode graphNode : nodes) {
                    NodeInfo nodeInfo = nodeInfoMap.get(graphNode.name);

                    //update the distance of adjacent nodes
                    if (!nodeInfo.visited && nodeInfo.distance > graphNode.weight + sourceNoteInfo.distance) {
                        nodeInfo.distance = graphNode.weight + sourceNoteInfo.distance;
                        nodeInfo.parent = minKey;
                    }


                }
            }

            for (Object key : nodeInfoMap.keySet()) {
                System.out.print(key + ":" + nodeInfoMap.get(key).distance + ":  ");
                Object parentKey = nodeInfoMap.get(key).parent;
                boolean sep = false;
                while (parentKey != null) {
                    if (sep)
                        System.out.print(" < ");
                    System.out.print(parentKey);
                    parentKey = nodeInfoMap.get(parentKey).parent;
                    sep = true;
                }
                System.out.println();

            }
        }


    }

    private Object getMinUnvisited(HashMap<Object, NodeInfo> nodeInfoMap) {

        int minDistance = Integer.MAX_VALUE;
        Object minKey = null;
        for (Object key : nodeInfoMap.keySet()) {

            //To find the node with the least distance which is also not visited
            if ((minDistance > nodeInfoMap.get(key).distance && !nodeInfoMap.get(key).visited)) {
                minKey = key;
                minDistance = nodeInfoMap.get(key).distance;
            }

        }
        return minKey;
    }

    private static class NodeInfo {

        boolean visited = false;
        int distance = Integer.MAX_VALUE;
        Object parent;

    }

    private void addAdjacencyNode(ArrayList<GraphNode> graphNodes, Object name, int weight) {

        GraphNode graphNode = null;
        for (GraphNode node : graphNodes) {
            if (node.name == name) {
                graphNode = node;
                break;
            }
        }

        if (graphNode != null) {
            graphNode.name = name;
            graphNode.weight = weight;
        } else {
            graphNodes.add(new GraphNode(name, weight));
        }
    }

    public void printGraph() {

        if (graphData.isEmpty()) {
            System.out.println("The graphData is empty");
            return;
        }

        for (Map.Entry<Object, ArrayList<GraphNode>> entry : graphData.entrySet()) {

            boolean comma = false;
            System.out.print(entry.getKey() + " : ");

            for (GraphNode node : entry.getValue()) {

                if (comma)
                    System.out.print(" > ");

                System.out.print(node.name + "(" + node.weight + ")");
                comma = true;
            }
            System.out.println();


        }
    }

    public int getSize() {

        return graphData.size();
    }

}
