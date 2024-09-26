package com.oracle.samil.Amodel;


import lombok.Data;

@Data
public class EmpSalDept {
	private int 	empno;			//사원번호
	private String 	email;			//이메일주소
	private String 	name;			//이름
	private String 	phone;			//전화번호
	private int 	deptno;			//부서번호
	private int 	grade;			//직급
	private int 	job;			//직책
	private String 	address;		//집주소
	private int 	status;			//근로상태
	private int 	admin;			//관리자권한
	private String 	image;			//이미지명
	private String 	hiredate;		//입사일
	private int 	totalVacation;	//총연차수
	private int 	restVacation;	//남은연차수
	private String 	account;		//입금계좌
	private String 	bank ;			//은행
	private boolean delCheck;		//삭제여부
	private int 	recentEditor;	//최근작성자
	private String 	recentEditDate;	//최근수정일
	


	public String 	deptName;		// 부서명
	public int		higherdeptno; 	// 상위부서
	public int		manager;		// 부서장사원번호
	public String	depttel;		// 부서대표번호
	public int		deptdepth;		// 부서reflev
	
	private String 	salNum;		//근로년월
	private int 	salBase;	//기본급
	private int 	salFood;	//식대
	private int 	salBonus;	//상여
	private int 	salNight;	//야간수당
	private int 	salTotal;	//금여총액
	private int 	taxNum;		//공제총액
	private int 	salFinal;	//차감지급액
	private String 	salDate;	//급여일
	private int 	tax;		//소득세
	private String 	editor;		//작성자
	private String 	editorDate;	//작성일
	
	// Page 정보
	private int start;
	private int end;
	private String currentPage;	

	// 조회용
	private String search;   	   private String keyword;
	
	
	
}
