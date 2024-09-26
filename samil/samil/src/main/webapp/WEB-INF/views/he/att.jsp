<%@page import="com.oracle.samil.Amodel.Attendance"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../1.main/user_header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style type="text/css">
h2 {
	font-size: 20px;
	font-weight: bold;
	margin-left: 200px;
}

h4 {
	margin-left: 200px;
}

/* form-group 클래스 설정 */
div.container {
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

.container select, .container input {
	width: 300px; /* 원하는 너비로 설정 */
	height: 40px;
}

.container button {
	background-color: #034EA2; /* 버튼 배경 색상 */
	color: white; /* 버튼 글자 색상 */
	cursor: pointer; /* 버튼 클릭 시 커서 모양 변경 */
	border: none; /* 버튼의 기본 테두리 제거 */
	min-width: 100px; /* 최소 너비 설정 */
	height: 40px;
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
	background: #034EA2;
	border-bottom: 2px solid #000000;
	height: 40px;
	font-size: 18px;
	color: white;
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

.vacation-info {
	margin: 0 200px; /* 왼쪽 및 오른쪽 여백 설정 */
	display: flex; /* 플렉스 박스 레이아웃 사용 */
	gap: 20px; /* 두 요소 간의 간격 설정 */
	font-size: 18px; /* 폰트 크기 설정 */
	font-weight: bold; /* 폰트 두께 설정 */
}

.vacation-item {
	display: inline-block; /* 인라인 블록으로 설정하여 간격을 유지 */
}

.hidden {
	display: none;
}

#calendarHeader {
	text-align: center;
	font-size: 18px;
	margin-bottom: 10px;
	font-weight: bold;
}

#calendar {
	position: absolute;
	width: 350px;
	height: 350px;
	border: 1px solid #ccc;
	background-color: white;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	z-index: 1000;
}

#datepicker {
	display: grid;
	grid-template-columns: repeat(7, 1fr);
	gap: 5px;
	justify-content: center; /* 중앙 정렬 */
}

.day {
	cursor: pointer;
	display: inline-block;
	width: 40px;
	text-align: center;
	margin: 2px;
	border: 1px solid #ddd;
	border-radius: 3px;
	transition: background 0.2s;
}

.day:hover {
	background: #f0f0f0;
}

.weekday {
	font-weight: bold;
	width: 30px; /* 요일 폭 조정 */
	text-align: center; /* 중앙 정렬 */
}

.holiday {
	background-color: red; /* 공휴일 색상 */
	color: white; /* 글자 색상 */
}

.saturday {
	background-color: #00BFFF; /* 토요일 색상 */
	color: white; /* 글자 색상 */
}

.holiday.saturday {
	background-color: red; /* 공휴일이면서 토요일 색상 */
}

.nav-buttons {
	display: flex;
	justify-content: center;
	margin-bottom: 5px; /* 요일과 버튼 간의 간격 */
}

button {
	margin: 0 5px; /* 버튼 간의 간격 */
	padding: 5px 10px; /* 버튼 크기 조정 */
	background: transparent; /* 배경색 제거 */
	border: none; /* 테두리 제거 */
	cursor: pointer;
	font-size: 0.9em; /* 글자 크기 조정 */
}
</style>
<title>근태</title>
</head>
<body>
	<form action="myAttList" method="get">
		<h2>출퇴근 조회</h2>
		<div class="container">
			<div id="displayArea"></div>
			<select id="selectPeriod">
				<option value="일">일</option>
				<option value="주">주</option>
				<option value="월">월</option>
			</select>
			<button type="button" id="calendarBtn">달력</button>
			<button type="submit" id="search">검색</button>
		</div>
	</form>
	<table>
		<tr>
			<th>근무일</th>
			<th>사원명</th>
			<th>출근시간</th>
			<th>퇴근시간</th>
			<th>야근</th>
			<th>일일 총 근로시간</th>
			<th>근태</th>
		</tr>
		<c:forEach var="myAttList" items="${myAtt}">
			<tr>
				<td>${myAttList.workDate}</td>
				<td>${myAttList.name}</td>
				<td>${myAttList.clockIn}</td>
				<td>${myAttList.clockOut}</td>
				<td>${myAttList.overTime}</td>
				<td>${myAttList.totWorkTime}</td>
				<td class="${myAttList.attStatus == 130 || myAttList.attStatus == 140 ? 'status_red' : ''}">
				    <c:choose>
				        <c:when test='${myAttList.attStatus == 100}'>출근</c:when>
				        <c:when test='${myAttList.attStatus == 110}'>지각</c:when>
				        <c:when test='${myAttList.attStatus == 120}'>조퇴</c:when>
				        <c:when test='${myAttList.attStatus == 130}'>지각&조퇴</c:when>
				        <c:when test='${myAttList.attStatus == 140}'>결근</c:when>
				    </c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="myLeaveList" method="get">
		<h2>연차 조회</h2>
		<div class="vacation-info">
			<span class="vacation-item">남은 연차 : ${emp.restVacation}</span>
			<span class="vacation-item">총 연차일 : ${emp.totalVacation}</span>
			<button type="button" id="LeaveRequest">연차 신청</button>
		</div>
	</form>
	<table>
		<tr>
			<th>신청일자</th>
			<th>연차항목</th>
			<th>사용예정일수</th>
			<th>기간</th>
			<th>신청내역</th>
			<th>결재상태</th>
		</tr>
		<c:forEach var="myLeaveList" items="${myLeave}">
			<tr>
				<td>${myLeaveList.furloughStartDate}</td>
				<td><c:choose>
						<c:when test="${myLeaveList.documentFormId == '100'}">연차</c:when>
						<c:when test="${myLeaveList.documentFormId == '110'}">병가</c:when>
						<c:when test="${myLeaveList.documentFormId == '120'}">경조사</c:when>
						<c:when test="${myLeaveList.documentFormId == '160'}">휴직</c:when>
						<c:when test="${myLeaveList.documentFormId == '170'}">퇴직</c:when>
					</c:choose></td>
				<td>${myLeaveList.furloughServiceData}일</td>
				<td>${myLeaveList.furloughStartDate} ~ ${myLeaveList.furloughEndDate}</td>
				<td>${myLeaveList.furloughServiceData}일</td>
				<td class="<c:choose>
                    <c:when test="${myLeaveList.furloughDetailsCode == '120'}">status_red</c:when></c:choose>">
					<c:choose>
						<c:when test="${myLeaveList.furloughDetailsCode == '100'}">결재요청</c:when>
						<c:when test="${myLeaveList.furloughDetailsCode == '110'}">전결</c:when>
						<c:when test="${myLeaveList.furloughDetailsCode == '120'}">결재</c:when>
						<c:when test="${myLeaveList.furloughDetailsCode == '130'}">반려</c:when>
						<c:when test="${myLeaveList.furloughDetailsCode == '140'}">이월</c:when>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>