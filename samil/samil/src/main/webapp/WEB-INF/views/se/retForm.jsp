<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../1.main/user_header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<% 
	String dfCode = request.getParameter("drafting");
	if (dfCode != null) {
		switch (dfCode) {
		    case "170": dfCode = "퇴직"; break;
	    }
	}
%>
<title><%out.print(dfCode);%></title>
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
        const startDateInput = document.getElementById('startDate').value;
        const endDateInput = document.getElementById('endDate').value;
        
        // 입력 값이 있는지 확인
        if (!startDateInput || !endDateInput) {
            document.getElementById('usagePeriod').textContent = '0개월';
            return;
        }

        const startDate = new Date(startDateInput);
        const endDate = new Date(endDateInput);
        
        if (endDate < startDate) {
            alert('종료일이 시작일보다 빠를 수 없습니다.');
            document.getElementById('usagePeriod').textContent = '0개월';
        } else {
            const timeDiff = endDate - startDate;
            const dayDiff = timeDiff / (1000 * 60 * 60 * 24); // 밀리초를 일수로 변환
            
            if (dayDiff < 1) {
                alert('근무일수가 1일 이상이어야 합니다.');
                document.getElementById('usagePeriod').textContent = '0개월';
            } else {
                const monthsDiff = (endDate.getFullYear() - startDate.getFullYear()) * 12 + (endDate.getMonth() - startDate.getMonth());
                document.getElementById('usagePeriod').textContent = monthsDiff + '개월';
            }
        }
    }


    
</script>
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
</head>
<body>
<main id="printableArea">
    <form id="myForm" action="approvalProcess.jsp" method="post">
        <table class="title">
            <tr>
                <td>결제</td>
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

        <h2><%out.print(dfCode);%> 승인 기안</h2>
		
        <table>
            <tr>
                <th>기안일자</th>
                <td id="draftDate"><%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %></td>
            </tr>
            <tr>
                <th>기안자</th>
                <th>${emp.name}</th>
            </tr>
            <tr>
                <th>기안자부서</th>
                <th>${demp.dempname}</th>
            </tr>
            <tr>
                <th>기안자직급</th>
                <th>${emp.grade}</th>
            </tr>
        </table>

        <h2>아래와 같이 기안하오니 검토 후 결재 바랍니다.</h2>
        <h3><%out.print(dfCode);%> 요청 정보</h3>
        <div>
		    <label for="usagePeriod">근무 기간:</label>
		    <span id="usagePeriod">0개월</span><br><br>
		</div>
        <div>
            <label for="startDate">입사일:</label>
            <input type="date" id="startDate" name="startDate" onchange="updateDay()"><br><br>
        </div>
        <div>
            <label for="endDate">퇴사일:</label>
            <input type="date" id="endDate" name="endDate" onchange="updateDay()"><br><br>
        </div>
        <div>
            <label for="reason">사유:</label>
            <textarea class="text-box" id="reason" name="reason" placeholder="사유를 입력하세요"></textarea>
        </div>

        <h3>첨부 파일</h3>
        <div style="margin-bottom: 20px;">
            <label for="relatedDocument">연관문서:</label>
            <button type="button" onclick="document.getElementById('relatedDocument').click()" style="margin-top: 5px;">찾아보기</button>
            <input type="file" id="relatedDocument" name="relatedDocument" style="display:none;" multiple onchange="addFileNames('fileNames', this.files)"/>
            <div id="fileNames" style="margin-top: 10px; display: flex; flex-direction: column;"></div>
        </div>
        <div style="margin-bottom: 20px;">
            <label for="fileAttachment">파일첨부:</label>
            <button type="button" onclick="document.getElementById('fileAttachment').click()" style="margin-top: 5px;">찾아보기</button>
            <input type="file" id="fileAttachment" name="fileAttachment" style="display:none;" multiple onchange="addFileNames('attachedFileNames', this.files)"/>
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
