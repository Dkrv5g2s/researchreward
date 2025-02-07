<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% JSONObject jsonObject = (JSONObject) request.getAttribute("json");%>
<html>
<head>
    <title>特殊優秀研究人才(A類、Y類)申請表年度設定</title>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
    <link rel="stylesheet" type="text/css" href="css/body.css">
    <script src="js/jquery.min.js"></script>
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: 'SpecialOutstandingResearcherSetting',
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
                <td class="metadata">(A類)申請年度</td>
                <td>
                    <input type="number" name="year" value="<%= jsonObject.getInt("year")%>" required>
                </td>
            </tr>
            <tr>
                <td class="metadata">(A類)補助日起1年內-期間設定</td>
                <td>
                    <input type="date" name="mostStart" value="<%= jsonObject.getDate("mostStart")%>" required>至
                    <input type="date" name="mostEnd" value="<%= jsonObject.getDate("mostEnd")%>" required>
                </td>
            </tr>
            <tr>
                <td class="metadata">(A類)年資計算截止日</td>
                <td><input type="date" name="seniority" value="<%= jsonObject.getDate("seniority")%>" required></td>
            </tr>
            <tr>
                <td class="metadata">(Y類)申請年度</td>
                <td>
                    <input type="number" name="year_y" value="<%= jsonObject.getInt("year_y")%>" required>
                </td>
            </tr>
            <tr>
                <td class="metadata">(Y類)申請梯次</td>
                <td>
                    <input type="number" name="echelon_y" value="<%= jsonObject.getInt("echelon_y")%>" required>
                </td>
            </tr>
            <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">存檔</button></td></tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
