<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../1.main/user_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
   body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        justify-content: center; /* 수평 중앙 정렬 */
        align-items: center; /* 수직 중앙 정렬 */
        height: 100vh; /* 전체 화면 높이*/
    }
    main {
        padding: 30px 10%;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin: 20px auto;
        border-radius: 8px;
    }
    h2 {
        color: #3333CC; /* 진한 파란색 제목 */
        border-bottom: 2px solid #3333CC; /* 제목 아래 선 */
        padding-bottom: 10px;
        margin-bottom: 20px;
    }
 
    table {
        margin: 20px auto; /* 테이블을 가운데 정렬 */
        width: 100%; /* 테이블 폭을 100%로 설정 */
        border-collapse: collapse;
        border-radius: 8px; /* 테이블 둥글게 */
        overflow: hidden; /* 모서리 둥글게 보이도록 */
    }
    .tg {
        border: none;
        border-color: #4d4d4d;
    }
    .tg td {
        border-color: #007acc;
        color: #333333;
        overflow: hidden;
        padding: 10px 5px;
        word-break: normal;
    }
    .tg th {
        background-color: #3333CC; /* 진한 파란색 헤더 배경 */
        border-color: #005999;
        color: #ffffff;
        font-size: 14px;
        font-weight: normal;
        overflow: hidden;
        padding: 10px 5px;
        word-break: normal;
    }
    .tg .header-center {
        text-align: center;
        vertical-align: top;
    }
    .tg .cell-center {
        text-align: center;
        vertical-align: top;
    }
    .tg .bold-header {
        font-family: "Arial Black", Gadget, sans-serif !important;
    }
    .search-container {
        display: flex; /* Flexbox 사용 */
        justify-content: center; /* 수평 중앙 정렬 */
        margin-bottom: 20px; /* 버튼과 테이블 사이 공간 추가 */
    }
     select, .searchCostBox {
        background-color: #3333CC;
        width: 200px; /* 두 개의 요소 크기 동일하게 설정 */
        height: 30px; /* 높이 동일하게 설정 */
        padding: 5px;
        border-radius: 5px;
        background-color: #ffffff;
        border: 1px solid #ccc; /* 테두리 추가 */
        margin-right: 5px; /* 버튼과의 간격 */
    }
    
    .searchCostBox {
        width: 200px; /* 검색 상자의 폭 설정 */
        padding: 5px;
        border-radius: 5px;
        background-color: #ffffff;
        border: 1px solid #ccc; /* 테두리 추가 */
        margin-right: 5px; /* 버튼과의 간격 */
    }
    button {
        padding: 5px 10px;
        border: none;
        border-radius: 5px; /* 둥글게 */
        background-color: #3333CC; /* 버튼 배경색 */
        color: #ffffff; /* 버튼 글자색 */
        cursor: pointer;
        transition: background-color 0.3s; /* 부드러운 색상 변경 */
    }
    button:hover {
        background-color: #005999; /* 버튼 호버 시 색상 변경 */
    }
    .costPlus {
        margin: 20px 0; /* 테이블과 버튼 사이 공간 추가 */
        text-align:right;
    }
    .pagination {
        display: inline-block;
        margin: 20px;
    }
    .pagination a {
        color: #3333CC; /* 진한 파란색 */
        padding: 8px 16px;
        text-decoration: none;
        border: 1px solid #3333CC; /* 테두리 색상 */
        border-radius: 5px; /* 둥글게 */
        transition: background-color 0.3s; /* 부드러운 색상 변경 */
    }
    .pagination a.active {
        background-color: #3333CC; /* 활성화된 페이지 색상 */
        color: white;
    }
    .pagination a:hover:not(.active) {
        background-color: #ddd; /* 호버 시 색상 변경 */
    }
   
</style>
<title>정산</title>
</head>
<body>
    <main>
        <h2>정산 페이지입니다</h2>
        		당신의 사번 : ${emp.name }

        	<hr color="#3333CC">
        
     <div class="container">
		    <form action="costSearch" method="get" class="searchCost">
		        <select name="search" id="searchCost" class="searchCost">
		            <option value="codeName">비용항목</option>
		            <option value="empno">신청자</option>
		            <option value="status">신청상태</option>       
		        </select>
		        <input type="text" name="keyword" class="searchCostBox" placeholder="검색어를 입력하세요">
		        <button type="submit" value="검색">검색</button>
		    </form>
		</div>

        <div class="costPlus">
			<a href="costPlus"><input type="button" value="정산 신청"></a>
        </div>
        	<c:set var="num" value="${page.total-page.start+1 }"></c:set>

        <table class="tg">
            <thead>
                <tr>
                    <th class="bold-header header-center">순서</th>
                    <th class="header-center">비용항목</th>
                    <th class="header-center">처리상태</th>
                    <th class="header-center">제목</th>
                    <th class="header-center">신청자</th>
                    <th class="header-center">부서</th>
                    <th class="header-center">신청날짜</th>
                    <th class="header-center">금액</th>
                    <th class="header-center">문서번호</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cost" items="${costList}" varStatus="status">
                    <tr>
                        <td class="cell-center">${status.index + 1}</td>
                        <td class="cell-center">${cost.codeName}</td>
                     <td class="cell-center">
					    <c:choose>
					        <c:when test="${cost.status == 100}">
					            <span style="color: blue;">${costMap[cost.status]}</span>
					        </c:when>
					        <c:when test="${cost.status == 110}">
					            <span style="color: green;">${costMap[cost.status]}</span>
					        </c:when>
					        <c:when test="${cost.status == 120}">
					            <span style="color: red;">${costMap[cost.status]}</span>
					        </c:when>
					        <c:otherwise>
					            <span>${cost.status}</span> 
					        </c:otherwise>
					    </c:choose>
					</td>
                        <td class="cell-center">${cost.costTitle}</td>
                        <td class="cell-center">${cost.name}</td>
                        <td class="cell-center">${cost.deptno}</td> <!-- 부서 필드가 있을 경우 사용 -->
                        <td class="cell-center">${cost.signdate}</td>
                        <td class="cell-center">${cost.costMoney}</td>
                        <td class="cell-center">${cost.costYear}-${cost.signdate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
	    <c:if test="${page.startPage > page.pageBlock }">
			<a href="listEmp?currentPage=${page.startPage-page.pageBlock}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
			<a href="listEmp?currentPage=${i}">[${i}]</a>
		</c:forEach>
		<c:if test="${page.endPage < page.totalPage }">
			<a href="listEmp?currentPage=${page.startPage+page.pageBlock}">[다음]</a>
		</c:if>	
</body>
</html>
