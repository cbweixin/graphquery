package com.weixin.query;


import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import org.jetbrains.annotations.NotNull;

import javax.servlet.annotation.WebServlet;


@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    @NotNull
    private static GraphQLSchema buildSchema() {
        ContactSourceRepository contactSourceRepository = new ContactSourceRepository();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(contactSourceRepository))
                .build()
                .makeExecutableSchema();
    }
}