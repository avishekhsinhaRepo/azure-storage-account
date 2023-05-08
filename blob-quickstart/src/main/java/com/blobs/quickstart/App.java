package com.blobs.quickstart;

import com.azure.storage.blob.*;
import com.blobs.quickstart.blobs.DownloadBlob;
import com.blobs.quickstart.containers.ContainerMetaData;
import com.blobs.quickstart.containers.CreateContainer;
import com.blobs.quickstart.containers.ListContainer;
import com.blobs.quickstart.containers.UploadToContainer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String storageAccountConnectionString = System.getenv("AZURE_STORAGE_CONNECTION_STRING");
        BlobServiceClient  blobServiceClient = new BlobServiceClientBuilder().connectionString(storageAccountConnectionString).buildClient();
        // Create the container and return a container client object
        CreateContainer createContainer = new CreateContainer(StorageConstants.CONTAINER_NAME, blobServiceClient);
        BlobContainerClient blobContainerClient =createContainer.createContainer();
        // List blobs in container
        ListContainer listContainer = new ListContainer();
        listContainer.listContainerBlob(blobContainerClient);
        // Upload File to Container fromn local folder
        UploadToContainer uploadToContainer = new UploadToContainer();
        //uploadToContainer.uploadFilesToContainer(blobContainerClient);

        ContainerMetaData containerMetaData = new ContainerMetaData();
        containerMetaData.addContainerMetaData(blobContainerClient);
        containerMetaData.readContainerMetaData(blobContainerClient);
        // Download file to a local folder
        DownloadBlob downloadBlob  = new DownloadBlob();
        downloadBlob.downloadBlob(blobContainerClient);
        //CreateContainer createPublicContainer = new CreateContainer(StorageConstants.CONTAINER_NAME_WITH_PUBLIC_ACCESS, blobServiceClient);
        //BlobContainerClient blobContainerClientPublic = createPublicContainer.createContainerWithPublicAccess();


    }
}
