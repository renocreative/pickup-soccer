<%-- 
    Document   : homes
    Created on : 12-Apr-2010, 7:53:35 PM
    Author     : Renaud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <c:import url = "WEB-INF/jspf/preHeader.jsp" >
            <c:param name = "param.title" value = "Login"/>
        </c:import>
    </head>
    <body onload="registerEvents();">
        <c:import url = "WEB-INF/jspf/header.jsp" />
        <hr />
        <!-- start page -->
        <div id="page">

            <!-- start content -->
            <div id="content" style="text-align:center;margin-left:260px;">
                <c:if test="${!empty requestScope.message}">
                    <div class="message"><c:out value="${requestScope.message}" default="${null}"/></div>
                </c:if>
                <div class="post" style="text-align:center;">
                    <h1 class="title">Registration</h1>
                    <p>&nbsp;</p>
                    <div class="post" style="text-align:center">
                        <form onSubmit="return validateForm()" action="registerUser" method="POST">
                            <table cellpadding="4" cellspacing="4" style="text-align:left" width="100%">
                                <tr><td>Email: </td>
                                    <td style="width:150px"><input type="text" onkeyup="validate"  id="email" name="email" >${ requestScope[user].email }</input></td>
                                    <td id="emailError" class="errorMsg" style="width:150px;margin-right: 10px"></td>
                                </tr>
                                <tr><td>Password: </td>
                                    <td style="width:150px"><input type="password" onkeyup="validate" id="password" name="password" /></td>
                                    <td id="passwordError" class="errorMsg"></td>
                                </tr>
                                <tr><td>&nbsp;</td><td><input type="submit" name="submit" value="Register" /></td><td>&nbsp;</td></tr>
                                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                            </table></form>
                    </div>
                </div>
            </div>
            <!-- end content -->

            <div style="clear: both;">&nbsp;</div>
        </div>
        <!-- end page -->
        <hr />
        <c:import url = "WEB-INF/jspf/footer.jsp" />
    </body>
</html>
