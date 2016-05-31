package com.merryyou.elasticsearch;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by YourName on 2015/11/23 0023.
 */
public class ESUtils {
    public static final String INDEX_NAME = "esindex";

    public static String getIndexName() {
        return INDEX_NAME;
    }

    public static final String TYPE_NAME = "estype";

    public static String getTypeName() {
        return TYPE_NAME;
    }

    public static Client getClient() throws UnknownHostException {
        Settings settings = ImmutableSettings.settingsBuilder()
                .build();
        Client client = new TransportClient(settings)
                //118.85.200.84
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("118.85.200.84"), 9300));
        return client;
    }

    public static void closeClient(Client esClient) {
        if (esClient != null) {
            esClient.close();
        }
    }
}
