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
            text-align: center; /* body의 텍스트를 중앙 정렬하여 테이블도 중앙에 배치됩니다. */
            margin: 0;
            padding: 0;
        }

        table {
            margin: 0 auto; /* 테이블을 수평으로 중앙에 배치합니다. */
            border-collapse: collapse; /* 테이블의 셀 경계선이 겹치지 않도록 설정합니다. */
            width: 60%; /* 테이블 너비를 설정합니다. */
        }

        th, td {
            padding: 10px; /* 셀 안쪽에 여백을 추가하여 내용이 셀의 경계와 떨어지도록 합니다. */
            border: 1px solid #ddd; /* 셀에 테두리를 추가합니다. */
        }
        td {
            text-align: left; /* 헤더의 텍스트를 중앙 정렬합니다. */
        }

        th {
            background-color: #f2f2f2; /* 테이블 헤더의 배경색을 설정합니다. */
            text-align: center; /* 헤더의 텍스트를 중앙 정렬합니다. */
            width: 75px; /* 기본 너비 설정 (예시, 필요에 따라 조정) */
        }

        /* '내용' 열을 50% 너비로 설정합니다. */
        td:nth-child(3) {
            width: 100%; /* '내용' 열의 너비를 50%로 설정합니다. */
        }
		
		textarea {
    		width: 100%; /* 너비를 100%로 설정합니다. */
  	 	    height: 200px; /* 높이를 원하는 값으로 설정합니다. */
		}
		
        h2 {
            text-align: center; /* 제목(h2)을 중앙에 정렬합니다. */
        }

        .button-container {
            text-align: center;
            margin-top: 20px;
        }

        .button-container input[type="submit"], 
        .button-container input[type="button"] {
            margin-right: 20px;
            padding: 5px 8px;
            font-size: 1.2em;
            background-color: #034EA2;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .button-container input[type="submit"]:hover,
        .button-container input[type="button"]:hover {
            background-color: #023e8a; /* 호버 시 배경색 변경 */
        }

        .file-upload {
            display: inline-block; /* 파일 첨부 버튼을 인라인 블록으로 설정합니다. */
        }
    </style>
</head>

<body>
    <h2>글 작성</h2>

    <form action="writeFree" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="empno" required></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" name="postsTitle" required></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="postsCnt" rows="5" required></textarea></td>
            </tr>
             <tr>
                <th>파일첨부</th>
                <td><input type="file" name="fileName" class="file-upload" ></td>
            </tr>
           
        </table>

        <div class="button-container">
            <input type="submit" value="작성하기">
            <input type="button" value="취소" onclick="history.back();"> 
        </div>
    </form>
</body>

</html>