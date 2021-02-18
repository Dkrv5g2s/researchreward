<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>績優教師聘任研究人員目錄</title>
        <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            function commit(){
                $.ajax({
                    type: 'POST',
                    url: '/SendApply',
                    dataType: 'text',
                    data: "",
                    contentType: 'application/text',
                    success: function(data){
                        alert('申請成功');
                        window.location.href="/RewardList";
                    }
                });
            };
        </script>
    </head>
    <body>
    <div class="content">
        <form>
            <table>
                <tbody>
                <tr>
                    <td class="metadata">表格名稱</td>
                </tr>
                <tr>
                    <td><a href="/TeacherHireResearcherForm">績優教師聘任研究人員申請表</a></td>
                </tr>
                <tr>
                    <td><a href="/TeacherHireResearcherAppDocInstructions">審查資料(填寫說明)</a></td>
                </tr>
                <tr>
                    <td><a href="/TeacherHireResearcherTableA">近五年內發表之期刊論文統計表(表A)</a></td>
                </tr>
                <tr>
                    <td><a href="/PaperPerformanceDescriptionForm">傑出論文績效說明表(表B)</a></td>
                </tr>
                <tr>
                    <td><a href="/PaperPerformanceDescriptionUpload">傑出論文績效說明表(表B)-上傳檔案</a></td>
                </tr>
                <tr>
                    <td><a href="/PaperPerformanceDescriptionForm?table_d=1">傑出論文績效說明表(申請第二期者填寫)(表D)</a></td>
                </tr>
                <tr>
                    <td><a href="/PaperPerformanceDescriptionUpload?table_d=1">傑出論文績效說明表(申請第二期者填寫)(表D)-上傳檔案</a></td>
                </tr>
                </tbody>
            </table>
            <p style="text-align: center;">
                <input type="button" name="sendApply" value="提出申請" onclick="commit()">
                <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='/RewardList'">
            </p>
        </form>
    </div>

    </body>
</html>