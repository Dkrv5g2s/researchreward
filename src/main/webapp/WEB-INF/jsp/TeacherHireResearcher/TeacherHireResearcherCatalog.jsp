<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>奬助研究績優教師聘任研究人員目錄</title>
        <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
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
                                window.open('TeacherHireResearcherPrint', 'TheWindow');
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
                if (fillRatesKeys.length < fillPage.length) {
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
                            window.open('TeacherHireResearcherPrint', 'TheWindow');
                        }
                    });
                }
            };

            function rejectApply(){
                if (confirm("是否確認送出退件?"))
                    window.location.href="ReasonForReturn";
            };

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
        </script>
    </head>
    <body>
    <div class="content">
        <h2 style="text-align:center;">奬助研究績優教師聘任研究人員</h2>
        <form>
            <table>
                <tbody>
                <tr>
                    <td class="metadata">申請表名稱</td>
                </tr>
                <tr>
                    <td><a class="filledCheck" href="TeacherHireResearcherForm" name="TeacherHireResearcherForm">奬助研究績優教師聘任研究人員申請表</a></td>
                </tr>
                <tr>
                    <td><a href="TeacherHireResearcherAppDocInstructions" name="TeacherHireResearcherAppDocInstructions">審查資料(填寫說明)</a></td>
                </tr>
                <tr>
                    <td><a class="filledCheck" href="TeacherHireResearcherTableA" name="TeacherHireResearcherTableA">近五年內發表之期刊論文統計表</a></td>
                </tr>
                <tr>
                    <td><a class="filledCheck" href="PaperPerformanceDescriptionForm" name="TeacherHireResearcherTableB">傑出論文績效說明表</a></td>
                </tr>
                <tr>
                    <td><a class="filledCheck" href="PaperPerformanceDescriptionUpload" name="PaperPerformanceDescriptionUpload">傑出論文績效說明表-上傳檔案</a></td>
                </tr>
                <tr>
                    <td><a href="PaperPerformanceDescriptionForm?table_c=1" name="TeacherHireResearcherTableC">傑出論文績效說明表(申請第二期以上者填寫)</a></td>
                </tr>
                <tr>
                    <td><a href="PaperPerformanceDescriptionUpload?table_c=1" name="TeacherHireResearcherTableCUpload">傑出論文績效說明表(申請第二期以上者填寫)-上傳檔案</a></td>
                </tr>
                <tr>
                    <td><a href="OtherFileUpload" name="OtherFileUpload">其他附件上傳</a></td>
                </tr>
                </tbody>
            </table>
            <p>
                <div style="text-align: center;" class="edit">
                    <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='RewardList'">
                    <input type="button" name="commit" value="提出申請" onclick="sendApply()">
                </div>
                <div style="text-align: center;" class="review">
                    <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='RewardPendingList'">
                    <input type="button" name="reject" value="退件" onclick="rejectApply()">
                    <input type="button" name="approve" value="審查完成" onclick="approveApply()">
                </div>
            </p>
        </form>
    </div>

    </body>
</html>