package com.oracle.samil.SeDao;

import java.util.List;

import org.springframework.ui.Model;

import com.oracle.samil.Amodel.Approval;
import com.oracle.samil.Amodel.ApprovalLine;

public interface ApprovalDao {

	// 유저 전체
	int 			allApp();
	List<Approval> 	allAppList(Approval approval);
	int 			condAllApp(Approval approval);
	List<Approval> 	allAppListSearch(Approval approval);
	// 결재 완료
	int 			finApp();
	List<Approval> 	finAppList(Approval approval);
	int 			condFinApp(Approval approval);
	List<Approval> 	finAppListSearch(Approval approval);
	// 결재 대기
	int 			stnApp();
	List<Approval> 	stnAppList(Approval approval);
	int 			condStnApp(Approval approval);
	List<Approval> 	stnAppListSearch(Approval approval);
	// 어드민 (모든유저)전체
	int 			adminApp();
	List<Approval> 	adminAppList(Approval approval);
	int 			condAdminApp(Approval approval);
	List<Approval> 	adminAppListSearch(Approval approval);
	// 조회
	List<ApprovalLine> approvalLineList(ApprovalLine approvalLine);
	Approval 			appDetail(int approvalNum, int documentFormId);
	// 업데이트
	int updateApp(Approval approval);
	
	

	

	

	
	
	
	







	
}
