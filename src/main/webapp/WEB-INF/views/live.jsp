<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:if test="${question != null}">

    <div class="row">
        <div class="col-sm-9">
            <h1>${survey.name}</h1><br />
            <h3>Frage ${question_count_index} von ${question_count}</h3>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-9">
            <form:form action="${url}" method="POST" modelAttribute="question" cssClass="form-horizontal form-label-left input_mask" >
                <div class="row">
                    <div class="col-sm-12">
                        <h2>${question.name}</h2>
                    </div>
                    <div class="col-sm-12">
                        <p>${question.description}</p>
                    </div>

                    <div class="col-sm-12">
                        ${question.answer.type}
                    </div>

                    <c:if test="${question.answer.type  == 'text'}">
                        <div class="col-sm-12">
                            <label>Bitte geben Sie Ihre Antwort ein</label>
                            <div class="col-sm-12">${question.answer.description}</div>
                            <form:input path="answer" cssClass="form-control"></form:input>
                        </div>
                    </c:if>
                    <c:if test="${question.answer.type == 'multiple-choice'}">
                        <div class="col-sm-12"><b>Antwort</b></div>
                        <div class="col-sm-12">${question.answer.description}</div>

                        <div class="col-sm-12">
                            <form:radiobuttons path="favoriteMovieType" items="${question.answer.answerList}" />

                        </div>
                    </c:if>
                </div>
                <div class="row">
                    <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                            <button type="reset" class="btn btn-primary" onclick="window.location.hreF='/'">Abbrechen</button>
                            <button type="submit" class="btn btn-success">Speichern und zur n&auml;chsten Frage</button>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>

</c:if>

<c:if test="${question == null}">
    <div class="row">
        <div class="col-sm-12">
            <h1>Vielen Dank f&uuml;r Ihre Teilnahme</h1>
            <p>Die Umfrage ist abgeschlossen, Sie d&uuml;rfen das Fenster nun schliessen.</p>
        </div>
    </div>
</c:if>