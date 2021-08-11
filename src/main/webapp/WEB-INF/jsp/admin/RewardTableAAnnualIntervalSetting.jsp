<%@ page import="fr.opensagres.xdocreport.document.json.JSONArray" %>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page import="Bean.Award.Award" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>各獎項期刊論文統計表年度設定</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>
        table {
            table-layout: fixed;
            color: black;
            width: 100%;
            border-style: groove;
            border-collapse: collapse;
            font: normal 13px Verdana;
        }
    </style>
</head>
<body>
<div class="content" >
    <form>
        <table>
            <tbody>
            <tr>
                <td colspan="1" class="metadata">設定年度類型</td>
                <td colspan="1" class="metadata">獎項名稱</td>
                <td colspan="5">期刊論文統計表年度</td>
            </tr>
            <tr>
                <td rowspan="5" colspan="1" class="metadata">近五年年度設定</td>
                <td colspan="1" class="metadata">奬助研究績優教師聘任研究人員</td>
                <td colspan="5">
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
<%--                    <input type="date" name="s5" value="<%= jsonObject.getDate("s5")%>" required>至<input type="date" name="l5" value="<%= jsonObject.getDate("l5")%>" required>--%>
                </td>
            </tr>
            <tr>
                <td colspan="1" class="metadata">講座教授/榮譽講座教授</td>
                <td colspan="5">
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                </td>
            </tr>

            <tr>
                <td colspan="1" class="metadata">特聘教授</td>
                <td colspan="5">
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                </td>
            </tr>

            <tr>
                <td colspan="1" class="metadata">獎勵特殊優秀研究人才</td>
                <td colspan="5">
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                </td>
            </tr>
            <tr>
                <td colspan="1" class="metadata">獎勵新聘特殊優秀研究人才</td>
                <td colspan="5">
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                </td>
            </tr>
            <tr>
                <td rowspan="2" colspan="1" class="metadata">近三年年度設定</td>
                <td colspan="1" class="metadata">年輕學者研究獎</td>
                <td colspan="5">
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                </td>
            </tr>
            <tr>
                <td colspan="1" class="metadata">傑出研究獎</td>
                <td colspan="5">
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                    <input type="number" min="1900" max="2099" step="1" value="" />
                </td>
            </tr>

            <tr><td colspan="7" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">存檔</button></td></tr>
            </tbody>
        </table>
    </form>
    <p>註:陽光獎助金、(續撥)獎勵新聘特殊優秀研究人才不需設定此參數</p>



</div>
</body>
</html>
