<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="fr.opensagres.xdocreport.document.json.JSONObject" %>
<%
    JSONObject jsonObject = (JSONObject) request.getAttribute("date_info");
%>

<html lang="zh">
<link rel="stylesheet" type="text/css" href="css/FormStyle.css">
<link rel="stylesheet" type="text/css" href="css/PrintPageStyle.css">
<style>
    .pre{
        margin-left: 2rem;
        font-size: small;
    }
    .pre > input{
        margin-left: 0;
        vertical-align: top;
    }
    .requiredField {
        color: red;
    }
</style>
<div class="content" >
    <p class="file_title">國立臺北科技大學<label name='year'><%= jsonObject.getInt("year")%></label>年度獎勵特殊優秀研究人才申請表</p>
    <form id="c001_form">
        <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <tbody>
            <tr>
                <td colspan="1" width="20%"><label id="applicant_title"><span class="requiredField">✱</span>申請人姓名</label>
                </td>
                <td colspan="2" width="30%">
                    <input id="applicant_name" name="applicant_name" value="" size="10" maxlength="40">
                </td>
                <td colspan="1" width="25%"><span class="requiredField">✱</span>職稱
                </td>
                <td colspan="2" width="25%">
                    <input id="job" name="job" value="" size="10" maxlength="40">
                </td>
            </tr>
            <tr>
                <td colspan="1"><label id="dep_title"><span class="requiredField">✱</span>所屬單位</label>
                </td>
                <td colspan="2">
                    <input id="college" name="college" value="" size="10" maxlength="40">&nbsp;學院&nbsp;
                    <input id="department" name="department" value="" size="10" maxlength="40">&nbsp;系(所)
                </td>
                <td colspan="1"><span class="requiredField">✱</span>任職本校年資(計算至<label name='seniority_end'><%= jsonObject.getDate("seniority")%></label>止)
                </td>
                <td colspan="2">
                    <input id="seniority" name="seniority" value="" size="10" maxlength="40">
                </td>
            </tr>
            <tr>
                <td colspan="1"><label><span class="requiredField">✱</span>補助起日前一年(<label name='mostStart'><%= jsonObject.getDate("mostStart")%></label>~<label name='mostEnd'><%= jsonObject.getDate("mostEnd")%></label>)是否曾執行科技部計畫</label>
                </td>
                <td colspan="5" style="line-height: 2;">
                    <input id="executed_tech_proj_yes" name="executed_tech_proj_yes" type="checkbox" >是。
                    計畫名稱：<input id="tech_proj_name" name="tech_proj_name" size="30" maxlength="45">
                    <br>
                    計畫編號:<input id="tech_proj_id" name="tech_proj_id" size="10" maxlength="40">
                    &nbsp;執行期間:<input type="date" id="tech_proj_start_time" name="tech_proj_start_time" size="10" maxlength="20" id="d01" >
                    至<input type="date" id="tech_proj_end_time" name="tech_proj_end_time" size="10" maxlength="20" id="d02" >
                    <br>
                    <input id="executed_tech_proj_no" name="executed_tech_proj_no" type="checkbox">否
                </td>
            </tr>
            <tr>
                <td colspan="6" style="text-align:center;background:  #C0C0C0 ">
                    <a><span class="requiredField">✱</span>申請項目(請勾選並檢附傑出績效說明表)</a>
                </td>
            </tr>
            <tr>
                <td colspan="6" style="text-align:center;background:  #C0C0C0 ">
                    ※第一級至第四級請依「<a href="https://rnd.ntut.edu.tw/var/file/42/1042/img/955/312758612.pdf#page=3">附表一：本校獎勵特殊優秀研究人才支給標準表</a>」之等級適用標準勾選
                </td>
            </tr>
            <!-- <tr>
                <td colspan="1">第一級至第四級</td>
                <td colspan="5">申請級數:第<input name="level" size="2" maxlength="2">級&nbsp;第<input name="item_num" size="2" maxlength="2">項<br>
                    適用標準:<input name="standard" size="20" maxlength="40"><br>
                </td>
            </tr> -->
            <tr>
                <td colspan="1" name="level_one">第一級</td>
                <td colspan="5">
                    <input type="checkbox" name="main_standard" id="level_one_number_one" value="諾貝爾獎得獎人">1.諾貝爾獎得獎人<br>
            </tr>
            <tr>
                <td colspan="1" name="level_two">第二級</td>
                <td colspan="5">
                    <input type="checkbox" name="main_standard" id="level_two_number_one" value="中央研究院院士">1.中央研究院院士<br>
                    <input type="checkbox" name="main_standard" id="level_two_number_two" value="相當於中央研究院院士級者">2.相當於中央研究院院士級者<br>
            </tr>
            <tr>
                <td colspan="1" name="level_three">第三級</td>
                <td colspan="5">
                    <input type="checkbox" name="main_standard" id="level_three_number_one" value="曾獲教育部國家講座者">1.曾獲教育部國家講座者<br>
                    <input type="checkbox" name="main_standard" id="level_three_number_two" value="曾獲相當於前項講座者">2.曾獲相當於前項講座者<br>
            </tr>
            <tr>
                <td colspan="1" name="level_four" >第四級</td>
                <td colspan="5">
                    <input type="checkbox" name="main_standard" id="level_four_number_one" value="曾獲教育部學術獎者">1.曾獲教育部學術獎者<br>
                    <input type="checkbox" name="main_standard" id="level_four_number_two" value="曾獲行政院傑出科技貢獻獎者">2.曾獲行政院傑出科技貢獻獎者<br>
                    <input type="checkbox" name="main_standard" id="level_four_number_three" value="曾獲相當於本級前兩獎項者">3.曾獲相當於本級前兩獎項者<br>
            </tr>
            <tr>
                <td colspan="1" name="level_five" >第五級</td>
                <td colspan="5">
                    <input type="checkbox" name="main_standard" id="level_five_number_one" value="國際知名之國家院士">1.國際知名之國家院士<br>
                    <input type="checkbox" name="main_standard" id="level_five_number_two" value="曾（現）任國際著名大學之講座">2.曾（現）任國際著名大學之講座<br>
                    <input type="checkbox" name="main_standard" id="level_five_number_three" value="前一年度獲科技部傑出研究獎且累積次數達二次以上">3.前一年度獲科技部傑出研究獎且累積次數達二次以上<br>
                    <input type="checkbox" name="main_standard" id="level_five_number_four" value="當年度獲聘為本校終身講座教授者">4.當年度獲聘為本校終身講座教授者<br>
                    <input type="checkbox" name="main_standard" id="level_five_number_five" value="前一年度發表之論文點數達250點以上(不含研討會論文)">5.前一年度發表之論文點數達250點以上(不含研討會論文)<br>
            </tr>
            <tr>
                <td colspan="1" name="level_six">第六級</td>
                <td colspan="5">
                    <input type="checkbox" name="main_standard" id="level_six_number_one" value="前一年度獲科技部傑出研究獎">1.前一年度獲科技部傑出研究獎<br>
                    <input type="checkbox" name="main_standard" id="level_six_number_two" value="當年度獲聘為本校專任講座教授者">2.當年度獲聘為本校專任講座教授者<br>
                    <input type="checkbox" name="main_standard" id="level_six_number_three" value="前一年度發表之論文點數達140點以上(不含研討會論文)">3.前一年度發表之論文點數達140點以上(不含研討會論文)<br>
            </tr>
            <tr>
                <td colspan="1" name="level_seven">第七級</td>
                <td colspan="5">
                    <input type="checkbox" name="main_standard" id="level_seven_number_one" value="當年度獲聘為本校終身特聘教授者">1.當年度獲聘為本校終身特聘教授者<br>
                    <input type="checkbox" name="main_standard" id="level_seven_number_two" value="前一年度獲本校傑出研究獎或傑出產學合作獎且累積次數達二次以上者">2.前一年度獲本校傑出研究獎或傑出產學合作獎且累積次數達二次以上者<br>
                    <input type="checkbox" name="main_standard" id="level_seven_number_three" value="前一年度發表之論文點數達80點以上(不含研討會論文)">3.前一年度發表之論文點數達80點以上(不含研討會論文)<br>
                    <input type="checkbox" name="main_standard" id="level_seven_number_four" value="前一年度以本校名義所獲得之產學合作計畫點數達240點以上且管理費納入校務基金超過150萬元">4.前一年度以本校名義所獲得之產學合作計畫點數達240點以上且管理費納入校務基金超過150萬元<br>
                    <input type="checkbox" name="main_standard" id="level_seven_number_five" value="前一年度以本校名義所獲得之實收技術移轉金點數達175點以上且管理費納入校務基金超過50萬元">5.前一年度以本校名義所獲得之實收技術移轉金點數達175點以上且管理費納入校務基金超過50萬元<br>
                    ※ 以本級第4、5項申請者，「傑出績效說明表」請先至產學處確認核章後，再送交各系所審查。
                </td>
            </tr>
            <tr>
                <td colspan="1" name="level_eight_to_nine">第八至第九級</td>
                <td rowspan="3" colspan="5">
                    <input type="checkbox" name="main_standard" id="level_eight_to_night_number_one" value="當年度獲聘為本校特聘教授者">1.當年度獲聘為本校特聘教授者<br>
                    <input type="checkbox" name="main_standard" id="level_eight_to_night_number_two" value="前一年度獲本校傑出研究獎者">2.前一年度獲本校傑出研究獎者<br>
                    <input type="checkbox" name="main_standard" id="level_eight_to_night_number_three" value="前一年度獲本校傑出產學合作獎者">3.前一年度獲本校傑出產學合作獎者<br>
                    <label style="margin-left: 0.5em;" value="基本門檻：近五年內曾主持科技部各型計畫，並滿足下列條件之一者">4.基本門檻：近五年內曾主持科技部各型計畫，並滿足下列條件之一者:<br>
                    <div class="pre"><input type="checkbox" name="sub_standard" id="level_eight_to_night_number_four_dash_one" value="近五年以本校名義發表之重要學術論著績效點數12點。設計學院及人社學院教師得採計TSSCI/THCI期刊論文；人文、設計、藝術或社會科學領域教師得以學術專書著作或專章申請。">(1)近五年以本校名義發表之重要學術論著績效點數12點。設計學院及人社學院教師得採計TSSCI/THCI期刊論文；人文、設計、藝術或社會科學領域教師得以學術專書著作或專章申請。</div>
                    <div class="pre"><input type="checkbox" name="sub_standard" id="level_eight_to_night_number_four_dash_two" value="以本校名義主持科技部各類型計畫，五年內之總金額，以五年內之計畫總金額為通過標準，其標準由各學院依相關程序訂定之。">(2)以本校名義主持科技部各類型計畫，五年內之總金額，以五年內之計畫總金額為通過標準，其標準由各學院依相關程序訂定之。</div>
                    <div class="pre"><input type="checkbox" name="sub_standard" id="level_eight_to_night_number_four_dash_three" value="近五年以本校名義所獲得之產學合作計畫累計總金額超過1000萬元(績效點數200點)且管理費納入校務基金超過150萬元者。">(3)近五年以本校名義所獲得之產學合作計畫累計總金額超過1000萬元(績效點數200點)且管理費納入校務基金超過150萬元者。</div>
                    <div class="pre"><input type="checkbox" name="sub_standard" id="level_eight_to_night_number_four_dash_four" value="近五年以本校名義所獲之實收技術移轉金累計總金額超過250萬元(績效點數125點)且管理費納入校務基金超過50萬元者。">(4)近五年以本校名義所獲之實收技術移轉金累計總金額超過250萬元(績效點數125點)且管理費納入校務基金超過50萬元者。</div>
                    </label>
                    <p>※ 以本級第4項(3)、(4)申請者，「傑出績效說明表」請先至產學處確認核章後，再送交各系所審查。</p>
            </tr>
            <tr>
                <td for="college_recommended_order" style="background: #C0C0C0;">
                    申請第4項(1)(2)院推薦排序
                </td>
            </tr>
            <tr>
                <td><input class="college" name="college_recommended_order" size="10" maxlength="5" disabled></td>
            </tr>
            <tr>
                <td colspan="1" name="additional_item" style="color:red;">額外項目</td>
                <td colspan="5">
                    <input type="checkbox" name="main_standard" id="additional_item_number_one" value="前一年度主持科技部雙邊協議國際合作研究計畫者(請檢附證明)。">1.前一年度主持<b>科技部雙邊協議國際合作研究計畫</b>者(請檢附證明)。<br>
                    ※ 本項不得單獨勾選，須配合上述各等級申請。
                </td>
            </tr>
            <tr>
                <td colspan="2" width="33%">系、所(簽章)</td>
                <td colspan="2" width="33%">學院(簽章)</td>
                <td colspan="2" width="33%">研發處(核備)</td>
            </tr>
            <tr>
                <td colspan="2"><input class="department" type="checkbox" name="department_review" disabled>申請資料經審查確認齊備。<br><br><br></td>
                <td colspan="2">本案業經<input class="college" type="date" name="college_review_date" id="d03" disabled>學院相關會議審議通過。<br><br><br></td>
                <td colspan="2"><input class="researchAndDevelopmentOffice" type="date" name="research_office_review_date" value="" size="10" maxlength="20" type="text" id="d04" disabled><br><br><br></td>
            </tr>
            </tbody>
        </table>
        <div style="font-size: smaller;">
            <label>※ 本案請經由各學院相關會議審查後，由學院彙整送至研發處提交本校「彈性薪資審查委員會」審議。</label><br>
            <label>※ 以上檢附之相關文件不全或不符規定者，不予受理。</label>
        </div>
        <div class="footer">
            <button type="button" width="10%" name="return_last_page" onclick="javascript:location.href='SpecialOutstandingResearcherCatalog'">回上頁</button>
            <button type="button" width="10%" name="save_the_page">暫存</button>
        </div>
    </form>
</div>

<script src="js/jquery.min.js"></script>
<script>

    function load() {
        var last_version_of_form = ${ latest_data } ;
        restore_latest_data( last_version_of_form ) ;
    }

    $(document).ready( load()  ) ;

    function restore_latest_data ( last_version_of_form ) {
        $("input[name='applicant_name']").val( last_version_of_form["applicant_name"] ) ;
        $("input[name='job']").val( last_version_of_form["job"] ) ;
        $("input[name='college']").val( last_version_of_form["college"] ) ;
        $("input[name='department']").val( last_version_of_form["department"] ) ;
        $("input[name='seniority']").val( last_version_of_form["seniority"] ) ;
        if ( last_version_of_form["executed_tech_proj"] ) {
            $("input[name='executed_tech_proj_yes']").prop( "checked",last_version_of_form["executed_tech_proj"]  ) ;
            $("input[name='tech_proj_name']").val( last_version_of_form["tech_proj_name"] ) ;
            $("input[name='tech_proj_id']").val( last_version_of_form["tech_proj_id"] ) ;
            $("input[name='tech_proj_start_time']").val( last_version_of_form["tech_proj_start_time"]  ) ;
            $("input[name='tech_proj_end_time']").val( last_version_of_form["tech_proj_end_time"]  ) ;
        }
        else {
            $("input[name='executed_tech_proj_yes']").prop( "checked",false  ) ;
            $("input[name='executed_tech_proj_no']").prop( "checked",true  ) ;
        }

        standard_list = last_version_of_form["standard_list"] ;
        for ( var i = 0; i < standard_list.length ; i++ ) {

            enable_standard( standard_list[i]["standard"] ) ;
            enable_standard( standard_list[i]["sub_standard"] ) ;
        }
    }

    function enable_standard( standard ) {
        $( "input[value='" + standard + "']" ).prop("checked", true) ;

    }

    function commit(){
        if ($("#applicant_name").val() && $("#job").val() && $("#college").val() && $("#department").val() && $("#seniority").val() && checkExecutedTechProj() && checkAllCheckbox()) {
            $.ajax({
                type: 'POST',
                url: 'SpecialOutstandingResearcherApplicationForm',
                dataType: 'text',
                data: {"data": InputFormToJson(), "func": "save"},
                success: function (data) {
                    alert('success');
                    location.reload();
                },
                error: function (data) {
                    alert("error")
                }
            });
        }
        else {
            alert("尚未填寫完成!");
        }
    }

    function checkExecutedTechProj() {
        return (($("#executed_tech_proj_yes").prop("checked") && $("#tech_proj_name").val() && $("#tech_proj_id").val() && $("#tech_proj_start_time").val() && $("#tech_proj_end_time").val())
                || $("#executed_tech_proj_no").prop("checked"));
    }

    function checkAllCheckbox() {
        return ($("#level_one_number_one").prop("checked")
            || $("#level_two_number_one").prop("checked") || $("#level_two_number_two").prop("checked")
            || $("#level_three_number_one").prop("checked") || $("#level_three_number_two").prop("checked")
            || $("#level_four_number_one").prop("checked") || $("#level_four_number_two").prop("checked") || $("#level_four_number_three").prop("checked")
            || $("#level_five_number_one").prop("checked") || $("#level_five_number_two").prop("checked") || $("#level_five_number_three").prop("checked")
            || $("#level_five_number_four").prop("checked") || $("#level_five_number_five").prop("checked")
            || $("#level_six_number_one").prop("checked") || $("#level_six_number_two").prop("checked") || $("#level_six_number_three").prop("checked")
            || $("#level_seven_number_one").prop("checked") || $("#level_seven_number_two").prop("checked") || $("#level_seven_number_three").prop("checked")
            || $("#level_seven_number_four").prop("checked") || $("#level_seven_number_five").prop("checked")
            || $("#level_eight_to_night_number_one").prop("checked") || $("#level_eight_to_night_number_two").prop("checked") || $("#level_eight_to_night_number_three").prop("checked")
            || $("#level_eight_to_night_number_four_dash_one").prop("checked") || $("#level_eight_to_night_number_four_dash_two").prop("checked") || $("#level_eight_to_night_number_four_dash_three").prop("checked")
            || $("#level_eight_to_night_number_four_dash_four").prop("checked"));
    }

    function InputFormToJson(){

        var data = {};
        var list_of_standard = [] ;
        for (var j=0; j<document.getElementsByTagName("input").length; j++) {
            if (document.getElementsByTagName("input")[j].type=='checkbox' && document.getElementsByTagName("input")[j].checked == true){
                var level_name = document.getElementsByTagName("input")[j].parentElement.previousElementSibling.getAttribute("name") ;
                var standard_content = document.getElementsByTagName("input")[j].value ;
                var sub_standard_content ="None";
                if ( document.getElementsByTagName("input")[j].getAttribute("name") =="sub_standard" ) {
                    level_name = document.getElementsByTagName("input")[j].parentElement.parentElement.parentElement.previousElementSibling.getAttribute("name");
                    sub_standard_content = standard_content ;
                    standard_content = document.getElementsByTagName("input")[j].parentElement.parentElement.getAttribute("value") ;
                }

                var a_tuple_of_standard = { "level_num" : level_name, "standard" : standard_content, "sub_standard" : sub_standard_content } ;
                list_of_standard.push(a_tuple_of_standard) ;

            }else if ( document.getElementsByTagName("input")[j].type !='checkbox' && document.getElementsByTagName("input")[j].name !='executed_tech_proj_yes' ) {
                data[ document.getElementsByTagName("input")[j].name] = document.getElementsByTagName("input")[j].value;
            }

        }

        for (var j=0; j<document.getElementsByTagName("select").length; j++){
            data[ document.getElementsByTagName("select")[j].name] = document.getElementsByTagName("select")[j].value;
        }

        data["executed_tech_proj"] = $("input[name='executed_tech_proj_yes']").prop('checked') ;
        data["fill_rate"] = getFillRate(data);
        data["standard_list"] = list_of_standard ;
        data["project_id"] = ${projectId} ;
        return JSON.stringify(data)
    }

    function getFillRate(data){
        let dataKeys = Object.keys(data);
        let dataLength = dataKeys.length;
        let executedTechProj = data["executed_tech_proj"];
        let dataNumber = executedTechProj ? dataLength : dataLength-4;
        let inputNumber = 0;
        for(let i=0; i<dataLength; i++){
            let dataKey = dataKeys[i];
            let dataValue = data[dataKey];
            if(dataValue===true || dataValue===false || dataValue.length>0){
                if(executedTechProj) {
                    inputNumber++;
                }
                else if(dataKey != "tech_proj_name" || dataKey != "tech_proj_id" || dataKey != "tech_proj_start_time" || dataKey != "tech_proj_end_time"){
                    inputNumber++;
                }
            }
        }
        return inputNumber/(dataNumber-3);//review input-3
    }

    $(document).on( "click", "button[name='save_the_page']", function() {
        commit();
    } ) ;

    function clear_executed_tech_proj_yes(){
        if ( $("input[name='executed_tech_proj_no']").prop('checked') ) {
            $("input[name='executed_tech_proj_yes']").prop( "checked", false ) ;
            $("input[name='tech_proj_name']").val("") ;
            $("input[name='tech_proj_id']").val("") ;
            $("input[name='tech_proj_start_time']").val("") ;
            $("input[name='tech_proj_end_time']").val("") ;
        }
        
    }

    function clear_executed_tech_proj_no(){
        if ( $("input[name='executed_tech_proj_yes']").prop('checked')  )
            $("input[name='executed_tech_proj_no']").prop( 'checked', false ) ;
    }

    $(document).on( "click", "input[name='executed_tech_proj_no']", function(){
        clear_executed_tech_proj_yes() ;
    } ) ;

    $(document).on( "click", "input[name='executed_tech_proj_yes']", function(){
        clear_executed_tech_proj_no() ;
    } ) ;


</script>
</html>