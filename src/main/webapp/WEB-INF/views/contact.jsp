<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Kontakt Seite</h1>

<div class="info"></div>
<br /><br />
<a href="/app/contacts/new"><button class="btn btn-primary">Neuer Kontakt</button></a>

<h3>Liste der vorhandenen Kontakte</h3>

<table class="table table-striped jambo_table bulk_action">
    <thead>
    <tr class="headings">
        <th class="column-title">Vorname </th>
        <th class="column-title">Name </th>
        <th class="column-title">E-Mail </th>
        <th class="column-title">Abteilung </th>
        <th class="column-title no-link last"><span class="nobr">Action</span>
        </th>
        <th class="bulk-actions" colspan="7">
            <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
        </th>
    </tr>
    </thead>

    <tbody>

    <c:forEach items="${contactList}" var="contact">
        <tr class="even pointer">
            <td>${contact.givenname}</td>
            <td>${contact.name}</td>
            <td>${contact.email}</td>
            <td>${contact.department}</td>
            <td class=" last">
                <a href="/app/contacts/edit?id=${contact.id}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Bearbeiten </a>
                <a href="/app/contacts/delete?action=delete&id=${contact.id}" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> L&ouml;schen </a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

