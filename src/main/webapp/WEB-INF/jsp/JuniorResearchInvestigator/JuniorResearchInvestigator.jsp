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
                    <td rowspan="2" colspan="2">
                        <label for="department">服務系所</label>
                    </td>
                    <td rowspan="2" colspan="2">
                        <input id="department" maxlength="45">
                    </td>
                    <td colspan="2">
                        <label for="birth_date">出生日期</label>
                    </td>
                    <td colspan="2">
                        <input id="birth_date" type="date">
                </tr>
                <tr>
                    <td colspan="2">
                        <label for="identity_number">身份證字號</label>
                    </td>
                    <td colspan="2">
                        <input id="identity_number" name="identity_number" type="text" maxlength="10">
                    </td>
                </tr>
                <tr>
                    <td rowspan="2" colspan="2">
                        <label for="employment_date">本校任職日期</label>
                    </td>
                    <td rowspan="2" colspan="2">
                        <input id="employment_date" type="date">
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
                        <div style="float:right;">目前輸入字數:<span id="nowWords">0</span>/200</div>
                    </td>
                </tr>
                <tr>
                    <td colspan="8">
                        <textarea id="recommended_reason" type="text" onkeyup="wordsTotal()" rows="3" cols="8"></textarea>
                    </td>
                </tr>
            </tbody>
        </table>
        <p>※ 以上檢附之相關文件不全或不符規定者，不予受理。</p>
        <div class="footer">
            <button type="button" name="return_last_page" onclick="javascript:location.href='JuniorResearchInvestigatorCatalog'">回上頁</button>
            <button type="button" name="confirm" onclick="commit()">存檔</button>
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
            url: 'JuniorResearchInvestigator',
            dataType: 'json',
            data: JSON.stringify(InputToJson()),
            contentType: 'application/json',
            success: function(data){
                alert(data.status);
                window.location.href="JuniorResearchInvestigator";
            },
            error:function(data) {
                alert("存檔失敗");
            }
        });
    };
    function InputToJson(){
        let data = {};
        for (let j=0; j<document.getElementsByTagName("input").length; j++) {
            data[ document.getElementsByTagName("input")[j].id] = document.getElementsByTagName("input")[j].value;
        }
        data[ document.getElementById("recommended_reason").id] = document.getElementById("recommended_reason").value;
        return data;
    }
    $(document).ready(function () {
        $("#user_name").val("<%=jsonObject.optString("user_name", "")%>");
        $("#applicant_title").val("<%=jsonObject.optString("applicant_title", "")%>");
        $("#department").val("<%=jsonObject.optString("department", "")%>");
        $("#birth_date").val("<%=jsonObject.optString("birth_date", "")%>");
        $("#identity_number").val("<%=jsonObject.optString("identity_number", "")%>");
        $("#employment_date").val("<%=jsonObject.optString("employment_date", "")%>");
        $("#extension_number").val("<%=jsonObject.optString("extension_number", "")%>");
        $("#cellphone_number").val("<%=jsonObject.optString("cellphone_number", "")%>");
        $("#recommended_reason").val("<%=jsonObject.optString("recommended_reason", "")%>");
        wordsTotal();
    })
</script>
</html>