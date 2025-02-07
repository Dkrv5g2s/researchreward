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
    <script src="js/jquery.min.js"></script>
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
        function createPatent() {
            var data = "<tr name=\"patent\">\n" +
                "                    <td><input type=\"text\" name=\"patentClass\"></td>\n" +
                "                    <td><input type=\"text\" name=\"patentName\"></td>\n" +
                "                    <td><input type=\"text\" name=\"country\"></td>\n" +
                "                    <td><input type=\"text\" name=\"patentNumber\"></td>\n" +
                "                    <td><input type=\"text\" name=\"inventor\"></td>\n" +
                "                    <td><input type=\"text\" name=\"patentee\"></td>\n" +
                "                    <td><input type=\"date\" name=\"approvalDate\"></td>\n" +
                "                    <td><input type=\"text\" name=\"mstPlanNumber\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='patent'] tr[name=new]").before(data);
        }

        function createTechnologyTransfer() {
            var data = "<tr name=\"technologyTransfer\">\n" +
                "                    <td><input type=\"text\" name=\"technologyName\"></td>\n" +
                "                    <td><input type=\"text\" name=\"patentName\"></td>\n" +
                "                    <td><input type=\"text\" name=\"authorizedUnit\"></td>\n" +
                "                    <td><input type=\"text\" name=\"toAuthorizedUnit\"></td>\n" +
                "                    <td><input type=\"date\" name=\"contractDate\"></td>\n" +
                "                    <td><input type=\"text\" name=\"mstPlanNumber\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='technologyTransfer'] tr[name=new]").before(data);
        }

        function createAuthorization() {
            var data = "<tr name=\"workAuthorization\">\n" +
                "                    <td><input type=\"text\" name=\"patentClass\"></td>\n" +
                "                    <td><input type=\"text\" name=\"authorizationClass\"></td>\n" +
                "                    <td><input type=\"text\" name=\"author\"></td>\n" +
                "                    <td><input type=\"text\" name=\"copyrightOwner\"></td>\n" +
                "                    <td><input type=\"text\" name=\"agent\"></td>\n" +
                "                    <td><input type=\"text\" name=\"mstPlanNumber\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='authorization'] tr[name=new]").before(data);
        }

        $(document).on("click", "button[name='delete']",function(){
            var thisTr = $(this).parents("tr");
            thisTr.remove();
        });

        function commit(){
            var table1 = tableToJson($('form').find("table")[0]);
            var table2 = tableToJson($('form').find("table")[1]);
            var table3 = tableToJson($('form').find("table")[2]);

            let filledInputNum = 0;
            let totalInputNum = 0;

            for (let j=0; j<document.getElementsByTagName("input").length; j++) {
                let inputElem = document.getElementsByTagName("input")[j];
                if (inputElem.value.length > 0)
                    filledInputNum++;
                totalInputNum++;
            }
            let fillRate = filledInputNum / totalInputNum;

            var data = [table1, table2, table3, fillRate];

            $.ajax({
                type: 'POST',
                url: 'ResearchProduction',
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
    <script>
        $(document).ready(function (){
            setReadOnly(<%=request.getAttribute("readonly")%>);
        })
    </script>
</head>
<body>
<div class="content">
    <p>研發成果智慧財產權及其應用績效：<br>
        　1. 請將個人研發成果所產生之智慧財產權及其應用績效分為(1)專利(2)技術移轉(3)著作授權(4)其他等類別，分別填入下列表中。如欄位不足，請自行加印填寫。<br>
        　2. 填寫順序請依專利期間起始日排列，或技術移轉及著作授權之簽約日期排列。<br>
    </p>
    <form id="form">
        <div name="patent">
            <table>
                <tbody>
                        <tr><td class="metadata" colspan="9">(一)專利 請填入目前仍有效之專利。「類別」請填入代碼：(A)發明專利(B)新型專利(C)新式樣專利。</td></tr>
                        <tr>
                            <td class="metadata" name="patentClass">類別</td>
                            <td class="metadata" name="patentName">專利名稱</td>
                            <td class="metadata" name="country">國別</td>
                            <td class="metadata" name="patentNumber">專利號碼</td>
                            <td class="metadata" name="inventor">發明人</td>
                            <td class="metadata" name="patentee">專利權人</td>
                            <td class="metadata" name="approvalDate">專利核准日期</td>
                            <td class="metadata" name="mstPlanNumber">科技部計畫編號</td>
                            <td class="metadata">功能</td>
                        </tr>
                        <tr name="new"><td colspan="9" style="text-align: center"><button type="button" onclick="createPatent()">新增</button></td></tr>
                </tbody>
            </table>
        </div>
        <div name="technologyTransfer">
            <table>
                <tbody>
                    <tr><td class="metadata" colspan="9">(二)技術移轉</td></tr>
                    <tr>
                        <td class="metadata" name="technologyName">技術名稱</td>
                        <td class="metadata" name="patentName">專利名稱</td>
                        <td class="metadata" name="authorizedUnit">授權單位</td>
                        <td class="metadata" name="toAuthorizedUnit">被授權單位</td>
                        <td class="metadata" name="contractDate">簽約日期</td>
                        <td class="metadata" name="mstPlanNumber">科技部計畫編號</td>
                        <td class="metadata">功能</td>
                    </tr>
                    <tr name="new"><td colspan="9" style="text-align: center"><button type="button" onclick="createTechnologyTransfer()">新增</button></td></tr>
                </tbody>
            </table>
        </div>
        <div name="authorization">
            <table>
                <tbody>
                    <tr><td class="metadata" colspan="9">（三）著作授權 「類別」分(1)語文著作(2)電腦程式著作(3)視聽著作(4)錄音著作(5)其他，請擇一代碼填入。</td></tr>
                    <tr>
                        <td class="metadata" name="workName">著作名稱</td>
                        <td class="metadata" name="authorizationClass">類別</td>
                        <td class="metadata" name="author">著作人</td>
                        <td class="metadata" name="copyrightOwner">著作財產權人</td>
                        <td class="metadata" name="agent">被授權人</td>
                        <td class="metadata" name="mstPlanNumber">科技部計畫編號</td>
                        <td class="metadata">功能</td>
                    </tr>
                    <tr name="new"><td colspan="9" style="text-align: center"><button type="button" onclick="createAuthorization()">新增</button></td></tr>
                </tbody>
            </table>
        </div>
        <div>
            <table>
                <tbody>
                <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">
                    <span>
                        <input class="back" type="button" width="10%" value="上一頁" name="close" onclick="javascript:location.href='ExcellentResearcherCatalog'">
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
