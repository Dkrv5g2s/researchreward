<%--
  Created by IntelliJ IDEA.
  User: CUser
  Date: 2021/2/8
  Time: 上午 07:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");
%>
<html>
<head>
    <title>講座期間之績效表現(申請第二任以上者填寫)</title>
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
            vertical-align: text-middle;
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
            /*width: 1200px;*/
            background-color: white;
        }

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: 'LectureProfessorExcellenceFormD',
                dataType: 'text',
                data: JSON.stringify(InputToJson()),
                contentType: 'application/json',
                success: function(data){
                    alert('存檔成功');
                    window.location.href="LectureProfessorExcellenceFormD";
                },
                error:function() {
                    alert("存檔失敗");
                }
            });
        };
        function InputToJson(){
            var data = {};
            let dataNumber = 0;
            const inputList = document.getElementsByTagName("input");


            for (let j=0; j<inputList.length; j++) {
                data[ inputList[j].name] = inputList[j].value;
                if(inputList[j].value.length > 0){
                    dataNumber++;
                }
            }
            const textareaList = document.getElementsByTagName("textarea");
            for (let j=0; j<textareaList.length; j++) {
                data[ textareaList[j].name] = textareaList[j].value;
                if(textareaList[j].value.length > 0 && inputList[j].className.length === 0){
                    dataNumber++;
                }
            }
            data["fill_rate"] = dataNumber/(inputList.length + textareaList.length );
            return data;
        }
    </script>
</head>

<body>
<div class="content">
    <form>
        <p>講座期間之績效表現(申請第二任以上者填寫)</p>
        <table>
            <tbody>
            <tr>
                <td class="metadata">員工編號</td>
                <td><input type="text" name="usernum" disabled="disabled" value=<%=json.get("usernum")%> ></td>
            </tr>
            <tr>
                <td class="metadata">系所</td>
                <td><input type="text" name="depart" value=<%=json.get("depart")%> ></td>
            </tr>
            <tr>
                <td class="metadata">姓名</td>
                <td><input type="text" name="name" value=<%=json.get("name")%> ></td>
            </tr>
            <tr>
                <td class="metadata">講座期間</td>
                <td><input type="text" name="speechTime" value=<%=json.get("speechTime")%> ></td>
            </tr>
            <tr>
                <td class="metadata">支給總金額</td>
                <td><input type="number" name="payment" value=<%=json.get("payment")%> ></td>
            </tr>
            <tr>
                <td class="metadata">具體績效</td>
                <td><textarea width = "100%" name="performance" placeholder="請說明具體績效（以1頁為原則)"><%=json.get("performance")%></textarea></td>
            </tr>

            </tbody>
        </table>
        <p style="text-align: center;">
            <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='LectureProfessorCatalog'"  >
            <input type="button" name="save" value="暫存" onclick="commit()">
        </p>
    </form>
</div>

</body>
</html>

