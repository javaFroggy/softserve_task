<%--
  Created by IntelliJ IDEA.
  User: yarik
  Date: 27.06.2022
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <title>Form application</title>
    </head>
    <body>
        <div class="contentContainer">
            <form method = "post" action="${contextPath}/login">
                <h2>Sign In</h2>
                <div>
                    <c:if test="${errorMessage}">Wrong user name or password</c:if>
                </div>
                <table>
                    <tr>
                        <td><label for="username">Username</label></td>
                        <td><input type="text" id="username" name="username" class="serializedFormContainer" placeholder="Username" required="true"></td>
                    </tr>
                    <tr>
                        <td><label for="password">Password</label></td>
                        <td><input type="password" id="password" name="password" class="serializedFormContainer" placeholder="Password" required="true"></td>
                    </tr>
                    <tr>
                        <td><button class="ui-button" type="submit">Sign in</button></td>
                        <td><a href="${contextPath}/registration">Sign Up</a></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
