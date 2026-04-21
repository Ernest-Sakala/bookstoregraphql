package com.cs.unza.zm.bookstore.config.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class GraphQLFileUploader implements DataFetcher<String> {
    private final FileStorageService fileStorageService;

    public GraphQLFileUploader(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @Override
    public String get(DataFetchingEnvironment environment) {
        MultipartFile file = environment.getArgument("file");
        
        String storedFilePath = fileStorageService.store(file);
        return String.format("File stored at: %s", storedFilePath);
    }
}