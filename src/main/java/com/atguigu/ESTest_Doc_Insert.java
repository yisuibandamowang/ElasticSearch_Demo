package com.atguigu;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
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
public class ESTest_Doc_Insert {
    public static void main(String[] args) throws IOException {

        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",8200,"http"))
        );

        //插入数据
        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");

        User user = new User();
        user.setName("zhangsan");
        user.setAge(30);
        user.setSex("男");

        //向ES插入数据，必须将数据转换为JSON形式
        ObjectMapper mapper = new ObjectMapper();
        String userJSON = mapper.writeValueAsString(user);
        request.source(userJSON, XContentType.JSON);

        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult());

        //关闭客户端
        esClient.close();

    }
}
