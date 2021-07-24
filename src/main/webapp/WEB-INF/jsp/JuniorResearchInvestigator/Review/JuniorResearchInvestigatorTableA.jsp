
<%--
  Created by IntelliJ IDEA.
  User: Sandy
  Date: 2021/1/24
  Time: 下午 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("data");
%>
<html>
<head>
    <title>年輕學者研究獎 近三年內發表之期刊論文統計表</title>

    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.14.1/moment.min.js"></script>

    <style type="text/css">
        div.content{
            width:80%;
        }
        tr{
            text-align:center;
        }
        .file_title{
            text-align: center;
            font-size: 24px;
            font-weight: bold;
        }
        .title{
            background:#C0C0C0;
            font-size: 16px;
        }
        .left{
            text-align: left;
        }
        .auto{
            width: auto;
            height: auto;
        }
        .total_point{
            font-weight: bold;
        }
        .sign{
            vertical-align: top;
            text-align: left;
            width: 200px;
            height: 80px;"
        }
    </style>
</head>
<body>
<div class="content">
    <form>
        <p class="file_title">年輕學者研究獎 近三年內發表之期刊論文統計表</p>
        <table>
            <tbody>
            <tr class="title">
                <td rowspan="2" colspan="3">學術論著</td>
                <td colspan="3">年度</td>
                <td rowspan="2"><b>小計<br>(A)</b></td>
            </tr>
            <tr class="title">
                <td><label id="year1"><%=json.get("year1")%></label></td>
                <td><label id="year2"><%=json.get("year2")%></label></td>
                <td><label id="year3"><%=json.get("year3")%></label></td>
            </tr>
            <tr class="count">
                <td rowspan="3">Scopus 或 WOS 資料庫</td>
                <td colspan="2">篇數</td>
                <td><label name="sw_article_count1" class="ic1"><%=json.optString("sw_article_count1", "0")%></label></td>
                <td><label name="sw_article_count2" class="ic2"><%=json.optString("sw_article_count2", "0")%></label></td>
                <td><label name="sw_article_count3" class="ic3"><%=json.optString("sw_article_count3", "0")%></label></td>
                <td id="sw_article_count_total" class="total_count"><%=json.optString("sw_article_count_total", "0")%></td>
            </tr>
            <tr class="count">
                <td colspan="2"><b>點數</b><br>(請參照 <a href="https://rnd.ntut.edu.tw/var/file/42/1042/img/214/488059897.pdf" target="_blank">附表一</a> )</td>
                <td><label id="sw_point1" name="sw_point1" class="ic1"><%=json.optString("sw_point1", "0")%></label></td>
                <td><label id="sw_point2" name="sw_point2" class="ic2"><%=json.optString("sw_point2", "0")%></label></td>
                <td><label id="sw_point3" name="sw_point3" class="ic3"><%=json.optString("sw_point3", "0")%></label></td>
                <td id="sw_point_total" class="total_count total_point"><%=json.optString("sw_point_total", "0")%></td>
            </tr>
            <tr>
                <td colspan="6">
                    <p>說明：論文請檢附-「傑出論文績效說明表」</p>
                </td>
            </tr>

            <tr class="count1">
                <td rowspan="2" >TSSCI/THCI (限設計及人社學院)</td>
                <td colspan="2">篇數</td>
                <td><label name="t_article_count1" class="ic1" maxlength="3"><%=json.optString("t_article_count1", "0")%></label></td>
                <td><label name="t_article_count2" class="ic2" maxlength="3"><%=json.optString("t_article_count2", "0")%></label></td>
                <td><label name="t_article_count3" class="ic3" maxlength="3"><%=json.optString("t_article_count3", "0")%></label></td>
                <td id="t_article_count_total" class="total_count"><%=json.optString("t_article_count_total","0")%></td>
            </tr>
            <tr class="point">
                <td colspan="2"><b>點數</b><br>(2點/篇)</td>
                <td id="t_point1" class="pc1" ><%=json.optString("t_point1","0")%></td>
                <td id="t_point2" class="pc2" ><%=json.optString("t_point2","0")%></td>
                <td id="t_point3" class="pc3"><%=json.optString("t_point3","0")%></td>
                <td id="t_point_total" class="total_point"><%=json.optString("t_point_total","0")%></td>
            </tr>
            <tr class="count2">
                <td rowspan="2" >人文、設計、藝術或社會之學術專書</td>
                <td colspan="2">冊數</td>
                <td><label name="a_book_count1" class="ic1"><%=json.optString("a_book_count1","0")%></label></td>
                <td><label name="a_book_count2" class="ic2"><%=json.optString("a_book_count2","0")%></label></td>
                <td><label name="a_book_count3" class="ic3"><%=json.optString("a_book_count3","0")%></label></td>
                <td id="a_book_count_total" class="total_count"><%=json.optString("a_book_count_total","0")%></td>
            </tr>
            <tr class="point">
                <td colspan="2"><b>點數</b><br>(6點/冊)</td>
                <td id="a_book_point1" class="pc1"><%=json.optString("a_book_point1","0")%></td>
                <td id="a_book_point2" class="pc2"><%=json.optString("a_book_point2","0")%></td>
                <td id="a_book_point3" class="pc3"><%=json.optString("a_book_point3","0")%></td>
                <td id="a_book_point_total" class="total_point"><%=json.optString("a_book_point_total","0")%></td>
            </tr>
            <tr class="count1">
                <td rowspan="2" >人文、設計、藝術或社會之學術專書單篇(章)</td>
                <td colspan="2">篇數</td>
                <td><label name="a_article_count1" class="ic1"><%=json.optString("a_article_count1","0")%></label></td>
                <td><label name="a_article_count2" class="ic2"><%=json.optString("a_article_count2","0")%></label></td>
                <td><label name="a_article_count3" class="ic3"><%=json.optString("a_article_count3","0")%></label></td>
                <td id="a_article_count_total" class="total_count"><%=json.optString("a_article_count_total","0")%></td>
            </tr>
            <tr class="point">
                <td colspan="2"><b>點數</b><br>(2點/篇)</td>
                <td id="a_article_point1" class="pc1"><%=json.optString("a_article_point1","0")%></td>
                <td id="a_article_point2" class="pc2"><%=json.optString("a_article_point2","0")%></td>
                <td id="a_article_point3" class="pc3"><%=json.optString("a_article_point3","0")%></td>
                <td id="a_article_point_total" class="total_point"><%=json.optString("a_article_point_total","0")%></td>
            </tr>
            <tr class="count4">
                <td colspan="3" >
                    <p align="left">申請人於SciVal資料庫中近三年FWCI值及h-5指數，若為本校近三年FWCI值及h-5指數之倍數，擇最優一項加計點數，對應表如下：</p>
                    <br>
                    <table style="border:1px #cccccc solid;border-collapse: collapse; min-width: 60px" cellpadding="10" border='1'>
                        <tr>
                            <td colspan="2">FWCI之倍數</td>
                            <td colspan="2">1.1-1.3(不含)</td>
                            <td colspan="2">1.3-1.5(不含)</td>
                            <td colspan="2">1.5-1.8(不含)</td>
                            <td colspan="2">1.8-2.2(不含)</td>
                            <td colspan="2">2.2以上</td>
                        </tr>
                        <tr>
                            <td colspan="2">h-5指數之倍數</td>
                            <td colspan="2">0.10-0.15(不含)</td>
                            <td colspan="2">0.15-0.25(不含)</td>
                            <td colspan="2">0.25-0.40(不含)</td>
                            <td colspan="2">0.40-0.55(不含)</td>
                            <td colspan="2">0.55以上</td>
                        </tr>
                        <tr>
                            <td colspan="2">加計點數</td>
                            <td colspan="2">6</td>
                            <td colspan="2">8</td>
                            <td colspan="2">10</td>
                            <td colspan="2">13</td>
                            <td colspan="2">15</td>
                        </tr>
                    </table>
                    <p align="left">申請人近3年FWCI值：<label id="fwci_value"><%=json.get("fwci_value")%></label>
                        為本校近三年FWCI值<span>${fwci}</span>之<span id="FWCIValueOfUserDivideNTUT"></span>倍。</p>
                    <p align="left">申請人h-5指數：<label id="h5_index"><%=json.get("h5_index")%></label>
                        為本校h-5指數<span>${h5Index}</span>之<span id="h5IndexOfUserDivideNTUT"></span>倍。</p>

                    <p align="left">上述兩者擇最優一項，加計點數：<span id="pointB" class="total_point"></span>點(B)。</p>

                </td>
                <td colspan="2">總計點數 (A)+(B)</td>
                <td colspan="2" id="a_plus_b_total_point" class="total_point"><%=json.get("a_plus_b_total_point")%></td>
            </tr>
            <tr>
                <td colspan="7" align="left">
                    說明：
                    <ol>
                        <li>近三年以本校名義發表之學術論著（此段期間曾生產或請育嬰假者得以延長，其延長期限依實際請假時間為依據，並檢附相關證明文件）始得採計。</li>
                        <li>論文之期刊排名以出版年度為準，若無該出版年資料，則以前一年度為準。</li>
                        <li>每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書。</li>
                    </ol>
                </td>
            </tr>

            <tr class="title">
                <td rowspan="2" colspan="3">科 技 部 計 畫<br>(不包含科技部產學合作計畫)</td>
                <td colspan="3">年度</td>
                <td rowspan="2"><b>小計</b></td>
            </tr>
            <tr class="title">
                <td><label id="year1"><%=json.get("year1")%></label></td>
                <td><label id="year2"><%=json.get("year2")%></label></td>
                <td><label id="year3"><%=json.get("year3")%></label></td>
            </tr>
            <tr class="count">
                <td rowspan="3" >近三年以本校名義主持科技部各類型計畫統計表</td>
                <td colspan="2">件數</td>
                <td><label name="tech_project_count1" class="ic1"><%=json.optString("tech_project_count1","0")%></label></td>
                <td><label name="tech_project_count2" class="ic2"><%=json.optString("tech_project_count2","0")%></label></td>
                <td><label name="tech_project_count3" class="ic3"><%=json.optString("tech_project_count3","0")%></label></td>
                <td id="tech_project_count_total" class="total_count"><%=json.optString("tech_project_count_total","0")%></td>
            </tr>
            <tr class="project_money1">
                <td colspan="2">計畫金額<br>(萬元)</td>
                <td><label name="tech_project_money1" class="ip1"><%=json.optString("tech_project_money1","0")%></label></td>
                <td><label name="tech_project_money2" class="ip2"><%=json.optString("tech_project_money2","0")%></label></td>
                <td><label name="tech_project_money3" class="ip3"><%=json.optString("tech_project_money3","0")%></label></td>
                <td id="tech_project_money_total" class="total_project_money"><%=json.optString("tech_project_money_total","0")%></td>
            </tr>
            <tr class="point">
                <td colspan="2"><b>點數</b><br>(5點/10萬元)</td>
                <td id="tech_project_point1" class="pc1"><%=json.optString("tech_project_point1","0")%></td>
                <td id="tech_project_point2" class="pc2"><%=json.optString("tech_project_point2","0")%></td>
                <td id="tech_project_point3" class="pc3"><%=json.optString("tech_project_point3","0")%></td>
                <td id="tech_project_point_total" class="total_point"><%=json.optString("tech_project_point_total","0")%></td>
            </tr>

            <tr class="title">
                <td rowspan="2" colspan="3">產 學 合 作 計 畫<br>(不包含以學校名義開授訓練課程招生收入)</td>
                <td colspan="3">年度</td>
                <td rowspan="2"><b>小計</b></td>
            </tr>
            <tr class="title">
                <td><label id="year1"><%=json.get("year1")%></label></td>
                <td><label id="year2"><%=json.get("year2")%></label></td>
                <td><label id="year3"><%=json.get("year3")%></label></td>
            </tr>
            <tr class="count">
                <td rowspan="5" >近三年以本校名義所獲得之產學合作計畫，其實際納入本校校務基金之統計表</td>
                <td colspan="2">件數</td>
                <td><label name="coop_project_count1" class="ic1"><%=json.optString("coop_project_count1","0")%></label></td>
                <td><label name="coop_project_count2" class="ic2"><%=json.optString("coop_project_count2","0")%></label></td>
                <td><label name="coop_project_count3" class="ic3"><%=json.optString("coop_project_count3","0")%></label></td>
                <td id="coop_project_count_total" class="total_count"><%=json.optString("coop_project_count_total","0")%></td>
            </tr>
            <tr class="manage_money1">
                <td colspan="2">管理費<br>(萬元)</td>
                <td><label name="coop_project_management1" class="mp1"><%=json.optString("coop_project_management1","0")%></label></td>
                <td><label name="coop_project_management2" class="mp2"><%=json.optString("coop_project_management2","0")%></label></td>
                <td><label name="coop_project_management3" class="mp3"><%=json.optString("coop_project_management3","0")%></label></td>
                <td id="coop_project_management_total" class="total_manage_money"><%=json.optString("coop_project_management_total","0")%></td>
            </tr>
            <tr class="project_money3">
                <td colspan="2">計畫金額<br>(萬元)</td>
                <td><label name="coop_project_money1" class="ip1"><%=json.optString("coop_project_money1","0")%></label></td>
                <td><label name="coop_project_money2" class="ip2"><%=json.optString("coop_project_money2","0")%></label></td>
                <td><label name="coop_project_money3" class="ip3"><%=json.optString("coop_project_money3","0")%></label></td>
                <td id="coop_project_money_total" class="total_project_money"><%=json.optString("coop_project_money_total","0")%></td>
            </tr>
            <tr class="point">
                <td colspan="2"><b>點數</b><br>(2點/10萬元)</td>
                <td id="coop_project_point1" class="pc1"><%=json.optString("coop_project_point1","0")%></td>
                <td id="coop_project_point2" class="pc2"><%=json.optString("coop_project_point2","0")%></td>
                <td id="coop_project_point3" class="pc3"><%=json.optString("coop_project_point3","0")%></td>
                <td id="coop_project_point_total" class="total_point"><%=json.optString("coop_project_point_total","0")%></td>
            </tr>
            <tr>
                <td colspan="2">產學處<br>(簽章)</td>
                <td colspan="2" class="sign">
                    <p>
                        <label>承辦人</label>
                    </p>
                </td>
                <td colspan="2" style="border-left-style: hidden;" class="sign">
                    <p>
                        <label>單位主管</label>
                    </p>
                </td>
            </tr>

            <tr class="title">
                <td rowspan="2" colspan="3">技 術 移 轉 金<br>(不包含科技部先期技術移轉授權金)</td>
                <td colspan="3">年度</td>
                <td rowspan="2"><b>小計</b></td>
            </tr>
            <tr class="title">
                <td><label id="year1"><%=json.get("year1")%></label></td>
                <td><label id="year2"><%=json.get("year2")%></label></td>
                <td><label id="year3"><%=json.get("year3")%></label></td>
            </tr>
            <tr class="count">
                <td rowspan="5" >近三年以本校名義所獲之實收技術移轉金統計表</td>
                <td colspan="2">件數</td>
                <td><label name="tech_transfer_count1" class="ic1"><%=json.optString("tech_transfer_count1","0")%></label></td>
                <td><label name="tech_transfer_count2" class="ic2"><%=json.optString("tech_transfer_count2","0")%></label></td>
                <td><label name="tech_transfer_count3" class="ic3"><%=json.optString("tech_transfer_count3","0")%></label></td>
                <td id="tech_transfer_count_total" class="total_count"><%=json.optString("tech_transfer_count_total","0")%></td>
            </tr>
            <tr class="manage_money2">
                <td colspan="2">管理費<br>(萬元)</td>
                <td><label name="tech_transfer_management1" class="mp1"><%=json.optString("tech_transfer_management1","0")%></label></td>
                <td><label name="tech_transfer_management2" class="mp2"><%=json.optString("tech_transfer_management2","0")%></label></td>
                <td><label name="tech_transfer_management3" class="mp3"><%=json.optString("tech_transfer_management3","0")%></label></td>
                <td id="tech_transfer_management_total" class="total_manage_money"><%=json.optString("tech_transfer_management_total","0")%></td>
            </tr>
            <tr class="project_money4">
                <td colspan="2">技轉金額<br>(萬元)</td>
                <td><label name="tech_transfer_money1" class="ip1"><%=json.optString("tech_transfer_money1","0")%></label></td>
                <td><label name="tech_transfer_money2" class="ip2"><%=json.optString("tech_transfer_money2","0")%></label></td>
                <td><label name="tech_transfer_money3" class="ip3"><%=json.optString("tech_transfer_money3","0")%></label></td>
                <td id="tech_transfer_money_total" class="total_project_money"><%=json.optString("tech_transfer_money_total","0")%></td>
            </tr>
            <tr class="point">
                <td colspan="2"><b>點數</b><br>(5點/10萬元)</td>
                <td id="tech_transfer_point1" class="pc1"><%=json.optString("tech_transfer_point1","0")%></td>
                <td id="tech_transfer_point2" class="pc2"><%=json.optString("tech_transfer_point2","0")%></td>
                <td id="tech_transfer_point3" class="pc3"><%=json.optString("tech_transfer_point3","0")%></td>
                <td id="tech_transfer_point_total" class="total_point"><%=json.optString("tech_transfer_point_total","0")%></td>
            </tr>
            <tr>
                <td colspan="2">產學處<br>(簽章)</td>
                <td colspan="2" class="sign">
                    <p>
                        <label>承辦人</label>
                    </p>
                </td>
                <td colspan="2" style="border-left-style: hidden;" class="sign">
                    <p>
                        <label>單位主管</label>
                    </p>
                </td>
            </tr>

            <tr>
                <td colspan="7" class="title">
                    <label for="other_data"><b>其 它 傑 出 表 現 說 明</b></label>
                </td>
            </tr>
            <tr>
                <td colspan="7" class="left">
                    <label id="other_data" style="word-break: break-all;"><%=json.optString("other_data", "")%></label>
                </td>
            </tr>
            <tr>
                <td colspan="7" class="left">
                    <p>註：1.論文以當年度紙本刊登為準。2.以本校「教師評鑑及基本資料庫」之資料為準。</p>
                    <p>
                        <input type="checkbox" name="declaration" class="auto" checked disabled="disabled"/>
                        <b><font color="red">申請人聲明&nbsp;充分瞭解申請要點，且以上所填各項資料與勾選事項皆確實無誤，若有不實本人願負擔所有法律及行政責任。</font></b>
                    </p>
                </td>
            </tr>
            </tbody>
        </table>
        <p style="text-align: center;">
            <button type="button" name="return_last_page" onclick="location.href='JuniorResearchInvestigatorCatalog'">回目錄</button>
            <button type="button" name="confirm" onclick="location.href='JuniorResearchInvestigatorTableB'">此頁審查完成</button>
        </p>
    </form>
</div>
<script>
    $(document).ready(function(){
        calculatePoint();
    });

    function calculatePoint(){
        let FWCIValueOfNTUT = "${fwci}";
        let FWCIValueOfUser = document.getElementById("fwci_value").innerHTML;
        let multipleOfFWCI = roundDecimal(FloatDiv(FWCIValueOfUser,FWCIValueOfNTUT),2).toString();

        let h5IndexOfNTUT = "${h5Index}";
        let h5IndexOfUser = document.getElementById("h5_index").innerHTML;
        let multipleOfH5 = roundDecimal(FloatDiv(h5IndexOfUser, h5IndexOfNTUT),2).toString();

        document.getElementById("FWCIValueOfUserDivideNTUT").innerHTML =  multipleOfFWCI;
        document.getElementById("h5IndexOfUserDivideNTUT").innerHTML =  multipleOfH5;

        let pointOfFWCI = getPointByFWCIMultiple(multipleOfFWCI);
        let pointOfH5Index = getPointByh5Multiple(multipleOfH5);
        let betterAmount = parseFloat(pointOfFWCI) >= parseFloat(pointOfH5Index) ? pointOfFWCI :pointOfH5Index;
        document.getElementById("pointB").innerHTML = betterAmount;
        update_A_plus_B();
    }

    function update_A_plus_B(){
        let sw_point_total = parseInt($("#sw_point_total").text());
        let t_point_total = parseInt($("#t_point_total").text());
        let a_book_point_total = parseInt($("#a_book_point_total").text());
        let a_article_point_total = parseInt($("#a_article_point_total").text());
        let betterAmount = parseInt($("#pointB").text());
        let a_plus_b = sw_point_total+t_point_total+a_book_point_total+a_article_point_total+betterAmount;
        $("#a_plus_b_total_point").text(a_plus_b);
    }
    function getPointByFWCIMultiple(multiple){
        let point = "";
        if(parseFloat(multiple)>=parseFloat("2.2")){
            point = "15";
        }
        else if (parseFloat(multiple)>=parseFloat("1.8") && parseFloat(multiple)<parseFloat("2.2")){
            point = "13";
        }
        else if (parseFloat(multiple)>=parseFloat("1.5") && parseFloat(multiple)<parseFloat("1.8")){
            point = "10";
        }
        else if (parseFloat(multiple)>=parseFloat("1.3") && parseFloat(multiple)<parseFloat("1.5")){
            point = "8";
        }
        else if (parseFloat(multiple)>=parseFloat("1.1") && parseFloat(multiple)<parseFloat("1.3")){
            point = "6";
        }
        else {
            point = "0";
        }
        return point;
    }

    function getPointByh5Multiple(multiple){
        let point = "";
        if(parseFloat(multiple)>=parseFloat("0.55")){
            point = "15";
        }
        else if (parseFloat(multiple)>=parseFloat("0.40") && parseFloat(multiple)<parseFloat("0.55")){
            point = "13";
        }
        else if (parseFloat(multiple)>=parseFloat("0.25") && parseFloat(multiple)<parseFloat("0.40")){
            point = "10";
        }
        else if (parseFloat(multiple)>=parseFloat("0.15") && parseFloat(multiple)<parseFloat("0.25")){
            point = "8";
        }
        else if (parseFloat(multiple)>=parseFloat("0.10") && parseFloat(multiple)<parseFloat("0.15")){
            point = "6";
        }
        else {
            point = "0";
        }
        return point;
    }

    function roundDecimal(val, precision) {
        return Math.round(Math.round(val * Math.pow(10, (precision || 0) + 1)) / 10) / Math.pow(10, (precision || 0));
    }

    function FloatDiv(arg1, arg2){
        let t1 = 0, t2 = 0, r1, r2;
        let str1 = String(arg1), str2 = String(arg2);
        try { t1 = str1.split(".")[1].length } catch (e) { }
        try { t2 = str2.split(".")[1].length } catch (e) { }

        r1 = Number(str1.replace(".", ""))
        r2 = Number(str2.replace(".", ""))
        return (r1 / r2) * Math.pow(10, t2 - t1);
    }
</script>
</body>
</html>
