package com.gf.repository;

import com.gf.entity.FQuestionElasticssearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface QuestionElasticsearchRepository extends ElasticsearchRepository<FQuestionElasticssearch, Long> {

    Page<FQuestionElasticssearch> findByCatory(String catory, Pageable pageable);

    @Query("{ \"bool\":{ \"must\":[ { \"multi_match\": { \"query\": \"?0\", \"type\": \"most_fields\", \"fields\": [ \"title\", \"content\" ] } }, { \"match\": { \"catory\": \"?1\" } } ] } } ")
    Page<FQuestionElasticssearch> searchByKeyWordsAndCatory(String keyword, String catory, Pageable pageable);

}
