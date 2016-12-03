<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<br /><br />
<a href="/app/surveys/new"><button class="btn btn-primary">Neue Umfrage</button></a>

<h3>Liste der vorhandenen Umfragen</h3>
<table class="table table-striped jambo_table bulk_action">
    <thead>
    <tr class="headings">
        <th>
            <div class="icheckbox_flat-green" style="position: relative;"><input type="checkbox" id="check-all" class="flat" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div>
        </th>
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
            <td class="a-center ">
                <div class="icheckbox_flat-green" style="position: relative;">
                    <input type="checkbox" class="flat" name="table_records" style="position: absolute; opacity: 0;" class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;" />
                </div>
            </td>
            <td>${survey.name}</td>
            <td>${survey.description}</td>
            <td>${survey.author}</td>
            <td><fmt:formatDate value="${survey.startDate}" type="date" pattern="dd.MM.yyyy" /></td>
            <td><fmt:formatDate value="${survey.endDate}" type="date" pattern="dd.MM.yyyy" /></td>
            <td>${survey.status}</td>
            <td class=" last">
                <a href="/app/surveys/execute?id=${survey.id}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Ausf&uuml;hren </a>
                <a href="/app/surveys/edit?id=${survey.id}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Bearbeiten </a>
                <a href="/app/surveys/delete?action=delete&id=${survey.id}" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> L&ouml;schen </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>