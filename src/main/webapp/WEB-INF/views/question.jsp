<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<br /><br />
<a href="/app/questions/new"><button class="btn btn-primary">Neue Frage</button></a>
<br /><br />

<div class="info"></div>

<h3>Liste der vorhandenen Fragen</h3>
<table class="table table-striped jambo_table bulk_action">
    <thead>
    <tr class="headings">
        <th class="column-title">Name </th>
        <th class="column-title">Beschreibung</th>
        <th class="column-title">Typ</th>
        <th class="column-title last">Status </th>
        </th>
        <th class="bulk-actions" colspan="7">
            <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
        </th>
    </tr>
    </thead>

    <tbody>

        <c:forEach items="${questionList}" var="question">
            <tr class="even pointer">
                <td>${question.name}</td>
                <td>${question.description}</td>
                <td>${question.type}</td>
                <td class=" last">
                    <a href="/app/questions/edit?id=${question.id}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Bearbeiten </a>
                    <a href="/app/questions/delete?id=${question.id}" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> L&ouml;schen </a>
                </td>
            </tr>
    </c:forEach>

    </tbody>
</table>

