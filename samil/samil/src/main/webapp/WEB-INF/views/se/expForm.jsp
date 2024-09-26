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
    
    function printPage(){
        window.print();
    }
    
    function goBack() {
        window.history.go(-2);
    }
    
    function resetForm() {
        document.getElementById("myForm").reset();
        document.getElementById('usagePeriod').innerText = "";
        document.getElementById('usageDays').innerText = "";
        document.getElementById('fileNames').innerHTML = "";
        document.getElementById('attachedFileNames').innerHTML = "";

        const tableBody = document.getElementById('tableBody');

        // 기존 행 모두 삭제
        while (tableBody.firstChild) {
        tableBody.removeChild(tableBody.firstChild);
    }

        // 초기 행 추가
        addRow(); // 기본 행을 다시 추가

        document.getElementById('totalAmount').value = ""; // 합계 초기화
    }

    function addRow() {
        const tableBody = document.getElementById('tableBody');
        const newRow = document.createElement('tr');

        newRow.innerHTML = `
            <td>
                <select>
                    <option value="100">비품</option>
                    <option value="110">유류비</option>
                    <option value="120">공과금</option>
                    <option value="130">특수비용</option>
                </select>
            </td>
            <td><input type="text" placeholder="내용 입력"></td>
            <td><input type="text" placeholder="수량 입력"></td>
            <td><input type="text" placeholder="단가 입력"></td>
            <td><input type="number" placeholder="금액 입력" oninput="calculateTotal();"></td>
            <td><button type="button" onclick="deleteRow(this)">x</button></td>
        `;

        tableBody.appendChild(newRow);
        calculateTotal(); // 새로운 행 추가 후 총합 계산
    }

    function deleteRow(button) {
        const row = button.parentNode.parentNode;
        row.parentNode.removeChild(row);
        calculateTotal(); // 총합 계산 업데이트
    }

    function calculateTotal() {
        const rows = document.querySelectorAll('#tableBody tr');
        let total = 0;

        rows.forEach(row => {
            const amount = row.querySelector('input[type="number"]').value;
            if (amount && !isNaN(amount)) { // 금액이 숫자인 경우만 더함
                total += parseFloat(amount);
            }
        });

        document.getElementById('totalAmount').value = total;
    }
</script>
<% 
	String dfCode = request.getParameter("drafting");
	
	if (dfCode != null) {
		switch (dfCode) {
			case "130": dfCode = "법인"; break;
		    case "140": dfCode = "비품"; break;
		    case "150": dfCode = "유류비"; break;
	    }
	}
%>
<title><%out.print(dfCode);%></title>
</head>
<body>
<main id="printableArea">
    <form id="myForm" method="post">
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
                <td>${Approval.name}</td>
            </tr>
            <tr>
                <th>기안자부서</th>
                <td>${Approval.deptname}</td>
            </tr>
            <tr>
                <th>기안자직급</th>
                <td>${Approval.grade}</td>
            </tr>
        </table>
        <h2>아래와 같이 기안하오니 검토 후 결재 바랍니다.</h2>
        <h3><%out.print(dfCode);%> 요청 정보</h3>
        
		<table>
		    <thead>
		        <tr>
		        	<th></th>
		            <th>내용</th>
		            <th>수량</th>
		            <th>단가</th>
		            <th>금액</th>
		        </tr>
		    </thead>
		    <tbody id="tableBody">
		        <tr>
		            <td>
		                <select>
		                    <option value="100">비품</option>
		                    <option value="110">유류비</option>
		                    <option value="120">공과금</option>
		                    <option value="130">특수비용</option>
		                </select>
		            </td>
		            <td><input type="text" placeholder="내용 입력"></td>
		            <td><input type="text" placeholder="수량 입력"></td>
		            <td><input type="text" placeholder="단가 입력"></td>
		            <td><input type="number" placeholder="금액 입력" oninput="calculateTotal();"></td>
		       		<td></td>
		        </tr>
		    </tbody>
		</table>
		
		<button type="button" onclick="addRow()">추가</button>
		
		<div style="margin-top: 20px;">
		    <strong>합계:</strong>
		    <input type="number" id="totalAmount" readonly>
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
