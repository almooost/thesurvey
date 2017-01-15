<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br /><br />
<a href="/app/answers/new"><button class="btn btn-primary">Neue Antwort</button></a>

<div class="info"></div>

<h3>Liste der vorhandenen Antworten</h3>
<table class="table table-striped jambo_table bulk_action">
    <thead>
    <tr class="headings">
        <th class="column-title">Name </th>
        <th class="column-title">Beschreibung</th>
        <th class="column-title">Typ</th>
        <th class="column-title">Punkte</th>
        <th class="column-title no-link last"><span class="nobr">Action</span>
        </th>
        <th class="bulk-actions" colspan="7">
            <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
        </th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${answerList}" var="answer">
        <tr class="even pointer">
            <td>${answer.name}</td>
            <td>${answer.description}</td>
            <td>${answer.type}</td>
            <td>${answer.points}</td>
            <td class=" last">
                <a href="/app/answers/edit?id=${answer.id}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Bearbeiten </a>
                <a href="/app/answers/delete?action=delete&id=${answer.id}" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> L&ouml;schen </a>
            </td>
        </tr>
    </c:forEach>


    </tbody>
</table>

