package com.data.manager.model.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author wqkenqing
 * @emai wqkenqingto@163.com
 * @time 2020/3/7
 * @desc
 */
@Document(indexName = "school", type = "person", shards = 1, replicas = 0)
public class School {
    @Id
    long id;

    @Field(type = FieldType.Keyword)
    String postion;
    @Field(type = FieldType.Keyword)
    String name;
    @Field(type = FieldType.Text)
    String desc;

}
