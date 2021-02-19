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
    <style type="text/css">
        body{
            text-align-last: center;
        }
        thead{
            background-color: rgb(255, 255, 240);
        }
        th{
            border-style: solid;
            border-width: thin;
        }
        .left{
            text-align-last: left;
        }
    </style>
</head>
<body>
<div class="content">
    <h2>年輕學者研究獎</h2>
    <table>
        <thead>
            <tr>
                <th>申請表名稱</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td class="left"><a href="JuniorResearchInvestigator">推薦申請表</a></td>
            </tr>
            <tr>
                <td class="left"><a href="JuniorResearchInvestigatorReviewInformation">審查資料</a></td>
            </tr>
            <tr>
                <td class="left"><a href="JuniorResearchInvestigatorTableA">表A 近三年內發表之期刊論文統計表</a></td>
            </tr>
            <tr>
                <td class="left"><a href="JuniorResearchInvestigatorTableB">表B 傑出論文績效說明表</a></td>
            </tr>
            <tr>
                <td class="left"><a href="PaperPerformanceDescriptionUpload">表B 傑出論文績效說明表-上傳檔案</a></td>
            </tr>
        </tbody>
    </table>
    <div style="margin: 1rem;" class="edit">
        <button type="button" name="return_last_page" onclick="location.href='RewardList'">回上頁</button>
        <button type="button" name="send_application" onclick="commit()">提出申請</button>
    </div>
    <div style="margin: 1rem;" class="review">
        <button type="button" name="return_last_page" onclick="location.href='ReasonForReturn'">退件</button>
        <button type="button" name="confirm" onclick="commit()">審查完成</button>
    </div>
</body>
<script>
    $(document).ready(function () {
        $(".review").hide();
        $(".edit").hide();
        if(${readonly}){
            $(".review").show();
        }
        else{
            $(".edit").show();
        }
    })
    function commit(){
        alert("確定要送出嗎?");
        $.ajax({
            type: 'POST',
            url: 'JuniorResearchInvestigatorCatalog',
            dataType: 'text',
            data: JSON.stringify({"projectId": ${projectId}}),
            contentType: 'application/json',
            success: function(){
                alert("送出完成");
                window.location.href="RewardList";
            },
            error:function() {
                alert("送出失敗");
            }
        });
    };
</script>
</html>
