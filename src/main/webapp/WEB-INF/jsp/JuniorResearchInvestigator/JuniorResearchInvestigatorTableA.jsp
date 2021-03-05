
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
    <title>年輕學者研究獎 附件A 近三年內發表之期刊論文統計表</title>

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
                <td><input name="sw_article_count1" type="number" class="ic1" value="<%=json.optString("sw_article_count1", "0")%>"></td>
                <td><input name="sw_article_count2" type="number" class="ic2" value="<%=json.optString("sw_article_count2", "0")%>"></td>
                <td><input name="sw_article_count3" type="number" class="ic3" value="<%=json.optString("sw_article_count3", "0")%>"></td>
                <td id="sw_article_count_total" class="total_count"><%=json.optString("sw_article_count_total", "0")%></td>
            </tr>
            <tr class="count">
                <td colspan="2"><b>點數</b><br>(請參照 <a href="https://rnd.ntut.edu.tw/var/file/42/1042/img/214/488059897.pdf#page=3" target="_blank">附表一</a> )</td>
                <td><input id="sw_point1" name="sw_point1" type="number" class="ic1" value="<%=json.optString("sw_point1", "0")%>"></td>
                <td><input id="sw_point2" name="sw_point2" type="number" class="ic2" value="<%=json.optString("sw_point2", "0")%>"></td>
                <td><input id="sw_point3" name="sw_point3" type="number" class="ic3" value="<%=json.optString("sw_point3", "0")%>"></td>
                <td id="sw_point_total" class="total_count total_point" ><%=json.optString("sw_point_total", "0")%></td>
            </tr>
            <tr>
                <td colspan="6">
                    <p>說明：論文請檢附-表B「傑出論文績效說明表」</p>
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
                <td colspan="3">近三年FWCI值：<b><input id="fwci_value_past_three_year" name="fwci_value_past_three_year" type="number" class="input_fwci" value="<%=json.optString("fwci_value_past_five_year","0")%>"></b>
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
                <td colspan="6" class="left">
                    <p>說明：1.包含專利技術移轉金、著作權技術移轉金及知識性技術移轉金。</p>
                    <p style="margin-left: 2.5rem;">2.不包含科技部先期技術移轉授權金。</p>
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
                </td>
            </tr>
            </tbody>
        </table>
        <p style="text-align: center;">
            <button type="button" name="return_last_page" onclick="location.href='JuniorResearchInvestigatorCatalog'">回上頁</button>
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
    $("input[name='declaration']").on('change', function() { checkDeclaration(); } ) ;

    function commit(){
        $.ajax({
            type: 'POST',
            url: 'JuniorResearchInvestigatorTableA',
            dataType: 'text',
            data: JSON.stringify(InputToJson()),
            contentType: 'application/json',
            success: function(){
                alert('存檔成功');
                window.location.href="JuniorResearchInvestigatorTableA";
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
        data["commit_date"] = moment(new Date()).format("YYYY-MM-DD");
        return data;
    }

    function update_A_plus_B(){
        let sw_point_total = parseInt($("#sw_point_total").text());
        let t_point_total = parseInt($("#t_point_total").text());
        let a_book_point_total = parseInt($("#a_book_point_total").text());
        let a_article_point_total = parseInt($("#a_article_point_total").text());
        let fwci_value_past_three_year = parseFloat($("#fwci_value_past_three_year")[0].value);
        let school_fwci_value_past_three_year = ${fwci};
        let update_A_plus_B = sw_point_total+t_point_total+a_book_point_total+a_article_point_total;
        if(parseFloat(fwci_value_past_three_year) >= parseFloat(school_fwci_value_past_three_year*1.5).toFixed(3)) {
            update_A_plus_B += 10;
        }
        $("#a_plus_b_total_point").text(update_A_plus_B);
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
        update_A_plus_B();
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
            update_A_plus_B();
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
            if($(this).val()===""){
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
    });
</script>
</html>
