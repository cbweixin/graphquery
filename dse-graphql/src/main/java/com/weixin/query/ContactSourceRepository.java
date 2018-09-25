package com.weixin.query;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.List;
import java.util.Map;

public class ContactSourceRepository {

    private GraphTraversalSource g = null;

    public ContactSourceRepository() {
        g = TraversalSource.getTraversalSource();
    }

    public ContactSource getContactSource(String sourceId, String sourceType) {
        GraphTraversal<Vertex, Map<String, List<String>>> a = g.V().hasLabel("contactSource").has("sourceType", sourceType).
                has("sourceId", sourceId).valueMap();

        ContactSource contactSource = null;

        while (a.hasNext()) {
            Map<String, List<String>> m = a.next();
            if (!m.isEmpty()) {
                contactSource = new ContactSource(sourceId, sourceType, m.get("realmId").get(0), m.get("entityType").get(0), m.get("displayName").get(0));
            }
        }


        return contactSource;

    }


}


