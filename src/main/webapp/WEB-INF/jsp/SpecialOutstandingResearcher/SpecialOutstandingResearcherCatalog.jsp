<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%  /*避免瀏覽器因cache而無法看到最新資料*/
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE HTML>
<html lang="zh">
<head>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
    <script src="js/jquery.min.js"></script>
</head>
<div class="content" >
    <h2 style="text-align:center;">獎勵特殊優秀人才(A類)</h2>
    <table >

        <tr  >
            <td class="metadata" >申請表名稱</td>
        </tr>

        <tbody>
            <tr >
                <td ><a class="filledCheck" href="SpecialOutstandingResearcherApplicationForm" name="SpecialOutstandingResearcherApplicationForm">獎勵特殊優秀研究人才申請表</a></td>

            </tr>
            <tr>
                <td><a class="filledCheck" href="OutstandingPerformanceDescriptionForm" name="OutstandingPerformanceDescriptionForm">特殊優秀研究人才傑出績效說明表</a></td>
            </tr>
            <tr >
                <td><a href="ReviewSupportingInformationForm" name="ReviewSupportingInformationForm">審查資料【填寫說明】</a></td>

            </tr>
            <tr >
                <td><a class="filledCheck" href="PaperPerformanceDescriptionForm" name="SpecialOutstandingResearcherTableB">論文績效說明表</a></td>

            </tr>
            <tr >
                <td><a class="filledCheck" href="PaperPerformanceDescriptionUpload" name="PaperPerformanceDescriptionUpload">論文績效說明表-上傳檔案</a></td>
            </tr>

            <tr >
                <td><a class="filledCheck" href="AwardDistributionAmountOrPrincipleForm" name="AwardDistributionAmountOrPrincipleForm">獎勵特殊優秀研究人才獎勵金分配金額或原則表</a></td>
            </tr>
            <tr>
                <td class="left"><a href="OtherFileUpload" name="OtherFileUpload">其他附件上傳</a></td>
            </tr>
        </tbody>
    </table>

    <div class="edit footer">
        <button type="button" name="return_last_page" onclick="location.href='RewardList'">回上頁</button>
        <button type="button" name="send_application" onclick="sendApply()">提出申請</button>
    </div>
    <div class="review footer">
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
                url: 'ProjectFillRate',
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
                    url: 'SendApply',
                    dataType: 'text',
                    data: "",
                    contentType: 'application/text',
                    success: function (data) {
                        alert('申請成功');
                        window.location.href = "TraceProgress";
                        window.open('SpecialOutstandingResearcherPrint', 'TheWindow');
                    },
                    error: function (message) {
                        alert(message);
                    }
                });
            }
        });
    }

    async function checkFilled(fillRates) {
        if(!fillRates){
            return false;
        }
        let fillPage = document.getElementsByClassName("filledCheck");
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
                    window.open('SpecialOutstandingResearcherPrint', 'TheWindow');
                }
            });
        }
    }

    function rejectApply(){
        if (confirm("是否確認送出退件?"))
            window.location.href="ReasonForReturn";
    }
</script>

</html>
