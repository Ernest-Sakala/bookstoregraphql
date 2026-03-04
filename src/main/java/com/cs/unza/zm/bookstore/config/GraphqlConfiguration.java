package com.cs.unza.zm.bookstore.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.GraphQLScalarType;
import static com.cs.unza.zm.bookstore.config.GraphqlMultipartHandler.SUPPORTED_RESPONSE_MEDIA_TYPES;
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.graphql.server.WebGraphQlHandler;
import org.springframework.http.MediaType;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;


@Configuration
public class GraphqlConfiguration {

    private final GraphQLFileUploader fileUploadDataFetcher;

    public GraphqlConfiguration(GraphQLFileUploader fileUploadDataFetcher) {
        this.fileUploadDataFetcher = fileUploadDataFetcher;
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return (builder) -> builder
                .type(newTypeWiring("Mutation").dataFetcher("uploadFile", fileUploadDataFetcher))
                .scalar(GraphQLScalarType.newScalar()
                        .name("Upload")
                        .coercing(new UploadCoercing())
                        .build());
    }

    @Bean
    @Order(1)
    public RouterFunction<ServerResponse> graphQlMultipartRouterFunction(
            GraphQlProperties properties,
            WebGraphQlHandler webGraphQlHandler,
            ObjectMapper objectMapper
    ) {
        String path = properties.getPath();
        RouterFunctions.Builder builder = RouterFunctions.route();
        GraphqlMultipartHandler graphqlMultipartHandler = new GraphqlMultipartHandler(webGraphQlHandler, objectMapper);
        builder = builder.POST(path, RequestPredicates.contentType(MULTIPART_FORM_DATA)
                .and(RequestPredicates.accept(SUPPORTED_RESPONSE_MEDIA_TYPES.toArray(MediaType[]::new))), graphqlMultipartHandler::handleRequest);
        return builder.build();
    }
}
