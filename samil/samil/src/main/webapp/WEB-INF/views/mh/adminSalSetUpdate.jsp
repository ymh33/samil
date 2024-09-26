<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../1.main/admin_header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>관리자 급여설정 페이지입니다</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
.text {
  width: 300px;
  height: 32px;
  font-size: 15px;
  border: 0;
  border-radius: 15px;
  outline: none;
  margin-left: 10px;
  margin-top : 10px;
  margin-right: 80%;
  background-color: rgb(233, 233, 233);
}

table{
	margin-left: 50%
}

#container {
margin-left: 80%
}
        #btn1{
            border-radius: 5px;
            border: 1px solid rgb(233, 233, 233);
            background-color: rgba(0,0,0,0);
            color: black;
            padding: 5px;
            float: right;
        }
        
                #btn2{
            border-radius: 5px;
            border: 1px solid rgb(233, 233, 233);
            background-color: rgba(0,0,0,0);
            color: black;; 
            padding: 5px;
            float: right;
        }
        #btn1:hover{
            color:black;
            background-color: rgb(233, 233, 233);
        }
                #btn2:hover{
            color:black;
            background-color: rgb(233, 233, 233);
        }
        
.sertchList {
float: left; width: 33%; padding:10px;   
 font-size: 15px;

}

#key {
float: left; width: 33%; padding:10px;  
 border: 0;
  border-radius: 15px;
  outline: none;
  background-color: rgb(233, 233, 233);
   font-size: 15px;
}

</style>
</head>
<body>
	<h2>관리자 급여설정 페이지입니다</h2>
	<div class="row g-3">
		<div class="col-sm-3">

		<form action="listSearch">
			<select class ="sertchList" name="search">
				<option class ="sertchList" value="seartchEmpno">사원번호</option>
				<option class ="sertchList"  value="seartchName">사원명</option>
				<option class ="sertchList" value = "seartchDet">부서</option>
				<option class ="sertchList" value = "seartGrade">직급</option>
			</select> 
			<input type="text" name="keyword" id="key">
			<button type="submit" id="btn2">검색</button>
		</form>
			<table class="table table-hover">
			<tr>
			
			</tr>
				<tr>
					<thead><tr><th>번호</th><th>사원번호</th><th>사원명</th><th>부서</th><th>직급</th></tr></thead><tbody>
					
				<c:set var="num" value="1"></c:set>
<c:forEach var="emp" items="${listEmp }">
    <tr onclick="salDList(${emp.empno})" id="salDList" style="cursor: pointer;">
        <td>${num }</td>
        <td>${emp.empno }</td>
        <td>${emp.name}</td>
        <td>${emp.deptName }</td>
        
        <!-- grade 변환 -->
        <td>
            <c:choose>
                <c:when test="${emp.grade == 100}">사원</c:when>
                <c:when test="${emp.grade == 110}">주임</c:when>
                <c:when test="${emp.grade == 120}">대리</c:when>
                <c:when test="${emp.grade == 130}">과장</c:when>
                <c:when test="${emp.grade == 140}">차장</c:when>
                <c:when test="${emp.grade == 150}">부장</c:when>
                <c:when test="${emp.grade == 160}">사장</c:when>
                <c:otherwise>직급 정보 없음</c:otherwise>
            </c:choose>
        </td>

    </tr>
    <c:set var="num" value="${num + 1 }"></c:set>
</c:forEach>
				</tbody>
			</table>
			<table>
			<div id="container">
				<c:if test="${page.startPage > page.pageBlock }">
					<a
						href="adminSalSet?currentPage=${page.startPage-page.pageBlock}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
					<a href="adminSalSet?currentPage=${i}">[${i}]</a>
				</c:forEach>
				<c:if test="${page.endPage < page.totalPage }">
					<a
						href="adminSalSet?currentPage=${page.startPage+page.pageBlock}">[다음]</a>
				</c:if>
				</div>

			</table>

		</div>
		<div class="row col-sm-4 g-3">
			<table class='table table-striped'>

				<tr>
					<th>1.기초정보</th>
				</tr>
<tr>
					<th>이    름 : ${shemp.name }<p> 
						입사일자 : ${shemp.hiredate }<p>
						부 서 명 :  ${shemp.deptName }<p> 
						직    급 :   <c:choose>
                <c:when test="${shemp.grade == 100}">사원</c:when>
                <c:when test="${shemp.grade == 110}">주임</c:when>
                <c:when test="${shemp.grade == 120}">대리</c:when>
                <c:when test="${shemp.grade == 130}">과장</c:when>
                <c:when test="${shemp.grade == 140}">차장</c:when>
                <c:when test="${shemp.grade == 150}">부장</c:when>
                <c:when test="${shemp.grade == 160}">사장</c:when>
                <c:otherwise>직급 정보 없음</c:otherwise>
            </c:choose><p>
						    <td>
         
        </td>
				
				</tr>

				<tr>
					<th>2. 급여정보</th>
				</tr>
				<tr>
					<th>
						<form class="row g-3">
						<p>
						<div class="form-floating mb-3">
						
					기본급 : <input type="text" id="isalBase" value="${shemp.salBase }"  class="text"><p> 
					식대 :  <input type="text" id="isalFood" value="${shemp.salFood }"  class="text"><p>
					상여 :  <input type="text" id="isalBonus"  value="${shemp.salBonus }"   class="text"><p> 
					추가수당 :  <input type="text" id="isalNight" value="${shemp.salNight }"  class="text"><p>
					</p>
					</div>
						</form>
				<tr>
					<th>3. 계좌정보</th>
				</tr>
				<tr>
					<th>
						
						계좌번호 : 
								<input type="text" id="iaccount"  class="text">
							
							<button id="btn1"  onclick="location.href='/mh/adminSalSet?currentPage=1'">취소</button>
							<button id="btn2">저장</button>
    
			</table>
		</div>
	</div>


	<script type="text/javascript">
    function salDList(empno) {
        $.ajax({
            url: "/mh/getDeptName?empno=" + empno, 
            type: "GET",         
			dataType:'json',
            success: function(response) {

            	 let gradeName = '';
                 switch(response.response.grade) {
                     case 100:
                         gradeName = '사원';
                         break;
                     case 110:
                         gradeName = '주임';
                         break;
                     case 120:
                         gradeName = '대리';
                         break;
                     case 130:
                         gradeName = '과장';
                         break;
                     case 140:
                         gradeName = '차장';
                         break;
                     case 150:
                         gradeName = '부장';
                         break;
                     case 160:
                         gradeName = '사장';
                         break;
                     default:
                         gradeName = '직급 정보 없음';
                 }
                $('#iname').val(response.response.name);
                $('#idate').val(response.response.hiredate);
                $('#idname').val(response.response.deptName);
                $('#igraed').val(gradeName);
                $('#isalBase').val(response.response.salBase);
                $('#isalFood').val(response.response.salFood);
                $('#isalBonus').val(response.response.salBonus);
                $('#isalNight').val(response.response.salNight);
                $('#iaccount').val(response.response.bank + " - " + response.response.account);
                $('#salDate').val(response.response.salDate);
                $('#btn1').attr("onclick", "location.href='/mh/admin_sal_setUpdate?empno=" + empno + "'");

            },
            error: function(xhr, status, error) {
                console.error("AJAX 요청 중 오류 발생: ", status, error);
                console.log("응답 내용: ", xhr.responseText); 
            }
        });
    }

	        	        
	</script>
	
	
	
</body>
</html>