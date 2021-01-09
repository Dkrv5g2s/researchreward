<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="container" style="margin: 0px auto; width: 1200px">
    <p style="text-align:center;font-weight:bold;font-size:20px;">國立臺北科技大學獎勵特殊優秀研究人才申請表</p>
</div>
<div class="container" style="margin: 0px auto; width: 1200px">
    <form id="c001_form">
        <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <tbody>
<%--            <tr>--%>
<%--                <td colspan="1"><a>申請序號:</a><input type="text" value="研發處填寫" name="project_id" style="display:display;" /></td>--%>
<%--            </tr>--%>
            <tr>
                <td colspan="1" width="20%"><label id="applicant_title">申請人姓名</label>
                    <font color="red">＊</font>
                </td>
                <td colspan="2" width="40%">
                    <input name="applicant_name" value="" size="10" maxlength="40">
                </td>
                <td colspan="1" width="10%">職稱<font color="red">*</font>
                </td>
                <td colspan="2" width="30%">
                    <input name="job" value="" size="10" maxlength="40">
                </td>
            </tr>
            <tr>
                <td colspan="1"><label id="dep_title">所屬單位</label>
                    <font color="red">＊</font>
                </td>
                <td colspan="2">
                    <input name="college" value="" size="10" maxlength="40">&nbsp;學院&nbsp;
                    <input name="department" value="" size="10" maxlength="40">&nbsp;系(所)
                </td>
                <td colspan="1">任職本校年資(計算至上一年度)<font color="red">*</font>
                </td>
                <td colspan="2">
                    <input name="seniority" value="" size="10" maxlength="40">
                </td>
            </tr>
            <tr>
                <td colspan="1"><label id="dep_title">補助起日前一年度是否曾執行科技部計畫</label>
                    <font color="red">＊</font>
                </td>
                <td colspan="5">
                    <input name="executed_tech_proj_yes" type="checkbox" value="true">是。計畫編號:
                    <input name="tech_proj_id" size="10" maxlength="40">&nbsp;執行期間:
                    <input name="tech_proj_start_time" value="" size="10" maxlength="20" type="text" id="d01" readonly><input value="..." type="button" onclick="WdatePicker({el:'d01'})">
                    至
                    <input name="tech_proj_end_time" value="" size="10" maxlength="20" type="text" id="d02" readonly><input value="..." type="button" onclick="WdatePicker({el:'d02'})">
                    <br>
                    <input name="executed_tech_proj_no" type="checkbox">否
                </td>
            </tr>
            <tr>
                <td colspan="6" style="text-align:center;background:  #C0C0C0 ">
                    <a>申請項目(請勾選並檢附傑出績效說明表)</a>
                </td>
            </tr>
            <tr>
                <td colspan="6" style="text-align:center;background:  #C0C0C0 ">
                    ※第一級至第四級請依「<a href="https://rnd.ntut.edu.tw/var/file/42/1042/img/955/510983332.pdf">附表一：本校獎勵特殊優秀研究人才支給標準表</a>」之等級適用標準勾選
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
                    <input type="checkbox" name="main_standard" id="level_five_number_six" value="相當於本級前述各項資格者">6.相當於本級前述各項資格者</td>
            </tr>
            <tr>
                <td colspan="1" name="level_six">第六級</td>
                <td colspan="5">
                    <input type="checkbox" name="main_standard" id="level_six_number_one" value="前一年度獲科技部傑出研究獎">1.前一年度獲科技部傑出研究獎<br>
                    <input type="checkbox" name="main_standard" id="level_six_number_two" value="前一年度獲校外相當於科技部傑出研究獎之重要學術獎勵者">2.前一年度獲校外相當於科技部傑出研究獎之重要學術獎勵者<br>
                    <input type="checkbox" name="main_standard" id="level_six_number_three" value="當年度獲聘為本校專任講座教授者">3.當年度獲聘為本校專任講座教授者<br>
                    <input type="checkbox" name="main_standard" id="level_six_number_four" value="前一年度發表之論文點數達140點以上(不含研討會論文)">4.前一年度發表之論文點數達140點以上(不含研討會論文)<br>
                    <input type="checkbox" name="main_standard" id="level_six_number_five" value="相當於本級前述各項資格者">5.相當於本級前述各項資格者</td>
            </tr>
            <tr>
                <td colspan="1" name="level_seven">第七級</td>
                <td colspan="5">
                    <input type="checkbox" name="main_standard" id="level_seven_number_one" value="當年度獲聘為本校終身特聘教授者">1.當年度獲聘為本校終身特聘教授者<br>
                    <input type="checkbox" name="main_standard" id="level_seven_number_two" value="前一年度獲本校傑出研究獎或傑出產學合作獎且累積次數達二次以上者">2.前一年度獲本校傑出研究獎或傑出產學合作獎且累積次數達二次以上者<br>
                    <input type="checkbox" name="main_standard" id="level_seven_number_three" value="前一年度發表之論文點數達80點以上(不含研討會論文)">3.前一年度發表之論文點數達80點以上(不含研討會論文)<br>
                    <input type="checkbox" name="main_standard" id="level_seven_number_four" value="前一年度以本校名義所獲得之產學合作計畫點數達240點以上且管理費納入校務基金超過150萬元">4.前一年度以本校名義所獲得之產學合作計畫點數達240點以上且管理費納入校務基金超過150萬元<br>
                    <input type="checkbox" name="main_standard" id="level_seven_number_five" value="前一年度以本校名義所獲得之實收技術移轉金點數達175點以上且管理費納入校務基金超過50萬元">5.前一年度以本校名義所獲得之實收技術移轉金點數達175點以上且管理費納入校務基金超過50萬元<br>
                    <input type="checkbox" name="main_standard" id="level_seven_number_six" value="相當於本級前述各項資格者">6.相當於本級前述各項資格者<br>
                    ※ 以本級第4、5項申請者，「傑出績效說明表」請先至產學處確認核章後，再送交各系所審查。
                </td>
            </tr>
            <tr>
                <td colspan="1" name="level_eight_to_nine">第八至第九級</td>
                <td rowspan="1" colspan="5">
                    <input type="checkbox" name="main_standard" id="level_eight_to_night_number_one" value="當年度獲聘為本校特聘教授者">1.當年度獲聘為本校特聘教授者<br>
                    <input type="checkbox" name="main_standard" id="level_eight_to_night_number_two" value="前一年度獲本校傑出研究獎者">2.前一年度獲本校傑出研究獎者<br>
                    <input type="checkbox" name="main_standard" id="level_eight_to_night_number_three" value="前一年度獲本校傑出產學合作獎者">3.前一年度獲本校傑出產學合作獎者<br>
                    <input type="checkbox" name="main_standard" id="level_eight_to_night_number_four" value="在學術研究、產學研究或跨領域研究績效之傑出人員相當於前兩項者">4.在學術研究、產學研究或跨領域研究績效之傑出人員相當於前兩項者<br>
                    <label value="基本門檻：近五年內曾主持科技部各型計畫，並滿足下列條件之一者">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.基本門檻：近五年內曾主持科技部各型計畫，並滿足下列條件之一者:<br>
                    <pre>   <input type="checkbox" name="sub_standard" id="level_eight_to_night_number_five_dash_one" value="近五年以本校名義發表之重要學術論著績效點數12點。設計學院及人社學院教師得採計TSSCI/THCI期刊論文；人文、設計、藝術或社會科學領域教師得以學術專書著作或專章申請。">(1)近五年以本校名義發表之重要學術論著績效點數12點。設計學院及人社學院教師得採計TSSCI/THCI期刊論文；人文、設計、藝術或社會科學領域教師得以學術專書著作或專章申請。</pre>
                    <pre>   <input type="checkbox" name="sub_standard" id="level_eight_to_night_number_five_dash_two" value="以本校名義主持科技部各類型計畫，五年內之總金額，以五年內之計畫總金額為通過標準，其標準由各學院依相關程序訂定之。">(2)以本校名義主持科技部各類型計畫，五年內之總金額，以五年內之計畫總金額為通過標準，其標準由各學院依相關程序訂定之。</pre>
                    <pre>   <input type="checkbox" name="sub_standard" id="level_eight_to_night_number_five_dash_three" value="近五年以本校名義所獲得之產學合作計畫累計總金額超過1000萬元(績效點數200點)且管理費納入校務基金超過150萬元者。">(3)近五年以本校名義所獲得之產學合作計畫累計總金額超過1000萬元(績效點數200點)且管理費納入校務基金超過150萬元者。</pre>
                    <pre>   <input type="checkbox" name="sub_standard" id="level_eight_to_night_number_five_dash_four" value="近五年以本校名義所獲之實收技術移轉金累計總金額超過250萬元(績效點數125點)且管理費納入校務基金超過50萬元者。">(4)近五年以本校名義所獲之實收技術移轉金累計總金額超過250萬元(績效點數125點)且管理費納入校務基金超過50萬元者。</pre>
                    </label>
<%--                    ※ 以本級第5項(3)、(4)申請者，「傑出績效說明表」請先至產學處確認核章後，再送交各系所審查。--%>
            </tr>
<%--            <tr style="background:#C0C0C0">--%>
<%--                <td colspan="1">申請第5項(1)(2)院推薦排序</td>--%>
<%--            </tr>--%>
<%--            <tr style="vertical-align: bottom;">--%>
<%--                <td colspan="1"><br><br><br>(由學院填寫)</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td colspan="2">系、所(簽章)</td>--%>
<%--                <td colspan="2">學院(簽章)</td>--%>
<%--                <td colspan="2">研發處(核備)</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td colspan="2"><input type="checkbox" name="dep_sign">申請資料經審查確認齊備。<br><br><br></td>--%>
<%--                <td colspan="2">本案業經<input name="meeting_time" value="" size="10" maxlength="20" type="text" id="d03" readonly><input value="..." type="button" onclick="WdatePicker({el:'d03'})">學院相關會議審議通過。<br><br><br></td>--%>
<%--                <td colspan="2"><br><br><br></td>--%>
<%--            </tr>--%>

            <tr>
                <td colspan="6" style="background-color:rgb(255, 255, 240);text-align: center">
                    <input type="button" width="10%" value="回上頁" name="return_last_page" onclick="returnIndex" >
                    <input type="button" width="10%" value="存檔" name="save_the_page"  >
                </td>
            </tr>
            </tbody>
        </table>
        <font>※ 本案請經由各學院相關會議審查後，由學院彙整送至研發處提交本校「彈性薪資審查委員會」審議。</font><br>
        <font>※ 以上檢附之相關文件不全或不符規定者，不予受理。</font><br>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>



    function commit(){

        $.ajax({
            type: 'POST',
            url: 'SpecialOutstandingResearcherApplicationForm',
            dataType: 'text',
            data: { "data": InputFormToJson() },   //JSON.stringify(InputToJson())
            //contentType: 'application/text',
            success: function(data){
                alert('success');
            },
            error:function(data){
                alert("error")
            }
        });

    };

    // function InputStandardToJson(){
    //     var standard = {} ;
    //     for (var j=0; j<document.getElementsByTagName("input").length; j++) {
    //         if (document.getElementsByTagName("input")[j].type=='checkbox' && document.getElementsByTagName("input")[j].checked == false){
    //             standard[ "level_num" :  ]
    //             continue;
    //         }
    //     }
    //
    //     for (var j=0; j<document.getElementsByTagName("select").length; j++){
    //         data[ document.getElementsByTagName("select")[j].name] = document.getElementsByTagName("select")[j].value;
    //     }
    //
    //     return JSON.stringify(data)
    //
    //     return data;
    // }

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

                // alert( level_name ) ;
                // alert( standard_content ) ;
                // alert( sub_standard_content ) ;

                var a_tuple_of_standard = { "level_num" : level_name, "standard" : standard_content, "sub_standard" : sub_standard_content } ;
                list_of_standard.push(a_tuple_of_standard) ;
               // alert(list_of_standard[0]);

            }else if ( document.getElementsByTagName("input")[j].type !='checkbox' ) {
                data[ document.getElementsByTagName("input")[j].name] = document.getElementsByTagName("input")[j].value;
            }

        }

        for (var j=0; j<document.getElementsByTagName("select").length; j++){
            data[ document.getElementsByTagName("select")[j].name] = document.getElementsByTagName("select")[j].value;
        }

        data["stantard_list"] = list_of_standard ;
        return JSON.stringify(data)

        //return data;
    }

    $(document).on( "click", "input[name='save_the_page']", function() {
        commit();
    } ) ;



</script>
</html>