package com.merryyou.elasticsearch;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

/**
 * Created by YourName on 2015/11/23 0023.
 */
public class TestCase {
    @Test
    public void testAdd() throws UnknownHostException {
        Client client = ESUtils.getClient();
        IndexResponse indexResponse;
        indexResponse = client.prepareIndex().setIndex(ESUtils.getIndexName())
                .setType(ESUtils.getTypeName())
                .setSource("{\"prodId\":1,\"prodName\":\"ipad5\",\"prodDesc\":\" 比你想的更强大\",\"catId\":1}")
                .setId("1")
                .execute()
                .actionGet();
        System.out.println("添加成功,isCreated="+indexResponse.isCreated());
        ESUtils.closeClient(client);
    }
    @Test
    public void testSerarch() throws UnknownHostException{
        Client client = ESUtils.getClient();
        GetResponse getResponse =
                client.prepareGet().setIndex(ESUtils.getIndexName())
                        .setType(ESUtils.getTypeName())
                        .setId("1")
                        .execute()
                        .actionGet();
        System.out.println("get="+getResponse.getSourceAsString());
        ESUtils.closeClient(client);
    }
}
