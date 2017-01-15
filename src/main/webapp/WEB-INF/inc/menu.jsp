
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="/" class="site_title"><i class="fa fa-group"></i> <span>The Survey</span></a>
        </div>

        <div class="clearfix"></div>
        <br>

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <ul class="nav side-menu">
                    <li><a href="/app/"><i class="fa fa-home"></i> Home</a></li>
                    <li><a href="/app/surveys/"><i class="fa fa-edit"></i> Umfragen</a></li>
                    <li><a href="/app/questions/"><i class="fa fa-comment"></i> Fragen</a></li>
                    <li><a href="/app/answers/"><i class="fa fa-clone"></i> Antworten</a></li>
                    <li><a href="/app/contacts/"><i class="fa fa-user"></i> Kontakte</a></li>
                    <li><a href="/app/evaluations/"><i class="fa fa-table"></i> Auswertungen</a></li>
                    <li><a href="/app/users/"><i class="fa fa-user-md"></i> Benutzer</a></li>
                    <li><a href="/app/customers/"><i class="fa fa-suitcase"></i> Firma</a></li>
                </ul>
            </div>

        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">
            <a href="/logout" data-toggle="tooltip" data-placement="top" title="" data-original-title="Logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>

<!-- top navigation -->
<div class="top_nav">
    <div class="nav_menu">
        <nav class="" role="navigation">
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        ${user_givenname} ${user_name}
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                        <li><a href="/logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                    </ul>
                </li>

            </ul>
        </nav>
    </div>
</div>
<!-- /top navigation -->