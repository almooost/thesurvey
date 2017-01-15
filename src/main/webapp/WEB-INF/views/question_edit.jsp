<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">
    <div class="col-md-6 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Frage ${question.name}<small> bearbeiten</small></h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>
                <form:form action="persist" method="POST" modelAttribute="question" cssClass="form-horizontal form-label-left input_mask" >
                    <form:hidden path="id" value="${question.id}" />
                    <form:hidden path="status" value="1" />


                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Name der Frage <span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <form:input path="name" cssClass="form-control col-md-7 col-xs-12" type="text" value="${question.name}"  />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">
                            Typ <span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <form:radiobutton path="type" value="Multiple-Choice" label="Multiple-Choice" id="type" />
                            <form:radiobutton path="type" value="Text" label="Text" id="type" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Beschreibung</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <form:textarea path="description" cssClass="form-control col-md-7 col-xs-12" type="text" value="${question.description}"  />
                        </div>
                    </div>

                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                            <button type="reset" class="btn btn-primary"><a href="/app/questions/" style="color:white;">Abbrechen</a></button>
                            <button type="submit" class="btn btn-success">Speichern</button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
        <div class="x_panel">
            <div class="x_title">
                <h2>Antwort zur Frage</h2>
                <div class="clearfix"></div>
            </div>

            <!-- answer -->
            <div class="form-group x_content">
                <table class="table table-striped jambo_table">
                    <thead>
                    <tr class="headings">
                        <th class="column-title">Name</th>
                        <th class="column-title">Typ</th>
                        <th class="column-title">Beschreibung</th>
                    </tr>
                    </thead>

                    <tbody>
                        <tr class="even pointer">
                            <td>${question.answer.name}</td>
                            <td>${question.answer.type}</td>
                            <td>${question.answer.description}</td>
                        </tr>
                    </tbody>
                </table>
            </div><!-- /answer -->

        </div>


    </div>
    <!-- add answer to question -->
    <div class="col-sm-6 col-xs-12">
        <div class="x_panel">
            <!-- add answer -->
            <div class="x_title">
                <h2>Antwort hinzuf&uuml;gen</h2>
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
                    <c:forEach items="${answerList}" var="answer">
                        <tr class="even pointer">
                            <td>${answer.name}</td>
                            <td>${answer.type}</td>
                            <td>${answer.description}</td>
                            <td class=" last">
                                <a href="/app/questions/answers/add?id=${question.id}&answer_id=${answer.id}">
                                    <i class="fa fa-plus"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div><!-- /add answer -->
        </div>
    </div>
</div>