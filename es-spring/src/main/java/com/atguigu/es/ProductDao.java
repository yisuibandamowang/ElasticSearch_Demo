package com.atguigu.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName: ProductDao
 * Package:
 * Description:
 *
 * @Author:xiaohei
 * @Create 2024/4/8 14:12
 * Version 1.0
 */
@Repository
public interface ProductDao extends ElasticsearchRepository<Product,Long> {

}
