<%--
  Created by IntelliJ IDEA.
  User: Sandy
  Date: 2021/1/23
  Time: 下午 04:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>年輕學者研究獎</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="content">
    <table>
        <thead>
            <tr><th>年輕學者研究獎</th></tr>
        </thead>
        <tbody>
        <tr>
            <td><a href="JuniorResearchInvestigator">推薦申請表</a></td>
        </tr>
        <tr>
            <td><a href="JuniorResearchInvestigatorReviewInformation">審查資料</a></td>
        </tr>
        <tr>
            <td><a href="JuniorResearchInvestigatorTableA">表A 近三年內發表之期刊論文統計表</a></td>
        </tr>
        <tr>
            <td><a href="JuniorResearchInvestigatorTableB">表B 傑出論文績效說明表</a></td>
        </tr>
        </tbody>
    </table>
    <div style="text-align-last: center; margin: 1rem;">
        <button type="button" name="return_last_page" onclick="location.href='RewardList'">回上頁</button>
        <button type="button" name="return_last_page" onclick="">提出申請</button>
    </div>
</div>
</body>
</html>
