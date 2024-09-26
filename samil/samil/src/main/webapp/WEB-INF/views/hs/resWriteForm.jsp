<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../1.main/user_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resWriteForm</title>
<style type="text/css">
	/* 메인 */
	.entire {
		display: flex;
		margin: 40px 120px 20px 150px;
	}
	
	/* 버튼 위치 조정 */
    .form-actions {
        margin-top: 20px;
        text-align: right; /* 버튼을 왼쪽으로 정렬 */
    }
    
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
    
	.ins {
		background-color: #8FFF86; /* 하늘색 */
		color: black;
	}

	.ins:hover {
		background-color: #59DA50; /* 호버 시 색상 변화 */
		box-shadow: inset 0 4px 6px rgba(0, 0, 0, 0.2); /* 눌리는 느낌 */
    }
</style>
</head>
<body>
<div class="entire">
	<form action="writeReserv" method="post">
		<div class="writeReservation">
			<h2>시설 예약</h2>
			<input type="hidden" name="resState" value="100">
			<input type="hidden" name="resWriter" value="${emp.empno }">
			<table>
				<tr>
					<th>시설명</th>
					<td>
						<select name="facilId">
							<c:forEach var="facility" items="${facilSort }">
								<option value="${facility.facilId }">${facility.facilType } ${facility.facilName }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>일시</th>
					<td>
						<input type="datetime-local" name="resStart" required="required">
						<input type="datetime-local" name="resEnd" required="required">
					</td>
				</tr>
				<tr>
					<th>예약내용</th>
					<td><input type="text" name="resContent" required="required"></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="tel" name="resTel"></td>
				</tr>
				<tr>
					<th>요청사안</th>
					<td><input type="text" name="resRequest"></td>
				</tr>
			</table>
			<div class="form-actions">
				<button type="submit" class="btn ins">신청</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>