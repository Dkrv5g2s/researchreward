<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2021/1/22
  Time: 下午 01:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>目錄</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <div class="content">
        <table>
            <tbody>
                <tr>
                    <td class="metadata">表格名稱</td>
                </tr>
                <tr>
                    <td><a href="/SecondPersonalInformation">基本資料&申請獎勵等級及符合資格</a></td>
                </tr>
                <tr>
                    <td><a href="/SecondExecutedPerformance">前一年度具體執行績效</a></td>
                </tr>
                <tr>
                    <td><a href="/SecondResearchProduction">獲獎勵期間學術研究成果及貢獻</a></td>
                </tr>
                <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">提出申請</button></td></tr>
            </tbody>
        </table>
    </div>

</body>
</html>
