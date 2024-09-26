<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../1.main/admin_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>관리자 공과금</title>
 <style type="text/css">
        body {
            font-family: Arial, sans-serif;
            background-color: #FFFFFF; /* 배경색 흰색 */
            margin: 0;
            padding: 20px;
        }

        .page-title {
            text-align: center;
            color: #333;
        }

        .utility-form {
            max-width: 600px;
            margin: 0 auto;
            background-color: #F4F4F4; /* 폼 배경색 */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .utility-form label {
            color: #333; /* 라벨 색상 */
            display: block;
            margin-bottom: 5px;
            font-weight: bold; /* 라벨 두께 */
        }

        .utility-form input[type="month"],
        .utility-form input[type="number"],
        .utility-form input[type="file"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #8C8C8C; /* 테두리 색상 */
            border-radius: 4px;
            background-color: #E0E0E0; /* 입력 배경색 */
        }

        .utility-form input[type="submit"] {
            background-color: #8C8C8C; /* 버튼 배경색 */
            color: #FFFFFF; /* 버튼 글자색 */
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s; /* 부드러운 전환 효과 */
        }

        .utility-form input[type="submit"]:hover {
            background-color: #A0A0A0; /* hover 색상 */
        }
    </style>
</head>
<body>
<main>
    <h2 class="page-title">관리자 공과금 페이지입니다</h2>

    <form action="adminUtilityAdd" method="post" enctype="multipart/form-data" class="utility-form">
        <label for="utilityYyyymm">해당 년월:</label>
        <input type="month" id="utilityYyyymm" name="utilityYyyymm" required>

        <label for="utilityDetail">세부:</label>
        <input type="number" id="utilityDetail" name="utilityDetail" required>

        <label for="empno">사원번호:</label>
        <input type="number" id="empno" name="empno" required>

        <label for="codeNum">비용 항목 코드:</label>
        <input type="number" id="codeNum" name="codeNum" required>

        <label for="utilityAttach">증빙 서류:</label>
        <input type="file" id="utilityAttach" name="utilityAttach" accept="image/*,application/pdf" required>

        <label for="utilityCost">비용:</label>
        <input type="number" id="utilityCost" name="utilityCost" required>

        <input type="submit" value="공과금 추가">
    </form>
</main>
</body>
</html>
