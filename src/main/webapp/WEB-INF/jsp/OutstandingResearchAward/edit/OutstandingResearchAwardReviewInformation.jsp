<%--
  Created by IntelliJ IDEA.
  User: Ted Lin
  Date: 2021/2/2
  Time: 上午 10:53
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONArray" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONArray json = (JSONArray) request.getAttribute("data");
%>
<html lang="zh">
<head>
    <title>傑出研究獎 審查資料</title>

    <link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style type="text/css">
        table{
            table-layout: fixed;
        }
        tr{
            text-align:center;
        }
        td{
            font-size:20px;
            text-align:center;
        }
        input {
            height: 100%;
            width: 100%;
            /*border-style: initial;*/
        }
        th{
            background-color:rgb(255, 255, 240);
            border-style: solid;
            border-width: thin;
        }
        h2 {
            font-weight: bold;
            text-align: center;
            margin-bottom: 2rem;
        }
        .footer{
            text-align-last: center;
            margin: 1rem;
        }
    </style>

    <%
        JSONArray jsonArray = (JSONArray)json.get(0);
        for(Object object: jsonArray){
            JSONObject jsonObject = (JSONObject)object;
    %>
    <script>
        $(document).ready(function () {
            let data = "<tr name=\"technologyTransfer\">\n" +
                "                    <td><input type=\"text\" name=\"technologyTransferContractName\" value=\"<%=jsonObject.get("technologyTransferContractName")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"technologyTransferDepartment\" value=\"<%=jsonObject.get("technologyTransferDepartment")%>\"></td>\n" +
                "                    <td><input type=\"date\" name=\"contractDate\" value=\"<%=jsonObject.get("contractDate")%>\"></td>\n" +
                "                    <td><input type=\"text\" name=\"technologyTransferFund\" value=\"<%=jsonObject.get("technologyTransferFund")%>\"></td>\n" +
                "                    <td><input type=\"date\" name=\"technologyTransferFundBringInDate\" value=\"<%=jsonObject.get("technologyTransferFundBringInDate")%>\"></td>\n" +
                "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='technologyTransfer'] tr[name=add]").before(data);
        })
    </script>
    <%
        }
    %>
</head>
<body>
<div name="technologyTransfer" class="content">
    <h2>傑出研究獎 ※審查資料【填寫說明】</h2>
    <p>一、 每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書(共同著作授權同意書)。<p>
    <p>二、 學術論著採計Scopus/WOS論文者，請檢附表B「傑出論文績效說明表」。並請檢附證明文件<strong>「期刊發表之論文首頁或以Scopus/WOS資料庫或scival分析系統之佐證」及「各篇期刊排名(以發表當年度為主) CiteScore/Journal Ranking、國際學者、企業、FWCI)」</strong>。</p>
    <p>三、科技部計畫(不包含科技部產學合作計畫)請以教評系統為準提供相關佐證資料。計畫年度(1/1~12/31)之認定以「計畫開始日期」為準；計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；多年期計畫分年計算單一年度執行金額。</p>
    <p>四、產學合作計畫(包含科技部產學合作計畫、政府機關及財團法人之研究型專案計畫；不含以學校名義開授訓練課程招生收入) 請以教評系統為準提供相關佐證資料。計畫年度(1/1~12/31)之認定以「計畫開始日期」為準；計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；多年期計畫分年計算單一年度執行金額。</p>
    <p>五、技術移轉金(包含專利技術移轉金、著作權技術移轉金及知識性技術移轉金；不包含科技部先期技術移轉授權金)請填列近五年以本校名義所獲得之實收技術移轉金資料(如下表) ，並洽產學合作處技術移轉組確認核章後提出申請。技術移轉金計算以「實際納入校務基金日期」為準。</p>
    <form method="post" id="c001_form">
        <table id="technologyTransfer">
            <thead>
            <th width="18%"><lable name="technologyTransferContractName">技轉合約名稱</lable></th>
            <th width="18%"><lable name="technologyTransferDepartment">技轉單位(企業)</lable></th>
            <th width="18%"><lable name="contractDate">簽約日期</lable></th>
            <th width="18%"><lable name="technologyTransferFund">實收技術移轉金金額</lable></th>
            <th width="18%"><lable name="technologyTransferFundBringInDate">技轉金實際納入校務基金日期</lable></th>
            <th width="10%"></th>
            </thead>
            <tbody style="text-align: center;">
            <tr name="add">
                <td colspan="6"><button type="button" class="btn btn-success btn-sm" onclick="create()">新增</button></td>
            </tr>
            </tbody>
        </table>
        <div class="footer">
            <button type="button" name="return_last_page" onclick="javascript:location.href='OutstandingResearchAwardCatalog'">回上頁</button>
            <button type="button" name="confirm" onclick="commit()">存檔</button>
        </div>
    </form>
</div>
</body>
<script>
    function create() {
        var data = "<tr name=\"technologyTransfer\">\n" +
            "                    <td><input type=\"text\" name=\"technologyTransferContractName\"></td>\n" +
            "                    <td><input type=\"text\" name=\"technologyTransferDepartment\"></td>\n" +
            "                    <td><input type=\"date\" name=\"contractDate\"></td>\n" +
            "                    <td><input type=\"text\" name=\"technologyTransferFund\"></td>\n" +
            "                    <td><input type=\"date\" name=\"technologyTransferFundBringInDate\"></td>\n" +
            "                    <td><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
            "                </tr>";
        $("div[name='technologyTransfer'] tr[name=add]").before(data);
    }

    $(document).on("click", "button[name='delete']",function(){
        var thisTr = $(this).parents("tr");
        thisTr.remove();
    });

    function commit(){
        var table = tableToJson(document.getElementById("technologyTransfer"));
        $.ajax({
            type: 'POST',
            url: 'OutstandingResearchAwardReviewInformation',
            dataType: 'text',
            data: JSON.stringify(table),
            contentType: 'application/json',
            success: function(data){
                alert('存檔成功');
                window.location.href="OutstandingResearchAwardReviewInformation";
            },
            error:function(data) {
                alert("存檔失敗");
            }
        });
    };

    function tableToJson(table){
        var data = [];
        // first row needs to be headers
        var elements = table.getElementsByTagName("lable");
        var headers = [];
        for (var i=0; i<elements.length; i++) {
            headers[i] = elements.item(i).getAttribute("name");
        }
        // go through cells
        for (var i=1; i<table.rows.length-1; i++) {
            var tableRow = table.rows[i];
            var rowData = {};
            for (var j=0; j<tableRow.cells.length-1; j++) {
                rowData[ headers[j] ] = tableRow.cells[j].getElementsByTagName("input")[0].value;
            }
            data.push(rowData);
        }
        return data;
    }
</script>
</html>
