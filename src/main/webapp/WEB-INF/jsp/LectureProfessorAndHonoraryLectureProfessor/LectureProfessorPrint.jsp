
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>LectureProfessorAwardPrint</title>
    <link rel="stylesheet" type="text/css" href="css/PrintPageStyle.css">
    <script src="lib/jquery.min.js"></script>
    <script src="js/PrintFunction.js"></script>

</head>
<body style="text-align: center;">
<iframe class="print-page" id="page1" frameborder="0" scrolling="no"></iframe>
<iframe class="print-page" id="page2" frameborder="0" scrolling="no"></iframe>
<iframe class="print-page" id="page3" frameborder="0" scrolling="no"></iframe>
<iframe class="print-page" id="page4" frameborder="0" scrolling="no"></iframe>
<iframe class="print-page" id="page5" frameborder="0" scrolling="no"></iframe>
<iframe class="print-page" id="page6" frameborder="0" scrolling="no"></iframe>
<iframe class="print-page" id="page7" frameborder="0" scrolling="no"></iframe>
<script type="text/javascript">
    $(document).ready(function () {
        setIframeSrc();
    })

    let loaded = 0;
    const iframeList = document.getElementsByTagName("iframe");
    const pageNumber = iframeList.length;
    $('#page1, #page2, #page3, #page4 #page5 #page6 #page7').on("load", function (){
        if (++loaded === pageNumber) {
            setPrint();
        }
    });

    function setIframeSrc(){
        document.getElementById("page1").src="LectureProfessorApplicationForm";
        document.getElementById("page2").src="LectureProfessorHonoraryApplicationForm";
        document.getElementById("page3").src="LectureProfessorAppDocInstructions";
        document.getElementById("page4").src="LectureProfessorExcellenceFormA";
        document.getElementById("page5").src="LectureProfessorExcellenceFormB";
        document.getElementById("page6").src="LectureProfessorExcellenceFormC";
        document.getElementById("page7").src="LectureProfessorExcellenceFormD";
    }

</script>
</body>
</html>
