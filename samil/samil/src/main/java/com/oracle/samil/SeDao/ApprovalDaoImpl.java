package com.oracle.samil.SeDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;

import com.oracle.samil.Amodel.Approval;
import com.oracle.samil.Amodel.ApprovalLine;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ApprovalDaoImpl implements ApprovalDao {
	
	private final PlatformTransactionManager transactionManager;
	
	private final SqlSession session;
	
	// 전체 보관함 -> 게시글 가져오기
	@Override
	public int allApp() {
		int allApp = 0;
		System.out.println("ApprovalDaoImpl allApp Start");
		
		try {
			allApp = session.selectOne("com.oracle.samil.SeDao.ApprovalDao.allApp");
			System.out.println("ApprovalDaoImpl allApp ok");
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl allApp 에러"+e.getMessage());
		}
		return allApp;
	}
	
	// 전체 보관함 -> 게시글 보여주기
	@Override
	public List<Approval> allAppList(Approval approval) {
		List<Approval> allList = null;
		System.out.println("ApprovalDaoImpl allAppList Start");
		
		try {
			allList = session.selectList("allAppList", approval);
			System.out.println("ApprovalDaoImpl allList" + allList.size());
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl allList e.getMessage() -> " + e.getMessage());
		}
		return allList;
	}
	
	// 보관함 조회
	@Override
	public int condAllApp(Approval approval) {
		int allAppCount = 0;
		System.out.println("ApprovalDaoImpl condAllApp start");
		
		try {
			allAppCount = session.selectOne("condAllApp", approval);
			System.out.println("ApprovalDaoImpl condAllApp "+allAppCount);
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl condAllApp 에러 "+e.getMessage());
		}
		return allAppCount;
	}
	
	// 보관함 검색
	@Override
	public List<Approval> allAppListSearch(Approval approval) {
		List<Approval> allAppListSearch = null;
		System.out.println("ApprovalDaoImpl allAppListSearch Start...");
		System.out.println("ApprovalDaoImpl allAppListSearch approval->"+approval);
		try {
			allAppListSearch = session.selectList("allAppListSearch", approval);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allAppListSearch;
	}
	
	// 결재 완료함 -> 게시글 가져오기
	@Override
	public int finApp() {
		int finApp = 0;
		System.out.println("ApprovalDaoImpl finApp Start");
		
		try {
			finApp = session.selectOne("com.oracle.samil.SeDao.ApprovalDao.finApp");
			System.out.println("ApprovalDaoImpl finApp ok");
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl finApp 에러"+e.getMessage());
		}
		return finApp;
	}
	
	// 결재 완료함 -> 게시글 보여주기
	@Override
	public List<Approval> finAppList(Approval approval) {
		List<Approval> finList = null;
		System.out.println("ApprovalDaoImpl finList Start");
		
		try {
			finList = session.selectList("finAppList", approval);
			System.out.println("ApprovalDaoImpl finList" + finList.size());
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl finList e.getMessage() -> " + e.getMessage());
		}
		return finList;
	}
	
	// 결재 완료함 -> 게시글 가져오기
	@Override
	public int condFinApp(Approval approval) {
		int finAppCount = 0;
		System.out.println("ApprovalDaoImpl condFinApp start");
		
		try {
			finAppCount = session.selectOne("condFinApp", approval);
			System.out.println("ApprovalDaoImpl condFinApp "+finAppCount);
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl condFinApp 에러 "+e.getMessage());
		}
		return finAppCount;
	}
	
	// 결재 완료함 -> 게시글 보여주기
	@Override
	public List<Approval> finAppListSearch(Approval approval) {
		List<Approval> finAppListSearch = null;
		System.out.println("ApprovalDaoImpl finAppListSearch Start...");
		System.out.println("ApprovalDaoImpl finAppListSearch approval->"+approval);
		try {
			finAppListSearch = session.selectList("finAppListSearch", approval);
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl allAppListSearch 에러 "+e.getMessage());
		}
		return finAppListSearch;
	}
	
	// 결재 대기함 -> 게시글 가져오기
	@Override
	public int stnApp() {
		int stnApp = 0;
		System.out.println("ApprovalDaoImpl stnApp Start");
		
		try {
			stnApp = session.selectOne("com.oracle.samil.SeDao.ApprovalDao.stnApp");
			System.out.println("ApprovalDaoImpl stnApp ok");
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl stnApp 에러"+e.getMessage());
		}
		return stnApp;
	}
	
	// 결재 대기함 -> 게시글 보여주기
	@Override
	public List<Approval> stnAppList(Approval approval) {
		List<Approval> stnList = null;
		System.out.println("ApprovalDaoImpl stnList Start");
		
		try {
			stnList = session.selectList("stnAppList", approval);
			System.out.println("ApprovalDaoImpl stnList" + stnList.size());
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl stnList e.getMessage() -> " + e.getMessage());
		}
		return stnList;
	}
	
	// 결재 완료함 -> 게시글 가져오기
	@Override
	public int condStnApp(Approval approval) {
		int stnAppCount = 0;
		System.out.println("ApprovalDaoImpl condStnApp start");
		
		try {
			stnAppCount = session.selectOne("condStnApp", approval);
			System.out.println("ApprovalDaoImpl condStnApp "+stnAppCount);
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl condStnApp 에러 "+e.getMessage());
		}
		return stnAppCount;
	}
	
	// 결재 완료함 -> 게시글 보여주기
	@Override
	public List<Approval> stnAppListSearch(Approval approval) {
		List<Approval> stnAppListSearch = null;
		System.out.println("ApprovalDaoImpl stnAppListSearch Start...");
		System.out.println("ApprovalDaoImpl stnAppListSearch approval->"+approval);
		try {
			stnAppListSearch = session.selectList("stnAppListSearch", approval);
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl stnAppListSearch 에러 "+e.getMessage());
		}
		return stnAppListSearch;
	}
	
	// 어드민 게시글 가져오기
	@Override
	public int adminApp() {
		int adminApp = 0;
		System.out.println("ApprovalDaoImpl adminApp Start");
		
		try {
			adminApp = session.selectOne("com.oracle.samil.SeDao.ApprovalDao.adminApp");
			System.out.println("ApprovalDaoImpl adminApp ok");
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl adminApp 에러"+e.getMessage());
		}
		return adminApp;
	}
	
	// 어드민 게시글 보여주기
	@Override
	public List<Approval> adminAppList(Approval approval) {
		List<Approval> adminList = null;
		System.out.println("ApprovalDaoImpl adminList Start");
		
		try {
			adminList = session.selectList("adminAppList", approval);
			System.out.println("ApprovalDaoImpl adminList" + adminList.size());
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl adminList e.getMessage() -> " + e.getMessage());
		}
		return adminList;
	}
	
	// 어드민 전체보관함 -> 게시글 가져오기
	@Override
	public int condAdminApp(Approval approval) {
		int adminAppCount = 0;
		System.out.println("ApprovalDaoImpl condAdminApp start");
		
		try {
			adminAppCount = session.selectOne("condAdminApp", approval);
			System.out.println("ApprovalDaoImpl condAdminApp "+adminAppCount);
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl condAdminApp 에러 "+e.getMessage());
		}
		return adminAppCount;
	}
	
	// 어드민 전체보관함 -> 게시글 보여주기
	@Override
	public List<Approval> adminAppListSearch(Approval approval) {
		List<Approval> adminAppListSearch = null;
		System.out.println("ApprovalDaoImpl adminAppListSearch Start...");
		System.out.println("ApprovalDaoImpl adminAppListSearch approval->"+approval);
		try {
			adminAppListSearch = session.selectList("adminAppListSearch", approval);
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl adminAppListSearch 에러 "+e.getMessage());
		}
		return adminAppListSearch;
	}
	
	// 조회
	@Override
	public Approval appDetail(int approvalNum, int documentFormId) {
	    System.out.println("ApprovalDaoImpl detailApp Start");
	    Approval approval = new Approval(); // Approval 객체로 변경

	    try {
	        Map<String, Object> params = new HashMap<>();
	        params.put("approvalNum", approvalNum);
	        params.put("documentFormId", documentFormId);
	        
	        approval = session.selectOne("detailApp", params);
	        System.out.println("ApprovalDaoImpl appDetail " + approval);
	    } catch (Exception e) {
	        e.printStackTrace(); // 로깅 등을 추가할 수 있습니다.
	    }

	    return approval; // Approval 객체에서 필요한 값 반환
	}

	
	// 결재라인 리스트 불러오기 
	@Override
	public List<ApprovalLine> approvalLineList(ApprovalLine approvalLine) {
		List<ApprovalLine> approvalLineList = null;
		System.out.println("ApprovalDaoImpl approvalLineList Start...");
		System.out.println("ApprovalDaoImpl approvalLineList approval->"+approvalLine);
		try {
			approvalLineList = session.selectList("approvalLineList", approvalLine);
			System.out.println("ApprovalDaoImpl approvalLineList approvalLineList.size()->"+approvalLineList.size());
			System.out.println("approvalLine->"+approvalLine);
		} catch (Exception e) {
			System.out.println("ApprovalDaoImpl approvalLineList 에러->"+e.getMessage());
		}
		return approvalLineList;
	}
	
	//작성내용변경
	@Override
	public int updateApp(Approval approval) {
		int result = 0;
		System.out.println("ApprovalDaoImpl updateApp Start...");
		try {
			result = session.insert("appUpdate", approval);
			System.out.println("ApprovalDaoImpl updateApp approval1 result ->"+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
