package com.atguigu;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.Index;

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
public class ESTest_Doc_Insert_Batch {
    public static void main(String[] args) throws IOException {

        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",8200,"http"))
        );

        //批量插入数据
        BulkRequest request = new BulkRequest();


        request.add(new IndexRequest()
                .index("user")
                .id("1001")
                .source(XContentType.JSON,"name","张三","age",20));
        request.add(new IndexRequest()
                .index("user")
                .id("1002")
                .source(XContentType.JSON,"name","李四","age",20));
        request.add(new IndexRequest()
                .index("user")
                .id("1003")
                .source(XContentType.JSON,"name","王五","age",20));

        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getItems());
        System.out.println(response.getTook());
        //关闭客户端
        esClient.close();

    }
}
