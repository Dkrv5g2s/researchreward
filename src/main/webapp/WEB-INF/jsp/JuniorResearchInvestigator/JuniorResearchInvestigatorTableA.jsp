<%--
  Created by IntelliJ IDEA.
  User: Sandy
  Date: 2021/1/24
  Time: 下午 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");
%>
<html>
<head>
    <title>年輕學者研究獎 附件A 近三年內發表之期刊論文統計表</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="content">
    <form>
        <p style="text-align: center;font-size: 24px;font-weight: bold;">年輕學者研究獎 附件A 近三年內發表之期刊論文統計表</p>
        <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <tbody>
            <tr style="text-align:center;background:  #C0C0C0 ">
                <td rowspan="2" colspan="2" width="30%">學術論著</td>
                <td colspan="3" width="60%" style="text-align: center;">年度</td>
                <td rowspan="2" width="10%" colspan="1">小計<br>(A)</td>
            </tr>
            <tr style="text-align:center;background:  #C0C0C0 ">
                <td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>
                <td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>
                <td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>
            </tr>
            <tr style="text-align: center;" class="count">
                <td rowspan="3" colspan="1" width="20%">Scopus 或 WOS 資料庫</td>
                <td colspan="1" width="10%">篇數</td>
                <td colspan="1" width="12%"><input name="sw_article_count1" type="number" class="ic1" value="<%=json.get("sw_article_count1")%>" size="5" maxlength="40" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="sw_article_count2" type="number" class="ic2" value="<%=json.get("sw_article_count2")%>" size="5" maxlength="40" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="sw_article_count3" type="number" class="ic3" value="<%=json.get("sw_article_count3")%>" size="5" maxlength="40" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="10%" id="sw_article_count_total" class="total_count"><%=json.get("sw_article_count_total")%></td>
            </tr>
            <tr style="text-align: center;" class="point">
                <td colspan="1" width="10%">點數<br>(請參照表B)</td>
                <td colspan="1" width="12%" id="sw_point1" class="pc1" ><%=json.get("sw_point1")%></td>
                <td colspan="1" width="12%" id="sw_point2" class="pc2" ><%=json.get("sw_point2")%></td>
                <td colspan="1" width="12%" id="sw_point3" class="pc3" ><%=json.get("sw_point3")%></td>
                <td colspan="1" width="10%" id="sw_point_total" class="total_point" ><%=json.get("sw_point_total")%></td>
            </tr>
            <tr style="text-align: center;">
                <td colspan="5" width="80%">說明：採計Scopus論文者，請檢附-表B「傑出論文績效說明表」</td>
            </tr>
            <tr style="text-align: center;" class="count1">
                <td rowspan="2" colspan="1" width="20%">TSSCI/THCI (限設計及人社學院)</td>
                <td colspan="1" width="10%">篇數</td>
                <td colspan="1" width="12%"><input name="t_article_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("t_article_count1")%>" style="text-align:center; width: 75px;" ></td>
                <td colspan="1" width="12%"><input name="t_article_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("t_article_count2")%>" style="text-align:center; width: 75px;" ></td>
                <td colspan="1" width="12%"><input name="t_article_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("t_article_count3")%>" style="text-align:center; width: 75px;" ></td>
                <td colspan="1" width="10%" id="t_article_count_total" class="total_count"><%=json.get("t_article_count_total")%></td>
            </tr>
            <tr style="text-align: center;" class="point">
                <td colspan="1" width="10%" >點數<br>(<font color="blue">2點/篇</font>)</td>
                <td colspan="1" width="12%" id="t_point1" class="pc1" ><%=json.get("t_point1")%></td>
                <td colspan="1" width="12%" id="t_point2" class="pc2" ><%=json.get("t_point2")%></td>
                <td colspan="1" width="12%" id="t_point3" class="pc3"><%=json.get("t_point3")%></td>
                <td colspan="1" width="10%" id="t_point_total" class="total_point"><%=json.get("t_point_total")%></td>
            </tr>
            <tr style="text-align: center;" class="count2">
                <td rowspan="2" colspan="1" width="20%">人文、設計、藝術或社會之學術專書</td>
                <td colspan="1" width="10%">冊數</td>
                <td colspan="1" width="12%"><input name="a_book_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("a_book_count1")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="a_book_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("a_book_count2")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="a_book_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("a_book_count3")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="10%" id="a_book_count_total" class="total_count"><%=json.get("a_book_count_total")%></td>
            </tr>
            <tr style="text-align: center;" class="point">
                <td colspan="1" width="10%">點數<br>(<font color="blue">6點/冊</font>)</td>
                <td colspan="1" width="12%" id="a_book_point1" class="pc1"><%=json.get("a_book_point1")%></td>
                <td colspan="1" width="12%" id="a_book_point2" class="pc2"><%=json.get("a_book_point2")%></td>
                <td colspan="1" width="12%" id="a_book_point3" class="pc3"><%=json.get("a_book_point3")%></td>
                <td colspan="1" width="10%" id="a_book_point_total" class="total_point"><%=json.get("a_book_point_total")%></td>
            </tr>
            <tr style="text-align: center;" class="count1">
                <td rowspan="2" colspan="1" width="20%">人文、設計、藝術或社會之學術專書單篇(章)</td>
                <td colspan="1" width="10%">篇數</td>
                <td colspan="1" width="12%"><input name="a_article_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("a_article_count1")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="a_article_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("a_article_count2")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="a_article_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("a_article_count3")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="10%" id="a_article_count_total" class="total_count"><%=json.get("a_article_count_total")%></td>
            </tr>
            <tr style="text-align: center;" class="point">
                <td colspan="1" width="10%">點數<br>(<font color="blue">2點/篇</font>)</td>
                <td colspan="1" width="12%" id="a_article_point1" class="pc1"><%=json.get("a_article_point1")%></td>
                <td colspan="1" width="12%" id="a_article_point2" class="pc2"><%=json.get("a_article_point2")%></td>
                <td colspan="1" width="12%" id="a_article_point3" class="pc3"><%=json.get("a_article_point3")%></td>
                <td colspan="1" width="10%" id="a_article_point_total" class="total_point"><%=json.get("a_article_point_total")%></td>
            </tr>
            <tr style="text-align: center;">
                <td colspan="3" width="54%">近三年FWCI值：<label id="fwci_value_past_three_year"><%=json.get("fwci_value_past_three_year")%></label>，若為本校近三年FWCI值之1.5倍則加計點數10點(B)</td>
                <td colspan="2" width="24%">總計點數<br>(A)+(B)</td>
                <td colspan="2" width="22%" id="a_plus_b_total_point" ><%=json.get("a_plus_b_total_point")%></td>
            </tr>
            <tr style="text-align:center;background:  #C0C0C0 ">
                <td rowspan="2" colspan="2" width="30%">科 技 部 計 畫</td>
                <td colspan="3" width="60%" style="text-align: center;">年度</td>
                <td rowspan="2" width="10%" colspan="1">小計</td>
            </tr>
            <tr style="text-align:center;background:  #C0C0C0 ">
                <td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>
                <td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>
                <td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>
            </tr>
            <tr style="text-align: center;" class="count">
                <td rowspan="4" colspan="1" width="20%">近三年以本校名義主持科技部各類型計畫統計表</td>
                <td colspan="1" width="10%">件數</td>
                <td colspan="1" width="12%"><input name="tech_project_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("tech_project_count1")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="tech_project_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("tech_project_count2")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="tech_project_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("tech_project_count3")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="10%" id="tech_project_count_total" class="total_count"><%=json.get("tech_project_count_total")%></td>
            </tr>
            <tr style="text-align: center;" class="project_money1">
                <td colspan="1" width="10%">計畫金額<br>(萬元)</td>
                <td colspan="1" width="12%"><input name="tech_project_money1" type="number" class="ip1" size="5" maxlength="40" value="<%=json.get("tech_project_money1")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="tech_project_money2" type="number" class="ip2" size="5" maxlength="40" value="<%=json.get("tech_project_money2")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="tech_project_money3" type="number" class="ip3" size="5" maxlength="40" value="<%=json.get("tech_project_money3")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="10%" id="tech_project_money_total" class="total_project_money"><%=json.get("tech_project_money_total")%></td>
            </tr>
            <tr style="text-align: center;" class="point">
                <td colspan="1" width="10%">點數<br>(<font color="blue">5點/10萬元</font>)</td>
                <td colspan="1" width="12%" id="tech_project_point1" class="pc1"><%=json.get("tech_project_point1")%></td>
                <td colspan="1" width="12%" id="tech_project_point2" class="pc2"><%=json.get("tech_project_point2")%></td>
                <td colspan="1" width="12%" id="tech_project_point3" class="pc3"><%=json.get("tech_project_point3")%></td>
                <td colspan="1" width="10%" id="tech_project_point_total" class="total_point"><%=json.get("tech_project_point_total")%></td>
            </tr>

            <tr>
                <td colspan="5" width="80%">
                    <p>說明：</p>
                    <p>1.不包含科技部產學合作計畫。</p>
                </td>
            </tr>
<%--            <tr style="text-align:center;background:  #C0C0C0 ">--%>
<%--                <td rowspan="2" colspan="2" width="30%">教 育 部 計 畫</td>--%>
<%--                <td colspan="3" width="60%" style="text-align: center;">年度</td>--%>
<%--                <td rowspan="2" width="10%" colspan="1">小計</td>--%>
<%--            </tr>--%>
<%--            <tr style="text-align:center;background:  #C0C0C0 ">--%>
<%--                <td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>--%>
<%--                <td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>--%>
<%--                <td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>--%>
<%--            </tr>--%>
<%--            <tr style="text-align: center;" class="count">--%>
<%--                <td rowspan="3" colspan="1" width="20%">近三年以本校名義主持教育部補助大學在地實踐社會責任計畫</td>--%>
<%--                <td colspan="1" width="10%">件數</td>--%>
<%--                <td colspan="1" width="12%"><input name="edu_project_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("edu_project_count1")%>" style="text-align:center; width: 75px;"></td>--%>
<%--                <td colspan="1" width="12%"><input name="edu_project_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("edu_project_count2")%>" style="text-align:center; width: 75px;"></td>--%>
<%--                <td colspan="1" width="12%"><input name="edu_project_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("edu_project_count3")%>" style="text-align:center; width: 75px;"></td>--%>
<%--                <td colspan="1" width="10%" id="edu_project_count_total" class="total_count"><%=json.get("edu_project_count_total")%></td>--%>
<%--            </tr>--%>
<%--            <tr style="text-align: center;" class="project_money2">--%>
<%--                <td colspan="1" width="10%">計畫金額<br>(萬元)</td>--%>
<%--                <td colspan="1" width="12%"><input name="edu_project_money1" type="number" class="ip1" size="5" maxlength="40" value="<%=json.get("edu_project_money1")%>" style="text-align:center; width: 75px;"></td>--%>
<%--                <td colspan="1" width="12%"><input name="edu_project_money2" type="number" class="ip2" size="5" maxlength="40" value="<%=json.get("edu_project_money2")%>" style="text-align:center; width: 75px;"></td>--%>
<%--                <td colspan="1" width="12%"><input name="edu_project_money3" type="number" class="ip3" size="5" maxlength="40" value="<%=json.get("edu_project_money3")%>" style="text-align:center; width: 75px;"></td>--%>
<%--                <td colspan="1" width="10%" id="edu_project_money_total" class="total_project_money"><%=json.get("edu_project_money_total")%></td>--%>
<%--            </tr>--%>
<%--            <tr style="text-align: center;" class="point">--%>
<%--                <td colspan="1" width="10%">點數<br>(<font color="blue">2點/10萬元</font>)</td>--%>
<%--                <td colspan="1" width="12%" id="edu_project_point1" class="pc1"><%=json.get("edu_project_point1")%></td>--%>
<%--                <td colspan="1" width="12%" id="edu_project_point2" class="pc2"><%=json.get("edu_project_point2")%></td>--%>
<%--                <td colspan="1" width="12%" id="edu_project_point3" class="pc3"><%=json.get("edu_project_point3")%></td>--%>
<%--                <td colspan="1" width="10%" id="edu_project_point_total" class="total_point"><%=json.get("edu_project_point_total")%></td>--%>
<%--            </tr>--%>

            <tr style="text-align:center;background:  #C0C0C0 ">
                <td rowspan="2" colspan="2" width="30%">產 學 合 作 計 畫</td>
                <td colspan="3" width="60%" style="text-align: center;">年度</td>
                <td rowspan="2" width="10%" colspan="1">小計</td>
            </tr>
            <tr style="text-align:center;background:  #C0C0C0 ">
                <td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>
                <td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>
                <td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>
            </tr>
            <tr style="text-align: center;" class="count">
                <td rowspan="5" colspan="1" width="20%">近三年以本校名義所獲得之產學合作計畫，其實際納入本校校務基金之統計表</td>
                <td colspan="1" width="10%">件數</td>
                <td colspan="1" width="12%"><input name="coop_project_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("coop_project_count1")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="coop_project_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("coop_project_count2")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="coop_project_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("coop_project_count3")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="10%" id="coop_project_count_total" class="total_count"><%=json.get("coop_project_count_total")%></td>
            </tr>
            <tr style="text-align: center;" class="mamage_money1">
                <td colspan="1" width="10%">管理費<br>(萬元)</td>
                <td colspan="1" width="12%"><input name="coop_project_management1" type="number" class="mp1" size="5" maxlength="40" value="<%=json.get("coop_project_management1")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="coop_project_management2" type="number" class="mp2" size="5" maxlength="40" value="<%=json.get("coop_project_management2")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="coop_project_management3" type="number" class="mp3" size="5" maxlength="40" value="<%=json.get("coop_project_management3")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="10%" id="coop_project_management_total" class="total_manage_money"><%=json.get("coop_project_management_total")%></td>
            </tr>
            <tr style="text-align: center;" class="project_money3">
                <td colspan="1" width="10%">計畫金額<br>(萬元)</td>
                <td colspan="1" width="12%"><input name="coop_project_money1" type="number" class="ip1" size="5" maxlength="40" value="<%=json.get("coop_project_money1")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="coop_project_money2" type="number" class="ip2" size="5" maxlength="40" value="<%=json.get("coop_project_money2")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="coop_project_money3" type="number" class="ip3" size="5" maxlength="40" value="<%=json.get("coop_project_money3")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="10%" id="coop_project_money_total" class="total_project_money"><%=json.get("coop_project_money_total")%></td>
            </tr>
            <tr style="text-align: center;" class="point">
                <td colspan="1" width="10%">點數<br>(<font color="blue">2點/10萬元</font>)</td>
                <td colspan="1" width="12%" id="coop_project_point1" class="pc1"><%=json.get("coop_project_point1")%></td>
                <td colspan="1" width="12%" id="coop_project_point2" class="pc2"><%=json.get("coop_project_point2")%></td>
                <td colspan="1" width="12%" id="coop_project_point3" class="pc3"><%=json.get("coop_project_point3")%></td>
                <td colspan="1" width="10%" id="coop_project_point_total" class="total_point"><%=json.get("coop_project_point_total")%></td>
            </tr>

            <tr>
                <td colspan="5" width="80%">
                    <p>說明：</p>
                    <p>1.包含科技部產學合作計畫、政府機關及財團法人之研究型計畫。</p>
                    <p>2. 不包含以學校名義開授訓練課程招生收入。</p>
                </td>
            </tr>
            <tr style="text-align:center;background:  #C0C0C0 ">
                <td rowspan="2" colspan="2" width="30%">技 術 移 轉 金</td>
                <td colspan="3" width="60%" style="text-align: center;">年度</td>
                <td rowspan="2" width="10%" colspan="1">小計</td>
            </tr>
            <tr style="text-align:center;background:  #C0C0C0 ">
                <td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>
                <td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>
                <td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>
            </tr>
            <tr style="text-align: center;" class="count">
                <td rowspan="5" colspan="1" width="20%">近三年以本校名義所獲之實收技術移轉金統計表</td>
                <td colspan="1" width="10%">件數</td>
                <td colspan="1" width="12%"><input name="tech_transfer_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("tech_transfer_count1")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="tech_transfer_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("tech_transfer_count2")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="tech_transfer_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("tech_transfer_count3")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="10%" id="tech_transfer_count_total" class="total_count"><%=json.get("tech_transfer_count_total")%></td>
            </tr>
            <tr style="text-align: center;" class="mamage_money2">
                <td colspan="1" width="10%">管理費<br>(萬元)</td>
                <td colspan="1" width="12%"><input name="tech_transfer_management1" type="number" class="mp1" size="5" maxlength="40" value="<%=json.get("tech_transfer_management1")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="tech_transfer_management2" type="number" class="mp2" size="5" maxlength="40" value="<%=json.get("tech_transfer_management2")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="tech_transfer_management3" type="number" class="mp3" size="5" maxlength="40" value="<%=json.get("tech_transfer_management3")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="10%" id="tech_transfer_management_total" class="total_manage_money"><%=json.get("tech_transfer_management_total")%></td>
            </tr>
            <tr style="text-align: center;" class="project_money4">
                <td colspan="1" width="10%">技轉金額<br>(萬元)</td>
                <td colspan="1" width="12%"><input name="tech_transfer_money1" type="number" class="ip1" size="5" maxlength="40" value="<%=json.get("tech_transfer_money1")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="tech_transfer_money2" type="number" class="ip2" size="5" maxlength="40" value="<%=json.get("tech_transfer_money2")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="12%"><input name="tech_transfer_money3" type="number" class="ip3" size="5" maxlength="40" value="<%=json.get("tech_transfer_money3")%>" style="text-align:center; width: 75px;"></td>
                <td colspan="1" width="10%" id="tech_transfer_money_total" class="total_project_money"><%=json.get("tech_transfer_money_total")%></td>
            </tr>
            <tr style="text-align: center;" class="point">
                <td colspan="1" width="10%">點數<br>(<font color="blue">5點/10萬元</font>)</td>
                <td colspan="1" width="12%" id="tech_transfer_point1" class="pc1"><%=json.get("tech_transfer_point1")%></td>
                <td colspan="1" width="12%" id="tech_transfer_point2" class="pc2"><%=json.get("tech_transfer_point2")%></td>
                <td colspan="1" width="12%" id="tech_transfer_point3" class="pc3"><%=json.get("tech_transfer_point3")%></td>
                <td colspan="1" width="10%" id="tech_transfer_point_total" class="total_point"><%=json.get("tech_transfer_point_total")%></td>
            </tr>

            <tr>
                <td colspan="5" width="80%">
                    <p>說明：</p>
                    <p>1.包含專利技術移轉金、著作權技術移轉金及知識性技術移轉金。</p>
                    <p>2.不包含科技部先期技術移轉授權金。</p>
                </td>
            </tr>
            <tr>
                <td colspan="7" width="100%" style="text-align: center; background: #C0C0C0">其 它 傑 出 表 現 說 明</td>
            </tr>
            <tr>
                <td colspan="7" width="100%">其他資料（例如：擔任國際重要學術學會理監事、國際知名學術期刊編輯/副編輯或評審委員、專利或技術移轉具體績效、獲獎情形及重要會議邀請演講…等）。
                    <p><textarea style="resize:none;width:100%;height:200px;" name="other_data" ><%=json.get("other_data")%></textarea></p>
                </td>
            </tr>
            <tr>
                <td colspan="7" width="100%"><input type="checkbox" name="declaration" >申請人聲明&nbsp;充分瞭解申請要點，且以上所填各項資料與勾選事項皆確實無誤，若有不實本人願負擔所有法律及行政責任。<br><br><br>
                    <a style="margin-left: 800px">日期:<input type="date" name="commit_date" value="<%=json.get("commit_date")%>"></a>
                </td>
            </tr>
            </tbody>
        </table>
        <p style="text-align: center;">
            <input type="button" name="save" value="存檔" onclick="commit()">
            <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='JuniorResearchInvestigatorCatalog'"  >
        </p>
    </form>
</div>
</body>
</html>
