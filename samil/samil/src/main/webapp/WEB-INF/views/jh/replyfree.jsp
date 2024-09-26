<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../1.main/user_header.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <style type="text/css">
        h2 {
            margin-top: 80px;
        }

        body {
            text-align: center; /* body의 텍스트를 중앙 정렬하여 테이블도 중앙에 배치 */
            margin: 0;
            padding: 0;
        }

        table {
            margin: 0 auto; /* 테이블을 수평으로 중앙에 배치 */
            border-collapse: collapse; /* 테이블의 셀 경계선 겹치지 않도록 설정 */
            width: 60%; /* 테이블 너비 설정 */
        }

        th, td {
            padding: 10px; /* 셀 안쪽에 여백 추가 */
            border: 1px solid #ddd; /* 셀에 테두리 추가 */
        }

        td {
            text-align: left;
        }

        th {
            background-color: #f2f2f2; /* 테이블 헤더 배경색 */
            text-align: center; /* 헤더의 텍스트를 중앙 정렬 */
            width: 75px; /* 기본 너비 설정 */
        }

        h2 {
            text-align: center; /* 제목을 중앙에 정렬 */
        }

        /* 버튼 스타일 */
        .button-container {
            text-align: center;
            margin-top: 20px;
        }

        .button-container input[type="button"],
        .button-container input[type="submit"] {
            margin-right: 20px;
            margin-bottom: 100px;
            padding: 5px 8px;
            font-size: 1.2em;
            background-color: #034EA2;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: inline-block;
        }

        .button-container input[type="button"]:hover,
        .button-container input[type="submit"]:hover {
            background-color: #023e8a; /* 호버 시 배경색 변경 */
        }

        /* 입력 필드 스타일 */
        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
        }

        textarea {
            height: 200px; /* 텍스트 영역 크기 조정 */
        }
    </style>
    <title>답글 작성</title>
</head>

<body>
    <h2>답글 작성</h2>

    <!-- 답글 작성 폼 -->
    <form action="/jh/replyfree" method="post">
        <input type="hidden" name="boardId" value="${posts.boardId}"> <!-- 히든 필드로 boardId 전달 -->

        <table>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="empno" value="${empno}" readonly></td> <!-- 작성자 필드는 readonly -->
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" placeholder="제목을 입력하세요"></td> <!-- 제목 입력 필드 -->
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="content" placeholder="내용을 입력하세요"></textarea></td> <!-- 내용 입력 필드 -->
            </tr>
        </table>

        <!-- 버튼 영역 -->
        <div class="button-container">
            <input type="submit" value="답변 저장"> <!-- 답변 저장 버튼 -->
            <input type="button" value="목록" onclick="history.back();"> <!-- 목록 버튼 -->
        </div>
    </form>
</body>

</html>
