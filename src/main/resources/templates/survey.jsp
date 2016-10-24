<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>The survey - Surveys</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p th:text="'You choosed , ' + ${id} + 'with name: '+ ${name} + '!'" />

<form method="POST" action="/surveys/add">
    <table>
        <tr>
            <td><label for="name">Name</label></td>
            <td><input type="text" id="name" name="name" /></td>
        </tr>
        <tr>
            <td><label for="id">id</label></td>
            <td><input type="text" id="id" name="id" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form>

<ul>
    <li th:each="survey : ${surveys}" th:text="${survey.id}+': '+${survey.name}"></li>
</ul>

</body>
</html>
