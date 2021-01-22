<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p style="font-weight:bold;font-size:20px;text-align: center;">國立臺北科技大學校內獎補助共同著作授權同意書</p><br>
<div class="container" style="margin: 0px auto; width: 1200px">
    <pre style="line-height: 40px;"><font style="font-size: 18px">授權人茲同意下列論文由共同作者<input name="common_author" size="15" maxlength="40"><br>老師提出本校「<label id="current_year" style="font-weight: bold;">109</label><font style="font-weight: bold;">年度獎勵特殊優秀研究人才</font>」申請。本人不<br>再重覆申請，特此聲明。<br><font style="font-size: 12px">(本同意書請檢附於該篇論文首頁和該篇論文Ranking證明文件後)</font></font></pre>
    論文題目:<input name="paper_title" size="20" maxlength="40">
    <br>
    作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者:<input name="author" size="20" maxlength="40">
</div>
<br>
<br>
<div class="container" style="margin: 0px auto; width: 1200px">
    <form method="post" action="Plan?func=international_formC001" enctype="multipart/form-data" id="c001_form">
        <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <tbody style="text-align: center;">
                <tr>
                    <td colspan="1" width="10%" style="font-weight: bold;">編號</td>
                    <td colspan="1" width="50%" style="font-weight: bold;">授權教師姓名</td>
                    <td colspan="1" width="30%" style="font-weight: bold;">簽名</td>
                    <td colspan="1" width="10%" ></td>
                </tr>
                <tr>
                    <td colspan="1">1</label></td>
                    <td colspan="1" style="text-align: left;">中文&nbsp;—&nbsp;<input name="authorized_teacher_cname" size="15" maxlength="40"><br>英文&nbsp;—&nbsp;<input name="authorized_teacher_ename" size="15" maxlength="40"><br></td>
                    <td colspan="1" ><input name="sign" size="15" maxlength="40"></td>
                    <td colspan="1" ><input type="button" name="delete_authorized_teacher" value="刪除"></td>
                </tr>
                <tr>
                    <td colspan="4"><input type="button" name="new_authorized_teacher" value="新增"></td>
                </tr>
            </tbody>
        </table>
    </form>
</div>

<div class="container" style="margin: 0px auto; width: 800px">
    <p style="text-align: center"><font style="background: #C0C0C0;font-weight: bold;">若本論文有多數本校作者，應全數簽署本授權同意書。</font></p>
    <font style="letter-spacing: 10px">中華民國<input name="year">年<input name="year">月<input name="year">日</font>
</div>

<script>
</script>