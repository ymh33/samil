<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../1.main/user_header.jsp" %>
<html>
<head>
    <title>카드 분실 신고</title>
  <style type="text/css">
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h2 {
            color: #3333CC; /* 진한 파란색 제목 */
            margin-bottom: 20px;
            text-align: center;
        }
        form {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 500px; /* 최대 폭 설정 */
            margin: 0 auto; /* 중앙 정렬 */
        }
        label {
            display: block;
            margin: 10px 0 5px;
            color: #333; /* 기본 텍스트 색상 */
        }
        select, input[type="text"], input[type="date"], button {
            width: 100%; /* 폭을 100%로 설정 */
            padding: 10px;
            border: 1px solid #ccc; /* 테두리 추가 */
            border-radius: 5px; /* 둥글게 */
            margin-bottom: 15px; /* 아래쪽 여백 추가 */
            font-size: 14px; /* 글자 크기 */
        }
        select:focus, input[type="text"]:focus, input[type="date"]:focus {
            border-color: #3333CC; /* 진한 파란색 포커스 */
            outline: none; /* 기본 아웃라인 제거 */
        }
        button {
            background-color: #3333CC; /* 버튼 배경색 */
            color: #ffffff; /* 버튼 글자색 */
            border: none; /* 테두리 제거 */
            cursor: pointer;
            transition: background-color 0.3s; /* 부드러운 색상 변경 */
        }
        button:hover {
            background-color: #005999; /* 버튼 호버 시 색상 변경 */
        }
        #cardDetails, #lostDate {
            display: flex; /* Flexbox를 사용하여 가로 정렬 */
            justify-content: space-between; /* 양 끝 정렬 */
            padding: 10px;
            padding-right:20px;
        }
        #cardDetails div {
            width: calc(50% - 10px); /* 두 개의 입력 필드를 반으로 나누기 */
        }
        
    </style>
    <script>
    function fetchCardDetails() {
        const cardNum = document.getElementById('cardNum').value;
        fetch(`hb/getCardDetails?cardNum=${cardNum}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json(); // JSON으로 변환
            })
            .then(data => {
                if (data) {
                    document.getElementById('Name').value = data.name; // data.name
                    document.getElementById('Deptno').value = data.deptno; // data.deptno
                } else {
                    console.log("No data found for the selected card number.");
                }
            })
            .catch(error => {
                console.error('Error fetching card details:', error);
            });
    }
    </script>
</head>
<body>
    <h2>카드 분실 신고</h2>
    <form action="/hb/cost_card_lost" method="post">
        <label for="cardNum">카드번호:</label>
        <select id="cardNum" name="cardNum" onchange="fetchCardDetails()">
            <c:forEach var="card" items="${cardSearchList}">
                <option value="${card.cardNum}">${card.cardNum}</option>
            </c:forEach>
        </select>
        
        <div id="cardDetails">
           	<input type="text" id="Name" name="name"  value="사원" readonly /> 
            <input type="text" id="Deptno" name="deptno" value ="부서"  readonly />
        </div>
		
			<label for="lostDate">분실 날짜:</label>
			<input type="date" id="lostDate" name="lostDate" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; margin-bottom: 15px; font-size: 14px;" />

        <button type="submit">신고하기</button>
    </form>
</body>
</html>
