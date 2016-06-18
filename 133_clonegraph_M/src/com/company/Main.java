package com.company;

import java.util.*;

public class Main {
    private static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    ;

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
/*        // breadth first traversal
        if(node == null)
            return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> listOfFound
                = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        listOfFound.put(node,head);
        queue.add(node);

        while(!queue.isEmpty()) {
            UndirectedGraphNode curnode = queue.poll();
            for(UndirectedGraphNode aNeighbor: curnode.neighbors) {
                if(!listOfFound.containsKey(aNeighbor)){
                    queue.add(aNeighbor);
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(aNeighbor.label);
                    listOfFound.put(aNeighbor,neighborCopy);
                }
                listOfFound.get(curnode).neighbors.add(listOfFound.get(aNeighbor));
            }
        }
        return head;*/

        // depth first traversal -- recursive
/*        if(node == null)
            return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> listOfFound
                = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        listOfFound.put(node,head);
        DFS(listOfFound,node);
        return head;*/

        // depth first traversal -- no recursive use a stack to replace queue
        if(node == null)
            return null;

        HashMap<UndirectedGraphNode,UndirectedGraphNode> listOfFound
                = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        listOfFound.put(node,head);
        stack.push(node);

        while(!stack.isEmpty()){
            UndirectedGraphNode curnode = stack.pop();
            for(UndirectedGraphNode aNeighbor: curnode.neighbors) {
                if(!listOfFound.containsKey(aNeighbor)){
                    stack.push(aNeighbor);
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(aNeighbor.label);
                    listOfFound.put(aNeighbor,neighborCopy);
                }
                listOfFound.get(curnode).neighbors.add(listOfFound.get(aNeighbor));
            }
        }
        return head;
    }

    private static void DFS(HashMap<UndirectedGraphNode,UndirectedGraphNode> listOfFound,UndirectedGraphNode node) {
        if(node == null)
            return;

        for(UndirectedGraphNode aNeighbor: node.neighbors) {
            if(!listOfFound.containsKey(aNeighbor)) {
                UndirectedGraphNode neighborCopy = new UndirectedGraphNode(aNeighbor.label);
                listOfFound.put(aNeighbor,neighborCopy);
                DFS(listOfFound,aNeighbor);
            }
            listOfFound.get(node).neighbors.add(listOfFound.get(aNeighbor));
        }
    }
    public static void main(String[] args) {
        // write your code here
    }
}
