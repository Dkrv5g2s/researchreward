<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");
%>
<html>
<head>
    <title>國立臺北科技大學特聘教授申請表</title>
    <style>
        body {
            margin: 20px 0px 0px 0px;
            padding: 0;
            /*background: #FFFFCC;*/
            font-size: 20px;
            color: #3C3D3F;
            /*background-color: #E9F2FF;*/
            font: normal 16px Verdana;
            /*width: 100%;*/
        }
        table {
            table-layout: fixed;
            color: black;
            width: 100%;
            /*border-width: thin;*/
            /*border-spacing: 0px;*/
            border-style: groove;
            /*border-color: gray;*/
            border-collapse: collapse;
            /*background-color: white;*/
            font: normal 13px Verdana;
        }
        table tr{
            text-align:center;
        }
        table td{
            border-width: 1px;
            padding: 8px;
            border-style: groove;
            border-color: gray;
            -moz-border-radius: 0px 0px 0px 0px;
            height: 20px;
            vertical-align: middle;
        }
        table td.metadata{
            background-color: rgb(255, 255, 240);
            text-align: right;
        }
        table td.cb{
            /*width: 1%;*/
        }
        table td.checkboxcontent{
            background-color: rgb(255, 255, 240);
            text-align: left;
        }
        div.content{
            margin: 0 auto;
            padding: 50px;
            /*width: 1200px;*/
            background-color: white;
        }
        .file_title{
            padding-bottom: 1rem;
            font-size:20px;
            border-top: hidden;
            border-left: hidden;
            border-right: hidden;
        }
        .ivory_bg{
            background-color: rgb(255, 255, 240);
        }
        td > p{
            margin: 3rem 0 0;
            text-align: left;
            vertical-align: bottom;
        }
        td > p > input{
            height: auto;
            /*width: 3ch;*/
        }
        input:not([type=radio]):not([type=checkbox]) {
            /*height: 100%;*/
            width: 100%;
            /*border-style: initial;*/
        }
        .footer{
            text-align-last: center;
            margin: 1rem;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: 'LectureProfessorApplicationForm',
                dataType: 'json',
                data: JSON.stringify(InputToJson()),
                // contentType: 'application/json',
                success: function(data){
                    alert(data.status);
                    window.location.href="LectureProfessorApplicationForm";
                },error:function(data,status,er) {
                    alert("存檔失敗");
                }
            });
        };

        function InputToJson(){
            var data = {};
            let dataNumber = 0;
            let totalNeedtoFillField = 0;
            const inputList = document.getElementsByTagName("input");

            for (let j=0; j<inputList.length; j++) {
                if (inputList[j].type=='checkbox'){
                    data[ inputList[j].name] = inputList[j].checked;
                    if(inputList[j].checked){
                        dataNumber++; // when true , add it
                        if(inputList[j].id == "applicationrequirements15"){
                            const textareaList = document.getElementsByTagName("textarea");

                            if(textareaList[0].value.length > 0 ){
                                dataNumber++;
                            }
                        }
                        totalNeedtoFillField++;
                    }
                }
                else if(inputList[j].type=='radio'){
                    data[ inputList[j].id] = inputList[j].checked;
                    if(inputList[j].checked){
                        dataNumber++; // when true , add it
                        totalNeedtoFillField++;
                    }
                }
                else{
                    data[ inputList[j].name] = inputList[j].value;
                    totalNeedtoFillField++;
                    if(inputList[j].value.length > 0 ){
                        dataNumber++;
                    }
                }
            }

            data[ document.getElementsByTagName("textarea")[0].name] = document.getElementsByTagName("textarea")[0].value;

            console.log(dataNumber,totalNeedtoFillField,inputList.length)
            data["fill_rate"] = dataNumber/(totalNeedtoFillField  -2 );  //審核input不列入計算-2
            return data;
        }


        $( document ).ready(function() {
            $("input[id='lectureCategoryExp']").prop("checked", <%=json.get("lectureCategoryExp")%>);
            $("input[id='lectureCategoryInv']").prop("checked", <%=json.get("lectureCategoryInv")%>);
            $("input[id='lectureCategoryLif']").prop("checked", <%=json.get("lectureCategoryLif")%>);
            $("input[name='applicationrequirements1']").prop("checked", <%=json.get("applicationrequirements1")%>);
            $("input[name='applicationrequirements2']").prop("checked", <%=json.get("applicationrequirements2")%>);
            $("input[name='applicationrequirements3']").prop("checked", <%=json.get("applicationrequirements3")%>);
            $("input[name='applicationrequirements4']").prop("checked", <%=json.get("applicationrequirements4")%>);
            $("input[name='applicationrequirements5']").prop("checked", <%=json.get("applicationrequirements5")%>);
            $("input[name='applicationrequirements6']").prop("checked", <%=json.get("applicationrequirements6")%>);
            $("input[name='applicationrequirements7']").prop("checked", <%=json.get("applicationrequirements7")%>);
            $("input[name='applicationrequirements8']").prop("checked", <%=json.get("applicationrequirements8")%>);
            $("input[name='applicationrequirements9']").prop("checked", <%=json.get("applicationrequirements9")%>);
            $("input[name='applicationrequirements10']").prop("checked", <%=json.get("applicationrequirements10")%>);
            $("input[name='applicationrequirements11']").prop("checked", <%=json.get("applicationrequirements11")%>);
            $("input[name='applicationrequirements12']").prop("checked", <%=json.get("applicationrequirements12")%>);
            $("input[name='applicationrequirements13']").prop("checked", <%=json.get("applicationrequirements13")%>);
            $("input[name='applicationrequirements14']").prop("checked", <%=json.get("applicationrequirements14")%>);
            $("input[name='applicationrequirements15']").prop("checked", <%=json.get("applicationrequirements15")%>);
            $("input[name='applicationrequirementsCheck']").prop("checked", <%=json.get("applicationrequirementsCheck")%>);
        });



    </script>
</head>

<body>
<div class="content">
    <form>
        <p class="file_title">國立臺北科技大學講座教授申請表</p>
        <table>
            <tbody>
            <tr>
                <td colspan="4" class="metadata">員工編號</td>
                <td colspan="4" ><input type="text" name="usernum" disabled="disabled" value=<%=json.get("usernum")%> ></td>
            </tr>
            <tr>
                <td colspan="4" class="metadata">申請人姓名(英文姓名)</td>
                <td colspan="4" ><input type="text" name="name" value=<%=json.get("name")%> ></td>
            </tr>
            <tr>
                <td colspan="4" class="metadata">職稱</td>
                <td colspan="4"><input type="text" name="job" value=<%=json.get("job")%> ></td>
            </tr>
            <tr>
                <td colspan="4" class="metadata">服務學校與系所</td>
                <td colspan="4"><input type="text" name="serviceSchoolAndDepartment" value=<%=json.get("serviceSchoolAndDepartment")%> ></td>
            </tr>
            <tr>
                <td colspan="4" class="metadata">教授證書號碼</td>
                <td colspan="4"><input type="text" name="certificatenum" value=<%=json.get("certificatenum")%> ></td>
            </tr>
            <tr>
                <td colspan="4" class="metadata">本校任職日期</td>
                <td colspan="4"><input type="date" name="workStartDate" value=<%=json.get("workStartDate")%> ></td>
            </tr>
            <tr>
                <td colspan="4" class="metadata">教授年資</td>
                <td colspan="4"><input type="text" name="seniority" value=<%=json.get("seniority")%> ></td>
            </tr>
            <tr>
                <td colspan="4" class="metadata">E-mail</td>
                <td colspan="4"><input type="text" name="email" value=<%=json.get("email")%> ></td>
            </tr>
            <tr>
                <td  colspan="4" class="metadata">聯絡電話</td>
                <td  colspan="4">
                    <p>研究室分機：<input type="text" name="researchroomext" value=<%=json.get("researchroomext")%> ></p>
                    <p>手機：<input type="text" name="cellphone" value=<%=json.get("cellphone")%> ></p>
                </td>
            </tr>
            <tr>
                <td  colspan="4" class="metadata">申請講座項目</td>
                <td colspan="4">
                    <input type ="radio" id="lectureCategoryExp" name="lectureCategory">專任講座
                    <input type ="radio" id="lectureCategoryInv" name="lectureCategory">客座講座
                    <input type ="radio" id="lectureCategoryLif" name="lectureCategory">終生講座
                </td>
            </tr>


            <tr>
                <td  colspan="8" class="ivory_bg" >申請條件（請勾選並檢附相關證明文件）</td>
            </tr>
            <tr>
                <td  colspan="4" class="cb" align="center"><input type="checkbox" name="applicationrequirements1" ></td>
                <td  colspan="4" class="checkboxcontent">
                    諾貝爾得獎人
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="cb" align="center"><input type="checkbox" name="applicationrequirements2" ></td>
                <td colspan="4"  class="checkboxcontent">
                    中央研究院院士
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="cb" align="center"><input type="checkbox" name="applicationrequirements3" ></td>
                <td colspan="4"  class="checkboxcontent">
                    曾獲總統科學獎
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="cb" align="center"><input type="checkbox" name="applicationrequirements4" ></td>
                <td colspan="4"  class="checkboxcontent">
                    曾獲行政院傑出科技貢獻獎
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="cb" align="center"><input type="checkbox" name="applicationrequirements5" ></td>
                <td colspan="4"  class="checkboxcontent">
                    曾獲教育部國家講座
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="cb" align="center"><input type="checkbox" name="applicationrequirements6" ></td>
                <td colspan="4"  class="checkboxcontent">
                    曾獲教育部學術獎
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="cb" align="center"><input type="checkbox" name="applicationrequirements7" ></td>
                <td colspan="4"  class="checkboxcontent">
                    曾獲科技部傑出特約研究員獎
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="cb" align="center"><input type="checkbox" name="applicationrequirements8" ></td>
                <td colspan="4"  class="checkboxcontent">
                    曾獲科技部傑出研究獎二次以上
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="cb" align="center"><input type="checkbox" name="applicationrequirements9" ></td>
                <td colspan="4"  class="checkboxcontent">
                    國際知名之國家院士
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="cb" align="center"><input type="checkbox" name="applicationrequirements10" ></td>
                <td colspan="4"  class="checkboxcontent">
                    曾(現)任國際著名大學之講座
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="cb" align="center"><input type="checkbox" name="applicationrequirements11" ></td>
                <td colspan="4"  class="checkboxcontent">
                    重要國際學會會士(Fellow)
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="cb" align="center"><input type="checkbox" name="applicationrequirements12" ></td>
                <td colspan="4"  class="checkboxcontent">
                    曾獲本校終身特聘教授滿3年者
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="cb" align="center"><input type="checkbox" name="applicationrequirements13" ></td>
                <td colspan="4"  class="checkboxcontent">
                    在產學合作或實務專業技術上有傑出貢獻
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="cb" align="center"><input type="checkbox" name="applicationrequirements14" ></td>
                <td colspan="4"  class="checkboxcontent">
                    其他在學術上有傑出貢獻
                </td>
            </tr>
            <tr>
                <td  colspan="4" class="cb" align="center"><input type="checkbox" name="applicationrequirements15" ></td>
                <td colspan="4"  class="checkboxcontent">
                    前一任獎座之申請條件(第二任以上申請者)<textarea class="singleRow" name ="additionalInfo" required maxlength="500"  style="height:20px"><%=json.get("additionalInfo")%></textarea>
                </td>
            </tr>
            <tr>
<%--                <td colspan="4"  class="cb" align="center"></td>--%>
                <td colspan="8"  class="checkboxcontent">
                    <input type="checkbox" name="applicationrequirementsCheck" required>
                    申請人聲明充分了解申請辦法，且上述資料與勾選事項皆屬實，若有誤願自行負完全法律責任。
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

         <div class="footer">
            <button type="button" name="return_last_page" onclick="javascript:location.href='LectureProfessorCatalog'">回上頁</button>
            <button type="button" name="save" onclick="commit()">暫存</button>
         </div>


    </form>
</div>

</body>
</html>
