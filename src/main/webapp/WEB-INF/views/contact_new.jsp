<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Seite: ${site}, Aktion: ${action}</h2>


<div class="row">
    <div class="col-md-6 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Neuer Kontakt<small> Daten im Formular eingeben</small></h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>
                <form:form action="persist" method="POST" modelAttribute="contact" cssClass="form-horizontal form-label-left input_mask" >
                    <form:hidden path="status" value="${status}" />


                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Vorname<span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <form:input path="givenname" cssClass="form-control col-md-7 col-xs-12"  />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Nachname<span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <form:input path="name" cssClass="form-control col-md-7 col-xs-12"  />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">E-Mail<span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <form:input path="email" cssClass="form-control col-md-7 col-xs-12"  />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Department<span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <form:input path="department" cssClass="form-control col-md-7 col-xs-12"  />
                        </div>
                    </div>

                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                            <button class="btn btn-primary"><a href="/" style="color:white;">Abbrechen</a></button>
                            <button type="submit" class="btn btn-success">Speichern</button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>

    </div>
</div>