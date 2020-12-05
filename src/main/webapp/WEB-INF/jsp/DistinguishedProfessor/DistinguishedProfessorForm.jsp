<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>國立臺北科技大學特聘教授申請表</title>
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

    </style>
</head>
<body>
    <div class="content">
        <form>
            <p>國立臺北科技大學特聘教授申請表</p>
            <table>
                <tbody>
                    <tr>
                        <td class="metadata">姓名</td>
                        <td><input type="text" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">系所</td>
                        <td><input type="text" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">本校任職日期</td>
                        <td><input type="date"></td>
                    </tr>
                    <tr>
                        <td class="metadata">教授證書號碼</td>
                        <td><input type="text" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">教授升等日期</td>
                        <td><input type="date"></td>
                    </tr>
                    <tr>
                        <td class="metadata">教授年資</td>
                        <td><input type="text" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">E-mail</td>
                        <td><input type="text" required></td>
                    </tr>
                    <tr>
                        <td class="metadata">聯絡電話</td>
                        <td>
                        	<p>研究室分機：<input type="text" required></p>
                        	<p>手機：<input type="text" required></p>
                        </td>
                    </tr>
                </tbody>
            </table>
            <p>申請要件（可多選）</p>
            <table>
               <tbody>
               <tr>
               		<td class="cb" align="center"><input type="checkbox"></td>
		            <td class="checkboxcontent">
		            	申請年度之前五年（含）內以本校名義發表之重要學術論著績效點數160點。設計學院及人社學院教師得採計TSSCI/THCI期刊論文；人文、設計、藝術或社會科學領域教師得以學術專書著作或專章申請。（符合本校特聘教授設置辦法第三條第一款）
		            </td>
		       </tr>
		       <tr>
		       		<td class="cb" align="center"><input type="checkbox"></td>
		            <td class="checkboxcontent">
		            	 申請年度之前五年(含)內以本校名義所獲得之科技部一般專題計畫(不包含科技部產學合作計畫)績效點數達250點者，其績效點數之計算每10萬元5點。（符合本校特聘教授設置辦法第三條第二款）
		            </td>
		       </tr>
		       <tr>
		       		<td class="cb" align="center"><input type="checkbox"></td>
		            <td class="checkboxcontent">
		            	 申請年度之前五年(含)內以本校名義所獲得之教育部補助大學在地實踐社會責任計畫績效點數達80點以上者，其績效點數之計算每10萬元2點。（符合本校特聘教授設置辦法第三條第三款）
		            </td>
		       </tr>
		       <tr>
		       		<td class="cb" align="center"><input type="checkbox"></td>
		            <td class="checkboxcontent">
		            	 申請年度之前五年(含)內以本校名義所獲得之產學合作計畫(含科技部產學合作計畫案之廠商配合款金額)績效點數達200點以上且管理費納入校務基金超過150萬元者，其績效點數之計算每10萬元2點。(符合本校特聘教授設置辦法第三條第四款)
		            </td>
		       </tr>
		       <tr>
		       		<td class="cb" align="center"><input type="checkbox"></td>
		            <td class="checkboxcontent">
		            	 申請年度之前五年(含)內以本校名義所獲之實收技術移轉金(不包含科技部先期技術移轉授權金)績效點數達100點以上且管理費納入校務基金超過40萬元者，其績效點數之計算每10萬元5點。（符合本校特聘教授設置辦法第三條第五款）
		            </td>
		       </tr>
		       <tr>
		       		<td class="cb" align="center"><input type="checkbox"></td>
		            <td class="checkboxcontent">
		            	 曾獲本校「傑出教學獎」2次者。（符合本校特聘教授設置辦法第三條第六款）
		            </td>
		       </tr>
		       <tr>
		       		<td class="cb" align="center"><input type="checkbox"></td>
		            <td class="checkboxcontent">
		            	 依本項第(一)、(二)、(三)、(四) 、(五)款所訂之基本條件為基準，其中兩項所計算出來的達成率合計達130%(含)以上、且該兩項之一達成率須達75%(含)以上者。（符合本校特聘教授設置辦法第三條第七款）
		            </td>
		       </tr>
		       <tr>
		       		<td class="cb" align="center"><input type="checkbox"></td>
		            <td class="checkboxcontent">
		            	 申請人近五年(含)之其他傑出專業表現，對發揚本校校譽有重大貢獻且經簽准者。（符合本校特聘教授設置辦法第三條第八款）
		            </td>
		       </tr>
		       <tr>
		       		<td class="cb" align="center"><input type="checkbox"></td>
		            <td class="checkboxcontent">
		            	 特聘教授三任期滿者，申請終身特聘教授榮銜。（符合本校特聘教授設置辦法第四條）
		            </td>
		       </tr>
              </tbody>
            </table>
            <p><input type="button" name="confirm" value="確定"></p>
        </form>
    </div>

</body>
</html>
