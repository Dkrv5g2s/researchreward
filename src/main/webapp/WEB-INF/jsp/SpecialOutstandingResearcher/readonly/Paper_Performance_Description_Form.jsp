<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="com.google.gson.*" %>

<%@ page import="Bean.Project.RewardProject" %>
<%  /*避免瀏覽器因cache而無法看到最新資料*/
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE HTML>
<html lang="zh">
<link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<div class="container">
    <p class="four_sections three_years five_years" style="font-weight:bold;font-size:20px;text-align: center;">國立臺北科技大學傑出論文績效說明表</p>
    <p class="table_c" style="font-weight:bold;font-size:20px;text-align: center;">研究績優教師執行第<input id="numOfPerformancePeriod" name="numOfPerformancePeriod" size="1" maxlength="4" style="text-align:center;" readonly>期績效說明表(申請第二期以上者填寫)</p>
</div>
<div class="container" style="margin: 0px auto;width: 90%;">
    <form method="post" action="Plan?func=international_formC001" enctype="multipart/form-data" id="c001_form">
        <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <thead style="text-align: center;">
            <%--            <tr>--%>
            <%--                <td colspan="4" width="50%">申請人姓名(中/英文):<input name="applicant_name" size="20" maxlength="40"></td>--%>
            <%--                <td colspan="3" width="40%">系所/職稱:<input name="dep_job" size="20" maxlength="40"></td>--%>
            <%--                <td colspan="1" width="10%"></td>--%>
            <%--            </tr>--%>
            <tr>
                <td colspan="2" width="20%">Journal Papers<br>
                    請依序填寫：姓名、著作名稱、期刊名稱、卷數、頁數、發表年份(SCI/SSCI,Impact Factor;Scopus CiteScore Rank,領域別) 並以＊註記該篇所有之通訊作者，檢附每篇論文首頁與以Scopus資料庫為主之證明文件。範例:AAA*, BBB, CCC, “Synergistic oooooooooocomposites,“Optics Express,Vol.127(2), pp1047-1053, May,2018. (SCI, Impact Factor =7.3;CiteScore Rank: 5/88=5.7%,Optics )
                </td>
                <td colspan="1" width="15%">期刊排名R<br>(W1)</td>
                <td colspan="1" width="15%">作者排序<br>(W2)</td>
                <td colspan="1" width="15%">通訊作者數<br>(W3)</td>
                <td colspan="1" width="15%">額外加權<br>(W4)</td>
                <td colspan="1" width="15%">換算點數<br>(A)<br>(=W1×W2×W3×W4)</td>
            </tr>
            </thead>
            <tbody id="data_table" style="text-align: center;">

            </tbody>
            <tbody>
            <tr>
                <%--                <td colspan="4" class="three_years table_c" style="text-align: left;border-width:3px;border-color: #000000">近三年FWCI值<input name="fwci_value_past_five_year">,若為本校近三年FWCI值之1.5倍則加計點數10點(B)。</td>--%>
                <%--                <td colspan="4" class="five_years four_sections" style="text-align: left;border-width:3px;border-color: #000000">近五年FWCI值<input name="fwci_value_past_five_year">,若為本校近五年FWCI值之1.5倍則加計點數10點(B)。</td>--%>
                <td colspan="4" style="text-align: left;border-width:3px;"></td>
                <td colspan="1" style="border-width: 3px;border-color: #000000">總計點數<br>(A)</td>
                <td colspan="2" style="border-width: 3px;border-color: #000000"><label id="total_point"></label></td>
            </tr>
            <tr>
                <td colspan="8" style="text-align: left;" class="four_sections">申請說明事項：<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;1.請檢附期刊發表之論文首頁及各篇期刊排名。學術論著正式出版年度以紙本刊登年度為準，若無紙本出版則以電子期刊出版年為基準。<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;2.請檢附Scopus資料庫或SciVal分析系統之佐證(含期刊排名CiteScore、國際學者、企業、FWCI)。<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;3.若某篇論文為SSCI且有企業及國際合著者，權重至多1.8倍計。<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;4.每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書。
                </td>
                <td colspan="8" style="text-align: left;" class="three_years five_years table_c">
                    <p>說明事項：</p>
                    <p class="three_years" style="padding-left: 2rem;">1. 近三年以本校名義發表之學術論著（此段期間曾生產或請育嬰假者得以延長，其延長期限依實際請假時間為依據，並檢附相關證明文件）始得採計。</p>
                    <p class="five_years" style="padding-left: 2rem;">1. 近五年以本校名義發表之學術論著（此段期間曾生產或請育嬰假者得以延長，其延長期限依實際請假時間為依據，並檢附相關證明文件）始得採計。</p>
                    <p class="table_c" style="padding-left: 2rem;">1. <b>績優教師執行第一期</b>以本校名義發表之學術論著。</p>
                    <p style="padding-left: 2rem;">2. 論文之期刊排名以出版年度為準，若無該出版年資料，則以前一年度為準。</p>
                    <p style="padding-left: 2rem;">3. <b>每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書。</b></p>
                </td>
            </tr>
            <tr>
                <td colspan="7" style="background-color:rgb(255, 255, 240);text-align: center">
                    <input type="button" width="10%" value="回目錄" name="return_last_page" onclick="location.href='${catalogURL}'" >
                    <button type="button" name="confirm" onclick="location.href='PaperPerformanceDescriptionUpload'">此頁審查完成</button>
                </td>
            </tr>
            </tbody>

        </table>
    </form>
</div>
<script>
    var latest_data = ${latest_data} ;
    var wight = ${weight} ;
    let tableCJson = ${tableCJson};
    let IsTableC = tableCJson.isTableC;
    //var paper_performence_list = latest_data["paper_performance_list"] ;

    function load(){
        showSection();
        showDatas() ;
        calculateTotal() ;
    }

    function showSection(){
        $(".three_years").hide();
        $(".five_years").hide();
        $(".four_sections").hide();
        $(".table_c").hide();
        let displayExplanation = "${displayExplanation}";

        if(displayExplanation==="four_sections"){
            $(".four_sections").show();
        }
        else if(displayExplanation==="three_years"){
            $(".three_years").show();
        }
        else if(displayExplanation==="five_years"){
            $(".five_years").show();
        }
        else{
            $(".table_c").show();
        }
    }


    function setWeight() {
        $("input[value='Nature、Science及Cell']" ).attr( 'data-weight', wight["w1_1"] );
        $("input[value='R≦1%及附表三期刊']" ).attr( 'data-weight', wight["w1_2"] );
        $("input[value='1%<R≦5%']" ).attr( 'data-weight', wight["w1_3"] );
        $("input[value='5%<R≦10%']" ).attr( 'data-weight', wight["w1_4"] );
        $("input[value='10%<R≦25%']" ).attr( 'data-weight', wight["w1_5"] );
        $("input[value='25%<R≦40%']" ).attr( 'data-weight', wight["w1_6"] );
        $("input[value='R>40%']" ).attr( 'data-weight', wight["w1_7"] );

        $("input[value='第一作者或通訊作者']" ).attr( 'data-weight', wight["w2_1"] );
        $("input[value='第二作者']" ).attr( 'data-weight', wight["w2_2"] );
        $("input[value='第三作者']" ).attr( 'data-weight', wight["w2_3"] );
        $("input[value='第四作者']" ).attr( 'data-weight', wight["w2_4"] );
        $("input[value='第五作者以上']" ).attr( 'data-weight', wight["w2_5"] );
        $("input[value='有多位Equal Contribution']" ).attr( 'data-weight', wight["w2_6"] );

        $("input[value='1位通訊作者']" ).attr( 'data-weight', wight["w3_1"] );
        $("input[value='2位(含)以上']" ).attr( 'data-weight', wight["w3_2"] );

        $("input[value='企業']" ).attr( 'data-weight', wight["w4_1"] );
        $("input[value='國際學者']" ).attr( 'data-weight', wight["w4_2"] );
        $("input[value='SDG']" ).attr( 'data-weight', wight["w4_3"] );
        $("input[value='SSCI']" ).attr( 'data-weight', wight["w4_4"] );
        $("input[value='企業及國際學者']" ).attr( 'data-weight', wight["w4_5"] );
        $("input[value='企業、SDG']" ).attr( 'data-weight', wight["w4_6"] );
        $("input[value='企業、SSCI']" ).attr( 'data-weight', wight["w4_7"] );
        $("input[value='國際學者、SSCI']" ).attr( 'data-weight', wight["w4_8"] );
        $("input[value='SDG、SSCI']" ).attr( 'data-weight', wight["w4_9"] );
        $("input[value='企業、SDG、SSCI']" ).attr( 'data-weight', wight["w4_10"] );
        $("input[value='國際學者、SDG、SSCI']" ).attr( 'data-weight', wight["w4_11"] );
        $("input[value='企業、國際學者、SDG、SSCI']" ).attr( 'data-weight', wight["w4_12"] );
        $("input[value='國際學者、SDG']" ).attr( 'data-weight', wight["w4_13"] );
        $("input[value='企業、國際學者、SDG']" ).attr( 'data-weight', wight["w4_14"] );
        $("input[value='企業、國際學者、SSCI']" ).attr( 'data-weight', wight["w4_15"] );

        $("label[name='1_1']").text( "Nature、Science及Cell(" + wight["w1_1"] + "點)" ) ;
        $("label[name='1_2']").text( "R≦1%及附表三期刊(" + wight["w1_2"] + "點)" ) ;
        $("label[name='1_3']").text( "1%<R≦5%(" + wight["w1_3"] + "點)" ) ;
        $("label[name='1_4']").text( "5%<R≦10%(" + wight["w1_4"] + "點)" ) ;
        $("label[name='1_5']").text( "10%<R≦25%(" + wight["w1_5"] + "點)" ) ;
        $("label[name='1_6']").text( "25%<R≦40%(" + wight["w1_6"] + "點)" ) ;
        $("label[name='1_7']").text( "R>40%(" + wight["w1_7"] + "點)" ) ;

        $("label[name='2_1']").text( "第一作者或通訊作者(×" + wight["w2_1"] + ")" ) ;
        $("label[name='2_2']").text( "第二作者(×" + wight["w2_2"] + ")" ) ;
        $("label[name='2_3']").text( "第三作者(×" + wight["w2_3"] + ")" ) ;
        $("label[name='2_4']").text( "第四作者(×" + wight["w2_4"] + ")" ) ;
        $("label[name='2_5']").text( "第五作者以上(×" + wight["w2_5"] + ")" ) ;
        $("label[name='2_6']").text( "有多位Equal Contribution(×" + wight["w2_6"] + ")" ) ;

        $("label[name='3_1']").text( "1位通訊作者(×" + wight["w3_1"] + ")" ) ;
        $("label[name='3_2']").text( "2位(含)以上(×" + wight["w3_2"] + ")" ) ;

        $("label[name='4_1']").text( "企業(×" + wight["w4_1"] + "點)" ) ;
        $("label[name='4_2']").text( "國際學者(×" + wight["w4_2"] + "點)" ) ;
        $("label[name='4_3']").text( "SDG(×" + wight["w4_3"] + "點)" ) ;
        $("label[name='4_4']").text( "SSCI(×" + wight["w4_4"] + "點)" ) ;
        $("label[name='4_5']").text( "企業及國際學者(×" + wight["w4_5"] + "點)" ) ;
        $("label[name='4_6']").text( "企業、SDG(×" + wight["w4_6"] + "點)" ) ;
        $("label[name='4_7']").text( "企業、SSCI(×" + wight["w4_7"] + "點)" ) ;
        $("label[name='4_8']").text( "國際學者、SSCI(×" + wight["w4_8"] + "點)" ) ;
        $("label[name='4_9']").text( "SDG、SSCI(×" + wight["w4_9"] + "點)" ) ;
        $("label[name='4_10']").text( "企業、SDG、SSCI(×" + wight["w4_10"] + "點)" ) ;
        $("label[name='4_11']").text( "國際學者、SDG、SSCI(×" + wight["w4_11"] + "點)" ) ;
        $("label[name='4_12']").text( "企業、國際學者、SDG、SSCI(×" + wight["w4_12"] + "點)" ) ;
        $("label[name='4_13']").text( "國際學者、SDG(×" + wight["w4_13"] + "點)" ) ;
        $("label[name='4_14']").text( "企業、國際學者、SDG(×" + wight["w4_14"] + "點)" ) ;
        $("label[name='4_15']").text( "企業、國際學者、SSCI(×" + wight["w4_15"] + "點)" ) ;

    }

    $(document).ready( load() );


    function add_new_item(){
        datasFromTable();
        var item = {};
        item.author_name = "" ;
        item.book_name = "";
        item.scholarly_journals_name = "";
        item.total_roll = "";
        item.total_page = "";
        item.publish_time = "";
        item.content = "";
        item.rank_of_scholarly_journals = "" ;
        item.author_order = "" ;
        item.communication_author_count = "" ;
        item.additional_weight = "" ;
        item.cal_point = "" ;
        item.paper_id = 0 ;
        latest_data["paper_performance_list"].push(item);
        showDatas();
        calculateTotal();
    }

    function makeNewItemHtml( i ) {
        var html_of_item = "";
        html_of_item += "<tr>" ;

        html_of_item += "<td colspan='2' style='text-align: left;'>姓名:<input name='author_name" + i + "' size='10' maxlength='40' readonly><br>" ;
        html_of_item += "著作名稱:<input name='book_name" + i + "' size='10' maxlength='150' readonly><br>" ;
        html_of_item += "期刊名稱:<input name='scholarly_journals_name" + i +"' size='10' maxlength='150' readonly><br>" ;
        html_of_item += "卷數:<input name='total_roll" + i + "' size='5' maxlength='5' readonly><br>" ;
        html_of_item += "頁數:<input name='total_page" + i + "' size='5' maxlength='5' readonly><br>" ;
        html_of_item += "發表年份:<input name='publish_time" + i + "' size='15' maxlength='4' readonly>" ;
        html_of_item += "<input name='paper_id" + i + "' style='display: none' readonly >" ;
        html_of_item += "</td>" ;

        html_of_item += "<td colspan='1' style='text-align: left;'><input type='checkbox' data-selection-block='onlyone' data-weight='150' name='rank_of_scholarly_journals" + i + "' value='Nature、Science及Cell'><label name='1_1'>Nature、Science及Cell</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='40' name='rank_of_scholarly_journals" + i +"' value='R≦1%及附表三期刊'><label name='1_2'>R≦1%及附表三期刊</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='20' name='rank_of_scholarly_journals" + i + "' value='1%<R≦5%'><label name='1_3'>1%&lt;R≦5%</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='10' name='rank_of_scholarly_journals"+ i +"' value='5%<R≦10%' ><label name='1_4'>5%&lt;R≦10%</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='5' name='rank_of_scholarly_journals" + i + "' value='10%<R≦25%' ><label name='1_5'>10%&lt;R≦25%</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='2' name='rank_of_scholarly_journals" + i + "' value='25%<R≦40%'><label name='1_6'>25%&lt;R≦40%</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='1' name='rank_of_scholarly_journals" + i + "' value='R>40%'><label name='1_7'>R&gt;40%</label>" ;
        html_of_item += "</td>" ;

        html_of_item += "<td colspan='1' style='text-align: left;'><input id='2_1' type='checkbox' data-selection-block='onlyone' data-weight='1' name='author_order"+i+"' value='第一作者或通訊作者'><label name='2_1'>第一作者或通訊作者</label><br>" ;
        html_of_item += "<input id='2_2' type='checkbox' data-selection-block='onlyone' data-weight='0.8' name='author_order"+i+"' value='第二作者'><label name='2_2'>第二作者</label><br>" ;
        html_of_item += "<input id='2_3' type='checkbox' data-selection-block='onlyone' data-weight='0.6' name='author_order"+i+"' value='第三作者'><label name='2_3'>第三作者</label><br>" ;
        html_of_item += "<input id='2_4' type='checkbox' data-selection-block='onlyone' data-weight='0.4' name='author_order"+i+"' value='第四作者'><label name='2_4'>第四作者</label><br>" ;
        html_of_item += "<input id='2_5' type='checkbox' data-selection-block='onlyone' data-weight='0.2' name='author_order"+i+"' value='第五作者以上'><label name='2_5'>第五作者以上</label><br>" ;
        html_of_item += "<input id='2_6' type='checkbox' data-selection-block='onlyone' data-weight='0.9' name='author_order"+i+"' value='有多位Equal Contribution'><label name='2_6'>多位Equal Contribution</label>" ;
        html_of_item += "</td>" ;

        html_of_item += "<td colspan='1' style='text-align: left;'><input type='checkbox' data-selection-block='onlyone' data-weight='1' name='communication_author_count"+i+"' value='1位通訊作者'><label name='3_1'>1位通訊作者</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='0.8' name='communication_author_count"+i+"' value='2位(含)以上'><label name='3_2'>2位(含)以上</label>" ;
        html_of_item += "</td>" ;

        html_of_item += "<td colspan='1' style='text-align: left;'><input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_1"] +"' name='additional_weight"+i+"' value='企業'><label name='4_1'>企業</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_2"] +"' name='additional_weight"+i+"' value='國際學者'><label name='4_2'>國際學者</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_3"] +"' name='additional_weight"+i+"' value='SDG'><label name='4_3'>SDG</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_4"] +"' name='additional_weight"+i+"' value='SSCI'><label name='4_4'>SSCI</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_5"] +"' name='additional_weight"+i+"' value='企業及國際學者'><label name='4_5'>企業、國際學者</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_6"] +"' name='additional_weight"+i+"' value='企業、SDG'><label name='4_6'>企業、SDG</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_13"] +"' name='additional_weight"+i+"' value='國際學者、SDG'><label name='4_13'>國際學者、SDG</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_7"] +"' name='additional_weight"+i+"' value='企業、SSCI'><label name='4_7'>企業、SSCI</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_8"] +"' name='additional_weight"+i+"' value='國際學者、SSCI'><label name='4_8'>國際學者、SSCI</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_9"] +"' name='additional_weight"+i+"' value='SDG、SSCI'><label name='4_9'>SDG、SSCI</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_14"] +"' name='additional_weight"+i+"' value='企業、國際學者、SDG'><label name='4_14'>企業、國際學者、SDG</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_15"] +"' name='additional_weight"+i+"' value='企業、國際學者、SSCI '><label name='4_15'>企業、國際學者、SSCI </label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_10"] +"' name='additional_weight"+i+"' value='企業、SDG、SSCI'><label name='4_10'>企業、SDG、SSCI</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_11"] +"' name='additional_weight"+i+"' value='國際學者、SDG、SSCI'><label name='4_11'>國際學者、SDG、SSCI</label><br>" ;
        html_of_item += "<input type='checkbox' data-selection-block='onlyone' data-weight='" + wight["w4_12"] +"' name='additional_weight"+i+"' value='企業、國際學者、SDG、SSCI'><label name='4_12'>企業、國際學者、SDG、SSCI</label>" ;

        html_of_item += "</td>" ;

        html_of_item += "<td colspan='1' style='text-align: center;'><label name='cal_point"+i+"'></label>" ;
        html_of_item += "</td>" ;


        html_of_item += "</tr>" ;

        return html_of_item ;
    }


    function datasFromTable(){
        latest_data["paper_performance_list"] = [];
        var i=0;
        while($("input[name='author_name"+i+"']").length>0){
            var item = {};
            item.author_name = $("input[name='author_name"+i+"']").val();
            item.book_name = $("input[name='book_name"+i+"']").val();
            item.scholarly_journals_name = $("input[name='scholarly_journals_name"+i+"']").val();
            item.total_roll = $("input[name='total_roll"+i+"']").val();
            item.total_page = $("input[name='total_page"+i+"']").val();
            item.publish_time = $("input[name='publish_time"+i+"']").val();
            item.rank_of_scholarly_journals = $("input:checked[name='rank_of_scholarly_journals"+i+"']").val();
            item.author_order =  $("input:checked[name='author_order"+i+"']").val();
            item.communication_author_count = $("input:checked[name='communication_author_count"+i+"']").val();
            item.additional_weight =  $("input:checked[name='additional_weight"+i+"']").val();
            item.cal_point =  $("label[name='cal_point"+i+"']").text();
            item.paper_id = $("input[name='paper_id"+ i +"']").val() ;

            latest_data["paper_performance_list"].push(item);
            i++;
        }

        latest_data["fwci_value_past_five_year"] = $('input[name="fwci_value_past_five_year"]').val() ;
        latest_data["fwci_value_past_five_year"] = $('label[id="total_point"]').text() ;

    }

    function showDatas(){
        var html = "";
        var paper_performence = latest_data["paper_performance_list"];

        for(var i=0;i<paper_performence.length;i++){
            var h = "";
            h += makeNewItemHtml( i ) ;
            html+=h;
        }
        if(html=="")
            html = "<tr></tr>";
        $("#data_table").html(html);

        if(IsTableC)
            $("input[id='numOfPerformancePeriod']").val(tableCJson.numOfPerformancePeriod);

        for(var i=0;i<paper_performence.length;i++){

            $("input[name='author_name"+i+"']").val(paper_performence[i].author_name);
            $("input[name='book_name"+i+"']").val(paper_performence[i].book_name);
            $("input[name='scholarly_journals_name"+i+"']").val(paper_performence[i].scholarly_journals_name);
            $("input[name='paper_id"+i+"']").val(paper_performence[i].paper_id);

            $("input[name='total_roll"+i+"']").val(paper_performence[i].total_roll);
            $("input[name='total_page"+i+"']").val(paper_performence[i].total_page);
            $("input[name='publish_time"+i+"']").val(paper_performence[i].publish_time);

            $("input[name='rank_of_scholarly_journals" + i + "'][value='"+paper_performence[i]["rank_of_scholarly_journals"]+ "']").prop("checked",true);
            $("input[name='author_order" + i + "'][value='"+paper_performence[i]["author_order"]+ "']").prop("checked",true);
            $("input[name='communication_author_count" + i + "'][value='"+paper_performence[i]["communication_author_count"]+ "']").prop("checked",true);

            $("input[name='additional_weight" + i + "'][value='"+paper_performence[i]["additional_weight"] + "']").prop("checked",true);
            $("label[name='cal_point"+i+"']").text(paper_performence[i].cal_point);
        }
        setWeight();
    }


    function calculateTotal() {
        datasFromTable()
        let sumOfTotalcolumn = 0.0;
        console.log("latest_data[paper_performance_list]",latest_data["paper_performance_list"]);
        for(var i=0;i<latest_data["paper_performance_list"].length;i++){
            var cal_total = parseFloat( $("input:checked[name='rank_of_scholarly_journals"+i+"']" ).attr( 'data-weight' )) ;
            cal_total *= parseFloat( $("input:checked[name='author_order"+i+"']" ).attr( 'data-weight' )) ;
            cal_total *= parseFloat( $("input:checked[name='communication_author_count"+i+"']" ).attr( 'data-weight' )) ;
            let additional_weight = parseFloat( $("input:checked[name='additional_weight"+i+"']" ).attr( 'data-weight' ));
            cal_total *= isNaN(additional_weight) ? 1 : additional_weight;

            if ( isNaN(cal_total) ){
                cal_total = "請確認W1至w3欄位皆勾選";
            }else{
                cal_total = financial(cal_total);
                sumOfTotalcolumn += Number.parseFloat(cal_total);
            }
            $("label[name='cal_point"+i+"']").text(cal_total);
        }

        $('input[name="fwci_value_past_five_year"]').val("0") ;


        $('label[id="total_point"]').text(financial(sumOfTotalcolumn)) ;

    }
    function financial(x) {
        return Number.parseFloat(x).toFixed(2);
    }
    $(document).on("change", "input[data-selection-block='onlyone']", function () {
        $(this).siblings().prop("checked", false) ;
        calculateTotal()
    } ) ;

    $(document).on("click", "input[type='checkbox']", function () {
        return false ;
    })

</script>
</html>