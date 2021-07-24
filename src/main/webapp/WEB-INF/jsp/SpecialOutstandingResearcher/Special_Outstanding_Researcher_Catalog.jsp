<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="com.google.gson.*" %>


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
<%--            <th style="width:20%;">完成度</th>--%>
        </tr>

        <tbody>
            <tr >
                <td ><a href="SpecialOutstandingResearcherApplicationForm">獎勵特殊優秀研究人才申請表</a></td>

            </tr>
            <tr>
                <td><a  href="OutstandingPerformanceDescriptionForm">特殊優秀研究人才傑出績效說明表</a></td>
            </tr>
            <tr >
                <td ><a  href="ReviewSupportingInformationForm" >審查佐證資料</a></td>

            </tr>
            <tr >
                <td><a  href="PaperPerformanceDescriptionForm" >論文績效說明表</a></td>

            </tr>
            <tr >
                <td ><a  href="PaperPerformanceDescriptionUpload" >論文績效說明表-上傳檔案</a></td>
            </tr>

            <tr >
                <td ><a  href="AwardDistributionAmountOrPrincipleForm" >獎勵特殊優秀研究人才獎勵金分配金額或原則表</a></td>
            </tr>

<%--            <tr>--%>
<%--                <td class="metadata" style="text-align: center; background-color: rgb(255, 255, 240)">--%>
<%--                    <button type="button" name="return_last_page" onclick="location.href='RewardList'">回上頁</button>--%>
<%--                    <button type="button" onclick="sendApply()">提出申請</button>--%>
<%--                </td>--%>
<%--            </tr>--%>

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
