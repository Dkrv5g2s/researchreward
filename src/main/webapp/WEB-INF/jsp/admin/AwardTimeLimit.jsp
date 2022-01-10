<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/11
  Time: 上午 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% JSONObject jsonObject = (JSONObject) request.getAttribute("json");%>
<html>
<head>
    <title>各獎項開放申請時間</title>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
<link rel="stylesheet" type="text/css" href="css/body.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: 'AwardTimeLimit',
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

            for (var j=0; j<document.getElementsByTagName("textarea").length; j++) {

                data[ document.getElementsByTagName("textarea")[j].name] = document.getElementsByTagName("textarea")[j].value;

            }


            for (var j=0; j<document.getElementsByTagName("input").length; j++) {
                if (document.getElementsByTagName("input")[j].type=='checkbox' && document.getElementsByTagName("input")[j].checked == false){
                    continue;
                }else {
                    data[ document.getElementsByTagName("input")[j].name] = document.getElementsByTagName("input")[j].value;
                }

            }



            return data;
        }
    </script>
</head>
<body>
    <div class="content">
        <form>
            <table>
                <tbody>
                    <tr>
                        <td class="metadata">奬助研究績優教師聘任研究人員</td>
                        <td><input type="date" name="s1" value="<%= jsonObject.getDate("s1")%>" required>至<input type="date" name="l1" value="<%= jsonObject.getDate("l1")%>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">講座教授/榮譽講座教授</td>
                        <td><input type="date" name="s2" value="<%= jsonObject.getDate("s2")%>" required>至<input type="date" name="l2" value="<%= jsonObject.getDate("l2")%>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">特聘教授</td>
                        <td><input type="date" name="s3" value="<%= jsonObject.getDate("s3")%>" required>至<input type="date" name="l3" value="<%= jsonObject.getDate("l3")%>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">傑出研究獎</td>
                        <td><input type="date" name="s4" value="<%= jsonObject.getDate("s4")%>" required>至<input type="date" name="l4" value="<%= jsonObject.getDate("l4")%>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">年輕學者研究獎</td>
                        <td><input type="date" name="s5" value="<%= jsonObject.getDate("s5")%>" required>至<input type="date" name="l5" value="<%= jsonObject.getDate("l5")%>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">獎勵特殊優秀研究人才</td>
                        <td><input type="date" name="s6" value="<%= jsonObject.getDate("s6")%>" required>至<input type="date" name="l6" value="<%= jsonObject.getDate("l6")%>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">獎勵新聘特殊優秀研究人才</td>
                        <td><input type="date" name="s7" value="<%= jsonObject.getDate("s7")%>" required>至<input type="date" name="l7" value="<%= jsonObject.getDate("l7")%>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">陽光獎助金論文獎勵</td>
                        <td><input type="date" name="s8" value="<%= jsonObject.getDate("s8")%>" required>至<input type="date" name="l8" value="<%= jsonObject.getDate("l8")%>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">本校近5年FWCI值</td>
                        <td><input type="number" name="fwciOfFiveYear" value="<%= jsonObject.getDouble("fwciOfFiveYear")%>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">本校近3年FWCI值</td>
                        <td><input type="number" name="fwciOfThreeYear" value="<%= jsonObject.getDouble("fwciOfThreeYear")%>" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">h5指數</td>
                        <td><input type="number" name="h5Index" value="<%= jsonObject.getDouble("h5Index")%>" required></td>
                    </tr>
                    <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">存檔</button></td></tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>
