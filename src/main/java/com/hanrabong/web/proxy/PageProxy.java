package com.hanrabong.web.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper=false)
@Data
@Lazy
@Component("pager")
@AllArgsConstructor
@NoArgsConstructor
public class PageProxy extends Proxy{
	
	private int totalCount, startRow, endRow
			,pageCount, pageSize, startPage, endPage, pageNum  // 
			,blockCount; 
	private boolean existNext, existPrev;
	private String search;
	private final int BLOCK_SIZE = 5; 
	private List<Integer>blist;
	private List<String> proxyList;	
	//@Autowired BrdMapper brdMapper;
	

	public void paging() {
		//Supplier<Integer> s = ()->brdMapper.countAllArticle();
		totalCount = 0;
		pageCount =(totalCount %pageSize==0) ?  totalCount/pageSize : (totalCount/pageSize)+1;
		startRow = (pageNum-1) * pageSize;
		System.out.println("pageNum>>>>>>>>>>>>>"+pageNum);
		endRow = (pageNum == pageCount) ?   totalCount -1 : pageNum*pageSize-1;
		blockCount = (pageCount %BLOCK_SIZE==0) ?  pageCount/BLOCK_SIZE : (pageCount/BLOCK_SIZE)+1; //블럭의 개수
		startPage =   ((pageNum-1)/BLOCK_SIZE)*BLOCK_SIZE+1; // 
		endPage = ((pageCount-startPage)<(BLOCK_SIZE) ) ?   pageCount : (startPage + BLOCK_SIZE -1); // 
		existPrev = (startPage < (BLOCK_SIZE+1) ) ? false : true;  // start Page가 BLOCK_SIZE+1보다 작으면 없음.
		existNext =  (pageCount == endPage) ? false : true; // 페이지수가 endPage와 같으면 없음.
		blist = new ArrayList<>();
		for (int i = startPage;  i < endPage+1 ; i++) {
			blist.add(i);
		}
				
	}
	
	
	
	
	
}
