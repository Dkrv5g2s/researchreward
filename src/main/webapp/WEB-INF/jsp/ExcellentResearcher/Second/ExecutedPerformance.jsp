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
    <script src="js/jquery.min.js"></script>
    <script src="js/Function.js"></script>
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: 'SecondExecutedPerformance',
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

            for (let j=0; j<document.getElementsByTagName("textarea").length; j++) {
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
                <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">請說明前一年度具體執行績效</td></tr>
                <tr>
                    <td class="metadata">執行績效應包含：
                        (一)	因本項獎勵補助而增加本校之具體執行績效或重要貢獻或對相關學術科技領域的具體助益。
                        (二)	研究表現說明(含研究能量、研究廣度、跨領域合作研究、創新研究領域、產業技術升級、研究團隊之養成及獲獎或榮譽等)。
                    </td>
                    <td>
                        <textarea name="work" type="text" maxlength="2000" required><%= json.get("work")%></textarea>
                    </td>
                </tr>

                <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">
                    <span>
                        <input type="button" style="width:10%" value="上一頁" name="close" onclick="javascript:location.href='SecondExcellentResearcherCatalog'">
                    </span>
                    <span>
                        <button type="button" onclick="commit()">暫存</button>
                    </span>

                </td></tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>
