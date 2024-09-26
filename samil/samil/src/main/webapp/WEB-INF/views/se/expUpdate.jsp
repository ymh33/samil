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
<title>${approval.documentFormTitle}</title>
</head>
<body>
<main id="printableArea">
    <form id="myForm" method="post">
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
		
        <table>
            <tr>
                <th>문서번호</th>
                <td>${approval.approvalNum}</td>
            </tr>
            <tr>
                <th>기안일자</th>
				<td>${approval.approvalDate}</td>
            </tr>
            <tr>
                <th>기안자</th>
                <td>${approval.name}</td>
            </tr>
            <tr>
                <th>기안자부서</th>
                <td>${approval.deptName}</td>
            </tr>
            <tr>
                <th>기안자직급</th>
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
        
		<table>
	     	<tr>
	     		<th>항목코드</th>
	     		<th>내용</th>
	     		<th>수량</th>
	     		<td>단가</td>
	     		<td>금액</td>
	     	</tr>
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
		            <td><input type="text" placeholder="내용 입력" value="${approval.costDetailsCnt}"></td>
		            <td><input type="text" placeholder="수량 입력" value="${approval.costQuantity}"></td>
		            <td><input type="text" placeholder="단가 입력"value="${approval.costUnitPrice}"></td>
		            <td><input type="number" placeholder="금액 입력" oninput="calculateTotal();" value="${approval.costAmount}"></td>
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
            <button type="submit">작성</button>
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
