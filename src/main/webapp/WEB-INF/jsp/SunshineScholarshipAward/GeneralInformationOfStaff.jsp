<%--
  Created by IntelliJ IDEA.
  User: Ted Lin
  Date: 2021/1/21
  Time: 下午 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");
%>
<html>
<head>
    <title>陽光獎助金論文 教職研人員基本資料表</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <link rel="stylesheet" type="text/css" href="/css/body.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: '/SelectInformation',
                dataType: 'json',
                data: JSON.stringify(InputToJson()),
                contentType: 'application/json',
                success: function(data){
                    alert('存檔成功，將跳轉下頁');
                }
            });

        };

        function InputToJson(){
            var data = {};
            data['ResignedTime'] = "";
            for (var j=0; j<document.getElementsByTagName("input").length; j++) {
                if (document.getElementsByTagName("input")[j].type=='checkbox' && document.getElementsByTagName("input")[j].checked == false){
                    continue;
                }else {
                    data[ document.getElementsByTagName("input")[j].name] = document.getElementsByTagName("input")[j].value;
                }

            }
            console.log("inputdata is :", data);
            for (var j=0; j<document.getElementsByTagName("select").length; j++){
                data[ document.getElementsByTagName("select")[j].name] = document.getElementsByTagName("select")[j].value;
            }
            // console.log("data is :", data);
            return data;
        }


        $( document ).ready(function() {
            // 在這撰寫javascript程式碼
            <%--$('#level').val("<%=json.get("level")%>");--%>
            <%--$('#qualification1').prop("checked","<%=json.get("qualification1")%>");--%>
            <%--$('#qualification2').prop("checked","<%=json.get("qualification2")%>");--%>
        });
    </script>
</head>
<body>
<p style="text-align:center;font-weight:bold;font-size:20px;clear:none;">陽光獎助金論文 教職研人員基本資料表</p>
    <form >
        <table border="1" cellpadding="5" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <tbody>
            <!-- 大列1 -->
            <tr style="text-align: center;">
                <td rowspan="3" colspan="1" width="20%" style="font-size:22px"><strong>申請人姓名</strong></td>
                <td width="10%" style="text-align: left;">中文:&nbsp;<input name="chineseName" maxlength="40"></td>
            </tr>
            <tr style="text-align: left;">
                <td width="10%">英文:&nbsp;<input name="englishName" maxlength="40"></td>

            </tr>
            <tr style="text-align: left;">
                <td width="10%">身分證字號(ARC No.):&nbsp;<input name="nationalIDNumber" maxlength="40"></td>

            </tr>
            <!-- 大列2 -->
            <tr style="text-align: center;">
                <td rowspan="1" colspan="1" width="20%" style="font-size:22px"><strong>單位(系所):</strong></td>
                <td rowspan="1" colspan="0" width="38%" style="font-size:22px;text-align: left;"><input name="department" maxlength="40"></td>
            </tr>


            <!-- 大列3 -->
            <tr style="text-align: center;" id="FacultyTr">
                <td rowspan="1" colspan="1" width="20%" style="font-size:22px">
                    <strong>教職員<br>職&nbsp;&nbsp;&nbsp;稱</strong></td>
                <td rowspan="1" colspan="1" width="20%" style="font-size:22px;text-align: left;" id="FacultyTable">
                    <select name="titles" size="1" id = "selectFacultyBox" onchange="changeFunc();">
                        <option value="" selected>請選擇教職員類型</option>
                        <option value="FullTimeTeacher">專任教師</option>
                        <option value="Researcher">研究人員</option>
                        <option value="FullTimeStaff">專任職員</option>
                        <option value="ResignedMember">離職教職研人員(離職36個月內)</option>
                    </select>
                </td>
            </tr>


            <!-- 大列4 -->
            <tr style="text-align: center;">
                <td rowspan="3" colspan="1" width="20%" style="font-size:22px"><strong>聯絡方式:</strong></td>
                <td rowspan="1" colspan="0" width="20%" style="text-align: left;">研究室分機:&nbsp;<input name="extensionNumber" maxlength="15"></td>
            </tr>
            <tr style="text-align: center;">
                <td rowspan="1" colspan="0" width="20%" style="text-align: left;">手機:&nbsp;<input name="cellphoneNumber" maxlength="15"></td>
            </tr>
            <tr style="text-align: center;">
                <td rowspan="1" colspan="0" width="20%" style="text-align: left;">E-mail:&nbsp;<input name="emailAddress" maxlength="40"></td>
            </tr>
            <tr>
                <td colspan="6" style="background-color:rgb(255, 255, 240);text-align: center">
                    <button type="button" width="10%" onclick="javascript:location.href='SunshineScholarshipCatalog'">回上頁</button>
                    <button type="button" width="10%" onclick="commit()">存檔</button>
                </td>
            </tr>
            </tbody>
        </table>
    </form >
</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

    function changeFunc() {

        var selectBox = document.getElementById("selectFacultyBox");
        var selectedValue = selectBox.options[selectBox.selectedIndex].value;
        var facultytable = document.getElementById("FacultyTable");


        clearExistedInput();

        var newTitleCell = document.createElement('td');
        var input = document.createElement('input');

        newTitleCell.setAttribute('id', "StaffInput");
        newTitleCell.setAttribute('size', 10);
        newTitleCell.setAttribute('maxlength', 40);
        newTitleCell.setAttribute('class', 'innerinput');
        newTitleCell.innerHTML = "職稱:&nbsp;"
        newTitleCell.appendChild(input);
        input.setAttribute('name', "levels");
        facultytable.appendChild(newTitleCell);


        if(selectedValue === 'ResignedMember' ){
            if (document.getElementById('ResignedMemberInput') == null){
                var ResignTime = document.createElement('td');
                var Resigninput = document.createElement('input');
                Resigninput.setAttribute('name',"ResignedTime");
                Resigninput.setAttribute('type',"date");
                ResignTime.setAttribute('id',"ResignedMemberInput");
                ResignTime.setAttribute('size',10);
                ResignTime.setAttribute('maxlength',40);
                ResignTime.setAttribute('class', 'innerinput');
                ResignTime.innerHTML = "離職年月:&nbsp;"
                ResignTime.appendChild(Resigninput);
                facultytable.appendChild(ResignTime);
            }
        }
    }
    function clearExistedInput(){
        if (document.getElementById('ResignedMemberInput') != null){
            document.getElementById("ResignedMemberInput").remove();
        }
        if (document.getElementById('StaffInput') != null){
            document.getElementById("StaffInput").remove();
        }
    }

</script>

<style type="text/css">
    .innerinput{
        border-style:none;
        text-align: left;
    }
</style>