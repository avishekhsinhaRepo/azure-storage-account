package com.blobs.quickstart.containers;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.models.BlobContainerProperties;

import java.util.HashMap;
import java.util.Map;


public class ContainerMetaData {
    public void addContainerMetaData(BlobContainerClient blobContainerClient){
        Map<String, String> metadata = new HashMap<>();
        metadata.put("doctype","text");
        metadata.put("category", "reference");
        blobContainerClient.setMetadata(metadata);
    }
    public void readContainerMetaData(BlobContainerClient blobContainerClient){
        BlobContainerProperties properties = blobContainerClient.getProperties();
        properties.getMetadata().entrySet().forEach(metadataItem -> {
            System.out.printf(" %s = %s%n", metadataItem.getKey(), metadataItem.getValue());
        });
    }
}
