<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2021/1/20
  Time: 下午 02:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>選獎項</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">


</head>
<body>
    <div class="content" style="width: 60%">
        <form>
            <p style="text-align:left;font-weight:bold;font-size:20px;">新增計畫： </p>
            <table>
                <tr>
                    <td class="metadata">選擇申請獎項</td>
                    <td>
                        <select>
                            <option>測試</option>
                        </select>
                    </td>
                </tr>
                <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">新增獎項</button></td></tr>
            </table>
        </form>
    </div>

</body>
</html>
