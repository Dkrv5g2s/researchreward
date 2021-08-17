<%@ page import="com.alibaba.fastjson.JSONObject" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%
    JSONObject awardsYears = (JSONObject) request.getAttribute("awardsYears");
    JSONObject teacherHireResearcher = awardsYears.getJSONObject("TeacherHireResearcher")==null ? new JSONObject() : awardsYears.getJSONObject("TeacherHireResearcher");
    JSONObject lectureProfessor = awardsYears.getJSONObject("LectureProfessor")==null ? new JSONObject() : awardsYears.getJSONObject("LectureProfessor");
    JSONObject distinguishedProfessor = awardsYears.getJSONObject("DistinguishedProfessor")==null ? new JSONObject() : awardsYears.getJSONObject("DistinguishedProfessor");
    JSONObject specialOutstandingResearcher = awardsYears.getJSONObject("SpecialOutstandingResearcher")==null ? new JSONObject() : awardsYears.getJSONObject("SpecialOutstandingResearcher");
    JSONObject juniorResearchInvestigator = awardsYears.getJSONObject("JuniorResearchInvestigator")==null ? new JSONObject() : awardsYears.getJSONObject("JuniorResearchInvestigator");
    JSONObject outstandingResearchAward = awardsYears.getJSONObject("OutstandingResearchAward")==null ? new JSONObject() : awardsYears.getJSONObject("OutstandingResearchAward");
%>
<html>
<head>
    <title>Title</title>
    <title>各獎項期刊論文統計表年度設定</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>
        table {
            table-layout: fixed;
        }
    </style>
</head>
<body>
<div class="content" >
    <form>
        <table>
            <tbody>
            <tr>
                <td colspan="1" class="metadata">設定年度類型</td>
                <td colspan="1" class="metadata">獎項名稱</td>
                <td colspan="5">期刊論文統計表年度</td>
            </tr>
            <tr>
                <td rowspan="4" colspan="1" class="metadata">近五年年度設定</td>
                <td colspan="1" class="metadata"><label name="TeacherHireResearcher">奬助研究及產學績優教師聘任研究人員辦法</label></td>
                <td colspan="5">
                    <input type="number" name="year1" min="100" max="199" step="1" value=<%=teacherHireResearcher.getIntValue("year1")%> />
                    <input type="number" name="year2" min="100" max="199" step="1" value=<%=teacherHireResearcher.getIntValue("year2")%> />
                    <input type="number" name="year3" min="100" max="199" step="1" value=<%=teacherHireResearcher.getIntValue("year3")%> />
                    <input type="number" name="year4" min="100" max="199" step="1" value=<%=teacherHireResearcher.getIntValue("year4")%> />
                    <input type="number" name="year5" min="100" max="199" step="1" value=<%=teacherHireResearcher.getIntValue("year5")%> />
                </td>
            </tr>
            <tr>
                <td colspan="1" class="metadata"><label name="LectureProfessor">講座教授</label></td>
                <td colspan="5">
                    <input type="number" name="year1" min="100" max="199" step="1" value=<%=lectureProfessor.getIntValue("year1")%> />
                    <input type="number" name="year2" min="100" max="199" step="1" value=<%=lectureProfessor.getIntValue("year2")%> />
                    <input type="number" name="year3" min="100" max="199" step="1" value=<%=lectureProfessor.getIntValue("year3")%> />
                    <input type="number" name="year4" min="100" max="199" step="1" value=<%=lectureProfessor.getIntValue("year4")%> />
                    <input type="number" name="year5" min="100" max="199" step="1" value=<%=lectureProfessor.getIntValue("year5")%> />
                </td>
            </tr>

            <tr>
                <td colspan="1" class="metadata"><label name="DistinguishedProfessor">特聘教授</label></td>
                <td colspan="5">
                    <input type="number" name="year1" min="100" max="199" step="1" value=<%=distinguishedProfessor.getIntValue("year1")%> />
                    <input type="number" name="year2" min="100" max="199" step="1" value=<%=distinguishedProfessor.getIntValue("year2")%> />
                    <input type="number" name="year3" min="100" max="199" step="1" value=<%=distinguishedProfessor.getIntValue("year3")%> />
                    <input type="number" name="year4" min="100" max="199" step="1" value=<%=distinguishedProfessor.getIntValue("year4")%> />
                    <input type="number" name="year5" min="100" max="199" step="1" value=<%=distinguishedProfessor.getIntValue("year5")%> />
                </td>
            </tr>

            <tr>
                <td colspan="1" class="metadata"><label name="SpecialOutstandingResearcher">獎勵特殊優秀研究人才</label></td>
                <td colspan="5">
                    <input type="number" name="year1" min="100" max="199" step="1" value=<%=specialOutstandingResearcher.getIntValue("year1")%> />
                    <input type="number" name="year2" min="100" max="199" step="1" value=<%=specialOutstandingResearcher.getIntValue("year2")%> />
                    <input type="number" name="year3" min="100" max="199" step="1" value=<%=specialOutstandingResearcher.getIntValue("year3")%> />
                    <input type="number" name="year4" min="100" max="199" step="1" value=<%=specialOutstandingResearcher.getIntValue("year4")%> />
                    <input type="number" name="year5" min="100" max="199" step="1" value=<%=specialOutstandingResearcher.getIntValue("year5")%> />
                </td>
            </tr>
            <tr>
                <td rowspan="2" colspan="1" class="metadata">近三年年度設定</td>
                <td colspan="1" class="metadata"><label name="JuniorResearchInvestigator">年輕學者研究獎</label></td>
                <td colspan="5">
                    <input type="number" name="year1" min="100" max="199" step="1" value=<%=juniorResearchInvestigator.getIntValue("year1")%> />
                    <input type="number" name="year2" min="100" max="199" step="1" value=<%=juniorResearchInvestigator.getIntValue("year2")%> />
                    <input type="number" name="year3" min="100" max="199" step="1" value=<%=juniorResearchInvestigator.getIntValue("year3")%> />
                </td>
            </tr>
            <tr>
                <td colspan="1" class="metadata"><label name="OutstandingResearchAward">傑出研究獎</label></td>
                <td colspan="5">
                    <input type="number" name="year1" min="100" max="199" step="1" value=<%=outstandingResearchAward.getIntValue("year1")%> />
                    <input type="number" name="year2" min="100" max="199" step="1" value=<%=outstandingResearchAward.getIntValue("year2")%> />
                    <input type="number" name="year3" min="100" max="199" step="1" value=<%=outstandingResearchAward.getIntValue("year3")%> />
                </td>
            </tr>

            <tr>
                <td colspan="7" style="text-align: center; background-color: rgb(255, 255, 240)">
                    <button type="button" onclick="commit()">存檔</button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <p>註:陽光獎助金、獎勵新聘特殊優秀研究人才、(續撥)獎勵新聘特殊優秀研究人才不需設定此參數</p>
</div>
<script>
    function commit(){
        $.ajax({
            type: 'POST',
            url: '/RewardTableAAnnualIntervalSetting',
            dataType: 'text',
            data: JSON.stringify(InputToJson()),
            contentType: 'application/json',
            success: function(){
                alert('存檔成功');
                window.location.reload();
            },
            error: function(){
                alert('存檔失敗');
            }
        });
    }

    function InputToJson() {
        let dataJsonObject = {};
        let data = document.getElementsByTagName("label");
        for (let j = 0; j < data.length; j++) {
            let dataObject = {};
            const inputList = data.item(j).parentNode.nextElementSibling.children;
            for (let i = 0; i < inputList.length; i++) {
                const input = inputList[i];
                dataObject[input.name] = input.valueAsNumber;
            }
            const awardName = document.getElementsByTagName("label")[j].getAttribute("name");
            dataJsonObject[awardName] = dataObject;
        }
        return dataJsonObject;
    }

</script>
</body>
</html>
