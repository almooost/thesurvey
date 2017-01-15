<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row">
    <div class="col-md-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Home</h2>
                <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>
                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">

                <p>Auflistung der laufenden Umfragen</p>

                <!-- start project list -->
                <table class="table table-striped projects">
                    <thead>
                    <tr>
                        <th style="width: 1%">#</th>
                        <th style="width: 20%">Umfrage Name</th>
                        <th>Kontakte</th>
                        <th>Umfrage Fortschritt</th>
                        <th style="width: 20%">Aktion</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${surveyList}" var="survey">
                        <c:if test="${survey.status > 1}">
                        <tr class="even pointer">
                            <td class="a-center ">${survey.id}</td>
                            <td>${survey.name}</td>
                            <td>
                                <ul class="list-inline">
                                    <li>
                                        <img src="/resources/assets/images/user.png" class="avatar" alt="Avatar">
                                    </li>
                                    <li>
                                        <img src="/resources/assets/images/user.png" class="avatar" alt="Avatar">
                                    </li>
                                    <li>
                                        <img src="/resources/assets/images/user.png" class="avatar" alt="Avatar">
                                    </li>
                                    <li>
                                        <img src="/resources/assets/images/user.png" class="avatar" alt="Avatar">
                                    </li>
                                </ul>
                            </td>
                            <td class="project_progress">
                                <div class="progress progress_sm">
                                    <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="25" style="width: 25%;" aria-valuenow="25"></div>
                                </div>
                                <small>25% Ausgef&uuml;llt</small>
                            </td>
                            <td class=" last">
                                <a href="/app/surveys/edit?id=${survey.id}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Bearbeiten </a>
                                <a href="/app/surveys/delete?action=delete&id=${survey.id}" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> L&ouml;schen </a>
                            </td>
                        </tr>
                        </c:if>
                    </c:forEach>

                    </tbody>
                </table>
                <!-- end project list -->

            </div>
        </div>
    </div>
</div>