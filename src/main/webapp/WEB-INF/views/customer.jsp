<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">
    <div class="col-md-6 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Firmen Einstellngen</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>
                <form:form action="persist" method="POST" modelAttribute="customer" cssClass="form-horizontal form-label-left input_mask" >
                    <form:hidden path="status" value="${status}" />

                    <input type="hidden" name="status" value="1">

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Name<span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <form:input path="name" cssClass="form-control col-md-7 col-xs-12" readonly="readonly" type="text" value="${name}"  />
                        </div>
                    </div>

                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                            <button type="reset" class="btn btn-primary"><a href="/" style="color:white;">Abbrechen</a></button>
                            <button type="submit" class="btn btn-success">Speichern</button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>

    </div>
</div>