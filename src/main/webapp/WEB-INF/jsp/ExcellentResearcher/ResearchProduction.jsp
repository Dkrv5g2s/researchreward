<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/12/3
  Time: 下午 01:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>研發成果智慧財產權及其應用績效</title>
    <link rel="stylesheet" type="text/css" href="/RRS/css/FormStyle.css">
    <style>
        td.metadata{
            text-align: center;
        }
        p{
            text-align:left;
            font-weight:bold;
            font-size:20px;
        }
        input{
            width: 100%;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function createResearchProduction() {
            var rowsNumber = $("tbody tr").length-1;
            var data = "<tr name=\"patent_"+rowsNumber+"\">\n" +
                "                    <td><input type=\"text\" name=\"patentClass_"+""+"\"></td>\n" +
                "                    <td><input type=\"text\" name=\"patentName_"+""+"\"></td>\n" +
                "                    <td><input type=\"text\" name=\"country_"+""+"\"></td>\n" +
                "                    <td><input type=\"text\" name=\"patentNumber_"+""+"\"></td>\n" +
                "                    <td><input type=\"text\" name=\"inventor_"+""+"\"></td>\n" +
                "                    <td><input type=\"text\" name=\"patentee_"+""+"\"></td>\n" +
                "                    <td><input type=\"text\" name=\"approvalDate_"+""+"\"></td>\n" +
                "                    <td><input type=\"text\" name=\"mstPlanNumber_"+""+"\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("tr[name=new]").before(data);
        }

        $(document).on("click", "button[name='delete']",function(){
            var thisTr = $(this).parents("tr");
            thisTr.remove();
        });

    </script>
</head>
<body>
<div class="content">
    <p>研發成果智慧財產權及其應用績效：<br>
        　1. 請將個人研發成果所產生之智慧財產權及其應用績效分為(1)專利(2)技術移轉(3)著作授權(4)其他等類別，分別填入下列表中。如欄位不足，請自行加印填寫。<br>
        　2. 填寫順序請依專利期間起始日排列，或技術移轉及著作授權之簽約日期排列。<br>
    </p>
    <form>
        <table>
            <tbody>
                <tr><td class="metadata" colspan="9">(一)專利 請填入目前仍有效之專利。「類別」請填入代碼：(A)發明專利(B)新型專利(C)新式樣專利。</td></tr>
                <tr>
                    <td class="metadata">類別</td>
                    <td class="metadata">專利名稱</td>
                    <td class="metadata">國別</td>
                    <td class="metadata">專利號碼</td>
                    <td class="metadata">發明人</td>
                    <td class="metadata">專利權人</td>
                    <td class="metadata">專利核准日期</td>
                    <td class="metadata">科技部計畫編號</td>
                    <td class="metadata">功能</td>
                </tr>
                <tr name="new"><td colspan="9" style="text-align: center"><button type="button" onclick="createResearchProduction()">新增</button></td></tr>
                <tr><td class="metadata" colspan="9">(一)專利 請填入目前仍有效之專利。「類別」請填入代碼：(A)發明專利(B)新型專利(C)新式樣專利。</td></tr>
                <tr>
                    <td class="metadata">類別</td>
                    <td class="metadata">專利名稱</td>
                    <td class="metadata">國別</td>
                    <td class="metadata">專利號碼</td>
                    <td class="metadata">發明人</td>
                    <td class="metadata">專利權人</td>
                    <td class="metadata">專利核准日期</td>
                    <td class="metadata">科技部計畫編號</td>
                    <td class="metadata">功能</td>
                </tr>
                <tr name="new"><td colspan="9" style="text-align: center"><button type="button" onclick="createResearchProduction()">新增</button></td></tr>
                <tr><td class="metadata" colspan="9">(一)專利 請填入目前仍有效之專利。「類別」請填入代碼：(A)發明專利(B)新型專利(C)新式樣專利。</td></tr>
                <tr>
                    <td class="metadata">類別</td>
                    <td class="metadata">專利名稱</td>
                    <td class="metadata">國別</td>
                    <td class="metadata">專利號碼</td>
                    <td class="metadata">發明人</td>
                    <td class="metadata">專利權人</td>
                    <td class="metadata">專利核准日期</td>
                    <td class="metadata">科技部計畫編號</td>
                    <td class="metadata">功能</td>
                </tr>
                <tr name="new"><td colspan="9" style="text-align: center"><button type="button" onclick="createResearchProduction()">新增</button></td></tr>
            </tbody>
        </table>
    </form>
</div>

</body>
</html>
