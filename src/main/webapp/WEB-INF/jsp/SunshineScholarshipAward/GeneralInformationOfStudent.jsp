<%--
  Created by IntelliJ IDEA.
  User: Ted Lin
  Date: 2021/1/22
  Time: 上午 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");
%>
<html>
<head>
    <title>陽光獎助金論文 學生基本資料表</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <link rel="stylesheet" type="text/css" href="/css/body.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<p style="text-align:center;font-weight:bold;font-size:20px;clear:none;">陽光獎助金論文 學生基本資料表</p>
<form method="post" action="Plan?func=international_formC001" enctype="multipart/form-data" id="c001_form">
    <table border="1" cellpadding="5" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
        <tbody>
        <!-- 大列1 -->
        <tr style="text-align: center;">
            <td rowspan="3" colspan="1" width="20%" style="font-size:22px"><strong>申請人姓名</strong></td>
            <td width="10%" style="text-align: left;">中文:&nbsp;<input id="chineseName" maxlength="40"></td>
        </tr>
        <tr style="text-align: left;">
            <td width="10%">英文:&nbsp;<input id="englishName" maxlength="40"></td>

        </tr>
        <tr style="text-align: left;">
            <td width="10%">身分證字號(ARC No.):&nbsp;<input id="nationalIDNumber" maxlength="40"></td>

        </tr>
        <!-- 大列2 -->
        <tr style="text-align: center;">
            <td rowspan="1" colspan="1" width="20%" style="font-size:22px"><strong>單位(系所):</strong></td>
            <td rowspan="1" colspan="0" width="38%" style="font-size:22px;text-align: left;"><input id="department" maxlength="40"></td>
        </tr>


        <!-- 大列3 -->
        <tr style="text-align: center;" id="FacultyTr">
            <td rowspan="1" colspan="1" width="20%" style="font-size:22px">
                <strong>學生類別</strong></td>
            <td rowspan="1" colspan="1" width="20%" style="font-size:13px;text-align: left;" id="FacultyTable">
                <select id="titles" size="1"  onchange="changeFunc();">
                    <option value="" selected>請選擇對應類別</option>
                    <option value="PHD">博士生</option>
                    <option value="Master">碩士生</option>
                    <option value="Bachelor">學士生</option>
                    <option value="Alumni">校友(畢業36個月內)</option>
                </select>
                <br>
                <span id="StaffInput">班級:&nbsp;<input id="levels"></span>
                <span id="ResignedMemberInput" style = "display : none ;">畢業年月(請填寫畢業證書上的畢業年月):&nbsp;<input id="ResignedTime" type="date"></span>
            </td>
        </tr>


        <!-- 大列4 -->
        <tr style="text-align: center;">
            <td rowspan="3" colspan="1" width="20%" style="font-size:22px"><strong>聯絡方式:</strong></td>
            <td rowspan="1" colspan="0" width="20%" style="text-align: left;">研究室分機:&nbsp;<input id="extensionNumber" maxlength="15"></td>
        </tr>
        <tr style="text-align: center;">
            <td rowspan="1" colspan="0" width="20%" style="text-align: left;">手機:&nbsp;<input id="cellphoneNumber" maxlength="15"></td>
        </tr>
        <tr style="text-align: center;">
            <td rowspan="1" colspan="0" width="20%" style="text-align: left;">E-mail:&nbsp;<input id="emailAddress" maxlength="40"></td>
        </tr>
        <tr>
        <td colspan="6" style="background-color:rgb(255, 255, 240);text-align: center">
            <button type="button" width="10%" onclick="javascript:location.href='SunshineScholarshipCatalog'">回上頁</button>
            <button type="button" width="10%" onclick="commit()">存檔</button>
        </td>
        </tr>
        </tbody>
    </table>
</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
    function commit(){
        $.ajax({
            type: 'POST',
            url: '/SelectInformation',
            dataType: 'text',
            data: JSON.stringify(InputToJson()),
            contentType: 'application/json',
            success: function(data){
                // alert(data.status);
                alert("存檔成功");
                window.location.href="SelectInformation";
            }
        });

    };

    function InputToJson(){
        var data = {};
        for (var j=0; j<document.getElementsByTagName("input").length; j++) {
            if (document.getElementsByTagName("input")[j].type=='checkbox' && document.getElementsByTagName("input")[j].checked == false){
                continue;
            }else {
                data[ document.getElementsByTagName("input")[j].id] = document.getElementsByTagName("input")[j].value;
            }

        }
        // console.log("inputdata is :", data);
        for (var j=0; j<document.getElementsByTagName("select").length; j++){
            data[ document.getElementsByTagName("select")[j].id] = document.getElementsByTagName("select")[j].value;
        }
        // console.log("data is :", data);
        return data;
    }

    $( document ).ready(function() {
        $("#chineseName").val("<%=json.optString("chinese_name","")%>");
        $("#englishName").val("<%=json.optString("english_name","")%>");
        $("#nationalIDNumber").val("<%=json.optString("national_ID_number","")%>");
        $("#department").val("<%=json.optString("department","")%>");
        $("#titles").val("<%=json.optString("titles","")%>");
        $("#titles").trigger("change");  //check if ResignedMember

        $("#levels").val("<%=json.optString("levels","")%>");
        $("#ResignedTime").val("<%=json.optString("resigned_time","")%>");
        $("#extensionNumber").val("<%=json.optString("extension_number","")%>");
        $("#cellphoneNumber").val("<%=json.optString("cellphone_number","")%>");
        $("#emailAddress").val("<%=json.optString("email_address","")%>");
    })

    function changeFunc() {
        var selectBox = document.getElementById("titles");
        var selectedValue = selectBox.options[selectBox.selectedIndex].value;
        console.log("changeFunc");
        if (selectedValue === "Alumni") {
            var result_style = document.getElementById("ResignedMemberInput").style;
            result_style.display = "block";
        } else {
            var result_style = document.getElementById("ResignedMemberInput").style;
            result_style.display = "none";
        }
    }



</script>

<style type="text/css">
    .innerinput{
        border-style:none;
        text-align: left;
        font-size:22px;
    }
</style>
