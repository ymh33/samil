<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../1.main/user_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공과금 그래프</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.4/dist/chart.umd.min.js"></script>
    <style>
        body {
            background-color: white; /* 배경 색상 */
            align-items: center; /* 수직 중앙 정렬 */
            height: 100vh; /* 전체 높이를 차지 */
            margin: 0; /* 기본 여백 제거 */
        }
        main {
            max-width: auto; /* 최대 너비 설정 */
            width: 100%; /* 전체 너비 사용 */
            padding: 20px; /* 패딩 추가 */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
            border-radius: 8px; /* 모서리 둥글게 */
        }
        table {
            width: 100%; /* 테이블 너비 */
            margin-top: 20px; /* 상단 마진 추가 */
            border-collapse: collapse; /* 테두리 합치기 */
        }
        th, td {
            border: 1px solid #3333CC; /* 테두리 색상 */
            padding: 10px; /* 패딩 추가 */
            text-align: center; /* 중앙 정렬 */
        }
        th {
            background-color: #3333CC; /* 헤더 배경 색상 */
            color: white; /* 헤더 글자 색상 */
        }
    </style>
</head>
<body>
    <main>
        <h2>공과금 사용 내역</h2>
        <canvas id="utilityChart"></canvas>
        <%-- 데이터 확인용 --%>
        <c:if test="${not empty utilityData}">
            <table>
                <thead>
                    <tr>
                        <th>해당년월</th>
                        <th>항목</th>
                        <th>비용</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="utility" items="${utilityData}" varStatus="status">
                        <c:if test="${status.index < 9}">
                            <tr>
                                <td>${utility.utilityYyyymm }</td>
                                <td>${utilityMap[utility.utilityDetail]}</td>
                                <td>${utility.utilityCost}</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </main>

    <script>
        const ctx = document.getElementById('utilityChart').getContext('2d');
        const labels = [];
        const data = [];
        const colors = ['rgba(255, 99, 132, 0.6)', 'rgba(54, 162, 235, 0.6)', 'rgba(255, 206, 86, 0.6)'];

        <c:if test="${not empty utilityData}">
            <c:forEach var="utility" items="${utilityData}" varStatus="status">
                <c:if test="${status.index < 9}">
                    labels.push('${UtilityMap[utility.utilityDetail]}');
                    data.push(${utility.utilityCost});
                </c:if>
            </c:forEach>
        </c:if>

        const groupedData = [];
        const groupedLabels = [];
        for (let i = 0; i < data.length; i += 3) {
            groupedLabels.push(labels.slice(i, i + 3));
            groupedData.push(data.slice(i, i + 3));
        }

        const datasets = groupedData.map((group, index) => ({
            label: `그룹 ${index + 1}`,
            data: group,
            backgroundColor: colors[index % colors.length],
            borderColor: colors[index % colors.length].replace('0.6', '1'),
            borderWidth: 1
        }));

        const myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: groupedLabels.flat(),
                datasets: datasets
            },
            options: {
                scales: {
                    x: {
                        barPercentage: 0.5,
                        categoryPercentage: 0.8
                    },
                    y: {
                        beginAtZero: true
                    }
                },
                layout: {
                    padding: {
                        left: 10,
                        right: 10,
                        top: 10,
                        bottom: 10
                    }
                }
            }
        });
    </script>
</body>
</html>
