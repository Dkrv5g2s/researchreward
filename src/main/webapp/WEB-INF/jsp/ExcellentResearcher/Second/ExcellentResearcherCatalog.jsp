<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2021/1/22
  Time: 下午 01:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>目錄</title>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/Function.js"></script>
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
                            window.open('SecondExcellentResearcherPrint', 'TheWindow');
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
            let fillPage = document.getElementsByClassName("filledCheck");
            let fillRatesKeys = Object.keys(fillRates);
            if (fillRatesKeys.length  < fillPage.length) {
                let unSavedPageName = "";
                for (let i = 0; i < fillPage.length; i++) {
                    let page = fillPage[i];
                    if (!fillRates[page.name]) {
                        unSavedPageName += page.innerHTML + "\n";
                    }
                }
                alert(unSavedPageName + "\n頁面尚未儲存");
                return false;
            } else {
                let unFinishedPageName = "";
                for (let i = 0; i < fillRatesKeys.length; i++) {
                    let fillRatesKey = fillRatesKeys[i];
                    const rate = fillRates[fillRatesKey];
                    if (fillPage.namedItem(fillRatesKey) && Math.fround(rate) < Math.fround(1.0)) {
                        unFinishedPageName += fillPage.namedItem(fillRatesKey).innerHTML + "\n";
                    }
                }
                if (unFinishedPageName.length > 0) {
                    alert(unFinishedPageName + "\n頁面尚未填寫完成");
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
                        window.open('SecondExcellentResearcherPrint', 'TheWindow');
                    }
                });
            }
        };

        function rejectApply(){
            if (confirm("是否確認送出退件?"))
                window.location.href="ReasonForReturn";
        };
    </script>
</head>
<body>
    <div class="content">
        <h2>(續撥)獎勵新聘特殊優秀研究人才(N類-續)</h2>
        <table>
            <tbody>
                <tr>
                    <td class="metadata">申請表名稱</td>
                </tr>
                <tr>
                    <td><a class = "filledCheck" href="SecondPersonalInformation" name="SecondPersonalInformation">基本資料&申請獎勵等級及符合資格</a></td>
                </tr>
                <tr>
                    <td><a class = "filledCheck" href="SecondExecutedPerformance" name="SecondExecutedPerformance">前一年度具體執行績效</a></td>
                </tr>
                <tr>
                    <td><a class = "filledCheck" href="SecondResearchProduction" name="SecondResearchProduction">獲獎勵期間學術研究成果及貢獻</a></td>
                </tr>
                <tr>
                    <td><a href="OtherFileUpload" name="OtherFileUpload">其他附件上傳</a></td>
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
</html>
