<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>Seite: ${site}, Aktion: ${action}, Survey: ${surveyList}</h2>


<div class="row">
    <div class="col-md-6 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Umfrage<small> Daten neu eingeben</small></h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>
                <form class="form-horizontal form-label-left input_mask" method="POST" action="add">

                    <input type="hidden" name="author" value="${username}">
                    <input type="hidden" name="points" value="0">
                    <input type="hidden" name="status" value="1">


                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Umfrage Name <span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input class="date-picker form-control col-md-7 col-xs-12" name="name" required="required" type="text">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Datum Start <span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input class="date-picker form-control col-md-7 col-xs-12" name="startDate" required="required" type="text">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Datum Ende <span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input class="date-picker form-control col-md-7 col-xs-12" name="endDate" required="required" type="text">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Beschreibung</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <textarea class="form-control" name="description"></textarea>
                        </div>
                    </div>

                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                            <button type="submit" class="btn btn-primary">Abbrechen</button>
                            <button type="submit" class="btn btn-success">Speichern</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>

    </div>
</div>