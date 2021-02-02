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
        <th>
            傑出研究獎
        </th>
        </thead>
        <tbody>
        <tr>
            <td><a href="/OutstandingResearchAward">推薦申請表</a></td>
        </tr>
        <tr>
            <td><a href="/OutstandingResearchAwardReviewInformation">審查資料</a></td>
        </tr>
        <tr>
            <td><a href="/OutstandingResearchAwardTableA">附件A 近三年內發表之期刊論文統計表</a></td>
        </tr>
        <tr>
            <td><a href="/OutstandingResearchAwardTableB">附件B 國立臺北科技大學傑出論文績效說明表</a></td>
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
