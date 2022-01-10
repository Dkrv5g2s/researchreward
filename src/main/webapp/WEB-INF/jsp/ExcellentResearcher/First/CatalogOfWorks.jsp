<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/1
  Time: 上午 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% JSONObject json = (JSONObject) request.getAttribute("json");%>
<html>
<head>
    <title>申請表額外文件</title>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
    <link rel="stylesheet" type="text/css" href="css/body.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/js/Function.js"></script>
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: '/CatalogOfWorks',
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

            for (let j=0; j<document.getElementsByTagName("input").length; j++) {
                if (document.getElementsByTagName("input")[j].type==='checkbox' && document.getElementsByTagName("input")[j].checked === false){
                    data[document.getElementsByTagName("input")[j].name] = "false";
                }else {
                    data[document.getElementsByTagName("input")[j].name] = document.getElementsByTagName("input")[j].value;
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
            <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">著作目錄</td></tr>
            <tr>
                <td class="metadata">請詳列個人申請截止日前5年內發表之學術性著作，包括：期刊論文、專書及專書論文、研討會論文、技術報告及其他等，並請依各類著作之重要性自行排列先後順序。</td>
                <td>
                    <textarea type="text" required maxlength="1000" name="work"><%=json.get("work")%></textarea>
                </td>
            </tr>
            <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><span><button type="button" onclick="commit()">存檔</button></span><span><input type="button" width="10%" value="上一頁" name="close" onclick="javascript:location.href='ExcellentResearcherCatalog'"></span></td></tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
