<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style type="text/css">
	/* 기본 마진과 패딩 초기화 */
	body {
	    margin: 0;
	    padding: 0;
	    font-family: Arial, sans-serif;
	}
	
	/* 상단 메뉴 */
	#topMenu {
	    height: 30px;
	    width: 100%;
	}
	
	#topMenu ul {
	    list-style-type: none;
	    margin-left: 25px;
	    padding-top: 25px;
	}
	
	#topMenu ul li {
	    color: black;
	    float: left;
	    line-height: 20px;
	    vertical-align: middle;
	    text-align: center;
	    position: relative;
	}
	
	.menuLink {
	    text-decoration: none;
	    display: block;
	    width: 150px;
	    font-size: 18px;
	    font-family: "Trebuchet MS", Dotum;
	    font-weight: bold;
	    padding-top: 15px;
	    color: white;
	    padding-bottom: 5px;
	}

	.longLink {
	    width: 190px;
	}
	
	.submenu {
	    position: absolute;
	    display: none; /* 기본적으로 숨김 */
	    background-color: transparent;
	    z-index: 1000;
	    list-style: none;
	    padding: 0; /* 기본 패딩 제거 */
	    margin: 0;
	    flex-direction: column; /* 기본적으로 세로로 나열되도록 설정 */
	}
	
	.submenu li {
	    display: inline-block; /* 각 서브 메뉴 항목을 블록 요소로 설정하여 세로로 나열 */
	}
		
	.submenuLink {
		text-decoration: none;
	    display: block;
	    width: 150px;
	    font-size: 14px;
	    font-family: "Trebuchet MS", Dotum;
	    color: #2d2d2d;
	    font-weight: normal;
	    box-sizing: border-box; /* 패딩과 테두리를 전체 폭에 포함 */
	    line-height: 1.5;
	    margin-top: 30px;
	}
	
	.submenuLink:hover {
	    background-color: #f0f0f0;
	}
	
	/* 헤더 Styles */
	nav {
	    display: grid;
	    grid-template-rows: repeat(3, auto);
	    grid-template-columns: 1fr;
	    padding: 10px;
	    box-sizing: border-box;
	}
	
	.header-top {
	    display: grid;
	    grid-template-columns: auto 1fr; /* Left and right columns */
	    grid-template-rows: auto;
	    align-items: center;
	    padding: 0;
	}
	
	.header-top .logo {
		grid-template-columns: 0 1fr 1fr;
	    grid-column: 2; /* Left column */
	    display: flex;
	    justify-content: flex-start;
	    align-items: center;
	    margin-left: 10%;
	}
	
	.header-top .icon {
	    grid-column: 3; /* Right column */
	    display: flex;
	    gap: 10px;
	    align-items: center;
	    justify-content: flex-end;
	    margin-right: 5%;
	}
	
	ul {
	    grid-row: 2 / 3;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    margin: 0;
	    padding: 0;
	    list-style: none;
	    padding-bottom: 10px;
	    background-color: rgb(110, 110, 110);
	    padding-right: 50px;
	    padding-left: 300px;
	}
	
	#icon {
	    display: flex;               
	    justify-content: flex-end;  
	    flex: 1;
	    position: relative; /* z-index를 사용할 수 있도록 position 설정 */
	    z-index: 100; /* #tog_mypage보다 낮은 z-index 값 설정 */
	}
	
	#tog_mypage {
	    position: absolute;
	    top: 70px;
	    right: 35px;
	    width: 200px;
	    height: 250px;
	    border: 1px solid #D5D5D5;
	    background-color: #FFFFFF;
	    transition: z-index 0.3s; /* 부드러운 전환 효과 추가 */
	    z-index: 1000; /* #icon보다 높은 z-index 값 설정 */
	}
	
	#tog_mypage.active {
	    z-index: 1000; /* 클릭 시 활성화 상태의 z-index */
	}
	
	#icon .menuLink {
	    display: flex;               
	    gap: 10px;                   
	    padding-top: 15px;                 
	    list-style: none;            
	    margin: 0;
	    padding-left: 15px;
	}
	
	#icon .menuLink li {
	    display: flex;    
	    position: relative;           
	}
	
	#icon .menuLink img {
	    width: 40px;                 
	    height: 40px;                
	}
	
	.toggleDiv {
	    position: absolute; /* 절대 위치 지정 */
	    top: 100%; /* 버튼 바로 아래 위치 */
	    left: 0;   /* 버튼의 왼쪽 정렬 */
	    z-index: 500; /* 다른 요소 위에 표시되도록 설정 */
	}
	/* 그리드 레이아웃 */
	.wrapper {
	    display: grid;
	    grid-template-columns: repeat(3, 1fr); /* 3 columns */
	    grid-template-rows: repeat(5, 1fr); /* 5 rows */
	    gap: 10px;
	    width: 100%;
	    height: calc(100vh - 189px); /* Adjust based on header height */
	    box-sizing: border-box;
	    margin-top: 20px; /* Adjust based on header height */
	    padding: 10px 10%;
	}
	
	/* 그리드 아이템 */
	.profile,
	.cost,
	.schedule,
	.sal,
	.notice,
	.approval,
	.mail {
	    background: #F0F0F0;
	    border-radius: 10px;
	    border: 1px solid #D5D5D5;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	}
	
	.profile {
	    grid-row: 1 / span 2;
	    padding-left: 20px;
	}
	
	.schedule {
	    grid-row: 3 / 6;
	}
	
	.sal {
	    grid-column: 2;
	    grid-row: 3;
	}
	
	.notice {
	    grid-column: 2 / span 2;
	    grid-row: 4 / 6;
	}
	
	.approval {
	    grid-column: 2;
	    grid-row: 2;
	}
	
	.mail {
	    grid-column: 3;
	    grid-row: 1 / 4;
	}
	
	/* 링크 */
	.wrapper a {
	    text-decoration: none;
	    color: #000;
	    font-size: 24px;
	}
	
	/* 고정 위치 */
	#imageButton {
	    position: relative;
	    z-index: 1;
	}
</style>
</head>
<body>
	<header>
    	<nav>
            <div class="header-top">
            <div class="logo">
                <a href="../user_main"><img src="/upload/admin.png" width="80" height="70" alt="Logo"></a>
                <!-- 현재 유저 전환버튼이지만 홈버튼으로 사용예정 -->
            </div>
            <div class="icon">
                <input type="image" src="/upload/mypage.png" width="45" height="40" onclick='btnClick()' id="imageButton">
                <div id="tog_mypage" style="display: none;">
                <!-- 마이페이지 출력예정 -->
                <img src="/upload/myinfo.png" width="200" height="240">
            </div>
                <input type="image" src="/upload/logout.png" width="50" height="45" onclick="logout()">
                <!-- 로그아웃 제작예정 -->
            </div>
        	</div>
        	<div class="header-mid">
			    <div class="header-mid">
			    <ul class="topMenu">
			        <li class="topMenuLi" id="admin_per">
			            <a class="menuLink" href="#">인사</a>
			            <ul class="submenu">
			                <li><a href="/tr/admin_per_inform" class="submenuLink" id="admin_per_inform">사원정보등록</a></li>
			                <li><a href="/tr/admin_per_manage" class="submenuLink" id="admin_per_manage">사원정보관리</a></li>
			                <li><a href="/tr/admin_group_check" class="submenuLink" id="admin_group_check">조직관리</a></li>
			            </ul>
			        </li>
			        <li class="topMenuLi" id="admin_app">
			            <a class="menuLink" href="#">결재</a>
			            <ul class="submenu">
			                <li><a href="/se/admin_app_all" class="submenuLink" id="admin_app_all">사원전체보관함</a></li>
			            </ul>
			        </li>
			        <li class="topMenuLi" id="admin_sal">
			            <a class="menuLink" href="#">급여</a>
			            <ul class="submenu">
			                <li><a href="/mh/admin_sal_set" class="submenuLink" id="admin_sal_set">급여설정</a></li>
			                <li><a href="/mh/admin_sal_give" class="submenuLink" id="admin_sal_give">급여지급</a></li>
			                <li><a href="/mh/admin_sal_list" class="submenuLink" id="admin_sal_list">급여대장</a></li>
			            </ul>
			        </li>
			        <li class="topMenuLi" id="admin_cost">
			            <a class="menuLink" href="#">비용</a>
			            <ul class="submenu">
			                <li><a href="/hb/admin_cost_cost" class="submenuLink" id="admin_cost_cost">정산</a></li>
			                <li><a href="/hb/admin_cost_card" class="submenuLink" id="admin_cost_card">카드</a></li>
			                <li><a href="/hb/admin_cost_utility" class="submenuLink" id="admin_cost_utility">공과금</a></li>
			            </ul>
			        </li>
			        <li class="topMenuLi" id="admin_att">
			            <a class="menuLink" href="/he/admin_att">근태</a>
			        </li>
			        <li class="topMenuLi" id="admin_cal">
			            <a class="menuLink" href="#">일정</a>
			            <ul class="submenu">
			                <li><a href="/hs/admin_cal" class="submenuLink" id="admin_cal">캘린더</a></li>
			                <li><a href="/hs/admin_cal_reservation" class="submenuLink" id="admin_cal_reservation">시설예약</a></li>
			            </ul>
			        </li>
			        <li class="icon" id="icon">
			            <ul class="menuLink">
			                <li><a href="/jm/chat"><img src="../upload/chat.png" alt="Chat"></a></li>
			                <li><a href="/tr/admin_mail"><img src="../upload/mail.png" alt="Mail"></a></li>
			            </ul>
			        </li>
			    </ul>
				</div>
			</div>
		</nav>
</header>
<script type="text/javascript">
	//서브메뉴 토글
	document.querySelectorAll(".menuLink").forEach(function(menuLink) {
	    var submenu = menuLink.nextElementSibling;
	
	    menuLink.addEventListener("click", function(event) {
	        // 서브메뉴를 열 때 기본 링크 동작을 막지 않음
	        if (submenu && submenu.classList.contains("submenu")) {
	            // 모든 서브메뉴를 숨기기
	            document.querySelectorAll(".submenu").forEach(function(sub) {
	                if (sub !== submenu) {
	                    sub.style.display = "none";
	                }
	            });
	
	            // 클릭한 메뉴의 서브메뉴 토글
	            submenu.style.display = (submenu.style.display === "block") ? "none" : "block";
	        }
	    });
	});
	
	// 서브메뉴 항목 클릭 시 화면 전환
	document.querySelectorAll(".submenuLink").forEach(function(submenuLink) {
	    submenuLink.addEventListener("click", function(event) {
	        // 기본 링크 동작을 유지하여 페이지를 이동하도록 함
	        // 페이지 이동을 위해 링크의 href 속성 사용
	        window.location.href = submenuLink.getAttribute("href");
	    });
	});
	
	// 토글 함수
	function toggleFontWeight(target, ...others) {
	    target.style.fontWeight = "bold";
	    others.forEach(el => el.style.fontWeight = "normal");
	}
	// 마이페이지 / 로그아웃
	function btnClick() {
        const togdiv = document.getElementById('tog_mypage');

        if(togdiv.style.display === 'none') {
            togdiv.style.display = 'block';
        } else {
            togdiv.style.display = 'none';
        }
	}
	
	document.getElementById('tog_mypage').addEventListener('click', function() {
        this.classList.toggle('active');
    });
	
	function logout() {
    	alert('로그아웃되었습니다.');
    }
	
	// 링크 클릭 이벤트 핸들러
	function handleLinkClick(target, ...relatedElements) {
	    target.addEventListener('click', function(event) {
	        // event.preventDefault() 제거: 링크 기본 동작을 방지하지 않음
	        toggleFontWeight(target, ...relatedElements);
	    });
	}
	
	// 메뉴 항목 및 서브메뉴 항목
	const elements = {
	    human: document.getElementById('human'),
	    human1: document.getElementById('human1'),
	    human2: document.getElementById('human2'),
	    human3: document.getElementById('human3'),
	    app: document.getElementById('app'),
	    app1: document.getElementById('app1'),
	    app2: document.getElementById('app2'),
	    app3: document.getElementById('app3'),
	    sal: document.getElementById('sal'),
	    sal1: document.getElementById('sal1'),
	    sal2: document.getElementById('sal2'),
	    sal3: document.getElementById('sal3'),
	    cost: document.getElementById('cost'),
	    cost1: document.getElementById('cost1'),
	    cost2: document.getElementById('cost2'),
	    cost3: document.getElementById('cost3'),
	    att: document.getElementById('att'),
	    notic: document.getElementById('notic'),
	    notic1: document.getElementById('notic1'),
	    notic2: document.getElementById('notic2'),
	    notic3: document.getElementById('notic3'),
	    halll: document.getElementById('halll'),
	    halll1: document.getElementById('halll1'),
	    halll2: document.getElementById('halll2')
	};
	
	// 링크 클릭 이벤트 설정
	handleLinkClick(elements.human, elements.app, elements.sal, elements.cost, elements.att, elements.notic, elements.halll);
	handleLinkClick(elements.human1, elements.human2, elements.human3);
	handleLinkClick(elements.human2, elements.human1, elements.human3);
	handleLinkClick(elements.human3, elements.human1, elements.human2);
	handleLinkClick(elements.att, elements.human, elements.sal, elements.cost, elements.app, elements.notic, elements.halll);
	handleLinkClick(elements.app, elements.human, elements.sal, elements.cost, elements.att, elements.notic, elements.halll);
	handleLinkClick(elements.app1, elements.app2, elements.app3);
	handleLinkClick(elements.app2, elements.app1, elements.app3);
	handleLinkClick(elements.app3, elements.app1, elements.app2);
	handleLinkClick(elements.sal, elements.human, elements.app, elements.cost, elements.att, elements.notic, elements.halll);
	handleLinkClick(elements.sal1, elements.sal2, elements.sal3);
	handleLinkClick(elements.sal2, elements.sal1, elements.sal3);
	handleLinkClick(elements.sal3, elements.sal1, elements.sal2);
	handleLinkClick(elements.cost, elements.human, elements.app, elements.sal, elements.att, elements.notic, elements.halll);
	handleLinkClick(elements.cost1, elements.cost2, elements.cost3);
	handleLinkClick(elements.cost2, elements.cost1, elements.cost3);
	handleLinkClick(elements.cost3, elements.cost1, elements.cost2);
	handleLinkClick(elements.notic, elements.human, elements.app, elements.sal, elements.att, elements.cost, elements.halll);
	handleLinkClick(elements.notic1, elements.notic2, elements.notic3);
	handleLinkClick(elements.notic2, elements.notic1, elements.notic3);
	handleLinkClick(elements.notic3, elements.notic1, elements.notic2);
	handleLinkClick(elements.halll, elements.human, elements.app, elements.sal, elements.att, elements.notic, elements.cost);
	handleLinkClick(elements.halll1, elements.halll2);
	handleLinkClick(elements.halll2, elements.halll1);
	

</script>
</body>
</html>
