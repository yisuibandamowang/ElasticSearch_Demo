package com.atguigu;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import javax.naming.directory.SearchResult;
import javax.swing.text.Highlighter;
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
public class ESTest_Doc_Query {
    public static void main(String[] args) throws IOException {

        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",8200,"http"))
        );

        //查询数据
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }


        //条件查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age","20")));
//
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }


        //分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //（当前页码-1） * 每页显示条数
//        builder.from(2);
//        builder.size(2);
//        request.source(builder);
//
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //排序返回
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //
//        builder.sort("age", SortOrder.DESC);
//        request.source(builder);
//
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //过滤字段
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //（当前页码-1） * 每页显示条数
//        String[] exclude = {};
//        String[] include = {"name"};
//        builder.fetchSource(include,exclude);
//
//        request.source(builder);
//
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //组合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//
//        boolQueryBuilder.must(QueryBuilders.matchQuery("age",20));
//        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex",'男'));
//
//        builder.query(QueryBuilders.matchAllQuery());
//        //（当前页码-1） * 每页显示条数
//        builder.from(2);
//        builder.size(2);
//        request.source(builder);
//
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //范围查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age");
//
//        rangeQueryBuilder.gt(30);
//        rangeQueryBuilder.lt(50);
//
//        builder.query(QueryBuilders.matchAllQuery());
//        //（当前页码-1） * 每页显示条数
//        request.source(builder);
//
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //模糊查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//
//        builder.query(QueryBuilders.fuzzyQuery("name", "三").fuzziness(Fuzziness.ONE));
//        //（当前页码-1） * 每页显示条数
//        request.source(builder);
//
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for(SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

        //高亮查询
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "张三");

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='red'>");
        highlightBuilder.postTags("</font>");
        highlightBuilder.field("name");

        builder.highlighter(highlightBuilder);
        builder.query(termQueryBuilder);
        //（当前页码-1） * 每页显示条数
        request.source(builder);

        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        for(SearchHit hit : hits){
            System.out.println(hit.getSourceAsString());
        }

        //关闭客户端
        esClient.close();

    }
}
