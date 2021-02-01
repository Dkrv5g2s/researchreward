<%--
  Created by IntelliJ IDEA.
  User: Ted Lin
  Date: 2021/1/24
  Time: 下午 03:07
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
            <td class="metadata">操作</td>
            <td class="metadata">表格狀態</td>
        </tr>
        <tr>
            <td>陽光獎助學金論文(教職研人員)獎勵申請表</td>
            <td><button onclick="javascript:location.href='SelectInformation'">編輯</button></td>
<%--            <td>幾時幾分填寫</td>--%>
        </tr>

        <tr>
            <td>表A.論文績效說明表</td>
            <td><button onclick="javascript:location.href='PaperInformation'">編輯</button></td>
<%--            <td>幾時幾分填寫</td>--%>
        </tr>

<%--        <tr>--%>
<%--            <td><a href="/CatalogOfWorks">著作目錄</a></td>--%>
<%--        </tr>--%>

        <tr><td colspan="3" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">提出申請</button></td></tr>
        </tbody>
    </table>
</div>
</body>
</html>
