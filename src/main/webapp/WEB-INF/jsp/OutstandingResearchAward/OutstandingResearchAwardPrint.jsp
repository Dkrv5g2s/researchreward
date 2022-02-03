
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>OutstandingResearchAwardPrint</title>
    <link rel="stylesheet" type="text/css" href="css/PrintPageStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/PrintFunction.js"></script>

</head>
<body style="text-align: center;">
<iframe class="print-page" id="page1" frameborder="0" scrolling="no"></iframe>
<iframe class="print-page" id="page2" frameborder="0" scrolling="no"></iframe>
<iframe class="print-page" id="page3" frameborder="0" scrolling="no"></iframe>
<iframe class="print-page" id="page4" frameborder="0" scrolling="no"></iframe>
<script type="text/javascript">
    $(document).ready(function () {
        setIframeSrc();
    })

    let loaded = 0;
    const iframeList = document.getElementsByTagName("iframe");
    const pageNumber = iframeList.length;
    $('#page1, #page2, #page3, #page4').on("load", function (){
        if (++loaded === pageNumber) {
            setPrint();
        }
    });

    function setIframeSrc(){
        document.getElementById("page1").src="OutstandingResearchAward";
        document.getElementById("page2").src="OutstandingResearchAwardReviewInformation";
        document.getElementById("page3").src="OutstandingResearchAwardTableA";
        document.getElementById("page4").src="OutstandingResearchAwardTableB";
    }

</script>
</body>
</html>
