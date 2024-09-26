package com.oracle.samil.Amodel;


import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Posts {
	public int 		postId;			//게시글아이디
	public int 		empno;			//사원번호
	public int 		boardId;		//게시판유형
	public String 	postsTitle;		//제목
	public String 	postsCnt;		//내용
	public String 	creationDate;	//작성일
	public int 		isPinned;		//상단고정
	public int 		postsViews;		//조회수
	public MultipartFile 	fileName;		//파일명
	public int 		ref;			//답변글끼리그룹
	public int 		reStep;			//REF내의순서
	public int 		reLevel;		//들여쓰기

	
	//조회용
	private String search;
	private String keyword;
	private String pageNum;
	private int start;
	private int end;
	//page 정보
	private String currentPage;

	
}
