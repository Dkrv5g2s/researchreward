<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/11/30
  Time: 下午 05:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");
%>
<html>
<head>
    <title>申請表額外文件</title>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
    <link rel="stylesheet" type="text/css" href="css/body.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/Function.js"></script>
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: 'RecruitDescription',
                dataType: 'text',
                data: JSON.stringify(InputToJson()),
                contentType: 'application/json',
                success: function(data){
                    alert('存檔成功');
                }
            });

        };

        function InputToJson(){
            var data = {};
            let filledInputNum = 0;
            let totalInputNum = 0;

            for (var j=0; j<document.getElementsByTagName("textarea").length; j++) {
                let inputElem = document.getElementsByTagName("textarea")[j];
                data[inputElem.name] = inputElem.value;
                if (inputElem.className.length === 0) {
                    if (inputElem.value.length > 0) {
                        filledInputNum++;
                    }
                    totalInputNum++;
                }
            }

            data["fill_rate"] = filledInputNum / totalInputNum;
            return data;
        }
        $(document).ready(function (){
            setReadOnly(<%=request.getAttribute("readonly")%>);
        })
    </script>
</head>
<body>
    <div class="content">
        <form>
            <table>
                <tbody>
                <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">延攬內容說明</td></tr>
                <tr>
                    <td class="metadata">延攬理由(擬參與工作之重要性、其專長對申請單位之影響程度等)</td>
                    <td>
                        <textarea name="recruitReason" type="text" maxlength="500" required><%= json.get("recruitReason")%></textarea>
                    </td>
                </tr>
                <tr>
                    <td class="metadata">延攬目標、執行方式及內容，申請單位對受延攬人提供之教學、研究及行政支援等相關配合措施。</td>
                    <td>
                        <textarea name="recruitContent" type="text" maxlength="500" required><%= json.get("recruitContent")%></textarea>
                    </td>
                </tr>
                <tr>
                    <td class="metadata">預期達成之具體成果及績效、未來績效評估準則(例如對申請單位研究工作之助益、對於科技發展之貢獻或於經濟建設及其他應用面預期可獲致之效益、對產業技術升級或研究團隊養成之效益等)。</td>
                    <td>
                        <textarea name="expect" type="text" maxlength="500" required><%= json.get("expect")%></textarea>
                    </td>
                </tr>
                <tr>
                    <td class="metadata">攬才情勢分析(含國際攬才情勢分析及申請單位攬才策略)。</td>
                    <td>
                        <textarea name="analysis" type="text" maxlength="500" required><%= json.get("analysis")%></textarea>
                    </td>
                </tr>
                <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">延攬特殊優秀人才之傑出研究表現說明及申請單位評估與推薦理由</td></tr>
                <tr>
                    <td class="metadata">最近5年內具代表性研究成果至多5篇(請依序填寫：姓名、發表年份、著作名稱、期刊、卷數、頁數、IF與領域排名及被引用次數(不含自我引用次數)，並以*註記該篇所有之通訊作者)。</td>
                    <td>
                        <textarea name="researchProduction" type="text" required><%= json.get("researchProduction")%></textarea>
                    </td>
                </tr>
                <tr>
                    <td class="metadata">獲獎情形及重要會議邀請演講至多5項。</td>
                    <td>
                        <textarea name="award" type="text" maxlength="500" required><%= json.get("award")%></textarea>
                    </td>
                </tr>
                <tr>
                    <td class="metadata">其他資料(例如：擔任國際重要學術學會理監事、國際知名學術期刊編輯/副編輯或評審委員、專利或技術移轉具體績效等)。</td>
                    <td>
                        <textarea name="other" type="text" maxlength="500" required><%= json.get("other")%></textarea>
                    </td>
                </tr>
                <tr>
                    <td class="metadata">請簡述上述代表性研究成果內個人之重要貢獻。</td>
                    <td>
                        <textarea name="contribution" type="text" maxlength="500" required><%= json.get("contribution")%></textarea>
                    </td>
                </tr>
                <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">
                    <span><input type="button" style="width:10%" value="上一頁" name="close" onclick="javascript:location.href='ExcellentResearcherCatalog'"></span>
                    <span><button type="button" onclick="commit()">暫存</button></span>
                </td></tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>
