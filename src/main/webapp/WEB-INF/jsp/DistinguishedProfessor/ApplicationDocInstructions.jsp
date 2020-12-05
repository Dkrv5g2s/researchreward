<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>國立臺北科技大學特聘教授申請表審查資料【填寫說明】</title>
    <style>
        body {
            margin: 20px 0px 0px 0px;
            padding: 0;
            background: #FFFFCC;
            font-size: 20px;
            color: #3C3D3F;
            background-color: #E9F2FF;
            font: normal 16px Verdana;
            width: 100%;
        }
        table {
            color: black;
            width: 100%;
            border-width: thin;
            border-spacing: 0px;
            border-style: groove;
            border-color: gray;
            border-collapse: collapse;
            background-color: white;
            font: normal 13px Verdana;
        }
        table td{
            border-width: 1px;
            padding: 8px;
            border-style: groove;
            border-color: gray;
            -moz-border-radius: 0px 0px 0px 0px;
            height: 20px;
            vertical-align: text-middle;
        }
        table td.metadata{
            width: 150px;
            background-color: rgb(255, 255, 240);
            text-align: right;
        }
        table td.cb{
            width: 1%;
        }
        table td.checkboxcontent{
            width: 500px;
            background-color: rgb(255, 255, 240);
            text-align: left;
        }
        div.content{
            margin: 0 auto;
            padding: 50px;
            width: 1200px;
            background-color: white;
        }

    </style>
</head>
<body>
    <div class="content">
        <form>
            <p>審查資料【填寫說明】</p>
            <table>
                <tbody>
                    <tr>
                        <td>一、 每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書(共同著作授權同意書)。</td>
                    </tr>
                    <tr>                  
                        <td>二、 學術論著採計Scopus / WOS論文者，請檢附表B「傑出論文績效說明表」。並請檢附證明文件<a style="font-weight:bold">「期刊發表之論文首頁或以Scopus / WOS資料庫或scival分析系統之佐證」及「各篇期刊排名(以發表當年度為主) CiteScore / Journal Ranking、國際學者、企業、FWCI)」。</a></td>
                    </tr>
                    <tr>
                        <td>三、 教育部補助大學在地實踐社會責任計畫，請以教評系統為準提供相關佐證資料。計畫年度(1/1~12/31)之認定以「計畫開始日期」為準；計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；多年期計畫分年計算單一年度執行金額。</td>
                    </tr>
                    <tr>
                        <td>四、 科技部計畫(不包含科技部產學合作計畫)請以教評系統為準提供相關佐證資料。計畫年度(1/1~12/31)之認定以「計畫開始日期」為準；計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；多年期計畫分年計算單一年度執行金額。</td>
                    </tr>
                    <tr>
                        <td>五、產學合作計畫(包含科技部產學合作計畫、政府機關及財團法人之研究型專案計畫；不含以學校名義開授訓練課程招生收入) 請以教評系統為準提供相關佐證資料。計畫年度(1/1~12/31)之認定以「計畫開始日期」為準；計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；多年期計畫分年計算單一年度執行金額。</td>
                    </tr>
                    <tr>
                        <td>六、技術移轉金(包含專利技術移轉金、著作權技術移轉金及知識性技術移轉金；不包含科技部先期技術移轉授權金)請填列近五年以本校名義所獲得之實收技術移轉金資料(如下表) ，並洽產學合作處技術移轉組確認核章後提出申請。技術移轉金計算以「實際納入校務基金日期」為準。</td>
                    </tr>
                </tbody>
            </table>
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
		                <td colspan="1" width="18%"><input size="10" maxlength="40"></td>
		                <td colspan="1" width="18%"><input size="10" maxlength="40"></td>
		                <td colspan="1" width="18%"><input type="date" size="10" maxlength="40"></td>
		                <td colspan="1" width="18%"><input size="10" maxlength="40"></td>
		                <td colspan="1" width="18%"><input size="10" maxlength="40" type="date"></td>
		                <td colspan="1" width="10%"><input type="button" name="delete_contract" value="刪除"></td>
		            </tr>
		            <tr>
		                <td colspan="6" width="100%"><input type="button" name="add_new_contract" value="  新增  "></td>
		            </tr>
		        </tbody>
		    </table>
		    <table>
		    	<tbody>
		    		<tr>
                        <td>七、<a style="font-weight:bold">各項計畫類總金額統計(不含因行政職務而擔任主持人部分)。</a></td>
                    </tr>
                    <tr>
                        <td>八、以本辦法第三條第六款：曾獲本校「傑出教學獎」2次者，檢附得獎證明。</td>
                    </tr>
                    <tr>
                        <td>九、<a style="font-weight:bold">無論以第三條之任一款基本條件申請者，A、B表各項資料均須填寫。</a></td>
                    </tr>
                </tbody>
            </table>
            <p><input type="button" name="confirm" value="確定"></p>
        </form>
    </div>

</body>
</html>
