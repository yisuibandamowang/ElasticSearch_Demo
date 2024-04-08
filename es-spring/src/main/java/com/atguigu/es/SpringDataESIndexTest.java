package com.atguigu.es;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName: SpringDataESIndexTest
 * Package:
 * Description:
 *
 * @Author:xiaohei
 * @Create 2024/4/8 14:17
 * Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESIndexTest {
    //注入 ElasticsearchRestTemplate
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    //创建索引并增加映射配置
    @Test
    public void createIndex(){
        //创建索引，系统初始化会自动创建索引
        System.out.println("创建索引");
    }
    @Test
    public void deleteIndex(){
        //创建索引，系统初始化会自动创建索引
        boolean flg = elasticsearchTemplate.deleteScript(String.valueOf(Product.class));
        System.out.println("删除索引 = " + flg);
    }

}
