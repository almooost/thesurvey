<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<br /><br />
<a href="/app/evaluations/new"><button class="btn btn-primary">Neue Auswertung</button></a>

<div class="info"></div>
<h3>Liste der Auswertungen</h3>

<table class="table table-striped jambo_table bulk_action">
    <thead>
    <tr class="headings">
        <th class="column-title">Name </th>
        <th class="column-title">Beschreibung </th>
        <th class="column-title">Typ </th>
        <th class="column-title">Zeit </th>
        <th class="column-title no-link last"><span class="nobr">Aktion</span></th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${evaluationList}" var="evaluation">
        <tr class="even pointer">
            <td>${evaluation.name}</td>
            <td>${evaluation.description}</td>
            <td>${evaluation.type}</td>
            <td><fmt:formatDate value="${evaluation.timestamp}" pattern="dd.MM.yyyy - mm:HH:ss" /></td>
            <td class=" last">
                <a href="/app/evaluations/edit?id=${evaluation.id}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Bearbeiten </a>
                <a href="/app/evaluations/delete?action=delete&id=${evaluation.id}" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> L&ouml;schen </a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>