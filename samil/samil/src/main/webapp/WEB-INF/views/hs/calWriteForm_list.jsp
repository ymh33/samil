<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calWriteForm</title>
<style type="text/css">
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            height: 100%;
        }
        .container {
            display: flex;
            flex: 1;
        }
        .search-section, .selected-section {
            flex: 1;
            padding: 10px;
            box-sizing: border-box;
            height: calc(100% - 60px); /* 전체 높이에서 버튼 공간을 뺀 나머지 높이 */
        }
        .search-section {
            border-right: 1px solid #ddd;
        }
        .selected-section {
            border-left: 1px solid #ddd;
        }
        .search-box {
            margin-bottom: 10px;
        }
        .search-box input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        .list, .selected-list {
            list-style-type: none;
            padding: 0;
            margin: 0;
            height: calc(100% - 40px); /* 전체 높이에서 여백 공간을 뺀 나머지 높이 */
            overflow-y: auto;
        }
        .list-item, .selected-item {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            cursor: pointer;
        }
        .list-item:hover, .selected-item:hover {
            background-color: #f0f0f0;
        }
        .list-item.selected {
            background-color: #007bff;
            color: white;
        }
        .button-container {
            padding: 10px;
            text-align: right;
            border-top: 1px solid #ddd;
        }
        .button-container button {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .button-container button:hover {
            background-color: #0056b3;
        }
        .button-container .close-button {
            background-color: #6c757d;
        }
        .button-container .close-button:hover {
            background-color: #5a6268;
        }
</style>
<!-- 자바스크립트 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<!-- CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<!-- 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script type="text/javascript">
//사원 선택 처리
function toggleSelection(element) {
    element.classList.toggle('selected');
}

// 선택된 사원 목록에 추가
function addSelected() {
    var selectedItems = document.querySelectorAll('.list-item.selected');
    var selectedList = document.querySelector('.selected-list');
    selectedItems.forEach(item => {
        var newItem = item.cloneNode(true);
        newItem.classList.remove('selected');
        selectedList.appendChild(newItem);
        item.classList.remove('selected');
    });
}

// 확인 버튼 클릭 시 메인 페이지로 메시지 전송
function confirmSelection() {
    // rowIndex를 쿼리 문자열에서 가져오기
    var urlParams = new URLSearchParams(window.location.search);
    var rowIndex = urlParams.get('rowIndex');

    // 메인 페이지에 메시지 전송
    if (window.opener) {
        window.opener.postMessage({ action: 'updateScheduleType', rowIndex: rowIndex }, '*');
    }

    // 팝업창 닫기
    window.close();
}

// 닫기 버튼 클릭 시 팝업창 닫기
function closePopup() {
    window.close();
}
</script>
</head>
<body>
    <div class="container">
        <div class="search-section">
            <div class="search-box">
                <input type="text" placeholder="검색..." />
            </div>
            <ul class="list">
                <!-- 검색 결과 리스트 항목 -->
                <li class="list-item" onclick="toggleSelection(this)">사원 A</li>
                <li class="list-item" onclick="toggleSelection(this)">사원 B</li>
                <li class="list-item" onclick="toggleSelection(this)">사원 C</li>
                <!-- 더 많은 항목들 추가 가능 -->
            </ul>
        </div>
        <div class="selected-section">
            <h3>선택된 사원 목록</h3>
            <ul class="selected-list">
                <!-- 선택된 사원 목록 항목 -->
                <!-- 선택된 항목이 여기에 추가됩니다. -->
            </ul>
        </div>
    </div>
    
    
    <div class="button-container">
        <button class="close-button" onclick="closePopup()">닫기</button>
        <button onclick="confirmSelection()">등록</button>
    </div>
    
    
    
    
    
    <div class="accordion" id="accordionExample" >
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        Accordion Item #1
      </button>
    </h2>
    <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <strong>This is the first item's accordion body.</strong> It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
        Accordion Item #2
      </button>
    </h2>
    <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <strong>This is the second item's accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
        Accordion Item #3
      </button>
    </h2>
    <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <strong>This is the third item's accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
      </div>
    </div>
  </div>
</div>
</body>
</html>