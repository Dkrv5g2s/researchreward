<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/1
  Time: 上午 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>申請表額外文件</title>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: '/CatalogOfWorks',
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
            <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)">著作目錄</td></tr>
            <tr>
                <td class="metadata">請詳列個人申請截止日前5年內(此段期間曾生產或請育嬰假者，得延長至7年。7年內，曾服國民義務役者，得依實際服役時間予以延長，但應檢附相關證明文件)發表之學術性著作，包括：期刊論文、專書及專書論文、研討會論文、技術報告及其他等，並請依各類著作之重要性自行排列先後順序。</td>
                <td>
                    <textarea type="text" required maxlength="1000" name="work"></textarea>
                </td>
            </tr>
            <tr><td colspan="2" style="text-align: center; background-color: rgb(255, 255, 240)"><button type="button" onclick="commit()">存檔</button></td></tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
