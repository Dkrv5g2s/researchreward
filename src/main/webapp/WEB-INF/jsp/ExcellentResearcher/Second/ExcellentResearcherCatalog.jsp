<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2021/1/22
  Time: 下午 01:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>目錄</title>
    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/js/Function.js"></script>
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
                        window.open('SecondExcellentResearcherPrint', 'TheWindow');
                    },
                    error: function(jqXHR, textStatus, message) {
                        //error handling
                        alert(jqXHR.responseText);
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
                        window.open('SecondExcellentResearcherPrint', 'TheWindow');
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
        <h2>(續撥)獎勵新聘特殊優秀研究人才</h2>
        <table>
            <tbody>
                <tr>
                    <td class="metadata">表格名稱</td>
                </tr>
                <tr>
                    <td><a href="/SecondPersonalInformation">基本資料&申請獎勵等級及符合資格</a></td>
                </tr>
                <tr>
                    <td><a href="/SecondExecutedPerformance">前一年度具體執行績效</a></td>
                </tr>
                <tr>
                    <td><a href="/SecondResearchProduction">獲獎勵期間學術研究成果及貢獻</a></td>
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
