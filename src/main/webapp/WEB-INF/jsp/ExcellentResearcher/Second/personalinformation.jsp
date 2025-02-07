<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/11/29
  Time: 下午 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");
%>
<html>
<head>
    <title>個人基本資料</title>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
    <link rel="stylesheet" type="text/css" href="css/body.css">
    <style>
        td > p.sign{
            margin: 3rem 0 0;
            vertical-align: bottom;
        }
        .requiredField {
            color: red;
        }
    </style>
    <script src="js/jquery.min.js"></script>
    <script src="js/Function.js"></script>
    <script>
        function commit(){
            if ($("#college").val() && $("#department").val() && $("#hiredYear").val() && $("#hiredMonth").val() && $("#year").val()
                && $("#month").val() && $("#cName").val() && $("#eName").val() && $("#title").val() && $("#pastTitle").val()
                && $("#pastPrice").val() && $("#planName").val() && $("#planNumber").val() && $("#startTime").val() && $("#lastTime").val()
                && $("#level").val() && $("#price").val() && ($("#qualification1").prop("checked") || $("#qualification2").prop("checked")) && $("#workContent").val()) {
                $.ajax({
                    type: 'POST',
                    url: 'SecondPersonalInformation',
                    dataType: 'text',
                    data: JSON.stringify(InputToJson()),
                    contentType: 'application/json',
                    success: function(data){
                        alert('存檔成功');
                    }
                });
            }
            else {
                alert("尚未填寫完成!");
            }
        }

        function InputToJson(){
            var data = {};
            let filledInputNum = 0;
            let totalInputNum = 0;

            for (var j=0; j<document.getElementsByTagName("input").length; j++) {
                let inputElem = document.getElementsByTagName("input")[j];
                if (inputElem.type==='radio'){
                    data[inputElem.name] = $('input[name=' + inputElem.name + ']:checked').val()
                }else if (inputElem.type==='checkbox' && inputElem.checked === false){
                    data[inputElem.name] = "false";
                }else {
                    data[inputElem.name] = inputElem.value;
                    if (inputElem.className.length === 0) {
                        if (inputElem.value.length > 0) {
                            filledInputNum++;
                        }
                        totalInputNum++;
                    }
                }

            }

            for (var j=0; j<document.getElementsByTagName("select").length; j++){
                data[ document.getElementsByTagName("select")[j].name] = document.getElementsByTagName("select")[j].value;
            }

            data["fill_rate"] = filledInputNum / totalInputNum;
            return data;
        }

        function setReviewData(){
            //department
            $("#departmentDirectorSignDate").val("<%=json.optString("departmentDirectorSignDate", "")%>");

            //college
            $("#collegeReviewedDate").val("<%=json.optString("collegeReviewedDate", "")%>");
            let reviewedResult = "<%=json.optString("reviewedResult", "")%>";
            if (reviewedResult !== "")
                $("input[name=reviewedResult][value=" + reviewedResult + "]").attr('checked',true);
            $("#collegeRecommendationRank").val("<%=json.optString("collegeRecommendationRank", "")%>");
            $("#collegeDirectorSignDate").val("<%=json.optString("collegeDirectorSignDate", "")%>");
            changeCollegeRecommendationRankVisible(reviewedResult);
        }

        function changeCollegeRecommendationRankVisible(option) {
            if (option === 'passed') {
                document.getElementById("collegeRecommendationRank").disabled=false;
            } else {
                document.getElementById("collegeRecommendationRank").disabled=true;
                document.getElementById("collegeRecommendationRank").value="";
            }

        }

        $( document ).ready(function() {
            // 在這撰寫javascript程式碼
            $('#level').val("<%=json.get("level")%>");
            $('#qualification1').prop("checked","<%=json.get("qualification1")%>"=="true"?true:false);
            $('#qualification2').prop("checked","<%=json.get("qualification2")%>"=="true"?true:false);

            let role = "${role}";
            if (role === "industryLiaisonOffice" || role === "researchAndDevelopmentOffice") {
                $("#save").remove();
            }
            setReadOnly(<%=request.getAttribute("readonly")%>);
            $(".${role}").removeAttr("readonly");
            $(".${role}").removeAttr("disabled");

            setReviewData();
        });

    </script>
</head>
<body>
    <div class="content">
        <form>
            <table>
                <tbody>
                    <tr>
                        <td class="metadata"><span class="requiredField">✱</span>單位</td>
                        <td>
                            <input type="text" id="college" name="college" value="<%= json.get("college") %>" required>學院
                            <input type="text" id="department" name="department" value="<%= json.get("department") %>" required>系(所)
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata"><span class="requiredField">✱</span>起聘年月</td>
                        <td>
                            <input type="number" id="hiredYear" name="hiredYear" value="<%= json.get("hiredYear") %>" required>年
                            <input type="number" id="hiredMonth" name="hiredMonth" value="<%= json.get("hiredMonth") %>" required>月
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata"><span class="requiredField">✱</span>任職本校年資</td>
                        <td>
                            <input type="number" id="year" name="year" value="<%= json.get("year") %>" required>年
                            <input type="number" id="month" name="month" value="<%= json.get("month") %>" required>個月
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata"><span class="requiredField">✱</span>中文姓名</td>
                        <td><input type="text" id="cName" name="cName" value="<%= json.get("cName") %>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata"><span class="requiredField">✱</span>英文姓名</td>
                        <td><input type="text" id="eName" name="eName" value="<%= json.get("eName") %>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata"><span class="requiredField">✱</span>職稱</td>
                        <td><input type="text" id="title" name="title" value="<%= json.get("title") %>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">國籍</td>
                        <td><input type="text" name="country" value="<%= json.get("country") %>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">性別</td>
                        <td><input type="text" name="gender" value="<%= json.get("gender") %>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata"><span class="requiredField">✱</span>受本校延攬前之工作單位/職稱</td>
                        <td>
                            <input type="text" id="pastTitle" name="pastTitle" value="<%= json.get("pastTitle") %>" required>
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata"><span class="requiredField">✱</span>前一年度獲核定獎勵金額
                        </td>
                        <td>
                            每月新台幣<input type="text" id="pastPrice" name="pastPrice" value="<%= json.get("pastPrice") %>" required>萬元
                        </td>
                    </tr>
                    <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">申請獎勵等級及符合資格</td></tr>
                    <tr>
                        <td class="metadata"><span class="requiredField">✱</span>一年內曾執行科技部計畫</td>
                        <td>計畫名稱:<input type="text" id="planName"  name="planName" value="<%= json.get("planName") %>" required>
                        計畫編號:<input type="text" id="planNumber" name="planNumber" value="<%= json.get("planNumber") %>" required>
                        執行期間:<input type="date" id="startTime" name="startTime" value="<%= json.get("startTime") %>" required>至<input type="date" id="lastTime" name="lastTime" value="<%= json.get("lastTime") %>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata"><span class="requiredField">✱</span>本次申請續撥期間及每月獎勵金</td>
                        <td>
                            <select name="level" id="level">
                                <option value="second">第二年</option>
                                <option value="third">第三年</option>
                            </select>
                            每月新台幣<input type="number" id="price" name="price" value="<%= json.get("price") %>" required>萬元
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata"><span class="requiredField">✱</span>定期考評</td>
                        <td>
                            <input type="checkbox" name="qualification1" id="qualification1" value="true">獲獎勵期間學術研究成果及貢獻
                            <input type="checkbox" name="qualification2" id="qualification2" value="true">前一年度具體執行績效
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata"><span class="requiredField">✱</span>獲奬勵期間工作內容</td>
                        <td>
                            <input type="text" name="workContent" id="workContent" value=<%= json.get("workContent") %>>
                        </td>
                    </tr>
                    <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">申請單位審查意見</td></tr>
                    <tr>
                        <td colspan="2">
                            本案申請人業經本院
                            <input id="collegeReviewedDate" name="collegeReviewedDate" class="college" type="date" style="width: auto;" disabled>
                            教評會審核申請科技部補助大專校院獎勵特殊優秀研究人才之彈性薪資(檢附院教評會議紀錄)，所提各項申請與證明文件屬實。<p>
                            <label><input type="radio" name="reviewedResult" value="passed" class="college" onFocus="changeCollegeRecommendationRankVisible('passed')" disabled>審查通過 (學院推薦排序 NO.<input id="collegeRecommendationRank" name="collegeRecommendationRank" class="college" maxlength="4" style="width: 5ch;" disabled>) 。</label><br>
                            <label><input type="radio" name="reviewedResult" value="failed" class="college" onFocus="changeCollegeRecommendationRankVisible('failed')" disabled>不予推薦。</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">系所主管核章</td>
                        <td>
                            <p class="sign">
                                <a style="float:left;">本案業經系所確認繳送資料齊備</a>
                                <a style="float:right;">日期:<input id="departmentDirectorSignDate" type="date" name="departmentDirectorSignDate" class="department" disabled></a>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">院長核章</td>
                        <td>
                            <p class="sign">
                                <a style="float:left;">本案業經院教評會審議通過(請檢附會議記錄)</a>
                                <a style="float:right;">日期:<input id="collegeDirectorSignDate" type="date" name="collegeDirectorSignDate" class="college" disabled></a>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">
                            <span><input type="button" width="10%" value="上一頁" name="close" onclick="javascript:location.href='SecondExcellentResearcherCatalog'"></span>
                            <span><input type="button" id="save" value="暫存" onclick="commit()"></span>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>

</body>
</html>
