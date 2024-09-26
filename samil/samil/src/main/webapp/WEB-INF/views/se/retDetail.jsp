<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../1.main/user_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	@media print {
	 	@page {
            size: A4; /* 페이지 크기 설정 (A4) */
            margin: 0; /* 여백 제거 */
        }
        
	    body * {
	        display: none; /* 모든 요소 숨김 */
	        transform: scale(0.9);
	        height: auto;
	    }
	    #printableArea, #printableArea * {
	        display: block; /* 인쇄할 영역 보이기 */
	    }
	}
</style>
<script>
    function appLine() {
        window.open('orgChart', 'popupWindow', 'width=600, height=400');
    }

    function printPage() {
        window.print();
    }
    
    function goBack() {
        window.history.go(-1);
    }
    
</script>
<title>${approval.documentFormTitle}</title>
</head>
<body>
<main id="printableArea">
    <form id="myForm" action="approvalProcess.jsp" method="post">
        <table class="title">
            <tr>
			    <td>결재:
			    <c:forEach var="appLine" items="${approvalLineList}" varStatus="status">
			    	<c:if test="${appLine.approverOrder <= 130}">
				        ${appLine.name} 
				        <c:choose>
			                <c:when test="${appLine.grade == 100}">사원</c:when>
			                <c:when test="${appLine.grade == 110}">주임</c:when>
			                <c:when test="${appLine.grade == 120}">대리</c:when>
			                <c:when test="${appLine.grade == 130}">과장</c:when>
			                <c:when test="${appLine.grade == 140}">차장</c:when>
			                <c:when test="${appLine.grade == 150}">부장</c:when>
			                <c:when test="${appLine.grade == 160}">사장</c:when>
			                <c:otherwise>( ${appLine.grade} )</c:otherwise>
			            </c:choose>
			            <c:if test="${!status.last}"> </c:if>
			    	</c:if>
			    </c:forEach>
			</td>
			</tr>
			<tr>
			    <td>참조:
			    <c:forEach var="appLine" items="${approvalLineList}" varStatus="status">
			        <c:if test="${appLine.approverOrder >= 900}">
			            ${appLine.name} 
			            <c:choose>
			                <c:when test="${appLine.grade == 100}">사원</c:when>
			                <c:when test="${appLine.grade == 110}">주임</c:when>
			                <c:when test="${appLine.grade == 120}">대리</c:when>
			                <c:when test="${appLine.grade == 130}">과장</c:when>
			                <c:when test="${appLine.grade == 140}">차장</c:when>
			                <c:when test="${appLine.grade == 150}">부장</c:when>
			                <c:when test="${appLine.grade == 160}">사장</c:when>
			                <c:otherwise>( ${appLine.grade} )</c:otherwise>
			            </c:choose>
			            <c:if test="${!status.last}"> </c:if>
			        </c:if>
			    </c:forEach>
				</td>
			</tr>
			<tr>    
                <td>제목: ${approval.approvalTitle}</td>
            </tr>    
        </table>

        <h2>${approval.documentFormTitle} 승인 기안</h2>
        <div class="button-group">
            <button type="submit" name="action" value="approve">결재</button>
            <button type="submit" name="action" value="reject">반려</button>
            <button type="submit" name="action" value="finalApprove">전결</button>
            <button type="submit" name="action" value="carryOver">이월</button>
        </div>
		<c:forEach var="appLine" items="${approvalLineList}" varStatus="status">
		    <c:if test="${appLine.approverOrder <= 130}">
		        ${appLine.name} 
		        <c:choose>
		            <c:when test="${appLine.grade == 100}">사원</c:when>
		            <c:when test="${appLine.grade == 110}">주임</c:when>
		            <c:when test="${appLine.grade == 120}">대리</c:when>
		            <c:when test="${appLine.grade == 130}">과장</c:when>
		            <c:when test="${appLine.grade == 140}">차장</c:when>
		            <c:when test="${appLine.grade == 150}">부장</c:when>
		            <c:when test="${appLine.grade == 160}">사장</c:when>
		            <c:otherwise>( ${appLine.grade} )</c:otherwise>
		        </c:choose>
		        <c:if test="${!status.last}"> | </c:if>
		    </c:if>
		</c:forEach>
		<br />
		<c:forEach var="appLine" items="${approvalLineList}" varStatus="status">
		    <c:if test="${appLine.approverOrder <= 130}">
		        <div style="display: inline-block; margin-right: 10px;">
		            <c:choose>
		                <c:when test="${appLine.approvalType == 120 || appLine.approvalType == 140}">
		                    <img src="/se/Yes.png" alt="Final Yes" style="width: 80px; height: 80px;"/> 
		                </c:when>
		                <c:when test="${appLine.approvalType == 130}">
		                    <img src="/se/None.png" alt="None" style="width: 80px; height: 80px;"/> 
		                </c:when>
		                <c:when test="${appLine.approvalType == 110}">
		                    <img src="/se/FinalYes.png" alt="Yes" style="width: 80px; height: 80px;"/> 
		                </c:when>
		                <c:otherwise>
		                    <!-- 다른 경우에 대한 처리 (필요 시) -->
		                </c:otherwise>
		            </c:choose>
		        </div>
		        <c:if test="${!status.last}"> | </c:if>
		    </c:if>
		</c:forEach>
		<div style="margin-top: 10px;">
		    <c:forEach var="appLine" items="${approvalLineList}" varStatus="status">
		        <c:if test="${appLine.approverOrder <= 130}">
		            <span style="margin-right: 10px;">${appLine.approvalCompleteDate}</span>
		            <c:if test="${!status.last}"> | </c:if>
		        </c:if>
		    </c:forEach>
		</div>
        <table class="draft">
			<tr>
				<td>문서번호</td>
				<td>${approval.approvalNum}</td>
			</tr>
			<tr>	
				<td>기안일자</td>
				<td>${approval.approvalDate}</td>
			</tr>
			<tr>	
				<td>기안자</td>
				<td>${approval.name}</td>
			</tr>
			<tr>	
				<td>기안자부서</td>
				<td>${approval.deptName}</td>
			</tr>
			<tr>	
				<td>기안자직급</td>
				<td>
				  ${approval.grade == 100 ? '사원' :
				    approval.grade == 110 ? '주임' :
				    approval.grade == 120 ? '대리' :
				    approval.grade == 130 ? '과장' :
				    approval.grade == 140 ? '차장' :
				    approval.grade == 150 ? '부장' :
				    approval.grade == 160 ? '사장' : 'Unknown'}
				</td>
			</tr>
		</table>

        <h2>아래와 같이 기안하오니 검토 후 결재 바랍니다.</h2>
        <h3>${approval.documentFormTitle} 요청 정보</h3>
        <div>
		    <label for="usagePeriod">근무 기간: ${approval.furloughStartDate} ~ ${approval.furloughEndDate}</label>
		</div>
        <div>
            <label for="startDate">입사일: ${approval.furloughStartDate}</label>
        </div>
        <div>
            <label for="endDate">퇴사일: ${approval.furloughEndDate}</label>
        </div>
        <div>
            <label for="reason">사유: ${approval.furloughCnt}</label>
        </div>

        <div style="margin-bottom: 20px;">
            <label for="relatedDocument">연관문서</label>
            <label>${approval.relatedDocuments} </label>
        </div>
        <div style="margin-bottom: 20px;">
            <label for="fileAttachment">파일첨부</label>
            <label>${approval.imageAttachment} </label>
        </div>

        <h3>결재 코멘트 : </h3>
			    <c:forEach var="appLine" items="${approvalLineList}" varStatus="status">
			        <c:if test="${appLine.approverOrder <= 130}">
			            ${appLine.name} 
			            <c:choose>
			                <c:when test="${appLine.grade == 100}">사원</c:when>
			                <c:when test="${appLine.grade == 110}">주임</c:when>
			                <c:when test="${appLine.grade == 120}">대리</c:when>
			                <c:when test="${appLine.grade == 130}">과장</c:when>
			                <c:when test="${appLine.grade == 140}">차장</c:when>
			                <c:when test="${appLine.grade == 150}">부장</c:when>
			                <c:when test="${appLine.grade == 160}">사장</c:when>
			                <c:otherwise>( ${appLine.grade} )</c:otherwise>
			            </c:choose>
			            <c:if test="${!status.last}"> </c:if>
			            ${appLine.approvalCnt}<br/>
			        </c:if>
			    </c:forEach>
        <div class="button-group">
            <button type="button" onclick="goBack()">목록</button>
			<input type="button" value="수정" 
                onclick="location.href='appUpdateForm?approvalNum=${approval.approvalNum}&documentFormId=${approval.documentFormId}'">
			<input type="button" value="삭제" onclick="location.href='deleteEmp?empno=${emp.empno}'">	
            <button type="button" class="print" onclick="printPage()">인쇄</button>
        </div>
    </form>
</main>
</body>
</html>
