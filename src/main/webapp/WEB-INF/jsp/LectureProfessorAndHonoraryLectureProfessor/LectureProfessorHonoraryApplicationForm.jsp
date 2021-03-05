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
            background-color: white;
        }

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: 'LectureProfessorHonoraryApplicationForm',
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
                data[document.getElementsByTagName("input")[j].name] = document.getElementsByTagName("input")[j].value;
            }
            data[ document.getElementsByTagName("textarea")[0].name] = document.getElementsByTagName("textarea")[0].value;
            data[ document.getElementsByTagName("textarea")[1].name] = document.getElementsByTagName("textarea")[1].value;
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
                <td class="metadata">員工編號</td>
                <td><input type="text" name="usernum" disabled="disabled" value=<%=json.get("usernum")%> ></td>
            </tr>
            <tr>
                <td class="metadata">姓名</td>
                <td><input type="text" name="name" value=<%=json.get("name")%> ></td>
            </tr>
            <tr>
                <td class="metadata">服務單位與職稱</td>
                <td><input type="text" name="jobAndDept" value=<%=json.get("jobAndDept")%> ></td>
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
            </tbody>
        </table>
        <table>
            <tbody>
            <tr>
                <td style="text-align:center">
                    個人學經歷
                </td>
            </tr>
            <tr style="height:200px;">
                <td >
                    <textarea style="width:100%; height:100%;" name ="indivisualEducation" ><%=json.get("indivisualEducation")%></textarea>
                </td>
            </tr>
            <tr>
                <td style="text-align:center">
                    推薦理由
                </td>
            </tr>
            <tr style="height:200px;">
                <td >
                    <textarea style="width:100%; height:100%;" name ="recommendationReason" ><%=json.get("recommendationReason")%><%=json.get("recommendationReason")%></textarea>
                </td>
            </tr>

            </tbody>
        </table>
        <p>
            <input type="button" name="save" value="存檔" onclick="commit()">
            <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='LectureProfessorCatalog'"  >
        </p>
    </form>
</div>

</body>
</html>

