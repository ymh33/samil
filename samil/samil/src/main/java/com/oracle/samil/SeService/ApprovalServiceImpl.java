package com.oracle.samil.SeService;

import org.springframework.stereotype.Service;

import java.util.List;

import com.oracle.samil.Amodel.Approval;
import com.oracle.samil.Amodel.ApprovalLine;
import com.oracle.samil.SeDao.ApprovalDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {
	
	private final ApprovalDao ad;
	
	// 전체 게시글
	@Override
	public int allApp() {
		System.out.println("ApprovalServiceImpl allApp start");
		int allApp = ad.allApp();
		return allApp;
	}
	
	// 전체 게시글 리스트
	@Override
	public List<Approval> allAppList(Approval approval) {
		List<Approval> allList = null;
		System.out.println("ApprovalServiceImpl allList Start");
		allList = ad.allAppList(approval);
		System.out.println("ApprovalServiceImpl allList" + allList);
		return allList;
	}
	
	// 전체 검색
	@Override
	public int condAllApp(Approval approval) {
		System.err.println("ApprovalServiceImpl Start condAllApp...");
		int allAppCnt = ad.condAllApp(approval);
		System.out.println("ApprovalServiceImpl condAllApp "+allAppCnt);
		return allAppCnt;
	}
	
	// 전체 검색 리스트
	@Override
	public List<Approval> allAppListSearch(Approval approval) {
		List<Approval> allAppListSearch = null;
		System.out.println("ApprovalServiceImpl allAppListSearch start");
		allAppListSearch = ad.allAppListSearch(approval);
		System.out.println("ApprovalServiceImpl allAppListSearch "+allAppListSearch);
		return allAppListSearch;
	}
	
	// 결재완료 게시글
	@Override
	public int finApp() {
		System.out.println("ApprovalServiceImpl finishApp start");
		int finApp = ad.finApp();
		return finApp;
	}
	
	// 결재완료 리스트
	@Override
	public List<Approval> finAppList(Approval approval) {
		List<Approval> finList = null;
		System.out.println("ApprovalServiceImpl finList Start");
		finList = ad.finAppList(approval);
		System.out.println("ApprovalServiceImpl finList" + finList);
		return finList;
	}
	
	// 결재완료 검색
	@Override
	public int condFinApp(Approval approval) {
		System.err.println("ApprovalServiceImpl Start condFinApp...");
		int finAppCnt = ad.condFinApp(approval);
		System.out.println("ApprovalServiceImpl condFinApp "+finAppCnt);
		return finAppCnt;
	}
	
	// 결재완료 검색 리스트
	@Override
	public List<Approval> finAppListSearch(Approval approval) {
		List<Approval> finAppListSearch = null;
		System.out.println("ApprovalServiceImpl finAppListSearch start");
		finAppListSearch = ad.finAppListSearch(approval);
		System.out.println("ApprovalServiceImpl finAppListSearch "+finAppListSearch);
		return finAppListSearch;
	}
	
	// 결재대기 게시글
	@Override
	public int stnApp() {
		System.out.println("ApprovalServiceImpl stnApp start");
		int stnApp = ad.stnApp();
		return stnApp;
	}

	// 결제대기 리스트
	@Override
	public List<Approval> stnAppList(Approval approval) {
		List<Approval> stnList = null;
		System.out.println("ApprovalServiceImpl stnList Start");
		stnList = ad.stnAppList(approval);
		System.out.println("ApprovalServiceImpl stnList" + stnList);
		return stnList;
	}

	// 결재대기 검색
	@Override
	public int condStnApp(Approval approval) {
		System.err.println("ApprovalServiceImpl Start condStnApp...");
		int stnAppCnt = ad.condStnApp(approval);
		System.out.println("ApprovalServiceImpl condStnApp "+stnAppCnt);
		return stnAppCnt;
	}
	
	// 결재대기 검색 리스트
	@Override
	public List<Approval> stnAppListSearch(Approval approval) {
		List<Approval> stnAppListSearch = null;
		System.out.println("ApprovalServiceImpl stnAppListSearch start");
		stnAppListSearch = ad.stnAppListSearch(approval);
		System.out.println("ApprovalServiceImpl stnAppListSearch "+stnAppListSearch);
		return stnAppListSearch;
	}
	
	// 어드민 모든유저 게시글
	@Override
	public int adminApp() {
		System.out.println("ApprovalServiceImpl adminallApp start");
		int adminApp = ad.adminApp();
		return adminApp;
	}

	// 어드민 모든유저 리스트
	@Override
	public List<Approval> adminAppList(Approval approval) {
		List<Approval> adminList = null;
		System.out.println("ApprovalServiceImpl adminAppList Start");
		adminList = ad.adminAppList(approval);
		System.out.println("ApprovalServiceImpl adminAppList" + adminList);
		return adminList;
	}
	
	// 어드민 전체 검색
	@Override
	public int condAdminApp(Approval approval) {
		System.err.println("ApprovalServiceImpl Start condAdminApp...");
		int adminAppCnt = ad.condAdminApp(approval);
		System.out.println("ApprovalServiceImpl condAdminApp "+adminAppCnt);
		return adminAppCnt;
	}
	
	// 어드민 전체 검색
	@Override
	public List<Approval> adminAppListSearch(Approval approval) {
		List<Approval> adminAppListSearch = null;
		System.out.println("ApprovalServiceImpl adminAppListSearch start");
		adminAppListSearch = ad.adminAppListSearch(approval);
		System.out.println("ApprovalServiceImpl adminAppListSearch "+adminAppListSearch);
		return adminAppListSearch;
	}
	
	// 조회
	@Override
	public Approval appDetail(int approvalNum, int documentFormId) {
	    System.out.println("ApprovalServiceImpl getApprovalDetails ...");
	    
	    Approval approval = null;
	    approval = ad.appDetail(approvalNum, documentFormId);
	    
	    return approval;
	}
	// 결재라인 불러오기
	@Override
	public List<ApprovalLine> appLineListSearch(ApprovalLine approvalLine) {
		System.out.println("ApprovalServiceImpl appLineListSearch ...");
		List<ApprovalLine> approvalLineList = null;
		approvalLineList = ad.approvalLineList(approvalLine);
		System.out.println("ApprovalServiceImpl appLineListSearch "+approvalLineList);
		return approvalLineList;
	}

	@Override
	public void updateApp(Approval approval) {
	    System.out.println("ApprovalServiceImpl updateApp 시작");
	    ad.updateApp(approval);
	    System.out.println("ApprovalServiceImpl updateApp 진행");
	    return; 
	}


}
