<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../1.main/admin_header.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>관리자 근태</title>
<style type="text/css">
h2 {
	font-size: 20px; /* px로 수정 */
	margin-left: 200px;
}

/* form-group 클래스 설정 */
.container {
	display: flex; /* Flexbox 사용 */
	align-items: center; /* 수직 정렬 */
	gap: 20px; /* 요소 간 간격 조정 */
	justify-content: flex-end; /* 자식 요소들을 오른쪽으로 정렬 */
	padding: 0 200px; /* 왼쪽 및 오른쪽 여백 설정 */
}

/* 옵션, 입력란, 버튼 스타일 */
.container select, .container input, .container button {
	font-size: 15px; /* 제목과 같은 폰트 크기 */
	padding: 10px 15px; /* 제목과 같은 패딩 */
	border: 1px solid #ccc; /* 테두리 */
	border-radius: 4px; /* 둥근 모서리 */
	box-sizing: border-box; /* 패딩과 테두리를 포함한 총 너비와 높이 계산 */
}

/* 옵션, 입력란 스타일 */
.container select, .container input {
	width: 300px; /* 원하는 너비로 설정 */
	height: 40px;
}

/* 버튼 스타일 */
.container button {
	background-color: #007bff; /* 버튼 배경 색상 */
	color: white; /* 버튼 글자 색상 */
	cursor: pointer; /* 버튼 클릭 시 커서 모양 변경 */
	border: none; /* 버튼의 기본 테두리 제거 */
	min-width: 100px; /* 최소 너비 설정 */
}

.container button:hover {
	background-color: #0056b3; /* 버튼 hover 시 배경 색상 변경 */
}

table {
	border-collapse: collapse; /* 셀 간격을 없애고 경계선을 통합 */
	width: calc(100% - 400px); /* 화면 너비에서 좌우 마진을 제외한 너비 */
	margin: 30px 200px;
	text-align: center;
}

tr {
	height: 30px;
	background: yellow;
}

th {
	background: #D5D5D5;
	border-bottom: 2px solid #000000;
	height: 40px;
	font-size: 18px;
}

td {
	background: #FFFFFF;
}

.status_red {
	color: #FF2424;
	font-weight: bold;
}

/* Placeholder 스타일 */
::placeholder {
	font-size: 15px; /* 글씨 크기 조정 */
}
</style>
</head>
<body>
	<form action="/he/adminAtt" method="get">
		<h2>근무 현황</h2>
		<div class="container">
			<input type="date" id="calendar">
			<input type="text" name="name" id="name" placeholder="사원명" value="${param.name}">
			<input type="text" name="attStatus" id="attStatus" placeholder="출근상태" value="${param.attStatus}"><!-- 입력값 유지 -->
			<button type="submit" id="search">검색</button>
		</div>
	</form>
	<table>
	    <tr>
	        <th>날짜</th>
	        <th>사원명</th>
	        <th>부서명</th>
	        <th>출근</th>
	        <th>퇴근</th>
	        <th>야근</th>
	        <th>일일 총 근로시간</th>
	        <th>근태</th>
	    </tr>
	    <c:forEach var="deptAttList" items="${deptAtt}">
	        <tr>
	            <td>${deptAttList.workDate}</td>
	            <td>${deptAttList.name}</td>
	            <td>${deptAttList.deptName}</td>
	            <td>${deptAttList.clockIn}</td>
	            <td>
	                <c:choose>
	                    <c:when test="${deptAttList.attStatus == 140}">00:00</c:when>
	                    <c:when test="${deptAttList.clockOut == '00:00'}">&nbsp;</c:when>
	                    <c:otherwise>${deptAttList.clockOut}</c:otherwise>
	                </c:choose>
	            </td>
	            <td>
	                <c:choose>
	                    <c:when test="${deptAttList.attStatus == 140}">00:00</c:when>
	                    <c:when test="${deptAttList.clockOut == '00:00'}">&nbsp;</c:when>
	                    <c:otherwise>${deptAttList.overTime}</c:otherwise>
	                </c:choose>
	            </td>
	            <td>
	                <c:choose>
	                    <c:when test="${deptAttList.attStatus == 140}">0시간</c:when>
	                    <c:when test="${deptAttList.totWorkTime == null || deptAttList.totWorkTime.toHours() == 0}">0시간</c:when>
	                    <c:otherwise>${deptAttList.totWorkTime.toHours()}시간</c:otherwise>
	                </c:choose>
	            </td>
	            <td class="${deptAttList.attStatus == 130 || deptAttList.attStatus == 140 ? 'status_red' : ''}">
	                <c:choose>
	                    <c:when test="${deptAttList.attStatus == 100}">출근</c:when>
	                    <c:when test="${deptAttList.attStatus == 110}">지각</c:when>
	                    <c:when test="${deptAttList.attStatus == 120}">조퇴</c:when>
	                    <c:when test="${deptAttList.attStatus == 130}">지각&조퇴</c:when>
	                    <c:when test="${deptAttList.attStatus == 140}">결근</c:when>
	                </c:choose>
	            </td>
	        </tr>
	    </c:forEach>
	</table>
	<form action="deptLeaveList" method="get">
		<h2>연차 현황</h2>
		<div class="container">
			<input type="text" name="ename" placeholder="사원명">
			<input type="text" name="dname" placeholder="부서명">
			<button type="submit" id="search">검색</button>
		</div>
	</form>
	<table>
		<tr>
			<th>연차그룹</th>
			<th>사원명</th>
			<th>부서명</th>
			<th>사용예정일</th>
			<th>기간</th>
			<th>누적사용일</th>
			<th>잔여일수</th>
		</tr>
		<c:forEach var="deptLeaveList" items="${deptLeave}">
			<tr>
				<td><c:choose>
						<c:when test="${deptLeaveList.documentFormId == '100'}">연차</c:when>
						<c:when test="${deptLeaveList.documentFormId == '110'}">병가</c:when>
						<c:when test="${deptLeaveList.documentFormId == '120'}">경조사</c:when>
						<c:when test="${deptLeaveList.documentFormId == '160'}">휴직</c:when>
						<c:when test="${deptLeaveList.documentFormId == '170'}">퇴직</c:when>
					</c:choose></td>
				<td>${deptLeaveList.name}</td>
				<td><c:choose>
						<c:when test="${deptLeaveList.deptno == '101'}">인사팀</c:when>
						<c:when test="${deptLeaveList.deptno == '102'}">회계팀</c:when>
						<c:when test="${deptLeaveList.deptno == '103'}">법인팀</c:when>
						<c:when test="${deptLeaveList.deptno == '104'}">영업팀</c:when>
						<c:when test="${deptLeaveList.deptno == '105'}">법무팀</c:when>
						<c:when test="${deptLeaveList.deptno == '110'}">총괄</c:when>
					</c:choose></td>
				<td>${deptLeaveList.furloughServiceData}일</td>
				<td>${deptLeaveList.furloughStartDate} ~ ${deptLeaveList.furloughEndDate}</td>
				<td>${deptLeaveList.totalVacation - deptLeaveList.restVacation}일</td>
				<td>${deptLeaveList.restVacation}일</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>