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
        
    }
    main {
        padding: 30px 10%;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin: 20px auto;
        border-radius: 8px;
    }
    h2 {
        color: #333;
        border-bottom: 2px solid #3333CC; /* 진한 파란색 */
        padding-bottom: 10px;
    }
    .container {
        text-align: center;
        margin-bottom: 20px;
    }
    .searchCardBox, .searchCard {
        width: 200px; /* 크기 통일 */
        height: 30px;
        padding: 5px;
        border-radius: 5px;
        border: 1px solid #ccc;
        margin-right: 10px;
        transition: border-color 0.3s; /* 부드러운 효과 */
    }
    .searchCardBox:focus, .searchCard:focus {
        border-color: #3333CC; /* 진한 파란색 포커스 */
        outline: none;
    }
    . submitButton {
    	background-color: #3333CC
    }
    .searchCard {
        background-color: white; /* 버튼 배경색 */
        color: black; /* 버튼 글자색 */
        cursor: pointer;
        border: none;
        border-radius: 5px;
        padding: 5px 10px;
        transition: background-color 0.3s; /* 부드러운 효과 */
    }
    .searchCard:hover {
        background-color: #3333CC; /* 버튼 호버 시 색상 변경 */
    }
    .cardLost {
        float: right;
        margin: 20px;
        background-color: #3333CC; /* 진한 파란색 */
        color: #fff;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s; /* 부드러운 효과 */
    }
    .cardLost:hover {
        background-color: #005999; /* 버튼 호버 시 색상 변경 */
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        padding: 12px;
        text-align: center;
        border: 1px solid #ddd;
    }
    th {
        background-color: #3333CC; /* 진한 파란색 헤더 배경 */
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #e0e0e0;
    }
    .CardUseNum {
        width: 60px;
    }
</style>
<title>카드</title>
</head>
<body>
<main>
    <h2>카드 사용내역 페이지입니다</h2>
    <hr/>
    <div class="container">
        <form action="cardUseSearch" method="get" class="searchCard">
            <select name="search" id="cost_searchCard" class="searchCard">
                <option value="cardNum">카드번호</option>
                <option value="empno">보유직원</option>
                <option value="deptno">부서이름</option>
                <option value="useDate">사용일</option>           
            </select>
            <input type="text" name="keyword" class="searchCardBox" placeholder="검색어를 입력하세요">
            <button type="submit" class="searchCard">검색</button>
        </form>
    </div>
    <a href="costCardLost">
        <input type="button" class="cardLost" value="분실 신고">
    </a>
    <table>
        <tr>
            <td class="CardUseNum">순서</td>
            <th>카드번호</th>
            <th>사용처</th>
            <th>보유직원/부서이름</th>
            <th>사용일</th>
            <th>금액</th>
        </tr>
        <c:forEach var="cardUse" items="${cardUseList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${cardUse.cardNum}</td>
                <td>${cardUse.place}</td>
                <td>${cardUse.name}/${cardUse.deptno }</td>
                <td>${cardUse.useDate}</td>
                <td>${cardUse.cardCost}</td>
            </tr>
        </c:forEach>
    </table>
</main>
</body>
</html>
