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
                url: '/SecondPersonalInformation',
                dataType: 'text',
                data: JSON.stringify(InputToJson()),
                contentType: 'application/json',
                success: function(data){
                    alert('存檔成功');
                }
            });

        };

        function InputToJson(){
            var data = {};

            for (var j=0; j<document.getElementsByTagName("input").length; j++) {
                if (document.getElementsByTagName("input")[j].type=='checkbox' && document.getElementsByTagName("input")[j].checked == false){
                    data[ document.getElementsByTagName("input")[j].name] = "false";
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
            $('#qualification1').prop("checked","<%=json.get("qualification1")%>"=="true"?true:false);
            $('#qualification2').prop("checked","<%=json.get("qualification2")%>"=="true"?true:false);
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
                        <td class="metadata">受本校延攬前之工作單位/職稱</td>
                        <td>
                            <input type="text" name="pastTitle" value="<%= json.get("pastTitle") %>" required>
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">前一年度獲核定獎勵金額
                        </td>
                        <td>
                            每月新台幣<input type="text" name="pastPrice" value="<%= json.get("pastPrice") %>" required>萬元
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
                        <td class="metadata">本次申請續撥期間及每月獎勵金</td>
                        <td>
                            <select name="level" id="level">
                                <option value="second">第二年</option>
                                <option value="third">第三年</option>
                            </select>
                            每月新台幣<input type="number" name="price" value="<%= json.get("price") %>" required>萬元
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">定期考評</td>
                        <td>
                            <input type="checkbox" name="qualification1" id="qualification1" value="true">獲獎勵期間學術研究成果及貢獻
                            <input type="checkbox" name="qualification2" id="qualification2" value="true">前一年度具體執行績效
                        </td>
                    </tr>
                    <tr>
                        <td class="metadata">獲奬勵期間工作內容</td>
                        <td>
                            <input type="text" name="workContent" id="workContent" value=<%= json.get("workContent") %>>
                        </td>
                    </tr>
                    <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><span><button type="button" onclick="commit()">存檔</button></span><span><input type="button" width="10%" value="上一頁" name="close" onclick="javascript:location.href='SecondExcellentResearcherCatalog'"></span></td></tr>
                </tbody>
            </table>
        </form>
    </div>

</body>
</html>
