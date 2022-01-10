<!DOCTYPE HTML>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject jsonObject = (JSONObject) request.getAttribute("data");
%>
<html lang="zh">
<head>
    <title>國立臺北科技大學傑出研究獎 推薦申請表</title>

    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <style type="text/css">
        table{
            table-layout: fixed;
        }
        tr{
            text-align:center;
        }
        input {
            height: 100%;
            width: 100%;
            border-style: initial;
        }
        .file_title{
            padding-bottom: 1rem;
            font-size:20px;
            border-top: hidden;
            border-left: hidden;
            border-right: hidden;
        }
        .title{
            background:#C0C0C0;
        }
        td > p{
            margin: 3rem 0 0;
            text-align: left;
            vertical-align: bottom;
        }
        td > p > input{
            height: auto;
            width: 3ch;
        }
        .footer{
            text-align-last: center;
            margin: 1rem;
        }
    </style>

</head>
<body>
<div class="content">
    <form method="post" id="form">
        <table id="OutstandingResearchAward">
            <thead>
            <tr>
                <th colspan="8" class="file_title">國立臺北科技大學傑出研究獎 推薦申請表</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td colspan="2">
                    <label for="user_name">申請人姓名<br>(英文姓名)</label>
                </td>
                <td colspan="2">
                    <input id="user_name" maxlength="45">
                </td>
                <td colspan="2">
                    <label for="applicant_title">職稱</label>
                </td>
                <td colspan="2">
                    <input id="applicant_title" maxlength="45">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label for="department">服務系所</label>
                </td>
                <td colspan="2">
                    <input id="department" maxlength="45">
                </td>
                <td rowspan="2">聯絡電話</td>
                <td>
                    <label for="extension_number">研究室分機</label>
                </td>
                <td colspan="2">
                    <input type="text" id="extension_number" maxlength="10">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label for="employment_date">本校任職日期</label>
                </td>
                <td colspan="2">
                    <input id="employment_date" type="date">
                </td>
                <td>
                    <label for="cellphone_number">手機</label>
                </td>
                <td colspan="2">
                    <input type="text" id="cellphone_number" maxlength="10">
                </td>
            </tr>
            <tr>
                <td colspan="8" class="title">
                    <label for="recommended_reason">推&nbsp;薦&nbsp;理&nbsp;由</label>
                    <div style="float:right;">目前輸入字數:<span id="nowWords">0</span>/500</div>
                </td>
            </tr>
            <tr>
                <td colspan="8">
                    <textarea id="recommended_reason" type="text" onkeyup="wordsTotal()" rows="3" cols="8" maxlength="500"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <label>推 薦 單 位 主 管</label>
                </td>
                <td colspan="4">
                    <label>學 院 院 長</label>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <p class="department">
                        本推薦案業經 <label id="department_academic_year">&nbsp;&nbsp;&nbsp; </label> 學年度第 <label id="department_semester">&nbsp;&nbsp;&nbsp;</label> 學期<br>
                        第 <label id="department_conference_times">&nbsp;&nbsp;&nbsp;</label> 次 系<label id="department_conference">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>會議審議通過<br>
                        （<input id="department_sign_date" type="date" style="width: auto;" class="department" disabled>）
                    </p>
                </td>
                <td colspan="4">
                    <p class="college">
                        本推薦案業經 <label id="college_academic_year">&nbsp;&nbsp;&nbsp; </label> 學年度第 <label id="college_semester">&nbsp;&nbsp;&nbsp;</label> 學期<br>
                        第 <label id="college_conference_times">&nbsp;&nbsp;&nbsp;</label> 次 院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;會議審議通過<br>
                        （<input id="college_sign_date" type="date" style="width: auto;" class="department" disabled>）
                    </p>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label>研發處</label>
                </td>
                <td colspan="6">
                    <p class="researchAndDevelopmentOffice" style="text-align: center;">
                        中 華 民 國
                        <label id="research_and_development_office_sign_year"></label>年
                        <label id="research_and_development_office_sign_month"></label>月
                        <label id="research_and_development_office_sign_date"></label>日
                    </p>
                </td>
            </tr>
            </tbody>
        </table>
        <p>※ 以上檢附之相關文件不全或不符規定者，不予受理。</p>
        <div class="footer">
            <button type="button" name="return_last_page" onclick="javascript:location.href='OutstandingResearchAwardCatalog'">回上頁</button>
            <button type="button" name="confirm" onclick="commit()">暫存</button>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    function wordsTotal() {
        const total = document.getElementById('recommended_reason').value.length;
        document.getElementById('nowWords').innerHTML = total;
    }

    function commit(){
        $.ajax({
            type: 'POST',
            url: 'OutstandingResearchAward',
            dataType: 'json',
            data: JSON.stringify(InputToJson()),
            // contentType: 'application/json',
            success: function(data){
                alert(data.status);
                window.location.href="OutstandingResearchAward";
            },
            error:function(data,status,er) {
                alert("存檔失敗");
            }
        });
    };

    function InputToJson(){
        let data = {};
        let dataNumber = 0;
        const inputList = document.getElementsByTagName("input");
        for (let j=0; j<inputList.length; j++) {
            data[ inputList[j].id] = inputList[j].value;
            if(inputList[j].value.length > 0 && inputList[j].className.length === 0){
                dataNumber++;
            }
        }
        data[ document.getElementById("recommended_reason").id] = document.getElementById("recommended_reason").value;
        const textareaList = document.getElementsByTagName("textarea");
        for (let j=0; j<textareaList.length; j++) {
            data[ textareaList[j].id] = textareaList[j].value;
            if(textareaList[j].value.length > 0 && inputList[j].className.length === 0){
                dataNumber++;
            }
        }
        data["fill_rate"] = dataNumber/(inputList.length + textareaList.length - 2);  //審核input不列入計算-2
        return data;
    }

    function setUserData(){
        $("#user_name").val("<%=jsonObject.optString("user_name", "")%>");
        $("#applicant_title").val("<%=jsonObject.optString("applicant_title", "")%>");
        $("#department").val("<%=jsonObject.optString("department", "")%>");
        $("#birth_date").val("<%=jsonObject.optString("birth_date", "")%>");
        $("#identity_number").val("<%=jsonObject.optString("identity_number", "")%>");
        $("#employment_date").val("<%=jsonObject.optString("employment_date", "")%>");
        $("#extension_number").val("<%=jsonObject.optString("extension_number", "")%>");
        $("#cellphone_number").val("<%=jsonObject.optString("cellphone_number", "")%>");
        $("#recommended_reason").val("<%=jsonObject.optString("recommended_reason", "")%>");
    }
    function setReviewData(){
        //department
        $("#department_academic_year").html("<%=jsonObject.optString("department_academic_year", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")%>");
        $("#department_semester").html("<%=jsonObject.optString("department_semester", "&nbsp;&nbsp;&nbsp;")%>");
        $("#department_conference_times").html("<%=jsonObject.optString("department_conference_times", "&nbsp;&nbsp;&nbsp;")%>");
        $("#department_conference").html("<%=jsonObject.optString("department_conference", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")%>");
        $("#department_sign_date").val("<%=jsonObject.optString("department_sign_date", "")%>");
        //college
        $("#college_academic_year").html("<%=jsonObject.optString("college_academic_year", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")%>");
        $("#college_semester").html("<%=jsonObject.optString("college_semester", "&nbsp;&nbsp;&nbsp;")%>");
        $("#college_conference_times").html("<%=jsonObject.optString("college_conference_times", "&nbsp;&nbsp;&nbsp;")%>");
        $("#college_conference").html("<%=jsonObject.optString("college_conference", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")%>");
        $("#college_sign_date").val("<%=jsonObject.optString("college_sign_date", "")%>");
        //researchAndDevelopmentOffice
        $("#research_and_development_office_sign_year").html("<%=jsonObject.optString("research_and_development_office_sign_year", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")%>");
        $("#research_and_development_office_sign_month").html("<%=jsonObject.optString("research_and_development_office_sign_month", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")%>");
        $("#research_and_development_office_sign_date").html("<%=jsonObject.optString("research_and_development_office_sign_date", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")%>");
    }
    $(document).ready(function () {
        setUserData();
        setReviewData();
        wordsTotal();
    })
</script>
</html>