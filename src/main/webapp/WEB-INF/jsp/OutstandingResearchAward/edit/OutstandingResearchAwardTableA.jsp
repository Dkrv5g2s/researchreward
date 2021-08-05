<%--
  Created by IntelliJ IDEA.
  User: Ted Lin
  Date: 2021/2/2
  Time: 上午 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("data");
%>
<html>
<head>
    <title>傑出研究獎 近三年內發表之期刊論文統計表</title>

    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.14.1/moment.min.js"></script>

    <style type="text/css">
        tr{
            text-align:center;
        }
        input {
            height: 100%;
            width: 100%;
            text-align: center;
        }
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
        }
        input[type="number"]{
            -moz-appearance: textfield;
        }
        textarea{
            resize:none;
            height:200px;
            font-size: 16px;
        }
        .input_fwci{
            height: auto;
            width: 4rem;
            border-style: revert;
        }
        .file_title{
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            margin-top: 0;
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
        <p class="file_title">傑出研究獎 近三年內發表之期刊論文統計表</p>
        <table>
            <tbody>
            <tr class="title">
                <td rowspan="2" colspan="3">學術論著</td>
                <td colspan="3">年度</td>
                <td rowspan="2"><b>小計<br>(A)</b></td>
            </tr>
            <tr class="title">
                <td><label id="year3"><%=json.get("year3")%></label></td>
                <td><label id="year4"><%=json.get("year4")%></label></td>
                <td><label id="year5"><%=json.get("year5")%></label></td>
            </tr>
            <tr class="count">
                <td rowspan="3">Scopus 或 WOS 資料庫</td>
                <td colspan="2">篇數</td>
                <td><input name="sw_article_count1" type="number" class="ic1" value="<%=json.optString("sw_article_count1", "0")%>"></td>
                <td><input name="sw_article_count2" type="number" class="ic2" value="<%=json.optString("sw_article_count2", "0")%>"></td>
                <td><input name="sw_article_count3" type="number" class="ic3" value="<%=json.optString("sw_article_count3", "0")%>"></td>
                <td id="sw_article_count_total" class="total_count"><%=json.optString("sw_article_count_total", "0")%></td>
            </tr>
            <tr class="count">
                <td colspan="2"><b>點數</b><br>(請參照 <a href="https://rnd.rpage.ntut.edu.tw/var/file/42/1042/img/955/111309993.pdf#page=3" target="_blank">附表一</a> )</td>
                <td><input id="sw_point1" name="sw_point1" type="number" class="ic1" value="<%=json.optString("sw_point1", "0")%>"></td>
                <td><input id="sw_point2" name="sw_point2" type="number" class="ic2" value="<%=json.optString("sw_point2", "0")%>"></td>
                <td><input id="sw_point3" name="sw_point3" type="number" class="ic3" value="<%=json.optString("sw_point3", "0")%>"></td>
                <td id="sw_point_total" class="total_count total_point" ><%=json.optString("sw_point_total", "0")%></td>
            </tr>
            <tr>
                <td colspan="6">
                    <p>說明：論文請檢附-「傑出論文績效說明表」</p>
                </td>
            </tr>

            <tr class="count1">
                <td rowspan="2" >TSSCI/THCI (限設計及人社學院)</td>
                <td colspan="2">篇數</td>
                <td><input name="t_article_count1" type="number" class="ic1" maxlength="3" value="<%=json.optString("t_article_count1", "0")%>" ></td>
                <td><input name="t_article_count2" type="number" class="ic2" maxlength="3" value="<%=json.optString("t_article_count2", "0")%>" ></td>
                <td><input name="t_article_count3" type="number" class="ic3" maxlength="3" value="<%=json.optString("t_article_count3", "0")%>" ></td>
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
                <td><input name="a_book_count1" type="number" class="ic1" value="<%=json.optString("a_book_count1","0")%>"></td>
                <td><input name="a_book_count2" type="number" class="ic2" value="<%=json.optString("a_book_count2","0")%>"></td>
                <td><input name="a_book_count3" type="number" class="ic3" value="<%=json.optString("a_book_count3","0")%>"></td>
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
                <td><input name="a_article_count1" type="number" class="ic1" value="<%=json.optString("a_article_count1","0")%>"></td>
                <td><input name="a_article_count2" type="number" class="ic2" value="<%=json.optString("a_article_count2","0")%>"></td>
                <td><input name="a_article_count3" type="number" class="ic3" value="<%=json.optString("a_article_count3","0")%>"></td>
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
                    <p align="left">申請人近3年FWCI值：<input name="fwci_value" id="fwci_value" value="<%=json.get("fwci_value")%>" style="width: 10%;" oninput="calculatePoint()">&nbsp;
                        為本校近三年FWCI值<span>${fwci}</span>之<span id="FWCIValueOfUserDivideNTUT"></span>倍。</p>
                    <p align="left">申請人h-5指數：<input name="h5_index" id="h5_index" value="<%=json.get("h5_index")%>" style="width: 10%;" oninput="calculatePoint()">
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
                <td><label id="year3"><%=json.get("year3")%></label></td>
                <td><label id="year4"><%=json.get("year4")%></label></td>
                <td><label id="year5"><%=json.get("year5")%></label></td>
            </tr>
            <tr class="count">
                <td rowspan="3" >近三年以本校名義主持科技部各類型計畫統計表</td>
                <td colspan="2">件數</td>
                <td><input name="tech_project_count1" type="number" class="ic1" value="<%=json.optString("tech_project_count1","0")%>"></td>
                <td><input name="tech_project_count2" type="number" class="ic2" value="<%=json.optString("tech_project_count2","0")%>"></td>
                <td><input name="tech_project_count3" type="number" class="ic3" value="<%=json.optString("tech_project_count3","0")%>"></td>
                <td id="tech_project_count_total" class="total_count"><%=json.optString("tech_project_count_total","0")%></td>
            </tr>
            <tr class="project_money1">
                <td colspan="2">計畫金額<br>(萬元)</td>
                <td><input name="tech_project_money1" type="number" class="ip1" value="<%=json.optString("tech_project_money1","0")%>"></td>
                <td><input name="tech_project_money2" type="number" class="ip2" value="<%=json.optString("tech_project_money2","0")%>"></td>
                <td><input name="tech_project_money3" type="number" class="ip3" value="<%=json.optString("tech_project_money3","0")%>"></td>
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
                <td><label id="year3"><%=json.get("year3")%></label></td>
                <td><label id="year4"><%=json.get("year4")%></label></td>
                <td><label id="year5"><%=json.get("year5")%></label></td>
            </tr>
            <tr class="count">
                <td rowspan="5" >近三年以本校名義所獲得之產學合作計畫，其實際納入本校校務基金之統計表</td>
                <td colspan="2">件數</td>
                <td><input name="coop_project_count1" type="number" class="ic1" value="<%=json.optString("coop_project_count1","0")%>"></td>
                <td><input name="coop_project_count2" type="number" class="ic2" value="<%=json.optString("coop_project_count2","0")%>"></td>
                <td><input name="coop_project_count3" type="number" class="ic3" value="<%=json.optString("coop_project_count3","0")%>"></td>
                <td id="coop_project_count_total" class="total_count"><%=json.optString("coop_project_count_total","0")%></td>
            </tr>
            <tr class="manage_money1">
                <td colspan="2">管理費<br>(萬元)</td>
                <td><input name="coop_project_management1" type="number" class="mp1" value="<%=json.optString("coop_project_management1","0")%>"></td>
                <td><input name="coop_project_management2" type="number" class="mp2" value="<%=json.optString("coop_project_management2","0")%>"></td>
                <td><input name="coop_project_management3" type="number" class="mp3" value="<%=json.optString("coop_project_management3","0")%>"></td>
                <td id="coop_project_management_total" class="total_manage_money"><%=json.optString("coop_project_management_total","0")%></td>
            </tr>
            <tr class="project_money3">
                <td colspan="2">計畫金額<br>(萬元)</td>
                <td><input name="coop_project_money1" type="number" class="ip1" value="<%=json.optString("coop_project_money1","0")%>"></td>
                <td><input name="coop_project_money2" type="number" class="ip2" value="<%=json.optString("coop_project_money2","0")%>"></td>
                <td><input name="coop_project_money3" type="number" class="ip3" value="<%=json.optString("coop_project_money3","0")%>"></td>
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
                <td><label id="year3"><%=json.get("year3")%></label></td>
                <td><label id="year4"><%=json.get("year4")%></label></td>
                <td><label id="year5"><%=json.get("year5")%></label></td>
            </tr>
            <tr class="count">
                <td rowspan="5" >近三年以本校名義所獲之實收技術移轉金統計表</td>
                <td colspan="2">件數</td>
                <td><input name="tech_transfer_count1" type="number" class="ic1" value="<%=json.optString("tech_transfer_count1","0")%>"></td>
                <td><input name="tech_transfer_count2" type="number" class="ic2" value="<%=json.optString("tech_transfer_count2","0")%>"></td>
                <td><input name="tech_transfer_count3" type="number" class="ic3" value="<%=json.optString("tech_transfer_count3","0")%>"></td>
                <td id="tech_transfer_count_total" class="total_count"><%=json.optString("tech_transfer_count_total","0")%></td>
            </tr>
            <tr class="manage_money2">
                <td colspan="2">管理費<br>(萬元)</td>
                <td><input name="tech_transfer_management1" type="number" class="mp1" value="<%=json.optString("tech_transfer_management1","0")%>"></td>
                <td><input name="tech_transfer_management2" type="number" class="mp2" value="<%=json.optString("tech_transfer_management2","0")%>"></td>
                <td><input name="tech_transfer_management3" type="number" class="mp3" value="<%=json.optString("tech_transfer_management3","0")%>"></td>
                <td id="tech_transfer_management_total" class="total_manage_money"><%=json.optString("tech_transfer_management_total","0")%></td>
            </tr>
            <tr class="project_money4">
                <td colspan="2">技轉金額<br>(萬元)</td>
                <td><input name="tech_transfer_money1" type="number" class="ip1" value="<%=json.optString("tech_transfer_money1","0")%>"></td>
                <td><input name="tech_transfer_money2" type="number" class="ip2" value="<%=json.optString("tech_transfer_money2","0")%>"></td>
                <td><input name="tech_transfer_money3" type="number" class="ip3" value="<%=json.optString("tech_transfer_money3","0")%>"></td>
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
                    <div style="float:right;">目前輸入字數:<span id="nowWords">0</span>/500</div>
                </td>
            </tr>
            <tr>
                <td colspan="7" class="left">
                    <textarea id="other_data" maxlength="500" onkeyup="wordsTotal()" placeholder="其他資料（例如：擔任國際重要學術學會理監事、國際知名學術期刊編輯/副編輯或評審委員、專利或技術移轉具體績效、獲獎情形及重要會議邀請演講…等）。"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="7" class="left">
                    <p>註：1.論文以當年度紙本刊登為準。2.以本校「教師評鑑及基本資料庫」之資料為準。</p>
                    <p>
                        <input type="checkbox" name="declaration" class="auto"/>
                        <b><font color="red">申請人聲明&nbsp;充分瞭解申請要點，且以上所填各項資料與勾選事項皆確實無誤，若有不實本人願負擔所有法律及行政責任。</font></b>
                    </p>
                    <p style="text-align: right;">
                        <label style="margin-right: 15ch;">申請人簽章：</label>
                        <label for="commit_date">日期：</label>
                        <input type="date" id="commit_date" style="width: auto;" value="<%=json.optString("commit_date", "")%>">
                    </p>
                </td>
            </tr>
            </tbody>
        </table>
        <p style="text-align: center;">
            <button type="button" name="return_last_page" onclick="location.href='OutstandingResearchAwardCatalog'">回上頁</button>
            <button type="button" name="save" onclick="commit()" disabled = "disabled">存檔</button>
        </p>
    </form>
</div>
</body>
<script>
    function wordsTotal() {
        const total = $('#other_data').val().length;
        document.getElementById('nowWords').innerHTML = total;
    }

    function checkDeclaration() {
        if ( $("input:not(:checked)[name='declaration']").length == 0  ) {
            $("button[name='save']").prop( "disabled", false );
        }
        else {
            $("button[name='save']").prop( "disabled", true  );
        }
    }

    function commit(){
        $.ajax({
            type: 'POST',
            url: 'OutstandingResearchAwardTableA',
            dataType: 'text',
            data: JSON.stringify(InputToJson()),
            contentType: 'application/json',
            success: function(){
                alert('存檔成功');
                window.location.href="OutstandingResearchAwardTableA";
            },
            error:function() {
                alert("存檔失敗");
            }
        });
    }

    function InputToJson(){
        let data = {};
        let input_number = document.getElementsByTagName("input");
        for (let i=0; i < input_number.length; i++) {
            data[ input_number[i].name] = input_number[i].value;
        }
        let tds = document.getElementsByTagName("td");
        for (let j=0; j<tds.length; j++) {
            if(tds[j].id.length!==0){
                data[ tds[j].id] = tds[j].innerHTML;
            }
        }
        let labels = document.getElementsByTagName("label");
        for (let k=0; k<labels.length; k++) {
            if(labels[k].id.length!==0) {
                data[labels[k].id] = labels[k].innerHTML;
            }
        }
        data["other_data"] = $("#other_data").val();
        data["commit_date"] = $("#commit_date").val();
        data["fill_rate"] = $("#commit_date").val() ? 1 : 0;
        return data;
    }

    function calculatePoint(){
        let FWCIValueofntut = ${fwci};
        let FWCIValueofuser = document.getElementById("fwci_value").value;
        let multipleofFWCI = roundDecimal(FloatDiv(FWCIValueofuser,FWCIValueofntut),2).toString();

        let h5Indexofntut = ${h5Index};
        let h5Indexofuser = document.getElementById("h5_index").value;
        let multipleofh5 = roundDecimal(FloatDiv(h5Indexofuser,h5Indexofntut),2).toString();

        document.getElementById("FWCIValueOfUserDivideNTUT").innerHTML =  multipleofFWCI;
        document.getElementById("h5IndexOfUserDivideNTUT").innerHTML =  multipleofh5;

        let pointOfFWCI = getPointByFWCIMultiple(multipleofFWCI);
        let pointOfH5Index = getPointByh5Multiple(multipleofh5);
        let betterAmount = parseFloat(pointOfFWCI) >= parseFloat(pointOfH5Index) ? pointOfFWCI :pointOfH5Index;
        document.getElementById("pointB").innerHTML = betterAmount;
        update_A_plus_B();
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
        var t1 = 0, t2 = 0, r1, r2;
        try { t1 = arg1.toString().split(".")[1].length } catch (e) { }
        try { t2 = arg2.toString().split(".")[1].length } catch (e) { }

        r1 = Number(arg1.toString().replace(".", ""))
        r2 = Number(arg2.toString().replace(".", ""))
        return (r1 / r2) * Math.pow(10, t2 - t1);

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

    function update_article(obj){
        let count = $(obj).parent().parent();
        let total_count=parseInt(count.find('.ic1').val())+parseInt(count.find('.ic2').val())+parseInt(count.find('.ic3').val());
        let total_point=parseInt(count.next().find('.pc1').text())+parseInt(count.next().find('.pc2').text())+parseInt(count.next().find('.pc3').text());
        if(!isNaN(total_count)){
            count.find('.total_count').text(total_count);
        }
        if(!isNaN(total_point)){
            count.next().find('.total_point').text(total_point);
        }
        calculatePoint();
    }

    function update_project_count(obj){
        let count = $(obj).parent().parent();
        let total_count=parseInt(count.find('.ic1').val())+parseInt(count.find('.ic2').val())+parseInt(count.find('.ic3').val());
        if(!isNaN(total_count)){
            count.find('.total_count').text(total_count);
        }
    }

    function update_project(obj){
        let money = $(obj).parent().parent();
        let total_count=parseInt(money.prev().find('.ic1').val())+parseInt(money.prev().find('.ic2').val())+parseInt(money.prev().find('.ic3').val());
        let total_money=parseInt(money.find('.ip1').val())+parseInt(money.find('.ip2').val())+parseInt(money.find('.ip3').val());
        let total_point=parseFloat(money.next().find('.pc1').text())+parseFloat(money.next().find('.pc2').text())+parseFloat(money.next().find('.pc3').text());

        if(!isNaN(total_count)){
            money.prev().find('.total_count').text(total_count);
        }
        if(!isNaN(total_money)){
            money.find('.total_project_money').text(total_money);
        }
        if(!isNaN(total_point)){
            money.next().find('.total_point').text(total_point);
        }
    }

    function update_project_manage(obj){
        let money = $(obj).parent().parent();
        let total_count=parseInt(money.prev().prev().find('.ic1').val())+parseInt(money.prev().prev().find('.ic2').val())+parseInt(money.prev().prev().find('.ic3').val());
        let total_money=parseInt(money.find('.ip1').val())+parseInt(money.find('.ip2').val())+parseInt(money.find('.ip3').val());
        let total_manage_money=parseInt(money.prev().find('.mp1').val())+parseInt(money.prev().find('.mp2').val())+parseInt(money.prev().find('.mp3').val());
        let total_point=parseFloat(money.next().find('.pc1').text())+parseFloat(money.next().find('.pc2').text())+parseFloat(money.next().find('.pc3').text());

        if(!isNaN(total_count)){
            money.prev().prev().find('.total_count').text(total_count);
        }
        if(!isNaN(total_money)){
            money.find('.total_project_money').text(total_money);
        }
        if(!isNaN(total_manage_money)){
            money.prev().find('.total_manage_money').text(total_manage_money);
        }
        if(!isNaN(total_point)){
            money.next().find('.total_point').text(total_point);
        }
    }

    function update_manage_project(obj){
        let money = $(obj).parent().parent();
        let total_count=parseInt(money.prev().find('.ic1').val())+parseInt(money.prev().find('.ic2').val())+parseInt(money.prev().find('.ic3').val());
        let total_money=parseInt(money.next().find('.ip1').val())+parseInt(money.next().find('.ip2').val())+parseInt(money.next().find('.ip3').val());
        let total_manage_money=parseInt(money.find('.mp1').val())+parseInt(money.find('.mp2').val())+parseInt(money.find('.mp3').val());
        let total_point=parseFloat(money.next().next().find('.pc1').text())+parseFloat(money.next().next().find('.pc2').text())+parseFloat(money.next().next().find('.pc3').text());

        if(!isNaN(total_count)){
            money.prev().find('.total_count').text(total_count);
        }
        if(!isNaN(total_money)){
            money.next().find('.total_project_money').text(total_money);
        }
        if(!isNaN(total_manage_money)){
            money.find('.total_manage_money').text(total_manage_money);
        }
        if(!isNaN(total_point)){
            money.next().next().find('.total_point').text(total_point);
        }
    }

    function article(class_name,point_id){
        $('.count').on( 'keyup',class_name,function(){
            update_article(this);
        });

        $('.count1').on( 'keyup',class_name,function(){
            const count = $(this).val();
            $(this).parents('.count1').next().find(point_id).text(2*count);
            update_article(this);
        });

        $('.count2').on( 'keyup',class_name,function(){
            const count = $(this).val();
            $(this).parents('.count2').next().find(point_id).text(6*count);
            update_article(this);
        });

        $('.count4').on( 'keyup',function(){
            calculatePoint();
        });
    }

    function project(count,class_name,point_id){
        $('.count').on( 'keyup',count,function(){
            update_project_count(this);
        });

        $('.project_money1').on( 'keyup',class_name,function(){
            const money = $(this).val();
            $(this).parents('.project_money1').next().find(point_id).text(money/2);
            update_project(this);
        });

        $('.project_money2').on( 'keyup',class_name,function(){
            const money = $(this).val();
            $(this).parents('.project_money2').next().find(point_id).text(money/5);
            update_project(this);
        });
    }

    function project_with_manage(count,project_class,manage_class,point_id){
        $('.count').on( 'keyup',count,function(){
            update_project_count(this);
        });

        $('.project_money3').on( 'keyup',project_class,function(){
            const money = parseInt($(this).val());
            const manage = parseInt($(this).parents('.project_money3').prev().find(manage_class).val());
            $(this).parents('.project_money3').next().find(point_id).text((money+manage)/5);
            update_project_manage(this);
        });

        $('.manage_money1').on( 'keyup',manage_class,function(){
            const manage = parseInt($(this).val());
            const money = parseInt($(this).parents('.manage_money1').next().find(project_class).val());
            $(this).parents('.manage_money1').next().next().find(point_id).text((money+manage)/5);
            update_manage_project(this);
        });

        $('.project_money4').on( 'keyup',project_class,function(){
            const money = parseInt($(this).val());
            const manage = parseInt($(this).parents('.project_money4').prev().find(manage_class).val());
            $(this).parents('.project_money4').next().find(point_id).text((money+manage)/2);
            update_project_manage(this);
        });

        $('.manage_money2').on( 'keyup',manage_class,function(){
            const manage = parseInt($(this).val());
            const money = parseInt($(this).parents('.manage_money2').next().find(project_class).val());
            $(this).parents('.manage_money2').next().next().find(point_id).text((money+manage)/2);
            update_manage_project(this);
        });
    }

    $(document).ready(function(){
        $("#other_data").val("<%=json.optString("other_data", "")%>");
        wordsTotal();

        $("input").blur(function(){
            if($(this).val()==="" && $(this).type !== "date"){
                $(this).val("0");
                update_article(this);
                update_project_count(this);
                update_project(this);
                update_project_manage(this);
                update_manage_project(this);
            }
        });
        article('.ic1','.pc1');
        article('.ic2','.pc2');
        article('.ic3','.pc3');
        project('.ic1','.ip1','.pc1');
        project('.ic2','.ip2','.pc2');
        project('.ic3','.ip3','.pc3');
        project_with_manage('.ic1','.ip1','.mp1','.pc1');
        project_with_manage('.ic2','.ip2','.mp2','.pc2');
        project_with_manage('.ic3','.ip3','.mp3','.pc3');
        calculatePoint();
        $("input[name='declaration']").on('change', function() { checkDeclaration(); } ) ;
    });
</script>
</html>