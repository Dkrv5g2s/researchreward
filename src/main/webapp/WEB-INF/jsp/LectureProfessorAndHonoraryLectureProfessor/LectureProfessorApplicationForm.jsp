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
            vertical-align: middle;
        }
        table td.metadata{
            width: 150px;
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
                url: 'LectureProfessorApplicationForm',
                dataType: 'json',
                data: JSON.stringify(InputToJson()),
                contentType: 'application/json',
                success: function(data){
                    alert('success');
                }
            });
        };

        function InputToJson(){
            var data = {};

            for (var j=0; j<document.getElementsByTagName("input").length; j++) {
                if (document.getElementsByTagName("input")[j].type=='checkbox'){
                    data[ document.getElementsByTagName("input")[j].name] = document.getElementsByTagName("input")[j].checked;
                }
                else if(document.getElementsByTagName("input")[j].type=='radio'){
                    data[ document.getElementsByTagName("input")[j].id] = document.getElementsByTagName("input")[j].checked;
                }
                else{
                    data[ document.getElementsByTagName("input")[j].name] = document.getElementsByTagName("input")[j].value;
                }
            }
            data[ document.getElementsByTagName("textarea")[0].name] = document.getElementsByTagName("textarea")[0].value;
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
        <p>國立臺北科技大學講座教授申請表</p>
        <table>
            <tbody>
            <tr>
                <td class="metadata">員工編號</td>
                <td><input type="text" name="usernum" disabled="disabled" value=<%=json.get("usernum")%> ></td>
            </tr>
            <tr>
                <td class="metadata">姓名</td>
                <td><input type="text" name="name" value=<%=json.get("name")%> ></td>
            </tr>
            <tr>
                <td class="metadata">職稱</td>
                <td><input type="text" name="job" value=<%=json.get("job")%> ></td>
            </tr>
            <tr>
                <td class="metadata">服務學校與系所</td>
                <td><input type="text" name="serviceSchoolAndDepartment" value=<%=json.get("serviceSchoolAndDepartment")%> ></td>
            </tr>
            <tr>
                <td class="metadata">教授證書號碼</td>
                <td><input type="text" name="certificatenum" value=<%=json.get("certificatenum")%> ></td>
            </tr>
            <tr>
                <td class="metadata">本校任職日期</td>
                <td><input type="date" name="workStartDate" value=<%=json.get("workStartDate")%> ></td>
            </tr>
            <tr>
                <td class="metadata">教授年資</td>
                <td><input type="text" name="seniority" value=<%=json.get("seniority")%> ></td>
            </tr>
            <tr>
                <td class="metadata">E-mail</td>
                <td><input type="text" name="email" value=<%=json.get("email")%> ></td>
            </tr>
            <tr>
                <td class="metadata">聯絡電話</td>
                <td>
                    <p>研究室分機：<input type="text" name="researchroomext" value=<%=json.get("researchroomext")%> ></p>
                    <p>手機：<input type="text" name="cellphone" value=<%=json.get("cellphone")%> ></p>
                </td>
            </tr>
            <tr>
                <td class="metadata">申請講座項目</td>
                <td>
                    <input type ="radio" id="lectureCategoryExp" name="lectureCategory">專任講座
                    <input type ="radio" id="lectureCategoryInv" name="lectureCategory">客座講座
                    <input type ="radio" id="lectureCategoryLif" name="lectureCategory">終生講座
                </td>
            </tr>
            </tbody>
        </table>
        <p>申請條件（請勾選並檢附相關證明文件）</p>
        <table>
            <tbody>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements1" ></td>
                <td class="checkboxcontent">
                    諾貝爾得獎人
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements2" ></td>
                <td class="checkboxcontent">
                    中央研究院院士
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements3" ></td>
                <td class="checkboxcontent">
                    曾獲總統科學獎
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements4" ></td>
                <td class="checkboxcontent">
                    曾獲行政院傑出科技貢獻獎
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements5" ></td>
                <td class="checkboxcontent">
                    曾獲教育部國家講
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements6" ></td>
                <td class="checkboxcontent">
                    曾獲教育部學術獎
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements7" ></td>
                <td class="checkboxcontent">
                    曾獲科技部傑出特約研究員
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements8" ></td>
                <td class="checkboxcontent">
                    曾獲科技部傑出研究獎二次以上
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements9" ></td>
                <td class="checkboxcontent">
                    國際知名之國家院士
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements10" ></td>
                <td class="checkboxcontent">
                    曾(現)任國際著名大學之講座
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements11" ></td>
                <td class="checkboxcontent">
                    重要國際學會會士(Fellow)
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements12" ></td>
                <td class="checkboxcontent">
                    曾獲本校終身特聘教授滿3年者
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements13" ></td>
                <td class="checkboxcontent">
                    在產學合作或實務專業技術上有傑出貢獻
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements14" ></td>
                <td class="checkboxcontent">
                    其他在學術上有傑出貢獻
                </td>
            </tr>
            <tr>
                <td class="cb" align="center"><input type="checkbox" name="applicationrequirements15" ></td>
                <td class="checkboxcontent">
                    前一任獎座之申請條件(第二任以上申請者)<textarea class="singleRow" name ="additionalInfo" required maxlength="200"  style="height:20px"><%=json.get("additionalInfo")%></textarea>
                </td>
            </tr>

            </tbody>
        </table>
        <br>
        <td class="cb" align="center"><input type="checkbox" name="applicationrequirementsCheck"></td>
        <td class="checkboxcontent">
            申請人聲明充分了解申請辦法，且上述資料與勾選事項皆屬實，若有誤願自行負完全法律責任。
        </td>
        <p>
            <input type="button" name="save" value="存檔" onclick="commit()" >
            <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='LectureProfessorCatalog'"  >
        </p>
    </form>
</div>

</body>
</html>
