package com.data.manager.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.data.manager.model.es.People;
import com.data.manager.model.es.School;
import com.data.manager.service.ElastciSearchService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;
import java.util.List;

/**
 * @author wqkenqing
 * @emai wqkenqingto@163.com
 * @time 2020/2/26
 * @desc some operations
 */
@Component
public class ElastciSearchServiceImpl implements ElastciSearchService {

    @Autowired
    private ElasticsearchTemplate template;

    public void query() {
        TermQueryBuilder query = QueryBuilders.termQuery("name", "傲天");
        NativeSearchQuery nquery = new NativeSearchQueryBuilder().withIndices("people").withTypes("man").withQuery(query).build();
        List<People> plist = template.queryForList(nquery, People.class);
        plist.forEach(p -> {
            System.out.println(p.toString());
        });

    }

    @Override
    public boolean createIndex() {
        String indexName = "school";
        boolean res = template.createIndex(School.class);
        Assert.isTrue(res, "create index in success!");
        return res;

    }

    @Override
    public boolean delete(String indexName) {

        Assert.notNull(indexName, "the indexName is null");
        boolean res = template.deleteIndex(indexName);
        Assert.isTrue(res, "delete the index in success!");
        return res;
    }


}
