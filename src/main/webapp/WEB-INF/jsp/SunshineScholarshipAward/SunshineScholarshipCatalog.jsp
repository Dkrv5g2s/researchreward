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
        </tr>
        <tr>
            <td><a href="/SelectInformation">申請人基本資料</a></td>
        </tr>
        <tr>
            <td><a href="/PaperInformation">學術論著及FWCI計算</a></td>
        </tr>
<%--        <tr>--%>
<%--            <td><a href="/CatalogOfWorks">著作目錄</a></td>--%>
<%--        </tr>--%>

        <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">提出申請</button></td></tr>
        </tbody>
    </table>
</div>
</body>
</html>
