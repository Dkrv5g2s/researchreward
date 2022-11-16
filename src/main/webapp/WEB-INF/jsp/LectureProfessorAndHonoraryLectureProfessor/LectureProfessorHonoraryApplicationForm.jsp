<%--
  Created by IntelliJ IDEA.
  User: CUser
  Date: 2021/2/1
  Time: 下午 02:13
  To change this template use File | Settings | File Templates.
--%>
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
            /*width: 150px;*/
            background-color: rgb(255, 255, 240);
            text-align: right;
        }
        table td.cb{
            /*width: 1%;*/
        }
        table td.checkboxcontent{
            /*width: 500px;*/
            background-color: rgb(255, 255, 240);
            text-align: left;
        }
        div.content{
            margin: 0 auto;
            padding: 50px;
            background-color: white;
        }
        td > p{
            margin: 6rem 0 0;
            text-align: left;
            vertical-align: bottom;
        }
        .footer{
            text-align-last: center;
            margin: 1rem;
        }
        .requiredField {
            color: red;
        }
    </style>
    <script src="lib/jquery.min.js"></script>
    <script>
        function commit(){
            if ($("#name").val() && $("#jobAndDept").val() && $("#email").val() && $("#cellphone").val() && $("#indivisualEducation").val() && $("#recommendationReason").val()) {
                $.ajax({
                    type: 'POST',
                    url: 'LectureProfessorHonoraryApplicationForm',
                    dataType: 'json',
                    data: JSON.stringify(InputToJson()),
                    contentType: 'application/json',
                    success: function(data){
                        alert(data.status);
                        window.location.href="LectureProfessorHonoraryApplicationForm";
                    },error:function(data,status,er) {
                        alert("存檔失敗");
                    }
                });
            }
            else {
                alert("尚未填寫完成!");
            }
        };

        function InputToJson(){
            var data = {};
            let dataNumber = 0;
            const inputList = document.getElementsByTagName("input");
            const textareaList = document.getElementsByTagName("textarea");

            for (var j=0; j<inputList.length; j++) {
                data[inputList[j].name] = inputList[j].value;
                if(inputList[j].value.length > 0 ){
                    dataNumber++;
                }
            }

            for (let j=0; j<textareaList.length; j++) {
                data[ textareaList[j].name] = textareaList[j].value;
                if(textareaList[j].value.length > 0 ){
                    dataNumber++;
                }
            }

            data["commit_date"] = $("#commit_date").val();
            console.log(dataNumber,inputList.length,textareaList.length)

            data["fill_rate"] = dataNumber/(inputList.length + textareaList.length );

            return data;
        }
    </script>
</head>

<body>
<div class="content">
    <form>
        <p>國立臺北科技大學榮譽講座教授申請表</p>
        <table>
            <tbody>
            <tr>
                <td colspan="4" class="metadata"><span class="requiredField">✱</span>員工編號</td>
                <td colspan="4"><input type="text" name="usernum" disabled="disabled" value=<%=json.get("usernum")%> ></td>
            </tr>
            <tr>
                <td colspan="4" class="metadata"><span class="requiredField">✱</span>被推薦人姓名(英文姓名)</td>
                <td colspan="4"><input type="text" id="name" name="name" value=<%=json.get("name")%> ></td>
            </tr>
            <tr>
                <td colspan="4" class="metadata"><span class="requiredField">✱</span>服務單位與職稱</td>
                <td colspan="4"><input type="text" id="jobAndDept" name="jobAndDept" value=<%=json.get("jobAndDept")%> ></td>
            </tr>
            <tr>
                <td colspan="4" class="metadata"><span class="requiredField">✱</span>E-mail</td>
                <td colspan="4"><input type="text" id="email" name="email" value=<%=json.get("email")%> ></td>
            </tr>
            <tr>
                <td colspan="4" class="metadata"><span class="requiredField">✱</span>聯絡電話</td>
                <td colspan="4">
<%--                    <p>研究室分機：<input type="text" name="researchroomext" value=<%=json.get("researchroomext")%> ></p>--%>
                    <input type="text" id="cellphone" name="cellphone" value=<%=json.get("cellphone")%> >
                </td>
            </tr>
            <tr>
                <td colspan="8" style="text-align:center">
                    <span class="requiredField">✱</span>個人學經歷
                </td>
            </tr>
            <tr style="height:200px;">
                <td colspan="8">
                    <textarea style="width:100%; height:100%;" id ="indivisualEducation" name ="indivisualEducation" ><%=json.get("indivisualEducation")%></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="8" style="text-align:center">
                    <span class="requiredField">✱</span>推薦理由
                </td>
            </tr>
            <tr style="height:200px;">
                <td colspan="8" >
                    <textarea style="width:100%; height:100%;" id ="recommendationReason" name ="recommendationReason" ><%=json.get("recommendationReason")%><%=json.get("recommendationReason")%></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: center">
                    <label>院長核章</label>
                </td>
                <td colspan="4" style="text-align: center">
                    <label>研發處</label>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <p></p>
                </td>
                <td colspan="4">
                    <p></p>
                </td>
            </tr>
            <tr>
                <td colspan="8" >
                    <p style="text-align: right;">
                        <label for="commit_date">申請日期：</label>
                        <input type="date" id="commit_date" style="width: auto;" value="<%=json.optString("commitDate", "")%>">
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

