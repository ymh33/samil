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

    function addFileNames(divId, files) {
        const fileNamesDiv = document.getElementById(divId);
        fileNamesDiv.innerHTML = ""; // 기존 파일 이름 지우기

        for (const file of files) {
            const fileNameElement = document.createElement('div');
            fileNameElement.textContent = file.name;
            fileNamesDiv.appendChild(fileNameElement);
        }
    }

    function printPage() {
        window.print();
    }
    
    function goBack() {
        window.history.go(-2);
    }
    
    function updateDay() {
        const startDateInput = document.getElementById('startDate');
        const endDateInput = document.getElementById('endDate');
        const usageDays = document.getElementById('usageDays');
        
        const startDate = startDateInput.value;
        const endDate = endDateInput.value;
        
        if (startDate && endDate) {
            const start = new Date(startDate);
            const end = new Date(endDate);
            
            // 날짜 차이를 계산
            const timeDiff = end - start;
            const dayDiff = timeDiff / (1000 * 3600 * 24) + 1; // 시작일 포함
            
            if (dayDiff < 1) {
                alert("종료일은 시작일보다 이후여야 합니다.");
                // 초기화
                startDateInput.value = "";
                endDateInput.value = "";
                usageDays.textContent = ""; // 사용일 수를 지우기
                document.getElementById('usagePeriod').textContent = ""; // 사용 기간도 초기화
            } else {
                usageDays.textContent = dayDiff + "일"; // 사용일 수 표시
            }
            
            // 사용 기간 출력
            if (dayDiff >= 1) {
                document.getElementById('usagePeriod').textContent = startDate + " ~ " + endDate;
            }
        } else {
            usageDays.textContent = ""; // 초기화
            document.getElementById('usagePeriod').textContent = ""; // 초기화
        }
    }
		
    function resetForm() {
        document.getElementById('leaveForm').reset(); // 폼 초기화
        document.getElementById('usageDays').textContent = ""; // 사용일 수 초기화
        document.getElementById('usagePeriod').textContent = ""; // 사용 기간 초기화
        document.getElementById('fileNames').innerHTML = ""; // 첨부 파일 이름 초기화
        document.getElementById('attachedFileNames').innerHTML = ""; // 연관문서 파일 이름 초기화
    }
</script>
<% 
	String dfCode = request.getParameter("drafting");
	
	if (dfCode != null) {
		switch (dfCode) {
			case "100": dfCode = "연차"; break;
		    case "110": dfCode = "병가"; break;
		    case "120": dfCode = "경조사"; break;
		    case "160": dfCode = "휴직"; break;
	    }
	}
%>
<title><%out.print(dfCode);%></title>
</head>
<body>
<main id="printableArea">
    <form id="leaveForm" method="post">
        <table class="title">
            <tr>
                <td>결재</td>
                <td><span id="paymentList"></span></td>
                <td><button type="button" onclick="appLine()">+</button></td>
            </tr>
            <tr>
            	<td>참조</td>
            	<td><button type="button" onclick="appLine()">+</button></td>
            <tr>    
                <td>제목: <input type="text" name="title" required></td>
            </tr>    
        </table>

        <h2><%out.print(dfCode);%>요청 기안</h2>
        <table class="approval">
        	<tr>
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
			                <c:when test="${appLine.job == 110}">팀장</c:when>
			                <c:when test="${appLine.job == 120}">대표</c:when>
			                <c:otherwise>( ${appLine.grade} )</c:otherwise>
			            </c:choose>
			            <c:if test="${!status.last}"> </c:if>
			    	</c:if>
			    </c:forEach>
        	</tr>
        	<tr>
        		<th>도장위치</th>
        		<th>도장위치</th>
        		<th>도장위치</th>
        	</tr>	
        	<tr>
        		<th>확인일</th>
        		<th>확인일</th>
        		<th>확인일</th>
        	</tr>	
        </table>
		<table class="draft">
			<tr>	
				<td>기안일자</td>
				<td id="draftDate"><%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %></td>
			</tr>
			<tr>	
				<td>기안자</td>
				<td>${Approval.name}</td>
			</tr>
			<tr>	
				<td>기안자부서</td>
				<td>${Approval.deptname}</td>
			</tr>
			<tr>	
				<td>기안자직급</td>
				<td>${Approval.grade} ${Approval.job}</td>
			</tr>
		</table>
        <h2>아래와 같이 기안하오니 검토 후 결재 바랍니다.</h2>
        <h3><%out.print(dfCode);%> 사용 정보</h3>
        <div>
            <label for="usagePeriod"><%out.print(dfCode);%> 사용 기간</label>
            <span id="usagePeriod"></span><br>
            <label>사용일</label>
            <span id="usageDays"></span><br><br>
        </div>
        <div>
            <label for="startDate">시작일:</label>
            <input type="text" id="furloughStartDate" name="furloughStartDate" onchange="updateDay()"><br><br>
        </div>
        <div>
            <label for="endDate">종료일:</label>
            <input type="text" id="furloughEndDate" name="furloughEndDate" onchange="updateDay()"><br><br>
        </div>

        <h3>사유:</h3>
        <div>
            <textarea class="text-box" id="furloughCnt" name="furloughCnt" placeholder="사유를 입력하세요"></textarea>
        </div>

        <h3>첨부 파일</h3>
        <div style="margin-bottom: 20px;">
            <label for="relatedDocuments">연관문서:</label>
            <button type="button" onclick="document.getElementById('relatedDocument').click()" style="margin-top: 5px;">찾아보기</button>
            <input type="file" id="relatedDocuments" name="relatedDocuments" style="display:none;" multiple onchange="addFileNames('fileNames', this.files)"/>
            <div id="fileNames" style="margin-top: 10px; display: flex; flex-direction: column;"></div>
        </div>
        <div style="margin-bottom: 20px;">
            <label for="imageAttachment">파일첨부:</label>
            <button type="button" onclick="document.getElementById('fileAttachment').click()" style="margin-top: 5px;">찾아보기</button>
            <input type="file" id="imageAttachment" name="imageAttachment" style="display:none;" multiple onchange="addFileNames('attachedFileNames', this.files)"/>
            <div id="attachedFileNames" style="margin-top: 10px; display: flex; flex-direction: column;"></div>
        </div>

        <div class="button-group">
            <button type="button" onclick="submitForm()">작성</button>
            <button type="button" onclick="resetForm()">초기화</button>
            <button type="button" onclick="recoveryForm()">회수</button>
            <button type="button" onclick="deleteForm()">삭제</button>
            
            <button type="button" onclick="goBack()">목록</button>
            <button type="button" class="print" onclick="printPage()">인쇄</button>
        </div>
    </form>
</main>
</body>
</html>
