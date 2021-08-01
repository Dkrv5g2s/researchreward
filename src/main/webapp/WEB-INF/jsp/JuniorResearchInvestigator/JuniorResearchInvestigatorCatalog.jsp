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
                <td class="left"><a href="JuniorResearchInvestigator" name="JuniorResearchInvestigator">推薦申請表</a></td>
            </tr>
            <tr>
                <td class="left"><a href="JuniorResearchInvestigatorReviewInformation" name="JuniorResearchInvestigatorReviewInformation">審查資料</a></td>
            </tr>
            <tr>
                <td class="left"><a href="JuniorResearchInvestigatorTableA" name="JuniorResearchInvestigatorTableA">近三年內發表之期刊論文統計表</a></td>
            </tr>
            <tr>
                <td class="left"><a href="JuniorResearchInvestigatorTableB" name="JuniorResearchInvestigatorTableB">傑出論文績效說明表</a></td>
            </tr>
            <tr>
                <td class="left"><a href="PaperPerformanceDescriptionUpload" name="PaperPerformanceDescriptionUpload">傑出論文績效說明表-上傳檔案</a></td>
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
    async function sendApply() {
        if (!confirm("確定要送出申請?")) {
            return;
        }
        new Promise((resolve, reject) => {
            $.ajax({
                type: 'POST',
                url: '/ProjectFillRate',
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
                    url: '/SendApply',
                    dataType: 'text',
                    data: "",
                    contentType: 'application/text',
                    success: function (data) {
                        alert('申請成功');
                        window.location.href = "/TraceProgress";
                    },
                    error: function (jqXHR, textStatus, message) {
                        alert(jqXHR.responseText);
                    }
                });
            }
        });
    }

    async function checkFilled(fillRates) {
        if(!fillRates){
            return false;
        }
        let fillPage = document.getElementsByTagName("a");
        let fillRatesKeys = Object.keys(fillRates);
        if (fillRatesKeys.length < fillPage.length) {
            let unSavedPageName = "";
            for (let i = 0; i < fillPage.length; i++) {
                let page = fillPage[i];
                if (!fillRates[page.name]) {
                    unSavedPageName += page.innerHTML + " ";
                }
            }
            alert(unSavedPageName + "頁面尚未儲存");
            return false;
        } else if (fillRatesKeys.length === fillPage.length) {
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
