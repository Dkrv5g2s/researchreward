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
    <title>個人基本資料</title>
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
            <table>
                <tbody>
                    <tr>
                        <td class="metadata">單位</td>
                        <td>
                            <input type="text" required>學院
                            <input type="text" required>系(所)
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">起聘年月</td>
                        <td>
                            <input type="number" required>年
                            <input type="number" required>月
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">任職本校年資</td>
                        <td>
                            <input type="number" required>年
                            <input type="number" required>個月
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">中文姓名</td>
                        <td><input type="text" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">英文姓名</td>
                        <td><input type="text" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">職稱</td>
                        <td><input type="text" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">國籍</td>
                        <td><input type="text" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">性別</td>
                        <td><input type="text" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">最高學歷</td>
                        <td>
                            學校名稱:<input type="text" required>
                            主修學門系所:<input type="text" required>
                            學位:<input type="text" required><br>
                            畢業年月:<input type="number" required>年
                            <input type="number" required>月
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">重要經歷</td>
                        <td>
                            服務機構:<input type="text" required>
                            服務部門:<input type="text" required>
                            職稱:<input type="text" required><br>
                            起迄年月:<input type="number" required>年
                            <input type="number" required>月
                        </td>
                    </tr>
                    <tr><td colspan="2" style="text-align: center; background-color: #FFFFCC"><input type="submit" value="存檔"></td></tr>
                </tbody>
            </table>
        </form>
    </div>

</body>
</html>
