<%--
    Document   : viewGame
    Created on : 4-Mar-2010, 2:16:47 PM
    Author     : Renaud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<div class="post">

    <h1 class="title">Game Details</h1>
    <p>&nbsp;</p>

    <form action="/PickupSoccerApplication/game/editGame.jsp?gameId=${ requestScope.game.gameId }" method="POST" />

        <div style="font-size:12px;text-align:center;width:600px"><table cellpadding="2" cellspacing="2">
                <tr><td>Date: </td><td>
                    <f:formatDate value="${ requestScope.game.dateHeure }" type="both" dateStyle="full"/>
                    </td><td></td></tr>
                <!--tr><td>Age Range: </td><td><input type="text" name="ageRange" value="20"/></td><td></td></tr-->
                <tr><td>Maximum of players: </td><td><c:out value="${ requestScope.game.maxPlayers }"/></td><td></td></tr>
                <tr><td>Skill Level: </td><td><c:out value="${ requestScope.game.skillLevel }"/></td><td></td></tr>
                <tr><td>Location: </td><td><c:out value="${ requestScope.game.location.fieldName }" /></td><td></td></tr>
                <tr><td>Field Cost: </td><td><c:out value="${ requestScope.game.fieldCost }" /></td><td></td></tr>
                <tr><td>Address: </td><td><c:out value="${ requestScope.game.location.fieldAddress }" /></td><td></td></tr>
                <tr><td>Notes: </td><td><c:out value="${ requestScope.game.comments }" /></td><td></td></tr>

                <tr><td></td><td align="right"><input type="submit" name="submit" value="Edit" /></td><td></td></tr>
            </table></div>
    </form>
    <p class="tags"><!--<strong>Tags:</strong> <a href="#">soccer</a> <a href="#">sports</a> <a href="#">pickup</a> <a href="#">team</a> <a href="#">players</a> <a href="#">group</a> <a href="#">enjoy</a> <a href="#">ball</a>--></p>

</div>