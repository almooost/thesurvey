<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br /><br />
<a href="/app/questions/new"><button class="btn btn-primary">Neue Frage</button></a>
<br /><br />
<h2>Seite: ${site}, Aktion: ${action}</h2>

<div class="info"></div>

<h3>Liste der vorhandenen Antworten</h3>
<table class="table table-striped jambo_table bulk_action">
    <thead>
    <tr class="headings">
        <th>
            <div class="icheckbox_flat-green" style="position: relative;"><input type="checkbox" id="check-all" class="flat" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div>
        </th>
        <th class="column-title">Name </th>
        <th class="column-title">Beschreibung</th>
        <th class="column-title">Typ</th>
        <th class="column-title">Status </th>
        <th class="column-title no-link last"><span class="nobr">Action</span>
        </th>
        <th class="bulk-actions" colspan="7">
            <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
        </th>
    </tr>
    </thead>

    <tbody>

        <c:forEach items="${questionList}" var="question">
            <tr class="even pointer">
                <td class="a-center ">
                    <div class="icheckbox_flat-green" style="position: relative;">
                        <input type="checkbox" class="flat" name="table_records" style="position: absolute; opacity: 0;" class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;" />
                    </div>
                </td>
                <td>${question.name}</td>
                <td>${question.description}</td>
                <td>${question.type}</td>
                <td>${question.status}</td>
                <td class=" last">
                    <a href="/app/questions/view?id=${question.id}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Bearbeiten </a>
                    <a href="/app/questions/delete?action=delete&id=${question.id}" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Löschen </a>
                </td>
            </tr>
    </c:forEach>

    </tbody>
</table>

