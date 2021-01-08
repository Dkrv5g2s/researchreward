<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container" style="margin: 0px auto; width: 1200px">
<p style="font-weight:bold;font-size:20px;text-align: center;">國立臺北科技大學傑出論文績效說明表(表B)</p>
</div>
<div class="container" style="margin: 0px auto; width: 1200px">
<form method="post" action="Plan?func=international_formC001" enctype="multipart/form-data" id="c001_form">
    <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
        <tbody style="text-align: center;">
            <tr>
                <td colspan="4" width="50%">申請人姓名(中/英文):<input name="applicant_name" size="20" maxlength="40"></td>
                <td colspan="3" width="40%">系所/職稱:<input name="dep_job" size="20" maxlength="40"></td>
                <td colspan="1" width="10%">員工編號:<input name="staff_code" size="10" maxlength="40"></td>
            </tr>
            <tr>
                <td colspan="2" width="20%">Journal Papers<br>
                    請依序填寫：姓名、著作名稱、期刊名稱、卷數、頁數、發表年份(SCI/SSCI,Impact Factor;Scopus CiteScore Rank,領域別) 並以＊註記該篇所有之通訊作者，檢附每篇論文首頁與以Scopus資料庫為主之證明文件。範例:AAA*, BBB, CCC, “Synergistic oooooooooocomposites,“Optics Express,Vol.127(2), pp1047-1053, May,2018. (SCI, Impact Factor =7.3;CiteScore Rank: 5/88=5.7%,Optics )
                </td>
                <td colspan="1" width="15%">期刊排名R<br>(W1)</td>
                <td colspan="1">作者排序<br>(W2)</td>
                <td colspan="1">通訊作者數<br>(W3)</td>
                <td colspan="1">額外加權<br>(W4)</td>
                <td colspan="1">換算點數<br>(A)<br>(=W1×W2×W3×W4)</td>
                <td colspan="1"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: left;">姓名:<input name="author" size="10" maxlength="40"><br>
                    著作名稱:<input name="book_name" size="10" maxlength="40"><br>
                    期刊名稱:<input name="article_name" size="10" maxlength="40"><br>
                    捲數:<input name="total_roll" size="5" maxlength="5"><br>
                    頁數:<input name="total_page" size="5" maxlength="5"><br>
                    發表年份:<input name="publish_time" size="15" maxlength="40">
                </td>
                <td colspan="1" style="text-align: left;"><input type="checkbox" name="rank_condition_one">Nature、Science及Cell (150點)<br>
                    <input type="checkbox" name="rank_condition_two">R≦1%及附表三期刊(40點)<br>
                    <input type="checkbox" name="rank_condition_three">1%&lt;R≦5%(20點)<br>
                    <input type="checkbox" name="rank_condition_four">5%&lt;R≦10%(10點)<br>
                    <input type="checkbox" name="rank_condition_five">10%&lt;R≦25%(5點)<br>
                    <input type="checkbox" name="rank_condition_six">25&lt;R≦40%(2點)<br>
                    <input type="checkbox" name="rank_condition_seven">R&gt;40%(1點)
                </td>
                <td colspan="1" style="text-align: left;"><input type="checkbox" name="author_order_one">第一作者或通訊作者(×1)<br>
                    <input type="checkbox" name="author_order_two">第二作者(×0.8)<br>
                    <input type="checkbox" name="author_order_three">第三作者(×0.6)<br>
                    <input type="checkbox" name="author_order_four">第四作者(×0.4)<br>
                    <input type="checkbox" name="author_order_five">第五作者以上(×0.2)<br>
                    <input type="checkbox" name="author_order_six">有多位Equal Contribution (×0.9)
                </td>
                <td colspan="1" style="text-align: left;"><input type="checkbox" name="communication_author_count_one">1位通訊作者(×1)<br>
                    <input type="checkbox" name="communication_author_count_two">2位(含)以上(×0.8)
                </td>
                <td colspan="1" style="text-align: left;"><input type="checkbox" name="additional_weight_one">企業(×1.1)<br>
                    <input type="checkbox" name="additional_weight_two">國際學者(×1.1)<br>
                    <input type="checkbox" name="additional_weight_three">企業及國際學者(×1.2)<br>
                    <input type="checkbox" name="additional_weight_four">SSCI(×1.5)<br>
                    <input type="checkbox" name="additional_weight_five">SSCI、企業(×1.65)<br>
                    <input type="checkbox" name="additional_weight_six">SSCI、國際學者(×1.65)<br>
                    <input type="checkbox" name="additional_weight_seven">SSCI、企業及國際學者(×1.8)
                </td>
                <td colspan="1" style="text-align: left;"><label id=column_point></label>
                </td>
                <td colspan="1" style="text-align: center;"><input type="button" name="delete_paper" value="刪除">
                </td>
            </tr>
            <tr>
                <td colspan="8" style="text-align: center;"><input type="button" value="新增" name="add_new_paper"></td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: left;border-width:3px;border-color: #000000">近五年FWCI值<input name="FWCI_value_past_five_year">,若為本校近五年FWCI值之1.5倍則加計點數10點(B)。</td>
                <td colspan="1" style="border-width: 3px;border-color: #000000">總計點數<br>(A)+(B)</td>
                <td colspan="3" style="border-width: 3px;border-color: #000000"><label id=" total_point"></label></td>
            </tr>
            <tr>
                <td colspan="8" style="text-align: left;">申請說明事項：<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;1.請檢附期刊發表之論文首頁及各篇期刊排名。學術論著正式出版年度以紙本刊登年度為準，若無紙本出版則以電子期刊出版年為基準。<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;2.請檢附Scopus資料庫或SciVal分析系統之佐證(含期刊排名CiteScore、國際學者、企業、FWCI)。<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;3.若某篇論文為SSCI且有企業及國際合著者，權重至多1.8倍計。<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;4.每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書。
                </td>
            </tr>
            <tr>
                <td colspan="8" style="text-align: left;font-weight: bold;"><input type="checkbox" name="declaration"><font color="red">申請人充分瞭解申請辦法，且上述資料與勾選事項皆屬實，若有誤願自行負完全的法律責任。</font><br><br><br>
                    <a style="margin-left: 100px">申請人簽章:<input name="applicant_sign" size="10" maxlength="40"></a>
                    <a style="margin-left: 400px">日期:<input name="sign_time" value="" size="10" maxlength="20" type="text" id="d01" readonly><input value="..." type="button" onclick="WdatePicker({el:'d01'})"></a></td>
            </tr>
            
        </tbody>
    </table>
</form>
</div>
<script>
</script>