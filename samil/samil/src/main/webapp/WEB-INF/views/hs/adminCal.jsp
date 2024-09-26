<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../1.main/admin_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	/* 메인 */
	.entire {
		display: flex;
		margin: 40px 120px 20px 150px;
	}
	
	.write {
		border: 1px solid;
		background-color: gray;
	}

	/* 2구역 */
	.container2 {
		margin: 0px 0px 0px 10px;
		width: 1000px;
		font-align: center;
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
	
	.tg  {
		border-collapse:collapse;
		border-spacing:0;
	}
	.tg td {
		border-color:black;
		border-style:solid;
		border-width:1px;
		font-family:Arial,sans-serif;
		font-size:14px;
  		overflow:hidden;
  		padding:10px 5px;
  		word-break:normal;
  	}
	.tg th	{
		border-color:black;
		border-style:solid;
		border-width:1px;
		font-family:Arial, sans-serif;
		font-size:14px;
  		font-weight:normal;
  		overflow:hidden;
  		padding:10px 5px;
  		word-break:normal;
  	}
   	.tg .tg-1wig {
   		font-weight:bold;
   		text-align:left;
   		vertical-align:top
   	}
	.tg .tg-0lax {
		text-align:left;
		vertical-align:top
	}
</style>
<title>admin_cal</title>
</head>
<body>
<div class="entire">
	<div class="write">
		<a href="/hs/adminCalWriteForm">
			<p>회사일정쓰기</p>
		</a>
	</div>
	<div class="container2">
		<table class="eventdetail">
			<tr>
	                <th>코드</th>
	                <th>제목</th>
	                <th>시작일</th>
	                <th>종료일</th>
	                <th>분류</th>
	                <th>사원번호</th>
	                <th>장소</th>
	                <th>파일첨부</th>
			</tr>
			<c:forEach var="event" items="${listAdminEvent}">
				<tr>
					<td>${event.eventId}</td>
					<td><a href="adminCalDetail?eventId=${event.eventId}">${event.eventTitle}</a></td>
					<td>${event.formatStartdate}</td>
					<td>${event.formatEnddate}</td>
					<td>${event.eventCategory}</td>
					<td>${event.eventWriter}</td>
					<td>${event.eventLoc}</td>
					<td>${event.eventFile}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>