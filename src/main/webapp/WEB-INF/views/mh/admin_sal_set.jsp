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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>관리자 급여설정 페이지입니다</title>
</head>
<body>
	<h2>관리자 급여설정 페이지입니다</h2>
	<div class="row g-3">
		<div class="col">
			<table>
				<tr>
					<th>번호</th>
					<th>사원번호</th>
					<th>사원명</th>
					<th>전화번호</th></tr>		
			<c:set var="num" value="1"></c:set>
			<c:forEach var="emp" items="${listEmp }">
			<tr><td>${num }</td><td>${emp.empno }</td>
			<td>${emp.name}</td>
				<td>${emp.job }</td><td>${emp.phone }</td></tr>
			<c:set var="num" value="${num + 1 }"></c:set>
		</c:forEach>
	</table>	
	<table>
	<c:if test="${page.startPage > page.pageBlock }">
		<a href="admin_sal_set?currentPage=${page.startPage-page.pageBlock}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
		<a href="admin_sal_set?currentPage=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${page.endPage < page.totalPage }">
		<a href="admin_sal_set?currentPage=${page.startPage+page.pageBlock}">[다음]</a>
	</c:if>	
	
		</table>

		</div>
		<div class="row col g-3">
			<table>

				<tr>
					<th>1.기초정보</th>
				</tr>
				<tr>
					<th>이 름 : 홍길동 <br> 입사일자 : 00-00-00<br> 부 서 명 : 개발 직
						책 : 부장
					</th>
				</tr>

				<tr>
					<th>2. 급여정보</th>
				</tr>
				<tr>
					<th>
						<div class="row mb-3">
							<label for="inputEmail3" class="col-sm-2 col-form-label">급여정보</label>
							<div class="col-sm-3">
								<input type="number" class="form-control" id="sal1">
							</div>
						</div>
						<div class="row mb-3">
							<label for="inputPassword3" class="col-sm-2 col-form-label">식대</label>
							<div class="col-sm-3">
								<input type="number" class="form-control" id="sal2">
							</div>
						</div>
						<div class="row mb-3">
							<label for="inputPassword3" class="col-sm-2 col-form-label">상여</label>
							<div class="col-sm-3">
								<input type="number" class="form-control" id="sal3">
							</div>
						</div>
						<div class="row mb-3">
							<label for="inputPassword3" class="col-sm-2 col-form-label">야간수당</label>
							<div class="col-sm-3">
								<input type="number" class="form-control" id="sal4">
							</div>
						</div>
				<tr>
					<th>3. 계좌정보</th>
				</tr>
				<tr>
					<th> <div class="col-auto">
    <label class="visually-hidden" for="autoSizingSelect">Preference</label>
    <select class="form-select" id="autoSizingSelect">
      <option selected>Choose...</option>
      <option value="1">One</option>
      <option value="2">Two</option>
      <option value="3">Three</option>
    </select>
  </div>
					<div class="row mb-7">
							<label for="inputPassword3" class="col-sm-2 col-form-label ">계좌번호
								: </label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="sal5">
							</div>
						</div>
			</table>
			<form class="row g-3">
	<div class="col-md-3">
    <label for="inputEmail4" class="form-label">기본급</label>
    <input type="email" class="form-control" id="inputEmail4">
  </div>
  <div class="col-md-3">
    <label for="inputPassword4" class="form-label">식대</label>
    <input type="password" class="form-control" id="inputPassword4">
  </div>
  </form>

		</div>
	</div>
				<input type="button" value="저장"> <input type="submit"value="수정">
</body>
</html>