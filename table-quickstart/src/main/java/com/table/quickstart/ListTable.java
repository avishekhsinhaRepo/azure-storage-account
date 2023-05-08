package com.table.quickstart;

import com.azure.data.tables.TableServiceClient;

public class ListTable {
    public void listTables(TableServiceClient tableServiceClient){
        tableServiceClient.listTables().forEach(tableItem -> System.out.println(tableItem.getName()));
    }
}
