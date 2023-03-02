<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%
    JSONObject jsonObject = (JSONObject) request.getAttribute("date_info");
%>

<html lang="zh">
<link rel="stylesheet" type="text/css" href="css/FormStyle.css">
<link rel="stylesheet" type="text/css" href="css/PrintPageStyle.css">
<style>
    .pre{
        margin-left: 2rem;
        font-size: small;
    }
    .pre > input{
        margin-left: 0;
        vertical-align: top;
    }
    .requiredField {
        color: red;
    }
</style>

<div class="content">
    <p class="file_title">國立臺北科技大學<label name='year_y'><%= jsonObject.getInt("year_y")%></label>年度教育部補助大專校院
        <br>實施彈性薪資作業要點延攬特殊優秀研究人才申請表 (第<label name='echelon_y'><%= jsonObject.getInt("echelon_y")%></label>梯次)</p>
    <p align="right">申請序號：<input class="researchAndDevelopmentOffice" name="researchAndDevelopmentOffice_review" disabled placeholder="研發處填寫"></p>
    <form id="form">
        <table style="border-spacing:0px;" class="inputForm">
            <tr>
                <td colspan="7" style="text-align:center; background:#C0C0C0;"><b>基本資料</b></td>
            </tr>
            <tr>
                <td colspan="1" style="text-align:center"><span class="requiredField">✱</span>任職單位</td>
                <td colspan="3">
                    <input id="serve_college" name="college" value="" size="10" maxlength="40">&nbsp;學院&nbsp;
                    <input id="serve_department" name="department" value="" size="10" maxlength="40">&nbsp;系(所)
                </td>
                <td colspan="1" style="text-align:center"><span class="requiredField">✱</span>正式納編日期</td>
                <td colspan="2">
                    <input type="date" id="include_date" name="include_date">
                </td>
            </tr>
            <tr>
                <td colspan="1" style="text-align:center"><span class="requiredField">✱</span>中文姓名</td>
                <td colspan="2">
                    <input id="chinese_name" name="chinese_name" value="" size="15">
                </td>
                <td colspan="1" style="text-align:center"><span class="requiredField">✱</span>英文姓名</td>
                <td colspan="3">
                    <input id="english_name" name="english_name" value="">
                </td>
            </tr>
            <tr>
                <td colspan="1" style="text-align:center"><span class="requiredField">✱</span>職　　稱</td>
                <td colspan="2">
                    <input id="job_title" name="job_title" value=""  size="15">
                </td>
                <td colspan="1" style="text-align:center">國籍</td>
                <td colspan="1">
                    <input id="citizenship" name="citizenship" value="" size="10">
                </td>
                <td colspan="1" style="text-align:center">性別</td>
                <td colspan="1">
                    <input id="gender" name="gender" value="" size="10" maxlength="40">
                </td>
            </tr>
            <tr>
                <td rowspan="2" colspan="1" style="text-align:center"><span class="requiredField">✱</span>最高學歷</td>
                <td colspan="1" style="text-align:center">學校名稱</td>
                <td colspan="2" style="text-align:center">主修學門系所</td>
                <td colspan="1" style="text-align:center">學位</td>
                <td colspan="2" style="text-align:center">畢業年月</td>
            </tr>
            <tr>
                <td colspan="1" style="text-align:center"><input id="graduate_school" name="graduate_school" value="" size="15"></td>
                <td colspan="2" style="text-align:center"><input id="major_department" name="major_department" value="" size="18"></td>
                <td colspan="1" style="text-align:center"><input id="degree" name="degree" value="" size="10"></td>
                <td colspan="2" style="text-align:center"><input type="month" id="graduate_year_month" name="graduate_year_month" value=""></td>
            </tr>
            <tr>
                <td rowspan="4" colspan="1" style="text-align:center"><span class="requiredField">✱</span>重要經歷</td>
                <td colspan="1" style="text-align:center">服務機構</td>
                <td colspan="2" style="text-align:center">服務部門</td>
                <td colspan="1" style="text-align:center">職稱</td>
                <td colspan="2" style="text-align:center">起迄年月</td>
            </tr>
            <tr>
                <td colspan="1" style="text-align:center"><input id="history_serve_organization_1" name="history_serve_organization_1" value="" size="15"></td>
                <td colspan="2" style="text-align:center"><input id="history_serve_department_1" name="history_serve_department_1" value="" size="18"></td>
                <td colspan="1" style="text-align:center"><input id="history_job_title_1" name="history_job_title_1" value="" size="10"></td>
                <td colspan="2" style="text-align:center">
                    <input type="month" id="history_job_1_begin" name="history_job_1_begin" value="">
                    <br>至<br>
                    <input type="month" id="history_job_1_end" name="history_job_1_end" value="">
                </td>
            </tr>
            <tr>
                <td colspan="1" style="text-align:center"><input id="history_serve_organization_2" name="history_serve_organization_2" value="" size="15"></td>
                <td colspan="2" style="text-align:center"><input id="history_serve_department_2" name="history_serve_department_2" value="" size="18"></td>
                <td colspan="1" style="text-align:center"><input id="history_job_title_2" name="history_job_title_2" value="" size="10"></td>
                <td colspan="2" style="text-align:center">
                    <input type="month" id="history_job_2_begin" name="history_job_2_begin" value="">
                    <br>至<br>
                    <input type="month" id="history_job_2_end" name="history_job_2_end" value="">
                </td>
            </tr>
            <tr>
                <td colspan="1" style="text-align:center"><input id="history_serve_organization_3" name="history_serve_organization_3" value="" size="15"></td>
                <td colspan="2" style="text-align:center"><input id="history_serve_department_3" name="history_serve_department_3" value="" size="18"></td>
                <td colspan="1" style="text-align:center"><input id="history_job_title_3" name="history_job_title_3" value="" size="10"></td>
                <td colspan="2" style="text-align:center">
                    <input type="month" id="history_job_3_begin" name="history_job_3_begin" value="">
                    <br>至<br>
                    <input type="month" id="history_job_3_end" name="history_job_3_end" value="">
                </td>
            </tr>
            <tr>
                <td colspan="7" style="text-align:center; background:#C0C0C0"><b>申請資格</b></td>
            </tr>
            <tr>
                <td rowspan="4" colspan="1" style="text-align:center">適用對象<br>及申請等級</td>
                <td colspan="4">
                    <p style="text-align:center; font-size:15px; margin:0;"><u>適用對象</u>(請附證明文件)</p><br>
                    本校編制內專任有給之新進教師，於正式納編日之年度至前二年內，未獲教育部玉山（青年）學者補助，且認定符合下列條件之一者：
                </td>
                <td colspan="2">
                    <p style="text-align:center; font-size:15px; margin:0;"><u>支給等級及標準</u></p><br>
                    參照本校「獎勵特殊優秀研究人才支給標準表」：
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <input type="checkbox" id="apply_condition_1" name="apply_condition_1">
                    1.曾獲國際或國內學術殊榮：諾貝爾獎、中央研究院院士、其他國家級院士或重要會士。
                </td>
                <td colspan="2" style="white-space:nowrap">
                    <input type="checkbox" id="payment_level_1" name="payment_level_1">第一級(每月不低於 30 萬元)<br>
                    <input type="checkbox" id="payment_level_2" name="payment_level_2">第二級(每月 20 萬元)
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <input type="checkbox" id="apply_condition_2" name="apply_condition_2">
                    2.曾獲總統科學獎、總統創新獎、總統文化獎、國家講座、學術獎、國家產學大師獎、師鐸獎、行政院傑出科技貢獻獎、傑出特約研究員獎、
                    傑出研究獎、傑出技術移轉貢獻獎、吳大猷先生紀念獎、國家產業創新獎或中央研究院年輕學者研究著作獎。
                </td>
                <td colspan="2" style="white-space:nowrap">
                    <input type="checkbox" id="payment_level_3" name="payment_level_3">第三級(每月 6.5~7.5 萬元)<br>
                    <input type="checkbox" id="payment_level_4" name="payment_level_4">第四級(每月 5.5~6.5 萬元)<br>
                    <input type="checkbox" id="payment_level_5" name="payment_level_5">第五級(每月 4.5~5.5 萬元)<br>
                    <input type="checkbox" id="payment_level_6" name="payment_level_6">第六級(每月 3.5~4.5 萬元)
                </td>
            </tr>
            <tr>
                <td rowspan="4" colspan="4">
                    <input type="checkbox" id="apply_condition_3" name="apply_condition_3">
                    3.於規定期間內，曾任下列政府部門研究計畫之計畫主持人：科技部專題研究計畫、科技部前瞻技術產學合作計畫、
                    科技部產學技術聯盟合作計畫、科技部學術攻頂研究計畫、科技部年輕學者養成計畫、教育部教學實踐研究計畫、
                    國家衛生研究院整合性醫藥衛生科技研究計畫或行政院農業委員會農業科技專案計畫：
                    <div class="pre">
                        (1)　已升等教授或研究員超過五(學)年，近五個(學)年度內有四個(學)年度曾任上開計畫主持人。
                    </div>
                    <div class="pre">
                        (2)　升等教授或研究員五(學)年以下、副教授或副研究員以下之教師或研究人員，近五個(學)年度內有三個(學)年度曾任上開計畫主持人。
                    </div>
                    <br>
                    註：以第3目第(1)、(2)子目申請者，請填寫升等教授日期：<input type="date" id="promotion_date" name="promotion_date">
                </td>
                <td rowspan="2" colspan="2" style="white-space:nowrap">
                    <input type="checkbox" id="payment_level_7" name="payment_level_7">第七級(每月 2.5~3.5 萬元)<br>
                    <input type="checkbox" id="payment_level_8" name="payment_level_8">第八級(每月 1.5~2.5 萬元)<br>
                    <input type="checkbox" id="payment_level_9" name="payment_level_9">第九級(每月 0.5~1.5 萬元)
                </td>
            </tr>
            <tr>
                <td colspan="1" style="text-align:center; background:#C0C0C0"><b>申請第3項<br>院推薦排序</b></td>
            </tr>
            <tr>
                <td rowspan="2" colspan="1" style="text-align:center">
                    <input class="college" name="college_recommended_order" size="10" maxlength="5" disabled>
                    <div style="vertical-align:bottom"><b>(由學院填寫)</b></div>
                </td>
                <td colspan="2" style="text-align:center; background:#C0C0C0"><b>支給期程</b></td>
            </tr>
            <tr>
                <td colspan="2">
                    <b>申請支給</b><input id="apply_years" name="apply_years" value="" size="5"><b>年。</b><br>
                    <b>第</b><input id="current_apply_year" name="current_apply_year" value="" size="5"><b>年</b><br>
                    註：第一~四級至多 5 年，第五~九級至多 3 年。
                </td>
            </tr>
            <tr>
                <td colspan="7" style="text-align:center; background:#C0C0C0"><b>申請單位審查意見</b></td>
            </tr>
            <tr>
                <td colspan="7">
                    本案申請人業經本系（所）<input class="department" type="date" name="department_meeting_date" disabled>
                    及本院<input class="college" type="date" name="college_meeting_date" disabled>
                    相關會議審核推薦申請，所提各項申請與證明文件屬實。
                </td>
            </tr>
            <tr>
                <td colspan="1" style="text-align:center">系所主管核章</td>
                <td colspan="3"><br><br>本案業經系（所）相關會議審議通過 (請檢附會議記錄)</td>
                <td colspan="1" style="text-align:center">日　　期</td>
                <td colspan="2"><input class="college" type="date" name="college_review_date" disabled></td>
            </tr>
            <tr>
                <td colspan="1" style="text-align:center">院 長 核 章</td>
                <td colspan="3"><br><br>本案業經學院相關會議審議通過 (請檢附會議記錄)</td>
                <td colspan="1" style="text-align:center">日　　期</td>
                <td colspan="2"><input class="department" type="date" name="department_review_date" disabled></td>
            </tr>
        </table>
    </form>
</div>

<script src="js/jquery.min.js"></script>
</html>
