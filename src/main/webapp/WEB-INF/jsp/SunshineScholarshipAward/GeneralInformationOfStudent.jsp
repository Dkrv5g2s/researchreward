<%--
  Created by IntelliJ IDEA.
  User: Ted Lin
  Date: 2021/1/22
  Time: 上午 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>陽光獎助金論文 學生基本資料表</title>
    <style type="text/css">
        /* input {
            height: 100%;
            width: 100%;
        } */
    </style>
</head>
<body>
<p style="text-align:center;font-weight:bold;font-size:20px;clear:none;">陽光獎助金論文 學生基本資料表</p>
<form method="post" action="Plan?func=international_formC001" enctype="multipart/form-data" id="c001_form">
    <table border="1" cellpadding="5" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
        <tbody>
        <!-- 大列1 -->
        <tr style="text-align: center;">
            <td rowspan="3" colspan="1" width="20%" style="font-size:22px"><strong>申請人姓名</strong></td>
            <td width="10%" style="text-align: left;">中文:&nbsp;<input name="TheChineseNameofApplicant" maxlength="40"></td>
        </tr>
        <tr style="text-align: left;">
            <td width="10%">英文:&nbsp;<input name="TheChineseNameofApplicant" maxlength="40"></td>

        </tr>
        <tr style="text-align: left;">
            <td width="10%">身分證字號(ARC No.):&nbsp;<input name="TheChineseNameofApplicant" maxlength="40"></td>

        </tr>
        <!-- 大列2 -->
        <tr style="text-align: center;">
            <td rowspan="1" colspan="1" width="20%" style="font-size:22px"><strong>單位(系所):</strong></td>
            <td rowspan="1" colspan="0" width="38%" style="font-size:22px;text-align: left;"><input name="TheNameofDepartment" maxlength="40"></td>
        </tr>


        <!-- 大列3 -->
        <tr style="text-align: center;" id="FacultyTr">
            <td rowspan="1" colspan="1" width="20%" style="font-size:22px">
                <strong>學生類別</strong></td>
            <td rowspan="1" colspan="1" width="20%" style="font-size:22px;text-align: left;" id="FacultyTable">
                <select name="Titles" size="1" id = "selectFacultyBox" onchange="changeFunc();">
                    <option value="" selected>請選擇對應類別</option>
                    <option value="PHD">博士生</option>
                    <option value="Master">碩士生</option>
                    <option value="Bachelor">學士生</option>
                    <option value="Alumni">校友(畢業36個月內)</option>
                </select>
            </td>
        </tr>


        <!-- 大列4 -->
        <tr style="text-align: center;">
            <td rowspan="3" colspan="1" width="20%" style="font-size:22px"><strong>聯絡方式:</strong></td>
            <td rowspan="1" colspan="0" width="20%" style="text-align: left;">研究室分機:&nbsp;<input name="ExtensionNumber" maxlength="15"></td>
        </tr>
        <tr style="text-align: center;">
            <td rowspan="1" colspan="0" width="20%" style="text-align: left;">手機:&nbsp;<input name="CellphoneNumber" maxlength="15"></td>
        </tr>
        <tr style="text-align: center;">
            <td rowspan="1" colspan="0" width="20%" style="text-align: left;">E-mail:&nbsp;<input name="EmailAddress" maxlength="40"></td>
        </tr>
        <td colspan="6" style="background-color:rgb(255, 255, 240);text-align: center">
            <input type="button" width="10%" value="回上頁" name="return_last_page" onclick="javascript:location.href='SunshineScholarshipCatalog'"  >
            <input type="button" width="10%" value="存檔" name="save_the_page"  >
        </td>
        </tbody>
    </table>
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
        newTitleCell.setAttribute('id', "StudentInput");
        newTitleCell.setAttribute('size', 10);
        newTitleCell.setAttribute('maxlength', 40);
        newTitleCell.setAttribute('class', 'innerinput');
        newTitleCell.innerHTML = "班級:&nbsp;"
        newTitleCell.appendChild(input);
        facultytable.appendChild(newTitleCell);


        if(selectedValue === 'Alumni' ){
            if (document.getElementById('AlumniInput') == null){
                var ResignTime = document.createElement('td');
                var Resigninput = document.createElement('input');
                ResignTime.setAttribute('id',"AlumniInput");
                ResignTime.setAttribute('size',10);
                ResignTime.setAttribute('maxlength',40);
                ResignTime.setAttribute('class', 'innerinput');
                ResignTime.innerHTML = "畢業年月(請填寫畢業證書上的畢業年月):&nbsp;"
                ResignTime.appendChild(Resigninput);
                facultytable.appendChild(ResignTime);
            }
        }
    }
    function clearExistedInput(){
        if (document.getElementById('AlumniInput') != null){
            document.getElementById("AlumniInput").remove();
        }
        if (document.getElementById('StudentInput') != null){
            document.getElementById("StudentInput").remove();
        }
    }

</script>

<style type="text/css">
    .innerinput{
        border-style:none;
        text-align: left;
        font-size:22px;
    }
</style>
