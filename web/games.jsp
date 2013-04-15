<%-- 
    Document   : games
    Created on : 12-Apr-2010, 7:53:35 PM
    Author     : Renaud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<div class="post">
    <h1 class="title">Pickup Games</h1>
    <p class="meta"><small>Updated on February 08th, 2010 by <a href="#">Admin</a></small></p>
    <p class="links"><a href="/PickupSoccerApplication/game/createGame.jsp" class="comments">Schedule a Pickup Game </a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/PickupSoccerApplication/game/home.jsp" class="permalink">Back to Home >></a></p>

    <c:choose>
        <c:when test= "${ empty games }" >
            No games created yet.
        </c:when>
        <c:otherwise>
            <c:forEach var="game" items="${ games }">
                <div class="entry">
                    <f:setLocale value="en_CA" />
                    <p><strong><a href="/PickupSoccerApplication/game/viewGame.jsp?gameId=<c:out value='${ game.gameId }'/>" >Pickup Game
                        At <c:out value="${ game.location.fieldName }" /></a></strong></p>
                    <p><f:formatDate value="${ game.dateHeure }" type="both" dateStyle="full"/>
                        <a href="http://maps.google.ca/maps?f=q&source=s_q&hl=en&geocode=&q=dome&sll=45.383693,-75.697865&sspn=0.125631,0.363579&ie=UTF8&hq=dome&hnear=&ll=45.380849,-75.805321&spn=0.119609,0.363579&z=12&iwloc=A"><%-- game.getLocation().getFieldName() --%></a>
                    </p>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>

    <p class="tags"><strong>Tags:</strong> <a href="#">soccer</a> <a href="#">sports</a> <a href="#">pickup</a> <a href="#">team</a> <a href="#">players</a> <a href="#">group</a> <a href="#">enjoy</a> <a href="#">ball</a></p>
</div>
