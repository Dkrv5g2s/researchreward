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
    <link rel="stylesheet" type="text/css" href="css/MenuStyle.css">
    <link rel="stylesheet" type="text/css" href="css/Style.css">
    <script src="js/jquery.min.js"></script>
    <script>
        $(document).ready(function (){
            if (<%=request.getAttribute("flag")%>) {
                $("li[name='a']").remove();
                $("li[name='b']").remove();
                $("li[name='c']").remove();
            } else {
                $("li[name='f']").remove();
            }
            if (<%=request.getAttribute("pendingReward")%>) {
                $("#head").append("<span style=\"font-size:12pt;font-family: 'Microsoft Tai Le'\">您有尚未審核的獎項&emsp;&emsp;</span>");
            }
            if (<%=request.getAttribute("returnedPendingReward")%>) {
                $("#head").append("<span style=\"font-size:12pt;font-family: 'Microsoft Tai Le'\">您有尚未處理的遭退件獎項</span>");
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
                <form action='Logout'  method="post">
                    <h1><input name="button" type="submit" id="button" value="Logout"></h1>
                </form>
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
                    <li class='top' name="a"><a href='SpecialOutstandingResearcherSetting' class='top_link' target="iframe"><span class='down'>特殊優秀研究人才申請表年度設定</span></a></li>
                    <li class='top' name="b"><a href='RewardTableAAnnualIntervalSetting' class='top_link' target="iframe"><span class='down'>各獎項期刊論文統計表申請表年度設定</span></a></li>
                    <li class='top' name="b"><a href='AwardTimeLimit' class='top_link' target="iframe"><span class='down'>獎項開放申請時間</span></a></li>
                    <li class='top' name="c"><a href='BFormFormula' class='top_link' target="iframe"><span class='down'>B表公式係數修改</span></a></li>
                    <li class='top' name="d"><a href='RewardPendingList' class='top_link' target="iframe"><span class='down'>待審核獎項</span></a></li>
                    <li class='top' name="e"><a href='ApprovedRewardList' class='top_link' target="iframe"><span class='down'>已審核獎項</span></a></li>
                    <li class='top' name="f"><a href='ReturnedRewardListForAdmin' class='top_link' target="iframe"><span class='down'>遭退件獎項</span></a></li>
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
