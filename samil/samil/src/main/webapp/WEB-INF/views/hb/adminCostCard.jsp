<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../1.main/admin_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 카드</title>
<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }
    main {
        max-width: 1200px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h2 {
        color: #333;
        border-bottom: 2px solid #8C8C8C; /* 제목 밑줄 색상 */
        padding-bottom: 10px;
        margin-bottom: 20px;
        text-align: center;
    }
    a {
        text-decoration: none;
    }
     .button-container {
        display: flex; /* Flexbox 사용 */
        justify-content: center; /* 수평 중앙 정렬 */
        margin-bottom: 20px; /* 버튼과 테이블 사이 여백 */
    }
    input[type="button"] {
        background-color: #8C8C8C; /* 버튼 배경색 */
        color: white;
        border: none;
        padding: 10px 20px;
        margin: 10px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        text-transform: uppercase;
        transition: background-color 0.3s ease;
        text-align:center;
    }
    input[type="button"]:hover {
        background-color: #7A7A7A; /* 마우스 오버 시 색상 */
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        padding: 12px;
        border: 2px solid #ddd;
        text-align: center;
    }
    th {
        background-color: #8C8C8C; /* 테이블 헤더 배경색 */
        color: white;
        font-size: 16px;
    }
    tr:nth-child(even) {
        background-color: #f0f0f0; /* 짝수 행 색상 */
    }
    tr:hover {
        background-color: #d9d9d9; /* 행 마우스 오버 색상 */
    }
</style>
</head>
<body>
    <main>
        <h2>카드 관리</h2>
         <div class="button-container">
 		       <a href="adminCostCardPlus"><input type="button" value="내역 추가"></a>
        		<a href="adminCostCardAdd"><input type="button" value="카드 추가"></a>
        </div>
        <table>
            <thead>
                <tr>
                    <th>순서</th>
                    <th>카드번호</th>
                    <th>카드사</th>
                    <th>보유직원</th>
                    <th>분실신청</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="card" items="${cardList}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${card.cardNum}</td>
                        <td>${card.cardBank}</td>
                        <td>${card.name}</td>
                        <td>
						 <c:choose>
                                <c:when test="${card.cardPermit == 0}">
                                    <span style="color: blue;">${cardMap[card.cardPermit]}</span>
                                </c:when>
                                <c:when test="${card.cardPermit == 110}">
                                    <span style="color: green;">${cardMap[card.cardPermit]}</span>
                                </c:when>
                                <c:otherwise>
                                    <span style="color: gray;">${cardMap[card.cardPermit]}</span>
                                </c:otherwise>
                            </c:choose>
                    </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
</body>
</html>
