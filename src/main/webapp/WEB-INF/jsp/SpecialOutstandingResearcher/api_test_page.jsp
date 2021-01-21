<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="com.google.gson.*" %>

<%@ page import="Bean.Project.RewardProject" %>
<%  /*避免瀏覽器因cache而無法看到最新資料*/
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE HTML>
<html lang="zh">
<link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<div class="container" style="margin: 0px auto; width: 1200px">
    <table >
        <thead>
        <tr  >
            <td class="metadata" style="width:20%;">表格代號</td>
            <td class="metadata" style="width:40%;">表格名稱</td>
            <%--            <th style="width:20%;">完成度</th>--%>
        </tr>
        </thead>
        <tbody>
        <tr class="">
            <td>C001</td>
            <td align="left"><a style="color:blue" href="SpecialOutstandingResearcherApplicationForm">獎勵特殊優秀研究人才申請表</a></td>
            <%--            <% if(c001_Form.getComplete_rate()<100){ %>--%>
            <%--            <td><span style="color:red;"><%=c001_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% }else{ %>--%>
            <%--            <td><span style="color:green;"><%=c001_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% } %>--%>
        </tr>

        </tbody>
        <thead>
        <tr>
            <th colspan="3" style="width:1000px;">  </th>
        </tr>
        </thead>
    </table>
</div>
<script>


</script>
</html>
