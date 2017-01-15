<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<br /><br />
<a href="/app/surveys/new"><button class="btn btn-primary">Neue Umfrage</button></a>

<h3>Liste der vorhandenen Umfragen</h3>
<table class="table table-striped jambo_table bulk_action">
    <thead>
    <tr class="headings">
        <th class="column-title">Name </th>
        <th class="column-title">Beschreibung</th>
        <th class="column-title">Erstellers</th>
        <th class="column-title">Start-Datum </th>
        <th class="column-title">End-Datum </th>
        <th class="column-title">Status </th>
        <th class="column-title no-link last"><span class="nobr">Aktionen</span>
        </th>
        <th class="bulk-actions" colspan="7">
            <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
        </th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${surveyList}" var="survey">
        <tr class="even pointer">
            <td>${survey.name}</td>
            <td>${survey.description}</td>
            <td>${survey.author}</td>
            <td><fmt:formatDate value="${survey.startDate}" type="date" pattern="dd.MM.yyyy" /></td>
            <td><fmt:formatDate value="${survey.endDate}" type="date" pattern="dd.MM.yyyy" /></td>
            <td>
                <c:if test="${survey.status == 1}">offen</c:if>
                <c:if test="${survey.status == 2}">fertig</c:if>
                <c:if test="${survey.status == 8}">l&auml;uft</c:if>
            </td>
            <td class=" last">
                <a href="/app/surveys/execute?id=${survey.id}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Ausf&uuml;hren </a>
                <a href="/app/surveys/edit?id=${survey.id}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Bearbeiten </a>
                <a href="/app/surveys/delete?action=delete&id=${survey.id}" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> L&ouml;schen </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>