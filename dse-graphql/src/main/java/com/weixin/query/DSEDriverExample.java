package com.weixin.query;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.List;
import java.util.Map;

public class DSEDriverExample {
    public static void main(String[] args) {
        GraphTraversalSource g = TraversalSource.getTraversalSource();
        GraphTraversal<Vertex, Map<String, List<String>>> a = g.V().hasLabel("contactSource").has("sourceType", "QBO").
                has("sourceId", "193514499191784.000000000").valueMap();

        while (a.hasNext()) {
            Map<String, List<String>> m = a.next();
            if (!m.isEmpty()) {
                for (String key : m.keySet()) {
                    String value = m.get(key).get(0);
                    System.out.println("key : " + key + " value : " + value);
                }
            }
        }

    }
}
