<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:if test="${question != null}">

    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3>${survey.name}</h3>
            </div>
        </div>
        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">

                        <h2>Frage ${question_count_index} <small>von ${question_count}</small></h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">


                        <!-- Smart Wizard -->
                        <p>Bitte beantworten Sie alle Fragen wahrheitsgetreu, besten Dank!.</p>
                        <div id="wizard" class="form_wizard wizard_horizontal">
                            <ul class="wizard_steps">
                                <li>
                                    <a href="#step-1">
                                        <span class="step_no">1</span>
                                        <span class="step_descr">
                                              Frage 1<br />
                                              <small>Allgemein</small>
                                          </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#step-2">
                                        <span class="step_no">2</span>
                                        <span class="step_descr">
                                              Frage 2<br />
                                              <small>Abteilung</small>
                                          </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#step-3">
                                        <span class="step_no">3</span>
                                        <span class="step_descr">
                                              Frage 3<br />
                                              <small>Mitarbeiter</small>
                                          </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#step-4">
                                        <span class="step_no">4</span>
                                        <span class="step_descr">
                                              Frage 4<br />
                                              <small>Arbeitsklima</small>
                                          </span>
                                    </a>
                                </li>
                            </ul>
                            <div id="step-1">
                                <div class="col-sm-12">
                                    <h2>${question.name}</h2>
                                    <div class="col-sm-12">
                                        <p>${question.description}</p>
                                    </div>
                                </div>
                                <form:form action="${url}" method="POST" modelAttribute="question" cssClass="form-horizontal form-label-left input_mask" >
                                    <form:hidden path="question_id" value="${question.id}" />

                                    <div class="col-sm-12">
                                            ${answerObj.type}
                                    </div>

                                    <c:if test="${answerObj.type == 'text'}">
                                        <div class="col-sm-12">
                                            <label>Bitte geben Sie Ihre Antwort ein</label>
                                            <div class="col-sm-12">${answerObj.description}</div>
                                            <form:input path="answer" cssClass="form-control"/>
                                        </div>
                                    </c:if>
                                    <c:if test="${answerObj.type == 'Multiple-Choice'}">
                                        <div class="col-sm-12"><b>Antwort</b></div>
                                        <div class="col-sm-12">${answerObj.description}</div>

                                        <div class="col-sm-12">
                                            <form:radiobuttons path="answer" items="${answer}" />
                                        </div>
                                    </c:if>

                                    <div class="form-group">
                                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                            <button type="reset" class="btn btn-primary" onclick="window.location.hreF='/'">Abbrechen</button>
                                            <button type="submit" class="btn btn-success">Speichern und zur n&auml;chsten Frage</button>
                                        </div>
                                    </div>

                                </form:form>

                            </div>
                            <div id="step-2">
                                <h2 class="StepTitle">Frage 2 Content</h2>
                                <p>
                                    do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                                    fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                </p>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor
                                    in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                </p>
                            </div>
                            <div id="step-3">
                                <h2 class="StepTitle">Frage 3 Content</h2>
                                <p>
                                    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore
                                    eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                </p>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor
                                    in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                </p>
                            </div>
                            <div id="step-4">
                                <h2 class="StepTitle">Frage 4 Content</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                                    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                </p>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor
                                    in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                </p>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor
                                    in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                </p>
                            </div>

                        </div>
                        <!-- End SmartWizard Content -->

                    </div>
                </div>
            </div>
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