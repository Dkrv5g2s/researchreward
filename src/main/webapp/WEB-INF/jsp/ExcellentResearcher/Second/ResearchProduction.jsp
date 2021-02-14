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
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
<link rel="stylesheet" type="text/css" href="/css/body.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
                "                    <td><input type=\"text\" name=\"executeTime\"></td>\n" +
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
                "                    <td><input type=\"date\" name=\"author\"></td>\n" +
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
                "                    <td><input type=\"text\" name=\"rewardDate\"></td>\n" +
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

            var data = [table1,table2,table3,table4];


            $.ajax({
                type: 'POST',
                url: '/Second/ResearchProduction',
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

        for(Object object: jArray1){
            JSONObject jsonObject = (JSONObject)object;

    %>

    <script>
        $(document).ready(function () {

            var data = "<tr name=\"patent\">\n" +
                "                    <td><input type=\"text\" name=\"patentClass\" value=\"<%=jsonObject.get("patentClass")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"patentName\" value=<%=jsonObject.get("patentName")%>></td>\n" +
                "                    <td><input type=\"text\" name=\"country\" value=<%=jsonObject.get("country")%>></td>\n" +
                "                    <td><input type=\"text\" name=\"patentNumber\" value=<%=jsonObject.get("patentNumber")%>></td>\n" +
                "                    <td><input type=\"text\" name=\"inventor\" value=<%=jsonObject.get("inventor")%>></td>\n" +
                "                    <td><input type=\"text\" name=\"patentee\" value=<%=jsonObject.get("patentee")%>></td>\n" +
                "                    <td><input type=\"date\" name=\"approvalDate\" value=<%=jsonObject.get("approvalDate")%>></td>\n" +
                "                    <td><input type=\"text\" name=\"mstPlanNumber\" value=<%=jsonObject.get("mstPlanNumber")%>></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='patent'] tr[name=new]").before(data);
        })
    </script>
    <%
        }
        for(Object object: jArray2){
            JSONObject jsonObject = (JSONObject)object;
    %>
    <script>
        $(document).ready(function () {

            var data = "<tr name=\"technologyTransfer\">\n" +
                "                    <td><input type=\"text\" name=\"technologyName\" value=\"<%=jsonObject.get("technologyName")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"patentName\" value=\"<%=jsonObject.get("patentName")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"authorizedUnit\" value=\"<%=jsonObject.get("authorizedUnit")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"toAuthorizedUnit\" value=\"<%=jsonObject.get("toAuthorizedUnit")%>\"></td>\n" +
                "                    <td><input type=\"date\" name=\"contractDate\" value=\"<%=jsonObject.get("contractDate")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"mstPlanNumber\" value=\"<%=jsonObject.get("mstPlanNumber")%>\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='technologyTransfer'] tr[name=new]").before(data);
        })
    </script>
    <%
        }
        for(Object object: jArray3){
            JSONObject jsonObject = (JSONObject)object;
    %>
    <script>
        $(document).ready(function () {
            var data = "<tr name=\"workAuthorization\">\n" +
                "                    <td><input type=\"text\" name=\"workName\" value=\"<%=jsonObject.get("workName")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"authorizationClass\" value=\"<%=jsonObject.get("authorizationClass")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"author\" value=\"<%=jsonObject.get("author")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"copyrightOwner\" value=\"<%=jsonObject.get("copyrightOwner")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"agent\" value=\"<%=jsonObject.get("agent")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"mstPlanNumber\" value=\"<%=jsonObject.get("mstPlanNumber")%>\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='authorization'] tr[name=new]").before(data);
        })
    </script>
    <%
        }
    %>
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
                        <tr><td class="metadata" colspan="6">執行科技部專題研究計畫</td></tr>
                        <tr>
                            <td class="metadata" name="number">序號</td>
                            <td class="metadata" name="year">年度</td>
                            <td class="metadata" name="planName">計畫名稱</td>
                            <td class="metadata" name="planNumber">計畫編號</td>
                            <td class="metadata" name="executeTime">執行期間</td>
                            <td class="metadata">功能</td>
                        </tr>
                        <tr name="new"><td colspan="6" style="text-align: center"><button type="button" onclick="createPatent()">新增</button></td></tr>
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
                    <tr name="new"><td colspan="6" style="text-align: center"><button type="button" onclick="createTechnologyTransfer()">新增</button></td></tr>
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
                    <tr name="new"><td colspan="9" style="text-align: center"><button type="button" onclick="createAuthorization()">新增</button></td></tr>
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
            <tr name="new"><td colspan="9" style="text-align: center"><button type="button" onclick="createAuthorization()">新增</button></td></tr>
            </tbody>
        </table>
    </div>
        <div>
            <table>
                <tbody>
                <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><span><button type="button" onclick="commit()">存檔</button></span><span><input class="back" type="button" width="10%" value="上一頁" name="close" onclick="javascript:location.href='ExcellentResearcherCatalog'"></span></td></tr>
                </tbody>
            </table>
        </div>
    </form>
</div>

</body>
</html>
