package com.atguigu;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * ClassName: ESTest_index_Create
 * Package:
 * Description:
 *
 * @Author:xiaohei
 * @Create 2024/4/7 20:32
 * Version 1.0
 */
public class ESTest_index_Create {
    public static void main(String[] args) throws IOException {

        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",8200,"http"))
        );

        //创建索引
        CreateIndexRequest request = new CreateIndexRequest("xiaohei");
        CreateIndexResponse response =
                esClient.indices().create(request, RequestOptions.DEFAULT);
        //响应状态
        boolean acknowledged = response.isAcknowledged();
        System.out.println("索引操作" + acknowledged);

        //关闭客户端
        esClient.close();

    }
}
