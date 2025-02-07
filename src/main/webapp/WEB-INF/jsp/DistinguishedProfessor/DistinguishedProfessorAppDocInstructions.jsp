<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONArray" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	JSONArray json = (JSONArray) request.getAttribute("json");
%>
<html>
<head>
    <title>國立臺北科技大學特聘教授申請表審查資料【填寫說明】</title>
    <script src="js/Function.js"></script>
    <script src="js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
    <link rel="stylesheet" type="text/css" href="css/PrintPageStyle.css">
    <style>
        body {
            margin: 20px 0px 0px 0px;
            padding: 0;
            font-size: 20px;
            font: normal 16px Verdana;
            width: 100%;
        }
        table {
            color: black;
            width: 100%;
            border-width: thin;
            border-spacing: 0px;
            border-style: groove;
            border-color: gray;
            border-collapse: collapse;
            background-color: white;
            font: normal 13px Verdana;
        }
        table td{
            border-width: 1px;
            padding: 8px;
            border-style: groove;
            border-color: gray;
            -moz-border-radius: 0px 0px 0px 0px;
            height: 20px;
            vertical-align: middle;
        }
        .footer{
            display: none;
            text-align-last: center;
            margin: 1rem;
        }

    </style>
    <script>
        function create() {
            var data = "<tr name=\"technologyTransfer\">\n" +
                "                    <td colspan=\"1\" width=\"18%\"><input type=\"text\" name=\"technologyTransferContractName\"></td>\n" +
                "                    <td colspan=\"1\" width=\"18%\"><input type=\"text\" name=\"technologyTransferDepartment\"></td>\n" +
                "                    <td colspan=\"1\" width=\"18%\"><input type=\"date\" name=\"contractDate\"></td>\n" +
                "                    <td colspan=\"1\" width=\"18%\"><input type=\"text\" name=\"technologyTransferFund\"></td>\n" +
                "                    <td colspan=\"1\" width=\"18%\"><input type=\"date\" name=\"technologyTransferFundBringInDate\"></td>\n" +
                "                    <td colspan=\"1\" width=\"10%\"><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
                "                </tr>";
            $("div[name='technologyTransfer'] tr[name=add]").before(data);
        }
        
        $(document).on("click", "button[name='delete']",function(){
            var thisTr = $(this).parents("tr");
            thisTr.remove();
        });
        
        function commit(){
            var table = tableToJson($('form').find("table")[1]);

        	$.ajax({
                type: 'POST',
                url: 'DistinguishedProfessorAppDocInstructions',
                dataType: 'text',
                data: JSON.stringify(table),
                contentType: 'application/json',
                success: function(data){
                    alert('存檔成功');
                }
            });

        };

        function tableToJson(table){
            var data = [];

            // first row needs to be headers
            var headers = [];
            for (var i=0; i<table.rows[0].cells.length-1; i++) {
                headers[i] = table.rows[0].cells[i].getAttribute("name");
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
        <%
	        JSONArray jsonArray = (JSONArray)json.get(0);
	        for(Object object: jsonArray){
	            JSONObject jsonObject = (JSONObject)object;
	
	    %>
	    <script>
	        $(document).ready(function () {
	
	            var data = "<tr name=\"technologyTransfer\">\n" +
	                "                    <td colspan=\"1\" width=\"18%\"><input type=\"text\" name=\"technologyTransferContractName\" value=\"<%=jsonObject.get("technologyTransferContractName")%>\"></td>\n" +
	                "                    <td colspan=\"1\" width=\"18%\"><input type=\"text\" name=\"technologyTransferDepartment\" value=<%=jsonObject.get("technologyTransferDepartment")%>></td>\n" +
	                "                    <td colspan=\"1\" width=\"18%\"><input type=\"date\" name=\"contractDate\" value=<%=jsonObject.get("contractDate")%>></td>\n" +
	                "                    <td colspan=\"1\" width=\"18%\"><input type=\"text\" name=\"technologyTransferFund\" value=<%=jsonObject.get("technologyTransferFund")%>></td>\n" +
	                "                    <td colspan=\"1\" width=\"18%\"><input type=\"date\" name=\"technologyTransferFundBringInDate\" value=<%=jsonObject.get("technologyTransferFundBringInDate")%>></td>\n" +
	                "                    <td colspan=\"1\" width=\"10%\"><button type=\"button\" name=\"delete\">刪除</button></td>\n" +
	                "                </tr>";
	            $("table[name='technologyTransfer'] tr[name=add]").before(data);
	        })
        </script>
        <%
	        }		        
	    %>
	    <script>
		    $(document).ready(function (){
	            setReadOnly(<%=request.getAttribute("readonly")%>);
	            const role = "${role}";
                if(role === "teacher"){
                    $("#apply_footer").show();
                    $("#review_footer").remove();
                }
                else{
                    $("#review_footer").show();
                    $("#apply_footer").remove();
                }
	        })
	    </script>
</head>
<body>
    <div name="technologyTransfer" class="content">
        <form id="form">
            <p class="file_title">審查資料【填寫說明】</p>
            <table>
                <tbody>
                    <tr>
                        <td>一、 每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書(共同著作授權同意書)。</td>
                    </tr>
                    <tr>                  
                        <td>二、 學術論著採計Scopus / WOS論文以本校「教師評鑑及基本資料庫」登錄為準，請檢附<a style="font-weight:bold">表B「傑出論文績效說明表」</a>。並請檢附下列證明文件：
                        	<br>(一) 期刊發表之論文首頁或以Scopus / WOS資料庫或SciVal分析系統之佐證。
                        	<br>(二)	各篇期刊排名(以發表當年度為主) CiteScore / Journal Ranking、國際學者、企業、SDG之佐證。
                        	<br>(三)	SciVal分析系統之教師近五年FWCI或h-5指數。
                        </td>
                    </tr>
                    <tr>
                        <td>三、 教育部補助大學在地實踐社會責任計畫，請以教評系統為準提供相關佐證資料。計畫年度(1/1~12/31)之認定以「計畫開始日期」為準；計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；多年期計畫分年計算單一年度執行金額。</td>
                    </tr>
                    <tr>
                        <td>四、 科技部計畫(不包含科技部產學合作計畫)請以教評系統為準提供相關佐證資料。計畫年度(1/1~12/31)之認定以「計畫開始日期」為準；計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；多年期計畫分年計算單一年度執行金額。</td>
                    </tr>
                    <tr>
                        <td>五、 產學合作計畫(包含科技部產學合作計畫、政府機關及財團法人之研究型專案計畫；不含以學校名義開授訓練課程招生收入) 請以教評系統為準提供相關佐證資料。計畫年度(1/1~12/31)之認定以「計畫開始日期」為準；計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；多年期計畫分年計算單一年度執行金額。</td>
                    </tr>
                    <tr>
                        <td>六、 技術移轉金(包含專利技術移轉金、著作權技術移轉金及知識性技術移轉金；不包含科技部先期技術移轉授權金)請填列近五年以本校名義所獲得之實收技術移轉金資料(如下表) ，並洽產學合作處技術移轉組確認核章後提出申請。技術移轉金計算以「實際納入校務基金日期」為準。</td>
                    </tr>
                </tbody>
            </table>
            <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;display: none;" class="inputForm" name="technologyTransfer">
		        <tbody style="text-align: center;">
		            <tr>
		                <td colspan="1" width="18%" name="technologyTransferContractName">技轉合約名稱</td>
		                <td colspan="1" width="18%" name="technologyTransferDepartment">技轉單位(企業)</td>
		                <td colspan="1" width="18%" name="contractDate">簽約日期</td>
		                <td colspan="1" width="18%" name="technologyTransferFund">實收技術移轉金金額</td>
		                <td colspan="1" width="18%" name="technologyTransferFundBringInDate">技轉金實際納入校務基金日期</td>
		                <td colspan="1" width="10%"></td>
		            </tr>
		            
		            <tr name="add">
		                <td colspan="6" width="100%"><button type="button" onclick="create()">新增</button></td>
		            </tr>
		        </tbody>
		    </table>
		    <table>
		    	<tbody>
		    		<tr>
                        <td>七、 <a style="font-weight:bold">各項計畫類總金額統計(不含因行政職務而擔任主持人部分)。</a></td>
                    </tr>
                    <tr>
                        <td>八、 以本辦法第三條第六款：曾獲本校「傑出教學獎」2次者，檢附得獎證明。</td>
                    </tr>
                    <tr>
                        <td>九、 <a style="font-weight:bold">無論以第三條之任一款基本條件申請者，A、B表各項資料均須填寫。</a></td>
                    </tr>
                </tbody>
            </table>
            <p id="apply_footer" class="footer">
                <button type="button" name="return_last_page" onclick="location.href='DistinguishedProfessorCatalog'">回上頁</button>
<%--                <button type="button" onclick="commit()">暫存</button>--%>
            </p>
            <p id="review_footer" class="footer">
                <input type="button" name="go_to_catalog" class="review" value="回目錄" onclick="location.href='DistinguishedProfessorCatalog'" />
                <input type="button" class="review" value="此頁審查完成" onclick="location.href='DistinguishedProfessorTableA'" />
            </p>
        </form>
    </div>

</body>
</html>
