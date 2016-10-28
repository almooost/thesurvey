<%@ page import="java.util.*" %>
<%
    List<Map<String, String>> surveyList = new ArrayList<>();
    Map<String, String> surveyMap = new HashMap<String, String>();
    surveyMap.put("name", "Survey 1");
    surveyMap.put("description", "Abteilung IT, Mitarbeiter Zufriedenheits-Umfrage");
    surveyMap.put("creator", "Samuel Alfano");
    surveyMap.put("date_start", "28.10.2016");
    surveyMap.put("date_end", "28.11.2016");
    surveyMap.put("status", "active");

    surveyList.add(surveyMap);
%>

<h1>Antworten</h1>
<h2>Seite: ${site}, Aktion: ${action}</h2>

<h3>Liste der vorhandenen Antworten</h3>

<table class="table table-striped jambo_table bulk_action">
    <thead>
    <tr class="headings">
        <th>
            <div class="icheckbox_flat-green" style="position: relative;"><input type="checkbox" id="check-all" class="flat" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div>
        </th>
        <th class="column-title">Name </th>
        <th class="column-title">Beschreibung</th>
        <th class="column-title">Ersteller</th>
        <th class="column-title">Start-Datum </th>
        <th class="column-title">End-Datum </th>
        <th class="column-title">Status </th>
        <th class="column-title no-link last"><span class="nobr">Action</span>
        </th>
        <th class="bulk-actions" colspan="7">
            <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
        </th>
    </tr>
    </thead>

    <tbody>
    <%
        Iterator iter = surveyList.iterator();
        while (iter.hasNext())
        {
            Map<String, String> element = (Map<String, String>) iter.next();
    %>
    <tr class="even pointer">
        <td class="a-center ">
            <div class="icheckbox_flat-green" style="position: relative;">
                <input type="checkbox" class="flat" name="table_records" style="position: absolute; opacity: 0;" class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;" />
            </div>
        </td>
        <td><%= element.get("name")%></td>
        <td><%= element.get("description")%></td>
        <td><%= element.get("creator")%></td>
        <td><%= element.get("date_start")%></td>
        <td><%= element.get("date_end")%></td>
        <td><%= element.get("status")%></td>
        <td class=" last">[E] [D]</td>
    </tr>
    <%
        }
    %>

    </tbody>
</table>