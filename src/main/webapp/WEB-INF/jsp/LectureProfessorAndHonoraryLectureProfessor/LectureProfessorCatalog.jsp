<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="com.google.gson.*" %>

<%@ page import="Bean.Project.RewardProject" %>
<%  /*避免瀏覽器因cache而無法看到最新資料*/
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE HTML>
<html lang="zh">
<head>
    <title>講座教授/榮譽講座教授</title>
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
    <h2>講座教授/榮譽講座教授</h2>
    <table>
        <thead>
        <tr>
            <th>申請表名稱</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="left"><a href="LectureProfessorApplicationForm">講座教授申請表</a></td>
        </tr>
        <tr>
            <td class="left"><a href="LectureProfessorHonoraryApplicationForm">榮譽講座教授申請表</a></td>
        </tr>
        <tr>
            <td class="left"><a href="LectureProfessorAppDocInstructions" >審查資料(填寫說明)</a></td>
        </tr>
        <tr>
            <td class="left"><a href="LectureProfessorExcellenceFormA" >近五年內傑出績效說明表(表A)</a></td>
        </tr>
        <tr>
            <td class="left"><a href="PaperPerformanceDescriptionForm" >國立臺北科技大學傑出論文績效說明表(表B)</a></td>
        </tr>
        <tr>
            <td class="left"><a href="PaperPerformanceDescriptionUpload" >國立臺北科技大學傑出論文績效說明表(表B)-上傳檔案</a></td>
        </tr>
        <tr>
            <td class="left"><a href="LectureProfessorExcellenceFormC" >傑出研究表現說明及申請機構推薦理由</a></td>
        </tr>
        <tr>
            <td class="left"><a href="LectureProfessorExcellenceFormD" >講座期間之績效表現(申請第二任以上者填寫)</a></td>
        </tr>
  <!--      <tr>
            <td class="left"><a href="LectureProfessorRefPoint" >附表一：國立臺北科技大學論文點數計算公式</a></td>
        </tr>
        <tr>
            <td class="left"><a href="LectureProfessorRefTable" >附件一：優質期刊清單</a></td>
        </tr>
        -->
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
                },
                error: function(jqXHR, textStatus, message) {
                    //error handling
                    alert(jqXHR.responseText);
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
