<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../1.main/user_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CalWriteForm</title>
<style type="text/css">
	/* 메인 */
	main {
		margin: 0px 120px 0px 150px;
	}
	
	.entirewrite {
	}
	
	table {
		width: 100%;
		border-collapse: collapse;
	}
	th {
		text-align: center;
		padding: 8px;
		border: 1px solid #ddd;
	}
	td {
		text-align: left;
		padding: 8px;
		border: 1px solid #ddd;
	}
	.btn {
		cursor: pointer;
		padding: 5px 10px;
		margin: 2px;
		border: 1px solid #ddd;
		background-color: #f0f0f0;
		border-radius: 5px;
	}
	.btn.selected {
		background-color: #FFBB00;
		color: black;
		border-color: #F29661;
	}
        
	.btn-address-book {
		cursor: pointer;
		padding: 5px 10px;
		margin: 2px;
		border: 1px solid #ddd;
		background-color: #e0e0e0;
		border-radius: 5px;
	}
	
	.btn.selected.address-book {
		background-color: #00D8FF; /* 원하는 클릭 색상 */
		color: white; /* 글자 색상 */
		border: none;
	}
        
	.scheduleTypeCell {
		position: relative;
		padding-left: 25px; /* 동그라미 기호 여백 */
	}
	.scheduleTypeCell::before {
		content: '';
		position: absolute;
		left: 0;
		top: 50%;
		transform: translateY(-50%);
		width: 15px;
		height: 15px;
		border-radius: 50%;
		background-color: #f0f0f0; /* 기본 색상 */
	}
	.scheduleTypeCell.personal::before {
		background-color: #ffad60; /* 연한 주황색 */
	}
	.scheduleTypeCell.shared::before {
		background-color: #87ceeb; /* 하늘색 */
	}
	/* 버튼 위치 조정 */
    .form-actions {
        margin-top: 20px;
        text-align: right; /* 버튼을 왼쪽으로 정렬 */
    }
    
	/* 파일 첨부 스타일 */
    .file-attachment-container {
        margin-top: 20px;
        text-align: right;
    }
    .file-attachment-container input[type="file"] {
        display: none;
    }
    .file-attachment-container label {
        display: inline-block;
        padding: 10px 20px;
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    .file-attachment-container label:hover {
        background-color: #218838;
    }
    .file-attachment-container button {
        margin-left: 10px;
        padding: 10px 20px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    .file-attachment-container button:hover {
        background-color: #0056b3;
    }
    
    /* 버튼 스타일 */
/* 	.btn {
		padding: 4px 10px;
		border: none;
		border-radius: 5px;
		font-size: 16px;
		cursor: pointer;
		transition: all 0.3s ease;
		box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
		font-size: 14px;
    } */
    
    .selectbox {
    	border: 1px solid;
    	margin-top: 10px;
    	padding: 10px;
    	border-radius: 10px;
    	height: 100%;
    }
    
    button {
            margin-left: 10px;
            color: blue; /* 글자 색상 */
            border: none; /* 테두리 없애기 */
            cursor: pointer; /* 마우스 커서 변경 */
            background-color: white;
            font-weight: bold;
        }
        
        
</style>
<!-- 자바스크립트 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<!-- CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<!-- 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script type="text/javascript">
	// 개인/주소록 버튼을 눌러서 아작스로 개인일정, 공유일정 변경하기
	function getEventCate(eventCate) {
		console.log(eventCate);
		$.ajax(
				{
					url:"<%=request.getContextPath()%>/hs/getEventCate",
					data:{eventCategory : eventCate},
					dataType:'text',
					success:function(eventCat) {
						console.log(eventCat);
						$('#eventCate').html(eventCat);
						if (eventCat.includes("개인일정")) {
							selectPersonal();	//개인일정 선택
							$('#eventCate').css('color','#FFBB00');
							console.log("색상 변경 : 개인일정");
							
						} else if (eventCat.includes("공유일정")) {
							selectAddressBook();	//주소록 선택
							$('#eventCate').css('color','#00D8FF');
							console.log("색상 변경 : 공유일정");
						}
					}
			});		
	}
	
	//수정권한 체크박스가 체크되면, 자동으로 value 바뀌게 하기
	$(document).ready(function() {
		// 초기 체크박스 상태 설정
	    const eventCategoryValue = $('#eventCategory').val();
	    getEventCate(eventCategoryValue); // 페이지 로드 시 카테고리에 따라 초기 상태 설정
		
	    $('#flexCheckChecked').change(function() {
	    	const hiddenInput = $('#attendRsvpHidden');
	        hiddenInput.val($(this).is(':checked') ? '100' : '110');
	    });
	});
	
	
 	function selectButton(button) {
	    const classificationDisplay = document.getElementById('classificationDisplay');
	    const eventCategoryInput = document.getElementById('eventCategory');

	    if (button.dataset.type === 'personal') {
	        classificationDisplay.textContent = '개인일정'; // 화면에 표시할 텍스트
	        eventCategoryInput.value = '120'; // 서버에 전달할 값
	    } else if (button.dataset.type === 'addressBook') {
	        classificationDisplay.textContent = '공유일정'; // 화면에 표시할 텍스트
	        eventCategoryInput.value = '110'; // 서버에 전달할 값
	    }
	}
	
	
	//주소록 버튼 클릭 시 선택 상태 변경 및 개인 일정으로 전환 가능하게 수정
	function selectAddressBookButton() {
		selectButton(document.querySelector('.btn[data-type="personal"]')); // 개인 일정으로 선택
		const addressBookButton = document.querySelector('.btn[data-bs-toggle="modal"]');
		addressBookButton.classList.add('selected', 'address-book'); // 클릭된 상태로 변경
	}
	
	// 선택된 직원 목록
	let selectedEmployees = [];
	
	// 직원 추가 함수
	function addEmployee(emp) {
		if (!selectedEmployees.includes(emp)) {
			selectedEmployees.push(emp);
			renderSelectedEmployees();
	
			// 주소록 버튼을 클릭된 것처럼 상태 변경
			selectAddressBookButton();
		} else {
			alert(emp.name +"은(는)이미 선택되었습니다.");	//중복 선택 시 경고
		}
	}
	
	// 직원 선택 시 스타일 추가
	function toggleEmployeeSelection(button) {
		button.classList.toggle('selected');
	} 
	
	// 직원 삭제 함수
	function removeEmployee(emp) {
		selectedEmployees = selectedEmployees.filter(e => e.empno !== emp.empno);
		renderSelectedEmployees();
	}
	
	// 선택된 직원 렌더링
	function renderSelectedEmployees() {
		const selectedContainer = document.querySelector('.selected-employees'); // 기존 직원 표시 영역
		const modalSelectedContainer = document.querySelector('.selectbox'); // 모달 내 선택된 직원 영역
	
		// 두 곳 모두 업데이트
		selectedContainer.innerHTML = '';
		modalSelectedContainer.innerHTML = '';
	
		if (selectedEmployees.length === 0) {
			return; // 배열이 비어있으면 함수 종료
		}
	
		// 기본 창에서는 한 줄로 표시
		selectedEmployees.forEach(emp => {
			const empDiv = document.createElement('div');
			empDiv.textContent = emp.name + ' (' + emp.empno + ') ';
			empDiv.style.display = 'inline-block'; // 한 줄에 표시
			empDiv.style.marginRight = '10px'; // 간격 조정
	
			const removeBtn = document.createElement('button');
			removeBtn.textContent = 'x';
			removeBtn.onclick = () => {
				removeEmployee(emp);
				renderSelectedEmployees(); // 직원 제거 후 재렌더링
			};
	
			empDiv.appendChild(removeBtn);
			selectedContainer.appendChild(empDiv); // 기본 직원 표시 영역에 추가
		});
	
		// 모달 창에서는 한 줄씩 표시
		selectedEmployees.forEach(emp => {
			const li = document.createElement('li'); // li로 변경
			li.textContent = emp.name + ' (' + emp.empno + ') ';
	
			const removeBtn = document.createElement('button');
			removeBtn.textContent = 'x';
			removeBtn.onclick = () => {
				removeEmployee(emp);
				renderSelectedEmployees(); // 직원 제거 후 재렌더링
			};
	
			li.appendChild(removeBtn);
			modalSelectedContainer.appendChild(li); // 모달 내 선택된 직원 표시 영역에 추가
		});
	}
	
	// 모달에서 선택된 직원 추가 및 닫기
	function addEmployeesAndCloseModal() {
		const selectedButtons = document.querySelectorAll('.accordion-body.selected');
	
		selectedButtons.forEach(button => {
			const empData = JSON.parse(button.getAttribute('data-emp'));
			addEmployee(empData);
		});
	
		// 선택된 직원 목록 렌더링
		renderSelectedEmployees();
	
		// 모달 닫기
		const modal = bootstrap.Modal.getInstance(document.getElementById('addressModal'));
		modal.hide();
	}
	
	function selectButton(button) {
		var type = button.getAttribute('data-type');
	
		// AJAX 요청으로 selectedType 업데이트
		fetch('/updateSelectedType', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({ type: type }),
		})
		.then(response => response.json())
		.then(data => {
			// 성공적으로 업데이트된 경우 페이지의 체크박스 상태를 업데이트
			updateCheckboxState(data.selectedType);
		})
		.catch(error => console.error('Error:', error));
	}
	
	function updateCheckboxState(selectedType) {
		const personalCheckbox = document.getElementById('flexCheckDisabled');
		const addressBookCheckbox = document.getElementById('flexCheckChecked');
	
		if (selectedType === 'personal') {
			personalCheckbox.disabled = true;
			addressBookCheckbox.checked = false;
		} else {
			personalCheckbox.disabled = false;
			addressBookCheckbox.checked = true;
		}
	}
	
	function appLine() {
        window.open('orgChart', 'popupWindow', 'width=600, height=400');
    }
	
	// 개인/주소록 선택 시 체크박스 표시 조정
	function selectPersonal() {
	    hideCheckbox(); // 개인 일정 선택 시 체크박스 숨김
	}
	
	function selectAddressBook() {
	    showCheckbox(); // 주소록 선택 시 체크박스 보이기
	}
	
	function showCheckbox() {
	    const checkboxContainer = document.getElementById('checkboxContainer');
	    checkboxContainer.style.display = 'block'; // 체크박스 보이기
	    updateAttendRsvpHidden(); // 체크박스 기본값 설정
	}
	
	function hideCheckbox() {
	    const checkboxContainer = document.getElementById('checkboxContainer');
	    checkboxContainer.style.display = 'none'; // 체크박스 숨기기

	    // 수정 권한 값을 110으로 설정
	    const hiddenInput = document.getElementById('attendRsvpHidden');
	    hiddenInput.value = '110';
	}
</script>
</head>
<body>
<main>
	<form action="writeEvent" method="post">
		<div class="entirewrite">
		<h2>일정쓰기</h2>
		<input type="hidden" name="eventDelete" value=100>
		<input type="hidden" id="eventCategory" name="eventCategory" value="120">
		<input type="hidden" name="eventWriter" value="${emp.empno }">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="eventTitle" required="required"></td>
				</tr>
				<tr>
					<th>일시</th>
					<td><input type="datetime-local" name="eventStartdate" required="required">
						<input type="datetime-local" name="eventEnddate" required="required"></td>
				</tr>
				<tr>
					<th>참석자</th>
					<td>
						<button type="button" class="btn btn-outline-warning btn-sm" data-type="personal" onclick="getEventCate(120)">개인</button>
						<!-- 주소록 모달버튼 -->
						<button type="button" class="btn btn-outline-info btn-sm" data-bs-toggle="modal" data-bs-target="#addressModal" onclick="getEventCate(110)">
							주소록
						</button>
						<div id="checkboxContainer" style="display: none;">
							<input type="checkbox" name="attendRsvp" value="100" id="flexCheckChecked" style="margin-left: 20px;">
							<label class="form-check-label" for="flexCheckChecked">수정 권한</label>
							<input type="hidden" name="attendRsvp" id="attendRsvpHidden" value="110">
						</div>
						<div class="selected-employees" style="margin-top: 10px;"></div> <!-- 선택된 직원 표시 영역 -->
                    </td>
				</tr>
				<tr>
					<th>분류</th>
					<td>
						<span id="eventCate"></span>
					</td>
				</tr>
				<tr>
					<th>장소</th>
					<td><input type="text" name="eventLoc"></td>
				</tr>
				<tr>
					<th>메모</th>
					<td><input type="text" name="eventMemo"></td>
				</tr>
				<tr>
					<th>파일첨부</th>
					<td><input type="file" id="fileInput" name="eventFile"/>
				</tr>
			</table>
			<div class="form-actions">
				<button type="submit" class="btn btn-outline-primary btn-sm">등록</button>
			</div>
		</div>
	</form>

	
	<!-- 주소록 모달 -->
	<div class="modal fade" id="addressModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">공유일정 참석자 추가</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							
							<!-- 직원 검색 및 조직도 -->
							<div class="col-sm-7">
								<!-- 아코디언 분류 -->
								<div class="accordion accordion-flush" id="accordionFlushExample">
									<input type="search" placeholder="사원이름 검색" style="width: 250px;">
									<button class="btn btn-outline-warning btn-sm" type="submit">검색</button>
									<c:forEach var="dept" items="${deptList}">
										<div class="accordion-item">
											<h2 class="accordion-header">
												<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse-${dept.deptno}" aria-expanded="false" aria-controls="flush-collapse-${dept.deptno}">
													${dept.deptName}
												</button>
											</h2>
											<div id="flush-collapse-${dept.deptno}" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
												<c:forEach var="emp" items="${deptEmpMap[dept.deptno]}">
													<div class="accordion-body" onclick="addEmployee({ name: '${emp.name}', empno: '${emp.empno}' })">
														<button type="button" class="list-group-item list-group-item-action">${emp.empno} ${emp.name} ${empgrade[emp.grade]}</button>
													</div>
												</c:forEach>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
							
							<!-- 선택된 사원 목록 -->
							<div class="col-md-4 ms-auto" style="text-align: center;">
								<span style="font-weight: bold; color: blue;">선택된 사원</span>
								<div class="selectbox" style="text-align: left;">
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-outline-secondary btn-sm" data-bs-dismiss="modal">닫기</button>
					<button type="submit" class="btn btn-outline-warning btn-sm" onclick="addEmployeesAndCloseModal()">추가</button>
				</div>
			</div>
		</div>
	</div>
</main>
</body>
</html>