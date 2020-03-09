package com.data.manager.service;

/**
 * @author wqkenqing
 * @emai wqkenqingto@163.com
 * @time 2020/2/26
 * @desc
 */
public interface ElastciSearchService {
     void query();
    boolean createIndex();

    boolean delete(String indexName);

}
