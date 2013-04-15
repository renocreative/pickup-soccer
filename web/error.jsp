<%-- 
    Document   : error
    Created on : 12-Apr-2010, 8:20:41 PM
    Author     : Renaud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <c:import url = "WEB-INF/jspf/preHeader.jsp" >
            <c:param name = "param.title" value = "Error occured"/>
        </c:import>
    </head>
    <body onload="registerEvents();">
        <c:import url = "WEB-INF/jspf/header.jsp" />
        <hr />
        <!-- start page -->
        <div id="page">
            <c:import url = "WEB-INF/jspf/news.jsp" />

            <!-- start content -->
            <div id="content">
                <h2 style="color:red">
                    Error occured: <br />
                    <c:out default="Unknown - Please Contact The Administrator!" value="${requestScope.message}" />
                </h2>
            </div>
            <!-- end content -->

            <c:import url = "WEB-INF/jspf/misc.jsp" />
            <div style="clear: both;">&nbsp;</div>
        </div>
        <!-- end page -->
        <hr />
        <c:import url = "WEB-INF/jspf/footer.jsp" />
    </body>
</html>
