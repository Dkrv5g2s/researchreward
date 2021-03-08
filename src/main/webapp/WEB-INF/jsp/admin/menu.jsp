<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2021/1/17
  Time: 下午 08:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>研發獎勵系統</title>
    <link rel="stylesheet" type="text/css" href="/css/MenuStyle.css">
    <link rel="stylesheet" type="text/css" href="/css/Style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function (){
            if(<%=request.getAttribute("flag")%>) {
                $("li[name='a']").remove();
                $("li[name='b']").remove();
            }
            if(<%=request.getAttribute("pendingReward")%>){
                $("#head").append("<span style=\"font-size:12pt;font-family: 'Microsoft Tai Le'\">您有尚未審核的獎項</span>");
            }
        })
    </script>
    <style>
        body {
            background-color:#E9F2FF;
        }
    </style>
</head>

<body>
<div id="wrapper" class="realBox">
    <div id="header-wrapper" >
        <div id="header">
            <div id="logo">
                <h1 id = "head"><span style="padding-right: 10%">研發獎勵系統</span></h1>
            </div>
        </div>
        <div id="menuline">
            <div style="width:100%;background-color:red;">
                <span class="preload1"></span>
                <span class="preload2"></span>
                <ul id="nav">
                    <li class='top' name="a"><a href='AwardTimeLimit' class='top_link' target="iframe"><span class='down'>獎項開放時間</span></a></li>
                    <li class='top' name="b"><a href='BFormFormula' class='top_link' target="iframe"><span class='down'>B表公式係數修改</span></a></li>
                    <li class='top' name="c"><a href='RewardPendingList' class='top_link' target="iframe"><span class='down'>待審核獎項</span></a></li>
                    <li class='top' name="d"><a href='ApprovedRewardList' class='top_link' target="iframe"><span class='down'>已審核獎項</span></a></li>
                </ul>
            </div>

            <br style="clear: left" />



            <div id="page" >
                <div id="content">
                    <div class="main_func">
                        <iframe src="" name="iframe" id="iframe" frameborder="0" scrolling="no" style="width: 100%;" onload="this.height=100"></iframe>
                    </div>
                </div>
                <!-- end #content -->
            </div>

        </div><!-- end #menuline -->

    </div><!-- end #header-wrapperr -->






    <br style="clear: left" />
</div>
<div id="footer">
</div>
<!-- end #footer -->



</body>
<script type="text/javascript">
    function reinitIframe(){
        var iframe = document.getElementById("iframe");
        try{
            var bHeight = iframe.contentWindow.document.body.scrollHeight;
            var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
            var height = Math.max(bHeight, dHeight);
            iframe.height = height;
        }catch (ex){}
    }
    window.setInterval("reinitIframe()", 200);
</script>
</html>
