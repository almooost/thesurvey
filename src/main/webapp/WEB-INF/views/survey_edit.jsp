<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Seite: ${site}, Aktion: ${action}</h2>


<div class="row">
    <div class="col-md-6 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Umfrage ${survey.name}</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>
                <form:form method="POST" action="/app/surveys/persist"
                           modelAttribute="survey" cssClass="form-horizontal form-label-left input_mask">
                <!-- <form class="form-horizontal form-label-left input_mask" method="POST" action="persist"> -->

                    <input type="hidden" name="id" value="${survey.id}">
                    <input type="hidden" name="author" value="${survey.author}">
                    <input type="hidden" name="points" value="0">
                    <input type="hidden" name="status" value="1">


                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Umfrage Name <span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input class="date-picker form-control col-md-7 col-xs-12" name="name" required="required" type="text" value="${survey.name}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Datum Start <span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input class="date-picker form-control col-md-7 col-xs-12" name="start_date" required="required" type="text" value="<fmt:formatDate value="${survey.startDate}" type="date" pattern="yyyy-mm-dd" />">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Datum Ende <span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input class="date-picker form-control col-md-7 col-xs-12" name="end_date" required="required" type="text" value="<fmt:formatDate value="${survey.endDate}" type="date" pattern="yyyy-mm-dd" />">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Beschreibung</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <textarea class="form-control" name="description">${survey.description}</textarea>
                        </div>
                    </div>

                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                            <button class="btn btn-primary"><a href="/app/surveys/" style="color:white;">Abbrechen</a></button>
                            <button type="submit" class="btn btn-success">Ändern und speichern</button>
                        </div>
                    </div>
                    <hr>
                    <h2>Fragen</h2>
                    <div class="form-group">
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
                                <th class="column-title no-link last"><span class="nobr">Aktion</span>
                                </th>
                                <th class="bulk-actions" colspan="7">
                                    <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                </th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${survey.questions}" var="question">
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
                                    <td class=" last"><a href="/surveys/view?id=${question.id}"><i class="fa fa-edit"></i></a> <i class="fa fa-trash"></i></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <hr>
                    <h2>Kontakte</h2>
                    <div class="form-group">
                        <table class="table table-striped jambo_table bulk_action">
                            <thead>
                            <tr class="headings">
                                <th>
                                    <div class="icheckbox_flat-green" style="position: relative;"><input type="checkbox" id="check-all" class="flat" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div>
                                </th>
                                <th class="column-title">Vorname </th>
                                <th class="column-title">Name</th>
                                <th class="column-title">E-Mail</th>
                                <th class="column-title">Abteilung</th>
                                <th class="column-title">Status </th>
                                <th class="column-title no-link last"><span class="nobr">Aktion</span>
                                </th>
                                <th class="bulk-actions" colspan="7">
                                    <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                </th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${survey.contacts}" var="contact">
                                <tr class="even pointer">
                                    <td class="a-center ">
                                        <div class="icheckbox_flat-green" style="position: relative;">
                                            <input type="checkbox" class="flat" name="table_records" style="position: absolute; opacity: 0;" class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;" />
                                        </div>
                                    </td>
                                    <td>${contact.givenname}</td>
                                    <td>${contact.name}</td>
                                    <td>${contact.email}</td>
                                    <td>${contact.department}</td>
                                    <td>${contact.status}</td>
                                    <td class=" last"><a href="/surveys/view?id=${contact.id}"><i class="fa fa-edit"></i></a> <i class="fa fa-trash"></i></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </form:form>
            </div>
        </div>

    </div>
</div>