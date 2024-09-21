<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <title>관리자 급여설정 페이지</title>
</head>
<body>
    <div class="container">
        <h2 class="my-4">관리자 급여설정 페이지</h2>

        <!-- 데이터 테이블 -->
        <div id="data-container">
            <table class="table table-bordered">
                <thead class="table-light">	      
                    <tr>
                        <th>번호</th>
                        <th>사원번호</th>
                        <th>사원명</th>
                        <th>전화번호</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="emp" items="${listEmp}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${emp.empno}</td>
                            <td>${emp.name}</td>
                            <td>${emp.phone}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- 페이지네이션 -->
        <div id="pagination" class="mt-3">
            <c:if test="${page.startPage > page.pageBlock}">
                <a href="javascript:void(0)" onclick="loadPage(${page.startPage-page.pageBlock})" class="btn btn-outline-primary">[이전]</a>
            </c:if>

            <c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
                <a href="javascript:void(0)" onclick="loadPage(${i})" class="btn btn-outline-secondary">${i}</a>
            </c:forEach>

            <c:if test="${page.endPage < page.totalPage}">
                <a href="javascript:void(0)" onclick="loadPage(${page.startPage+page.pageBlock})" class="btn btn-outline-primary">[다음]</a>
            </c:if>
        </div>

        <!-- 급여 정보 -->
        <div class="row g-3 mt-5">
            <div class="col-md-6">
                <h4>1. 기초정보</h4>
                <p>이름: 홍길동</p>
                <p>입사일자: 00-00-00</p>
                <p>부서명: 개발</p>
                <p>직책: 부장</p>
            </div>

            <div class="col-md-6">
                <h4>2. 급여정보</h4>
                <form>
                    <div class="row mb-3">
                        <label for="sal1" class="col-sm-2 col-form-label">급여</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="sal1">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="sal2" class="col-sm-2 col-form-label">식대</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="sal2">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="sal3" class="col-sm-2 col-form-label">상여</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="sal3">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="sal4" class="col-sm-2 col-form-label">야간수당</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="sal4">
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="row g-3 mt-4">
            <div class="col-md-6">
                <h4>3. 계좌정보</h4>
                <div class="row mb-3">
                    <label for="bankAccount" class="col-sm-2 col-form-label">계좌번호</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="bankAccount">
                    </div>
                </div>
                <div class="mb-3">
                    <label for="bankName" class="col-form-label">은행명</label>
                    <select class="form-select" id="bankName">
                        <option selected>Choose...</option>
                        <option value="1">은행 1</option>
                        <option value="2">은행 2</option>
                        <option value="3">은행 3</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="mt-3">
            <button type="button" class="btn btn-primary">저장</button>
            <button type="submit" class="btn btn-secondary">수정</button>
        </div>
    </div>

    <!-- Ajax로 페이지 데이터를 불러오는 스크립트 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        function loadPage(pageNumber) {
            $.ajax({
                url: 'admin_sal_set',
                type: 'GET',
                data: {currentPage: pageNumber},
                success: function(response) {
                    // 데이터를 HTML로 변환해서 테이블에 넣기
                    let tableHtml = '';
                    $.each(response.employees, function(index, emp) {
                        tableHtml += '<tr><td>' + (index + 1) + '</td><td>' + emp.empno + '</td>';
                        tableHtml += '<td>' + emp.name + '</td><td>' + emp.phone + '</td></tr>';
                    });
                    $('#data-container tbody').html(tableHtml);

                    // 페이지네이션 갱신
                    $('#pagination').html(response.paginationHtml);
                },
                error: function(xhr, status, error) {
                    console.error("Ajax 요청 실패:", error);
                }
            });
        }
    </script>
</body>
</html>
