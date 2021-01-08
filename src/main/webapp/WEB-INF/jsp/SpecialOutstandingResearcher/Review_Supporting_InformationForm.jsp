<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container" style="margin: 0px auto; width: 1200px">
    <p style="font-weight:bold;font-size:20px;">※審查佐證資料【填寫說明】</p>
</div>
<div class="container" style="margin: 0px auto; width: 1200px">
    <pre style="font-size: 15px">一、 所有申請等級(第一至九級)皆需檢附<a style="font-weight: bold; background: #C0C0C0">表A「五年內傑出績效說明表」</a>。<pre>
<pre style="font-size: 15px">二、 以傑出研究奬、特聘教授等奬項申請者，請檢附相關聘書資料影本供參。</pre>
    <pre style="font-size: 15px">三、 每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附
     其他教師同意書<a style="font-weight: bold;">(共同著作授權同意書)</a>。</pre>
    <pre style="font-size: 15px">四、 學術論著採計Scopus / WOS論文者，請檢附<a style="font-weight: bold;background: #C0C0C0">表B「傑出論文績效說明表」</a>。並請
     檢附證明文件「期刊發表之論文首頁或以Scopus / WOS資料庫或SciVal分析系
     統之佐證」及「各篇期刊排名(以發表當年度為主) CiteScore / Journal Ranking、國
     際學者、企業、FWCI)」。</pre>
    <pre style="font-size: 15px">五、 科技部計畫請以本校「教師評鑑及基本資料庫」為準提供相關佐證資料。計畫年
     度之認定以「計畫開始日期」介於104/01/01-108/12/31為準；
     計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；
     多年期計畫分年計算單一年度執行金額。</pre>
    <pre style="font-size: 15px">六、 產學合作計畫(包含科技部產學合作計畫、政府機關及財團法人之研究型專案計畫；
     不含以學校名義開授訓練課程招生收入) 請以本校「教師評鑑及基本資料庫」為準提供相關佐證資料。
     計畫年度之認定以「計畫開始日期」介於104/01/01-108/12/31為準；
     計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；
     多年期計畫分年計算單一年度執行金額。</pre>
    <pre style="font-size: 15px">七、 技術移轉金(不包含科技部先期技術移轉授權金)請填列近五年以本校名義所獲得之實收技術移轉金資料(如下表) ，
     並洽產學合作處技術移轉組確認核章後提出申請。技術移轉金計算以「實際納入校務基金日期」
     介於104/01/01-108/12/31為準。</pre>
    <form method="post" action="Plan?func=international_formC001" enctype="multipart/form-data" id="c001_form">
        <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <tbody style="text-align: center;">
                <tr>
                    <th colspan="1" width="18%">技轉合約名稱</th>
                    <th colspan="1" width="18%">技轉單位(企業)</th>
                    <th colspan="1" width="18%">簽約日期</th>
                    <th colspan="1" width="18%">實收技術移轉金金額</th>
                    <th colspan="1" width="18%">技轉金實際納入校務基金日期</th>
                    <th colspan="1" width="10%"></th>
                </tr>
                <tr>
                    <td colspan="1" width="18%"><input name="contract_name" size="10" maxlength="40"></td>
                    <td colspan="1" width="18%"><input name="contract_name" size="10" maxlength="40"></td>
                    <td colspan="1" width="18%"><input name="contract_name" size="10" maxlength="40"></td>
                    <td colspan="1" width="18%"><input name="contract_name" size="10" maxlength="40"></td>
                    <td colspan="1" width="18%"><input name="sign_time" value="" size="10" maxlength="20" type="text" id="d01" readonly><input value="..." type="button" onclick="WdatePicker({el:'d01'})"></td>
                    <td colspan="1" width="10%"><input type="button" name="delete_contract" value="刪除"></td>
                </tr>
                <tr>
                    <td colspan="6" width="100%"><input type="button" name="add_new_contract" value="  新增  "></td>
                </tr>
                <!-- --- -->
            </tbody>
        </table>
    </form>
</div>
<script>
</script>