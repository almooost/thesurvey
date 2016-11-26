<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>Seite: ${site}, Aktion: ${action}</h2>


<div class="row">
    <div class="col-md-6 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Frage ${question.name}<small> bearbeiten</small></h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>
                <form class="form-horizontal form-label-left input_mask" method="POST" action="persist">

                    <input type="hidden" name="status" value="1">


                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Name der Frage <span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input class="date-picker form-control col-md-7 col-xs-12" name="name" required="required" type="text" value="${question.name}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">
                            Typ <span class="required">*</span>
                        </label>
                        <p>
                            Multiple Choice:
                        <div class="iradio_flat-green checked" style="position: relative;">
                            <input type="radio" class="flat" name="type" value="multiple-choice" checked="" required="" style="position: absolute; opacity: 0;">
                            <ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                        </div>
                        Text
                        <div class="iradio_flat-green" style="position: relative;">
                            <input type="radio" class="flat" name="type" value="text" style="position: absolute; opacity: 0;">
                            <ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                        </div>
                        </p>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Beschreibung</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <textarea class="form-control" name="description">${question.description}</textarea>
                        </div>
                    </div>

                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                            <button type="reset" class="btn btn-primary"><a href="/app/questions/" style="color:white;">Abbrechen</a></button>
                            <button type="submit" class="btn btn-success">Speichern</button>
                        </div>
                    </div>

                </form>
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
                        </th>
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