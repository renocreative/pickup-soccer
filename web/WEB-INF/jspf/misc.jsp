<%--
    Document   : news
    Created on : 12-Apr-2010, 7:44:34 PM
    Author     : Renaud
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- start sidebar two -->
<div id="sidebar2" class="sidebar">
    <ul>
        <li>
            <c:choose>
                <c:when test= "${ empty sessionScope.user }" >
                    <h2>About you</h2>
                    <ul>
                        <li><a href="/PickupSoccerApplication/user/login.jsp">Want to login ?!!</a> </li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <h2>You are logged in!</h2>
                    <ul>
                        <li><a href="#">Account settings</a> </li>
                        <li><a href="#">My Favorites Games</a>
                        </li>
                        <li><a href="#">My Reviews</a> </li>
                        <li><a href="/PickupSoccerApplication/user/logout">Logout</a> </li>

                    </ul>
                </c:otherwise>
            </c:choose>
        </li>
        <li>
            <h2>Archives</h2>
            <ul>
                <li><a href="#">December</a> (23)</li>
                <li><a href="#">November</a> (31)</li>
                <li><a href="#">October</a> (31)</li>
                <li><a href="#">September</a> (30)</li>
                <li><a href="#">August</a> (31)</li>
            </ul>
        </li>
        <li>
            <h2>Best Fields By Users</h2>
            <h3>&nbsp;&nbsp; Winter Season</h3>
            <ul>
                <li><a href="#">Lansdowne Park</a></li>
                <li><a href="#">Matt Anthony Field</a></li>
                <li><a href="#">Kanata Soccer Dome</a></li>
            </ul>
        </li>
    </ul>
</div>
<!-- end sidebar two -->