package com.gf.controller;

import com.gf.entity.FQuestionElasticssearch;
import com.gf.service.QuestionElasticsearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elsearch")
public class ElasticsearchRest {

    @Autowired
    QuestionElasticsearchService questionElasticsearchService;

    @RequestMapping(value = "/test", method = { RequestMethod.GET })
    public List<FQuestionElasticssearch> test(@RequestParam(value = "value", required = false) String value) {
        return questionElasticsearchService.pageByOpenAndCatory(0, 10, "六脉神剑", value).getContent();
    }
}