package com.atguigu;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * ClassName: ESTest_Index_Search
 * Package:
 * Description:
 *
 * @Author:xiaohei
 * @Create 2024/4/7 20:38
 * Version 1.0
 */
public class ESTest_Index_Search {
    public static void main(String[] args) throws IOException {

        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",8200,"http"))
        );

        //创建索引
        GetIndexRequest request = new GetIndexRequest("user");
        GetIndexResponse response =
                esClient.indices().get(request, RequestOptions.DEFAULT);
        //响应状态
        System.out.println(response.getAliases());
        System.out.println(response.getMappings());
        //关闭客户端
        esClient.close();

    }
}
