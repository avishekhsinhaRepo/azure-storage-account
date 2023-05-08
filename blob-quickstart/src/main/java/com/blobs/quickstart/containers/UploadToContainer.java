package com.blobs.quickstart.containers;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.blobs.quickstart.StorageConstants;

import java.io.File;
import java.util.Arrays;

public class UploadToContainer {
    public void uploadFilesToContainer(BlobContainerClient blobContainerClient){
        File dataFolder  = new File(StorageConstants.LOCAL_PATH);
        File[]  fileList = dataFolder.listFiles();
        for (File file: fileList) {
            BlobClient blobClient = blobContainerClient.getBlobClient(file.getName());
            blobClient.uploadFromFile(file.getPath());
        }


    }
}
