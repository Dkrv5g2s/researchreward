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
//    System.out.println("json:"+json);
%>
<html>
<head>
    <title>陽光獎助金論文 教職研人員基本資料表</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <link rel="stylesheet" type="text/css" href="/css/body.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%--    <script src="math.js" type="text/javascript"></script>--%>
    <script src=https://cdnjs.cloudflare.com/ajax/libs/mathjs/3.3.0/math.min.js></script>
</head>
<body>
<p style="text-align:center;font-weight:bold;font-size:20px;clear:none;">陽光獎助金論文 教職研人員基本資料表</p>
    <form >
        <table border="1" cellpadding="5" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <tbody>
            <!-- 大列1 -->
            <tr style="text-align: center;">
                <td rowspan="3" colspan="1" width="20%" style="font-size:22px"><strong>申請人姓名</strong></td>
                <td width="10%" style="text-align: left;">中文:&nbsp;<input  id="chineseName" maxlength="40" ></td>
            </tr>
            <tr style="text-align: left;">
                <td width="10%">英文:&nbsp;<input  id="englishName" maxlength="40" ></td>

            </tr>
            <tr style="text-align: left;">
                <td width="10%">身分證字號(ARC No.):&nbsp;<input  id="nationalIDNumber" maxlength="40" ></td>

            </tr>
            <!-- 大列2 -->
            <tr style="text-align: center;">
                <td rowspan="1" colspan="1" width="20%" style="font-size:22px"><strong>單位(系所):</strong></td>
                <td rowspan="1" colspan="0" width="38%" style="font-size:22px;text-align: left;"><input  id="department" maxlength="40" ></td>
            </tr>


            <!-- 大列3 -->
            <tr style="text-align: center;" id="FacultyTr">
                <td rowspan="1" colspan="1" width="20%" style="font-size:22px">
                    <strong>教職員<br>職&nbsp;&nbsp;&nbsp;稱</strong></td>
                <td rowspan="1" colspan="1" width="20%" style="font-size:13px;text-align: left;" id="FacultyTable">
                    <select  size="1" id = "titles" onchange="changeFunc();" >
                        <option value="" selected>請選擇教職員類型</option>
                        <option value="FullTimeTeacher">專任教師</option>
                        <option value="Researcher">研究人員</option>
                        <option value="FullTimeStaff">專任職員</option>
                        <option value="ResignedMember">離職教職研人員(離職36個月內)</option>
                    </select><br>
                    <span id="StaffInput">職稱:&nbsp;<input id="levels"></span>
                    <span id="ResignedMemberInput" style = "display : none ;">離職年月:&nbsp;<input id="resignedTime" type="date"></span>
                </td>
            </tr>


            <!-- 大列4 -->
            <tr style="text-align: center;">
                <td rowspan="3" colspan="1" width="20%" style="font-size:22px"><strong>聯絡方式:</strong></td>
                <td rowspan="1" colspan="0" width="20%" style="text-align: left;">研究室分機:&nbsp;<input  id="extensionNumber" maxlength="15"></td>
            </tr>
            <tr style="text-align: center;">
                <td rowspan="1" colspan="0" width="20%" style="text-align: left;">手機:&nbsp;<input  id="cellphoneNumber" maxlength="15" ></td>
            </tr>
            <tr style="text-align: center;">
                <td rowspan="1" colspan="0" width="20%" style="text-align: left;">E-mail:&nbsp;<input  id="emailAddress" maxlength="40"  ></td>
            </tr>
<%--           ^^ personal data--%>
            <tr style="text-align:center;background:  #C0C0C0 ">
                <td rowspan="1"  width="50%" ><strong style="font-size:22px">學&nbsp;術&nbsp;論&nbsp;著</strong><br>(請參照附表一)</td>
                <td rowspan="1"  width="50%"><strong>請於表A「論文績效說明表」檢附相關資訊</strong></td>
            </tr>
            <tr style="text-align: center;">
                <td rowspan="2" colspan="1" width="20%" style="background:  #C0C0C0 ">Scopus/WOS 資料庫</td>
                <td colspan="2" width="20%" style="text-align: left;"><strong>篇數: <input id="SWArticleCountOne" maxlength="5"></strong></td>
            </tr>
            <tr style="text-align: center;">
                <td colspan="2" width="20%" style="text-align: left;"><strong>點數小計:  <input id="SWPointOne" maxlength="5"></strong></td>
            </tr>

            <tr style="text-align: center;">
                <td rowspan="1"  width="20%">申請人如於近5年內發表之論文篇數達15篇（含）以上<br>（5年內曾刊登於本校優質期刊清單者不在此限），於SciVal資料庫中近五年FWCI值<br> ，若為本校近五年FWCI值之倍數加計獎金對應表如下：
                    <br>
                    <table align="center" style="text-align: center; border:1px #cccccc solid;border-collapse: collapse; min-width: 60px" cellpadding="10" border='1'>
                        <tr>
                            <td rowspan="1" colspan="2" width="20%">倍數</td>
                            <td rowspan="1" colspan="2" width="20%">1.1-1.3</td>
                            <td rowspan="1" colspan="2" width="20%">1.3-1.5</td>
                            <td rowspan="1" colspan="2" width="20%">1.5-1.8</td>
                            <td rowspan="1" colspan="2" width="20%">1.8-2.2</td>
                            <td rowspan="1" colspan="2" width="20%">2.2以上</td>
                        </tr>
                        <tr>
                            <td rowspan="1" colspan="2" width="20%">加計獎金(元)<br><span style="font-style:normal; font-size: 12px;">(依年底預算浮動)</span></td>
                            <td rowspan="1" colspan="2" width="10%" id="UnderOnePointThreePrize"></td>
                            <td rowspan="1" colspan="2" width="10%" id="UnderOnePointFivePrize" ></td>
                            <td rowspan="1" colspan="2" width="10%" id="UnderOnePointEightPrize"></td>
                            <td rowspan="1" colspan="2" width="10%" id="UnderTwoPointTwoPrize"></td>
                            <td rowspan="1" colspan="2" width="10%" id="OverTwoPointTwoPrize"></td>
                        </tr>
                    </table>

                </td>
                <td rowspan="1"  width="20%">
                    申請人近5年(2015-2019)FWCI值:&nbsp;<input id="FWCIValueOfUser" maxlength="40" oninput="calculatePrize()"><br> 為本校近五年(2015-2019)FWCI值 <span id="FWCIValueOfNTUT"></span>之&nbsp;
                    <span id="FWCIValueOfUserDivideNTUT"></span>倍<br> 加計獎金(請對照左表)：&nbsp;
                    <span id="FWCIPrize"></span>元

                </td>
            </tr>
            <tr style="text-align: left; ">
                <td rowspan="1 " colspan="6 " width="100% " style="font-weight: bold; ">
                    <input type="checkbox" id="TeacherFormCheck"><span style="color: #ff0000">申請人聲明&nbsp;&nbsp;&nbsp;充分了解申請要點，且以上所填各項資料與勾選事項皆確實無誤，若有不實本人願負擔所有法律及行政責任</span>
                    <br><br><br>
                    日期:<input type="date" id="CommitDate">

                </td>
            </tr>


            <tr>
                <td colspan="6" style="background-color:rgb(255, 255, 240);text-align: center">
                    <button type="button" width="10%" onclick="javascript:location.href='SunshineScholarshipCatalog'">回上頁</button>
                    <button type="button" width="10%" onclick="commit()">存檔</button>
                </td>
            </tr>
            </tbody>
        </table>
<%--        <br>※ 本案業經<strong>系所評審委員會</strong>審議通過（請檢附<strong>會議記錄</strong>）--%>
    </form >
</body>
</html>

<style type="text/css">
    .innerinput{
        border-style:none;
        text-align: left;
        font-size:13px;
    }
</style>
<script>
    $( document ).ready(function() {
        loadPersonalData();
        loadFWCIPrizeData();
        loadFWCIInputData();//code smell: need load ntutfwcivalue first ,the dependancy

    })


    function loadPersonalData(){
        $("#chineseName").val("<%=json.optString("chineseName","")%>");
        $("#englishName").val("<%=json.optString("englishName","")%>");
        $("#nationalIDNumber").val("<%=json.optString("nationalIDNumber","")%>");
        $("#department").val("<%=json.optString("department","")%>");
        $("#titles").val("<%=json.optString("titles","")%>");
        $("#titles").trigger("change");  //check if ResignedMember
        $("#levels").val("<%=json.optString("levels","")%>");
        $("#resignedTime").val("<%=json.optString("resignedTime","")%>");
        $("#extensionNumber").val("<%=json.optString("extensionNumber","")%>");
        $("#cellphoneNumber").val("<%=json.optString("cellphoneNumber","")%>");
        $("#emailAddress").val("<%=json.optString("emailAddress","")%>");

    }

    function loadFWCIInputData(){
        //from sunshine_scholarship_award_fwci_user_input
        $("#SWArticleCountOne").val("<%=json.optString("swArticleCountOne","")%>");
        $("#SWPointOne").val("<%=json.optString("swPointOne","")%>");
        $('#FWCIValueOfUser').prop('value', "<%=json.optString("fwciValueOfUser","")%>");
        $('#FWCIValueOfUser').trigger("input");
        $("#TeacherFormCheck").prop("checked","<%=json.optBoolean("teacherFormCheck",false)%>");
        $("#CommitDate").val("<%=json.optString("commitDate","")%>");



    }

    function loadFWCIPrizeData(){
        //from sunshine_scholarship_award_fwci_prize
        $("#UnderOnePointThreePrize").html("<%=json.optString("UnderOnePointThreePrize","")%>");
        $("#UnderOnePointFivePrize").html("<%=json.optString("UnderOnePointFivePrize","")%>");
        $("#UnderOnePointEightPrize").html("<%=json.optString("UnderOnePointEightPrize","")%>");
        $("#UnderTwoPointTwoPrize").html("<%=json.optString("UnderTwoPointTwoPrize","")%>");
        $("#OverTwoPointTwoPrize").html("<%=json.optString("OverTwoPointTwoPrize","")%>");
        // $("#FWCIValueOfNTUT").html("");
        console.log("loadFWCIPrizeData");

    }

    function commit(){
        $.ajax({
            type: 'POST',
            url: '/SelectInformation',
            dataType: 'text',
            data: JSON.stringify(InputToJson()),
            contentType: 'application/json',
            success: function(data){
                // alert(data.status);
                alert("存檔成功");
                window.location.href="SelectInformation";
            }
        });

    };

    function InputToJson(){
        var data = {};
        for (var j=0; j<document.getElementsByTagName("input").length; j++) {
            if (document.getElementsByTagName("input")[j].type=='checkbox'){
                if(document.getElementsByTagName("input")[j].checked == false){
                    continue;
                }
                else {
                    data[document.getElementsByTagName("input")[j].id] = document.getElementsByTagName("input")[j].checked;
                }
            }else {
                data[document.getElementsByTagName("input")[j].id] = document.getElementsByTagName("input")[j].value;
            }
        }
        for (var j=0; j<document.getElementsByTagName("select").length; j++){
            data[ document.getElementsByTagName("select")[j].id] = document.getElementsByTagName("select")[j].value;
        }
        console.log("dataRdyToBE:", data);
        return data;
    }

    function changeFunc() {
        var selectBox = document.getElementById("titles");
        var selectedValue = selectBox.options[selectBox.selectedIndex].value;
        console.log("changeFunc");
        if (selectedValue === "ResignedMember") {
            var result_style = document.getElementById("ResignedMemberInput").style;
            result_style.display = "block";
        } else {
            var result_style = document.getElementById("ResignedMemberInput").style;
            result_style.display = "none";
        }
    }

    function calculatePrize(){

        var FWCIValueofntut = ${fwci};
        var FWCIValueofuser = document.getElementById("FWCIValueOfUser").value;
        var multiple = roundDecimal(FloatDiv(FWCIValueofuser,FWCIValueofntut),2).toString();

        document.getElementById("FWCIValueOfUserDivideNTUT").innerHTML =  multiple;
        document.getElementById("FWCIPrize").innerHTML = getPrize(multiple);

        // console.log("user:",FWCIValueofuser,"ntut:",FWCIValueofntut,"multiple:",multiple,"FWCIPrize:",getPrize(multiple))
    }
    function getPrize(multiple){
        var prize = "";

        if(parseFloat(multiple)>parseFloat("2.2")){
            prize = "26000";
        }
        else if (parseFloat(multiple)>parseFloat("1.8") && parseFloat(multiple)<=parseFloat("2.2")){
            prize = "22000";
        }
        else if (parseFloat(multiple)>parseFloat("1.5") && parseFloat(multiple)<=parseFloat("1.8")){
            prize = "18000";
        }
        else if (parseFloat(multiple)>parseFloat("1.3") && parseFloat(multiple)<=parseFloat("1.5")){
            prize = "14000";
        }
        else if (parseFloat(multiple)>parseFloat("1.1") && parseFloat(multiple)<=parseFloat("1.3")){
            prize = "10000";
        }
        else {
            prize = "0";
        }
        return prize;
    }


    function FloatDiv(arg1, arg2){
        var t1 = 0, t2 = 0, r1, r2;
        try { t1 = arg1.toString().split(".")[1].length } catch (e) { }
        try { t2 = arg2.toString().split(".")[1].length } catch (e) { }

        r1 = Number(arg1.toString().replace(".", ""))
        r2 = Number(arg2.toString().replace(".", ""))
        return (r1 / r2) * Math.pow(10, t2 - t1);

    }

    var roundDecimal = function (val, precision) {
        return Math.round(Math.round(val * Math.pow(10, (precision || 0) + 1)) / 10) / Math.pow(10, (precision || 0));
    }

</script>