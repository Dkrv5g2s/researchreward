<%--
  Created by IntelliJ IDEA.
  User: Ted Lin
  Date: 2021/2/2
  Time: 上午 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>傑出研究獎</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="content">
    <table>
        <thead>
        <th  colspan="3" >
            傑出研究獎
        </th>
        </thead>
        <tbody>
        <tr>
            <td class="metadata">表格名稱</td>
        </tr>
        <tr>
            <td ><a href="OutstandingResearchAward">推薦申請表</a></td>
        </tr>
        <tr>
            <td ><a href="OutstandingResearchAwardReviewInformation">審查資料表</a></td>
        </tr>
        <tr>
            <td ><a href="OutstandingResearchAwardTableA">檢附表A 近三年內發表之期刊論文統計表</a></td>
        </tr>
        <tr>
            <td ><a href="OutstandingResearchAwardTableB">檢附表B 傑出論文績效說明表</a></td>
        </tr>
        <tr>
            <td ><a href="PaperPerformanceDescriptionUpload">檢附表B 傑出論文績效說明表-檔案上傳</a></td>
        </tr>
        </tbody>
    </table>
    <div style="text-align-last: center; margin: 1rem;">
        <button type="button" name="return_last_page" onclick="javascript:location.href='RewardList'">回上頁</button>
        <button type="button" name="return_last_page" onclick="">提出申請</button>
    </div>
</div>
</body>
</html>
