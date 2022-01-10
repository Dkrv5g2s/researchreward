<%--
  Created by IntelliJ IDEA.
  User: Sandy
  Date: 2021/2/19
  Time: 下午 04:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>退件原因</title>
        <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <style type="text/css">
            .footer{
                text-align: center;
                margin: 1rem;
            }
        </style>
    </head>

    <body>
        <div class="content">
            <h2 style="text-align: center;"><%=request.getAttribute("reward_type")%></h2>
            <label for="reason_for_return">請輸入退件原因</label>
            <div style="float:right;">目前輸入字數:<span id="nowWords">0</span>/500</div>
            <textarea id="reason_for_return" maxlength="500" type="text" onkeyup="wordsTotal()" style="height:200px;"></textarea>
            <div class="footer">
                <button type="button" name="return_last_page" onclick="returnCatalog()">返回上頁</button>
                <button type="button" name="confirm" onclick="commit()">送出退件</button>
            </div>
        </div>
    </body>
    <script>
        function wordsTotal() {
            const total = document.getElementById('reason_for_return').value.length;
            document.getElementById('nowWords').innerHTML = total;
        }
        function returnCatalog(){
            $.ajax({
                type: 'POST',
                url: '/RewardList',
                dataType: 'json',
                data: JSON.stringify({
                    projectId: "<%=request.getSession().getAttribute("projectId")%>",
                    rewardName: "<%=request.getAttribute("reward_type")%>"
                }),
                contentType: 'application/json',
                complete:function(XMLHttpRequest,textStatus){
                    let newDoc = document.open("text/html", "replace");
                    newDoc.write(XMLHttpRequest.responseText);
                    newDoc.close();
                }
            });
        };
        function commit(){
            let yes = confirm('確定要送出退件嗎?');
            if (!yes) {
                return;
            }
            const projectId = <%=request.getSession().getAttribute("projectId")%>;
            const reason_for_return = $("#reason_for_return").val();
            $.ajax({
                type: 'POST',
                url: '/ReasonForReturn',
                dataType: 'text',
                data: JSON.stringify({
                    projectId: projectId,
                    reason_for_return: reason_for_return
                }),
                contentType: 'application/json',
                success: function(){
                    alert('退件成功');
                    window.location.href="ApprovedRewardList";
                },
                error:function() {
                    alert("退件失敗");
                }
            });
        };
    </script>
</html>