package com.atguigu.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * ClassName: Product
 * Package:
 * Description:
 *
 * @Author:xiaohei
 * @Create 2024/4/8 14:03
 * Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "shopping")
public class Product {
    @Id
    private Long id;//商品唯一标识
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;//商品名称
    @Field(type = FieldType.Keyword)
    private String category;//分类名称
    @Field(type = FieldType.Double)
    private Double price;//商品价格
    @Field(type = FieldType.Keyword, index = false)
    private String images;//图片地址
}
