package com.leetcode.one.three;

import com.leetcode.util.UndirectedGraphNode;

import java.util.*;

public class Three {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);

        List<UndirectedGraphNode> list = new ArrayList<>();
        while (!q.isEmpty()){
            UndirectedGraphNode n = q.poll();
            if(!map.containsKey(n)){
                UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
                map.put(n,newNode);
                for(UndirectedGraphNode next : n.neighbors){
                    if(!map.containsKey(next)) q.offer(next);
                }
                list.add(n);
            }
        }

        q.add(node);

        for(UndirectedGraphNode n : list){
            UndirectedGraphNode mapped = map.get(n);
            mapped.neighbors = new ArrayList<>();
            for(UndirectedGraphNode nei : n.neighbors){
                mapped.neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }
}
