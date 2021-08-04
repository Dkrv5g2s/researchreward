<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	JSONObject json = (JSONObject) request.getAttribute("json");
%>
<html>
<head>
	<title>國立臺北科技大學獎勵特殊優秀研究人才傑出績效說明表</title>
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
		table td.metadata{
			width: 150px;
			background-color: rgb(255, 255, 240);
			text-align: right;
		}
		table td.cb{
			width: 1%;
		}
		table td.checkboxcontent{
			width: 500px;
			background-color: rgb(255, 255, 240);
			text-align: left;
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
		input.back {
			width: 55px;
		}
		input.date {
			width: 135px;
		}
		input.check {
			width: 10px;
		}
		.sign{
			vertical-align: top;
			text-align: left;
			width: 200px;
			height: 80px;"
		}
		table tr.title{
			text-align: center;
			background: #C0C0C0;
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="/js/Function.js"></script>
	<script>

		function commit(){
			$.ajax({
				type: 'POST',
				url: 'OutstandingPerformanceDescriptionForm',
				dataType: 'text',
				data: JSON.stringify(InputToJson()),
				contentType: 'application/json',
				success: function(data){
					alert('存檔成功');
					location.reload();
				}
			});

		};

		function InputToJson(){
			var data = {};

			for (var i=0; i<document.getElementsByTagName("input").length; i++) {

				data[ document.getElementsByTagName("input")[i].name] = document.getElementsByTagName("input")[i].value;

			}

			for (var j=0; j<document.getElementsByTagName("td").length; j++) {

				data[ document.getElementsByTagName("td")[j].id] = document.getElementsByTagName("td")[j].innerHTML;

			}

			for (var k=0; k<document.getElementsByTagName("label").length; k++) {

				data[ document.getElementsByTagName("label")[k].id] = document.getElementsByTagName("label")[k].innerHTML;

			}
			data[ document.getElementsByTagName("textarea")[0].name] = document.getElementsByTagName("textarea")[0].value;
			return data;
		}

		function update_article(obj){
			let count = $(obj).parent().parent();
			total_count=parseInt(count.find('.ic1').val())+parseInt(count.find('.ic2').val())+parseInt(count.find('.ic3').val())+parseInt(count.find('.ic4').val())+parseInt(count.find('.ic5').val());
			total_point=parseInt(count.next().find('.pc1').text())+parseInt(count.next().find('.pc2').text())+parseInt(count.next().find('.pc3').text())+parseInt(count.next().find('.pc4').text())+parseInt(count.next().find('.pc5').text());

			if(!isNaN(total_count)){
				count.find('.total_count').text(total_count);
			}
			if(!isNaN(total_point)){
				count.next().find('.total_point').text(total_point);
			}
			calculatePrize();
		}

		function update_project_count(obj){
			let count = $(obj).parent().parent();
			total_count=parseInt(count.find('.ic1').val())+parseInt(count.find('.ic2').val())+parseInt(count.find('.ic3').val())+parseInt(count.find('.ic4').val())+parseInt(count.find('.ic5').val());

			if(!isNaN(total_count)){
				count.find('.total_count').text(total_count);
			}
		}

		function update_project(obj){
			let money = $(obj).parent().parent();
			total_count=parseInt(money.prev().find('.ic1').val())+parseInt(money.prev().find('.ic2').val())+parseInt(money.prev().find('.ic3').val())+parseInt(money.prev().find('.ic4').val())+parseInt(money.prev().find('.ic5').val());
			total_money=parseFloat(money.find('.ip1').val())+parseFloat(money.find('.ip2').val())+parseFloat(money.find('.ip3').val())+parseFloat(money.find('.ip4').val())+parseFloat(money.find('.ip5').val());
			total_point=parseFloat(money.next().find('.pc1').text())+parseFloat(money.next().find('.pc2').text())+parseFloat(money.next().find('.pc3').text())+parseFloat(money.next().find('.pc4').text())+parseFloat(money.next().find('.pc5').text());

			if(!isNaN(total_count)){
				money.prev().find('.total_count').text(total_count);
			}
			if(!isNaN(total_money)){
				money.find('.total_project_money').text(total_money.toFixed(2));
			}
			if(!isNaN(total_point)){
				money.next().find('.total_point').text(total_point.toFixed(2));
			}
		}

		function update_project_manage(obj){
			let money = $(obj).parent().parent();
			total_count=parseInt(money.prev().prev().find('.ic1').val())+parseInt(money.prev().prev().find('.ic2').val())+parseInt(money.prev().prev().find('.ic3').val())+parseInt(money.prev().prev().find('.ic4').val())+parseInt(money.prev().prev().find('.ic5').val());
			total_money=parseFloat(money.find('.ip1').val())+parseFloat(money.find('.ip2').val())+parseFloat(money.find('.ip3').val())+parseFloat(money.find('.ip4').val())+parseFloat(money.find('.ip5').val());
			total_manage_money=parseFloat(money.prev().find('.mp1').val())+parseFloat(money.prev().find('.mp2').val())+parseFloat(money.prev().find('.mp3').val())+parseFloat(money.prev().find('.mp4').val())+parseFloat(money.prev().find('.mp5').val());
			total_point=parseFloat(money.next().find('.pc1').text())+parseFloat(money.next().find('.pc2').text())+parseFloat(money.next().find('.pc3').text())+parseFloat(money.next().find('.pc4').text())+parseFloat(money.next().find('.pc5').text());

			if(!isNaN(total_count)){
				money.prev().prev().find('.total_count').text(total_count);
			}
			if(!isNaN(total_money)){
				money.find('.total_project_money').text(total_money.toFixed(2));
			}
			if(!isNaN(total_manage_money)){
				money.prev().find('.total_manage_money').text(total_manage_money.toFixed(2));
			}
			if(!isNaN(total_point)){
				money.next().find('.total_point').text(total_point.toFixed(2));
			}
		}

		function update_manage_project(obj){
			let money = $(obj).parent().parent();
			total_count=parseInt(money.prev().find('.ic1').val())+parseInt(money.prev().find('.ic2').val())+parseInt(money.prev().find('.ic3').val())+parseInt(money.prev().find('.ic4').val())+parseInt(money.prev().find('.ic5').val());
			total_money=parseFloat(money.next().find('.ip1').val())+parseFloat(money.next().find('.ip2').val())+parseFloat(money.next().find('.ip3').val())+parseFloat(money.next().find('.ip4').val())+parseFloat(money.next().find('.ip5').val());
			total_manage_money=parseFloat(money.find('.mp1').val())+parseFloat(money.find('.mp2').val())+parseFloat(money.find('.mp3').val())+parseFloat(money.find('.mp4').val())+parseFloat(money.find('.mp5').val());
			total_point=parseFloat(money.next().next().find('.pc1').text())+parseFloat(money.next().next().find('.pc2').text())+parseFloat(money.next().next().find('.pc3').text())+parseFloat(money.next().next().find('.pc4').text())+parseFloat(money.next().next().find('.pc5').text());

			if(!isNaN(total_count)){
				money.prev().find('.total_count').text(total_count);
			}
			if(!isNaN(total_money)){
				money.next().find('.total_project_money').text(total_money.toFixed(2));
			}
			if(!isNaN(total_manage_money)){
				money.find('.total_manage_money').text(total_manage_money.toFixed(2));
			}
			if(!isNaN(total_point)){
				money.next().next().find('.total_point').text(total_point.toFixed(2));
			}
		}

		function article(class_name,point_id){

			$('.count').on( 'keyup',class_name,function(){
				update_article(this);
			});

			$('.count1').on( 'keyup',class_name,function(){
				var count = +$(this).val();
				$(this).parents('.count1').next().find(point_id).text(2*count);
				update_article(this);
			});

			$('.count2').on( 'keyup',class_name,function(){
				var count = +$(this).val();
				$(this).parents('.count2').next().find(point_id).text(6*count);
				update_article(this);
			});

			$('.count3').on( 'keyup',function(){
				calculatePrize();
			});
		}

		function project(count,class_name,point_id){

			$('.count').on( 'keyup',count,function(){
				update_project_count(this);
			});

			$('.project_money1').on( 'keyup',class_name,function(){
				var money = +$(this).val();
				$(this).parents('.project_money1').next().find(point_id).text((money/2).toFixed(2));
				update_project(this);
			});

			$('.project_money2').on( 'keyup',class_name,function(){
				var money = +$(this).val();
				$(this).parents('.project_money2').next().find(point_id).text((money/5).toFixed(2));
				update_project(this);
			});

		}

		function project_with_manage(count,project_class,manage_class,point_id){

			$('.count').on( 'keyup',count,function(){
				update_project_count(this);
			});

			$('.project_money3').on( 'keyup',project_class,function(){
				var money = +$(this).val();
				var manage = $(this).parents('.project_money3').prev().find(manage_class).val();
				$(this).parents('.project_money3').next().find(point_id).text(((parseFloat(money)+parseFloat(manage))/5).toFixed(2));
				update_project_manage(this);
			});

			$('.mamage_money1').on( 'keyup',manage_class,function(){
				var manage = +$(this).val();
				var money = $(this).parents('.mamage_money1').next().find(project_class).val();
				$(this).parents('.mamage_money1').next().next().find(point_id).text(((parseFloat(money)+parseFloat(manage))/5).toFixed(2));
				update_manage_project(this);
			});

			$('.project_money4').on( 'keyup',project_class,function(){
				var money = +$(this).val();
				var manage = $(this).parents('.project_money4').prev().find(manage_class).val();
				$(this).parents('.project_money4').next().find(point_id).text(((parseFloat(money)+parseFloat(manage))/2).toFixed(2));
				update_project_manage(this);
			});

			$('.mamage_money2').on( 'keyup',manage_class,function(){
				var manage = +$(this).val();
				var money = $(this).parents('.mamage_money2').next().find(project_class).val();
				$(this).parents('.mamage_money2').next().next().find(point_id).text(((parseFloat(money)+parseFloat(manage))/2).toFixed(2));
				update_manage_project(this);
			});

		}

		function calculatePrize(){

			var FWCIValueofntut = ${fwci};
			var FWCIValueofuser = document.getElementById("fwci_value").value;
			var multipleofFWCI = roundDecimal(FloatDiv(FWCIValueofuser,FWCIValueofntut),2).toString();

			var h5Indexofntut = ${h5Index};
			var h5Indexofuser = document.getElementById("h5_index").value;
			var multipleofh5 = roundDecimal(FloatDiv(h5Indexofuser,h5Indexofntut),2).toString();

			document.getElementById("FWCIValueOfUserDivideNTUT").innerHTML =  multipleofFWCI;
			document.getElementById("h5IndexOfUserDivideNTUT").innerHTML =  multipleofh5;
			console.log("FWCIuser:",FWCIValueofuser,"ntut:",FWCIValueofntut,"multiple:",multipleofFWCI,"FWCIPrize:",getPrizeByFWCIMultiple(multipleofFWCI))
			console.log("h5user:",h5Indexofuser,"ntut:",h5Indexofntut,"multiple:",multipleofh5,"FWCIPrize:",getPrizeByh5Multiple(multipleofh5))
			let betterAmount = parseFloat(getPrizeByFWCIMultiple(multipleofFWCI)) >= parseFloat(getPrizeByh5Multiple(multipleofh5)) ? getPrizeByFWCIMultiple(multipleofFWCI) :getPrizeByh5Multiple(multipleofh5);
			document.getElementById("FWCIPrize").innerHTML = betterAmount;

			var sw_point_total = parseInt($("#sw_point_total").text());
			var t_point_total = parseInt($("#t_point_total").text());
			var a_book_point_total = parseInt($("#a_book_point_total").text());
			var a_article_point_total = parseInt($("#a_article_point_total").text());

			var update_A_plus_B = sw_point_total+t_point_total+a_book_point_total+a_article_point_total+parseInt(betterAmount);

			$("#a_plus_b_total_point").text(update_A_plus_B);

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


		$(document).ready(function(){


			$("input").blur(function(){
				if($(this).val()== ""){
					$(this).val("0");
					update_article(this);
					update_project_count(this);
					update_project(this);
					update_project_manage(this);
					update_manage_project(this);
				}
			});

			article('.ic1','.pc1');
			article('.ic2','.pc2');
			article('.ic3','.pc3');
			article('.ic4','.pc4');
			article('.ic5','.pc5');
			project('.ic1','.ip1','.pc1');
			project('.ic2','.ip2','.pc2');
			project('.ic3','.ip3','.pc3');
			project('.ic4','.ip4','.pc4');
			project('.ic5','.ip5','.pc5');
			project_with_manage('.ic1','.ip1','.mp1','.pc1');
			project_with_manage('.ic2','.ip2','.mp2','.pc2');
			project_with_manage('.ic3','.ip3','.mp3','.pc3');
			project_with_manage('.ic4','.ip4','.mp4','.pc4');
			project_with_manage('.ic5','.ip5','.mp5','.pc5');
			calculatePrize();
			$("input[name='representationClause']").on('change', function() { checkRepresentationClause(); } ) ;

		});

		function checkRepresentationClause() {
			if ( $("input:not(:checked)[name='representationClause']").length == 0  ) {
				$("button[name='save_the_page']").prop( "disabled", false );
			}
			else {
				$("button[name='save_the_page']").prop( "disabled", true  );
			}
		}


	</script>
	<script>
		$(document).ready(function (){
			setReadOnly(<%=request.getAttribute("readonly")%>);
		});
	</script>
</head>
<body>
<div class="content">
	<form>
		<p>國立臺北科技大學獎勵特殊優秀研究人才傑出績效說明表</p>
		<table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
			<tbody>
			<tr class="title">
				<td rowspan="2" colspan="2" width="30%">學術論著</td>
				<td colspan="5" width="60%" style="text-align: center;">年度</td>
				<td rowspan="2" width="10%" colspan="1">小計<br>(A)</td>
			</tr>
			<tr class="title">
				<td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>
				<td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>
				<td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>
				<td colspan="1" width="12%"><label id="year4"><%=json.get("year4")%></label></td>
				<td colspan="1" width="12%"><label id="year5"><%=json.get("year5")%></label></td>
			</tr>
			<tr style="text-align: center;" class="count">
				<td rowspan="3" colspan="1" width="20%">Scopus 或 WOS 資料庫</td>
				<td colspan="1" width="10%">篇數</td>
				<td colspan="1" width="12%"><input name="sw_article_count1" type="number" class="ic1" value="<%=json.get("sw_article_count1")%>" size="5" maxlength="40" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="sw_article_count2" type="number" class="ic2" value="<%=json.get("sw_article_count2")%>" size="5" maxlength="40" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="sw_article_count3" type="number" class="ic3" value="<%=json.get("sw_article_count3")%>" size="5" maxlength="40" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="sw_article_count4" type="number" class="ic4" value="<%=json.get("sw_article_count4")%>" size="5" maxlength="40" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="sw_article_count5" type="number" class="ic5" value="<%=json.get("sw_article_count5")%>" size="5" maxlength="40" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="10%" id="sw_article_count_total" class="total_count"><%=json.get("sw_article_count_total")%></td>
			</tr>
			<tr style="text-align: center;" class="count">
				<td colspan="1" width="10%">點數<br>(請參照表B)</td>
				<td colspan="1" width="12%"><input name="sw_point1" type="number" id="sw_point1" class="ic1" value="<%=json.get("sw_point1")%>" size="5" maxlength="40" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="sw_point2" type="number" id="sw_point2" class="ic2" value="<%=json.get("sw_point2")%>" size="5" maxlength="40" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="sw_point3" type="number" id="sw_point3" class="ic3" value="<%=json.get("sw_point3")%>" size="5" maxlength="40" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="sw_point4" type="number" id="sw_point4" class="ic4" value="<%=json.get("sw_point4")%>" size="5" maxlength="40" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="sw_point5" type="number" id="sw_point5" class="ic5" value="<%=json.get("sw_point5")%>" size="5" maxlength="40" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="10%" id="sw_point_total" class="total_count" ><%=json.get("sw_point_total")%></td>
			</tr>
			<tr>
				<td colspan="7" width="80%">說明：採計Scopus論文者，請檢附-表B「傑出論文績效說明表」</td>
			</tr>
			<tr style="text-align: center;" class="count1">
				<td rowspan="2" colspan="1" width="20%">TSSCI/THCI (限設計及人社學院)</td>
				<td colspan="1" width="10%">篇數</td>
				<td colspan="1" width="12%"><input name="t_article_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("t_article_count1")%>" style="text-align:center; width: 75%;" ></td>
				<td colspan="1" width="12%"><input name="t_article_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("t_article_count2")%>" style="text-align:center; width: 75%;" ></td>
				<td colspan="1" width="12%"><input name="t_article_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("t_article_count3")%>" style="text-align:center; width: 75%;" ></td>
				<td colspan="1" width="12%"><input name="t_article_count4" type="number" class="ic4" size="5" maxlength="40" value="<%=json.get("t_article_count4")%>" style="text-align:center; width: 75%;" ></td>
				<td colspan="1" width="12%"><input name="t_article_count5" type="number" class="ic5" size="5" maxlength="40" value="<%=json.get("t_article_count5")%>" style="text-align:center; width: 75%;" ></td>
				<td colspan="1" width="10%" id="t_article_count_total" class="total_count"><%=json.get("t_article_count_total")%></td>
			</tr>
			<tr style="text-align: center;" class="point">
				<td colspan="1" width="10%" >點數<br>(<font color="blue">2點/篇</font>)</td>
				<td colspan="1" width="12%" id="t_point1" class="pc1" ><%=json.get("t_point1")%></td>
				<td colspan="1" width="12%" id="t_point2" class="pc2" ><%=json.get("t_point2")%></td>
				<td colspan="1" width="12%" id="t_point3" class="pc3"><%=json.get("t_point3")%></td>
				<td colspan="1" width="12%" id="t_point4" class="pc4" ><%=json.get("t_point4")%></td>
				<td colspan="1" width="12%" id="t_point5" class="pc5" ><%=json.get("t_point5")%></td>
				<td colspan="1" width="10%" id="t_point_total" class="total_point"><%=json.get("t_point_total")%></td>
			</tr>
			<tr style="text-align: center;" class="count2">
				<td rowspan="2" colspan="1" width="20%">人文、設計、藝術或社會之學術專書</td>
				<td colspan="1" width="10%">冊數</td>
				<td colspan="1" width="12%"><input name="a_book_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("a_book_count1")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="a_book_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("a_book_count2")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="a_book_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("a_book_count3")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="a_book_count4" type="number" class="ic4" size="5" maxlength="40" value="<%=json.get("a_book_count4")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="a_book_count5" type="number" class="ic5" size="5" maxlength="40" value="<%=json.get("a_book_count5")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="10%" id="a_book_count_total" class="total_count"><%=json.get("a_book_count_total")%></td>
			</tr>
			<tr style="text-align: center;" class="point">
				<td colspan="1" width="10%">點數<br>(<font color="blue">6點/冊</font>)</td>
				<td colspan="1" width="12%" id="a_book_point1" class="pc1"><%=json.get("a_book_point1")%></td>
				<td colspan="1" width="12%" id="a_book_point2" class="pc2"><%=json.get("a_book_point2")%></td>
				<td colspan="1" width="12%" id="a_book_point3" class="pc3"><%=json.get("a_book_point3")%></td>
				<td colspan="1" width="12%" id="a_book_point4" class="pc4"><%=json.get("a_book_point4")%></td>
				<td colspan="1" width="12%" id="a_book_point5" class="pc5"><%=json.get("a_book_point5")%></td>
				<td colspan="1" width="10%" id="a_book_point_total" class="total_point"><%=json.get("a_book_point_total")%></td>
			</tr>
			<tr style="text-align: center;" class="count1">
				<td rowspan="2" colspan="1" width="20%">人文、設計、藝術或社會之學術專書單篇(章)</td>
				<td colspan="1" width="10%">篇數</td>
				<td colspan="1" width="12%"><input name="a_article_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("a_article_count1")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="a_article_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("a_article_count2")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="a_article_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("a_article_count3")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="a_article_count4" type="number" class="ic4" size="5" maxlength="40" value="<%=json.get("a_article_count4")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="a_article_count5" type="number" class="ic5" size="5" maxlength="40" value="<%=json.get("a_article_count5")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="10%" id="a_article_count_total" class="total_count"><%=json.get("a_article_count_total")%></td>
			</tr>
			<tr style="text-align: center;" class="point">
				<td colspan="1" width="10%">點數<br>(<font color="blue">2點/篇</font>)</td>
				<td colspan="1" width="12%" id="a_article_point1" class="pc1"><%=json.get("a_article_point1")%></td>
				<td colspan="1" width="12%" id="a_article_point2" class="pc2"><%=json.get("a_article_point2")%></td>
				<td colspan="1" width="12%" id="a_article_point3" class="pc3"><%=json.get("a_article_point3")%></td>
				<td colspan="1" width="12%" id="a_article_point4" class="pc4"><%=json.get("a_article_point4")%></td>
				<td colspan="1" width="12%" id="a_article_point5" class="pc5"><%=json.get("a_article_point5")%></td>
				<td colspan="1" width="10%" id="a_article_point_total" class="total_point"><%=json.get("a_article_point_total")%></td>
			</tr>
			<tr style="text-align: center;" class="count3">
				<td colspan="4"  width="54%">
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
					<p align="left">申請人近5年FWCI值:&nbsp;<input name="fwci_value" id="fwci_value" value="<%=json.get("fwci_value")%>" style="text-align:center; width: 10%;" oninput="calculatePrize()">&nbsp;
						為本校近五年FWCI值<span >${fwci}</span>之<span id="FWCIValueOfUserDivideNTUT"></span>倍。<br></p>
					<p align="left">申請人h-5指數:&nbsp;<input name="h5_index" id="h5_index" value="<%=json.get("h5_index")%>" style="text-align:center; width: 10%;" oninput="calculatePrize()">&nbsp;
						為本校近五年h-5指數<span >${h5Index}</span>之<span id="h5IndexOfUserDivideNTUT"></span>倍。<br></p>

					<p align="left">上述兩者擇最優一項，加計點數：&nbsp;<span id="FWCIPrize"></span>點(B)。</p>

				</td>
				<td colspan="2" width="24%">總計點數<br>(A)+(B)</td>
				<td colspan="2" width="22%" id="a_plus_b_total_point" ><%=json.get("a_plus_b_total_point")%></td>
			</tr>
			<tr>
				<td colspan="8"><p>說明：</p>
					<p>1.近五年以本校名義發表之學術論著（此段期間曾生產或請育嬰假者得以延長，其延長期限依實際請假時間為依據，並檢附相關證明文件）始得採計。</p>
					<p>2.論文之期刊排名以出版年度為準，若無該出版年資料，則以前一年度為準。</p>
					<p>3.每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書。</p>
				</td>
			</tr>
			<tr class="title">
				<td rowspan="2" colspan="2" width="30%">科 技 部 計 畫<br>(不包含科技部產學合作計畫)</td>
				<td colspan="5" width="60%" style="text-align: center;">年度</td>
				<td rowspan="2" width="10%" colspan="1">小計</td>
			</tr>
			<tr class="title">
				<td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>
				<td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>
				<td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>
				<td colspan="1" width="12%"><label id="year4"><%=json.get("year4")%></label></td>
				<td colspan="1" width="12%"><label id="year5"><%=json.get("year5")%></label></td>
			</tr>
			<tr style="text-align: center;" class="count">
				<td rowspan="3" colspan="1" width="20%">近五年以本校名義主持科技部各類型計畫統計表</td>
				<td colspan="1" width="10%">件數</td>
				<td colspan="1" width="12%"><input name="tech_project_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("tech_project_count1")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_project_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("tech_project_count2")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_project_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("tech_project_count3")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_project_count4" type="number" class="ic4" size="5" maxlength="40" value="<%=json.get("tech_project_count4")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_project_count5" type="number" class="ic5" size="5" maxlength="40" value="<%=json.get("tech_project_count5")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="10%" id="tech_project_count_total" class="total_count"><%=json.get("tech_project_count_total")%></td>
			</tr>
			<tr style="text-align: center;" class="project_money1">
				<td colspan="1" width="10%">計畫金額<br>(萬元)</td>
				<td colspan="1" width="12%"><input name="tech_project_money1" type="number" class="ip1" size="5" maxlength="40" value="<%=json.get("tech_project_money1")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_project_money2" type="number" class="ip2" size="5" maxlength="40" value="<%=json.get("tech_project_money2")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_project_money3" type="number" class="ip3" size="5" maxlength="40" value="<%=json.get("tech_project_money3")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_project_money4" type="number" class="ip4" size="5" maxlength="40" value="<%=json.get("tech_project_money4")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_project_money5" type="number" class="ip5" size="5" maxlength="40" value="<%=json.get("tech_project_money5")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="10%" id="tech_project_money_total" class="total_project_money"><%=json.get("tech_project_money_total")%></td>
			</tr>
			<tr style="text-align: center;" class="point">
				<td colspan="1" width="10%">點數<br>(<font color="blue">5點/10萬元</font>)</td>
				<td colspan="1" width="12%" id="tech_project_point1" class="pc1"><%=json.get("tech_project_point1")%></td>
				<td colspan="1" width="12%" id="tech_project_point2" class="pc2"><%=json.get("tech_project_point2")%></td>
				<td colspan="1" width="12%" id="tech_project_point3" class="pc3"><%=json.get("tech_project_point3")%></td>
				<td colspan="1" width="12%" id="tech_project_point4" class="pc4"><%=json.get("tech_project_point4")%></td>
				<td colspan="1" width="12%" id="tech_project_point5" class="pc5"><%=json.get("tech_project_point5")%></td>
				<td colspan="1" width="10%" id="tech_project_point_total" class="total_point"><%=json.get("tech_project_point_total")%></td>
			</tr>

			<tr class="title">
				<td rowspan="2" colspan="2" width="30%">產 學 合 作 計 畫<br>(不包含以學校名義開授訓練課程招生收入)</td>
				<td colspan="5" width="60%" style="text-align: center;">年度</td>
				<td rowspan="2" width="10%" colspan="1">小計</td>
			</tr>
			<tr class="title">
				<td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>
				<td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>
				<td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>
				<td colspan="1" width="12%"><label id="year4"><%=json.get("year4")%></label></td>
				<td colspan="1" width="12%"><label id="year5"><%=json.get("year5")%></label></td>
			</tr>
			<tr style="text-align: center;" class="count">
				<td rowspan="6" colspan="1" width="20%">近五年以本校名義所獲得之產學合作計畫，其實際納入本校校務基金之統計表</td>
				<td colspan="1" width="10%">件數</td>
				<td colspan="1" width="12%"><input name="coop_project_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("coop_project_count1")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="coop_project_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("coop_project_count2")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="coop_project_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("coop_project_count3")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="coop_project_count4" type="number" class="ic4" size="5" maxlength="40" value="<%=json.get("coop_project_count4")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="coop_project_count5" type="number" class="ic5" size="5" maxlength="40" value="<%=json.get("coop_project_count5")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="10%" id="coop_project_count_total" class="total_count"><%=json.get("coop_project_count_total")%></td>
			</tr>
			<tr style="text-align: center;" class="mamage_money1">
				<td colspan="1" width="10%">管理費<br>(萬元)</td>
				<td colspan="1" width="12%"><input name="coop_project_management1" type="number" class="mp1" size="5" maxlength="40" value="<%=json.get("coop_project_management1")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="coop_project_management2" type="number" class="mp2" size="5" maxlength="40" value="<%=json.get("coop_project_management2")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="coop_project_management3" type="number" class="mp3" size="5" maxlength="40" value="<%=json.get("coop_project_management3")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="coop_project_management4" type="number" class="mp4" size="5" maxlength="40" value="<%=json.get("coop_project_management4")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="coop_project_management5" type="number" class="mp5" size="5" maxlength="40" value="<%=json.get("coop_project_management5")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="10%" id="coop_project_management_total" class="total_manage_money"><%=json.get("coop_project_management_total")%></td>
			</tr>
			<tr style="text-align: center;" class="project_money3">
				<td colspan="1" width="10%">計畫金額<br>(萬元)</td>
				<td colspan="1" width="12%"><input name="coop_project_money1" type="number" class="ip1" size="5" maxlength="40" value="<%=json.get("coop_project_money1")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="coop_project_money2" type="number" class="ip2" size="5" maxlength="40" value="<%=json.get("coop_project_money2")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="coop_project_money3" type="number" class="ip3" size="5" maxlength="40" value="<%=json.get("coop_project_money3")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="coop_project_money4" type="number" class="ip4" size="5" maxlength="40" value="<%=json.get("coop_project_money4")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="coop_project_money5" type="number" class="ip5" size="5" maxlength="40" value="<%=json.get("coop_project_money5")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="10%" id="coop_project_money_total" class="total_project_money"><%=json.get("coop_project_money_total")%></td>
			</tr>
			<tr style="text-align: center;" class="point">
				<td colspan="1" width="10%">點數<br>(<font color="blue">2點/10萬元</font>)</td>
				<td colspan="1" width="12%" id="coop_project_point1" class="pc1"><%=json.get("coop_project_point1")%></td>
				<td colspan="1" width="12%" id="coop_project_point2" class="pc2"><%=json.get("coop_project_point2")%></td>
				<td colspan="1" width="12%" id="coop_project_point3" class="pc3"><%=json.get("coop_project_point3")%></td>
				<td colspan="1" width="12%" id="coop_project_point4" class="pc4"><%=json.get("coop_project_point4")%></td>
				<td colspan="1" width="12%" id="coop_project_point5" class="pc5"><%=json.get("coop_project_point5")%></td>
				<td colspan="1" width="10%" id="coop_project_point_total" class="total_point"><%=json.get("coop_project_point_total")%></td>
			</tr>
			<tr style="text-align: center;">
				<td rowspan="2">產學處<br>(簽章)</td>
				<td colspan="3" class="sign">
					<p>
						<label>承辦人</label>
					</p>
				</td>
				<td colspan="3" style="border-left-style: hidden;" class="sign">
					<p>
						<label>單位主管</label>
					</p>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<p>※以第七級第4項、第八級及第九級第4項(3)申請者，請產學處填寫確認計畫及管理費總金額後核章</p>
				</td>
			</tr>

			<tr class="title">
				<td rowspan="2" colspan="2" width="30%">技 術 移 轉 金<br>(不包含科技部先期技術移轉授權金)</td>
				<td colspan="5" width="60%" style="text-align: center;">年度</td>
				<td rowspan="2" width="10%" colspan="1">小計</td>
			</tr>
			<tr class="title">
				<td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>
				<td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>
				<td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>
				<td colspan="1" width="12%"><label id="year4"><%=json.get("year4")%></label></td>
				<td colspan="1" width="12%"><label id="year5"><%=json.get("year5")%></label></td>
			</tr>
			<tr style="text-align: center;" class="count">
				<td rowspan="6" colspan="1" width="20%">近五年以本校名義所獲之實收技術移轉金統計表</td>
				<td colspan="1" width="10%">件數</td>
				<td colspan="1" width="12%"><input name="tech_transfer_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("tech_transfer_count1")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_transfer_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("tech_transfer_count2")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_transfer_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("tech_transfer_count3")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_transfer_count4" type="number" class="ic4" size="5" maxlength="40" value="<%=json.get("tech_transfer_count4")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_transfer_count5" type="number" class="ic5" size="5" maxlength="40" value="<%=json.get("tech_transfer_count5")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="10%" id="tech_transfer_count_total" class="total_count"><%=json.get("tech_transfer_count_total")%></td>
			</tr>
			<tr style="text-align: center;" class="mamage_money2">
				<td colspan="1" width="10%">管理費<br>(萬元)</td>
				<td colspan="1" width="12%"><input name="tech_transfer_management1" type="number" class="mp1" size="5" maxlength="40" value="<%=json.get("tech_transfer_management1")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_transfer_management2" type="number" class="mp2" size="5" maxlength="40" value="<%=json.get("tech_transfer_management2")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_transfer_management3" type="number" class="mp3" size="5" maxlength="40" value="<%=json.get("tech_transfer_management3")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_transfer_management4" type="number" class="mp4" size="5" maxlength="40" value="<%=json.get("tech_transfer_management4")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_transfer_management5" type="number" class="mp5" size="5" maxlength="40" value="<%=json.get("tech_transfer_management5")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="10%" id="tech_transfer_management_total" class="total_manage_money"><%=json.get("tech_transfer_management_total")%></td>
			</tr>
			<tr style="text-align: center;" class="project_money4">
				<td colspan="1" width="10%">技轉金額<br>(萬元)</td>
				<td colspan="1" width="12%"><input name="tech_transfer_money1" type="number" class="ip1" size="5" maxlength="40" value="<%=json.get("tech_transfer_money1")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_transfer_money2" type="number" class="ip2" size="5" maxlength="40" value="<%=json.get("tech_transfer_money2")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_transfer_money3" type="number" class="ip3" size="5" maxlength="40" value="<%=json.get("tech_transfer_money3")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_transfer_money4" type="number" class="ip4" size="5" maxlength="40" value="<%=json.get("tech_transfer_money4")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="12%"><input name="tech_transfer_money5" type="number" class="ip5" size="5" maxlength="40" value="<%=json.get("tech_transfer_money5")%>" style="text-align:center; width: 75%;"></td>
				<td colspan="1" width="10%" id="tech_transfer_money_total" class="total_project_money"><%=json.get("tech_transfer_money_total")%></td>
			</tr>
			<tr style="text-align: center;" class="point">
				<td colspan="1" width="10%">點數<br>(<font color="blue">5點/10萬元</font>)</td>
				<td colspan="1" width="12%" id="tech_transfer_point1" class="pc1"><%=json.get("tech_transfer_point1")%></td>
				<td colspan="1" width="12%" id="tech_transfer_point2" class="pc2"><%=json.get("tech_transfer_point2")%></td>
				<td colspan="1" width="12%" id="tech_transfer_point3" class="pc3"><%=json.get("tech_transfer_point3")%></td>
				<td colspan="1" width="12%" id="tech_transfer_point4" class="pc4"><%=json.get("tech_transfer_point4")%></td>
				<td colspan="1" width="12%" id="tech_transfer_point5" class="pc5"><%=json.get("tech_transfer_point5")%></td>
				<td colspan="1" width="10%" id="tech_transfer_point_total" class="total_point"><%=json.get("tech_transfer_point_total")%></td>
			</tr>
			<tr style="text-align: center;">
				<td rowspan="2">產學處<br>(簽章)</td>
				<td colspan="3" class="sign">
					<p>
						<label>承辦人</label>
					</p>
				</td>
				<td colspan="3" style="border-left-style: hidden;" class="sign">
					<p>
						<label>單位主管</label>
					</p>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<p>※以第七級第5項、第八級及第九級第4項(4)申請者，請產學處填寫確認技轉金及管理費金額後核章</p>
				</td>
			</tr>

			<tr class="title">
				<td colspan="9" width="100%">
					<p>其他傑出表現說明</p>
				</td>
			</tr>
			<tr>
				<td colspan="9" width="100%">
					<p>其他資料（例如：擔任國際重要學術學會理監事、國際知名學術期刊編輯/副編輯或評審委員、專利或技術移轉具體績效、獲獎情形及重要會議邀請演講…等）。</p>
					<textarea style="resize:none;width:100%;height:200px;" name="other_data" id="other_data" maxlength="500"  ><%=json.get("other_data")%></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="9" width="100%"><input type="checkbox" name="representationClause" class="check" >申請人聲明&nbsp;充分瞭解申請要點，且以上所填各項資料與勾選事項皆確實無誤，若有不實本人願負擔所有法律及行政責任。<br><br><br>
					<a style="margin-left: 65%">日期:<input type="date" name="commit_date" class="date" value="<%=json.get("commit_date")%>"></a>
				</td>
			</tr>
			</tbody>
		</table>
		<p style="text-align: center;">
			<input type="button" class="back" name="return_last_page" value="回上頁"  onclick="javascript:location.href='SpecialOutstandingResearcherCatalog'"  >
			<button type="button" name="save_the_page" onclick="commit()" disabled = "disabled">存檔</button>
		</p>
	</form>
</div>

</body>
</html>