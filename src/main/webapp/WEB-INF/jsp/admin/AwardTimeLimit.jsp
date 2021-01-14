<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/11
  Time: 上午 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>各獎項開放申請時間</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: '/AwardTimeLimit',
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
                        <td class="metadata">績優教師聘任研究人員</td>
                        <td><input type="date"  required>至<input type="date"  required></td>
                    </tr>
                    <tr>
                        <td class="metadata">講座教授/榮譽講座教授</td>
                        <td><input type="date"  required>至<input type="date"  required></td>
                    </tr>
                    <tr>
                        <td class="metadata">特聘教授</td>
                        <td><input type="date"  required>至<input type="date"  required></td>
                    </tr>
                    <tr>
                        <td class="metadata">傑出研究獎</td>
                        <td><input type="date"  required>至<input type="date"  required></td>
                    </tr>
                    <tr>
                        <td class="metadata">年輕學者獎</td>
                        <td><input type="date"  required>至<input type="date"  required></td>
                    </tr>
                    <tr>
                        <td class="metadata">獎勵特殊優秀研究人才</td>
                        <td><input type="date"  required>至<input type="date"  required></td>
                    </tr>
                    <tr>
                        <td class="metadata">獎勵新聘特殊優秀研究人才</td>
                        <td><input type="date"  required>至<input type="date"  required></td>
                    </tr>
                    <tr>
                        <td class="metadata">陽光獎助金論文獎勵</td>
                        <td><input type="date"  required>至<input type="date"  required></td>
                    </tr>
                    <tr>
                        <td class="metadata">本校近5年FWCI值</td>
                        <td><input type="number" required></td>
                    </tr>
                    <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">存檔</button></td></tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>
