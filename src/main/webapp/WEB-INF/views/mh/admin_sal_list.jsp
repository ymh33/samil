<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../1.main/admin_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 급여대장 페이지입니다</title>
<style type="text/css">
table, th, tr, td {
	border: solid;
	border-collapse : collapse; 
}

</style>
</head>
<body>
	<h2>8월 급여대장</h2>
	<table><thead>
  <tr>
    <th colspan="9">2024-08 <td>명세서보기</td>
  </tr></thead>
<tbody>
  <tr>
    <td rowspan="2">체크박스</td>
    <td>사원번호</td>
    <td>성명</td>
    <td>기본급</td>
    <td>상여</td>
    <td>야간근로</td>
    <td>식대</td>
    <td>지급합계</td>
    <td>지급총액</td>
    <td>지급일</td>
  </tr>
  <tr>
    <td>부서</td>
    <td>직책</td>
    <td>소득세</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>공제총액</td>
    <td>-</td>
  </tr>
  <tr>
    <td>사원번호 검색</td>
    <td>성명 검색</td>
    <td>기본급 검색</td>
    <td>상여 검색</td>
    <td>지급일 검색</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
  </tr>
    <tr>
    <td rowspan="2">체크박스</td>
    <td>0111</td>
    <td>홍길동</td>
    <td>2000</td>
    <td>1000</td>
    <td>1000</td>
    <td>1000</td>
    <td>260</td>
    <td>2345</td>
    <td>2024-09-10</td>
  </tr>
  <tr>
    <td>개발</td>
    <td>부장</td>
    <td>1000</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>1000</td>
    <td>-</td>
    <td>-</td>
  </tr>
  
</tbody>
</table>
</body>
</html>