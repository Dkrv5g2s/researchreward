<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2021/1/22
  Time: 下午 01:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Boolean readonly = (Boolean) request.getAttribute("readonly");%>
<html>
<head>
    <title>目錄</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $(".review").hide();
            $(".edit").hide();
            if(${readonly}){
                $(".review").show();
            }
            else{
                $(".edit").show();
            }
        })
        function sendApply(){
            if (confirm("確定要送出申請?")) {
                $.ajax({
                    type: 'POST',
                    url: '/SendApply',
                    dataType: 'text',
                    data: "",
                    contentType: 'application/text',
                    success: function (data) {
                        alert('申請成功');
                        window.location.href = "/TraceProgress";
                    }
                });
            }
        };

        function approveApply(){
            if (confirm("確定要確認審理?")) {
                $.ajax({
                    type: 'POST',
                    url: '/ApproveApply',
                    dataType: 'text',
                    data: "",
                    contentType: 'application/text',
                    success: function (data) {
                        alert('確認審理成功');
                        window.location.href = "/ApprovedRewardList";
                    }
                });
            }
        };

        function rejectApply(){
            if (confirm("確定要退件?"))
                window.location.href="/ReasonForReturn";
        };
    </script>
</head>
<body>
    <div class="content">
        <table>
            <tbody>
                <tr>
                    <td class="metadata">表格名稱</td>
                </tr>
                <tr>
                    <td><a href="/PersonalInformation">基本資料&申請獎勵等級及符合資格</a></td>
                </tr>
                <tr>
                    <td><a href="/RecruitDescription">延攬內容說明&延攬特殊優秀人才之傑出研究表現說明</a></td>
                </tr>
                <tr>
                    <td><a href="/CatalogOfWorks">著作目錄</a></td>
                </tr>
                <tr>
                    <td><a href="/ResearchProduction">研發成果智慧財產權及其應用績效</a></td>
                </tr>
            </tbody>
        </table>
        <div style="margin: 1rem;" class="edit">
            <button type="button" name="return_last_page" onclick="location.href='RewardList'">回上頁</button>
            <button type="button" name="send_application" onclick="sendApply()">提出申請</button>
        </div>
        <div style="margin: 1rem;" class="review">
            <button type="button" name="return_last_page" onclick="rejectApply()">退件</button>
            <button type="button" name="confirm" onclick="approveApply()">審查完成</button>
        </div>
    </div>

</body>
</html>
