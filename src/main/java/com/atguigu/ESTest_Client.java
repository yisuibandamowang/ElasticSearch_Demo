package com.atguigu;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * ClassName: ESTest_Client
 * Package:
 * Description:
 *
 * @Author:xiaohei
 * @Create 2024/4/7 20:29
 * Version 1.0
 */
public class ESTest_Client {

    public static void main(String[] args) throws IOException {

        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",8200,"http"))
        );

        //关闭客户端
        restHighLevelClient.close();

    }

}
