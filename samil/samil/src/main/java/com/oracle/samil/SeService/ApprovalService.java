package com.oracle.samil.SeService;

import java.util.List;

import org.springframework.ui.Model;

import com.oracle.samil.Amodel.Approval;
import com.oracle.samil.Amodel.ApprovalLine;

public interface ApprovalService {
	
	//전체 보관
	int 		   allApp();
	List<Approval> allAppList(Approval approval);
	int            condAllApp(Approval approval);
	List<Approval> allAppListSearch(Approval approval);
	//완료 보관
	int            finApp();
	List<Approval> finAppList(Approval approval);
	int            condFinApp(Approval approval);
	List<Approval> finAppListSearch(Approval approval);
	//대기 보관
	int            stnApp();
	List<Approval> stnAppList(Approval approval);
	int            condStnApp(Approval approval);
	List<Approval> stnAppListSearch(Approval approval);
	//어드민 보관
	int            adminApp();
	List<Approval> adminAppList(Approval approval);
	int            condAdminApp(Approval approval);
	List<Approval> adminAppListSearch(Approval approval);
	//조회
	Approval 			appDetail(int approvalNum, int documentFormId);
	List<ApprovalLine> appLineListSearch(ApprovalLine approvalLine);
	//업데이트
	void	updateApp(Approval approval);
	









}
