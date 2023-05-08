package com.table.quickstart;


import com.azure.data.tables.TableClient;
import com.azure.data.tables.TableServiceClient;
import com.azure.data.tables.TableServiceClientBuilder;
import com.azure.data.tables.models.TableEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String storageAccountConnectionString = System.getenv("AZURE__TABLE_STORAGE_CONNECTION_STRING");
        System.out.println(storageAccountConnectionString);
        TableServiceClient tableServiceClient = new TableServiceClientBuilder().connectionString(storageAccountConnectionString).buildClient();
        tableServiceClient.createTableIfNotExists(TableConstants.TABLE_NAME);
        TableClient tableClient = tableServiceClient.getTableClient(TableConstants.TABLE_NAME);
        ListTable listTable= new ListTable();
        listTable.listTables(tableServiceClient);

        String partitionKey="India";
        String rowKey="C001";
        Map<String, Object>  customerInfo = new HashMap<>();
        customerInfo.put("firstName","Avi");
        customerInfo.put("lastName","Sinha");
        customerInfo.put("Email", "avishekh.sinha@gmail.com");
        TableEntity customer = new TableEntity(partitionKey,rowKey).setProperties(customerInfo);
        tableClient.upsertEntity(customer);
        tableClient.listEntities().forEach(tableEntity -> System.out.println(tableEntity.getPartitionKey() +" "+tableEntity .getRowKey() + " "
        +tableEntity.getProperty("firstName")+" "+ tableEntity.getProperty("lastName")+" "+tableEntity.getProperty("Email")));
    }
}
