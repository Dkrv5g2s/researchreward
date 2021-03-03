<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page import="Utils.DateUtil" %>
<%
    int cellsNum = 5;                       // 年度橫向欄位數
    final int TSSCIPointPerArticle = 2;     // TSSCI/THCI 點數(2點/篇)
    final int artsBooksPerBooks = 6;        // 人文、設計、藝術或社會之學術專書 點數(6點/冊)
    final int artsArticlePerArticle = 2;    // 人文、設計、藝術或社會之學術專書單篇(章) 點數(2點/篇)

    //科技部計畫 點數(5點/10萬元)
    final int ministryOfTechnologyProjectPoint = 5;
    final int ministryOfTechnologyProjectMoney = 10;
    JSONObject json = (JSONObject) request.getAttribute("json");
    DateUtil dateUtil = new DateUtil();
%>

<html>
<head>
    <title>國立臺北科技大學績優教師聘任研究人員近五年內發表之期刊論文統計表(表A)</title>
    <style>
        body {
            margin: 0px 0px 0px 0px;
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
            vertical-align: text-middle;
        }
        div.content{
            margin: 0 auto;
            padding: 50px;
            width: 80%;
            background-color: white;
        }
       /* Chrome, Safari, Edge, Opera */
		input::-webkit-outer-spin-button,
		input::-webkit-inner-spin-button {
		  -webkit-appearance: none;
		  margin: 0;
		}
		
		/* Firefox */
		input[type=number] {
		  -moz-appearance: textfield;
		}
		input{
			width: 100%;
		}
		input.button {
			width: 55px;
		}
		input.date {
			width: 135px;
		}
		input.check {
			width: 10px;
		}

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="/js/Function.js"></script>
    <script>
	    function commit(){
	    	if (!$("input[name='declaration']").prop("checked")){
				alert('請勾選申請人聲明');
			}else if($("input[name='commit_date']").val()===""){
				alert('請填寫日期');
			}else{
				$.ajax({
					type: 'POST',
					url: '/TeacherHireResearcherTableA',
					dataType: 'text',
					data: JSON.stringify(InputToJson()),
					contentType: 'application/json',
					success: function(data){
						alert('存檔成功');
						window.location.href="/TeacherHireResearcherCatalog";
					}
				});
			}
	    };
	
	    function InputToJson(){
	        let data = {};
			for (let i=0; i<document.getElementsByTagName("input").length; i++) {
				let inputElem = document.getElementsByTagName("input")[i];
				if (inputElem.type==="number" || inputElem.type==="date") {
					data[inputElem.name] = inputElem.value;
				}
			}
	        data[ document.getElementsByTagName("textarea")[0].name] = document.getElementsByTagName("textarea")[0].value;
	        return data;
	    }

		$(document).ready(function(){
			$("tr").each(function(){
				$(this).find("input").each(function(){
					fillSpaceWithZero(this);
				});
				updateSubTotal($(this));
			});

			$("input").on('change paste keyup', function(){
				fillSpaceWithZero(this);
                calculatePoint($(this).parent().parent());
			});

			if($("input[name='commit_date']").val()===""){
				$("input[name='commit_date']").val("<%=dateUtil.getNowDate()%>");
			}
			setReadOnly(${readonly});
		});

		function updateSubTotal(trObj){
            let total = 0;
            //ic=篇/冊/件數 pc=點數 ip=計畫金額
			trObj.find('[class^="ic"],[class^="pc"],[class^="ip"]').each(function(){
				total += toFloat(this.value);
			});
			trObj.find('[class^="total"]').val(total);
		}

		function calculatePoint(input){
			let output = input.next();
			let multiple = toFloat(output.find('input[name="multiple"]').val());
			for(let i=0; i<<%=cellsNum%>; i++){
				let classIndexStr = (i+1).toString();
				let count = toFloat(input.find('[class="ic' + classIndexStr +'"],[class="ip' + classIndexStr +'"]').val());
				let point = count * multiple;
				output.find('.pc' + (i+1).toString()).val(point);
			}
			updateSubTotal(input);
			updateSubTotal(output);
			calculateArticleTotalPoint();
		}

		function calculateArticleTotalPoint(){
			let total = 0;
			$(".total_point").each(function(){
				total += toFloat(this.value);
			});
			$("input[name='a_plus_b_total_point']").val(total);
		}

		function toFloat(num){
			if (!(isNaN(num) || num===""))
				return parseFloat(num);
			else
				return 0;
		}

		function fillSpaceWithZero(obj){
			if($(obj).val()== "" && $(obj).attr("type")==="number"){
				$(obj).val("0");
			}
		}

    </script>
</head>
<body>
    <div class="content">
        <form>
			<p style="text-align:center;font-weight:bold;font-size:20px;">國立臺北科技大學績優教師聘任研究人員近五年內發表之期刊論文統計表(表A)</p>
            <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
		        <tbody>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">學術論著</td>
		                <td colspan="<%=cellsNum%>" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計<br>(A)</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
                        <% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%" ><input name="year<%=i+1%>" type="number" value="<%=json.get("year"+(i+1))%>" style="text-align:center; width: 75%; border:none; outline:none; background-color:transparent;" tabindex="-1" readonly></td>
                        <% } %>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="3" colspan="1" width="20%">Scopus 或 WOS 資料庫</td>
		                <td colspan="1" width="10%">篇數</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><input name="sw_article_count<%=i+1%>" type="number" class="ic<%=i+1%>" value="<%=json.get("sw_article_count"+(i+1))%>" size="5" maxlength="40" style="text-align:center; width: 75%;"/></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="sw_article_count_total" type="number" class="total_count" value="<%=json.get("sw_article_count_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="point">
		                <td colspan="1" width="10%">點數<br>(請參照<a href="https://rnd.ntut.edu.tw/var/file/42/1042/img/182608393.pdf#page=6" target="_blank">附表一</a>)</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%" ><input name="sw_point<%=i+1%>" type="number" class="pc<%=i+1%>" value="<%=json.get("sw_point"+(i+1))%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="sw_point_total" type="number" class="total_point" value="<%=json.get("sw_point_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="<%=cellsNum+2%>" width="80%">說明：論文請檢附-表B「傑出論文績效說明表」</td>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="2" colspan="1" width="20%">TSSCI/THCI (限設計及人社學院)</td>
		                <td colspan="1" width="10%">篇數</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><input name="t_article_count<%=i+1%>" type="number" class="ic<%=i+1%>" size="5" maxlength="40" value="<%=json.get("t_article_count"+(i+1))%>" style="text-align:center; width: 75%;" ></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="t_article_count_total" type="number" class="total_count" value="<%=json.get("t_article_count_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="point">
		                <td colspan="1" width="10%" >
							點數<br>(<font color="blue"><%=TSSCIPointPerArticle%>點/篇</font>)
							<input type="hidden" name="multiple" value="<%=TSSCIPointPerArticle%>">
						</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%" ><input name="t_point<%=i+1%>" type="number" class="pc<%=i+1%>" value="<%=json.get("t_point"+(i+1))%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="t_point_total" type="number" class="total_point" value="<%=json.get("t_point_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="2" colspan="1" width="20%">人文、設計、藝術或社會之學術專書</td>
		                <td colspan="1" width="10%">冊數</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><input name="a_book_count<%=i+1%>" type="number" class="ic<%=i+1%>" size="5" maxlength="40" value="<%=json.get("a_book_count"+(i+1))%>" style="text-align:center; width: 75%;"></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="a_book_count_total" type="number" class="total_count" value="<%=json.get("a_book_count_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="point">
		                <td colspan="1" width="10%">
							點數<br>(<font color="blue"><%=artsBooksPerBooks%>點/冊</font>)
							<input type="hidden" name="multiple" value="<%=artsBooksPerBooks%>">
						</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%" ><input name="a_book_point<%=i+1%>" type="number" class="pc<%=i+1%>" value="<%=json.get("a_book_point"+(i+1))%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="a_book_point_total" type="number" class="total_point" value="<%=json.get("a_book_point_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="2" colspan="1" width="20%">人文、設計、藝術或社會之學術專書單篇(章)</td>
		                <td colspan="1" width="10%">篇數</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><input name="a_article_count<%=i+1%>" type="number" class="ic<%=i+1%>" size="5" maxlength="40" value="<%=json.get("a_article_count"+(i+1))%>" style="text-align:center; width: 75%;"></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="a_article_count_total" type="number" class="total_count" value="<%=json.get("a_article_count_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="point">
		                <td colspan="1" width="10%">
							點數<br>(<font color="blue"><%=artsArticlePerArticle%>點/篇</font>)
							<input type="hidden" name="multiple" value="<%=artsArticlePerArticle%>">
						</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%" ><input name="a_article_point<%=i+1%>" type="number" class="pc<%=i+1%>" value="<%=json.get("a_article_point"+(i+1))%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="a_article_point_total" type="number" class="total_point" value="<%=json.get("a_article_point_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="4" width="54%">近五年FWCI值：<input name="fwci_value_past_five_year" type="number" value="<%=json.get("fwci_value_past_five_year")%>" style="text-align:center; width: 10%;">，若為本校近五年FWCI值之1.5倍則加計點數10點(B)</td>
						<td colspan="2" width="24%">總計點數<br>(A)+(B)</td>
						<td colspan="<%=cellsNum-3%>" width="22%" ><input name="a_plus_b_total_point" type="number" value="<%=json.get("a_plus_b_total_point")%>" style="text-align:center; width: 10%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">科 技 部 計 畫</td>
		                <td colspan="<%=cellsNum%>" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><%=json.get("year"+(i+1))%></td>
						<% } %>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="4" colspan="1" width="20%">近五年以本校名義主持科技部各類型計畫統計表</td>
		                <td colspan="1" width="10%">件數</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><input name="tech_project_count<%=i+1%>" type="number" class="ic<%=i+1%>" size="5" maxlength="40" value="<%=json.get("tech_project_count"+(i+1))%>" style="text-align:center; width: 75%;"></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="tech_project_count_total" type="number" class="total_count_tech_project" value="<%=json.get("tech_project_count_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="project_money">
		                <td colspan="1" width="10%">計畫金額<br>(萬元)</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><input name="tech_project_money<%=i+1%>" type="number" class="ip<%=i+1%>" size="5" maxlength="40" value="<%=json.get("tech_project_money"+(i+1))%>" style="text-align:center; width: 75%;"></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="tech_project_money_total" type="number" class="total_project_money_tech_project" value="<%=json.get("tech_project_money_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="point">
		                <td colspan="1" width="10%">
							點數<br>(<font color="blue"><%=ministryOfTechnologyProjectPoint%>點/<%=ministryOfTechnologyProjectMoney%>萬元</font>)
							<input type="hidden" name="multiple" value="<%=(double)ministryOfTechnologyProjectPoint/ministryOfTechnologyProjectMoney%>">
						</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%" ><input name="tech_project_point<%=i+1%>" type="number" class="pc<%=i+1%>" value="<%=json.get("tech_project_point"+(i+1))%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="tech_project_point_total" type="number" class="total_point_tech_project" value="<%=json.get("tech_project_point_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            
		            <tr>
		                <td colspan="<%=cellsNum+2%>" width="80%">
		                    <p>說明：不包含科技部產學合作計畫。</p>
		                </td>
		            </tr>

		            <tr>
		                <td colspan="<%=cellsNum+4%>" width="100%" style="text-align: center; background: #C0C0C0">其 它 傑 出 表 現 說 明</td>
		            </tr>
		            <tr>
		                <td colspan="<%=cellsNum+4%>" width="100%">其他資料（例如：擔任國際重要學術學會理監事、國際知名學術期刊編輯/副編輯或評審委員、專利或技術移轉具體績效、獲獎情形及重要會議邀請演講…等）。
                        	<p><textarea style="resize:none;width:100%;height:200px;" name="other_data" ><%=json.get("other_data")%></textarea></p>
                    	</td>
		            </tr>
		            <tr>
		                <td colspan="<%=cellsNum+4%>" width="100%"><input type="checkbox" name="declaration" class="check">申請人聲明&nbsp;充分瞭解申請要點，且以上所填各項資料與勾選事項皆確實無誤，若有不實本人願負擔所有法律及行政責任。<br><br>
							註：1.論文以當年度紙本刊登為準。2.以本校「教師評鑑及基本資料庫」之資料為準。<br>
		                    <a style="margin-left: 65%">日期:<input type="date" name="commit_date" class="date" value="<%=json.get("commit_date")%>"></a>
		                </td>
		            </tr>
		        </tbody>
		    </table>
            <p style="text-align: center;">
<%--	            <input type="button" name="save" class="button" value="存檔" onclick="commit()">--%>
				<button type="button" name="save" onclick="commit()">存檔</button>
	            <input type="button" name="return_last_page" class="button" value="回上頁" onclick="javascript:location.href='/TeacherHireResearcherCatalog'"  >
       		</p>
        </form>
    </div>

</body>
</html>
