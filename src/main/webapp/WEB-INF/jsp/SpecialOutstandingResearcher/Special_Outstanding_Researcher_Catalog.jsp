<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%  /*避免瀏覽器因cache而無法看到最新資料*/
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);

%>

<!DOCTYPE HTML>
<html lang="zh">
<head>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<div class="content" >
    <table >

        <tr  >
            <td class="metadata" >表格名稱</td>
        </tr>

        <tbody>
            <tr >
                <td ><a href="SpecialOutstandingResearcherApplicationForm" name="SpecialOutstandingResearcherApplicationForm">獎勵特殊優秀研究人才申請表</a></td>

            </tr>
            <tr>
                <td><a href="OutstandingPerformanceDescriptionForm" name="OutstandingPerformanceDescriptionForm">特殊優秀研究人才傑出績效說明表</a></td>
            </tr>
            <tr >
                <td><a href="ReviewSupportingInformationForm" name="ReviewSupportingInformationForm">審查資料【填寫說明】</a></td>

            </tr>
            <tr >
                <td><a href="PaperPerformanceDescriptionForm" name="SpecialOutstandingResearcherTableB">論文績效說明表</a></td>

            </tr>
            <tr >
                <td><a href="PaperPerformanceDescriptionUpload" name="SpecialOutstandingResearcherUpload">論文績效說明表-上傳檔案</a></td>
            </tr>

            <tr >
                <td><a href="AwardDistributionAmountOrPrincipleForm" name="AwardDistributionAmountOrPrincipleForm">獎勵特殊優秀研究人才獎勵金分配金額或原則表</a></td>
            </tr>
        </tbody>
    </table>

    <div style="margin: 1rem;" class="edit">
        <button type="button" name="return_last_page" onclick="location.href='RewardList'">回上頁</button>
        <button type="button" name="send_application" onclick="sendApply()">提出申請</button>
    </div>
    <div style="margin: 1rem;" class="review">
        <input type="button" width="10%" value="回目錄" name="return_last_page" onclick="location.href='${catalogURL}'" >
        <button type="button" name="return_last_page" onclick="rejectApply()">退件</button>
        <button type="button" name="confirm" onclick="approveApply()">審查完成</button>
    </div>

</div>
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
    }

    function rejectApply(){
        if (confirm("確定要退件?"))
            window.location.href="/ReasonForReturn";
    }
</script>

</html>
