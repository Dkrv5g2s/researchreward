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
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
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
            <td class="left"><a href="LectureProfessorApplicationForm" name="LectureProfessorApplicationForm">講座教授申請表</a></td>
        </tr>
        <tr>
            <td class="left"><a href="LectureProfessorHonoraryApplicationForm" name="LectureProfessorHonoraryApplicationForm">榮譽講座教授申請表</a></td>
        </tr>
        <tr>
            <td class="left"><a href="LectureProfessorAppDocInstructions" name="LectureProfessorAppDocInstructions">審查資料(填寫說明)</a></td>
        </tr>
        <tr>
            <td class="left"><a href="LectureProfessorExcellenceFormA" name="LectureProfessorExcellenceFormA">近五年內傑出績效說明表</a></td>
        </tr>
        <tr>
            <td class="left"><a href="LectureProfessorFormCUploadFile" name="LectureProfessorFormCUploadFile">近五年內傑出績效說明表-上傳檔案</a></td>
        </tr>
        <tr>
            <td class="left"><a href="PaperPerformanceDescriptionForm" name="LectureProfessorTableB">國立臺北科技大學傑出論文績效說明表</a></td>
        </tr>
        <tr>
            <td class="left"><a href="PaperPerformanceDescriptionUpload" name="PaperPerformanceDescriptionUpload">國立臺北科技大學傑出論文績效說明表-上傳檔案</a></td>
        </tr>
        <tr>
            <td class="left"><a href="LectureProfessorExcellenceFormC" name="LectureProfessorExcellenceFormC">傑出研究表現說明及申請機構推薦理由</a></td>
        </tr>
        <tr>
            <td class="left"><a href="LectureProfessorExcellenceFormD" name="LectureProfessorExcellenceFormD">講座期間之績效表現(申請第二任以上者填寫)</a></td>
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
        if (!confirm("確定要送出申請?")) {
            return;
        }
        new Promise((resolve, reject) => {
            $.ajax({
                type: 'POST',
                url: 'ProjectFillRate',
                dataType: 'text',
                data: "",
                contentType: 'application/text',
                success: async function (data) {
                    let rateData = JSON.parse(data);
                    resolve(await checkFilled(rateData));
                },
                error: function (data) {
                    console.log(data);
                    reject(false);
                }
            });
        }).then(result=>{
            if(result){
                $.ajax({
                    type: 'POST',
                    url: 'SendApply',
                    dataType: 'text',
                    data: "",
                    contentType: 'application/text',
                    success: function (data) {
                        alert('申請成功');
                        window.location.href = "TraceProgress";
                        window.open('LectureProfessorPrint', 'TheWindow');
                    },
                    error: function(jqXHR, textStatus, message) {
                        alert(jqXHR.responseText);
                    }
                });
            }
        });

    };
    async function checkFilled(fillRates) {
        if(!fillRates){
            return false;
        }
        console.log(fillRates)
        let fillPage = document.getElementsByTagName("a");
        let fillRatesKeys = Object.keys(fillRates);
        // ReviewInformation page don't need to be checked fillRate.
        console.log(fillPage.length)
        console.log(fillRatesKeys.length)
        if (fillRatesKeys.length < fillPage.length-1) {
            let unSavedPageName = "";
            for (let i = 0; i < fillPage.length; i++) {
                let page = fillPage[i];
                if (!fillRates[page.name] && page.innerHTML!="審查資料(填寫說明)") {
                    unSavedPageName += page.innerHTML + " ";
                }
            }
            alert(unSavedPageName + "頁面尚未儲存");
            return false;
        } else if (fillRatesKeys.length === fillPage.length-1) {
            let unFinishedPageName = "";
            for (let i = 0; i < fillRatesKeys.length; i++) {
                let fillRatesKey = fillRatesKeys[i];
                const rate = fillRates[fillRatesKey];
                if (rate < 1.0) {
                    unFinishedPageName += fillPage.namedItem(fillRatesKey).innerHTML + " ";
                }
            }
            if (unFinishedPageName.length > 0) {
                alert(unFinishedPageName + "頁面尚未填寫完成");
                return false;
            } else {
                console.log("send");
                return true;
            }
        }
        return false;
    }
    function approveApply(){
        if (confirm("是否確認送出審理?")) {
            $.ajax({
                type: 'POST',
                url: 'ApproveApply',
                dataType: 'text',
                data: "",
                contentType: 'application/text',
                success: function (data) {
                    alert('確認審理成功');
                    window.location.href = "ApprovedRewardList";
                    window.open('LectureProfessorPrint', 'TheWindow');
                },
                error: function (massage) {
                    alert("審理失敗，請洽系統管理員");
                }
            });
        }
    };

    function rejectApply(){
        if (confirm("確定要退件?"))
            window.location.href="ReasonForReturn";
    };
</script>
</html>
