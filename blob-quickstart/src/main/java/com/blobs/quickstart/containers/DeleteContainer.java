package com.blobs.quickstart.containers;


import com.azure.storage.blob.BlobServiceClient;

public class DeleteContainer {
    public void deleteContainer(BlobServiceClient blobServiceClient, String containerName){
        blobServiceClient.deleteBlobContainer(containerName);
    }

}
