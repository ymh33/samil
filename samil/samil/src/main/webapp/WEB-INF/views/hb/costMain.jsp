<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../1.main/user_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정산 메인 페이지입니다</title>
<style type="text/css">
    .container {
        display: flex; /* Flexbox 활성화 */
        justify-content: space-between; /* 아이템 사이의 간격 조정 */
        padding: 20px; /* 컨테이너 내부 여백 */
    }
    .utility {
        width: 48%; /* 박스의 너비 */
        height: 300px; /* 박스의 높이 */
        border: 2px solid #000; /* 박스의 테두리 */
        padding: 20px; /* 박스 내부 여백 */
        background-color: #f0f0f0; /* 박스 배경 색상 */
        box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
        border-radius: 8px; /* 모서리 둥글게 하기 */
        text-align: center; /* 텍스트 정렬 */
    }
    .card, .cost {
        width: 48%; /* 카드의 너비 */
        height: 300px; /* 카드의 높이 */
        border: 2px solid #000; /* 카드의 테두리 */
        padding: 10px; /* 카드 내부 여백 */
        text-align: center; /* 카드 내부 텍스트 정렬 */
        border-radius: 8px; /* 카드 모서리 둥글게 하기 */
    }
    .tg {
        border-collapse: collapse;
        border-spacing: 0;
        width: 100%;
        height: 300px;
    }
    .tg td, .tg th {
        border-color: black;
        border-style: solid;
        border-width: 1px;
        overflow: hidden;
        padding: 10px 5px;
        word-break: normal;
    }
    .tg .tg-0lax {
        text-align: left;
        vertical-align: top;
    }
</style>
</head>
<body>
    <h1>정산 메인입니다</h1>
    <div class="container">
        <div class="utility"><a href="costUtility">공과금 자리</a></div>
        <div class="cost"><a href="costCost">정산 자리</a></div>        
        <div class="card"><a href="costCard">카드 자리</a></div>
    </div>

    <table class="tg">
        <thead>
            <tr>
                <th>하이</th>
                <th>방가</th>
                <th>하이</th>
                <th>방가</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td class="tg-0lax"><a href="costCost">하이</a></td>
                <td class="tg-0lax"><a href="costCost">하이</a></td>
                <td class="tg-0lax"><a href="costCard">하이</a></td>
                <td class="tg-0lax"><a href="costCardLost">하이</a></td>
            </tr>
        </tbody>
    </table>
</body>
</html>
