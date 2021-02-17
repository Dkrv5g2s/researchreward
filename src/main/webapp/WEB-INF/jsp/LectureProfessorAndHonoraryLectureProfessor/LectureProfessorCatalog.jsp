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
            <td class="metadata" style="width:20%;">表格編號</td>
            <td class="metadata" style="width:40%;">表格名稱</td>
            <%--            <th style="width:20%;">完成度</th>--%>
        </tr>
        </thead>
        <tbody>
        <tr class="">
            <td>1</td>
            <td align="left"><a style="color:blue" href="LectureProfessorApplicationForm">講座教授申請表</a></td>
            <%--            <% if(c001_Form.getComplete_rate()<100){ %>--%>
            <%--            <td><span style="color:red;"><%=c001_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% }else{ %>--%>
            <%--            <td><span style="color:green;"><%=c001_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% } %>--%>
        </tr>
        <tr class="">
            <td>2</td>
            <td align="left"><a style="color:blue" href="LectureProfessorHonoraryApplicationForm">榮譽講座教授申請表</a></td>
            <%--            <% if(c001_Form.getComplete_rate()<100){ %>--%>
            <%--            <td><span style="color:red;"><%=c001_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% }else{ %>--%>
            <%--            <td><span style="color:green;"><%=c001_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% } %>--%>
        </tr>
        <tr class="">
            <td>3</td>
            <td align="left"><a style="color:blue" href="LectureProfessorAppDocInstructions" >審查資料(填寫說明)</a></td>
            <%--            <% if(c002_Form.getComplete_rate()<100){ %>--%>
            <%--            <td><span style="color:red;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% }else{ %>--%>
            <%--            <td><span style="color:green;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% } %>--%>
        </tr>
        <tr class="">
            <td>4</td>
            <td align="left"><a style="color:blue" href="LectureProfessorExcellenceFormA" >近五年內傑出績效說明表(表A)</a></td>
            <%--            <% if(c002_Form.getComplete_rate()<100){ %>--%>
            <%--            <td><span style="color:red;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% }else{ %>--%>
            <%--            <td><span style="color:green;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% } %>--%>
        </tr>
        <tr class="">
            <td>5</td>
            <td align="left"><a style="color:blue" href="PaperPerformanceDescriptionForm" >國立臺北科技大學傑出論文績效說明表(表B)</a></td>
            <%--            <% if(c002_Form.getComplete_rate()<100){ %>--%>
            <%--            <td><span style="color:red;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% }else{ %>--%>
            <%--            <td><span style="color:green;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% } %>--%>
        </tr>
        <tr class="">
            <td>5</td>
            <td align="left"><a style="color:blue" href="PaperPerformanceDescriptionUpload" >國立臺北科技大學傑出論文績效說明表(表B)-上傳檔案</a></td>
            <%--            <% if(c002_Form.getComplete_rate()<100){ %>--%>
            <%--            <td><span style="color:red;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% }else{ %>--%>
            <%--            <td><span style="color:green;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% } %>--%>
        </tr>
        <tr class="">
            <td>6</td>
            <td align="left"><a style="color:blue" href="LectureProfessorExcellenceFormC" >傑出研究表現說明及申請機構推薦理由</a></td>
            <%--            <% if(c002_Form.getComplete_rate()<100){ %>--%>
            <%--            <td><span style="color:red;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% }else{ %>--%>
            <%--            <td><span style="color:green;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% } %>--%>
        </tr>
        <tr class="">
            <td>7</td>
            <td align="left"><a style="color:blue" href="LectureProfessorExcellenceFormD" >講座期間之績效表現(申請第二任以上者填寫)</a></td>
            <%--            <% if(c002_Form.getComplete_rate()<100){ %>--%>
            <%--            <td><span style="color:red;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% }else{ %>--%>
            <%--            <td><span style="color:green;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% } %>--%>
        </tr>
        <tr class="">
            <td>8</td>
            <td align="left"><a style="color:blue" href="LectureProfessorRefPoint" >附表一：國立臺北科技大學論文點數計算公式</a></td>
            <%--            <% if(c002_Form.getComplete_rate()<100){ %>--%>
            <%--            <td><span style="color:red;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% }else{ %>--%>
            <%--            <td><span style="color:green;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% } %>--%>
        </tr>
        <tr class="">
            <td>9</td>
            <td align="left"><a style="color:blue" href="LectureProfessorRefTable" >附件一：優質期刊清單</a></td>
            <%--            <% if(c002_Form.getComplete_rate()<100){ %>--%>
            <%--            <td><span style="color:red;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
            <%--            <% }else{ %>--%>
            <%--            <td><span style="color:green;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
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
