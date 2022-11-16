<%--
  Created by IntelliJ IDEA.
  User: Sandy
  Date: 2021/8/18
  Time: 下午 01:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>TeacherHireResearcherPrint</title>
    <link rel="stylesheet" type="text/css" href="css/PrintPageStyle.css">
    <script src="lib/jquery.min.js"></script>
    <script src="js/PrintFunction.js"></script>

</head>
<body style="text-align: center;">
<iframe class="print-page" id="page1" frameborder="0" scrolling="no"></iframe><div class="page-break-before"></div>
<iframe class="print-page" id="page2" frameborder="0" scrolling="no"></iframe><div class="page-break-before"></div>
<iframe class="print-page" id="page3" frameborder="0" scrolling="no"></iframe><div class="page-break-before"></div>
<iframe class="print-page" id="page4" frameborder="0" scrolling="no"></iframe><div class="page-break-before"></div>
<iframe class="print-page" id="page5" frameborder="0" scrolling="no"></iframe>

<script type="text/javascript">
    $(document).ready(function () {
        setIframeSrc();
    })

    let loaded = 0;
    const iframeList = document.getElementsByTagName("iframe");
    const pageNumber = iframeList.length;
    $('#page1, #page2, #page3, #page4, #page5').on("load", function (){
        if (++loaded === pageNumber) {
            setPrint();
        }
    });

    function setIframeSrc(){
        document.getElementById("page1").src="TeacherHireResearcherForm";
        document.getElementById("page2").src="TeacherHireResearcherAppDocInstructions";
        document.getElementById("page3").src="TeacherHireResearcherTableA";
        document.getElementById("page4").src="PaperPerformanceDescriptionForm";
        document.getElementById("page5").src="PaperPerformanceDescriptionForm?table_c=1";
    }

</script>
</body>
</html>
