<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- 스타일 시트 링크 (선택적) -->
</head>
<body>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Department</th>
                <th>Position</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="dept" items="${deptList}">
                <tr>
                    <td>${dept.empno}</td>
                    <td>${dept.name}</td>
                    <td>${dept.deptName}</td>
                    <td>${dept.job}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
