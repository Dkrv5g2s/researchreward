<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");
%>
<html>
<head>
    <title>國立臺北科技大學特聘教授近五年內發表之期刊論文統計表(表A)</title>
    <style>
        body {
            margin: 20px 0px 0px 0px;
            padding: 0;
            background: #FFFFCC;
            font-size: 20px;
            color: #3C3D3F;
            background-color: #E9F2FF;
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
            width: 1200px;
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

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
	    function commit(){
	    	$.ajax({
	            type: 'POST',
	            url: 'DistinguishedProfessorTableA',
	            dataType: 'json',
	            data: JSON.stringify(InputToJson()),
	            contentType: 'application/json',
	            success: function(data){
	                alert('success');
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
    		total_money=parseInt(money.find('.ip1').val())+parseInt(money.find('.ip2').val())+parseInt(money.find('.ip3').val())+parseInt(money.find('.ip4').val())+parseInt(money.find('.ip5').val());
			total_point=parseFloat(money.next().find('.pc1').text())+parseFloat(money.next().find('.pc2').text())+parseFloat(money.next().find('.pc3').text())+parseFloat(money.next().find('.pc4').text())+parseFloat(money.next().find('.pc5').text());
			
			if(!isNaN(total_count)){
				money.prev().find('.total_count').text(total_count);
		    }
			if(!isNaN(total_money)){
				money.find('.total_project_money').text(total_money);
		    }
		    if(!isNaN(total_point)){
		    	money.next().find('.total_point').text(total_point);
		    }
    	}
    	
    	function update_project_manage(obj){
    		let money = $(obj).parent().parent();
    		total_count=parseInt(money.prev().prev().find('.ic1').val())+parseInt(money.prev().prev().find('.ic2').val())+parseInt(money.prev().prev().find('.ic3').val())+parseInt(money.prev().prev().find('.ic4').val())+parseInt(money.prev().prev().find('.ic5').val());
    		total_money=parseInt(money.find('.ip1').val())+parseInt(money.find('.ip2').val())+parseInt(money.find('.ip3').val())+parseInt(money.find('.ip4').val())+parseInt(money.find('.ip5').val());
    		total_manage_money=parseInt(money.prev().find('.mp1').val())+parseInt(money.prev().find('.mp2').val())+parseInt(money.prev().find('.mp3').val())+parseInt(money.prev().find('.mp4').val())+parseInt(money.prev().find('.mp5').val());
			total_point=parseFloat(money.next().find('.pc1').text())+parseFloat(money.next().find('.pc2').text())+parseFloat(money.next().find('.pc3').text())+parseFloat(money.next().find('.pc4').text())+parseFloat(money.next().find('.pc5').text());
			
			if(!isNaN(total_count)){
				money.prev().prev().find('.total_count').text(total_count);
		    }
			if(!isNaN(total_money)){
				money.find('.total_project_money').text(total_money);
		    }
			if(!isNaN(total_manage_money)){
				money.prev().find('.total_manage_money').text(total_manage_money);
		    }
		    if(!isNaN(total_point)){
		    	money.next().find('.total_point').text(total_point);
		    }
    	}
    	
    	function update_manage_project(obj){
    		let money = $(obj).parent().parent();
    		total_count=parseInt(money.prev().find('.ic1').val())+parseInt(money.prev().find('.ic2').val())+parseInt(money.prev().find('.ic3').val())+parseInt(money.prev().find('.ic4').val())+parseInt(money.prev().find('.ic5').val());
    		total_money=parseInt(money.next().find('.ip1').val())+parseInt(money.next().find('.ip2').val())+parseInt(money.next().find('.ip3').val())+parseInt(money.next().find('.ip4').val())+parseInt(money.next().find('.ip5').val());
    		total_manage_money=parseInt(money.find('.mp1').val())+parseInt(money.find('.mp2').val())+parseInt(money.find('.mp3').val())+parseInt(money.find('.mp4').val())+parseInt(money.find('.mp5').val());
			total_point=parseFloat(money.next().next().find('.pc1').text())+parseFloat(money.next().next().find('.pc2').text())+parseFloat(money.next().next().find('.pc3').text())+parseFloat(money.next().next().find('.pc4').text())+parseFloat(money.next().next().find('.pc5').text());
			
			if(!isNaN(total_count)){
				money.prev().find('.total_count').text(total_count);
		    }
			if(!isNaN(total_money)){
				money.next().find('.total_project_money').text(total_money);
		    }
			if(!isNaN(total_manage_money)){
				money.find('.total_manage_money').text(total_manage_money);
		    }
		    if(!isNaN(total_point)){
		    	money.next().next().find('.total_point').text(total_point);
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
    	}
    	
    	function project(count,class_name,point_id){

    		$('.count').on( 'keyup',count,function(){
    			update_project_count(this);
			});
    		
    		$('.project_money1').on( 'keyup',class_name,function(){
				var money = +$(this).val();
				$(this).parents('.project_money1').next().find(point_id).text(money/2);
				update_project(this);
			});
    		
    		$('.project_money2').on( 'keyup',class_name,function(){
				var money = +$(this).val();
				$(this).parents('.project_money2').next().find(point_id).text(money/5);
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
				$(this).parents('.project_money3').next().find(point_id).text((parseInt(money)+parseInt(manage))/5);
				update_project_manage(this);
			});
    		
    		$('.mamage_money1').on( 'keyup',manage_class,function(){
				var manage = +$(this).val();
				var money = $(this).parents('.mamage_money1').next().find(project_class).val();
				$(this).parents('.mamage_money1').next().next().find(point_id).text((parseInt(money)+parseInt(manage))/5);
				update_manage_project(this);
			});
    		
    		$('.project_money4').on( 'keyup',project_class,function(){
				var money = +$(this).val();
				var manage = $(this).parents('.project_money4').prev().find(manage_class).val();
				$(this).parents('.project_money4').next().find(point_id).text((parseInt(money)+parseInt(manage))/2);
				update_project_manage(this);
			});
    		
    		$('.mamage_money2').on( 'keyup',manage_class,function(){
				var manage = +$(this).val();
				var money = $(this).parents('.mamage_money2').next().find(project_class).val();
				$(this).parents('.mamage_money2').next().next().find(point_id).text((parseInt(money)+parseInt(manage))/2);
				update_manage_project(this);
			});
    		
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
    				 			 	
		});
    </script>
</head>
<body>
    <div class="content">
        <form>
            <p>國立臺北科技大學特聘教授近五年內發表之期刊論文統計表(表A)</p>
            <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
		        <tbody>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">學術論著</td>
		                <td colspan="5" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計<br>(A)</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>
		                <td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>
		                <td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>
		                <td colspan="1" width="12%"><label id="year4"><%=json.get("year4")%></label></td>
		                <td colspan="1" width="12%"><label id="year5"><%=json.get("year5")%></label></td>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="3" colspan="1" width="20%">Scopus 或 WOS 資料庫</td>
		                <td colspan="1" width="10%">篇數</td>
		                <td colspan="1" width="12%"><input name="sw_article_count1" type="number" class="ic1" value="<%=json.get("sw_article_count1")%>" size="5" maxlength="40" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="sw_article_count2" type="number" class="ic2" value="<%=json.get("sw_article_count2")%>" size="5" maxlength="40" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="sw_article_count3" type="number" class="ic3" value="<%=json.get("sw_article_count3")%>" size="5" maxlength="40" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="sw_article_count4" type="number" class="ic4" value="<%=json.get("sw_article_count4")%>" size="5" maxlength="40" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="sw_article_count5" type="number" class="ic5" value="<%=json.get("sw_article_count5")%>" size="5" maxlength="40" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="10%" id="sw_article_count_total" class="total_count"><%=json.get("sw_article_count_total")%></td>
		            </tr>
		            <tr style="text-align: center;" class="point">
		                <td colspan="1" width="10%">點數<br>(請參照表B)</td>
		                <td colspan="1" width="12%" id="sw_point1" class="pc1" ><%=json.get("sw_point1")%></td>
		                <td colspan="1" width="12%" id="sw_point2" class="pc2" ><%=json.get("sw_point2")%></td>
		                <td colspan="1" width="12%" id="sw_point3" class="pc3" ><%=json.get("sw_point3")%></td>
		                <td colspan="1" width="12%" id="sw_point4" class="pc4" ><%=json.get("sw_point4")%></td>
		                <td colspan="1" width="12%" id="sw_point5" class="pc5" ><%=json.get("sw_point5")%></td>
		                <td colspan="1" width="10%" id="sw_point_total" class="total_point" ><%=json.get("sw_point_total")%></td>
		            </tr>
		            <tr style="text-align: center;">
		                <td colspan="7" width="80%">說明：採計Scopus論文者，請檢附-表B「傑出論文績效說明表」</td>
		            </tr>
		            <tr style="text-align: center;" class="count1">
		                <td rowspan="2" colspan="1" width="20%">TSSCI/THCI (限設計及人社學院)</td>
		                <td colspan="1" width="10%">篇數</td>
		                <td colspan="1" width="12%"><input name="t_article_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("t_article_count1")%>" style="text-align:center; width: 75px;" ></td>
		                <td colspan="1" width="12%"><input name="t_article_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("t_article_count2")%>" style="text-align:center; width: 75px;" ></td>
		                <td colspan="1" width="12%"><input name="t_article_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("t_article_count3")%>" style="text-align:center; width: 75px;" ></td>
		                <td colspan="1" width="12%"><input name="t_article_count4" type="number" class="ic4" size="5" maxlength="40" value="<%=json.get("t_article_count4")%>" style="text-align:center; width: 75px;" ></td>
		                <td colspan="1" width="12%"><input name="t_article_count5" type="number" class="ic5" size="5" maxlength="40" value="<%=json.get("t_article_count5")%>" style="text-align:center; width: 75px;" ></td>
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
		                <td colspan="1" width="12%"><input name="a_book_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("a_book_count1")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="a_book_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("a_book_count2")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="a_book_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("a_book_count3")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="a_book_count4" type="number" class="ic4" size="5" maxlength="40" value="<%=json.get("a_book_count4")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="a_book_count5" type="number" class="ic5" size="5" maxlength="40" value="<%=json.get("a_book_count5")%>" style="text-align:center; width: 75px;"></td>
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
		                <td colspan="1" width="12%"><input name="a_article_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("a_article_count1")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="a_article_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("a_article_count2")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="a_article_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("a_article_count3")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="a_article_count4" type="number" class="ic4" size="5" maxlength="40" value="<%=json.get("a_article_count4")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="a_article_count5" type="number" class="ic5" size="5" maxlength="40" value="<%=json.get("a_article_count5")%>" style="text-align:center; width: 75px;"></td>
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
		            <tr style="text-align: center;">
		                <td colspan="4" width="54%">近五年FWCI值：<label id="fwci_value_past_five_year"><%=json.get("fwci_value_past_five_year")%></label>，若為本校近五年FWCI值之1.5倍則加計點數10點(B)</td>
		                <td colspan="2" width="24%">總計點數<br>(A)+(B)</td>
		                <td colspan="2" width="22%" id="a_plus_b_total_point" ><%=json.get("a_plus_b_total_point")%></td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">科 技 部 計 畫</td>
		                <td colspan="5" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>
		                <td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>
		                <td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>
		                <td colspan="1" width="12%"><label id="year4"><%=json.get("year4")%></label></td>
		                <td colspan="1" width="12%"><label id="year5"><%=json.get("year5")%></label></td>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="4" colspan="1" width="20%">近五年以本校名義主持科技部各類型計畫統計表</td>
		                <td colspan="1" width="10%">件數</td>
		                <td colspan="1" width="12%"><input name="tech_project_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("tech_project_count1")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_project_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("tech_project_count2")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_project_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("tech_project_count3")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_project_count4" type="number" class="ic4" size="5" maxlength="40" value="<%=json.get("tech_project_count4")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_project_count5" type="number" class="ic5" size="5" maxlength="40" value="<%=json.get("tech_project_count5")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="10%" id="tech_project_count_total" class="total_count"><%=json.get("tech_project_count_total")%></td>
		            </tr>
		            <tr style="text-align: center;" class="project_money1">
		                <td colspan="1" width="10%">計畫金額<br>(萬元)</td>
		                <td colspan="1" width="12%"><input name="tech_project_money1" type="number" class="ip1" size="5" maxlength="40" value="<%=json.get("tech_project_money1")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_project_money2" type="number" class="ip2" size="5" maxlength="40" value="<%=json.get("tech_project_money2")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_project_money3" type="number" class="ip3" size="5" maxlength="40" value="<%=json.get("tech_project_money3")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_project_money4" type="number" class="ip4" size="5" maxlength="40" value="<%=json.get("tech_project_money4")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_project_money5" type="number" class="ip5" size="5" maxlength="40" value="<%=json.get("tech_project_money5")%>" style="text-align:center; width: 75px;"></td>
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
		            
		            <tr>
		                <td colspan="7" width="80%">
		                    <p>說明：</p>
		                    <p>1.不包含科技部產學合作計畫。</p>
		                </td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">教 育 部 計 畫</td>
		                <td colspan="5" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>
		                <td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>
		                <td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>
		                <td colspan="1" width="12%"><label id="year4"><%=json.get("year4")%></label></td>
		                <td colspan="1" width="12%"><label id="year5"><%=json.get("year5")%></label></td>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="3" colspan="1" width="20%">近五年以本校名義主持教育部補助大學在地實踐社會責任計畫</td>
		                <td colspan="1" width="10%">件數</td>
		                <td colspan="1" width="12%"><input name="edu_project_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("edu_project_count1")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="edu_project_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("edu_project_count2")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="edu_project_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("edu_project_count3")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="edu_project_count4" type="number" class="ic4" size="5" maxlength="40" value="<%=json.get("edu_project_count4")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="edu_project_count5" type="number" class="ic5" size="5" maxlength="40" value="<%=json.get("edu_project_count5")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="10%" id="edu_project_count_total" class="total_count"><%=json.get("edu_project_count_total")%></td>
		            </tr>
		            <tr style="text-align: center;" class="project_money2">
		                <td colspan="1" width="10%">計畫金額<br>(萬元)</td>
		                <td colspan="1" width="12%"><input name="edu_project_money1" type="number" class="ip1" size="5" maxlength="40" value="<%=json.get("edu_project_money1")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="edu_project_money2" type="number" class="ip2" size="5" maxlength="40" value="<%=json.get("edu_project_money2")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="edu_project_money3" type="number" class="ip3" size="5" maxlength="40" value="<%=json.get("edu_project_money3")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="edu_project_money4" type="number" class="ip4" size="5" maxlength="40" value="<%=json.get("edu_project_money4")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="edu_project_money5" type="number" class="ip5" size="5" maxlength="40" value="<%=json.get("edu_project_money5")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="10%" id="edu_project_money_total" class="total_project_money"><%=json.get("edu_project_money_total")%></td>
		            </tr>
		            <tr style="text-align: center;" class="point">
		                <td colspan="1" width="10%">點數<br>(<font color="blue">2點/10萬元</font>)</td>
		                <td colspan="1" width="12%" id="edu_project_point1" class="pc1"><%=json.get("edu_project_point1")%></td>
		                <td colspan="1" width="12%" id="edu_project_point2" class="pc2"><%=json.get("edu_project_point2")%></td>
		                <td colspan="1" width="12%" id="edu_project_point3" class="pc3"><%=json.get("edu_project_point3")%></td>
		                <td colspan="1" width="12%" id="edu_project_point4" class="pc4"><%=json.get("edu_project_point4")%></td>
		                <td colspan="1" width="12%" id="edu_project_point5" class="pc5"><%=json.get("edu_project_point5")%></td>
		                <td colspan="1" width="10%" id="edu_project_point_total" class="total_point"><%=json.get("edu_project_point_total")%></td>
		            </tr>
		            
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">產 學 合 作 計 畫</td>
		                <td colspan="5" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>
		                <td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>
		                <td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>
		                <td colspan="1" width="12%"><label id="year4"><%=json.get("year4")%></label></td>
		                <td colspan="1" width="12%"><label id="year5"><%=json.get("year5")%></label></td>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="5" colspan="1" width="20%">近五年以本校名義所獲得之產學合作計畫，其實際納入本校校務基金之統計表</td>
		                <td colspan="1" width="10%">件數</td>
		                <td colspan="1" width="12%"><input name="coop_project_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("coop_project_count1")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="coop_project_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("coop_project_count2")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="coop_project_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("coop_project_count3")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="coop_project_count4" type="number" class="ic4" size="5" maxlength="40" value="<%=json.get("coop_project_count4")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="coop_project_count5" type="number" class="ic5" size="5" maxlength="40" value="<%=json.get("coop_project_count5")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="10%" id="coop_project_count_total" class="total_count"><%=json.get("coop_project_count_total")%></td>
		            </tr>
		            <tr style="text-align: center;" class="mamage_money1">
		                <td colspan="1" width="10%">管理費<br>(萬元)</td>
		                <td colspan="1" width="12%"><input name="coop_project_management1" type="number" class="mp1" size="5" maxlength="40" value="<%=json.get("coop_project_management1")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="coop_project_management2" type="number" class="mp2" size="5" maxlength="40" value="<%=json.get("coop_project_management2")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="coop_project_management3" type="number" class="mp3" size="5" maxlength="40" value="<%=json.get("coop_project_management3")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="coop_project_management4" type="number" class="mp4" size="5" maxlength="40" value="<%=json.get("coop_project_management4")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="coop_project_management5" type="number" class="mp5" size="5" maxlength="40" value="<%=json.get("coop_project_management5")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="10%" id="coop_project_management_total" class="total_manage_money"><%=json.get("coop_project_management_total")%></td>
		            </tr>
		            <tr style="text-align: center;" class="project_money3">
		                <td colspan="1" width="10%">計畫金額<br>(萬元)</td>
		                <td colspan="1" width="12%"><input name="coop_project_money1" type="number" class="ip1" size="5" maxlength="40" value="<%=json.get("coop_project_money1")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="coop_project_money2" type="number" class="ip2" size="5" maxlength="40" value="<%=json.get("coop_project_money2")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="coop_project_money3" type="number" class="ip3" size="5" maxlength="40" value="<%=json.get("coop_project_money3")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="coop_project_money4" type="number" class="ip4" size="5" maxlength="40" value="<%=json.get("coop_project_money4")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="coop_project_money5" type="number" class="ip5" size="5" maxlength="40" value="<%=json.get("coop_project_money5")%>" style="text-align:center; width: 75px;"></td>
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
		            
		            <tr>
		                <td colspan="7" width="80%">
		                    <p>說明：</p>
		                    <p>1.包含科技部產學合作計畫、政府機關及財團法人之研究型計畫。</p>
		                    <p>2. 不包含以學校名義開授訓練課程招生收入。</p>
		                </td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td rowspan="2" colspan="2" width="30%">技 術 移 轉 金</td>
		                <td colspan="5" width="60%" style="text-align: center;">年度</td>
		                <td rowspan="2" width="10%" colspan="1">小計</td>
		            </tr>
		            <tr style="text-align:center;background:  #C0C0C0 ">
		                <td colspan="1" width="12%"><label id="year1"><%=json.get("year1")%></label></td>
		                <td colspan="1" width="12%"><label id="year2"><%=json.get("year2")%></label></td>
		                <td colspan="1" width="12%"><label id="year3"><%=json.get("year3")%></label></td>
		                <td colspan="1" width="12%"><label id="year4"><%=json.get("year4")%></label></td>
		                <td colspan="1" width="12%"><label id="year5"><%=json.get("year5")%></label></td>
		            </tr>
		            <tr style="text-align: center;" class="count">
		                <td rowspan="5" colspan="1" width="20%">近五年以本校名義所獲之實收技術移轉金統計表</td>
		                <td colspan="1" width="10%">件數</td>
		                <td colspan="1" width="12%"><input name="tech_transfer_count1" type="number" class="ic1" size="5" maxlength="40" value="<%=json.get("tech_transfer_count1")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_count2" type="number" class="ic2" size="5" maxlength="40" value="<%=json.get("tech_transfer_count2")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_count3" type="number" class="ic3" size="5" maxlength="40" value="<%=json.get("tech_transfer_count3")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_count4" type="number" class="ic4" size="5" maxlength="40" value="<%=json.get("tech_transfer_count4")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_count5" type="number" class="ic5" size="5" maxlength="40" value="<%=json.get("tech_transfer_count5")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="10%" id="tech_transfer_count_total" class="total_count"><%=json.get("tech_transfer_count_total")%></td>
		            </tr>
		            <tr style="text-align: center;" class="mamage_money2">
		                <td colspan="1" width="10%">管理費<br>(萬元)</td>
		                <td colspan="1" width="12%"><input name="tech_transfer_management1" type="number" class="mp1" size="5" maxlength="40" value="<%=json.get("tech_transfer_management1")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_management2" type="number" class="mp2" size="5" maxlength="40" value="<%=json.get("tech_transfer_management2")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_management3" type="number" class="mp3" size="5" maxlength="40" value="<%=json.get("tech_transfer_management3")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_management4" type="number" class="mp4" size="5" maxlength="40" value="<%=json.get("tech_transfer_management4")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_management5" type="number" class="mp5" size="5" maxlength="40" value="<%=json.get("tech_transfer_management5")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="10%" id="tech_transfer_management_total" class="total_manage_money"><%=json.get("tech_transfer_management_total")%></td>
		            </tr>
		            <tr style="text-align: center;" class="project_money4">
		                <td colspan="1" width="10%">技轉金額<br>(萬元)</td>
		                <td colspan="1" width="12%"><input name="tech_transfer_money1" type="number" class="ip1" size="5" maxlength="40" value="<%=json.get("tech_transfer_money1")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_money2" type="number" class="ip2" size="5" maxlength="40" value="<%=json.get("tech_transfer_money2")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_money3" type="number" class="ip3" size="5" maxlength="40" value="<%=json.get("tech_transfer_money3")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_money4" type="number" class="ip4" size="5" maxlength="40" value="<%=json.get("tech_transfer_money4")%>" style="text-align:center; width: 75px;"></td>
		                <td colspan="1" width="12%"><input name="tech_transfer_money5" type="number" class="ip5" size="5" maxlength="40" value="<%=json.get("tech_transfer_money5")%>" style="text-align:center; width: 75px;"></td>
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
		           
		            <tr>
		                <td colspan="7" width="80%">
		                    <p>說明：</p>
		                    <p>1.包含專利技術移轉金、著作權技術移轉金及知識性技術移轉金。</p>
		                    <p>2.不包含科技部先期技術移轉授權金。</p>
		                </td>
		            </tr>
		            <tr>
		                <td colspan="9" width="100%" style="text-align: center; background: #C0C0C0">其 它 傑 出 表 現 說 明</td>
		            </tr>
		            <tr>
		                <td colspan="9" width="100%">其他資料（例如：擔任國際重要學術學會理監事、國際知名學術期刊編輯/副編輯或評審委員、專利或技術移轉具體績效、獲獎情形及重要會議邀請演講…等）。
                        	<p><textarea style="resize:none;width:100%;height:200px;" name="other_data" ><%=json.get("other_data")%></textarea></p>
                    	</td>
		            </tr>
		            <tr>
		                <td colspan="9" width="100%"><input type="checkbox" name="declaration" >申請人聲明&nbsp;充分瞭解申請要點，且以上所填各項資料與勾選事項皆確實無誤，若有不實本人願負擔所有法律及行政責任。<br><br><br>
		                    <a style="margin-left: 800px">日期:<input type="date" name="commit_date" value="<%=json.get("commit_date")%>"></a>
		                </td>
		            </tr>
		        </tbody>
		    </table>
            <p>
	            <input type="button" name="save" value="存檔" onclick="commit()">
	            <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='DistinguishedProfessorCatalog'"  >
       		</p>
        </form>
    </div>

</body>
</html>
