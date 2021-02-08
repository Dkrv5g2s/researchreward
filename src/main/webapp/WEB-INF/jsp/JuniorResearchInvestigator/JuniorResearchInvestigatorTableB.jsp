<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");
%>
<html>
<head>
    <title>國立臺北科技大學特聘教授論文績效說明表(表B)</title>

    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <style>
        th{
            border-width: 1px;
            padding: 8px;
            border-style: groove;
            border-color: gray;
        }
        table{
            text-align: center;
        }
        .con{
            margin: 0 auto;
            padding: 50px;
        }
        .file_title{
            text-align: center;
            font-size: 24px;
            font-weight: bold;
        }
        .td_fwci{
            border-width: 3px;
            border-color: #000000;
        }
        .input_fwci{
            height: auto;
            width: 4rem;
            border-style: revert;
        }
        .initial_input {
            height: 100%;
            width: 100%;
            border-style: initial;
            text-align: center;
        }
        .left{
            text-align: left;
        }
    </style>
</head>
<body>
<div class="con">
    <form>
        <p class="file_title">年輕學者研究獎 表B 傑出論文績效說明表</p>
        <table>
            <thead>
                <tr>
                    <th colspan="2">申請人姓名(中/英文)</th>
                    <th colspan="2"><input name="applicant_name" class="initial_input" size="20" maxlength="40"></th>
                    <th>系所/職稱</th>
                    <th colspan="2"><input name="dep_job" class="initial_input" size="20" maxlength="40"></th>
                    <th>員工編號</th>
                    <th colspan="2"><input name="staff_code" class="initial_input" maxlength="40"></th>
                </tr>
                <tr style="border-bottom-style: groove;">
                    <th colspan="4">
                        <p>Journal Papers<br>(請以＊註記該篇所有之通訊作者，並檢附每篇論文首頁與以Scopus資料庫為主之證明文件。)</p>
                    </th>
                    <th>期刊排名R (W1)</th>
                    <th>作者排序 (W2)</th>
                    <th>通訊作者數 (W3)</th>
                    <th>額外加權 (W4)</th>
                    <th>換算點數 (A)<br>(=W1×W2×W3×W4)</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <tr>
                <td>作者</td>
                <td><input class="initial_input" name="author" maxlength="45" placeholder="AAA*, BBB, CCC"></td>
                <td>發表年份</td>
                <td><input name="publish_time" class="initial_input" maxlength="45" placeholder="May,2018."></td>

                <td rowspan="4" class="left">
                    <input type="checkbox" name="rank_condition" data-selection-block='onlyone'>Nature、Science及Cell (<label id="w1_1"></label>點)<br>
                    <input type="checkbox" name="rank_condition" data-selection-block='onlyone'>R≦1%及附表三期刊(<label id="w1_2"></label>點)<br>
                    <input type="checkbox" name="rank_condition" data-selection-block='onlyone'>1%&lt;R≦5%(<label id="w1_3"></label>點)<br>
                    <input type="checkbox" name="rank_condition" data-selection-block='onlyone'>5%&lt;R≦10%(<label id="w1_4"></label>點)<br>
                    <input type="checkbox" name="rank_condition" data-selection-block='onlyone'>10%&lt;R≦25%(<label id="w1_5"></label>點)<br>
                    <input type="checkbox" name="rank_condition" data-selection-block='onlyone'>25&lt;R≦40%(<label id="w1_6"></label>點)<br>
                    <input type="checkbox" name="rank_condition" data-selection-block='onlyone'>R&gt;40%(<label id="w1_7"></label>點)
                </td>
                <td rowspan="4" class="left">
                    <input type="checkbox" name="author_order">第一作者或通訊作者(×<label id="w2_1"></label>)<br>
                    <input type="checkbox" name="author_order">第二作者(×<label id="w2_2"></label>)<br>
                    <input type="checkbox" name="author_order">第三作者(×<label id="w2_3"></label>)<br>
                    <input type="checkbox" name="author_order">第四作者(×<label id="w2_4"></label>)<br>
                    <input type="checkbox" name="author_order">第五作者以上(×<label id="w2_5"></label>)<br>
                    <input type="checkbox" name="author_order">有多位Equal Contribution (×<label id="w2_6"></label>)
                </td>
                <td rowspan="4" class="left">
                    <input type="checkbox" name="communication_author_count">1位通訊作者(×<label id="w3_1"></label>)<br>
                    <input type="checkbox" name="communication_author_count">2位(含)以上(×<label id="w3_2"></label>)
                </td>
                <td rowspan="4" class="left">
                    <input type="checkbox" name="additional_weight">企業(×<label id="w4_1"></label>)<br>
                    <input type="checkbox" name="additional_weight">國際學者(×<label id="w4_2"></label>)<br>
                    <input type="checkbox" name="additional_weight">SDG(×<label id="w4_3"></label>)<br>
                    <input type="checkbox" name="additional_weight">SSCI(×<label id="w4_4"></label>)<br>
                    <input type="checkbox" name="additional_weight">企業、國際學者(×<label id="w4_5"></label>)<br>
                    <input type="checkbox" name="additional_weight">企業、SDG(×<label id="w4_6"></label>)<br>
                    <input type="checkbox" name="additional_weight">企業、SSCI(×<label id="w4_7"></label>)<br>
                    <input type="checkbox" name="additional_weight">國際學者、SSCI(×<label id="w4_8"></label>)<br>
                    <input type="checkbox" name="additional_weight">SDG、SSCI(×<label id="w4_9"></label>)<br>
                    <input type="checkbox" name="additional_weight">企業、SDG、SSCI(×<label id="w4_10"></label>)<br>
                    <input type="checkbox" name="additional_weight">國際學者、SDG、SSCI(×<label id="w4_11"></label>)<br>
                    <input type="checkbox" name="additional_weight">企業、國際學者、SDG、SSCI(×<label id="w4_12"></label>)
                </td>
                <td rowspan="4"><label id=column_point></label></td>
                <td rowspan="5" style="text-align: center;">
                    <input type="button" name="delete_paper" value="刪除">
                </td>
            </tr>
            <tr>
                <td>著作名稱</td>
                <td><input name="book_name" class="initial_input" maxlength="45" placeholder="Synergistic oooooooooocomposites"></td>
                <td>SCI/SSCI</td>
                <td><input name="sci_or_ssci" class="initial_input" maxlength="45" placeholder="SCI"></td>
            </tr>
            <tr>
                <td>期刊名稱</td>
                <td><input name="article_name" class="initial_input" maxlength="45" placeholder="Optics Express"></td>
                <td>Impact Factor</td>
                <td><input name="impact_factor" class="initial_input" maxlength="45" placeholder="7.3"></td>
            </tr>
            <tr>
                <td>卷數</td>
                <td><input name="total_roll" class="initial_input" maxlength="45" placeholder="Vol.127(2)"></td>
                <td>Scopus CiteScore Rank</td>
                <td><input name="impact_factor" class="initial_input" maxlength="45" placeholder="5/88=5.7%"></td>
            </tr>
            <tr style="border-bottom-style: groove;">
                <td>頁數</td>
                <td><input name="total_page" class="initial_input" maxlength="45" placeholder="pp1047-1053"></td>
                <td>領域別</td>
                <td><input name="impact_factor" class="initial_input" maxlength="45" placeholder="Optics"></td>
                <td colspan="3">
                    <input type="text" name="paper_first_page_file_name" value="檔案名稱">
                    <input type="button" name="paper_first_page" value="上傳論文首頁">
                    <input type="button" name="paper_first_page" value="檢視">
                </td>
                <td colspan="2">
                    <input type="text" name="joint_authoriztion_agreement_file_name" value="檔案名稱">
                    <input type="button" name="joint_authoriztion_agreement" value="上傳同意書">
                    <input type="button" name="joint_authoriztion_agreement" value="檢視">
                </td>
            </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="10" style="text-align: center;"><input type="button" value="新增" name="add_new_paper" onclick="addNewPaper()"></td>
                </tr>
                <tr>
                    <td colspan="5" class="td_fwci">近三年FWCI值<b><input name="FWCI_value_past_three_year" class="input_fwci"></b>，若為本校近三年FWCI值之1.5倍則加計點數<b>10</b>點(B)。</td>
                    <td colspan="2" class="td_fwci">總計點數 (A)+(B)</td>
                    <td colspan="3" id="a_plus_b_total_point" class="td_fwci"></td>
                </tr>
                <tr>
                    <td colspan="10" class="left">
                        <p>說明事項：</p>
                        <p style="padding-left: 2rem;">1. 近三年以本校名義發表之學術論著（此段期間曾生產或請育嬰假者得以延長，其延長期限依實際請假時間為依據，並檢附相關證明文件）始得採計。</p>
                        <p style="padding-left: 2rem;">2. 論文之期刊排名以出版年度為準，若無該出版年資料，則以前一年度為準。</p>
                        <p style="padding-left: 2rem;">3. <b>每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書。</b></p>
                    </td>
                </tr>
                <tr>
                    <td colspan="10" style="font-weight: bold;" class="left">
                        <input type="checkbox" name="declaration">申請人充分瞭解申請辦法，且上述資料與勾選事項皆屬實，若有誤願自行負完全的法律責任。<br>
                </tr>
            </tfoot>
        </table>
        <p style="text-align: center">
            <button type="button" name="return_last_page" onclick="location.href='JuniorResearchInvestigatorCatalog'">回上頁</button>
            <button type="button" name="save" onclick="commit()">存檔</button>
        </p>
    </form>
</div>

</body>
<script>
    $(document).ready(function() {
        $("input[placeholder]").each(function () {
            $(this).attr('size', $(this).attr('placeholder').length);
        });
    });
    function addNewPaper(){
        // $("tbody").appendChild($("tbody").childNodes.clone());
    }

    function commit(){
        let formData = new FormData();
        // formData.append('logo', logoImg);  //append files
        let objArr = [];
        objArr.push(InputToJson());
        formData.append('objArr', JSON.stringify( objArr ));
        $.ajax({
            type: 'POST',
            url: 'JuniorResearchInvestigatorTableB',
            dataType: 'text',
            // processData:false,
            // contentType: false,
            data: formData,
            contentType: 'application/json',
            success: function(){
                alert('存檔成功');
                window.location.href="JuniorResearchInvestigatorTableB";
            },
            error:function() {
                alert("存檔失敗");
            }
        });
    }
    function InputToJson() {
        let data = {};
        return data;
    }
</script>
</html>
