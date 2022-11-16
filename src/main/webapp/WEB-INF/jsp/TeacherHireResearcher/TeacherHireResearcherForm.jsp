<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");

    String[] researcherTypeChecked = {"", ""};
    if (json.getString("researcherType").equals("postDoctoral")) {
        researcherTypeChecked[1] = "checked";
    }else {
        researcherTypeChecked[0] = "checked";
    }
%>
<html>
    <head>
        <title>國立臺北科技大學獎助研究績優教師聘任研究人員申請表</title>
        <style>
            body {
                margin: 20px 0px 0px 0px;
                padding: 0;
                font-size: 20px;
                font: normal 16px Verdana;
                width: 100%;
            }
            table {
                color: black;
                width: 100%;
                border-width: thin;
                border-spacing: 0px;
                border-style: groove;
                border-color: gray;
                border-collapse: collapse;
                background-color: white;
                font: normal 13px Verdana;
            }
            table td{
                border-width: 1px;
                padding: 8px;
                border-style: groove;
                border-color: gray;
                -moz-border-radius: 0px 0px 0px 0px;
                height: 20px;
                vertical-align: text-middle;
            }
            table td.metadata{
                background-color: rgb(255, 255, 240);
                text-align: right;
            }
            table td.sign_metadata{
                background-color: rgb(255, 255, 240);
                text-align: center;
            }
            td > p{
                margin: 3rem 0 0;
                text-align: left;
                vertical-align: bottom;
            }
            div.content{
                margin: 0 auto;
                padding: 50px;
                width: 90%;
                background-color: white;
            }
            textarea {
                font: normal 13px Verdana;
            }
            .requiredField {
                color: red;
            }

        </style>
        <script src="js/jquery.min.js"></script>
        <script src="js/Function.js"></script>
        <script>
            function commit(){
                if ($("#applicantName").val() && $("#applicantDepartment").val() && $("#applicantEmail").val() && $("#applicantResearchRoomExt").val() && $("#applicantPhone").val() && ($("#expectedPerformanceNearFiveYears").val() || $("#expectedPerformancePerYears").val() || $("#expectedPerformanceOthers").val()) && $("#applyForSubsidies").val()) {
                    $.ajax({
                        type: 'POST',
                        url: 'TeacherHireResearcherForm',
                        dataType: 'text',
                        data: JSON.stringify(InputToJson()),
                        contentType: 'application/json',
                        success: function (data) {
                            alert('存檔成功');
                            window.location.href = "TeacherHireResearcherCatalog";
                        }
                    });
                }
                else {
                    alert("尚未填寫完成!");
                }
            }

            function InputToJson(){
                let data = {};
                let filledInputNum = 0;
                let totalInputNum = 0;

                for (let j=0; j<document.getElementsByTagName("input").length; j++) {
                    let inputElem = document.getElementsByTagName("input")[j];
                    if (inputElem.type!=="button" &&
                        (inputElem.type!=="radio" || (inputElem.type==="radio" && inputElem.checked))) {
                        data[inputElem.name] = inputElem.value;
                        if (inputElem.className.length === 0) {
                            if (inputElem.value.length > 0) {
                                filledInputNum++;
                            }
                            totalInputNum++;
                        }
                    }
                }

                for (let j=0; j<document.getElementsByTagName("textarea").length; j++) {
                    let inputElem = document.getElementsByTagName("textarea")[j];
                    data[inputElem.name] = inputElem.value;
                    if (inputElem.className.length === 0) {
                        if (inputElem.value.length > 0) {
                            filledInputNum++;
                        }
                        totalInputNum++;
                    }
                }

                data["fill_rate"] = filledInputNum / totalInputNum;
                return data;
            }

            function countWordsTotal() {
                const total = document.getElementById('applyForSubsidies').value.length;
                document.getElementById('wordsCount').innerHTML = total;
            }

            function setReviewData(){
                //department
                $("#departmentAcademicYear").val("<%=json.optString("departmentAcademicYear", "")%>");
                $("#departmentSemester").val("<%=json.optString("departmentSemester", "")%>");
                $("#departmentConferenceTimes").val("<%=json.optString("departmentConferenceTimes", "")%>");
                $("#departmentSignDate").val("<%=json.optString("departmentSignDate", "")%>");
                //college
                $("#collegeAcademicYear").val("<%=json.optString("collegeAcademicYear", "")%>");
                $("#collegeSemester").val("<%=json.optString("collegeSemester", "")%>");
                $("#collegeConferenceTimes").val("<%=json.optString("collegeConferenceTimes", "")%>");
                $("#collegeSignDate").val("<%=json.optString("collegeSignDate", "")%>");
                //researchAndDevelopmentOffice
                $("#researchAndDevelopmentOfficeSignYear").val("<%=json.optString("researchAndDevelopmentOfficeSignYear", "")%>");
                $("#researchAndDevelopmentOfficeSignMonth").val("<%=json.optString("researchAndDevelopmentOfficeSignMonth", "")%>");
                $("#researchAndDevelopmentOfficeSignDate").val("<%=json.optString("researchAndDevelopmentOfficeSignDate", "")%>");
            }

            $(document).ready(function (){
                countWordsTotal();
                $("#applyForSubsidies").on('change paste keyup', function(){
                    countWordsTotal();
                });

                let role = "${role}";
                if (role === "industryLiaisonOffice") {
                    $("#save").remove();
                }
                setReadOnly(${readonly});
                $(".${role}").removeAttr("readonly");
                $(".${role}").removeAttr("disabled");

                setReviewData();
            });
        </script>
    </head>
    <body>
        <div class="content">
            <p style="text-align:center;font-weight:bold;font-size:20px;">國立臺北科技大學獎助研究績優教師聘任研究人員申請表</p>
            <form>
                <table border="1" cellpadding="7" cellspacing="1" align="center" style="border-spacing:0px;">
                    <tbody>
                        <tr>
                            <td colspan="1" class="metadata">
                                <span class="requiredField">✱</span>申請人姓名<br>(英文姓名)
                            </td>
                            <td colspan="2">
                                <input id="applicantName" name="applicantName" value="<%= json.get("applicantName")%>" size="10" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                職稱
                            </td>
                            <td colspan="3">
                                <input name="applicantJobTitle" value="<%= json.get("applicantJobTitle")%>" size="10" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                <span class="requiredField">✱</span>服務系所
                            </td>
                            <td colspan="2">
                                <input id="applicantDepartment" name="applicantDepartment" value="<%= json.get("applicantDepartment")%>" size="20" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                <span class="requiredField">✱</span>E-mail
                            </td>
                            <td colspan="3">
                                <input id="applicantEmail" name="applicantEmail" value="<%= json.get("applicantEmail")%>" size="30" maxlength="50">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                任職本校年資
                            </td>
                            <td colspan="2">
                                <input name="applicantSeniority" value="<%= json.get("applicantSeniority")%>" size="20" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                <span class="requiredField">✱</span>聯絡電話
                            </td>
                            <td colspan="3">
                                研究室分機:<input id="applicantResearchRoomExt" name="applicantResearchRoomExt" value="<%= json.get("applicantResearchRoomExt")%>" size="5" maxlength="40"><br>
                                手機:<input id="applicantPhone" name="applicantPhone" value="<%= json.get("applicantPhone")%>" size="11" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                <span class="requiredField">✱</span>聘任研究人員類別
                            </td>
                            <td colspan="2">
                                <label><input type="radio" name="researcherType" value="teacher" <%= researcherTypeChecked[0]%>>研究型教師</label><br>
                                <label><input type="radio" name="researcherType" value="postDoctoral" <%= researcherTypeChecked[1]%>>博士後研究人員</label>
                            </td>
                            <td colspan="1" class="metadata">
                                受聘人姓名<br>(研究人員)
                            </td>
                            <td colspan="3">
                                <input name="researcherName" value="<%= json.get("researcherName")%>" size="10" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                擬聘用職稱
                            </td>
                            <td colspan="2">
                                <input name="researcherJobTitle" value="<%= json.get("researcherJobTitle")%>" size="20" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                擬聘用薪級(月)
                            </td>
                            <td colspan="3">
                                <input name="researcherSalaryScale" value="<%= json.get("researcherSalaryScale")%>" size="20" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" width="15%" class="metadata">
                                計畫類別<br>(主持人為研究人員)
                            </td>
                            <td colspan="1" width="20%">
                                <input name="projectCategory" value="<%= json.get("projectCategory")%>" size="10" maxlength="40">
                            </td>
                            <td colspan="1" width="10%" class="metadata">
                                計畫名稱
                            </td>
                            <td colspan="2" width="5%">
                                <input name="projectName" value="<%= json.get("projectName")%>" size="15" maxlength="40">
                            </td>
                            <td colspan="1" width="10%" class="metadata">
                                計畫金額
                            </td>
                            <td colspan="1" width="20%">
                                <input name="projectAmount" value="<%= json.get("projectAmount")%>" size="10" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                <span class="requiredField">✱</span>預期績效
                            </td>
                            <td colspan="6">
                                近五年平均論文點數:
                                <input id="expectedPerformanceNearFiveYears" name="expectedPerformanceNearFiveYears" value="<%= json.get("expectedPerformanceNearFiveYears")%>" size="40" maxlength="50"><br>
                                預期每年論文點數:
                                <input id="expectedPerformancePerYears" name="expectedPerformancePerYears" value="<%= json.get("expectedPerformancePerYears")%>" size="40" maxlength="50"><br>
                                其它(分列執行第一期、第二期…之論文總點數/平均點數，如C表):
                                <input id="expectedPerformanceOthers" name="expectedPerformanceOthers" value="<%= json.get("expectedPerformanceOthers")%>" size="60" maxlength="50">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                <span class="requiredField">✱</span>申請補助項目<br>(人事費)
                            </td>
                            <td colspan="6">
                                <textarea id="applyForSubsidies" name="applyForSubsidies" rows="8" cols="60" maxlength="500" required><%= json.get("applyForSubsidies")%></textarea>
                                <div style="float:right;">目前輸入字數:<span id="wordsCount">0</span>/500</div>
                            </td>
                        </tr>
<%--                        備註:請依研究人員實際年資填寫，若無則依本校規定辦理。--%>
                        <tr>
                            <td colspan="1" class="metadata">
                                備註
                            </td>
                            <td colspan="6">
                                請依研究人員實際年資填寫，若無則依本校規定辦理。
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3" class="sign_metadata">
                                <label>推 薦 單 位 主 管</label>
                            </td>
                            <td colspan="4" class="sign_metadata">
                                <label>學 院 院 長</label>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <p class="department">
                                    本推薦案業經 <input id="departmentAcademicYear" name="departmentAcademicYear" class="department" maxlength="3" style="width: 4ch;" disabled/> 學年度第 <input id="departmentSemester" name="departmentSemester" class="department" maxlength="1" style="width: 3ch;" disabled/> 學期<br>
                                    第 <input id="departmentConferenceTimes" name="departmentConferenceTimes" class="department" maxlength="5" style="width: 5ch;" disabled/> 次 系&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;會議審議通過<br>
                                    （<input id="departmentSignDate" name="departmentSignDate" class="department" type="date" style="width: auto;" disabled>）
                                </p>
                            </td>
                            <td colspan="4">
                                <p class="college">
                                    本推薦案業經 <input id="collegeAcademicYear" name="collegeAcademicYear" class="college" maxlength="3" style="width: 4ch;" disabled/> 學年度第 <input id="collegeSemester" name="collegeSemester" class="college" maxlength="1" style="width: 3ch;" disabled/> 學期<br>
                                    第 <input id="collegeConferenceTimes" name="collegeConferenceTimes" class="college" maxlength="5" style="width: 5ch;" disabled/> 次 院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;會議審議通過<br>
                                    （<input id="collegeSignDate" name="collegeSignDate" type="date" class="college" style="width: auto;" disabled>）
                                </p>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                <label>研發處</label>
                            </td>
                            <td colspan="6">
                                <p class="researchAndDevelopmentOffice" style="text-align: center;">
                                    中 華 民 國
                                    <input id="researchAndDevelopmentOfficeSignYear" name="researchAndDevelopmentOfficeSignYear" class="researchAndDevelopmentOffice" maxlength="3" style="width: 4ch;" disabled>年
                                    <input id="researchAndDevelopmentOfficeSignMonth" name="researchAndDevelopmentOfficeSignMonth" class="researchAndDevelopmentOffice" maxlength="2" style="width: 3ch;" disabled>月
                                    <input id="researchAndDevelopmentOfficeSignDate" name="researchAndDevelopmentOfficeSignDate" class="researchAndDevelopmentOffice" maxlength="2" style="width: 3ch;" disabled>日
                                </p>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <p align="center">
                    <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='TeacherHireResearcherCatalog'">
                    <input type="button" id="save" name="save" value="暫存" onclick="commit()"/>
                </p>
            </form>
        </div>
    </body>
</html>