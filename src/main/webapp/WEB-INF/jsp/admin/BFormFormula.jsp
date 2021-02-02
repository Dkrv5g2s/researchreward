<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/11
  Time: 上午 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% JSONObject jsonObject = (JSONObject) request.getAttribute("json");%>
<html>
<head>
    <title>B表公式修改</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
<link rel="stylesheet" type="text/css" href="/css/body.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: '/BFormFormula',
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
            <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">W1期刊排名</td></tr>
            <tr>
                <td class="metadata">Nature、Science及Cell:</td>
                <td><input type="number" name="w1_1" value="<%= jsonObject.getDouble("w1_1")%>" required>點數</td>
            </tr>
            <tr>
                <td class="metadata">R≦1%:</td>
                <td><input type="number" name="w1_2" value="<%= jsonObject.getDouble("w1_2")%>" required>點數</td>
            </tr>
            <tr>
                <td class="metadata">1%&lt;R≦5%:</td>
                <td><input type="number" name="w1_3" value="<%= jsonObject.getDouble("w1_3")%>" required>點數</td>
            </tr>
            <tr>
                <td class="metadata">5%&lt;R≦10%:</td>
                <td><input type="number" name="w1_4" value="<%= jsonObject.getDouble("w1_4")%>" required>點數</td>
            </tr>
            <tr>
                <td class="metadata">10%&lt;R≦25%:</td>
                <td><input type="number" name="w1_5" value="<%= jsonObject.getDouble("w1_5")%>" required>點數</td>
            </tr>
            <tr>
                <td class="metadata">25%&lt;R≦40%:</td>
                <td><input type="number" name="w1_6" value="<%= jsonObject.getDouble("w1_6")%>" required>點數</td>
            </tr>
            <tr>
                <td class="metadata">R>40%:</td>
                <td><input type="number" name="w1_7" value="<%= jsonObject.getDouble("w1_7")%>" required>點數</td>
            </tr>
            <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">W2作者排序</td></tr>
            <tr>
                <td class="metadata">第一作者或通訊作者:</td>
                <td><input type="number" name="w2_1" value="<%= jsonObject.getDouble("w2_1")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">第二作者:</td>
                <td><input type="number" name="w2_2" value="<%= jsonObject.getDouble("w2_2")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">第三作者:</td>
                <td><input type="number" name="w2_3" value="<%= jsonObject.getDouble("w2_3")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">第四作者:</td>
                <td><input type="number" name="w2_4" value="<%= jsonObject.getDouble("w2_4")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">第五作者:</td>
                <td><input type="number" name="w2_5" value="<%= jsonObject.getDouble("w2_5")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">Equal Contribution:</td>
                <td><input type="number" name="w2_6" value="<%= jsonObject.getDouble("w2_6")%>" required>倍率</td>
            </tr>
            <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">W3通訊作者數</td></tr>
            <tr>
                <td class="metadata">1位通訊作者:</td>
                <td><input type="number" name="w3_1" value="<%= jsonObject.getDouble("w3_1")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">2位以上:</td>
                <td><input type="number" name="w3_2" value="<%= jsonObject.getDouble("w3_2")%>" required>倍率</td>
            </tr>
            <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">W4額外加權</td></tr>
            <tr>
                <td class="metadata">企業:</td>
                <td><input type="number" name="w4_1" value="<%= jsonObject.getDouble("w4_1")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">國際學者:</td>
                <td><input type="number" name="w4_2" value="<%= jsonObject.getDouble("w4_2")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">SDG:</td>
                <td><input type="number" name="w4_3" value="<%= jsonObject.getDouble("w4_3")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">SSCI:</td>
                <td><input type="number" name="w4_4" value="<%= jsonObject.getDouble("w4_4")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">企業、國際學者:</td>
                <td><input type="number" name="w4_5" value="<%= jsonObject.getDouble("w4_5")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">企業、SDG:</td>
                <td><input type="number" name="w4_6" value="<%= jsonObject.getDouble("w4_6")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">企業、SSCI:</td>
                <td><input type="number" name="w4_7" value="<%= jsonObject.getDouble("w4_7")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">國際學者、SSCI:</td>
                <td><input type="number" name="w4_8" value="<%= jsonObject.getDouble("w4_8")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">SDG、SSCI:</td>
                <td><input type="number" name="w4_9" value="<%= jsonObject.getDouble("w4_9")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">企業、SDG、SSCI:</td>
                <td><input type="number" name="w4_10" value="<%= jsonObject.getDouble("w4_10")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">國際學者、SDG、SSCI:</td>
                <td><input type="number" name="w4_11" value="<%= jsonObject.getDouble("w4_11")%>" required>倍率</td>
            </tr>
            <tr>
                <td class="metadata">企業、國際學者、SDG、SSCI:</td>
                <td><input type="number" name="w4_12" value="<%= jsonObject.getDouble("w4_12")%>" required>倍率</td>
            </tr>
            <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">存檔</button></td></tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
