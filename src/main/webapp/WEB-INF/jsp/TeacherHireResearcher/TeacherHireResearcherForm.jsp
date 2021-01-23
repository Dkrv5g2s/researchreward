<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%!
private String getNowDate(){
    Date date = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
    return ft.format(date);
}
%>
<html>
    <head>
        <title>國立臺北科技大學特聘教授申請表</title>
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
            table td.cb{
                width: 1%;
            }
            table td.checkboxcontent{
                width: 500px;
                background-color: rgb(255, 255, 240);
                text-align: left;
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
                    dataType: 'json',
                    data: JSON.stringify(InputToJson()),
                    contentType: 'application/json',
                    success: function(data){
                        alert('success');
                    }
                });

            }

            function InputToJson(){
                var data = {};

                for (var j=0; j<document.getElementsByTagName("input").length; j++) {
                    let inputElem = document.getElementsByTagName("input")[j];
                    if (inputElem.type!=="button" &&
                        (inputElem.type!=="radio" || (inputElem.type==="radio" && inputElem.checked))) {

                        if (inputElem.name==="applyType" && inputElem.value==="teacher")
                            data["applyTypeDescription"] = document.getElementsByName("applyTypeTeacherDescription")[0].value;
                        else if (inputElem.name==="applyType" && inputElem.value==="department")
                            data["applyTypeDescription"] = document.getElementsByName("applyTypeDepartmentDescription")[0].value;
                        data[inputElem.name] = inputElem.value;

                    }
                }

                for (var j=0; j<document.getElementsByTagName("textarea").length; j++) {
                    data[document.getElementsByTagName("textarea")[j].name] = document.getElementsByTagName("textarea")[j].value;
                }

                return data;
            }

            // function changeApplyType() {
            //     if(document.applyType[0].checked){
            //         document.applyTypeDescription1.style.display='none';
            //         document.applyTypeDescription2.style.display='none';
            //     }else{
            //         document.applyTypeDescription1.style.display='';
            //         document.applyTypeDescription2.style.display='';
            //     }
            //
            // }
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
                                    <input type="radio" name="applyType" value="alone" onFocus="changeApplyType()" checked>
                                    單獨申請<br>
                                </label>
                                <label>
                                    <input type="radio" name="applyType" value="teacher" onFocus="changeApplyType()">
                                    共同申請教師姓名:
                                    <input name="applyTypeTeacherDescription" value="" size="10" maxlength="40"><br>
                                </label>
                                <label>
                                    <input type="radio" name="applyType" value="department" onFocus="changeApplyType()">
                                    教學、研究、行政單位<br>
                                    單位名稱:<input name="applyTypeDepartmentDescription" value="" size="10" maxlength="40">
                                </label>
                            </td>
                            <td class="metadata">
                                聘任研究人員類別<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <label><input type="radio" name="researcherType" value="teacher">研究型教師</label><br>
                                <label><input type="radio" name="researcherType" value="postDoctoral">博士後研究人員</label>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                申請人姓名<font color="red">＊</font><br>(英文姓名)
                            </td>
                            <td colspan="2">
                                <input name="applicantName" value="" size="10" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                職稱<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <input name="applicantJobTitle" value="" size="10" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                服務系所<font color="red">＊</font>
                            </td>
                            <td colspan="2">
                                <input name="applicantDepartment" value="" size="20" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                E-mail<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <input name="applicantEmail" value="" size="30" maxlength="50">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                任職本校年資<font color="red">＊</font>
                            </td>
                            <td colspan="2">
                                <input name="applicantSeniority" value="" size="20" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                聯絡電話<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                研究室分機:<input name="applicantResearchRoomExt" value="" size="5" maxlength="40"><br>
                                手機:<input name="applicantPhone" value="" size="11" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" rowspan="3" class="metadata">
                                受聘人姓名<font color="red">＊</font><br>(研究人員)
                            </td>
                            <td colspan="2" rowspan="3">
                                <input name="researcherName" value="" size="10" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                出生日期<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <input type="date" name="researcherBirthDate" max="<%=getNowDate()%>">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                身份證字號<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <input name="researcherIdNum" value="" size="10" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                聯絡電話<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <input name="researcherPhone" value="" size="10" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                擬聘用職稱<font color="red">＊</font>
                            </td>
                            <td colspan="2">
                                <input name="researcherJobTitle" value="" size="20" maxlength="40">
                            </td>
                            <td colspan="1" class="metadata">
                                擬聘用薪級(月)<font color="red">*</font>
                            </td>
                            <td colspan="3">
                                <input name="researcherSalaryScale" value="" size="20" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" width="15%" class="metadata">
                                計畫類別<font color="red">＊</font><br>(主持人為研究人員)
                            </td>
                            <td colspan="1" width="20%">
                                <input name="projectCategory" value="" size="10" maxlength="40">
                            </td>
                            <td colspan="1" width="10%" class="metadata">
                                計畫名稱<font color="red">*</font>
                            </td>
                            <td colspan="2" width="5%">
                                <input name="projectName" value="" size="20" maxlength="40">
                            </td>
                            <td colspan="1" width="10%" class="metadata">
                                計畫金額<font color="red">*</font>
                            </td>
                            <td colspan="1" width="20%">
                                <input name="projectAmount" value="" size="10" maxlength="40">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                預期績效<font color="red">＊</font>
                            </td>
                            <td colspan="6">
                                近五年平均論文點數:
                                <input name="expectedPerformanceNearFiveYears" value="" size="40" maxlength="50"><br>
                                預期每年論文點數:
                                <input name="expectedPerformancePerYears" value="" size="40" maxlength="50"><br>
                                其它:
                                <input name="expectedPerformanceOthers" value="" size="40" maxlength="50">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1" class="metadata">
                                申請補助項目<font color="red">＊</font><br>(含總補助金額)
                            </td>
                            <td colspan="6">
                                <textarea name="applyForSubsidies" rows="4" cols="50" required></textarea>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <p align="center"><input type="button" name="save" value="存檔" onclick="commit()"></p>
            </form>
        </div>
    </body>
</html>