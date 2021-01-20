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
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
<link rel="stylesheet" type="text/css" href="/css/body.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: '/PersonalInformation',
                dataType: 'json',
                data: JSON.stringify(InputToJson()),
                contentType: 'application/json',
                success: function(data){
                    alert('success');
                }
            });

        };

        function InputToJson(){
            var data = {};

            for (var j=0; j<document.getElementsByTagName("input").length; j++) {
                if (document.getElementsByTagName("input")[j].type=='checkbox' && document.getElementsByTagName("input")[j].checked == false){
                    continue;
                }else {
                    data[ document.getElementsByTagName("input")[j].name] = document.getElementsByTagName("input")[j].value;
                }

            }

            for (var j=0; j<document.getElementsByTagName("select").length; j++){
                data[ document.getElementsByTagName("select")[j].name] = document.getElementsByTagName("select")[j].value;
            }



            return data;
        }


        $( document ).ready(function() {
            // 在這撰寫javascript程式碼
            $('#level').val("<%=json.get("level")%>");
            $('#qualification1').prop("checked","<%=json.get("qualification1")%>");
            $('#qualification2').prop("checked","<%=json.get("qualification2")%>");
        });
    </script>
</head>
<body>
    <div class="content">
        <form>
            <table>
                <tbody>
                    <tr>
                        <td class="metadata">單位</td>
                        <td>
                            <input type="text" name="college" value="<%= json.get("college") %>" required>學院
                            <input type="text" name="department" value="<%= json.get("department") %>" required>系(所)
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">起聘年月</td>
                        <td>
                            <input type="number" name="hiredYear" value="<%= json.get("hiredYear") %>" required>年
                            <input type="number" name="hiredMonth" value="<%= json.get("hiredMonth") %>" required>月
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">任職本校年資</td>
                        <td>
                            <input type="number" name="year" value="<%= json.get("year") %>" required>年
                            <input type="number" name="month" value="<%= json.get("month") %>" required>個月
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">中文姓名</td>
                        <td><input type="text" name="cName" value="<%= json.get("cName") %>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">英文姓名</td>
                        <td><input type="text" name="eName" value="<%= json.get("eName") %>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">職稱</td>
                        <td><input type="text" name="title" value="<%= json.get("title") %>" required></td>
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
                        <td class="metadata">最高學歷</td>
                        <td>
                            學校名稱:<input type="text" name="schoolName" value="<%= json.get("schoolName") %>" required>
                            主修學門系所:<input type="text" name="major" value="<%= json.get("major") %>" required>
                            學位:<input type="text" name="degree" value="<%= json.get("degree") %>" required><br>
                            畢業年月:<input type="number" name="graduateYear" value="<%= json.get("graduateYear") %>" required>年
                            <input type="number" name="graduateMonth" value="<%= json.get("graduateMonth") %>" required>月
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">重要經歷</td>
                        <td>
                            服務機構:<input type="text" name="ServiceOrganization" value="<%= json.get("serviceOrganization") %>" required>
                            服務部門:<input type="text" name="ServiceDepartment" value="<%= json.get("serviceDepartment") %>" required>
                            職稱:<input type="text" name="pastTitle" value="<%= json.get("pastTitle") %>" required><br>
                            起迄年月:<input type="number" name="pastYear" value="<%= json.get("pastYear") %>" required>年
                            <input type="number" name="pastMonth" value="<%= json.get("pastMonth") %>" required>月
                        </td>
                    </tr>
                    <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">申請獎勵等級及符合資格</td></tr>
                    <tr>
                        <td class="metadata">一年內曾執行科技部計畫</td>
                        <td>計畫名稱:<input type="text" name="planName" value="<%= json.get("planName") %>" required>
                        計畫編號:<input type="text" name="planNumber" value="<%= json.get("planNumber") %>" required>
                        執行期間:<input type="date" name="startTime" value="<%= json.get("startTime") %>" required>至<input type="date" name="lastTime" value="<%= json.get("lastTime") %>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">獎助資格(請檢附證明文件)</td>
                        <td>
                            <input type="checkbox" name="qualification1" id="qualification1" value="true">非曾任或非現任國內學術研究機構編制內之專任教學、研究人員。
                            <input type="checkbox" name="qualification2" id="qualification2" value="true">於正式納編前五年間均任職於國外學術研究機構。
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">申請獎勵等級及額度</td>
                        <td>
                            <select name="level" id="level">
                                <option value="prof">教授級</option>
                                <option value="ap">副教授級</option>
                                <option value="asst">助理教授級</option>
                            </select>
                            每月獎勵額度<input type="number" name="price" value="<%= json.get("price") %>" required>萬元
                        </td>
                    </tr>
                    <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">存檔</button></td></tr>
                </tbody>
            </table>
        </form>
    </div>

</body>
</html>
