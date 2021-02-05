<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");
    String TeacherDescription = "";
    String DepartmentDescription = "";

    String[] applyTypeChecked = {"", "", ""};
    if (json.getString("applyType").equals("teacher")) {
        applyTypeChecked[1] = "checked";
        TeacherDescription = json.getString("applyTypeDescription");
    }else if (json.getString("applyType").equals("department")) {
        applyTypeChecked[2] = "checked";
        DepartmentDescription = json.getString("applyTypeDescription");
    }else {
        applyTypeChecked[0] = "checked";
    }

    String[] researcherTypeChecked = {"", ""};
    if (json.getString("researcherType").equals("postDoctoral")) {
        researcherTypeChecked[1] = "checked";
    }else {
        researcherTypeChecked[0] = "checked";
    }
%>
<%!
    private String getNowDate(){
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        return ft.format(date);
    }
%>
<html>
    <head>
        <title>國立臺北科技大學績優教師聘任研究人員申請表</title>
        <style>
            body {
                margin: 20px 0px 0px 0px;
                padding: 0;
                background: #FFFFCC;
                font-size: 20px;
                color: #3C3D3F;
                background-color: #E9F2FF;
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
            div.content{
                margin: 0 auto;
                padding: 50px;
                width: 1200px;
                background-color: white;
            }

        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            function commit(){
                $.ajax({
                    type: 'POST',
                    url: '/TeacherHireResearcherForm',
                    dataType: 'text',
                    data: JSON.stringify(InputToJson()),
                    contentType: 'application/json',
                    success: function(data){
                        alert('存檔成功');
                        window.location.href="/TeacherHireResearcherCatalog";
                    }
                });

            }

            function InputToJson(){
                var data = {};
                data["applyTypeDescription"] = "";

                for (var j=0; j<document.getElementsByTagName("input").length; j++) {
                    let inputElem = document.getElementsByTagName("input")[j];
                    if (inputElem.type!=="button" &&
                        (inputElem.type!=="radio" || (inputElem.type==="radio" && inputElem.checked))) {

                        if (inputElem.id==="applyTypeTeacher")
                            data["applyTypeDescription"] = document.getElementById("applyTypeTeacherDescription").value;
                        else if (inputElem.id==="applyTypeDepartment")
                            data["applyTypeDescription"] = document.getElementById("applyTypeDepartmentDescription").value;
                        data[inputElem.name] = inputElem.value;

                    }
                }

                for (var j=0; j<document.getElementsByTagName("textarea").length; j++) {
                    data[document.getElementsByTagName("textarea")[j].name] = document.getElementsByTagName("textarea")[j].value;
                }

                return data;
            }

            function changeTextVisible(option) {
                if(option === 'teacher'){
                    document.getElementById("applyTypeTeacherDescription").disabled=false;
                    document.getElementById("applyTypeDepartmentDescription").disabled=true;
                    document.getElementById("applyTypeDepartmentDescription").value="";
                }else if(option === 'department'){
                    document.getElementById("applyTypeTeacherDescription").disabled=true;
                    document.getElementById("applyTypeTeacherDescription").value="";
                    document.getElementById("applyTypeDepartmentDescription").disabled=false;
                }else {
                    document.getElementById("applyTypeTeacherDescription").disabled=true;
                    document.getElementById("applyTypeTeacherDescription").value="";
                    document.getElementById("applyTypeDepartmentDescription").disabled=true;
                    document.getElementById("applyTypeDepartmentDescription").value="";
                }

            }

            $(document).ready(function (){
                changeTextVisible(document.querySelector('input[name="applyType"]:checked').value);
            });
        </script>
    </head>
    <body>
        <div class="content">
            <p style="text-align:center;font-weight:bold;font-size:20px;">國立臺北科技大學奬助研究績優教師聘任研究人員申請表</p>
            <form>
                <table border="1" cellpadding="7" cellspacing="1" width="70%" align="center" style="border-spacing:0px;">
                    <tbody>
                        <tr>
                            <td class="metadata">
                                申請類別<font color="red">＊</font>
                            </td>
                            <td colspan="2">
                                <label>
                                    <input type="radio" name="applyType" id="applyTypeAlone" value="alone" onFocus="changeTextVisible('alone')" <%= applyTypeChecked[0]%>>
                                    單獨申請<br>
                                </label>
                                <label>
                                    <input type="radio" name="applyType" id="applyTypeTeacher" value="teacher" onFocus="changeTextVisible('teacher')" <%= applyTypeChecked[1]%>>
                                    共同申請教師姓名:
                                    <input name="applyTypeTeacherDescription" id="applyTypeTeacherDescription" value="<%= TeacherDescription%>" size="10" maxlength="40"><br>
                                </label>
                                <label>
                                    <input type="radio" name="applyType" id="applyTypeDepartment" value="department" onFocus="changeTextVisible('department')" <%= applyTypeChecked[2]%>>
                                    教學、研究、行政單位<br>
                                    單位名稱:<input name="applyTypeDepartmentDescription" id="applyTypeDepartmentDescription" value="<%= DepartmentDescription%>" size="10" maxlength="40">
                                </label>
                            </td>
                            <td class="metadata">
                                聘任研究人員類別<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <label><input type="radio" name="researcherType" value="teacher" <%= researcherTypeChecked[0]%>>研究型教師</label><br>
                                <label><input type="radio" name="researcherType" value="postDoctoral" <%= researcherTypeChecked[1]%>>博士後研究人員</label>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                申請人姓名<font color="red">＊</font><br>(英文姓名)
                            </td>
                            <td colspan="2">
                                <input name="applicantName" value="<%= json.get("applicantName")%>" size="10" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                職稱<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <input name="applicantJobTitle" value="<%= json.get("applicantJobTitle")%>" size="10" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                服務系所<font color="red">＊</font>
                            </td>
                            <td colspan="2">
                                <input name="applicantDepartment" value="<%= json.get("applicantDepartment")%>" size="20" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                E-mail<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <input name="applicantEmail" value="<%= json.get("applicantEmail")%>" size="30" maxlength="50">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                任職本校年資<font color="red">＊</font>
                            </td>
                            <td colspan="2">
                                <input name="applicantSeniority" value="<%= json.get("applicantSeniority")%>" size="20" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                聯絡電話<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                研究室分機:<input name="applicantResearchRoomExt" value="<%= json.get("applicantResearchRoomExt")%>" size="5" maxlength="40"><br>
                                手機:<input name="applicantPhone" value="<%= json.get("applicantPhone")%>" size="11" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" rowspan="3" class="metadata">
                                受聘人姓名<font color="red">＊</font><br>(研究人員)
                            </td>
                            <td colspan="2" rowspan="3">
                                <input name="researcherName" value="<%= json.get("researcherName")%>" size="10" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                出生日期<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <input type="date" name="researcherBirthDate" value="<%= json.get("researcherBirthDate")%>" max="<%=getNowDate()%>">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                身份證字號<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <input name="researcherIdNum" value="<%= json.get("researcherIdNum")%>" size="10" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                聯絡電話<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <input name="researcherPhone" value="<%= json.get("researcherPhone")%>" size="10" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                擬聘用職稱<font color="red">＊</font>
                            </td>
                            <td colspan="2">
                                <input name="researcherJobTitle" value="<%= json.get("researcherJobTitle")%>" size="20" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                擬聘用薪級(月)<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <input name="researcherSalaryScale" value="<%= json.get("researcherSalaryScale")%>" size="20" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" width="15%" class="metadata">
                                計畫類別<font color="red">＊</font><br>(主持人為研究人員)
                            </td>
                            <td colspan="1" width="20%">
                                <input name="projectCategory" value="<%= json.get("projectCategory")%>" size="10" maxlength="40">
                            </td>
                            <td colspan="1" width="10%" class="metadata">
                                計畫名稱<font color="red">*</font>
                            </td>
                            <td colspan="2" width="5%">
                                <input name="projectName" value="<%= json.get("projectName")%>" size="20" maxlength="40">
                            </td>
                            <td colspan="1" width="10%" class="metadata">
                                計畫金額<font color="red">*</font>
                            </td>
                            <td colspan="1" width="20%">
                                <input name="projectAmount" value="<%= json.get("projectAmount")%>" size="10" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                預期績效<font color="red">＊</font>
                            </td>
                            <td colspan="6">
                                近五年平均論文點數:
                                <input name="expectedPerformanceNearFiveYears" value="<%= json.get("expectedPerformanceNearFiveYears")%>" size="40" maxlength="50"><br>
                                預期每年論文點數:
                                <input name="expectedPerformancePerYears" value="<%= json.get("expectedPerformancePerYears")%>" size="40" maxlength="50"><br>
                                其它:
                                <input name="expectedPerformanceOthers" value="<%= json.get("expectedPerformanceOthers")%>" size="40" maxlength="50">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                申請補助項目<font color="red">＊</font><br>(含總補助金額)
                            </td>
                            <td colspan="6">
                                <textarea name="applyForSubsidies" rows="4" cols="50" required><%= json.get("applyForSubsidies")%></textarea>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <p align="center">
                    <input type="button" name="save" value="存檔" onclick="commit()">
                    <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='/TeacherHireResearcherCatalog'"  >
                </p>
            </form>
        </div>
    </body>
</html>