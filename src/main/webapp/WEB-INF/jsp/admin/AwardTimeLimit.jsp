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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
                        <td><input type="date" name="s1" required>至<input type="date" name="l1" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">講座教授/榮譽講座教授</td>
                        <td><input type="date" name="s2" required>至<input type="date" name="l2" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">特聘教授</td>
                        <td><input type="date" name="s3" required>至<input type="date" name="l3" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">傑出研究獎</td>
                        <td><input type="date" name="s4" required>至<input type="date" name="l4" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">年輕學者獎</td>
                        <td><input type="date" name="s5" required>至<input type="date" name="l5" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">獎勵特殊優秀研究人才</td>
                        <td><input type="date" name="s6" required>至<input type="date" name="l6" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">獎勵新聘特殊優秀研究人才</td>
                        <td><input type="date" name="s7" required>至<input type="date" name="l7" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">陽光獎助金論文獎勵</td>
                        <td><input type="date" name="s8" required>至<input type="date" name="l8" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">本校近5年FWCI值</td>
                        <td><input type="number" name="fwci" required></td>
                    </tr>
                    <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">存檔</button></td></tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>
