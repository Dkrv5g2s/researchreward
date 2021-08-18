<%@ page import="fr.opensagres.xdocreport.document.json.JSONArray" %>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2021/1/20
  Time: 下午 03:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% JSONArray array = (JSONArray) request.getAttribute("json");%>
<html>
<head>
    <title>查看退件獎項</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function commit(project_id,rewardName){
            $.ajax({
                type: 'POST',
                url: '/RewardList',
                dataType: 'json',
                data: JSON.stringify({
                    projectId:project_id,
                    rewardName:rewardName
                }),
                contentType: 'application/json',
                complete:function(XMLHttpRequest,textStatus){
                    var newDoc = document.open("text/html", "replace");
                    newDoc.write(XMLHttpRequest.responseText);
                    newDoc.close();
                }
            });

        };

        function deleteCommit(project_id,rewardName){
            $.ajax({
                type: 'POST',
                url: '/deleteRewardList',
                dataType: 'text',
                data: JSON.stringify({
                    projectId:project_id,
                    rewardName:rewardName
                }),
                contentType: 'application/json',
                complete:function(XMLHttpRequest,textStatus){
                    alert('刪除成功');
                    window.location.href="RewardList";
                }
            });

        };

        $(document).on("click", "button[name='modify']",function(){

            var projectId = $(this).parents("tr").find("td").eq(0).text();
            var rewardName = $(this).parents("tr").find("td").eq(1).text();
            commit(projectId,rewardName);
        });

        $(document).on("click", "button[name='delete']",function(){
            var projectId = $(this).parents("tr").find("td").eq(0).text();
            var rewardName = $(this).parents("tr").find("td").eq(1).text();
            if(confirm("您確定要刪除此筆申請獎項嗎?")){
                deleteCommit(projectId,rewardName);
            }

        });
    </script>
</head>
<body>
    <div class="content">
        <table>
            <tr>
                <td class="metadata">申請編號</td>
                <td class="metadata">申請獎項</td>
                <td class="metadata">退件原因</td>
                <td class="metadata">操作</td>
            </tr>
            <%
                for(Object element: array){
                    JSONObject json = (JSONObject) element;
            %>
            <tr>
                <td><%=json.optInt("project_id")%></td>
                <td><%=json.optString("reward_type")%></td>
                <td style="white-space: pre-line;"><%=json.optString("reason_for_return")%></td>
                <td>
                    <span><button type="button" name="modify">修改</button></span>
                    <span><button type="button" name="delete">刪除</button></span>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </div>

</body>
</html>
