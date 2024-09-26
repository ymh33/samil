<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../1.main/user_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	/* 메인 */
	.entire {
		display: flex;
		flex-direction: column;
		margin: 40px 120px 20px 150px;
	}
	
	/* 링크스타일 */
	a {
		color: black;	/* 글자 색상 설정 */
		text-decoration: none;	/* 밑줄제거 */
	}
	
	a:hover {
		font-weight: bold;
	}
	
	
	/* 1구역 */
	.writemyplan {
		display: flex;	/* 플렉스 박스를 사용하여 정렬 */
		flex-direction: row;	/* 가로 방향 정렬 */
		align-items: center;	/* 수직 중앙 정렬 */
	}
	
	.writemyplan img {
		width: 150px;
		height: auto;
	}
	
	.deleteList {
		display: flex;	/* 플렉스 박스를 사용하여 정렬 */
		justify-content: center; /* 가로 가운데 정렬 */
		align-items: center; /* 세로 가운데 정렬 */
		margin-top: 100px;	/* 위쪽 간격 추가 */
		font-size: 18px;
		font-weight: bold;
	}
	
	.writemyplan .deleteList img {
		margin-right: 8px;	/* 그림과 글씨 사이 간격 조정 */
		width: 30px;
	}
	
	.writemyplan .deleteList a:hover {
		color: rgb(3, 78, 162);
		text-decoration: underline;
	}
	
	/* 1구역의 검색 */
	.container1 {
		display: flex; /* 플렉스 박스를 사용하여 정렬 */
		justify-content: space-between; /* 요소들 사이에 공간 분배 */
		width: 100%; /* 전체 너비 */
		margin-bottom: 20px; /* 아래쪽 여백 추가 */
	}
	
	/* 검색 부분 스타일 */
	.container1 .search {
		width: 100%;
		height: 30px;
		margin-bottom: 20px;
		text-align: right;
	}
	
	
	/* 2구역 */
	.container2 {
		margin: 0px 0px 0px 10px;
		min-width: 800px;
		width: calc(100% - 270px);
		font-align: center;
		display: flex;
		flex-direction: column;
		padding-left: 20px;
	}
	
	/* 제목스타일 */
	.container2 .planTitle {
		width: 97%;
		min-width: 800px;
		height: 30px;
		border: 1px solid;
		border-radius: 17px;
		padding: 15px;
		background-color: rgb(3, 78, 162);
		color: white;
		display: flex;	/* 플렉스 박스를 사용하여 정렬 */
		align-items: center; /* 세로 가운데 정렬 */
		justify-content: space-between; /* 양쪽 끝으로 정렬 */
		font-weight: bold;
		font-size: 20px;
		margin-bottom: 20px;
		margin-top: 20px;
	}
	
	.planTitle ul {
		display: flex; /* 플렉스 박스 사용 */
		justify-content: flex-end; /* 오른쪽 정렬 */
		list-style: none; /* 기본 목록 스타일 제거 */
		padding: 0; /* 패딩 제거 */
		margin: 0; /* 마진 제거 */
	}
	
	/* 일정내용 */
	.eventdetail {
		width: 100%;
		border-collapse: collapse;
		text-align: center;
		
	}
	
	.eventdetail th, .eventdetail td {
		border: 1px solid #ddd;
		padding: 8px;
	}
	
	.eventdetail .calendar {
		width: 70%;
	}
	
	/* 카테고리별 일정 TBL의 스타일 */
	.eventList100,
	.eventList110,
	.eventList120,
	.eventList130 {
		border: none; /* 테두리 없애기 */
		width: 230px; /* 너비를 100%로 설정 (필요에 따라 다른 값으로 변경 가능) */
		table-layout: fixed; /* 테이블 레이아웃을 고정으로 설정하여 균일한 너비 보장 */
		margin-bottom: 20px;
		max-height: 100px; /* 고정 높이 설정 (필요에 따라 조정 가능) */
    	overflow-y: auto; /* 세로 스크롤 가능 */
	}

	.eventList100 th,
	.eventList110 th,
	.eventList120 th,
	.eventList130 th {
		border: none; /* 테두리 없애기 */
	    width: 100%; /* 모든 셀의 너비를 100%로 설정 (필요에 따라 다른 값으로 변경 가능) */
	    padding: 8px; /* 셀 패딩 */
	    text-align: left; /* 텍스트 정렬 */
	}

	.eventList100 td,
	.eventList110 td,
	.eventList120 td,
	.eventList130 td {
	   	border: none;
	    width: 100%; /* 모든 셀의 너비를 100%로 설정 (필요에 따라 다른 값으로 변경 가능) */
	    padding: 5px; /* 셀 패딩 */
	    text-align: left; /* 텍스트 정렬 */
	}
	
	
	/* 회사일정 tbl font색 */
	.eventList100 table {
		min-width: 200px;
		border: none;
	}
	
	.eventList100 th {
		color: #62C15B;
		border-bottom: 1px solid;
	}
	
	.one100 {
		color: #1DDB16;
	}
	
	.eventList100 td {
		color: #62C15B; /* 회사 일정 색 */
		font-size: 13px;
	}
	
	/* 공유일정 tbl font색 */
	.eventList110 th {
		color: #3DB7CC;
		border-bottom: 1px solid;
	}
	
	.eventList110 td {
		color: #3DB7CC; /* 공유 일정 색 */
		font-size: 13px;
	}
	
	.one110 {
		color: #00D8FF;
	}
	
	/* 개인일정 tbl font색 */
	.eventList120 th {
		color:#DB9700;
		border-bottom: 1px solid;
	}
	
	.eventList120 td {
		color: #DB9700; /* 개인 일정 색 */
		font-size: 13px;
	}
	
	.one120 {
		color: #FFBB00;
	}
	
	/* 연차일정 tbl font색 */
	.eventList130 th {
		color: #C9AE00;
		border-bottom: 1px solid;
	}
	
	.one130 {
		color: #FFE400;
	}

	.eventList130 td {
		color: #C9AE00; /* 연차 일정 색 */
		font-size: 13px;
	}
	
	
	
	/* 3구역 */
	.side_right {
		margin: 0px 0px 0px 10px;
		width: 250px;
		height: auto;
		font-align: center;
		float: left;
		border: 2px solid gray;
		border-color: rgb(3, 78, 162);
		border-collapse: collapse;
		border-radius: 20px;
		padding: 20px;
	}
	
	.side_right p {
		font-align: center;
		font-size: 20px;
		color: rgb(3, 78, 162);
		font-weight: bold;
		margin: 0 auto; /* div를 가운데 정렬 */
	}
	
	.side_right .calrequest,
	 .side_right .calresponse {
		font-size: 14px;
		text-align: center; /* 텍스트와 테이블을 가운데 정렬 */
		margin: 0 auto; /* div를 가운데 정렬 */
		
	}
	
	.side_right .calresponse table {
		margin: 0 auto;
	}
	
	.side_right .calrequest th {
		max-width: 50px;
		min-width: 50px;
	}
	
	.side_right .calrequest td {
		text-align: left;
		min-width: 160px;
		max-width: 160px;
	}
	
	.side_right .calresponse th {
		max-width: 130px;
		min-width: 130px;
	}
	
	.side_right .calresponse td {
		text-align: left;
		min-width: 80px;
		max-width: 800px;
	}
	
	/* 공유요청 승인 거부 스타일 */
	.side_right .reqbutton {
		text-align: right;
		display: flex;
    	justify-content: flex-end; /* 버튼을 오른쪽으로 정렬 */
	}
	
	.side_right .calrequest .circle {
		font-size: 20px;
		color: #12EAFF;
		min-width: 10px;
		max-width: 10px;
	}
	
	.reqbutton input[type="submit"].accept {
		background-color: #B2CCFF; /* 연파랑 배경색 */
		border: 1px solid #00008b; /* 진파랑 테두리색 */
		border-radius: 8px;
		color: #000; /* 글자 색 (선택 사항) */
		padding: 5px 10px; /* 버튼의 패딩 조정 */
		margin: 5px; /* 버튼 사이 간격 조정 */
		cursor: pointer; /* 버튼 클릭 시 커서 변경 */
		line-height: 0.9; /* 버튼 텍스트의 줄 높이 조정 */
		font-size: 12px; /* 버튼 텍스트 크기 조정 (옵션) */
		float: right;
		box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 기본 그림자 */
    	transition: transform 0.2s, box-shadow 0.2s; /* 애니메이션 효과 */
	}

	.reqbutton input[type="submit"].reject {
		background-color: #FFD8D8; /* 연빨강 배경색 */
		border: 1px solid #ff0000; /* 빨강 테두리색 */
		border-radius: 8px;
		color: #000; /* 글자 색 (선택 사항) */
		padding: 5px 10px; /* 버튼의 패딩 조정 */
		margin: 5px; /* 버튼 사이 간격 조정 */
		cursor: pointer; /* 버튼 클릭 시 커서 변경 */
		line-height: 0.9; /* 버튼 텍스트의 줄 높이 조정 */
		font-size: 12px; /* 버튼 텍스트 크기 조정 (옵션) */
		float: right;
/* 		box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 기본 그림자 */
    	transition: transform 0.2s ease, box-shadow 0.2s ease; /* 애니메이션 효과 */ */
    	transition: all 0.3s ease;	/* 애니메이션 효과 */
		box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 기본 그림자 */
	}
	
	.reqbutton input[type="submit"].accept:hover {
		background-color: #6799FF; /* 호버 시 색상 변화 */
		color: #ffffff; /* 글자 색 (선택 사항) */
		box-shadow: inset 0 4px 6px rgba(0, 0, 0, 0.2); /* 눌리는 느낌 */
	}

	.reqbutton input[type="submit"].reject:hover  {
		background-color: #F15F5F; /* 호버 시 색상 변화 */
		color: #ffffff; /* 글자 색 (선택 사항) */
		box-shadow: inset 0 4px 6px rgba(0, 0, 0, 0.2); /* 눌리는 느낌 */
	}


</style>
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js'></script>
<link href='https://unpkg.com/@fullcalendar/core@6.1.15/main.min.css' rel='stylesheet' />
<script src='https://cdn.jsdelivr.net/npm/@fullcalendar/google-calendar@6.1.15/index.global.min.js'></script>
<script>
	function confirmAction(formId, message) {
		if (confirm(message)) {
			document.getElementById(formId).submit();
			return true;
		} else {
			return false;
		}
	}
	
	document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
        	/* initialView: 'dayGridMonth', */
        	googleCalendarApiKey : "AIzaSyCpqE_3VYLRWTFE66yjA1R6O_eN57yG_W0",
            eventSources :[ 
                {						
                    googleCalendarId : 'ko.south_korea.official#holiday@group.v.calendar.google.com'
                    , color: 'white'   // an option!
                    , textColor: 'red' // an option!
                    , className: 'ko_event'
                } 
            ],
            events: /* [[${eventsForCalendar}]] */ [], // 서버에서 전달된 이벤트 데이터 추가
            
            eventClick: function(info) {
                // 링크 클릭 방지
                info.jsEvent.preventDefault();
                // 추가적으로 처리할 로직이 있다면 여기에 작성
            }
        });
        calendar.render();
      });
	
	
</script>
<title>캘린더</title>
</head>
<body>
	<div class="entire">
		<div class="container1">
			<div class="writemyplan">
				<a href="/hs/calWriteForm">
					<img src="/hsimg/1out.png" alt="일정쓰기">
				</a>
				<a href="/hs/cal">
					<img src="/hsimg/0out.png" alt="내일정">
	    		</a>
	    		
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
				
				<div class="search"  style="display: flex; align-items: center;">
					<div class="search1" style="display: flex; justify-content: flex-start;">
						<span><img alt="search" src="/hsimg/dot.png" style="width: 15px; margin-left: 20px; margin-right: 10px;">일정검색
							<input type="search" placeholder="검색어를 입력하세요">
							<input type="submit" value="검색">
						</span>
					</div>
					<div class="search2" style="display: flex; justify-content: flex-end;">
						<span><img alt="search" src="/hsimg/dot.png" style="width: 15px; margin-left: 20px; margin-right: 10px;">일정검색
							<input type="search" placeholder="검색어를 입력하세요">
							<input type="submit" value="검색">
						</span>
					</div>
				</div>
			</div>
		</div>
			
		<div class="container2">
			<div class="planTitle">
				${calendarData.year}년 ${calendarData.month}월 ${calendarData.day }일
			</div>
			<!-- 메인페이지 -->
			<div class="eventdetail">
				<div id='calendar'></div>

				
				<!-- 카테고리 별 일정 TBL -->
				<div class="eventListT">
					<div class="eventCom">
						<table class="eventList100">
							<tr>
								<th class="one100" style="font-size: 25px; width: 10px;">●</th>
								<th>회사일정</th>
							</tr>
							<c:forEach var="event" items="${listComEvent}">
								<tr>
									<td class="one100">●</td>
									<td><a href="/hs/calDetail?eventId=${event.eventId}">${event.formatStartTime }시 ${event.eventTitle }</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="eventOth">
						<c:forEach var="event" items="${listCategory }">
							<c:choose>
								<c:when test="${event.eventCategory == 130 }">
									<table class="eventList${event.eventCategory }">
										<tr>
											<th class="one${event.eventCategory }" style="font-size: 25px; width: 10px;">●</th>
											<th>${cateMap[event.eventCategory] }</th>
										</tr>
										<c:forEach var="event" items="${listEventMap[event.eventCategory]}">
											<tr>
												<td class="one${event.eventCategory }">●</td>
												<td>${event.formatStartTime }시 ${event.eventTitle }</td>
											</tr>
										</c:forEach>
									</table>
								</c:when>
								
								
								<c:when test="${event.eventCategory == 110 }">
									<table class="eventList${event.eventCategory }">
										<tr>
											<th class="one${event.eventCategory }" style="font-size: 25px; width: 10px;">●</th>
											<th>${cateMap[event.eventCategory] }</th>
										</tr>
										<c:forEach var="event" items="${listEventMap[event.eventCategory]}">
											<tr>
												<td class="one${event.eventCategory }">●</td>
												<td><a href="/hs/calDetail?eventId=${event.eventId}">${event.formatStartTime }시 ${event.eventTitle }</a></td>
											</tr>
										</c:forEach>
									</table>
								</c:when>
								
								
								<c:when test="${event.eventCategory == 120 }">
									<table class="eventList${event.eventCategory }">
										<tr>
											<th class="one${event.eventCategory }" style="font-size: 25px; width: 10px;">●</th>
											<th>${cateMap[event.eventCategory] }</th>
										</tr>
										<c:forEach var="event" items="${listEventMap[event.eventCategory]}">
											<tr>
												<td class="one${event.eventCategory }">●</td>
												<td><a href="/hs/calDetail?eventId=${event.eventId}">${event.formatStartTime }시 ${event.eventTitle }</a></td>
											</tr>
										</c:forEach>
									</table>
								</c:when>
							</c:choose>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		
		<div class="side_right">
			<div class="calrequest">
				<p>공유일정 요청</p><br><br>
				
				<table>
					<c:forEach var="attendee" items="${listRequestAtten }">
						<tr>
							<td class="circle">●</td>
							<th>요청자</th>
							<td>${attendee.name }</td>
						</tr>
						<tr>
							<td class="circle"></td>
							<th>제목</th>
							<td>${attendee.eventTitle }</td>
						</tr>
						<tr>
							<td class="circle"></td>
							<th>일시</th>
							<td>${attendee.formatStartdate } - 
								${attendee. formatEnddate}</td>
						</tr>
						<tr>
							<td class="circle"></td>
							<th></th>
							<td class="reqbutton">
								<form action="updateAttAcc" method="post" style="display:inline;" id="accept-form-${attendee.attendId}">
									<input type="hidden" name="eventId" value="${attendee.eventId}">
									<input type="hidden" name="attendId" value="${attendee.attendId}">
									<input type="hidden" name="attendRes" value="110">
									<input type="submit" class="accept" value="수락" onclick="return confirmAction('accept-form-${attendee.attendId}', '수락하시겠습니까?')"></button>
								</form>
								<form action="updateAttRej" method="post" style="display:inline;" id="reject-form-${attendee.attendId}">
									<input type="hidden" name="eventId" value="${attendee.eventId}">
									<input type="hidden" name="attendId" value="${attendee.attendId}">
									<input type="hidden" name="attendRes" value="120">
									<input type="submit" class="reject" value="거부" onclick="return confirmAction('reject-form-${attendee.attendId}', '거부하시겠습니까?')">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div><br><br><br><br>
			
			<div class="calresponse">
				<p>내 공유요청</p><br><br>
				
				<table>
					<c:forEach var="attendee" items="${listResponseAtten}">
				        <tr>
				            <th>${attendee.name}</th>
				            <td>
				                <c:choose>
				                    <c:when test="${attendee.attendRes == 110}">
				                        <span style="color: blue;">
				                            <c:out value="${atteReMap[attendee.attendRes]}" />
				                        </span>
				                    </c:when>
				                    <c:when test="${attendee.attendRes == 120}">
				                        <span style="color: red;">
				                            <c:out value="${atteReMap[attendee.attendRes]}" />
				                        </span>
				                    </c:when>
				                    <c:otherwise>
				                        <span style="color: gray;">
				                            <c:out value="${atteReMap[attendee.attendRes]}" />
				                        </span>
				                    </c:otherwise>
				                </c:choose>
				            </td>
				        </tr>
				    </c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>