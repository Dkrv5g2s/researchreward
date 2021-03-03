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
        <thead>
        <th  colspan="3" >
            陽光獎助金論文申請
        </th>
        </thead>
        <tbody>
        <tr>
            <td class="metadata">表格名稱</td>
        </tr>
        <tr>
            <td ><a href="SelectInformation">陽光獎助學金論文(教職研人員)獎勵申請表</a></td>
        </tr>
        <tr>
            <td ><a href="SunshineScholarshipAwardTableA">表A.論文績效說明表</a></td>
        </tr>
        <tr>
            <td ><a href="SunshineScholarshipAwardTableAUpload">表A.論文績效說明表-檔案上傳</a></td>
        </tr>
        </tbody>
    </table>
    <div style="margin: 1rem;" class="edit">
        <button type="button" name="return_last_page" onclick="location.href='RewardList'">回上頁</button>
        <button type="button" name="send_application" onclick="sendApply()">提出申請</button>
    </div>
    <div style="margin: 1rem;" class="review">
        <button type="button" name="return_last_page" onclick="rejectApply()">退件</button>
        <button type="button" name="confirm" onclick="approveApply()">審查完成</button>
    </div>

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
    function sendApply(){
        if (confirm("確定要送出申請?")) {
            $.ajax({
                type: 'POST',
                url: '/SendApply',
                dataType: 'text',
                data: "",
                contentType: 'application/text',
                success: function (data) {
                    alert('申請成功');
                    window.location.href = "/TraceProgress";
                }
            });
        }
    };

    function approveApply(){
        if (confirm("確定要確認審理?")) {
            $.ajax({
                type: 'POST',
                url: '/ApproveApply',
                dataType: 'text',
                data: "",
                contentType: 'application/text',
                success: function (data) {
                    alert('確認審理成功');
                    window.location.href = "/ApprovedRewardList";
                }
            });
        }
    };

    function rejectApply(){
        if (confirm("確定要退件?"))
            window.location.href="/ReasonForReturn";
    };
</script>

</html>