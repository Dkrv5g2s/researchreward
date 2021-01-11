<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container" style="margin: 0px auto; width: 1200px">
    <p style="font-weight:bold;font-size:20px;text-align: center;">※繳送資料【請系(所)、學院承辦人填寫】</p><br>
</div>
<div class="container" style="margin: 0px auto; width: 1200px">
    <form method="post" action="Plan?func=international_formC001" enctype="multipart/form-data" id="c001_form">
        <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <tbody style="text-align: center;">
                <tr>
                    <td colspan="4" width="100%" style="font-weight: bold;">重要學術論著採計Scopus或WOS論文者應檢附之證明文件<br>(證明文件齊全始得收件)</td>
                </tr>
                <tr>
                    <td colspan="1" width="10%">檢核欄</td>
                    <td colspan="3" width="90%">項&nbsp;&nbsp;&nbsp;&nbsp;目</td>
                </tr>
                <tr>
                    <td colspan="1" width="10%"><input type="checkbox" name="check_one"></td>
                    <td colspan="3" width="90%">檢附表B「論文績效說明表」</td>
                </tr>
                
                <tr>
                    <td colspan="1" width="10%"><input type="checkbox" name="check_two"></td>
                    <td colspan="3" width="90%">期刊發表之論文首頁或以 Scopus資料庫或 SciVal 分析系統之佐證</td>
                </tr>
                <tr>
                    <td colspan="1" width="10%"><input type="checkbox" name="check_three"></td>
                    <td colspan="3" width="90%">各篇期刊排名(以發表當年度為主) CiteScore / Journal Ranking、國際學者、企業、FWCI之佐證</td>
                </tr>
                <tr>
                    <td colspan="1" width="10%"><input type="checkbox" name="check_four"></td>
                    <td colspan="3" width="90%">（限設計及人社學院）以本校名義發表收錄於TSSCI/THCI之學術期刊論文首頁</td>
                </tr>
                <tr>
                    <td colspan="1" width="10%"><input type="checkbox" name="check_five"></td>
                    <td colspan="3" width="90%">檢附表B「論文績效說明表（限設計及人社學院）人文、設計、藝術或社會科學領域之學術專書/單篇(章)首頁</td>
                </tr>

                <tr style="text-align: left;">
                    <td colspan="2" width="50%">系(所)承辦人核章：<input name="dep_case_officer_sign" size="15" maxlength="40"><br><br>日期:<input name="dep_case_officer_sign_time" value="" size="10" maxlength="20" type="text" id="d01" readonly><input value="..." type="button" onclick="WdatePicker({el:'d01'})"><br><br></td>
                    <td colspan="2" width="50%">學院承辦人核章：<input name="college_case_officer_sign"><br><br>日期:<input name="dep_case_officer_sign_time" value="" size="10" maxlength="20" type="text" id="d02" readonly><input value="..." type="button" onclick="WdatePicker({el:'d02'})">
                </tr>
            </tbody>
        </table>
    </form>
</div>

<script>
</script>