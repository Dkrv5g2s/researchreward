<%--
  Created by IntelliJ IDEA.
  User: Ted Lin
  Date: 2021/1/24
  Time: 下午 04:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");
%>

<html>
<head>
    <title>陽光獎助金論文 教職研人員 學術論著及FWCI計算 </title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <link rel="stylesheet" type="text/css" href="/css/body.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<p style="text-align:center;font-weight:bold;font-size:20px;clear:none;">陽光獎助金論文 教職研人員 學術論著及FWCI計算</p>

    <table border="1" cellpadding="5" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
        <tbody>

        <!-- 大列1 -->
        <tr style="text-align:center;background:  #C0C0C0 ">
            <td rowspan="1" colspan="3" width="50%"><strong style="font-size:22px">學&nbsp;術&nbsp;論&nbsp;著</strong><br>(請參照附表一)</td>
            <td rowspan="1" colspan="2" width="50%"><strong>請於表A「論文」績效說明表檢附資訊</strong></td>
        </tr>
        <!-- 大列2 -->
        <tr style="text-align: center;">
            <td rowspan="2" colspan="1" width="20%" style="background:  #C0C0C0 ">Scopus/WOS 資料庫</td>
            <td colspan="2" width="20%"><strong>篇數: </strong></td>
            <td colspan="2" width="20%"><input name="sw_article_count_one" maxlength="5"></td>

        </tr>
        <tr style="text-align: center;">
            <td colspan="2" width="20%"><strong>點數小計:  </strong></td>
            <td colspan="2" width="20%"><input name="sw_article_count_one" maxlength="5"></td>
        </tr>
        <!-- 大列5 -->
        <tr style="text-align: center;">
            <td rowspan="1" colspan="3" width="20%">申請人如於近5年內發表之論文篇數達15篇（含）以上<br>（5年內曾刊登於本校優質期刊清單者不在此限），於SciVal資料庫中近五年FWCI值<br> ，若為本校近五年FWCI值之倍數加計獎金對應表如下：
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
                        <td rowspan="1" colspan="2" width="10%" id="UnderOnePointTwoPrize"></td>
                        <td rowspan="1" colspan="2" width="10%" id="OverTwoPointTwoPrize"></td>
                    </tr>
                </table>

            </td>
            <td rowspan="1" colspan="3" width="20%">
                申請人近5年(2015-2019)FWCI值:&nbsp;<input name="applicant" value="" size="10" maxlength="40"><br> 為本校近五年(2015-2019)FWCI值 <span id="ntut_fwci_value"></span>之&nbsp;
                <input name="applicant" value="" size="10" maxlength="40">倍<br> 加計獎金(請對照左表)：&nbsp;
                <input name="applicant" width="50%" value="" size="10" maxlength="40">元

            </td>
        </tr>
        <!-- 大列6 -->
        <tr style="text-align: left; ">
            <td rowspan="1 " colspan="6 " width="100% " style="font-weight: bold; ">
                <input type="checkbox" name="check_one ">申請人聲明&nbsp;&nbsp;&nbsp;充分了解申請要點，且以上所填各項資料與勾選事項皆確實無誤，若有不實本人願負擔所有法律及行政責任
                <br><br><br> 申請人簽章:
                <input type="text" name="check_one "> 日期:<input type="text" name="check_one ">
                <br>本案業經<strong>系所評審委員會</strong>審議通過（請檢附<strong>會議記錄</strong>）
            </td>
        </tr>
        <tr>
            <td colspan="6" style="background-color:rgb(255, 255, 240);text-align: center">
                <input type="button" width="10%" value="回上頁" name="return_last_page" onclick="javascript:location.href='SunshineScholarshipCatalog'"  >
                <input type="button" width="10%" value="存檔" name="save_the_page"  >
            </td>
        </tr>
        </tbody>
    </table>


</body>
</html>

<script>
    function commit(){
        $.ajax({
            type: 'POST',
            url: '/PaperInforamationOfStaff',
            dataType: 'text',
            data: JSON.stringify(InputToJson()),
            contentType: 'application/json',
            success: function(data){
                alert("存檔成功");
                window.location.href="SelectInformation";
            }
        });

    };

    function InputToJson(){
        var data = {};
        for (var j=0; j<document.getElementsByTagName("input").length; j++) {
            if (document.getElementsByTagName("input")[j].type=='checkbox' && document.getElementsByTagName("input")[j].checked == false){
                continue;
            }else {
                data[ document.getElementsByTagName("input")[j].id] = document.getElementsByTagName("input")[j].value;
            }

        }
        for (var j=0; j<document.getElementsByTagName("select").length; j++){
            data[ document.getElementsByTagName("select")[j].id] = document.getElementsByTagName("select")[j].value;
        }
        // console.log("data is :", data);
        return data;
    }


    $( document ).ready(function() {

        $("#chineseName").val("<%=json.optString("chinese_name","")%>");
        $("#englishName").val("<%=json.optString("english_name","")%>");
        $("#nationalIDNumber").val("<%=json.optString("national_ID_number","")%>");
        $("#department").val("<%=json.optString("department","")%>");
        $("#titles").val("<%=json.optString("titles","")%>");
        $("#titles").trigger("change");  //check if ResignedMember

        $("#levels").val("<%=json.optString("levels","")%>");
        $("#ResignedTime").val("<%=json.optString("resigned_time","")%>");
        $("#extensionNumber").val("<%=json.optString("extension_number","")%>");
        $("#cellphoneNumber").val("<%=json.optString("cellphone_number","")%>");
        $("#emailAddress").val("<%=json.optString("email_address","")%>");
        console.log("init");

        $("#UnderOnePointThreePrize").val("<%=json.optString("under_one_point_three_prize","")%>");
        $("#UnderOnePointFivePrize").val("<%=json.optString("under_one_point_five_prize","")%>");
        $("#UnderOnePointEightPrize").val("<%=json.optString("under_one_point_eight_prize","")%>");
        $("#UnderOnePointTwoPrize").val("<%=json.optString("under_two_point_two_prize","")%>");
        $("#OverTwoPointTwoPrize").val("<%=json.optString("over_two_point_two_prize","")%>");
        $("#FWCIValue").val("<%=json.optString("ntut_fwci_value","")%>");

    })



</script>