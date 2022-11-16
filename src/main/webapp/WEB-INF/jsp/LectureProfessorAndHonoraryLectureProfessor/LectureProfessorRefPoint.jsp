<%--
  Created by IntelliJ IDEA.
  User: CUser
  Date: 2021/2/1
  Time: 下午 01:43
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: CUser
  Date: 2021/2/1
  Time: 下午 01:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="com.google.gson.*" %>

<%@ page import="Bean.Project.RewardProject" %>
<%  /*避免瀏覽器因cache而無法看到最新資料*/
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE HTML>
<html lang="zh">
<link rel="stylesheet" type="text/css" href="css/FormStyle.css">
<script src="js/jquery.min.js"></script>
<div class="container" style="margin: 0px auto; width: 1200px">
    <title>附表一：國立臺北科技大學論文點數計算公式</title>


    <p>每篇論文僅能單一作者提出申請，若有2位或以上本校教師為共同作者，請檢附其他教師同意書。</p>
    <p>論文產出點數的計算公式：</p>
    <p>每篇論文點數=期刊排名(W1) x 作者排序(W2) x 通訊作者數(W3) x 額外加權(W4)</p>
    <p>(一)	期刊排名(W1)：該論文紙本刊登出版當年度Scopus資料庫中CiteScore Ranking或WOS資料庫中Journal Ranking在各次領域排名。</p>
    <table >
        <thead>
        <tr  >
            <td class="metadata" style="width:20%;">期刊排名：R(Ranking)</td>
            <td class="metadata" style="width:10%;">R≦1%</td>
            <td class="metadata" style="width:10%;">1%&lt;R≦5%</td>
            <td class="metadata" style="width:10%;">5%&lt;R≦10%</td>
            <td class="metadata" style="width:10%;">10%&lt;R≦25%</td>
            <td class="metadata" style="width:10%;">25&lt;R≦40%</td>
            <td class="metadata" style="width:10%;">R>40%</td>
        </tr>
        </thead>
        <tbody>
        <tr class="">
            <td>權重1(W1)</td>
            <td align="left"><a>40</a></td>
            <td align="left"><a>20</a></td>
            <td align="left"><a>10</a></td>
            <td align="left"><a>5</a></td>
            <td align="left"><a>2</a></td>
            <td align="left"><a>1</a></td>
        </tbody>
        <thead>
        <tr>
            <th colspan="7" style="width:1000px;">  </th>
        </tr>
        </thead>
    </table>
    <p>註一：論文發表於Nature、Science及Cell國際著名學術期刊或相當等級之論文(不含該出版社子期刊)其每篇W1為150點。</p>
    <p>註二：論文發表於優質期刊（如附件一）其每篇W1為40點。</p>


    <p>(二)	作者排序(W2)：作者排序與相對應的權重。</p>
    <table >
        <thead>
        <tr  >
            <td class="metadata" style="width:20%;">作者排序</td>
            <td class="metadata" style="width:10%;">第一作者或通訊作者</td>
            <td class="metadata" style="width:10%;">第二作者</td>
            <td class="metadata" style="width:10%;">第三作者</td>
            <td class="metadata" style="width:10%;">第四作者</td>
            <td class="metadata" style="width:20%;">第五作者以上</td>
        </tr>
        </thead>
        <tbody>
        <tr class="">
            <td>權重2(W2)</td>
            <td align="left"><a>1</a></td>
            <td align="left"><a>0.8</a></td>
            <td align="left"><a>0.6</a></td>
            <td align="left"><a>0.4</a></td>
            <td align="left"><a>0.2</a></td>
        </tbody>
        <thead>
        <tr>
            <th colspan="6" style="width:1000px;">  </th>
        </tr>
        </thead>
    </table>
    <p>註一：若該篇文章有多位Equal Contribution，其每篇W2為0.9。</p>

    <p>(三)	通訊作者數(W3)：若為通訊作者，且該篇文章有兩位以上通訊作者，則該篇須乘上0.8，惟該篇文章若有國際通訊作者，不算入通訊作者數。</p>
    <table >
        <thead>
        <tr  >
            <td class="metadata" style="width:20%;">通訊作者數</td>
            <td class="metadata" style="width:10%;">1位通訊作者</td>
            <td class="metadata" style="width:50%;">2位(含)以上通訊作(國際通訊作者不計)</td>
        </tr>
        </thead>
        <tbody>
        <tr class="">
            <td>權重3(W3)</td>
            <td align="left"><a>1</a></td>
            <td align="left"><a>0.8</a></td>
        </tbody>
        <thead>
        <tr>
            <th colspan="3" style="width:1000px;">  </th>
        </tr>
        </thead>
    </table>

    <p>(四)	額外加權(W4)：</p>
    <p>1.	若該篇文章與企業合著，則該篇乘上1.1倍。</p>
    <p>2.	若該篇文章與國際學者合著，則該篇乘上1.1倍。</p>
    <p>3.	若該篇文章與企業及國際學者合著，則該篇乘上1.2倍。</p>
    <p>4.	若該論文亦於SSCI發表，則該篇乘上1.5倍。</p>


    <table >
        <thead>
        <tr  >
            <td class="metadata" style="width:20%;">額外加權</td>
            <td class="metadata" style="width:10%;">企業</td>
            <td class="metadata" style="width:10%;">國際學者</td>
            <td class="metadata" style="width:10%;">企業及國際學者</td>
            <td class="metadata" style="width:30%;">SSCI</td>
        </tr>
        </thead>
        <tbody>
        <tr class="">
            <td>權重4(W4)</td>
            <td align="left"><a>1.1</a></td>
            <td align="left"><a>1.1</a></td>
            <td align="left"><a>1.2</a></td>
            <td align="left"><a>1.5</a></td>
        </tbody>
        <thead>
        <tr>
            <th colspan="5" style="width:1000px;">  </th>
        </tr>
        </thead>
    </table>
    <p>註一：若某篇論文為SSCI且有企業及國際合著者，權重至多1.8倍計。</p>
    <p>註二：於Scival資料庫中近五年FWCI值，若為本校近五年FWCI值之1.5倍則加計點數10點。</p>
    <p>(五)	點數計算若有爭議，由委員會決議。</p>
    <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='LectureProfessorCatalog'"  >
</div>
<script>
</script>
</html>
