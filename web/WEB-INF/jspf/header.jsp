<%--
    Document   : header
    Created on : 12-Apr-2010, 7:44:34 PM
    Author     : Renaud
--%>

<!-- start header -->
<div id="header">
    <div id="menu">
        <ul>
            <li id="home_index" class="current_page_item"><a href="/PickupSoccerApplication/game/home.jsp">Home</a></li>
            <li id="games_index"><a href="/PickupSoccerApplication/game/games.jsp">Pickup Soccer Games</a></li>
            <li id="locations_index"><a href="#">Best Fields/Locations</a></li>
            <li id="about_index"><a href="#">About</a></li>
            <li id="contact_index"><a href="#">Contact</a></li>
        </ul>
    </div>
    <div id="search">
        <form id="searchform" method="get" action="#">
            <fieldset>
                <input id="searchInput" type="text" name="s" value="" class="text" />
                <input id="submitSearch" type="submit" value="Search" class="button" />
                <span id="suggestion" style="color:#FFFFFF"></span>
            </fieldset>
        </form>
    </div>
</div>
<div id="logo">
    <h1><a href="#">Pickup Soccer</a></h1>
    <h2>In Ottawa/Gatineau</h2>
</div>
<!-- end header -->