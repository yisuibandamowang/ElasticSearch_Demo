package com.atguigu.es;

import lombok.Data;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: ElasticsearchConfig
 * Package:
 * Description:
 *
 * @Author:xiaohei
 * @Create 2024/4/8 14:05
 * Version 1.0
 */
@ConfigurationProperties(prefix = "elasticsearch")
@Configuration
@Data
public class ElasticsearchConfig{

    private String host ;
    private Integer port ;

    public RestHighLevelClient elasticsearchClient() {
        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port));
        RestHighLevelClient restHighLevelClient = new
                RestHighLevelClient(builder);
        return restHighLevelClient;
    }
}
