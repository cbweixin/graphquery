package com.weixin.query;

import com.datastax.driver.core.exceptions.NoHostAvailableException;
import com.datastax.driver.dse.DseCluster;
import com.datastax.driver.dse.DseSession;
import com.datastax.driver.dse.graph.GraphOptions;
import com.datastax.dse.graph.api.DseGraph;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;

import java.net.InetSocketAddress;
import java.util.Map;

/**
 * singleton
 */
public enum TraversalSource {

    INSTANCE;

    private GraphTraversalSource g = null;
    private DseCluster cluster = null;
    private DseSession session = null;

    private void prepare() {
        if (cluster == null) {
            try {
                cluster = DseCluster.builder()
                        .withCredentials("cassandra", "cassandra")
                        .withPort(19042)
                        .withSSL()
                        .addContactPoint("127.0.0.1")
                        .build();
                session = cluster.connect();
                g = DseGraph.traversal(session, new GraphOptions().setGraphName("sbg_graph_prod"));
            } catch (NoHostAvailableException nex) {
                for (Map.Entry<InetSocketAddress, Throwable> entry : nex.getErrors().entrySet()) {
                    System.out.format("host : %s and reason : %s\n", entry.getKey().toString(), entry.getValue().getMessage());
                    entry.getValue().printStackTrace();
                }

            }
        }
    }


    public static GraphTraversalSource getTraversalSource() {
        if (INSTANCE.g == null) {
            INSTANCE.prepare();
        }
        return INSTANCE.g;
    }

    public static void cleanUp() {
        INSTANCE.session.close();
        INSTANCE.cluster.close();
    }
}
