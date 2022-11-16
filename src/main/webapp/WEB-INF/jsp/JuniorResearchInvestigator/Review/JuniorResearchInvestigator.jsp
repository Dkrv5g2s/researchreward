<!DOCTYPE HTML>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject jsonObject = (JSONObject) request.getAttribute("data");
%>
<html lang="zh">
<head>
    <title>國立臺北科技大學年輕學者研究獎 推薦申請表</title>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
    <link rel="stylesheet" type="text/css" href="css/PrintPageStyle.css">
    <script src="lib/jquery.min.js"></script>

    <style type="text/css">
        table{
            /*table-layout: fixed;*/
        }
        tr{
            text-align:center;
        }
        .title{
            background:#C0C0C0;
        }
        td > p{
            margin: 3rem 0 0;
            text-align: left;
            vertical-align: bottom;
        }
        td > input{
            border-style: initial;
            readonly: readonly;
        }
    </style>

</head>
<body>
<div class="content">
    <form method="post" id="form">
        <table id="juniorResearchInvestigator">
            <thead>
            <tr>
                <th colspan="8" class="file_title">國立臺北科技大學年輕學者研究獎 推薦申請表</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td colspan="2">
                        <label for="user_name">申請人姓名<br>(英文姓名)</label>
                    </td>
                    <td colspan="2">
                        <label id="user_name" maxlength="45"></label>
                    </td>
                    <td colspan="2">
                        <label for="applicant_title">職稱</label>
                    </td>
                    <td colspan="2">
                        <label id="applicant_title" maxlength="45"></label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label for="department">服務系所</label>
                    </td>
                    <td colspan="2">
                        <label id="department" maxlength="45"></label>
                    </td>
                    <td rowspan="2">聯絡電話</td>
                    <td>
                        <label for="extension_number">研究室分機</label>
                    </td>
                    <td colspan="2">
                        <label type="text" id="extension_number" maxlength="10"></label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label for="employment_date">本校任職日期</label>
                    </td>
                    <td colspan="2">
                        <label id="employment_date" type="date"></label>
                    </td>
                    <td>
                        <label for="cellphone_number">手機</label>
                    </td>
                    <td colspan="2">
                        <label type="text" id="cellphone_number" maxlength="10"></label>
                    </td>
                </tr>
                <tr>
                    <td colspan="8" class="title">
                        <label for="recommended_reason">推&nbsp;薦&nbsp;理&nbsp;由</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="8" rowspn="3">
                        <label id="recommended_reason" type="text" style="word-break: break-all;"></label>
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
                        <p>
                            本推薦案業經 <input id="department_academic_year" class="department" maxlength="3" style="width: 3ch;"/> 學年度第 <input id="department_semester" class="department" maxlength="1" style="width: 3ch;"/> 學期<br>
                            第 <input id="department_conference_times" class="department" maxlength="5" style="width: 5ch;"/> 次 系&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;會議審議通過<br>
                            （<input id="department_sign_date" class="department" type="date" style="width: auto;">）
                        </p>
                    </td>
                    <td colspan="4">
                        <p class="college">
                            本推薦案業經 <input id="college_academic_year" class="college" maxlength="3" style="width: 3ch;"/> 學年度第 <input id="college_semester" class="college" maxlength="1" style="width: 3ch;"/> 學期<br>
                            第 <input id="college_conference_times" class="college" maxlength="5" style="width: 5ch;"/> 次 院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;會議審議通過<br>
                            （<input id="college_sign_date" type="date" class="college" style="width: auto;">）
                        </p>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label>研發處</label>
                    </td>
                    <td colspan="6">
                        <p style="text-align: center;">
                            中 華 民 國
                            <input id="research_and_development_office_sign_year" class="researchAndDevelopmentOffice" maxlength="3" style="width: 3ch;">年
                            <input id="research_and_development_office_sign_month" class="researchAndDevelopmentOffice" maxlength="2" style="width: 3ch;">月
                            <input id="research_and_development_office_sign_date" class="researchAndDevelopmentOffice" maxlength="2" style="width: 3ch;">日
                        </p>
                    </td>
                </tr>
            </tbody>
        </table>
        <p>※ 以上檢附之相關文件不全或不符規定者，不予受理。</p>
        <div class="footer">
            <button type="button" name="go_to_catalog" onclick="location.href='JuniorResearchInvestigatorCatalog'">回目錄</button>
            <button type="button" name="confirm" onclick="reviewed()">此頁審查完成</button>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        setUserData();
        setReviewData();
        $("input").attr("disabled", "disabled");
        $(".${role}").removeAttr("disabled");
    })

    function setUserData(){
        $("#user_name").html("<%=jsonObject.optString("user_name", "")%>");
        $("#applicant_title").html("<%=jsonObject.optString("applicant_title", "")%>");
        $("#department").html("<%=jsonObject.optString("department", "")%>");
        $("#employment_date").html("<%=jsonObject.optString("employment_date", "")%>");
        $("#extension_number").html("<%=jsonObject.optString("extension_number", "")%>");
        $("#cellphone_number").html("<%=jsonObject.optString("cellphone_number", "")%>");
        $("#recommended_reason").html("<%=jsonObject.optString("recommended_reason", "")%>");
    }

    function setReviewData(){
        //department
        $("#department_academic_year").val("<%=jsonObject.optString("department_academic_year", "")%>");
        $("#department_semester").val("<%=jsonObject.optString("department_semester", "")%>");
        $("#department_conference_times").val("<%=jsonObject.optString("department_conference_times", "")%>");
        $("#department_sign_date").val("<%=jsonObject.optString("department_sign_date", "")%>");
        //college
        $("#college_academic_year").val("<%=jsonObject.optString("college_academic_year", "")%>");
        $("#college_semester").val("<%=jsonObject.optString("college_semester", "")%>");
        $("#college_conference_times").val("<%=jsonObject.optString("college_conference_times", "")%>");
        $("#college_sign_date").val("<%=jsonObject.optString("college_sign_date", "")%>");
        //researchAndDevelopmentOffice
        $("#research_and_development_office_sign_year").val("<%=jsonObject.optString("research_and_development_office_sign_year", "")%>");
        $("#research_and_development_office_sign_month").val("<%=jsonObject.optString("research_and_development_office_sign_month", "")%>");
        $("#research_and_development_office_sign_date").val("<%=jsonObject.optString("research_and_development_office_sign_date", "")%>");
    }
    function reviewed(){
        if("${role}" === "department" || "${role}" === "college" || "${role}" === "researchAndDevelopmentOffice"){
            let data = {};
            let input_data = document.getElementsByClassName("${role}");
            for (let i=0; i<input_data.length; i++){
                data[input_data[i].id] = input_data[i].value;
            }
            commit(data);
        }
        else{
            location.href="JuniorResearchInvestigatorReviewInformation";
        }
    }

    function commit(input_data){
        $.ajax({
            type: 'POST',
            url: 'JuniorResearchInvestigator',
            dataType: 'json',
            data: JSON.stringify(input_data),
            success: function(data){
                alert(data.status);
                location.href="JuniorResearchInvestigatorReviewInformation";
            },
            error:function(data) {
                alert("存檔失敗");
            }
        });
    };
</script>
</html>