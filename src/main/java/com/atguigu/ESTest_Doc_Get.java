package com.atguigu;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;

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
public class ESTest_Doc_Get {
    public static void main(String[] args) throws IOException {

        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",8200,"http"))
        );

        //查询数据
        GetRequest request = new GetRequest();
        request.index("user").id("1001");
        GetResponse response = esClient.get(request, RequestOptions.DEFAULT);

        System.out.println(response.getSourceAsString());
        //关闭客户端
        esClient.close();

    }
}
