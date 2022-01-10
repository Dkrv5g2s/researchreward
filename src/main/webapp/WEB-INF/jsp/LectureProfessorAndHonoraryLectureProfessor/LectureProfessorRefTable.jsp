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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<div class="container" style="margin: 0px auto; width: 1200px">

    <title>附件一：優質期刊清單</title>
    <table >
        <thead>
        <tr  >
            <td class="metadata" style="width:20%;">編號</td>
            <td class="metadata" style="width:40%;">期刊名稱</td>
        </tr>
        </thead>
        <tbody>
        <tr class="">
            <td>1	</td>
            <td align="left"><a>Neuron</a></td>
        </tr>
        <tr class="">
            <td>2	</td>
            <td align="left"><a>Nature Biotechnology</a></td>
        </tr>
        <tr class="">
            <td>3	</td>
            <td align="left"><a>Nature Chemical Biology</a></td>
        </tr>
        <tr class="">
            <td>4	</td>
            <td align="left"><a>Nature Chemistry</a></td>
        </tr>
        <tr class="">
            <td>5	</td>
            <td align="left"><a>Nature Communications</a></td>
        </tr>
        <tr class="">
            <td>6	</td>
            <td align="left"><a>Nature Climate Change</a></td>
        </tr>
        <tr class="">
            <td>7	</td>
            <td align="left"><a>Nature Cell Biology</a></td>
        </tr>
        <tr class="">
            <td>8	</td>
            <td align="left"><a>Nature Materials</a></td>
        </tr>
        <tr class="">
            <td>9	</td>
            <td align="left"><a>Nature Medicine</a></td>
        </tr>
        <tr class="">
            <td>10</td>
            <td align="left"><a>Nature Nanotechnology</a></td>
        </tr>
        <tr class="">
            <td>11</td>
            <td align="left"><a>Nature Neuroscience</a></td>
        </tr>
        <tr class="">
            <td>12</td>
            <td align="left"><a>Nature Photonics</a></td>
        </tr>
        <tr class="">
            <td>13</td>
            <td align="left"><a>Nature Physics</a></td>
        </tr>
        <tr class="">
            <td>14</td>
            <td align="left"><a>Nature Structural & Molecular Biology</a></td>
        </tr>
        <tr class="">
            <td>15</td>
            <td align="left"><a>Nature Genetics</a></td>
        </tr>
        <tr class="">
            <td>16</td>
            <td align="left"><a>Nature Geoscience</a></td>
        </tr>
        <tr class="">
            <td>17</td>
            <td align="left"><a>Nature Immunology</a></td>
        </tr>
        <tr class="">
            <td>18</td>
            <td align="left"><a>Science Translational Medicine</a></td>
        </tr>
        <tr class="">
            <td>19</td>
            <td align="left"><a>Molecular Cell</a></td>
        </tr>
        <tr class="">
            <td>20</td>
            <td align="left"><a>Immunity</a></td>
        </tr>
        <tr class="">
            <td>21</td>
            <td align="left"><a>Developmental Cell</a></td>
        </tr>
        <tr class="">
            <td>22</td>
            <td align="left"><a>Cancer Cell</a></td>
        </tr>
        <tr class="">
            <td>23</td>
            <td align="left"><a>Cell Host & Microbe</a></td>
        </tr>
        <tr class="">
            <td>24</td>
            <td align="left"><a>Cell Metabolism</a></td>
        </tr>
        <tr class="">
            <td>25</td>
            <td align="left"><a>Cell Stem Cell</a></td>
        </tr>
        <tr class="">
            <td>26</td>
            <td align="left"><a>NEW ENGL J MED</a></td>
        </tr>
        <tr class="">
            <td>27</td>
            <td align="left"><a>Lancet</a></td>
        </tr>
        </tbody>
        <thead>
        <tr>
            <th colspan="2" style="width:1000px;">  </th>
        </tr>
        </thead>
    </table>
    <input type="button" name="return_last_page" value="回上頁"  onclick="javascript:location.href='LectureProfessorCatalog'"  >
</div>
<script>
</script>
</html>
