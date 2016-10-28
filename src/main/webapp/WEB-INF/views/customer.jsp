<%@ page import="java.util.*" %>
<%
    List<Map<String, String>> surveyList = new ArrayList<>();
    Map<String, String> surveyMap = new HashMap<String, String>();
    surveyMap.put("name", "Survey 1");
    surveyMap.put("creator", "Samuel Alfano");
    surveyMap.put("date", "28.10.2016");

    surveyList.add(surveyMap);
%>

<h1>Survey Page</h1>
<h2>Seite: ${site}, Aktion: ${action}</h2>

<h3>Liste der vorhandenen Umfragen</h3>
<form method="POST" action="/surveys/add">
    <table>
        <tr>
            <td><b>Name</b></td>
            <td><b>Ersteller</b></td>
            <td><b>Datum</b></td>
            <td><b>Aktion</b></td>
        </tr>
        <%
            Iterator iter = surveyList.iterator();
            while (iter.hasNext())
            {
                Map<String, String> element = (Map<String, String>) iter.next();
        %>
        <tr>
            <td><%= element.get("name")%></td>
            <td><%= element.get("creator")%></td>
            <td><%= element.get("date")%></td>
            <td>[E] [D]</td>
        </tr>
        <%
            }
        %>
    </table>
</form>

