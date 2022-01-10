<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8"%>
<html lang="zh">
<head>
    <title>年輕學者研究獎 審查資料</title>

    <link rel="stylesheet" type="text/css" href="css/FormStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style type="text/css">
        table{
            table-layout: fixed;
        }
        tr{
            text-align:center;
        }
        td{
            text-align:center;
        }
        input {
            height: 100%;
            width: 100%;
            border-style: initial;
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
    </style>
</head>
<body>
<div name="technologyTransfer" class="content">
    <p class="file_title">年輕學者研究獎 審查資料</p>
    <p>一、每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書<strong>(共同著作授權同意書)</strong>。<p>
    <p>二、學術論著採計Scopus / WOS論文以本校「教師評鑑及基本資料庫」登錄為準，請檢附<strong>「傑出論文績效說明表」</strong>。並請檢附下列證明文件：</p>
    <div style="padding-left: 2rem;">
        <p>(一) 期刊發表之論文首頁或以Scopus / WOS資料庫或SciVal分析系統之佐證。</p>
        <p>(二) 各篇期刊排名(以發表當年度為主) CiteScore / Journal Ranking、國際學者、企業、SDG之佐證。</p>
        <p>(三) SciVal分析系統之教師近三年FWCI或h-5指數。</p>
    </div>
    <p>三、科技部計畫(不包含科技部產學合作計畫)請以本校「教師評鑑及基本資料庫」為準提供相關佐證資料。計畫年度(1/1~12/31)之認定以「計畫開始日期」為準；計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；多年期計畫分年計算單一年度執行金額。</p>
    <p>四、產學合作計畫(包含科技部產學合作計畫、政府機關及財團法人之研究型專案計畫；不含以學校名義開授訓練課程招生收入) 請以教評系統為準提供相關佐證資料。計畫年度(1/1~12/31)之認定以「計畫開始日期」為準；計畫主持人及共同主持人依所執行計畫分配金額計算執行經費；多年期計畫分年計算單一年度執行金額。</p>
    <p>五、技術移轉金(包含專利技術移轉金、著作權技術移轉金及知識性技術移轉金；不包含科技部先期技術移轉授權金)請填列近三年以本校名義所獲得之實收技術移轉金資料(如下表) ，並洽產學合作處技術移轉組確認核章後提出申請。技術移轉金計算以「實際納入校務基金日期」為準。</p>
    <form method="post" id="c001_form">
        <table id="technologyTransfer" style="display:none;">
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
            <button type="button" name="return_last_page" onclick="location.href='JuniorResearchInvestigatorCatalog'">回上頁</button>
        </div>
    </form>
</div>
</body>
</html>
