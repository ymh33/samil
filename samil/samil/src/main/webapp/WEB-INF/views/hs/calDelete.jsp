<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../1.main/user_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calDelete</title>
<style type="text/css">
	/* 메인 */
	.entire {
		display: flex;
		margin: 40px 120px 20px 150px;
	}
	
	a {
		color: black;	/* 글자 색상 설정 */
		text-decoration: none;	/* 밑줄제거 */
	}
	
	a:hover {
		font-weight: bold;
	}
	
	/* 1구역 */
	.side_left {
		width: 320px;
		font-align: center;
	}
	
	.writemyplan img {
		width: 150px;
		height: auto;
	}
	
	.side_left .deleteList {
		display: flex;	/* 플렉스 박스를 사용하여 정렬 */
		justify-content: center; /* 가로 가운데 정렬 */
		align-items: center; /* 세로 가운데 정렬 */
		margin-top: 100px;	/* 위쪽 간격 추가 */
		font-size: 18px;
		font-weight: bold;
	}
	
	.side_left .deleteList img {
		margin-right: 8px;	/* 그림과 글씨 사이 간격 조정 */
	}
	
	.side_left .deleteList a:hover {
		color: rgb(3, 78, 162);
		text-decoration: underline;
	}
	
	/* 미니캘린더구역 */
	.calendar {
		width: 300px;
		border-collapse: collapse;
		margin: 20px 0;
		text-align: center;
	}
	.calendar th, .calendar td {
		border: 1px solid #ddd;
		padding: 8px;
		text-align: center;
	}
	.calendar th {
		background-color: #f2f2f2;
	}
	.calendar td {
		cursor: pointer;
	}
	.sunday, holiday {
		color: pink;
	}
	.saturday {
		color: lightblue;
	}
	.day-cell {
		cursor: pointer;
	}
	
	
	
	/* 삭제된 일정 목록 */
	.container {
		display: flex;
		flex-direction: column;
		margin-left: 30px;
		padding-left: 20px;
	}
	
	.container .search {
		width: 100%;
		height: 30px;
		margin-bottom: 20px;
		text-align: right;
	}
	
	.container .search img {
		width: 15px;
		margin-left: 20px;
		margin-right: 10px;
	}
	
	.container .search text {
		margin-right: 10px;
	}
	
	.container .deltitle {
		width: 100%;
		min-width: 1000px;
		height: 30px;
		border: 1px solid;
		border-radius: 17px;
		padding: 15px;
		background-color: rgb(3, 78, 162);
		color: white;
		display: flex;	/* 플렉스 박스를 사용하여 정렬 */
		align-items: center; /* 세로 가운데 정렬 */
		font-weight: bold;
		font-size: 20px;
	}
	
	.container .deltitle img {
		margin-right: 10px;
	}
	
	.container .delList {
		text-align: center;
		min-width: 1000px;
	}
	
	.container .delList table {
		width: 100%;
		min-width: 1000px;
		border: none;
		padding-left: 20px;
		padding-top: 10px;
	}
	
	.container .delList th {
		background-color: #D5D5D5;
		height: 30px;
	}
	
	.delbutton input[type="submit"].restore {
		background-color: #5587ed; /* 연파랑 배경색 */
		border: 1px solid #5587ed; /* 진파랑 테두리색 */
		border-radius: 8px;
		color: #ffffff; /* 글자 색 (선택 사항) */
		padding: 5px 10px; /* 버튼의 패딩 조정 */
		margin: 5px; /* 버튼 사이 간격 조정 */
		cursor: pointer; /* 버튼 클릭 시 커서 변경 */
		line-height: 0.9; /* 버튼 텍스트의 줄 높이 조정 */
		font-size: 12px; /* 버튼 텍스트 크기 조정 (옵션) */
		float: right;
	}

	.delbutton input[type="submit"].delete {
		background-color: #ff0000; /* 빨강 배경색 */
		border: 1px solid #ff0000; /* 빨강 테두리색 */
		border-radius: 8px;
		color: #ffffff; /* 글자 색 (선택 사항) */
		padding: 5px 10px; /* 버튼의 패딩 조정 */
		margin: 5px; /* 버튼 사이 간격 조정 */
		cursor: pointer; /* 버튼 클릭 시 커서 변경 */
		line-height: 0.9; /* 버튼 텍스트의 줄 높이 조정 */
		font-size: 12px; /* 버튼 텍스트 크기 조정 (옵션) */
		float: right;
	}
	
</style>
<script type="text/javascript">
const API_KEY='L14grotwGfo2U3slJQUf1JMlKnW2SBNNZR9ToRHsJSh4s5hu%2BBvbhuDlQ8%2BaoaX%2BZIFrTX2gWX6THbzNGEC6zQ%3D%3D'

	 async function getData(){
		const url='http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo?solYear=2024&solMonth=09&ServiceKey=${API_KEY}';
		const response = await fetch(url);
		const data = await response.json();
		console.log("data",data);
	}
	
	getData();


	const year = new Date().getFullYear();
	const month = new Date().getMonth(); // 현재 월

/* 	async function loadCalendar() {
		const response = await fetch('/hs/holidays?countryCode=KR&year=' + year);
		const data = await response.json();
		const holidays = data.holidays.map(h => h.date); // API에서 공휴일 날짜 추출
		generateCalendar(year, month, holidays);
	} */

	function generateCalendar(year, month, holidays) {

	}

	loadCalendar();
	
	function confirmAction(formId, message) {
		if (confirm(message)) {
			document.getElementById(formId).submit();
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
<main>
	<div class="entire">
		<div class="side_left">
			<div class="writemyplan">
				<a href="/hs/calWriteForm">
					<img src="/hsimg/1out.png" alt="일정쓰기">
				</a>
				<a href="/hs/cal">
					<img src="/hsimg/0out.png" alt="내일정">
	    		</a>
	    	</div>
			<h2>${calendarData.year}년 ${calendarData.month + 1}월</h2>
		    <table class="calendar">
				<thead>
					<tr>
						<th>Sun</th>
						<th>Mon</th>
						<th>Tue</th>
						<th>Wed</th>
						<th>Thu</th>
						<th>Fri</th>
						<th>Sat</th>
					</tr>
				</thead>
		        <tbody id="calendar-body">
					<c:forEach var="i" begin="1" end="${calendarData.startDay - 1}">
						<td></td>
					</c:forEach>
					<c:forEach var="day" begin="1" end="${calendarData.daysInMonth}">
						<c:choose>
							<c:when test="${(calendarData.startDay + day - 1) % 7 == 1}">
								<td class="sunday">${day}</td>
							</c:when>
							<c:when test="${(calendarData.startDay + day - 1) % 7 == 0}">
								<td class="saturday">${day}</td>
							</c:when>
							<c:otherwise>
								<td>${day}</td>
							</c:otherwise>
						</c:choose>
						<c:if test="${(calendarData.startDay + day - 1) % 7 == 0}">
							</tr><tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
			
			<table>
				<tr>
					<td class="deleteList">
						<div style="display: flex; align-items: center">
							<a href="/hs/calDelete">
								<img alt="trash" src="/hsimg/trashfile.png" width="30px"> 삭제된 일정 목록
							</a>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="container">
			<div class="search">
				<p><img alt="search" src="/hsimg/dot.png">검색
					<input type="search" placeholder="검색어를 입력하세요">
					<input type="submit" value="검색">
				</p>
				
			</div>
			<div class="deltitle">
				<img alt="trash" src="/hsimg/trashfile1.png" width="30px"> 삭제된 일정 목록
			</div>
			<div class="delList">
				<table>
					<tr>
						<th>제목</th>
						<th>일시</th>
						<th></th>
					</tr>
					<c:forEach var="event" items="${listDelete }">
						<tr>
							<td>${event.eventTitle }</td>
							<td>${event.formatStartdate } - ${event.formatEnddate }</td>
							<td class="delbutton">
								<form action="eventRestore" method="post" style="display:inline;" id="restore-form-${event.eventId}">
									<input type="hidden" name="eventId" value="${event.eventId}">
									<input type="hidden" name="eventDelete" value="100">
									<input type="submit" class="restore" value="복원" onclick="return confirmAction('restore-form-${event.eventId}', '일정을 복원하시겠습니까?')">
								</form>
								<form action="eventForDel" method="post" style="display:inline;" id="delete-form-${event.eventId}">
									<input type="hidden" name="eventId" value="${event.eventId}">
									<input type="submit" class="delete" value="삭제" onclick="return confirmAction('delete-form-${event.eventId}', '완전히 삭제하시겠습니까?')">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</main>
</body>
</html>