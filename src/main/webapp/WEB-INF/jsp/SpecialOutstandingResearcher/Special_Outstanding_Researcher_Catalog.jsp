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
                <td><a  href="OutstandingPerformanceDescriptionForm">表A 特殊優秀研究人才傑出績效說明表</a></td>
            </tr>
            <tr >
                <td ><a  href="ReviewSupportingInformationForm" >審查佐證資料</a></td>

            </tr>
            <tr >
                <td><a  href="PaperPerformanceDescriptionForm" >表B 論文績效說明表</a></td>

            </tr>
            <tr >
                <td ><a  href="PaperPerformanceDescriptionUpload" >表B 論文績效說明表-上傳檔案</a></td>
            </tr>
            <tr><td class="metadata" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">提出申請</button></td></tr>
        </tbody>

    </table>

</div>

</html>
