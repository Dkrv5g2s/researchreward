<!DOCTYPE HTML>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject jsonObject = (JSONObject) request.getAttribute("data");
%>
<html lang="zh">
<head>
    <title>國立臺北科技大學年輕學者研究獎 推薦申請表</title>

    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <style type="text/css">
        table{
            table-layout: fixed;
        }
        tr{
            text-align:center;
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
        .footer{
            text-align-last: center;
            margin: 1rem;
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
                    <td colspan="8">
                        <label id="recommended_reason" type="text" style="word-break: break-all;"></label>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <label for="department_conference">推 薦 單 位 主 管</label>
                    </td>
                    <td colspan="4">
                        <label for="college_conference">學 院 院 長</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <p>
                            本推薦案業經 <input id="department_academic_year" maxlength="3"/> 學年度第 <input id="department_semester" maxlength="1"/> 學期<br>
                            第 <input id="department_conference_times" maxlength="5"/> 次 系<input id="department_conference" maxlength="13" style="width: 15ch;"/>會議審議通過<br>
                            （<input id="department_sign_date" type="date" style="width: auto;">）
                        </p>
                    </td>
                    <td colspan="4">
                        <p>
                            本推薦案業經 <input id="college_academic_year" maxlength="3"/> 學年度第 <input id="college_semester" maxlength="1"/> 學期<br>
                            第 <input id="college_conference_times" maxlength="5"/> 次 院 <input id="college_conference" maxlength="13" style="width: 15ch;"/> 會議審議通過<br>
                            （<input id="college_sign_date" type="date" style="width: auto;">）
                        </p>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label>研發處</label>
                    </td>
                    <td colspan="6">
                        <p style="text-align: center;">
                            中 華 民 國 <input id="research_and_development_office_sign_year" maxlength="3" style="width: 3ch;">
                            年<input id="research_and_development_office_sign_month" maxlength="2" style="width: 3ch;">
                            月<input id="research_and_development_office_sign_date" maxlength="2" style="width: 3ch;">日
                        </p>
                    </td>
                </tr>
            </tbody>
        </table>
        <p>※ 以上檢附之相關文件不全或不符規定者，不予受理。</p>
        <div class="footer">
            <button type="button" name="return_last_page" onclick="location.href='JuniorResearchInvestigatorCatalog'">回目錄</button>
            <button type="button" name="confirm" onclick="location.href='JuniorResearchInvestigatorReviewInformation'">此頁審查完成</button>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#user_name").html("<%=jsonObject.optString("user_name", "")%>");
        $("#applicant_title").html("<%=jsonObject.optString("applicant_title", "")%>");
        $("#department").html("<%=jsonObject.optString("department", "")%>");
        $("#birth_date").html("<%=jsonObject.optString("birth_date", "")%>");
        $("#identity_number").html("<%=jsonObject.optString("identity_number", "")%>");
        $("#employment_date").html("<%=jsonObject.optString("employment_date", "")%>");
        $("#extension_number").html("<%=jsonObject.optString("extension_number", "")%>");
        $("#cellphone_number").html("<%=jsonObject.optString("cellphone_number", "")%>");
        $("#recommended_reason").html("<%=jsonObject.optString("recommended_reason", "")%>");
    })
</script>
</html>