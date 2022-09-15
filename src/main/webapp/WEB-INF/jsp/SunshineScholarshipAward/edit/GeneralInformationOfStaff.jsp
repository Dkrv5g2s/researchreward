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
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
    <link rel="stylesheet" type="text/css" href="css/body.css">
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
                <td rowspan="3" colspan="4" width="20%" style="font-size:22px"><span class="requiredField">✱</span><strong>申請人姓名</strong></td>
                <td colspan="2" width="10%" style="text-align: left;">中文:&nbsp;<input  id="chineseName" maxlength="40" ></td>
            </tr>
            <tr style="text-align: left;">
                <td colspan="2" width="10%">英文:&nbsp;<input  id="englishName" maxlength="40" ></td>
            </tr>
            <tr style="text-align: left;">
                <td colspan="2" width="10%">身分證字號(ARC No.):&nbsp;<input  id="nationalIDNumber" maxlength="40" ></td>
            </tr>
            <!-- 大列2 -->
            <tr style="text-align: center;">
                <td rowspan="1" colspan="4" width="20%" style="font-size:22px"><span class="requiredField">✱</span><strong>單位(系所):</strong></td>
                <td rowspan="1" colspan="2" width="38%" style="font-size:22px;text-align: left;"><input  id="department" maxlength="40" ></td>
            </tr>


            <!-- 大列3 -->
            <tr style="text-align: center;" id="FacultyTr">
                <td rowspan="1" colspan="4" width="20%" style="font-size:22px">
                    <span class="requiredField">✱</span><strong>教職員<br>職&nbsp;&nbsp;&nbsp;稱</strong></td>
                <td rowspan="1" colspan="2" width="20%" style="font-size:13px;text-align: left;" id="FacultyTable">
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
                <td rowspan="3" colspan="4" width="20%" style="font-size:22px"><span class="requiredField">✱</span><strong>聯絡方式:</strong></td>
                <td rowspan="1" colspan="2" width="20%" style="text-align: left;">研究室分機:&nbsp;<input  id="extensionNumber" maxlength="15"></td>
            </tr>

            <tr style="text-align: center;">
                <td rowspan="1" colspan="2" width="20%" style="text-align: left;">手機:&nbsp;<input  id="cellphoneNumber" maxlength="15" ></td>
            </tr>
            <tr style="text-align: center;">
                <td rowspan="1" colspan="2" width="20%" style="text-align: left;">E-mail:&nbsp;<input  id="emailAddress" maxlength="40"  ></td>
            </tr>
            <!-- 大列5 -->
            <tr style="text-align:center;background:  #C0C0C0 ">
                <td rowspan="1" colspan="4" width="50%" ><strong style="font-size:22px">學&nbsp;術&nbsp;論&nbsp;著</strong><br>(請參照附表一)</td>
                <td rowspan="1" colspan="2" width="50%"><strong>請於表A「論文績效說明表」檢附相關資訊</strong></td>
            </tr>
            <!-- 大列6 -->
            <tr style="text-align: center;">
                <td rowspan="2" colspan="4" width="20%" style="background:  #C0C0C0 ">Scopus/WOS 資料庫</td>
                <td colspan="2"  width="20%" style="text-align: left;"><span class="requiredField">✱</span><strong>篇數: <input id="SWArticleCountOne" maxlength="5"></strong></td>
            </tr>
            <tr style="text-align: center;">
                <td colspan="2" width="20%" style="text-align: left;"><span class="requiredField">✱</span><strong>點數小計:  <input id="SWPointOne" maxlength="5"></strong></td>
            </tr>
            <!-- 大列7 -->
            <tr style="text-align: center;">
                <td rowspan="1" colspan="6"  width="20%">
                    <p align="left">申請人於SciVal資料庫中近五年FWCI值及h-5指數，若為本校近五年FWCI值及h-5指數之倍數，擇最優一項加計獎金，對應表如下：</p>
                    <br>
                    <table align="center" style="text-align: center; border:1px #cccccc solid;border-collapse: collapse; min-width: 60px" cellpadding="10" border='1'>
                        <tr>
                            <td rowspan="1" colspan="2" width="20%">FWCI倍數</td>
                            <td rowspan="1" colspan="2" width="20%">1.1-1.3(不含)</td>
                            <td rowspan="1" colspan="2" width="20%">1.3-1.5(不含)</td>
                            <td rowspan="1" colspan="2" width="20%">1.5-1.8(不含)</td>
                            <td rowspan="1" colspan="2" width="20%">1.8-2.2(不含)</td>
                            <td rowspan="1" colspan="2" width="20%">2.2以上</td>
                        </tr>
                        <tr>
                            <td rowspan="1" colspan="2" width="20%">h-5指數之倍數</td>
                            <td rowspan="1" colspan="2" width="20%">0.10-0.15(不含)</td>
                            <td rowspan="1" colspan="2" width="20%">0.15-0.25(不含)</td>
                            <td rowspan="1" colspan="2" width="20%">0.25-0.40(不含)</td>
                            <td rowspan="1" colspan="2" width="20%">0.40-0.55(不含)</td>
                            <td rowspan="1" colspan="2" width="20%">0.55以上</td>
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
                    <br>
                    <p align="left">申請人近5年FWCI值:&nbsp;<input id="FWCIValueOfUser" maxlength="40" oninput="calculatePrize()">&nbsp;
                    為本校近五年FWCI值<span >${fwci}</span>之<span id="FWCIValueOfUserDivideNTUT"></span>倍。<br></p>
                    <p align="left">申請人h-5指數:&nbsp;<input id="h5IndexOfUser" maxlength="40" oninput="calculatePrize()">&nbsp;
                    為本校近五年h-5指數<span >${h5Index}</span>之<span id="h5IndexOfUserDivideNTUT"></span>倍。<br></p>

                    <p align="left">上述兩者擇最優一項，加計獎金：&nbsp;<span id="FWCIPrize"></span>元</p>
                </td>
            </tr>
            <!-- 大列8 -->
            <tr style="text-align: left; ">
                <td rowspan="1 " colspan="6" width="100% " style="font-weight: bold; ">
                    <input type="checkbox" id="TeacherFormCheck"><span style="color: #ff0000">申請人聲明&nbsp;&nbsp;&nbsp;充分了解申請要點，且以上所填各項資料與勾選事項皆確實無誤，若有不實本人願負擔所有法律及行政責任</span>
                    <br><br><br>
                    日期:<input type="date" id="CommitDate">

                </td>
            </tr>
            <tr  style="text-align: center; font-size:22px ">
                <td width="33%" colspan="2" style="font-weight: bold; ">
                    系、所&nbsp;(簽章)
                </td>
                <td width="33%" colspan="2" style="font-weight: bold; ">
                    學&nbsp;院&nbsp;(簽章)
                </td>
                <td width="33%" colspan="2" style="font-weight: bold; ">
                    研發處(核備)
                </td>
            </tr>
            <tr style="text-align: left; font-size:16px ">
                <td  colspan="2" width="100% ">
                    <br><br><br><br><br><br><br><br><br>本案業經<strong>系所評審委員會</strong>審議通過（請檢附<strong>會議記錄</strong>）
                </td>
                <td  colspan="2" width="100% " style="font-weight: bold; ">
                    <br><br><br><br><br><br><br><br><br>
                </td>
                <td  colspan="2" width="100% " style="font-weight: bold; ">
                    <br><br><br><br><br><br><br><br><br>
                </td>
            </tr>

            <tr>
                <td colspan="6" style="background-color:rgb(255, 255, 240);text-align: center">
                    <button type="button" width="10%" onclick="javascript:location.href='SunshineScholarshipCatalog'">回上頁</button>
                    <button type="button" width="10%" onclick="commit()">暫存</button>
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
    .requiredField {
        color: red;
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
        $('#h5IndexOfUser').prop('value', "<%=json.optString("h5IndexOfUser","")%>");
        $('#h5IndexOfUser').trigger("input");


    }

    function loadFWCIPrizeData(){
        //from sunshine_scholarship_award_fwci_prize
        $("#UnderOnePointThreePrize").html("<%=json.optString("UnderOnePointThreePrize","")%>");
        $("#UnderOnePointFivePrize").html("<%=json.optString("UnderOnePointFivePrize","")%>");
        $("#UnderOnePointEightPrize").html("<%=json.optString("UnderOnePointEightPrize","")%>");
        $("#UnderTwoPointTwoPrize").html("<%=json.optString("UnderTwoPointTwoPrize","")%>");
        $("#OverTwoPointTwoPrize").html("<%=json.optString("OverTwoPointTwoPrize","")%>");
        console.log("loadFWCIPrizeData");
    }

    function commit(){
        if ($("#chineseName").val() && $("#englishName").val() && $("#nationalIDNumber").val() && $("#department").val() && $("#titles").val()
            && (!($("#titles").val() == "ResignedMember") || $("#resignedTime").val())
            && $("#levels").val() && $("#extensionNumber").val() && $("#cellphoneNumber").val() && $("#emailAddress").val() && $("#SWArticleCountOne").val()
            && $("#SWPointOne").val() && $("#TeacherFormCheck").prop("checked")) {
            $.ajax({
                type: 'POST',
                url: 'SunshineScholarshipAwardGeneralInformation',
                dataType: 'text',
                data: JSON.stringify(InputToJson()),
                contentType: 'application/json',
                success: function(data){
                    // alert(data.status);
                    alert("存檔成功");
                    window.location.href="SunshineScholarshipAwardGeneralInformation";
                }
            });
        }
        else {
            alert("尚未填寫完成!");
        }
    }

    function InputToJson(){
        let data = {};
        let dataNumber = 0;
        const inputList = document.getElementsByTagName("input");


        for (let j=0; j<inputList.length; j++) {
            data[ inputList[j].id] = inputList[j].value;
            if(inputList[j].value.length > 0 && inputList[j].className.length === 0){
                dataNumber++;
            }
        }

        let resignedMemberInputStyle = document.getElementById("ResignedMemberInput").style;
        if(resignedMemberInputStyle.display === "none"){
            // 離職年月欄僅在有出現時需要納入填寫
            data["fill_rate"] = dataNumber/(inputList.length-1);
        }else{
            data["fill_rate"] = dataNumber/(inputList.length);
        }



        for (let j=0; j<document.getElementsByTagName("input").length; j++) {
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
        var multipleofFWCI = roundDecimal(FloatDiv(FWCIValueofuser,FWCIValueofntut),2).toString();

        var h5Indexofntut = ${h5Index};
        var h5Indexofuser = document.getElementById("h5IndexOfUser").value;
        var multipleofh5 = roundDecimal(FloatDiv(h5Indexofuser,h5Indexofntut),2).toString();

        document.getElementById("FWCIValueOfUserDivideNTUT").innerHTML =  multipleofFWCI;
        document.getElementById("h5IndexOfUserDivideNTUT").innerHTML =  multipleofh5;
        let betterAmount = getPrizeByFWCIMultiple(multipleofFWCI) >= getPrizeByh5Multiple(multipleofh5) ? getPrizeByFWCIMultiple(multipleofFWCI) :getPrizeByh5Multiple(multipleofh5);
        document.getElementById("FWCIPrize").innerHTML = betterAmount;

        console.log("FWCIuser:",FWCIValueofuser,"ntut:",FWCIValueofntut,"multiple:",multipleofFWCI,"FWCIPrize:",getPrizeByFWCIMultiple(multipleofFWCI))
        console.log("h5user:",h5Indexofuser,"ntut:",h5Indexofntut,"multiple:",multipleofh5,"FWCIPrize:",getPrizeByh5Multiple(multipleofh5))
    }
    function getPrizeByFWCIMultiple(multiple){
        var prize = "";

        if(parseFloat(multiple)>=parseFloat("2.2")){
            prize = "26000";
        }
        else if (parseFloat(multiple)>=parseFloat("1.8") && parseFloat(multiple)<parseFloat("2.2")){
            prize = "22000";
        }
        else if (parseFloat(multiple)>=parseFloat("1.5") && parseFloat(multiple)<parseFloat("1.8")){
            prize = "18000";
        }
        else if (parseFloat(multiple)>=parseFloat("1.3") && parseFloat(multiple)<parseFloat("1.5")){
            prize = "14000";
        }
        else if (parseFloat(multiple)>=parseFloat("1.1") && parseFloat(multiple)<parseFloat("1.3")){
            prize = "10000";
        }
        else {
            prize = "0";
        }
        return prize;
    }

    function getPrizeByh5Multiple(multiple){
        var prize = "";

        if(parseFloat(multiple)>=parseFloat("0.55")){
            prize = "26000";
        }
        else if (parseFloat(multiple)>=parseFloat("0.40") && parseFloat(multiple)<parseFloat("0.55")){
            prize = "22000";
        }
        else if (parseFloat(multiple)>=parseFloat("0.25") && parseFloat(multiple)<parseFloat("0.40")){
            prize = "18000";
        }
        else if (parseFloat(multiple)>=parseFloat("0.15") && parseFloat(multiple)<parseFloat("0.25")){
            prize = "14000";
        }
        else if (parseFloat(multiple)>=parseFloat("0.10") && parseFloat(multiple)<parseFloat("0.15")){
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