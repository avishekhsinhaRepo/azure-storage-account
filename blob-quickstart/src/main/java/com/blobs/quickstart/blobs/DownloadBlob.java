package com.blobs.quickstart.blobs;


import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;

import java.util.Date;

public class DownloadBlob {

    public void downloadBlob(BlobContainerClient blobContainerClient){
        BlobClient blobClient = blobContainerClient.getBlobClient("uhc-vpp.css");
        blobClient.downloadToFile(new Date().getTime()+"abc.css");
    }
}
