<%@ page import="fr.opensagres.xdocreport.document.json.JSONArray" %>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2021/1/20
  Time: 下午 03:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% JSONArray array = (JSONArray) request.getAttribute("json");%>

<html>
<head>
    <title>申請進度追蹤</title>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
</head>
<body>
<div class="content">
    <table>
        <tr>
            <td class="metadata">申請編號</td>
            <td class="metadata">申請獎項</td>
            <td class="metadata">申請時間</td>
            <td class="metadata">送審進度</td>
        </tr>
        <%
            for(Object element: array){
                JSONObject json = (JSONObject) element;
        %>
        <tr>
            <td><%=json.getInt("project_id")%></td>
            <td><%=json.getString("reward_type")%></td>
            <td><%=json.getDate("apply_date")%></td>
            <td><%=json.getString("status")%></td>
        </tr>
        <%
            }
        %>
    </table>
</div>

</body>
</html>
