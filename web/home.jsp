<%-- 
    Document   : home
    Created on : 12-Apr-2010, 7:53:35 PM
    Author     : Renaud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<div class="post">
    <h1 class="title" style="text-align:center">Pickup Games Today</h1>
    <p class="meta"><small>Updated on February 08th, 2010 by <a href="#">Admin</a></small></p>
    <p class="links"><a href="/PickupSoccerApplication/game/createGame.jsp" class="comments">Schedule a Pickup Game </a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/PickupSoccerApplication/game/games.jsp" class="permalink">See More Games</a></p>

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

    <%--<div class="entry">
        <p><strong><a href="#">Liquid Sex </a></strong></p>
        <p>Tuesday 09th February 2010 at 2PM, <a href="http://maps.google.ca/maps?f=q&source=s_q&hl=en&geocode=&q=dome&sll=45.383693,-75.697865&sspn=0.125631,0.363579&ie=UTF8&hq=dome&hnear=&ll=45.380849,-75.805321&spn=0.119609,0.363579&z=12&iwloc=A">Kanata Soccer Dome</a></p>
        <!-- <div class="map">
        <iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.ca/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=dome&amp;sll=45.383693,-75.697865&amp;sspn=0.125631,0.363579&amp;ie=UTF8&amp;hq=dome&amp;hnear=&amp;ll=45.379161,-75.895958&amp;spn=0.119609,0.363579&amp;z=12&amp;iwloc=A&amp;cid=3745397187117462037&amp;output=embed"></iframe><br /><small><a href="http://maps.google.ca/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=dome&amp;sll=45.383693,-75.697865&amp;sspn=0.125631,0.363579&amp;ie=UTF8&amp;hq=dome&amp;hnear=&amp;ll=45.379161,-75.895958&amp;spn=0.119609,0.363579&amp;z=12&amp;iwloc=A&amp;cid=3745397187117462037" style="color:#0000FF;text-align:left">View Larger Map</a></small></div> -->
    </div>

    <div class="entry">
        <p><strong><a href="#">The One Untouchables</a></strong></p>
        <p>Tuesday 09th February 2010 at 4PM, <a href= "http://maps.google.ca/maps?f=q&source=s_q&hl=en&geocode=&q=matt+anthony&sll=45.450257,-75.578041&sspn=0.125483,0.363579&ie=UTF8&radius=8.81&filter=0&rq=1&ev=p&hq=matt+anthony&hnear=&ll=45.456518,-75.61409&spn=0.125469,0.363579&z=12&iwloc=A">Matt Anthony Field</a></p>
    </div> --%>
    <p class="tags"><strong>Tags:</strong> <a href="#">soccer</a> <a href="#">sports</a> <a href="#">pickup</a> <a href="#">team</a> <a href="#">players</a> <a href="#">group</a> <a href="#">enjoy</a> <a href="#">ball</a></p>
</div>
