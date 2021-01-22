<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container" style="margin: 0px auto; width: 1200px">
    <p style="text-align:center;font-weight:bold;font-size:20px;">國立臺北科技大學獎勵特殊優秀研究人才傑出績效說明表(表A)</p>
</div>
<div class="container" style="margin: 0px auto; width: 1200px">
    <form method="post" action="Plan?func=international_formC001" enctype="multipart/form-data" id="c001_form">
        <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <tbody>
                <tr style="text-align:center;background:  #C0C0C0 ">
                    <td rowspan="2" colspan="2" width="30%">學術論著</td>
                    <td colspan="5" width="60%" style="text-align: center;">年度</td>
                    <td rowspan="2" width="10%" colspan="1">小記<br>(A)</td>
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
                <tr>
                    <td colspan="9" width="100%">
                        <p>說明：
                            1. 近五年以本校名義發表之學術論著（此段期間曾生產或請育嬰假者得以延長，其延長期限依實際請假時間為依據，並檢附相關證明文件）始得採計。</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. 論文之期刊排名以出版年度為準，若無該出版年資料，則以前一年度為準。</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. 每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書。</p>
                    </td>
                </tr>
                <tr style="text-align:center;background:  #C0C0C0 ">
                    <td rowspan="2" colspan="2" width="30%">科 技 部 計 畫</td>
                    <td colspan="5" width="60%" style="text-align: center;">年度</td>
                    <td rowspan="2" width="10%" colspan="1">小記</td>
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
                <tr style="text-align: center;">
                    <td colspan="7" width="80%">說明：不包含科技部產學合作計畫。</td>
                </tr>
                <tr style="text-align:center;background:  #C0C0C0 ">
                    <td rowspan="2" colspan="2" width="30%">產 學 合 作 計 畫</td>
                    <td colspan="5" width="60%" style="text-align: center;">年度</td>
                    <td rowspan="2" width="10%" colspan="1">小記</td>
                </tr>
                <tr style="text-align:center;background:  #C0C0C0 ">
                    <td colspan="1" width="12%"><label id="year_1">104</label></td>
                    <td colspan="1" width="12%"><label id="year_2">105</label></td>
                    <td colspan="1" width="12%"><label id="year_3">106</label></td>
                    <td colspan="1" width="12%"><label id="year_4">107</label></td>
                    <td colspan="1" width="12%"><label id="year_5">108</label></td>
                </tr>
                <tr style="text-align: center;">
                    <td rowspan="6" colspan="1" width="20%">近五年以本校名義所獲得之產學合作計畫，其實際納入本校校務基金之統計表</td>
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
                    <td colspan="1" width="10%" style="text-align: center;">產學處<br>(簽章)</td>
                    <td colspan="6" width="70%">承辦人<input name="case_officer" size="10" maxlength="40">&nbsp;&nbsp;單位主管<input name="department_head" size="10" maxlength="40"><br>※以第七級第4項、第八級及第九級第5項(3)申請者，請產學處填寫確認計畫及管理費總金額後核章</td>
                </tr>
                <tr>
                    <td colspan="7" width="80%">
                        <p>說明：1.包含科技部產學合作計畫、政府機關及財團法人之研究型計畫。</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. 不包含以學校名義開授訓練課程招生收入。</p>
                    </td>
                </tr>
                <tr style="text-align:center;background:  #C0C0C0 ">
                    <td rowspan="2" colspan="2" width="30%">技 術 移 轉 金</td>
                    <td colspan="5" width="60%" style="text-align: center;">年度</td>
                    <td rowspan="2" width="10%" colspan="1">小記</td>
                </tr>
                <tr style="text-align:center;background:  #C0C0C0 ">
                    <td colspan="1" width="12%"><label id="year_1">104</label></td>
                    <td colspan="1" width="12%"><label id="year_2">105</label></td>
                    <td colspan="1" width="12%"><label id="year_3">106</label></td>
                    <td colspan="1" width="12%"><label id="year_4">107</label></td>
                    <td colspan="1" width="12%"><label id="year_5">108</label></td>
                </tr>
                <tr style="text-align: center;">
                    <td rowspan="6" colspan="1" width="20%">近五年以本校名義所獲之實收技術移轉金統計表</td>
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
                    <td colspan="1" width="10%" style="text-align: center;">產學處<br>(簽章)</td>
                    <td colspan="6" width="70%">承辦人<input name="case_officer" size="10" maxlength="40">&nbsp;&nbsp;單位主管<input name="department_head" size="10" maxlength="40"><br>※以第七級第5項及第八級第5項(4)申請者，請產學處填寫確認技轉金及管理費金額後核章</td>
                </tr>
                <tr>
                    <td colspan="7" width="80%">
                        <p>說明：1.包含專利技術移轉金、著作權技術移轉金及知識性技術移轉金。</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.不包含科技部先期技術移轉授權金。</p>
                    </td>
                </tr>
                <tr>
                    <td colspan="9" width="100%" style="text-align: center; background: #C0C0C0">審 查 佐 證 資 料 (請參見下頁填寫說明)</td>
                </tr>
                <tr>
                    <td colspan="9" width="100%"><br><br><br><br><br><br></td>
                </tr>
                <tr>
                    <td colspan="9" width="100%"><input type="checkbox" name="declaration">申請人聲明&nbsp;充分瞭解申請要點，且以上所填各項資料與勾選事項皆確實無誤，若有不實本人願負擔所有法律及行政責任。<br><br><br>
                        <p style="text-align: right;">申請人簽章:<input name="applicant_sign" size="10" maxlength="40">&nbsp;日期:<input name="sign_time" value="" size="10" maxlength="20" type="text" id="d01" readonly><input value="..." type="button" onclick="WdatePicker({el:'d01'})"></p>
                    </td>
                </tr>
                <!-- --- -->
            </tbody>
        </table>
    </form>
</div>
<script>
</script>