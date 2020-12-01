<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/11/29
  Time: 下午 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>特聘教授申請表</title>
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
            <p>特聘教授申請表</p>
            <table>
                <tbody>
                    <tr>
                        <td class="metadata">姓名</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="metadata">系所</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="metadata">本校任職日期</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="metadata">教授證書號碼</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="metadata">教授升等日期</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="metadata">教授年資</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="metadata">E-mail</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="metadata">聯絡電話</td>
                        <td>
                        	<p>研究室分機：</p>
                        	<p>手機：</p>
                        </td>
                    </tr>
                </tbody>
            </table>
            <p>申請要件（可多選）</p>
            <p><input type="checkbox"></p>
            <p><input type="checkbox"></p>
            <p><input type="checkbox"></p>
            <p><input type="checkbox"></p>
            <p><input type="checkbox"></p>
            <p><input type="checkbox"></p>
            <p><input type="checkbox"></p>
            <p><input type="checkbox"></p>
        </form>
    </div>

</body>
</html>
