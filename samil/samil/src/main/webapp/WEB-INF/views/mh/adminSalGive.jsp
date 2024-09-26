<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../1.main/admin_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>관리자 급여지급 페이지입니다</title>
</head>
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
            color: black;
            float: r; width: 33%; padding:10px; 
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
body { text-align: center; }

</style>
<body>
	<h2>관리자 급여지급 페이지입니다</h2>
급여 지급일 : ${salDate}
			<form action="listSearchGive">
			<select class ="sertchList" name="search">
				<option class ="sertchList" value="seartchEmpno">사원번호</option>
				<option class ="sertchList" value="seartchName">사원명</option>
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
    <tr ondblclick="location.href='/mh/adminSalGiveD?empno=${emp.empno}'" id="salDList" style="cursor: pointer;">
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
						href="adminSalGive?currentPage=${page.startPage-page.pageBlock}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
					<a href="adminSalGive?currentPage=${i}">[${i}]</a>
				</c:forEach>
				<c:if test="${page.endPage < page.totalPage }">
					<a
						href="adminSalGive?currentPage=${page.startPage+page.pageBlock}">[다음]</a>
				</c:if>
				</div>

			</table>
	
</body>
</html>