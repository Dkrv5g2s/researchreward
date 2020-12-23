<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>國立臺北科技大學特聘教授申請表B表</title>
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
            <p>國立臺北科技大學特聘教授申請表B表</p>
            <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
		        <tbody style="text-align: center;">
		            <tr>
		                <td colspan="3" width="33%">申請人姓名(中/英文):<input name="applicant_name" size="20" maxlength="40"></td>
		                <td colspan="2" width="33%">系所/職稱:<input name="dep_job" size="20" maxlength="40"></td>
		                <td colspan="3" width="33%">員工編號:<input name="staff_code" size="10" maxlength="40"></td>
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
		                <td colspan="8" style="text-align: left;">說明事項：<br>
		                    &nbsp;&nbsp;&nbsp;&nbsp;1.近五年以本校名義發表之學術論著（此段期間曾生產或請育嬰假者得以延長，其延長期限依實際請假時間為依據，並檢附相關證明文件）始得採計。<br>
		                    &nbsp;&nbsp;&nbsp;&nbsp;2.論文之期刊排名以出版年度為準，若無該出版年資料，則以前一年度為準。<br>
		                    &nbsp;&nbsp;&nbsp;&nbsp;3.每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書。
		                </td>
		            </tr>
		            <tr>
		                <td colspan="8" style="text-align: left;font-weight: bold;"><input type="checkbox" name="declaration"><font color="red">申請人充分瞭解申請辦法，且上述資料與勾選事項皆屬實，若有誤願自行負完全的法律責任。</font><br><br>
		                    <a style="margin-left: 800px">日期:<input type="date" ></a></td>
		            </tr>
		           
		        </tbody>
		    </table>
            <p><input type="button" name="confirm" value="確定"></p>
        </form>
    </div>

</body>
</html>
