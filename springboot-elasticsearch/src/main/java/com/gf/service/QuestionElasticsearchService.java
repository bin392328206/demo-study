package com.gf.service;

import com.gf.entity.FQuestionElasticssearch;
import com.gf.repository.QuestionElasticsearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class QuestionElasticsearchService {
    @Autowired
    QuestionElasticsearchRepository questionElasticsearchRepository;

    public Page<FQuestionElasticssearch> pageByOpenAndCatory(Integer page, Integer size, String catory,
                                                             String keyWord) {
        Pageable pageable = PageRequest.of(page, size);
        if (StringUtils.isEmpty(keyWord)) {
            return questionElasticsearchRepository.findByCatory(catory, pageable);

        } else {
            return questionElasticsearchRepository.searchByKeyWordsAndCatory(keyWord, catory, pageable);
        }
    }
}
