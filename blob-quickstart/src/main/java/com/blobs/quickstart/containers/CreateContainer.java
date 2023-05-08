package com.blobs.quickstart.containers;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.PublicAccessType;

public class CreateContainer {
    private String containerName = null;
    private  BlobServiceClient blobServiceClient = null;

    public CreateContainer(String containerName, BlobServiceClient blobServiceClient) {
        this.containerName = containerName;
        this.blobServiceClient = blobServiceClient;
    }

    public BlobContainerClient createContainer(){
        BlobContainerClient blobContainerClient = this.blobServiceClient.createBlobContainerIfNotExists(containerName);
        return  blobContainerClient;
    }

//    public BlobContainerClient createContainerWithPublicAccess(){
//        BlobContainerClient blobContainerClient = this.blobServiceClient.c(containerName);
//        return  blobContainerClient;
   // }
}
