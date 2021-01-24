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
        <tr class="">
            <td>C002</td>
            <td align="left"><a style="color:blue" href="PaperPerformanceDescriptionForm" >論文績效說明表(表B)</a></td>
<%--            <% if(c002_Form.getComplete_rate()<100){ %>--%>
<%--            <td><span style="color:red;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
<%--            <% }else{ %>--%>
<%--            <td><span style="color:green;"><%=c002_Form.getComplete_rate()%>%</span></td>--%>
<%--            <% } %>--%>
        </tr>
        <tr class="">
            <td>C003</td>
            <td align="left"><a style="color:blue" href="ReviewSupportingInformationForm" >審查佐證資料</a></td>
<%--            <% if(c003_Form.getC003_Form_Datas().size()==0){ %>--%>
<%--            <td><span style="color:red;">※請至少填寫一個</span></td>--%>
<%--            <% }else { %>--%>
<%--            <td><span style="color:green;">已填寫</span></td>--%>
<%--            <% } %>--%>
        </tr>
        <tr class="">
            <td>C004</td>
            <td align="left"><a style="color:blue" href="PaperPerformanceDescriptionUpload" >論文績效說明表(表B)-上傳檔案</a></td>
            <%--            <% if(c003_Form.getC003_Form_Datas().size()==0){ %>--%>
            <%--            <td><span style="color:red;">※請至少填寫一個</span></td>--%>
            <%--            <% }else { %>--%>
            <%--            <td><span style="color:green;">已填寫</span></td>--%>
            <%--            <% } %>--%>
        </tr>


<%--        <tr class="">--%>
<%--            <td>C004</td>--%>
<%--            <td align="left"><a style="color:blue" href="Main?func=formC004&id=<%=id%>">研究人事費</a></td>--%>
<%--            <%if(c004_Form.getC004_Form_Data01s().size()>0||c004_Form.getC004_Form_Data02s().size()>0){ %>--%>
<%--            <td><span style="color:green;">已填寫</span></td>--%>
<%--            <% }else { %>--%>
<%--            <td><span style="color:red;">未填寫(非必填)</span></td>--%>
<%--            <% } %>--%>
<%--        </tr>--%>
<%--        <tr class="">--%>
<%--            <td>C005</td>--%>
<%--            <td align="left"><a style="color:blue" href="Main?func=formC005&id=<%=id%>">業務費</a></td>--%>
<%--            <%if(c005_Form.getC005_Form_Datas().size()>0){ %>--%>
<%--            <td><span style="color:green;">已填寫</span></td>--%>
<%--            <% }else { %>--%>
<%--            <td><span style="color:red;">未填寫(非必填)</span></td>--%>
<%--            <% } %>--%>
<%--        </tr>--%>
<%--        <tr class="">--%>
<%--            <td>C006</td>--%>
<%--            <td align="left"><a style="color:blue" href="Main?func=formC006&id=<%=id%>">儀器設備費</a></td>--%>
<%--            <%if(c006_Form.getC006_Form_Datas().size()>0){ %>--%>
<%--            <td><span style="color:green;">已填寫</span></td>--%>
<%--            <% }else { %>--%>
<%--            <td><span style="color:red;">未填寫(非必填)</span></td>--%>
<%--            <% } %>--%>
<%--        </tr>--%>
<%--        <tr class="">--%>
<%--            <td>C007</td>--%>
<%--            <td align="left"><a style="color:blue" href="Main?func=formC007&id=<%=id%>">整合型研究計畫項目及重點說明</a></td>--%>
<%--            <% if(!c001_Form.getProject_type().equals("integration")){ %>--%>
<%--            <td><span style="color:green;">※非整合型研究計畫不需上傳</span></td>--%>
<%--            <% }else {--%>
<%--                if(c007to303_Form.getC007_path().equals("")){ %>--%>
<%--            <td><span style="color:red;">未上傳</span></td>--%>
<%--            <% }else{ %>--%>
<%--            <td><span style="color:green;">已上傳</span></td>--%>
<%--            <% }--%>
<%--            } %>--%>
<%--        </tr>--%>
<%--        <tr class="">--%>
<%--            <td>C008</td>--%>
<%--            <td align="left"><a style="color:blue" href="Main?func=formC008&id=<%=id%>">研究計畫中英文摘要</a></td>--%>
<%--            <% if(c007to303_Form.getC008_path().equals("")){ %>--%>
<%--            <td><span style="color:red;">未上傳</span></td>--%>
<%--            <% }else{ %>--%>
<%--            <td><span style="color:green;">已上傳</span></td>--%>
<%--            <% } %>--%>
<%--        </tr>--%>
<%--        <tr class="">--%>
<%--            <td>C009</td>--%>
<%--            <td align="left"><a style="color:blue" href="Main?func=formC009&id=<%=id%>">研究計畫內容</a></td>--%>
<%--            <% if(c007to303_Form.getC009_path().equals("")){ %>--%>
<%--            <td><span style="color:red;">未上傳</span></td>--%>
<%--            <% }else{ %>--%>
<%--            <td><span style="color:green;">已上傳</span></td>--%>
<%--            <% } %>--%>
<%--        </tr>--%>
<%--        <tr class="">--%>
<%--            <td>C010</td>--%>
<%--            <td align="left"><a style="color:blue" href="Main?func=formC010&id=<%=id%>">近五年內執行之研究計畫</a></td>--%>
<%--            <% if(c007to303_Form.getC010_path().equals("")){ %>--%>
<%--            <td><span style="color:red;">未上傳</span></td>--%>
<%--            <% }else{ %>--%>
<%--            <td><span style="color:green;">已上傳</span></td>--%>
<%--            <% } %>--%>
<%--        </tr>--%>
<%--        <tr class="">--%>
<%--            <td rowspan="2">C301、C302、C303</td>--%>
<%--            <td align="left"><a style="color:blue" href="Main?func=formC301to303_01&id=<%=id%>">本校申請人員個人資料表</a></td>--%>
<%--            <% if(c007to303_Form.getC301to303_path01().equals("")){ %>--%>
<%--            <td><span style="color:red;">未上傳</span></td>--%>
<%--            <% }else{ %>--%>
<%--            <td><span style="color:green;">已上傳</span></td>--%>
<%--            <% } %>--%>
<%--        </tr>--%>
<%--        <tr class="">--%>
<%--            <td align="left"><a style="color:blue" href="Main?func=formC301to303_02&id=<%=id%>">合作學校申請人員個人資料表</a></td>--%>
<%--            <% if(c007to303_Form.getC301to303_path02().equals("")){ %>--%>
<%--            <td><span style="color:red;">未上傳</span></td>--%>
<%--            <% }else{ %>--%>
<%--            <td><span style="color:green;">已上傳</span></td>--%>
<%--            <% } %>--%>
<%--        </tr>--%>
<%--        <tr class="">--%>
<%--            <td>SCI成果調查</td>--%>
<%--            <td align="left">--%>
<%--                <a style="color:blue" href="Main?func=sci_project&staff_code=<%=project.getStaff_code()%>">SCI成果資料</a>--%>
<%--            </td>--%>
<%--            <td><span style="color:red;">(曾獲校際學術合作補助者須填寫)</span></td>--%>
<%--        </tr>--%>
<%--        <tr class="">--%>
<%--            <td>其他成果資料</td>--%>
<%--            <td align="left">--%>
<%--                <a style="color:blue" href="Main?func=other_achievement&staff_code=<%=project.getStaff_code()%>">其他成果資料</a>--%>
<%--            </td>--%>
<%--            <td><span style="color:red;">(曾獲校際學術合作補助者須填寫)</span></td>--%>
<%--        </tr>--%>
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
