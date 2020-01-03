package com.gf;

import com.gf.entity.Article;
import com.gf.entity.Book;
import com.gf.entity.FQuestionElasticssearch;
import com.gf.repository.BookRepository;
import com.gf.repository.QuestionElasticsearchRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticsearchApplicationTests {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	QuestionElasticsearchRepository questionElasticsearchRepository;

	@Test
	public void createIndex2(){
		FQuestionElasticssearch fQuestionElasticssearch = new FQuestionElasticssearch();
		fQuestionElasticssearch.setCatory("六脉神剑");
		fQuestionElasticssearch.setContent("天下无敌");
		fQuestionElasticssearch.setTitle("六神无主");
		questionElasticsearchRepository.index( fQuestionElasticssearch );
	}

	@Test
	public void useFind() {
		List<Book> list = bookRepository.findByBookNameLike( "游" );
		for (Book book : list) {
			System.out.println(book);
		}

	}

}
