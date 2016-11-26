<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<br /><br />
<a href="/app/surveys/execute?id=${survey.id}"><button class="btn btn-primary">Ausführen</button></a>

<div class="row">
    <!-- col-md-6 -->
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
                        <table class="table table-striped jambo_table">
                            <thead>
                            <tr class="headings">
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
                            <c:forEach items="${surveyQuestionList}" var="surveyQuestion">
                                <tr class="even pointer">
                                    <td>${surveyQuestion.question.name}</td>
                                    <td>${surveyQuestion.question.description}</td>
                                    <td>${surveyQuestion.question.type}</td>
                                    <td>${surveyQuestion.question.status}</td>
                                    <td class=" last"><a href="/surveys/view?id=${surveyQuestion.id}"><i class="fa fa-edit"></i></a> <i class="fa fa-trash"></i></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <hr>
                    <h2>Kontakte</h2>
                    <div class="form-group">
                        <table class="table table-striped jambo_table">
                            <thead>
                            <tr class="headings">
                                <th class="column-title">Vorname </th>
                                <th class="column-title">Name</th>
                                <th class="column-title">E-Mail</th>
                                <th class="column-title">Abteilung</th>
                                <th class="column-title no-link last"><span class="nobr">Aktion</span>
                                </th>
                                <th class="bulk-actions" colspan="7">
                                    <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                </th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${surveyContactList}" var="surveyContact">
                                <tr class="even pointer">
                                    <td>${surveyContact.contact.givenname}</td>
                                    <td>${surveyContact.contact.name}</td>
                                    <td>${surveyContact.contact.email}</td>
                                    <td>${surveyContact.contact.department}</td>
                                    <td class=" last">
                                        <a href="/app/surveys/contacts/edit?id=${survey.id}&contact_id=${surveyContact.id}"><i class="fa fa-edit"></i></a>
                                        <a href="/app/surveys/contacts/delete?id=${survey.id}&contact_id=${surveyContact.id}"><i class="fa fa-trash"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </form:form>
            </div>
        </div>

    </div><!-- /.col-md-6 -->

    <!-- col-md-6 -->
    <div class="col-md-6 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Auswertung ${survey.name}</h2>
                <div class="clearfix"></div>
            </div>
            <!-- x_content -->
            <div class="x_content">
                <!-- ./form-horizontal -->
                <div class="form-horizontal form-label-left input_mask">

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Name der Auswertung<span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input class="date-picker form-control col-md-7 col-xs-12" name="name" required="required" type="text" value="${survey.evaluation.name}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Beschreibung</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <textarea class="form-control" name="description">${survey.evaluation.description}</textarea>
                        </div>
                    </div>

                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                            <button class="btn btn-success">
                                <a href="/app/evaluations/${survey.evaluation.id}" style="color:white;">Auswertung herunterladen</a>
                            </button>
                        </div>
                    </div>
                </div><!-- ./form-horizontal -->
            </div><!-- /.x_content -->

            <!-- add contact -->
            <div class="x_title">
                <h2>Kontakt hinzuf&uuml;gen</h2>
                <div class="clearfix"></div>
            </div>
            <div class="form-group x_content">
                <table class="table table-striped jambo_table">
                    <thead>
                    <tr class="headings">
                        <th class="column-title">Vorname </th>
                        <th class="column-title">Name</th>
                        <th class="column-title">E-Mail</th>
                        <th class="column-title">Abteilung</th>
                        <th class="column-title no-link last"><span class="nobr">Aktion</span>
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
                                <a href="/app/surveys/contacts/add?id=${survey.id}&contact_id=${contact.id}">
                                    <i class="fa fa-plus"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div><!-- /add contact -->

            <!-- add question -->
            <div class="x_title">
                <h2>Frage hinzuf&uuml;gen</h2>
                <div class="clearfix"></div>
            </div>
            <div class="form-group x_content">
                <table class="table table-striped jambo_table">
                    <thead>
                    <tr class="headings">
                        <th class="column-title">Name</th>
                        <th class="column-title">Typ</th>
                        <th class="column-title">Beschreibung</th>
                        <th class="column-title no-link last"><span class="nobr">Aktion</span>
                        </th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${questionList}" var="question">
                        <tr class="even pointer">
                            <td>${question.name}</td>
                            <td>${question.type}</td>
                            <td>${question.description}</td>
                            <td class=" last">
                                <a href="/app/surveys/questions/add?id=${survey.id}&question_id=${question.id}">
                                    <i class="fa fa-plus"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div><!-- /add question -->

        </div><!-- /.x_panel -->
    </div><!-- /.col-md-6 -->

</div><!-- row -->