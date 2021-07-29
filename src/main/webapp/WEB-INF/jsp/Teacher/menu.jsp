<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2021/1/19
  Time: 下午 02:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>研發獎勵系統</title>
    <link rel="stylesheet" type="text/css" href="/css/MenuStyle.css">
    <link rel="stylesheet" type="text/css" href="/css/Style.css">
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
            <div id="logo" style="float: left;">
                <h1><span>研發獎勵系統</span></h1>
            </div>
        </div>
        <div id="logout">
            <h3>
                <form action='logout'  method="post" style="overflow: hidden">
                    <input style="float: right; clear: both; " name="button" type="submit" id="button" value="登出">
                </form>
            </h3>
        </div>
        <div id="menuline">
            <div style="width:100%;background-color:red;">
                <span class="preload1"></span>
                <span class="preload2"></span>
                <ul id="nav">
                    <li class='top'><a class='top_link' href="/SelectReward" target="iframe"><span class='down'>選擇申請獎項</span></a></li>
                    <li class='top'><a class='top_link' href="/RewardList" target="iframe"><span class='down'>修改申請獎項</span></a></li>
                    <li class='top'><a class='top_link'  href="/TraceProgress" target="iframe"><span class='down'>申請進度追蹤</span></a></li>
                    <li class='top'><a class='top_link'  href="/ReturnedRewardList" target="iframe"><span class='down'>查看退件獎項</span></a></li>
<%--                    <li class='top'><a class='top_link'   target="iframe"><span class='down'><span class='down'>登出</span></a></li>--%>
                </ul>
            </div>

            <br style="clear: left" />



            <div id="page" >
                <div id="content">
                    <div class="main_func">
                        <!-- frameborder=0 means hide border;scrolling=no means the embedded web will not shot scroll bar -->
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
