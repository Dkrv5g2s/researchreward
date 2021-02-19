
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
    JSONObject json = (JSONObject) request.getAttribute("json");
%>
<html>
<head>
    <title>年輕學者研究獎 附件A 近三年內發表之期刊論文統計表</title>

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
    </style>
</head>
<body>
<div class="content">
    <form>
        <p class="file_title">年輕學者研究獎 表A 近三年內發表之期刊論文統計表</p>
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
                    <p>說明：論文請檢附-表B「傑出論文績效說明表」</p>
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
                <td colspan="3">
                    近三年FWCI值：<b><label id="fwci_value_past_three_year" name="fwci_value_past_three_year" class="input_fwci">
                    <%=json.optString("fwci_value_past_five_year","0")%>
                    </label></b>
                    ，若為本校近三年FWCI值之1.5倍則加計點數10點<b>(B)</b>
                </td>
                <td colspan="2"><b>總計點數 (A)+(B)</b></td>
                <td colspan="2" id="a_plus_b_total_point" class="total_point"><%=json.optString("a_plus_b_total_point","0")%></td>
            </tr>

            <tr class="title">
                <td rowspan="2" colspan="3">科 技 部 計 畫</td>
                <td colspan="3">年度</td>
                <td rowspan="2"><b>小計</b></td>
            </tr>
            <tr class="title">
                <td><label id="year1"><%=json.get("year1")%></label></td>
                <td><label id="year2"><%=json.get("year2")%></label></td>
                <td><label id="year3"><%=json.get("year3")%></label></td>
            </tr>
            <tr class="count">
                <td rowspan="4" >近三年以本校名義主持科技部各類型計畫統計表</td>
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
            <tr>
                <td colspan="6">
                    <p>說明：不包含科技部產學合作計畫。</p>
                </td>
            </tr>

            <tr class="title">
                <td rowspan="2" colspan="3">產 學 合 作 計 畫</td>
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
                <td colspan="6" class="left">
                    <p>說明：1.包含科技部產學合作計畫、政府機關及財團法人之研究型計畫。</p>
                    <p style="margin-left: 2.5rem;">2.不包含以學校名義開授訓練課程招生收入。</p>
                </td>
            </tr>
            <tr class="title">
                <td rowspan="2" colspan="3">技 術 移 轉 金</td>
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
                <td colspan="6" class="left">
                    <p>說明：1.包含專利技術移轉金、著作權技術移轉金及知識性技術移轉金。</p>
                    <p style="margin-left: 2.5rem;">2.不包含科技部先期技術移轉授權金。</p>
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
</body>
</html>
