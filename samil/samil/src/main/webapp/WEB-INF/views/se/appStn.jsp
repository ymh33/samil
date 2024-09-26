<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../1.main/user_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	.status-red {
	    background-color: rgb(255, 36, 36);
	    color: black; /* Optional: Change text color for better contrast */
	}
	
	.status-green {
	    background-color: rgb(89, 218, 80);
	    color: black; /* Optional */
	}
	
	.status-yellow {
	    background-color: rgb(247, 234, 110);
	    color: black; /* Optional */
	}
	
	.status-white {
	    background-color: rgb(189, 189, 189);
	    color: black; /* Optional */
	}
</style>
<title>결재</title>
</head>
<body>
<main>
    <h2>결재대기</h2>
	<h3>전체 게시글 : ${stnApp}</h3>
					<!-- 문서번호 프로시저사용예정 -->
	<table>
		<tr>
			<th>문서번호</th><th>작성자</th><th>제목</th><th>기안일</th><th>결재상태</th><th>승인일</th>
		</tr>
		<c:forEach var="Approval" items="${stnAppList}">
			<c:if test="${Approval.approvalNum != lastApprovalNum}">
		        <tr>
		            <!-- 문서번호 시퀀스 사용예정 -->
		            <td>${Approval.approvalNum}</td>
		            <td>${Approval.name}</td>
		            <td><a href="appDetail?approvalNum=${Approval.approvalNum}&documentFormId=${Approval.documentFormId}">${Approval.approvalTitle}</a></td>
		            <td>${Approval.approvalDate}</td>
		            <td class="${Approval.approvalCondition == 130 ? 'status-red' : 
		                         Approval.approvalCondition == 120 ? 'status-green' : 
		                         Approval.approvalCondition == 110 ? 'status-yellow' : 
		                         Approval.approvalCondition == 100 ? 'status-white' : ''}">
		                ${statusMap[Approval.approvalCondition]}
		            </td>
		            <td>${Approval.approvalCompleteDate}</td>
		        </tr>
		        <c:set var="lastApprovalNum" value="${Approval.approvalNum}" />
		    </c:if>
		</c:forEach>
	</table>
	
	<c:set var="num" value="${page.total-page.start+1 }"></c:set>
	
	<c:if test="${page.startPage > page.pageBlock}">
		<a href="appStn?currentPage=${page.startPage-page.pageBlock}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${page.startPage}" end="${page.endPage }">
		<a href="appStn?currentPage=${i}">[${i }]</a>
	</c:forEach>
	<c:if test="${page.endPage < page.totalPage}">
		<a href="appStn?currentPage=${page.startPage + page.pageBlock}">[다음]</a>
	</c:if>	
	
	<p><a href="draftingForm">기안 작성</a><p>
	
	<form action="stnAppListSearch">
		<select name="search">
			<option value="s_approvalTitle">제목</option>
			<option value="s_approvalCondition">내용</option>
			<option value="s_name">작성자</option>
		</select>
		<input type="text" name="keyword">
		<button type="submit">검색</button><p>
	</form>
</main>
</body>
</html>