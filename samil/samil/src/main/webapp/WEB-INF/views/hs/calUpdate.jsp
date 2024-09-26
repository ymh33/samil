<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../1.main/user_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calUpdate</title>
<style type="text/css">
	/* 메인 */
	main {
		margin: 0px 120px 0px 150px;
	}
/* 	
	/* 버튼 스타일 */
	.btn {
		padding: 4px 10px;
		border: none;
		border-radius: 5px;
		font-size: 16px;
		cursor: pointer;
		transition: all 0.3s ease;
		box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 기본 그림자 */
		font-size: 14px;
    }
    
	.upd {
		background-color: #4374D9; /* 하늘색 */
		color: white;
	}

	.upd:hover {
		background-color: #1F50B5; /* 호버 시 색상 변화 */
		box-shadow: inset 0 4px 6px rgba(0, 0, 0, 0.2); /* 눌리는 느낌 */
    }
     */
</style>
<!-- 자바스크립트 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<!-- CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<!-- 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>
<main>
<form action="updateEvent" method="post">
	<div class="entire">
		<h2>일정 수정하기</h2>
		<input type="hidden" name="eventId" value="${attendee.eventId }">
		<input type="hidden" name="eventCategory" value="${attendee.eventCategory}">
		<input type="hidden" name="eventWriter" value="${attendee.eventWriter }">
		<table>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="eventTitle" required="required" value="${attendee.eventTitle }">
				</td>
			</tr>
			<tr>
				<th>일시</th>
				<td>
					<input type="datetime-local" name="eventStartdate" required="required" value="${attendee.eventStartdate }"> - 
					<input type="datetime-local" name="eventEnddate" required="required" value="${attendee.eventEnddate }">  
				</td>
			</tr>
			<tr>
				<th>분류</th>
				<td>
					${cateMap[attendee.eventCategory]}
				</td>
			</tr>
			<tr>
				<th>장소</th>
				<td>
					<input type="text" name="eventLoc" value="${attendee.eventLoc }">
				</td>
			</tr>
			<tr>
				<th>메모</th>
				<td>
					<input type="text" name="eventMemo" value="${attendee.eventMemo }">
				</td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<td>
					<input type="text" name="eventFile" value="${attendee.eventFile }">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right;">
					<button type="submit" class="btn btn-outline-success btn-sm">수정</button>
				</td>
			</tr>
		</table>
	</div>
</form>
</main>
</body>
</html>