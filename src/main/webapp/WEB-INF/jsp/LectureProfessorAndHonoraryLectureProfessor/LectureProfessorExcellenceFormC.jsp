<%--
  Created by IntelliJ IDEA.
  User: CUser
  Date: 2021/2/8
  Time: 上午 07:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");
%>
<html>
<head>
    <title>傑出研究表現說明及申請機構推薦理由</title>
    <style>
        body {
            margin: 20px 0px 0px 0px;
            padding: 0;
            /*background: #FFFFCC;*/
            font-size: 20px;
            color: #3C3D3F;
            /*background-color: #E9F2FF;*/
            font: normal 16px Verdana;
            width: 100%;
        }
        table {
            color: black;
            width: 100%;
            border-width: thin;
            border-spacing: 0px;
            border-style: groove;
            border-color: gray;
            border-collapse: collapse;
            background-color: white;
            font: normal 13px Verdana;
        }
        table td{
            border-width: 1px;
            padding: 8px;
            border-style: groove;
            border-color: gray;
            -moz-border-radius: 0px 0px 0px 0px;
            height: 20px;
            vertical-align: middle;
        }
        table td.metadata{
            /*width: 150px;*/
            background-color: rgb(255, 255, 240);
            text-align: right;
        }
        table td.cb{
            /*width: 1%;*/
        }
        table td.checkboxcontent{
            /*width: 500px;*/
            background-color: rgb(255, 255, 240);
            text-align: left;
        }
        div.content{
            margin: 0 auto;
            padding: 50px;
            /*width: 1200px;*/
            background-color: white;
        }

    </style>
    <script src="lib/jquery.min.js"></script>
    <script>
        function commit(){
            $.ajax({
                type: 'POST',
                url: 'LectureProfessorExcellenceFormC',
                dataType: 'text',
                data: JSON.stringify(InputToJson()),
                contentType: 'application/json',
                success: function(data){
                    alert('存檔成功');
                    window.location.href="LectureProfessorExcellenceFormC";
                },
                error:function() {
                    alert("存檔失敗");
                }
            });

        };

        function InputToJson(){
            var data = {};
            let dataNumber = 0;
            data[ document.getElementsByTagName("textarea")[0].name] = document.getElementsByTagName("textarea")[0].value;
            data["fill_rate"] = $('textarea[name="recommendationReason"]').val().length > 0 ? 1 : 0;
            return data;
        }
    </script>
</head>

<body>
<div class="content">
    <form>
        <p>傑出研究表現說明及申請機構推薦理由</p>
        <table>
            <tbody>
            <tr>
                <td class="metadata">員工編號</td>
                <td><input type="text" name="usernum" disabled="disabled" value=<%=json.get("usernum")%> ></td>
            </tr>
            <tr>
            <tr>
                <td class="metadata">傑出研究表現說明</td>
                <td><label>請就下列各點分項敘明並檢附證明文件：<br>
                    一、	被推薦人選之學經歷。<br>
                    二、	完整論著目錄、重要論著抽印本。<br>
                    三、	具體學術成就證明。<br>
                    四、	具體專業技術成果證明。<br>
                    五、	其他相關之證明文件(如為本校專任教師請加附教師評鑑及基本資料庫內相關佐證資料)及教學研究計畫。<br>
                    六、	最具代表性研究成果至多10篇（請依序填寫：姓名、發表年份、著作名稱、期刊、卷數、頁數、IF及被引用次數<br>
                            (不含自我引用次數，請檢附證明文件以Scopus資料庫為主，並以＊註記該篇所有之通訊作者）。<br>
                    七、	請簡述上述代表性研究成果內個人之重要貢獻。
                </label></td>
            </tr>
            <tr>
                <td style="height:600px;">申請機構推薦理由</td>
                <td><textarea style="width:100%; height:100%;" name ="recommendationReason" required maxlength="2000" placeholder="申請機構推薦理由填寫於此" style="height:100%"><%=json.get("recommendationReason")%></textarea></td>
            </tr>

            </tbody>
        </table>

        <p style="text-align: center;">
            <button type="button" name="return_last_page" onclick="location.href='LectureProfessorCatalog'">回上頁</button>
            <button type="button" name="save" onclick="commit()" >暫存</button>
        </p>
    </form>
</div>

</body>
</html>

