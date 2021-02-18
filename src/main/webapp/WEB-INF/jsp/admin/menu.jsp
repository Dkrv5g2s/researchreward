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
</head>

<body>
<div id="wrapper" class="realBox">
    <div id="header-wrapper" >
        <div id="header">
            <div id="logo">
                <h1><span>研發獎勵系統</span></h1>
            </div>
        </div>
        <div id="menuline">
            <div style="width:1200px;;margin: 0px auto 0px auto;background-color:red;">
                <span class="preload1"></span>
                <span class="preload2"></span>
                <ul id="nav">
                    <li class='top'><a href='AwardTimeLimit'  class='top_link' target="iframe"><span class='down'>獎項開放時間</span></a></li>
                    <li class='top'><a href='BFormFormula'  class='top_link' target="iframe"><span class='down'>B表公式係數修改</span></a></li>
                    <li class='top'><a href='RewardPendingList'  class='top_link' target="iframe"><span class='down'>待審核獎項</span></a></li>
                </ul>
            </div>

            <br style="clear: left" />



            <div id="page" >
                <div id="content">
                    <div class="main_func">
                        <iframe src="" name="iframe" id="iframe" frameborder="0" style="width: 100%;height: 100%"></iframe>
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
</html>