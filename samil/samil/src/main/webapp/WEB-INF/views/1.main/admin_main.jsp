<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style type="text/css">
	.profile {
		display: flex; /* Flexbox 사용 */
		flex-direction: column; /* 세로 방향으로 정렬 */
		align-items: center; /* 왼쪽 정렬 */
		padding-right: 20px;
	}

	.profile a {
	    text-decoration: none;
	    color: #000;
	    font-size: 19px;
	    font-weight: bold;
	}

	.onOff {
		margin-top: 10px; /* onOff div 위쪽에 10px의 공간 추가 */
	}

	.onOff button {
	    width: 80px; /* 원하는 너비로 설정 */
	    padding: 1px 10px; /* 패딩을 추가하여 버튼의 크기를 늘림 */
	    font-size: 15px;
	    margin-right: 5px; /* 버튼 간의 간격 추가 */
	    background-color: transparent; /* 배경색 없애기 */
	    border: 1px solid #D3D3D3;
	    border-radius: 3px;
	    cursor: pointer; /* 커서 포인터로 변경 */
	}

	.currentTime {
		margin: 10px 0; /* 시간 표시 div에 여백 추가 */
		font-size: 15px; /* 시간 폰트 크기 */
	}
</style>
<script>
function updateTime() {
    const now = new Date();
    const timeString = now.toLocaleTimeString(); // HH:MM:SS 형식으로 변환
    document.getElementById('currentTime').textContent = timeString;
}

$(document).ready(function() {
    updateTime(); // 페이지 로드 시 현재 시간 표시
    setInterval(updateTime, 1000); // 1초마다 현재 시간 업데이트

    $('#on').click(function() {
        $.ajax({
            url: '/he/adminAtt/checkClockIn',
            type: 'POST',
            success: function(response) {
                alert('출근시간 기록: ' + response);
                window.localStorage.setItem('clockInTime', new Date().toISOString()); // 출근 시간 기록
            },
            error: function(xhr, status, error) {
                alert('이미 출근 기록이 있습니다.');
            }
        });
    });

    $('#off').click(function() {
        // 출근 시간이 있는지 확인
        if (!window.localStorage.getItem('clockInTime')) {
            alert('출근 시간을 먼저 기록해 주세요.');
            return; // 출근 기록이 없으면 퇴근 기록을 하지 않음
        }
        
        $.ajax({
            url: '/he/AdminAtt/checkClockOut',
            type: 'POST',
            success: function(response) {
                alert('퇴근시간 기록: ' + response);
                window.localStorage.removeItem('clockInTime'); // 퇴근 시 출근 시간 기록 삭제
            },
            error: function() {
                alert('이미 퇴근 기록이 있습니다.');
            }
        });
    });

    $('#attLink').click(function() {
        window.location.href = '/he/adminAtt';
    });
});
</script>
<title>SAMIL</title>
</head>
<body>
	<main class="wrapper">
		<div class="profile">
			<div class="info">
				<a href="/he/adminAtt">${emp.empno} ${emp.name} ${gradeName} ${jobName}</a>
			</div>
			<div class="currentTime" id="currentTime"></div>
			<div class="onOff">
				<button type="button" id="on">on</button>
				<button type="button" id="off">off</button>
			</div>
		</div>
	    <div class="cost"><a href="/hb/costCost">비용</a></div>
	    <div class="sal"><a href="/mh/salJoin">급여</a></div>
	    <div class="schedule"><a href="/hs/adminCal">일정</a></div>
	    <div class="notice"><a href="/jh/postNotice">공지사항</a></div>
	    <div class="approval"><a href="/se/appAll">결재</a></div>
	    <div class="mail"><a href="/tr/mail">메일</a></div>
	</main>
</body>
</html>
