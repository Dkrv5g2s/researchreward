<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/1
  Time: 上午 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>申請表額外文件</title>
    <link rel="stylesheet" type="text/css" href="/RRS/css/FormStyle.css">
</head>
<body>
<div class="content">
    <form>
        <table>
            <tbody>
            <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">著作目錄</td></tr>
            <tr>
                <td class="metadata">請詳列個人申請截止日前5年內(此段期間曾生產或請育嬰假者，得延長至7年。7年內，曾服國民義務役者，得依實際服役時間予以延長，但應檢附相關證明文件)發表之學術性著作，包括：期刊論文、專書及專書論文、研討會論文、技術報告及其他等，並請依各類著作之重要性自行排列先後順序。</td>
                <td>
                    <textarea type="text" required maxlength="200" ></textarea>
                </td>
            </tr>
            <tr>
                <td class="metadata">各類著作請按發表時間先後順序填寫。各項著作請務必依作者姓名（按原出版之次序，通訊作者請加註「*」。）、出版年、月份、題目、期刊名稱（專書出版社）、起迄頁數之順序填寫，被接受刊登尚未正式出版者請附被接受函。</td>
                <td>
                    <textarea type="text" required maxlength="200" ></textarea>
                </td>
            </tr>
            <tr>
                <td class="metadata">預期達成之具體成果及績效、未來績效評估準則(例如對申請單位研究工作之助益、對於科技發展之貢獻或於經濟建設及其他應用面預期可獲致之效益、對產業技術升級或研究團隊養成之效益等)。</td>
                <td>
                    <textarea type="text" required maxlength="200" ></textarea>
                </td>
            </tr>
            <tr>
                <td class="metadata">若期刊屬於SCI、EI、SSCI或A&HCI等時，請註明；若著作係經由科技部補助之研究計畫所產生，請於最後填入相關之科技部計畫編號。</td>
                <td>
                    <textarea type="text" required maxlength="200" ></textarea>
                </td>
            </tr>
            <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">研發成果智慧財產權及其應用績效</td></tr>
            <tr>
                <td class="metadata">最近5年內具代表性研究成果至多5篇(請依序填寫：姓名、發表年份、著作名稱、期刊、卷數、頁數、IF與領域排名及被引用次數(不含自我引用次數)，並以*註記該篇所有之通訊作者)。</td>
                <td>
                    <textarea type="text" required maxlength="200" ></textarea>
                </td>
            </tr>
            <tr>
                <td class="metadata">獲獎情形及重要會議邀請演講至多5項。</td>
                <td>
                    <textarea type="text" required maxlength="200" ></textarea>
                </td>
            </tr>
            <tr>
                <td class="metadata">其他資料(例如：擔任國際重要學術學會理監事、國際知名學術期刊編輯/副編輯或評審委員、專利或技術移轉具體績效等)。</td>
                <td>
                    <textarea type="text" required maxlength="200" ></textarea>
                </td>
            </tr>
            <tr>
                <td class="metadata">請簡述上述代表性研究成果內個人之重要貢獻。</td>
                <td>
                    <textarea type="text" required maxlength="200" ></textarea>
                </td>
            </tr>
            <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><input type="submit" value="存檔"></td></tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
