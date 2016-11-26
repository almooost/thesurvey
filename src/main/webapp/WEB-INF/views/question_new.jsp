<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Seite: ${site}, Aktion: ${action}</h2>


<div class="row">
    <div class="col-md-6 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Neue Frage<small> Daten im Formular eingeben</small></h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>
                <form:form action="persist" method="POST" modelAttribute="question" cssClass="form-horizontal form-label-left input_mask" >
                <form:hidden path="status" value="${status}" />

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Name der Frage <span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <form:input path="name" cssClass="form-control col-md-7 col-xs-12"  />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">
                            Typ <span class="required">*</span>
                        </label>
                        <p>
                            Multiple Choice:
                            <div class="iradio_flat-green checked" style="position: relative;">
                                <form:radiobutton path="type" cssClass="flat" value="multiple-choise"/>
                                <ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                            </div>
                            Text
                            <div class="iradio_flat-green" style="position: relative;">
                                <form:radiobutton path="type" cssClass="flat" value="text" />
                                <ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                            </div>
                        </p>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Beschreibung</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <form:textarea path="description" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                            <button type="submit" class="btn btn-primary">Abbrechen</button>
                            <button type="submit" class="btn btn-success">Speichern</button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>

    </div>
</div>