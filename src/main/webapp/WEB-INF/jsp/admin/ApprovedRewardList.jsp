<%@ page import="fr.opensagres.xdocreport.document.json.JSONArray" %>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% JSONArray array = (JSONArray) request.getAttribute("json");%>
<html>
<head>
    <title>已審核獎項</title>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
</head>
<body>
    <div class="content">
        <table>
            <tr>
                <td class="metadata">申請編號</td>
                <td class="metadata">申請獎項</td>
                <td class="metadata">審查者</td>
                <td class="metadata">審查時間</td>
                <td class="metadata">審查狀態</td>
            </tr>
            <%
                for(Object element: array){
                    JSONObject json = (JSONObject) element;
            %>
            <tr>
                <td><%=json.optInt("project_id", -1)%></td>
                <td><%=json.optString("reward_type", "null")%></td>
                <td><%=json.optString("reviewer", "null")%></td>
                <td><%=json.optString("review_time", "null")%></td>
                <td><%=json.optString("status", "null")%></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>

</body>
</html>
