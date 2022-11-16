<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JSONObject json = (JSONObject) request.getAttribute("json");
%>
<html>
<head>
    <title>國立臺北科技大學特聘教授申請表</title>
    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
    <link rel="stylesheet" type="text/css" href="css/PrintPageStyle.css">
    <style>
        table td.cb{
            border-right: hidden;
            border-top-style: hidden;
            vertical-align: text-top;
            width: 10%;
        }
        table td.checkboxcontent{
            border-top-style: hidden;
        }
        td > p{
            margin: 3rem 0 0;
            text-align: left;
            vertical-align: bottom;
        }
        .footer{
            display: none;
        }
        .requiredField {
            color: red;
        }
    </style>
    <script src="lib/jquery.min.js"></script>
    <script src="js/Function.js"></script>
    <script>
        function reviewed(){
            if("${role}" === "department" || "${role}" === "college" || "${role}" === "researchAndDevelopmentOffice"){
                let data = {};
                let input_data = document.getElementsByClassName("${role}");
                for (let i=0; i<input_data.length; i++){
                    data[input_data[i].id] = input_data[i].value;
                }
                commit(data);
            }
            else{
                location.href="DistinguishedProfessorAppDocInstructions";
            }
        }

        async function save() {
            let data = await InputToJson();
            const dataKeys = Object.keys(data);
            let inputNumber = 0;
            dataKeys.forEach(key => {
                if(data[key].length>0 || data[key]===true || data[key]===false ) {
                    inputNumber++;
                }
            });

            data["fill_rate"] = inputNumber/dataKeys.length;
            commit(data);
        }

        function commit(data){
            if ($("#name").val() && $("#department").val() && $("#hireddate").val() && $("#certificatenum").val() && $("#upgradedate").val() && $("#seniority").val() && $("#email").val() && $("#researchroomext").val() && $("#cellphone").val() &&
                ($("#applicationrequirements1").prop("checked") || $("#applicationrequirements2").prop("checked") || $("#applicationrequirements3").prop("checked")
                || $("#applicationrequirements4").prop("checked") || $("#applicationrequirements5").prop("checked") || $("#applicationrequirements6").prop("checked")
                || $("#applicationrequirements7").prop("checked") || $("#applicationrequirements8").prop("checked") || $("#applicationrequirements9").prop("checked"))) {
                $.ajax({
                    type: 'POST',
                    url: 'DistinguishedProfessorForm',
                    dataType: 'text',
                    data: JSON.stringify(data),
                    success: function(data){
                        alert('存檔成功');
                        if(${readonly}){
                            location.href="DistinguishedProfessorAppDocInstructions";
                        }
                        else {
                            location.reload();
                        }
                    },
                    error:function() {
                        alert("存檔失敗");
                    }
                });
            }
            else {
                alert("尚未填寫完成!");
            }
        };

        function InputToJson(){
            var data = {};

            for (var j=0; j<document.getElementsByTagName("input").length; j++) {
            	if (document.getElementsByTagName("input")[j].type=='checkbox'){
            		data[ document.getElementsByTagName("input")[j].name] = document.getElementsByTagName("input")[j].checked;
                }
            	else if(document.getElementsByTagName("input")[j].name.length > 0){
                    data[ document.getElementsByTagName("input")[j].name] = document.getElementsByTagName("input")[j].value;
                }
            }


            return data;
        }

        
        $( document ).ready(function() {
        	$("input[name='applicationrequirements1']").prop("checked", <%=json.get("applicationrequirements1")%>);
        	$("input[name='applicationrequirements2']").prop("checked", <%=json.get("applicationrequirements2")%>);
        	$("input[name='applicationrequirements3']").prop("checked", <%=json.get("applicationrequirements3")%>);
        	$("input[name='applicationrequirements4']").prop("checked", <%=json.get("applicationrequirements4")%>);
        	$("input[name='applicationrequirements5']").prop("checked", <%=json.get("applicationrequirements5")%>);
        	$("input[name='applicationrequirements6']").prop("checked", <%=json.get("applicationrequirements6")%>);
        	$("input[name='applicationrequirements7']").prop("checked", <%=json.get("applicationrequirements7")%>);
        	$("input[name='applicationrequirements8']").prop("checked", <%=json.get("applicationrequirements8")%>);
        	$("input[name='applicationrequirements9']").prop("checked", <%=json.get("applicationrequirements9")%>);

            setReviewData();
            setReadOnly(<%=request.getAttribute("readonly")%>);

            const role = "${role}";
            if(role === "teacher"){
                $(".review").attr('disabled','disabled');
                $("#apply_footer").show();
                $("#review_footer").remove();
            }
            else{
                $("."+role).removeAttr("disabled");
                $("."+role).prop("readonly", false);
                $("#review_footer").show();
                $("#apply_footer").remove();
            }
        });
        function setReviewData(){
            //department
            $("#department_academic_year").val("<%=json.optString("department_academic_year", "")%>");
            $("#department_semester").val("<%=json.optString("department_semester", "")%>");
            $("#department_conference_times").val("<%=json.optString("department_conference_times", "")%>");
            $("#department_sign_date").val("<%=json.optString("department_sign_date", "")%>");
            //college
            $("#college_academic_year").val("<%=json.optString("college_academic_year", "")%>");
            $("#college_semester").val("<%=json.optString("college_semester", "")%>");
            $("#college_conference_times").val("<%=json.optString("college_conference_times", "")%>");
            $("#college_sign_date").val("<%=json.optString("college_sign_date", "")%>");
            //researchAndDevelopmentOffice
            $("#research_and_development_office_sign_year").val("<%=json.optString("research_and_development_office_sign_year", "")%>");
            $("#research_and_development_office_sign_month").val("<%=json.optString("research_and_development_office_sign_month", "")%>");
            $("#research_and_development_office_sign_date").val("<%=json.optString("research_and_development_office_sign_date", "")%>");
        }
	</script>
</head>

<body>
    <div class="content">
        <form>
            <table>
                <thead>
                <tr>
                    <th colspan="8" class="file_title">國立臺北科技大學特聘教授申請表</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td colspan="2"><span class="requiredField">✱</span>姓名</td>
                        <td colspan="2"><input type="text" id="name" name="name" value=<%=json.get("name")%> ></td>
                        <td colspan="2"><span class="requiredField">✱</span>系所</td>
                        <td colspan="2"><input type="text" id="department" name="department" value=<%=json.get("department")%> ></td>
                    </tr>
                    <tr>
                        <td colspan="2"><span class="requiredField">✱</span>本校任職日期</td>
                        <td colspan="2"><input type="date" id="hireddate" name="hireddate" value=<%=json.get("hireddate")%> ></td>
                        <td colspan="2"><span class="requiredField">✱</span>教授證書號碼</td>
                        <td colspan="2"><input type="text" id="certificatenum" name="certificatenum" value=<%=json.get("certificatenum")%> ></td>
                    </tr>
                    <tr>
                        <td colspan="2"><span class="requiredField">✱</span>教授升等日期</td>
                        <td colspan="2"><input type="date" id="upgradedate" name="upgradedate" value=<%=json.get("upgradedate")%> ></td>
                        <td colspan="2"><span class="requiredField">✱</span>教授年資</td>
                        <td colspan="2"><input type="text" id="seniority" name="seniority" value=<%=json.get("seniority")%> ></td>
                    </tr>
                    <tr>
                        <td colspan="2"><span class="requiredField">✱</span>E-mail</td>
                        <td colspan="2"><input type="text" id="email" name="email" value=<%=json.get("email")%> ></td>
                        <td colspan="2"><span class="requiredField">✱</span>聯絡電話</td>
                        <td colspan="2">
                            研究室分機：<input type="text" id="researchroomext" name="researchroomext" style="max-width: 50%;" value=<%=json.get("researchroomext")%> ><br>
                            手機：<input type="text" id="cellphone" name="cellphone" value=<%=json.get("cellphone")%> >
                        </td>
                    </tr>
                    <tr>
                        <td colspan="8">
                            <label style="font-weight: bold;"><span class="requiredField">✱</span>申請要件（可多選）</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="cb" align="center"><input type="checkbox" id="applicationrequirements1" name="applicationrequirements1" ></td>
                        <td colspan="7" class="checkboxcontent">
                            申請年度之前五年（含）內以本校名義發表之重要學術論著績效點數160點。設計學院及人社學院教師得採計TSSCI/THCI期刊論文；人文、設計、藝術或社會科學領域教師得以學術專書著作或專章申請。（符合本校特聘教授設置辦法第三條第一款）
                        </td>
                   </tr>
                   <tr>
                        <td class="cb" align="center"><input type="checkbox" id="applicationrequirements2" name="applicationrequirements2" ></td>
                        <td colspan="7" class="checkboxcontent">
                            申請年度之前五年(含)內以本校名義所獲得之科技部一般專題計畫(不包含科技部產學合作計畫)績效點數達250點者，其績效點數之計算每10萬元5點。（符合本校特聘教授設置辦法第三條第二款）
                        </td>
                   </tr>
                   <tr>
                        <td class="cb" align="center"><input type="checkbox" id="applicationrequirements3" name="applicationrequirements3" ></td>
                        <td colspan="7" class="checkboxcontent">
                            申請年度之前五年(含)內以本校名義所獲得之教育部補助大學在地實踐社會責任計畫績效點數達80點以上者，其績效點數之計算每10萬元2點。（符合本校特聘教授設置辦法第三條第三款）
                        </td>
                   </tr>
                   <tr>
                        <td class="cb" align="center"><input type="checkbox" id="applicationrequirements4" name="applicationrequirements4" ></td>
                        <td colspan="7" class="checkboxcontent">
                            申請年度之前五年(含)內以本校名義所獲得之產學合作計畫(含科技部產學合作計畫案之廠商配合款金額)績效點數達200點以上且管理費納入校務基金超過150萬元者，其績效點數之計算每10萬元2點。(符合本校特聘教授設置辦法第三條第四款)
                        </td>
                   </tr>
                   <tr>
                        <td class="cb" align="center"><input type="checkbox" id="applicationrequirements5" name="applicationrequirements5" ></td>
                        <td colspan="7" class="checkboxcontent">
                            申請年度之前五年(含)內以本校名義所獲之實收技術移轉金(不包含科技部先期技術移轉授權金)績效點數達100點以上且管理費納入校務基金超過40萬元者，其績效點數之計算每10萬元5點。（符合本校特聘教授設置辦法第三條第五款）
                        </td>
                   </tr>
                   <tr>
                        <td class="cb" align="center"><input type="checkbox" id="applicationrequirements6" name="applicationrequirements6" ></td>
                        <td colspan="7" class="checkboxcontent">
                            曾獲本校「傑出教學獎」2次者。（符合本校特聘教授設置辦法第三條第六款）
                        </td>
                   </tr>
                   <tr>
                        <td class="cb" align="center"><input type="checkbox" id="applicationrequirements7" name="applicationrequirements7" ></td>
                        <td colspan="7" class="checkboxcontent">
                            依本項第(一)、(二)、(三)、(四) 、(五)款所訂之基本條件為基準，其中兩項所計算出來的達成率合計達130%(含)以上、且該兩項之一達成率須達75%(含)以上者。（符合本校特聘教授設置辦法第三條第七款）
                        </td>
                   </tr>
                   <tr>
                        <td class="cb" align="center"><input type="checkbox" id="applicationrequirements8" name="applicationrequirements8" ></td>
                        <td colspan="7" class="checkboxcontent">
                            申請人近五年(含)之其他傑出專業表現，對發揚本校校譽有重大貢獻且經簽准者。（符合本校特聘教授設置辦法第三條第八款）
                        </td>
                   </tr>
                   <tr>
                        <td class="cb" align="center"><input type="checkbox" id="applicationrequirements9" name="applicationrequirements9" ></td>
                        <td colspan="7" class="checkboxcontent">
                            特聘教授三任期滿者，申請終身特聘教授榮銜。（符合本校特聘教授設置辦法第四條）
                        </td>
                    </tr>
                    <tr style="text-align: center;">
                        <td colspan="4">
                            <label>系(所)核章</label>
                        </td>
                        <td colspan="4">
                            <label>學院院長</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <p>
                                本推薦案業經 <input id="department_academic_year" class="department review" maxlength="3" style="width: 5ch;"/> 學年度第 <input id="department_semester" class="department review" maxlength="1" style="width: 3ch;"/> 學期<br>
                                第 <input id="department_conference_times" class="department review" maxlength="5" style="width: 5ch;"/> 次 系&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;會議審議通過<br>
                                （<input id="department_sign_date" class="department review" type="date" style="width: auto;">）
                            </p>
                        </td>
                        <td colspan="4">
                            <p>
                                本推薦案業經 <input id="college_academic_year" class="college review" maxlength="3" style="width: 5ch;"/> 學年度第 <input id="college_semester" class="college review" maxlength="1" style="width: 3ch;"/> 學期<br>
                                第 <input id="college_conference_times" class="college review" maxlength="5" style="width: 5ch;"/> 次 院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;會議審議通過<br>
                                （<input id="college_sign_date" type="date" class="college review" style="width: auto;">）
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: center;">
                            <label>研發處</label>
                        </td>
                        <td colspan="7">
                            <p style="text-align: center;">
                                中 華 民 國
                                <input id="research_and_development_office_sign_year" class="researchAndDevelopmentOffice review" maxlength="3" style="width: 5ch;">年
                                <input id="research_and_development_office_sign_month" class="researchAndDevelopmentOffice review" maxlength="2" style="width: 3ch;">月
                                <input id="research_and_development_office_sign_date" class="researchAndDevelopmentOffice review" maxlength="2" style="width: 3ch;">日
                            </p>
                        </td>
                    </tr>
                </tbody>
            </table>
            <p id="apply_footer" class="footer">
                <button type="button" name="return_last_page" onclick="location.href='DistinguishedProfessorCatalog'">回上頁</button>
                <button type="button" onclick="save()">暫存</button>
            </p>
            <p id="review_footer" class="footer">
                <input type="button" name="go_to_catalog" class="review" value="回目錄" onclick="location.href='DistinguishedProfessorCatalog'" />
                <input type="button" class="review" value="此頁審查完成" onclick="reviewed()" />
            </p>
        </form>
    </div>

</body>
</html>
