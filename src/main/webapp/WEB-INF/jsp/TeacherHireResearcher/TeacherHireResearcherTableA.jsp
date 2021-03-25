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
    <title>近五年內發表之期刊論文統計表(表A)</title>
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
	        return data;
	    }

		$(document).ready(function(){
			$("tr").each(function(){
				$(this).find("input").each(function(){
					fillSpaceWithZero(this);
				});
				calculatePoint($(this));
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
			calculatePrize();
			let betterAmount = document.getElementById("FWCIPrize").innerHTML;
			total += toFloat(betterAmount);

			$("input[name='a_plus_b_total_point']").val(total);
		}

		function calculatePrize(){
			let FWCIValueofntut = ${fwci};
			let FWCIValueofuser = document.getElementById("fwci_value").value;
			let multipleofFWCI = roundDecimal(FloatDiv(FWCIValueofuser,FWCIValueofntut),2).toString();

			let h5Indexofntut = ${h5Index};
			let h5Indexofuser = document.getElementById("h5_index").value;
			let multipleofh5 = roundDecimal(FloatDiv(h5Indexofuser,h5Indexofntut),2).toString();

			document.getElementById("FWCIValueOfUserDivideNTUT").innerHTML =  multipleofFWCI;
			document.getElementById("h5IndexOfUserDivideNTUT").innerHTML =  multipleofh5;

			let betterAmount = toFloat(getPrizeByFWCIMultiple(multipleofFWCI)) >= toFloat(getPrizeByh5Multiple(multipleofh5)) ? getPrizeByFWCIMultiple(multipleofFWCI) :getPrizeByh5Multiple(multipleofh5);
			document.getElementById("FWCIPrize").innerHTML = betterAmount;
		}

		function getPrizeByFWCIMultiple(multiple){
			var point = "";

			if(parseFloat(multiple)>=parseFloat("2.2")){
				point = "15";
			}
			else if (parseFloat(multiple)>=parseFloat("1.8") && parseFloat(multiple)<parseFloat("2.2")){
				point = "13";
			}
			else if (parseFloat(multiple)>=parseFloat("1.5") && parseFloat(multiple)<parseFloat("1.8")){
				point = "10";
			}
			else if (parseFloat(multiple)>=parseFloat("1.3") && parseFloat(multiple)<parseFloat("1.5")){
				point = "8";
			}
			else if (parseFloat(multiple)>=parseFloat("1.1") && parseFloat(multiple)<parseFloat("1.3")){
				point = "6";
			}
			else {
				point = "0";
			}
			return point;
		}

		function getPrizeByh5Multiple(multiple){
			var point = "";

			if(parseFloat(multiple)>=parseFloat("0.55")){
				point = "15";
			}
			else if (parseFloat(multiple)>=parseFloat("0.40") && parseFloat(multiple)<parseFloat("0.55")){
				point = "13";
			}
			else if (parseFloat(multiple)>=parseFloat("0.25") && parseFloat(multiple)<parseFloat("0.40")){
				point = "10";
			}
			else if (parseFloat(multiple)>=parseFloat("0.15") && parseFloat(multiple)<parseFloat("0.25")){
				point = "8";
			}
			else if (parseFloat(multiple)>=parseFloat("0.10") && parseFloat(multiple)<parseFloat("0.15")){
				point = "6";
			}
			else {
				point = "0";
			}
			return point;
		}

		var roundDecimal = function (val, precision) {
			return Math.round(Math.round(val * Math.pow(10, (precision || 0) + 1)) / 10) / Math.pow(10, (precision || 0));
		}

		function FloatDiv(arg1, arg2){
			var t1 = 0, t2 = 0, r1, r2;
			try { t1 = arg1.toString().split(".")[1].length } catch (e) { }
			try { t2 = arg2.toString().split(".")[1].length } catch (e) { }

			r1 = Number(arg1.toString().replace(".", ""))
			r2 = Number(arg2.toString().replace(".", ""))
			return (r1 / r2) * Math.pow(10, t2 - t1);

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
			<p style="text-align:center;font-weight:bold;font-size:20px;">近五年內發表之期刊論文統計表(表A)</p>
            <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
		        <tbody>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">學術論著</td>
		                <td colspan="<%=cellsNum%>" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計<br>(A)</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
                        <% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%" ><input name="year<%=i+1%>" type="number" value="<%=json.opt("year"+(i+1))%>" style="text-align:center; width: 75%; border:none; outline:none; background-color:transparent;" tabindex="-1" readonly></td>
                        <% } %>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="3" colspan="1" width="20%">Scopus 或 WOS 資料庫</td>
		                <td colspan="1" width="10%">篇數</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><input name="sw_article_count<%=i+1%>" type="number" class="ic<%=i+1%>" value="<%=json.opt("sw_article_count"+(i+1))%>" size="5" maxlength="40" style="text-align:center; width: 75%;"/></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="sw_article_count_total" type="number" class="total_count" value="<%=json.opt("sw_article_count_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="point">
		                <td colspan="1" width="10%">點數<br>(請參照<a href="https://rnd.ntut.edu.tw/var/file/42/1042/img/182608393.pdf#page=6" target="_blank">附表一</a>)</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%" ><input name="sw_point<%=i+1%>" type="number" class="pc<%=i+1%>" value="<%=json.opt("sw_point"+(i+1))%>" style="text-align:center; width: 75%;"></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="sw_point_total" type="number" class="total_point" value="<%=json.opt("sw_point_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="<%=cellsNum+2%>" width="80%">說明：論文請檢附-表B「傑出論文績效說明表」</td>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="2" colspan="1" width="20%">TSSCI/THCI (限設計及人社學院)</td>
		                <td colspan="1" width="10%">篇數</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><input name="t_article_count<%=i+1%>" type="number" class="ic<%=i+1%>" size="5" maxlength="40" value="<%=json.opt("t_article_count"+(i+1))%>" style="text-align:center; width: 75%;" ></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="t_article_count_total" type="number" class="total_count" value="<%=json.opt("t_article_count_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="point">
		                <td colspan="1" width="10%" >
							點數<br>(<font color="blue"><%=TSSCIPointPerArticle%>點/篇</font>)
							<input type="hidden" name="multiple" value="<%=TSSCIPointPerArticle%>">
						</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%" ><input name="t_point<%=i+1%>" type="number" class="pc<%=i+1%>" value="<%=json.opt("t_point"+(i+1))%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="t_point_total" type="number" class="total_point" value="<%=json.opt("t_point_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="2" colspan="1" width="20%">人文、設計、藝術或社會之學術專書</td>
		                <td colspan="1" width="10%">冊數</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><input name="a_book_count<%=i+1%>" type="number" class="ic<%=i+1%>" size="5" maxlength="40" value="<%=json.opt("a_book_count"+(i+1))%>" style="text-align:center; width: 75%;"></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="a_book_count_total" type="number" class="total_count" value="<%=json.opt("a_book_count_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="point">
		                <td colspan="1" width="10%">
							點數<br>(<font color="blue"><%=artsBooksPerBooks%>點/冊</font>)
							<input type="hidden" name="multiple" value="<%=artsBooksPerBooks%>">
						</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%" ><input name="a_book_point<%=i+1%>" type="number" class="pc<%=i+1%>" value="<%=json.opt("a_book_point"+(i+1))%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="a_book_point_total" type="number" class="total_point" value="<%=json.opt("a_book_point_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="2" colspan="1" width="20%">人文、設計、藝術或社會之學術專書單篇(章)</td>
		                <td colspan="1" width="10%">篇數</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><input name="a_article_count<%=i+1%>" type="number" class="ic<%=i+1%>" size="5" maxlength="40" value="<%=json.opt("a_article_count"+(i+1))%>" style="text-align:center; width: 75%;"></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="a_article_count_total" type="number" class="total_count" value="<%=json.opt("a_article_count_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="point">
		                <td colspan="1" width="10%">
							點數<br>(<font color="blue"><%=artsArticlePerArticle%>點/篇</font>)
							<input type="hidden" name="multiple" value="<%=artsArticlePerArticle%>">
						</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%" ><input name="a_article_point<%=i+1%>" type="number" class="pc<%=i+1%>" value="<%=json.opt("a_article_point"+(i+1))%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="a_article_point_total" type="number" class="total_point" value="<%=json.opt("a_article_point_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="<%=cellsNum%>" width="<%=90 - (60/cellsNum * 2)%>%">
							<p align="left">申請人於SciVal資料庫中近五年FWCI值及h-5指數，若為本校近五年FWCI值及h-5指數之倍數，擇最優一項加計點數，對應表如下：</p>
							<br>
							<table align="center" style="text-align: center; border:1px #cccccc solid;border-collapse: collapse; min-width: 60px" cellpadding="10" border='1'>
								<tr>
									<td rowspan="1" colspan="2" width="20%">FWCI倍數</td>
									<td rowspan="1" colspan="2" width="20%">1.1-1.3(不含)</td>
									<td rowspan="1" colspan="2" width="20%">1.3-1.5(不含)</td>
									<td rowspan="1" colspan="2" width="20%">1.5-1.8(不含)</td>
									<td rowspan="1" colspan="2" width="20%">1.8-2.2(不含)</td>
									<td rowspan="1" colspan="2" width="20%">2.2以上</td>
								</tr>
								<tr>
									<td rowspan="1" colspan="2" width="20%">h-5指數之倍數</td>
									<td rowspan="1" colspan="2" width="20%">0.10-0.15(不含)</td>
									<td rowspan="1" colspan="2" width="20%">0.15-0.25(不含)</td>
									<td rowspan="1" colspan="2" width="20%">0.25-0.40(不含)</td>
									<td rowspan="1" colspan="2" width="20%">0.40-0.55(不含)</td>
									<td rowspan="1" colspan="2" width="20%">0.55以上</td>
								</tr>
								<tr>
									<td rowspan="1" colspan="2" width="20%">加計點數<br><span style="font-style:normal; font-size: 12px;">(依年底預算浮動)</span></td>
									<td rowspan="1" colspan="2" width="10%" >6</td>
									<td rowspan="1" colspan="2" width="10%" >8</td>
									<td rowspan="1" colspan="2" width="10%" >10</td>
									<td rowspan="1" colspan="2" width="10%" >13</td>
									<td rowspan="1" colspan="2" width="10%" >15</td>
								</tr>
							</table>
							<br>
							<p align="left">申請人近5年FWCI值:&nbsp;<input name="fwci_value" type="number" id="fwci_value" value="<%=json.get("fwci_value")%>" style="text-align:center; width: 10%;">&nbsp;
								為本校近五年FWCI值<span >${fwci}</span>之<span id="FWCIValueOfUserDivideNTUT"></span>倍。<br></p>
							<p align="left">申請人h-5指數:&nbsp;<input name="h5_index" type="number" id="h5_index" value="<%=json.get("h5_index")%>" style="text-align:center; width: 10%;">&nbsp;
								為本校近五年h-5指數<span >${h5Index}</span>之<span id="h5IndexOfUserDivideNTUT"></span>倍。<br></p>

							<p align="left">上述兩者擇最優一項，加計點數：&nbsp;<span id="FWCIPrize"></span>點(B)</p>
						</td>
						<td colspan="1" width="<%=60/cellsNum%>%">總計點數<br>(A)+(B)</td>
						<td colspan="2" width="<%=60/cellsNum+10%>%" ><input name="a_plus_b_total_point" type="number" value="<%=json.opt("a_plus_b_total_point")%>" style="text-align:center; width: 40%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
					<tr>
						<td colspan="<%=cellsNum+3%>" width="100%">
							說明：
							<ol>
								<li>近五年以本校名義發表之學術論著（此段期間曾生產或請育嬰假者得以延長，其延長期限依實際請假時間為依據，並檢附相關證明文件）始得採計。</li>
								<li>論文之期刊排名以<a style="font-weight: bold;">出版年度</a>為準，若無該出版年資料，則以前一年度為準。</li>
								<li>每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書。</li>
							</ol>
						</td>
					</tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">
							科 技 部 計 畫
							<br><a style="font-weight: bold;">(不包含科技部產學合作計畫)</a>
						</td>
		                <td colspan="<%=cellsNum%>" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><%=json.opt("year"+(i+1))%></td>
						<% } %>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="3" colspan="1" width="20%">近五年以本校名義主持科技部各類型計畫統計表</td>
		                <td colspan="1" width="10%">件數</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><input name="tech_project_count<%=i+1%>" type="number" class="ic<%=i+1%>" size="5" maxlength="40" value="<%=json.opt("tech_project_count"+(i+1))%>" style="text-align:center; width: 75%;"></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="tech_project_count_total" type="number" class="total_count_tech_project" value="<%=json.opt("tech_project_count_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="project_money">
		                <td colspan="1" width="10%">計畫金額<br>(萬元)</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%"><input name="tech_project_money<%=i+1%>" type="number" class="ip<%=i+1%>" size="5" maxlength="40" value="<%=json.opt("tech_project_money"+(i+1))%>" style="text-align:center; width: 75%;"></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="tech_project_money_total" type="number" class="total_project_money_tech_project" value="<%=json.opt("tech_project_money_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>
		            <tr style="text-align: center;" class="point">
		                <td colspan="1" width="10%">
							點數<br>(<font color="blue"><%=ministryOfTechnologyProjectPoint%>點/<%=ministryOfTechnologyProjectMoney%>萬元</font>)
							<input type="hidden" name="multiple" value="<%=(double)ministryOfTechnologyProjectPoint/ministryOfTechnologyProjectMoney%>">
						</td>
						<% for (int i=0; i<cellsNum; i++){ %>
							<td colspan="1" width="<%=60/cellsNum%>%" ><input name="tech_project_point<%=i+1%>" type="number" class="pc<%=i+1%>" value="<%=json.opt("tech_project_point"+(i+1))%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
						<% } %>
						<td colspan="1" width="10%" ><input name="tech_project_point_total" type="number" class="total_point_tech_project" value="<%=json.opt("tech_project_point_total")%>" style="text-align:center; width: 75%; border:none; outline:none;" tabindex="-1" readonly></td>
		            </tr>

		            <tr>
		                <td colspan="<%=cellsNum+3%>" width="100%">
							<input type="checkbox" name="declaration" class="check">申請人聲明&nbsp;充分瞭解申請要點，且以上所填各項資料與勾選事項皆確實無誤，若有不實本人願負擔所有法律及行政責任。<br><br>
							註：1.論文以當年度紙本刊登為準。 2.以本校「教師評鑑及基本資料庫」之資料為準。<br>
		                    <a style="margin-left: 65%">日期:<input type="date" name="commit_date" class="date" value="<%=json.opt("commit_date")%>"></a>
		                </td>
		            </tr>
		        </tbody>
		    </table>
            <p style="text-align: center;">
				<input type="button" name="return_last_page" class="button" value="回上頁" onclick="javascript:location.href='/TeacherHireResearcherCatalog'"  >
				<button type="button" name="save" onclick="commit()">存檔</button>
       		</p>
        </form>
    </div>

</body>
</html>
