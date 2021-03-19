<%@ page import="java.util.List" %><%--
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
        <form action="/SelectReward" method="post">
            <p style="text-align:left;font-weight:bold;font-size:20px;">申請獎項： </p>
            <table>
                <tr>
                    <td class="metadata">選擇申請獎項</td>
                    <td>
                        <select name="reward">
                            <%
                                for (String reward: (List<String>)request.getAttribute("rewardList")){
                            %>
                                <option value="<%=reward%>"><%=reward%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><input type="submit" value="申請"></td></tr>
            </table>
        </form>
    </div>

</body>
</html>
