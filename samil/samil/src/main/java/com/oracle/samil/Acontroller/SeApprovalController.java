package com.oracle.samil.Acontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.samil.Amodel.Approval;
import com.oracle.samil.Amodel.ApprovalLine;
import com.oracle.samil.Amodel.Dept;
import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.SeService.ApprovalService;
import com.oracle.samil.SeService.Paging;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/se")
public class SeApprovalController {
	
	private final ApprovalService as;
	
	// 유저 전체 게시글 
	@GetMapping(value = "/appAll")
	public String allApp(Approval approval, Model model) {
		System.out.println("SeApprovalController allApp");
	    int allApp = as.allApp();
	    String currentPage = "1";
	    
	    Paging page = new Paging(allApp, currentPage);
	    approval.setStart(page.getStart());
	    approval.setEnd(page.getEnd());
		
		List<Approval> allAppList = as.allAppList(approval);
		System.out.println("SeApprovalController allAppList" + allAppList);
		
		Map<Integer, String> statusMap = new HashMap<>();
	    statusMap.put(100, "결재요청");
	    statusMap.put(110, "결재진행");
	    statusMap.put(120, "결재완료");
	    statusMap.put(130, "반려");
	    
	    model.addAttribute("statusMap", statusMap);
	    model.addAttribute("allApp", allApp);
	    model.addAttribute("allAppList", allAppList);
	    model.addAttribute("page",page);
	    
	    return "se/appAll";
	}
	
	// 유저 보관함 검색
	@RequestMapping(value = "allAppListSearch")
	public String listSearchAllApp(Approval approval, Model model) {
		System.out.println("SeApprovalController listSearchAllApp");

		int allApp = as.condAllApp(approval);
		System.out.println("SeApprovalController listSearchAllApp "+allApp);
		// Paging 작업
		Paging page = new Paging(allApp,approval.getCurrentPage());

		approval.setStart(page.getStart());		// 시작시 1
		approval.setEnd(page.getEnd()); 			// 시작시 10
		System.out.println("SeApprovalController listSearchallApp page->"+page);
		
		List<Approval> allAppListSearch = as.allAppListSearch(approval);
		
		System.out.println("SeApprovalController ApplistSearch"+allAppListSearch);
		Map<Integer, String> statusMap = new HashMap<>();
	    statusMap.put(100, "결재요청");
	    statusMap.put(110, "결재진행");
	    statusMap.put(120, "결재완료");
	    statusMap.put(130, "반려");
	    
	    model.addAttribute("statusMap", statusMap);
		model.addAttribute("allApp", allApp);
		model.addAttribute("allAppList", allAppListSearch);
		model.addAttribute("page", page);
		
		return "se/appAll";
	}
	
	// 결재완료 게시글
	@GetMapping(value = "/appFin")
	public String finApp (Approval approval, Model model){
		System.out.println("SeApprovalController finApp");
		int finApp = as.finApp();
		String currentPage = "1";
		
		Paging page = new Paging(finApp, currentPage);
		approval.setStart(page.getStart());
	    approval.setEnd(page.getEnd());
		
	    List<Approval> finAppList = as.finAppList(approval);
		System.out.println("SeApprovalController finAppList" + finAppList);
		
		Map<Integer, String> statusMap = new HashMap<>();
	    statusMap.put(100, "결재요청");
	    statusMap.put(110, "결재진행");
	    statusMap.put(120, "결재완료");
	    statusMap.put(130, "반려");
	    
	    model.addAttribute("statusMap", statusMap);
	    model.addAttribute("finApp", finApp);
	    model.addAttribute("finAppList", finAppList);
	    model.addAttribute("page", page);
	    
		return "se/appFin";
	}
	
	// 결재완료 검색
	@RequestMapping(value = "finAppListSearch")
	public String SearchFinApp(Approval approval, Model model) {
		System.out.println("SeApprovalController SearchFinApp");

		int finApp = as.condFinApp(approval);
		System.out.println("SeApprovalController SearchFinApp "+finApp);
		// Paging 작업
		Paging page = new Paging(finApp,approval.getCurrentPage());

		approval.setStart(page.getStart());		// 시작시 1
		approval.setEnd(page.getEnd()); 			// 시작시 10
		System.out.println("SeApprovalController SearchFinApp page->"+page);
		
		List<Approval> finAppListSearch = as.finAppListSearch(approval);
		
		System.out.println("SeApprovalController SearchFinApp"+finAppListSearch);
		Map<Integer, String> statusMap = new HashMap<>();
	    statusMap.put(100, "결재요청");
	    statusMap.put(110, "결재진행");
	    statusMap.put(120, "결재완료");
	    statusMap.put(130, "반려");
	    
	    model.addAttribute("statusMap", statusMap);
		model.addAttribute("finApp", finApp);
		model.addAttribute("finAppList", finAppListSearch);
		model.addAttribute("page", page);
		
		return "se/appFin";
	}
	
	// 결재대기함 게시글
	@GetMapping(value = "/appStn")
	public String stnApp (Approval approval, Model model){
		System.out.println("SeApprovalController stnApp");
		int stnApp = as.stnApp();
		String currentPage = "1";
		
		Paging page = new Paging(stnApp, currentPage);
		approval.setStart(page.getStart());
	    approval.setEnd(page.getEnd());
		
	    List<Approval> stnAppList = as.stnAppList(approval);
		System.out.println("SeApprovalController stnAppList" + stnAppList);
		
		Map<Integer, String> statusMap = new HashMap<>();
	    statusMap.put(100, "결재요청");
	    statusMap.put(110, "결재진행");
	    statusMap.put(120, "결재완료");
	    statusMap.put(130, "반려");
	    
	    model.addAttribute("statusMap", statusMap);
	    model.addAttribute("stnApp", stnApp);
	    model.addAttribute("stnAppList", stnAppList);
	    model.addAttribute("page", page);
	    
		return "se/appStn";
	}
	
	// 결재대기 검색
	@RequestMapping(value = "stnAppListSearch")
	public String SearchStnApp(Approval approval, Model model) {
		System.out.println("SeApprovalController SearchStnApp");

		int stnApp = as.condStnApp(approval);
		System.out.println("SeApprovalController SearchStnApp "+stnApp);
		// Paging 작업
		Paging page = new Paging(stnApp,approval.getCurrentPage());

		approval.setStart(page.getStart());		// 시작시 1
		approval.setEnd(page.getEnd()); 			// 시작시 10
		System.out.println("SeApprovalController SearchStnApp page->"+page);
		
		List<Approval> stnAppListSearch = as.stnAppListSearch(approval);
		System.out.println("SeApprovalController SearchFinApp"+stnAppListSearch);
		Map<Integer, String> statusMap = new HashMap<>();
	    statusMap.put(100, "결재요청");
	    statusMap.put(110, "결재진행");
	    statusMap.put(120, "결재완료");
	    statusMap.put(130, "반려");
	    
	    model.addAttribute("statusMap", statusMap);
		model.addAttribute("stnApp", stnApp);
		model.addAttribute("stnAppList", stnAppListSearch);
		model.addAttribute("page", page);
		
		return "se/appStn";
	}
		
	// 어드민 (모든유저)전체 게시글
	@GetMapping(value = "/adminApp")
	public String adminApp(Approval approval, Model model) {
		System.out.println("SeApprovalController adminApp");
	    int adminApp = as.adminApp();
	    String currentPage = "1";
	    
	    Paging page = new Paging(adminApp, currentPage);
	    approval.setStart(page.getStart());
	    approval.setEnd(page.getEnd());
		
		List<Approval> adminAppList = as.adminAppList(approval);
		System.out.println("SeApprovalController adminAppList" + adminAppList);
		
		Map<Integer, String> statusMap = new HashMap<>();
	    statusMap.put(100, "결재요청");
	    statusMap.put(110, "결재진행");
	    statusMap.put(120, "결재완료");
	    statusMap.put(130, "반려");
	    
	    model.addAttribute("statusMap", statusMap);
	    model.addAttribute("adminApp", adminApp);
	    model.addAttribute("adminAppList", adminAppList);
	    model.addAttribute("page",page);
	    
	    return "se/adminApp";
	}
	
	// 어드민 (모든유저)전체 검색
	@RequestMapping(value = "adminAppListSearch")
	public String SearchAdminApp(Approval approval, Model model) {
		System.out.println("SeApprovalController SearchAdminApp");

		int adminApp = as.condAdminApp(approval);
		System.out.println("SeApprovalController SearchAdminApp "+adminApp);
		// Paging 작업
		Paging page = new Paging(adminApp, approval.getCurrentPage());

		approval.setStart(page.getStart());		// 시작시 1
		approval.setEnd(page.getEnd()); 		// 시작시 10
		System.out.println("SeApprovalController SearchAdminApp page->"+page);
		
		List<Approval> adminAppListSearch = as.adminAppListSearch(approval);
		System.out.println("SeApprovalController SearchAdminApp "+adminAppListSearch);
		Map<Integer, String> statusMap = new HashMap<>();
	    statusMap.put(100, "결재요청");
	    statusMap.put(110, "결재진행");
	    statusMap.put(120, "결재완료");
	    statusMap.put(130, "반려");
	    
	    model.addAttribute("statusMap", statusMap);
		model.addAttribute("adminApp", adminApp);
		model.addAttribute("adminAppList", adminAppListSearch);
		model.addAttribute("page", page);
		
		return "se/adminApp";
	}
	
	// 조직도검색
	@GetMapping(value = "/orgChart")
	public String orgChart() {
		return "se/orgChart";
	}
	
	// 기안서식창
	@GetMapping(value = "/draftingForm")
	public String draftingForm(@RequestParam(value = "drafting", required = false) Integer drafting) {
	    if (drafting == null) {
	        // 서식 선택 페이지로 이동
	        return "se/draftingForm"; // 기본 서식 선택 페이지
	    }
	    switch (drafting) {
	        case 100: // 연차
	        case 110: // 병가
	        case 120: // 경조사
	        case 160: // 휴직
	            return "se/leaveForm"; // 휴가 관련 서식
	        case 130: // 법인
	        case 140: // 비품
	        case 150: // 유류비
	            return "se/expForm"; // 비용 결제 서식
	        case 170: // 퇴직
	            return "se/retForm"; // 퇴직 요청 서식
	        default:
	            return "se/draftingForm"; // 기본 서식 선택 페이지
	    }
	}
	
	// 제목을통해 해당 파일 조회
	@GetMapping(value = "appDetail")
	public String appDetail(@RequestParam(value = "approvalNum") Integer approvalNum,
	                        @RequestParam(value = "documentFormId", required = false) Integer documentFormId, 
	                        Model model) {
		
		System.out.println("SeApprovalController appDetail approvalNum->"+approvalNum);
		System.out.println("SeApprovalController appDetail documentFormId->"+documentFormId);
		Approval approval = as.appDetail(approvalNum, documentFormId);
		System.out.println("SeApprovalController appDetail approval->"+approval);

		ApprovalLine approvalLine = new ApprovalLine();
		approvalLine.setApprovalNum(approvalNum);
		approvalLine.setDocumentFormId(documentFormId);
		System.out.println("SeApprovalController appDetail approvalLine->"+approvalLine);
		List<ApprovalLine> approvalLineList = as.appLineListSearch(approvalLine);
		
		System.out.println("SeApprovalController appDetail approvalLineList ->"+approvalLineList);
		model.addAttribute("approval", approval);
		model.addAttribute("approvalLineList", approvalLineList);
	    
		switch (documentFormId) {
	            case 100: // 연차
	            case 110: // 병가
	            case 120: // 경조사
	            case 160: // 휴직
	                return "se/leaveDetail"; // 휴가 관련 서식
	            case 130: // 법인
	            case 140: // 비품
	            case 150: // 유류비
	                return "se/expDetail"; // 비용 결제 서식
	            case 170: // 퇴직
	                return "se/retDetail"; // 퇴직 요청 서식
	        }
	    return "se/errPage";
	}
	
	//휴무 수정
	@GetMapping(value = "appUpdateForm")
	public String appUpdateForm(@RequestParam(value = "approvalNum") Integer approvalNum,
	                        @RequestParam(value = "documentFormId", required = false) Integer documentFormId, 
	                        Model model) {
		
		System.out.println("SeApprovalController appDetail approvalNum->"+approvalNum);
		System.out.println("SeApprovalController appDetail documentFormId->"+documentFormId);
		Approval approval = as.appDetail(approvalNum, documentFormId);
		System.out.println("SeApprovalController appDetail approval->"+approval);

		ApprovalLine approvalLine = new ApprovalLine();
		approvalLine.setApprovalNum(approvalNum);
		approvalLine.setDocumentFormId(documentFormId);
		System.out.println("SeApprovalController appDetail approvalLine->"+approvalLine);
		List<ApprovalLine> approvalLineList = as.appLineListSearch(approvalLine);
		
		System.out.println("SeApprovalController appDetail approvalLineList ->"+approvalLineList);
		model.addAttribute("approval", approval);
		model.addAttribute("approvalLineList", approvalLineList);
	    
		switch (documentFormId) {
	            case 100: // 연차
	            case 110: // 병가
	            case 120: // 경조사
	            case 160: // 휴직
	                return "se/leaveUpdate"; // 휴가 관련 서식
	            case 130: // 법인
	            case 140: // 비품
	            case 150: // 유류비
	                return "se/expUpdate"; // 비용 결제 서식
	            case 170: // 퇴직
	                return "se/retUpdate"; // 퇴직 요청 서식
	        }
	    return "se/errPage";
	}
	
	// 수정완료
	@PostMapping(value = "updateApp")
    public String updateApp( Approval approval, Model model) {
		System.out.println("SeApprovalController updateApp approval->"+approval);
	
		as.updateApp(approval);
		model.addAttribute("approval", approval);
	    
	    return "redirect:/se/appAll";
	}
	
}
