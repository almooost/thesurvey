<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br /><br />
<a href="/surveys/answers/new"><button class="btn btn-primary">Neue Frage</button></a>

<br /><br />
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
        <th class="column-title">Typ</th>
        <th class="column-title">Punkte</th>
        <th class="column-title">Status </th>
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
            <td class="a-center ">
                <div class="icheckbox_flat-green" style="position: relative;">
                    <input type="checkbox" class="flat" name="table_records" style="position: absolute; opacity: 0;" class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;" />
                </div>
            </td>
            <td>${answer.name}</td>
            <td>${answer.description}</td>
            <td>${answer.type}</td>
            <td>${answer.points}</td>
            <td>${answer.status}</td>
            <td class=" last"><a href="/surveys/answers/view?id=${answer.id}">[E]</a> [D]</td>
        </tr>
    </c:forEach>


    </tbody>
</table>

