<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONArray" %><%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/3
  Time: 下午 01:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONArray json = (JSONArray) request.getAttribute("json");
%>
<html>
<head>
    <title>研發成果智慧財產權及其應用績效</title>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
<link rel="stylesheet" type="text/css" href="css/body.css">
    <script src="lib/jquery.min.js"></script>
    <script src="js/Function.js"></script>
    <style>
        td.metadata{
            text-align: center;
        }
        p{
            text-align:left;
            font-weight:bold;
            font-size:20px;
        }
        input{
            width: 100%;
        }
        input.back{
            width: 10%;
        }

    </style>
    <script>
        function createPlan() {
            var data = "<tr name=\"plan\">\n" +
                "                    <td><input type=\"text\" name=\"number\"></td>\n" +
                "                    <td><input type=\"text\" name=\"year\"></td>\n" +
                "                    <td><input type=\"text\" name=\"planName\"></td>\n" +
                "                    <td><input type=\"text\" name=\"planNumber\"></td>\n" +
                "                    <td><input type=\"date\" name=\"startTime\"></td>" +
                "                    <td><input type=\"date\" name=\"lastTime\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='plan'] tr[name=new]").before(data);
        }

        function createPaper() {
            var data = "<tr name=\"paper\">\n" +
                "                    <td><input type=\"text\" name=\"number\"></td>\n" +
                "                    <td><input type=\"text\" name=\"year\"></td>\n" +
                "                    <td><input type=\"text\" name=\"paperName\"></td>\n" +
                "                    <td><input type=\"text\" name=\"journal\"></td>\n" +
                "                    <td><input type=\"text\" name=\"author\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='paper'] tr[name=new]").before(data);
        }

        function createBook() {
            var data = "<tr name=\"book\">\n" +
                "                    <td><input type=\"text\" name=\"number\"></td>\n" +
                "                    <td><input type=\"text\" name=\"year\"></td>\n" +
                "                    <td><input type=\"text\" name=\"bookName\"></td>\n" +
                "                    <td><input type=\"text\" name=\"publisher\"></td>\n" +
                "                    <td><input type=\"text\" name=\"publishYear\"></td>\n" +
                "                    <td><input type=\"text\" name=\"ISBN\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='book'] tr[name=new]").before(data);
        }

        function createReward() {
            var data = "<tr name=\"reward\">\n" +
                "                    <td><input type=\"text\" name=\"rewardName\"></td>\n" +
                "                    <td><input type=\"text\" name=\"organization\"></td>\n" +
                "                    <td><input type=\"date\" name=\"rewardDate\"></td>\n" +
                "                    <td><input type=\"text\" name=\"reason\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='reward'] tr[name=new]").before(data);
        }

        $(document).on("click", "button[name='delete']",function(){
            var thisTr = $(this).parents("tr");
            thisTr.remove();
        });

        function commit(){


            var table1 = tableToJson($('form').find("table")[0]);
            var table2 = tableToJson($('form').find("table")[1]);
            var table3 = tableToJson($('form').find("table")[2]);
            var table4 = tableToJson($('form').find("table")[3]);

            let filledInputNum = 0;
            let totalInputNum = 0;

            for (let j=0; j<document.getElementsByTagName("input").length; j++) {
                let inputElem = document.getElementsByTagName("input")[j];
                if (inputElem.value.length > 0)
                    filledInputNum++;
                totalInputNum++;
            }
            let fillRate = filledInputNum / totalInputNum;

            var data = [table1, table2, table3, table4, fillRate];

            $.ajax({
                type: 'POST',
                url: 'SecondResearchProduction',
                dataType: 'text',
                data: JSON.stringify(data),
                contentType: 'application/json',
                success: function(data){
                    alert('存檔成功');
                }
            });

        };

        function tableToJson(table){
            var data = [];

            // first row needs to be headers
            var headers = [];
            for (var i=0; i<table.rows[1].cells.length-1; i++) {
                headers[i] = table.rows[1].cells[i].getAttribute("name");
            }

            console.log(headers);

            // go through cells
            for (var i=2; i<table.rows.length-1; i++) {

                var tableRow = table.rows[i];
                var rowData = {};

                for (var j=0; j<tableRow.cells.length-1; j++) {

                    rowData[ headers[j] ] = tableRow.cells[j].getElementsByTagName("input")[0].value;

                }

                data.push(rowData);
            }

            return data;
        }

    </script>
    <%
        JSONArray jsonArray = (JSONArray)json;
        JSONArray jArray1 = (JSONArray)jsonArray.get(0);
        JSONArray jArray2 = (JSONArray)jsonArray.get(1);
        JSONArray jArray3 = (JSONArray)jsonArray.get(2);
        JSONArray jArray4 = (JSONArray)jsonArray.get(3);
        for(Object object: jArray1){
            JSONObject jsonObject = (JSONObject)object;

    %>

    <script>
        $(document).ready(function () {

            var data = "<tr name=\"plan\">\n" +
                "                    <td><input type=\"text\" name=\"number\" value=\"<%=jsonObject.get("number")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"year\" value=<%=jsonObject.get("year")%>></td>\n" +
                "                    <td><input type=\"text\" name=\"planName\" value=<%=jsonObject.get("planName")%>></td>\n" +
                "                    <td><input type=\"text\" name=\"planNumber\" value=<%=jsonObject.get("planNumber")%>></td>\n" +
                "                    <td><input type=\"date\" name=\"startTime\" value=<%=jsonObject.get("startTime")%>></td>\n" +
                "                    <td><input type=\"date\" name=\"lastTime\" value=<%=jsonObject.get("lastTime")%>></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='plan'] tr[name=new]").before(data);
        })
    </script>
    <%
        }
        for(Object object: jArray2){
            JSONObject jsonObject = (JSONObject)object;
    %>
    <script>
        $(document).ready(function () {

            var data = "<tr name=\"paper\">\n" +
                "                    <td><input type=\"text\" name=\"number\" value=\"<%=jsonObject.get("number")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"year\" value=\"<%=jsonObject.get("year")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"paperName\" value=\"<%=jsonObject.get("paperName")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"journal\" value=\"<%=jsonObject.get("journal")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"author\" value=\"<%=jsonObject.get("author")%>\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='paper'] tr[name=new]").before(data);
        })
    </script>
    <%
        }
        for(Object object: jArray3){
            JSONObject jsonObject = (JSONObject)object;
    %>
    <script>
        $(document).ready(function () {
            var data = "<tr name=\"book\">\n" +
                "                    <td><input type=\"text\" name=\"number\" value=\"<%=jsonObject.get("number")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"year\" value=\"<%=jsonObject.get("year")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"bookName\" value=\"<%=jsonObject.get("bookName")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"publisher\" value=\"<%=jsonObject.get("publisher")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"publishYear\" value=\"<%=jsonObject.get("publishYear")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"ISBN\" value=\"<%=jsonObject.get("ISBN")%>\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='book'] tr[name=new]").before(data);
        })
    </script>
    <%
        }
        for(Object object: jArray4){
        JSONObject jsonObject = (JSONObject)object;
    %>
    <script>
        $(document).ready(function () {
            var data = "<tr name=\"reward\">\n" +
                "                    <td><input type=\"text\" name=\"rewardName\" value=\"<%=jsonObject.get("rewardName")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"organization\" value=\"<%=jsonObject.get("organization")%>\"></td>\n" +
                "                    <td><input type=\"date\" name=\"rewardDate\" value=\"<%=jsonObject.get("rewardDate")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"reason\" value=\"<%=jsonObject.get("reason")%>\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='reward'] tr[name=new]").before(data);
        })
    </script>
    <%
        }
    %>
    <script>
        $(document).ready(function (){
            setReadOnly(<%=request.getAttribute("readonly")%>);
        })
    </script>
</head>
<body>
<div class="content">
    <p>獲獎勵期間學術研究成果及貢獻：<br>
        　受獎勵人應為補助起始日前一年內執行科技部研究計畫之計畫主持人；並以本校名義發表收錄於Scopus或WOS資料庫國際學術期刊論文，且需為該論文第一作者或兩名內通訊作者方可採計，第一年至少一篇(含國際研討會論文口頭報告)，第二年及第三年至少需各發表一篇和二篇 (不含國際研討會論文)。<br>
    </p>
    <form id="form">
        <div name="plan">
            <table>
                <tbody>
                        <tr><td class="metadata" colspan="7">執行科技部專題研究計畫</td></tr>
                        <tr>
                            <td class="metadata" name="number">序號</td>
                            <td class="metadata" name="year">年度</td>
                            <td class="metadata" name="planName">計畫名稱</td>
                            <td class="metadata" name="planNumber">計畫編號</td>
                            <td class="metadata" name="startTime">執行期間-起始日</td>
                            <td class="metadata" name="lastTime">執行期間-結束日</td>
                            <td class="metadata">功能</td>
                        </tr>
                        <tr name="new"><td colspan="7" style="text-align: center"><button type="button" onclick="createPlan()">新增</button></td></tr>
                </tbody>
            </table>
        </div>
        <div name="paper">
            <table>
                <tbody>
                    <tr><td class="metadata" colspan="6">著作發表情形-論文</td></tr>
                    <tr>
                        <td class="metadata" name="number">序號</td>
                        <td class="metadata" name="year">年度</td>
                        <td class="metadata" name="paperName">論文名稱</td>
                        <td class="metadata" name="journal">期刊名稱、卷期</td>
                        <td class="metadata" name="author">第一作者或兩名內通訊作者</td>
                        <td class="metadata">功能</td>
                    </tr>
                    <tr name="new"><td colspan="6" style="text-align: center"><button type="button" onclick="createPaper()">新增</button></td></tr>
                </tbody>
            </table>
        </div>
        <div name="book">
            <table>
                <tbody>
                    <tr><td class="metadata" colspan="7">著作發表情形-專書</td></tr>
                    <tr>
                        <td class="metadata" name="number">序號</td>
                        <td class="metadata" name="year">年度</td>
                        <td class="metadata" name="bookName">專書名稱</td>
                        <td class="metadata" name="publisher">出版社</td>
                        <td class="metadata" name="publishYear">出版年</td>
                        <td class="metadata" name="ISBN">ISBN</td>
                        <td class="metadata">功能</td>
                    </tr>
                    <tr name="new"><td colspan="9" style="text-align: center"><button type="button" onclick="createBook()">新增</button></td></tr>
                </tbody>
            </table>
        </div><div name="reward">
        <table>
            <tbody>
            <tr><td class="metadata" colspan="7">獲獎情形</td></tr>
            <tr>
                <td class="metadata" name="rewardName">獎項名稱</td>
                <td class="metadata" name="organization">頒獎機構</td>
                <td class="metadata" name="rewardDate">頒獎日期</td>
                <td class="metadata" name="reason">頒獎緣由</td>
                <td class="metadata">功能</td>
            </tr>
            <tr name="new"><td colspan="9" style="text-align: center"><button type="button" onclick="createReward()">新增</button></td></tr>
            </tbody>
        </table>
    </div>
        <div>
            <table>
                <tbody>
                <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">

                    <span>
                        <input class="back" type="button" width="10%" value="上一頁" name="close" onclick="javascript:location.href='SecondExcellentResearcherCatalog'">

                    </span>
                    <span>
                        <button type="button" onclick="commit()">暫存</button>
                    </span>
                </td></tr>
                </tbody>
            </table>
        </div>
    </form>
</div>

</body>
</html>
