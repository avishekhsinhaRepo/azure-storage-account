package com.blobs.quickstart.containers;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.models.BlobItem;

public class ListContainer {

    public void listContainerBlob(BlobContainerClient blobContainerClient){
        PagedIterable<BlobItem>  blobItems = blobContainerClient.listBlobs();
        for(BlobItem blobItem : blobItems){
            System.out.println(blobItem.getName());
        }
    }
}
