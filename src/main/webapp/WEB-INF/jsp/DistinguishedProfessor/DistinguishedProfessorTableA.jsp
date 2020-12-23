<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>國立臺北科技大學特聘教授申請表A表</title>
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
            vertical-align: text-middle;
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
            width: 1200px;
            background-color: white;
        }

    </style>
</head>
<body>
    <div class="content">
        <form>
            <p>國立臺北科技大學特聘教授申請表A表</p>
            <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
		        <tbody>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">學術論著</td>
		                <td colspan="5" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計<br>(A)</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td colspan="1" width="12%"><label id="year_1">104</label></td>
		                <td colspan="1" width="12%"><label id="year_2">105</label></td>
		                <td colspan="1" width="12%"><label id="year_3">106</label></td>
		                <td colspan="1" width="12%"><label id="year_4">107</label></td>
		                <td colspan="1" width="12%"><label id="year_5">108</label></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td rowspan="3" colspan="1" width="20%">Scopus 或 WOS 資料庫</td>
		                <td colspan="1" width="10%">篇數</td>
		                <td colspan="1" width="12%"><input name="sw_article_count_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="sw_article_count_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="sw_article_count_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="sw_article_count_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="sw_article_count_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="sw_article_count_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">點數<br>(請參照表B)</td>
		                <td colspan="1" width="12%"><input name="sw_point_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="sw_point_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="sw_point_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="sw_point_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="sw_point_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="sw_point_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="7" width="80%">說明：採計Scopus論文者，請檢附-表B「傑出論文績效說明表」</td>
		            </tr>
		            <tr style="text-align: center;">
		                <td rowspan="2" colspan="1" width="20%">TSSCI/THCI (限設計及人社學院)</td>
		                <td colspan="1" width="10%">篇數</td>
		                <td colspan="1" width="12%"><input name="t_article_count_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="t_article_count_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="t_article_count_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="t_article_count_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="t_article_count_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="t_article_count_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">點數<br>(<font color="blue">2點/篇</font>)</td>
		                <td colspan="1" width="12%"><input name="t_point_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="t_point_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="t_point_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="t_point_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="t_point_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="t_point_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td rowspan="2" colspan="1" width="20%">人文、設計、藝術或社會之學術專書</td>
		                <td colspan="1" width="10%">冊數</td>
		                <td colspan="1" width="12%"><input name="a_book_count_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_book_count_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_book_count_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_book_count_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_book_count_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="a_book_count_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">點數<br>(<font color="blue">6點/冊</font>)</td>
		                <td colspan="1" width="12%"><input name="a_book_point_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_book_point_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_book_point_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_book_point_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_book_point_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="a_book_point_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td rowspan="2" colspan="1" width="20%">人文、設計、藝術或社會之學術專書單篇(章)</td>
		                <td colspan="1" width="10%">篇數</td>
		                <td colspan="1" width="12%"><input name="a_article_count_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_article_count_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_article_count_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_article_count_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_article_count_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="a_article_count_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">點數<br>(<font color="blue">2點/篇</font>)</td>
		                <td colspan="1" width="12%"><input name="a_book_point_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_book_point_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_book_point_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_book_point_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="a_book_point_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="a_book_point_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="4" width="54%">近五年FWCI值<input name="fwci_value_past_five_year">，若為本校近五年FWCI值之1.5倍則加計點數10點(B)</td>
		                <td colspan="2" width="24%">總計點數<br>(A)+(B)</td>
		                <td colspan="2" width="22%"><input name="a_plus_b_total_point" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">科 技 部 計 畫</td>
		                <td colspan="5" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td colspan="1" width="12%"><label id="year_1">104</label></td>
		                <td colspan="1" width="12%"><label id="year_2">105</label></td>
		                <td colspan="1" width="12%"><label id="year_3">106</label></td>
		                <td colspan="1" width="12%"><label id="year_4">107</label></td>
		                <td colspan="1" width="12%"><label id="year_5">108</label></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td rowspan="4" colspan="1" width="20%">近五年以本校名義主持科技部各類型計畫統計表</td>
		                <td colspan="1" width="10%">件數</td>
		                <td colspan="1" width="12%"><input name="tech_project_count_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_count_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_count_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_count_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_count_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="tech_project_count_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">計畫金額<br>(萬元)</td>
		                <td colspan="1" width="12%"><input name="tech_project_money_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_money_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_money_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_money_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_money_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="tech_project_money_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">點數<br>(<font color="blue">5點/10萬元</font>)</td>
		                <td colspan="1" width="12%"><input name="tech_project_point_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_point_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_point_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_point_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_point_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="tech_project_point_total" size="5" maxlength="40"></td>
		            </tr>
		            
		            <tr>
		                <td colspan="7" width="80%">
		                    <p>說明：</p>
		                    <p>1.不包含科技部產學合作計畫。</p>
		                </td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">教 育 部 計 畫</td>
		                <td colspan="5" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td colspan="1" width="12%"><label id="year_1">104</label></td>
		                <td colspan="1" width="12%"><label id="year_2">105</label></td>
		                <td colspan="1" width="12%"><label id="year_3">106</label></td>
		                <td colspan="1" width="12%"><label id="year_4">107</label></td>
		                <td colspan="1" width="12%"><label id="year_5">108</label></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td rowspan="3" colspan="1" width="20%">近五年以本校名義主持教育部補助大學在地實踐社會責任計畫</td>
		                <td colspan="1" width="10%">件數</td>
		                <td colspan="1" width="12%"><input name="tech_project_count_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_count_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_count_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_count_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_count_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="tech_project_count_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">計畫金額<br>(萬元)</td>
		                <td colspan="1" width="12%"><input name="tech_project_money_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_money_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_money_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_money_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_money_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="tech_project_money_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">點數<br>(<font color="blue">2點/10萬元</font>)</td>
		                <td colspan="1" width="12%"><input name="tech_project_point_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_point_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_point_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_point_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_project_point_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="tech_project_point_total" size="5" maxlength="40"></td>
		            </tr>
		            
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">產 學 合 作 計 畫</td>
		                <td colspan="5" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td colspan="1" width="12%"><label id="year_1">104</label></td>
		                <td colspan="1" width="12%"><label id="year_2">105</label></td>
		                <td colspan="1" width="12%"><label id="year_3">106</label></td>
		                <td colspan="1" width="12%"><label id="year_4">107</label></td>
		                <td colspan="1" width="12%"><label id="year_5">108</label></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td rowspan="5" colspan="1" width="20%">近五年以本校名義所獲得之產學合作計畫，其實際納入本校校務基金之統計表</td>
		                <td colspan="1" width="10%">件數</td>
		                <td colspan="1" width="12%"><input name="coop_project_count_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_count_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_count_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_count_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_count_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="coop_project_count_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">管理費<br>(萬元)</td>
		                <td colspan="1" width="12%"><input name="coop_project_management_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_management_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_management_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_management_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_management_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="coop_project_management_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">計畫金額<br>(萬元)</td>
		                <td colspan="1" width="12%"><input name="coop_project_money_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_money_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_money_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_money_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_money_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="coop_project_money_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">點數<br>(<font color="blue">2點/10萬元</font>)</td>
		                <td colspan="1" width="12%"><input name="coop_project_point_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_point_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_point_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_point_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="coop_project_point_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="coop_project_point_total" size="5" maxlength="40"></td>
		            </tr>
		            
		            <tr>
		                <td colspan="7" width="80%">
		                    <p>說明：</p>
		                    <p>1.包含科技部產學合作計畫、政府機關及財團法人之研究型計畫。</p>
		                    <p>2. 不包含以學校名義開授訓練課程招生收入。</p>
		                </td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">技 術 移 轉 金</td>
		                <td colspan="5" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td colspan="1" width="12%"><label id="year_1">104</label></td>
		                <td colspan="1" width="12%"><label id="year_2">105</label></td>
		                <td colspan="1" width="12%"><label id="year_3">106</label></td>
		                <td colspan="1" width="12%"><label id="year_4">107</label></td>
		                <td colspan="1" width="12%"><label id="year_5">108</label></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td rowspan="5" colspan="1" width="20%">近五年以本校名義所獲之實收技術移轉金統計表</td>
		                <td colspan="1" width="10%">件數</td>
		                <td colspan="1" width="12%"><input name="tech_transfer_count_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_count_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_count_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_count_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_count_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="tech_transfer_count_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">管理費<br>(萬元)</td>
		                <td colspan="1" width="12%"><input name="tech_transfer_management_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_management_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_management_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_management_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_management_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="tech_transfer_management_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">技轉金額<br>(萬元)</td>
		                <td colspan="1" width="12%"><input name="tech_transfer_money_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_money_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_money_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_money_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_money_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="tech_transfer_money_total" size="5" maxlength="40"></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="1" width="10%">點數<br>(<font color="blue">5點/10萬元</font>)</td>
		                <td colspan="1" width="12%"><input name="tech_transfer_point_one" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_point_two" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_point_three" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_point_four" size="5" maxlength="40"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_point_five" size="5" maxlength="40"></td>
		                <td colspan="1" width="10%"><input name="tech_transfer_point_total" size="5" maxlength="40"></td>
		            </tr>
		           
		            <tr>
		                <td colspan="7" width="80%">
		                    <p>說明：</p>
		                    <p>1.包含專利技術移轉金、著作權技術移轉金及知識性技術移轉金。</p>
		                    <p>2.不包含科技部先期技術移轉授權金。</p>
		                </td>
		            </tr>
		            <tr>
		                <td colspan="9" width="100%" style="text-align: center; background: #C0C0C0">其 它 傑 出 表 現 說 明</td>
		            </tr>
		            <tr>
		                <td colspan="9" width="100%">其他資料（例如：擔任國際重要學術學會理監事、國際知名學術期刊編輯/副編輯或評審委員、專利或技術移轉具體績效、獲獎情形及重要會議邀請演講…等）。
                        	<p><textarea style="resize:none;width:100%;height:200px;"></textarea></p>
                    	</td>
		            </tr>
		            <tr>
		                <td colspan="9" width="100%"><input type="checkbox" name="declaration">申請人聲明&nbsp;充分瞭解申請要點，且以上所填各項資料與勾選事項皆確實無誤，若有不實本人願負擔所有法律及行政責任。<br><br><br>
		                    <a style="margin-left: 800px">日期:<input type="date" ></a>
		                </td>
		            </tr>
		        </tbody>
		    </table>
            <p><input type="button" name="confirm" value="確定"></p>
        </form>
    </div>

</body>
</html>
