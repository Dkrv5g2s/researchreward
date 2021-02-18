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
            <td class="metadata">操作</td>
            <td class="metadata">表格狀態</td>
        </tr>
        <tr>
            <td>推薦申請表</td>
            <td><button onclick="location.href='OutstandingResearchAward'">編輯</button></td>
            <td>【Time】填寫</td>

        </tr>
        <tr>
            <td>審查資料表</td>
            <td><button onclick="location.href='OutstandingResearchAwardReviewInformation'">編輯</button></td>
            <td>【Time】填寫</td>
        </tr>
        <tr>
            <td>檢附表A 近三年內發表之期刊論文統計表</td>
            <td><button onclick="location.href='OutstandingResearchAwardTableA'">編輯</button></td>
            <td>【Time】填寫</td>
        </tr>
        <tr>
            <td>檢附表B 傑出論文績效說明表</td>
            <td><button onclick="location.href='OutstandingResearchAwardTableB'">編輯</button></td>
            <td>【Time】填寫</td>
        </tr>
        <tr>
            <td>檢附表B 傑出論文績效說明表-檔案上傳</td>
            <td><button onclick="location.href='PaperPerformanceDescriptionUpload'">編輯</button></td>
            <td>【Time】填寫</td>
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
