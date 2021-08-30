<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="com.google.gson.*" %>

<%  /*避免瀏覽器因cache而無法看到最新資料*/
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE HTML>
<html lang="zh">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/FormStyle.css">
<link rel="stylesheet" type="text/css" href="/css/PrintPageStyle.css">
<div class="content">
    <p class="file_title">※審查資料【填寫說明】</p>
    
    <p>一、 所有申請等級(第一至九級)皆需檢附<a style="font-weight: bold; background: #C0C0C0">表A「五年內傑出績效說明表」</a>。</p>
    <p>二、 以傑出研究奬、特聘教授等奬項申請者，請檢附相關聘書資料影本供參。</p>
    <p>三、 每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附
     其他教師同意書<a style="font-weight: bold;">(共同著作授權同意書)</a>。</p>
    <p>四、 學術論著採計Scopus / WOS論文以本校「教師評鑑及基本資料庫」登錄為準，請檢附表B「傑出論文績效說明表」。並請檢附下列證明文件：</p>
    <p style="margin-left: 4ch;">(一) 期刊發表之論文首頁或以Scopus / WOS資料庫或SciVal分析系統之佐證。</p>
    <p style="margin-left: 4ch;">(二) 各篇期刊排名(以出版年度為準，若無該出版年資料，則以前一年度為準) CiteScore / Journal Ranking、國際學者、企業、SDG之佐證。</p>
    <p style="margin-left: 4ch;">(三) SciVal分析系統之教師近五年FWCI或h-5指數。</p>
    <p>五、 科技部計畫(不包含科技部產學合作計畫)請以本校「教師評鑑及基本資料庫」為準提供相關佐證資料。計畫年度(1/1~12/31)之認定以「計畫開始日期」為準；計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；多年期計畫分年計算單一年度執行金額。</p>
    <p>六、 產學合作計畫(包含科技部產學合作計畫、政府機關及財團法人之研究型專案計畫；不含以學校名義開授訓練課程招生收入) 請以本校「教師評鑑及基本資料庫」為準提供相關佐證資料。計畫年度(1/1~12/31)之認定以「計畫開始日期」為準；計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；多年期計畫分年計算單一年度執行金額。</p>
    <p>七、 技術移轉金(包含專利技術移轉金、著作權技術移轉金及知識性技術移轉金；不包含科技部先期技術移轉授權金)請填列近五年以本校名義所獲得之實收技術移轉金資料(如下表) ，並洽產學合作處技術移轉組確認核章後提出申請。技術移轉金之計算以「實際納入校務基金日期」為準。</p>
    <form method="post" id="c001_form">
        <table border="1" cellpadding="6" cellspacing="1" width="100%" align="center" style="border-spacing:0px;" class="inputForm">
            <thead style="display: table-column; display:none;">
                    <th colspan="1" width="18%">技轉合約名稱</th>
                    <th colspan="1" width="18%">技轉單位(企業)</th>
                    <th colspan="1" width="18%">簽約日期</th>
                    <th colspan="1" width="18%">實收技術移轉金金額</th>
                    <th colspan="1" width="18%">技轉金實際納入校務基金日期</th>
                    <th colspan="1" width="10%"></th>
                </thead>
            <tbody id="data_table" style="text-align: center; display:none;">
            </tbody>
            <tbody style="text-align: center;">
                <tr style="display:none;">
                    <td colspan="6" width="100%"><input type="button" name="add_new_contract" value="  新增  " onclick="add_new_item()"></td>
                </tr>
            </tbody>

        </table>
    </form>
    <div class="footer">
        <input type="button" width="10%" value="回上頁" name="return_last_page" onclick="javascript:location.href='SpecialOutstandingResearcherCatalog'"  >
    </div>
</div>
<script>
    var latest_data = ${latest_data} ;


    function load(){
        showDatas() ;

    }

    $(document).ready( load() );

    function removeData(index){
        datasFromTable();
        if(confirm("您確定要刪除此筆資料嗎?")){
            latest_data["review_supporting_information_list"].splice(index,1);
            showDatas();
            calculateTotal();
        }
        showDatas();
    }

    function add_new_item(){
        datasFromTable();
        var item = {};
        item.contract_name = "";
        item.technology_transfer_unit = "";
        item.contract_date = "";
        item.actually_received_technology_transfer_funds = "";
        item.technical_transfer_funds_include_date = "";
        latest_data["review_supporting_information_list"].push(item);
        showDatas();

    }


    function makeNewItemHtml( i ) {
        var html_of_item = "";
        html_of_item += "<tr>" ;

        html_of_item += "<td colspan='1' width='18%'><input name='contract_name"+i+"' size='10' maxlength='40'></td>" ;
        html_of_item += "<td colspan='1' width='18%'><input name='technology_transfer_unit"+i+"' size='10' maxlength='40'></td>";
        html_of_item += "<td colspan='1' width='18%'><input type='date' name='contract_date"+i+"' ></td>" ;
        html_of_item += "<td colspan='1' width='18%'><input name='actually_received_technology_transfer_funds"+i+"' size='10' maxlength='40'></td>" ;
        html_of_item += "<td colspan='1' width='18%'><input type='date' name='technical_transfer_funds_include_date"+i+"' ></td>" ;
        html_of_item += "<td colspan='1' width='10%'><input type='button' name='delete_contract"+i+"' value='刪除' onclick='removeData("+i+" )'></td>" ;

        html_of_item += "</tr>" ;

        return html_of_item ;
    }



    function datasFromTable(){
        latest_data["review_supporting_information_list"] = [];
        var i=0;
        while($("input[name='contract_name"+i+"']").length>0){
            var item = {};
            item.contract_name = $("input[name='contract_name"+i+"']").val();
            item.technology_transfer_unit = $("input[name='technology_transfer_unit"+i+"']").val();
            item.contract_date = $("input[name='contract_date"+i+"']").val();
            item.actually_received_technology_transfer_funds = $("input[name='actually_received_technology_transfer_funds"+i+"']").val();
            item.technical_transfer_funds_include_date = $("input[name='technical_transfer_funds_include_date"+i+"']").val();


            latest_data["review_supporting_information_list"].push(item);
            i++;
        }

    }

    function showDatas(){
        var html = "";
        var review_supporting_information = latest_data["review_supporting_information_list"];

        for(var i=0;i<review_supporting_information.length;i++){
            var h = "";
            h += makeNewItemHtml( i ) ;
            html+=h;
        }
        if(html=="")
            html = "<tr></tr>";
        $("#data_table").html(html);

        for(var i=0;i<review_supporting_information.length;i++){
            $("input[name='contract_name"+i+"']").val(review_supporting_information[i].contract_name);
            $("input[name='technology_transfer_unit"+i+"']").val(review_supporting_information[i].technology_transfer_unit);
            $("input[name='contract_date"+i+"']").val(review_supporting_information[i].contract_date);
            $("input[name='actually_received_technology_transfer_funds"+i+"']").val(review_supporting_information[i].actually_received_technology_transfer_funds);
            $("input[name='technical_transfer_funds_include_date"+i+"']").val(review_supporting_information[i].technical_transfer_funds_include_date);

        }
    }

    function checkDatas() {
        return true ;
    }

    function InputFormToJson() {
        latest_data["project_id"] = ${projectId} ;

        return JSON.stringify(latest_data) ;
    }

    function saveDatas(){
        if(checkDatas()){
            datasFromTable();

            $.ajax({
                type: 'POST',
                url: 'ReviewSupportingInformationForm',
                dataType: 'text',
                data: { "data": InputFormToJson()},
                //contentType: 'application/text',
                success: function(data){
                    alert('success');
                    location.reload();
                },
                error:function(data){
                    alert("error")
                }
            });

        }
        else{
            alert("有資料格式錯誤或未填寫");
        }
    }
</script>
</html>