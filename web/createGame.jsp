<%--
    Document   : createGame
    Created on : 4-Mar-2010, 2:16:47 PM
    Author     : Renaud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="post">

    <h1 class="title">Schedule a Pickup Game</h1>
    <p>&nbsp;</p>
    <form action="/PickupSoccerApplication/game/createGame" method="POST">
        <div style="font-size:12px;text-align:center;width:600px"><table cellpadding="2" cellspacing="2">
                <!--tr><td>Name: </td><td><input type="text" name="gameId" value="TheWinners" /></td><td></td></tr-->
                <tr><td>Date: </td><td>
                        <select name="day">
                            <option value="1">01</option>
                            <option value="2">02</option>
                            <option value="3">03</option>
                            <option value="4">04</option>
                            <option value="5">05</option>
                            <option value="6">06</option>
                            <option value="7">07</option>
                            <option value="8">08</option>
                            <option value="9">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="31">31</option>
                        </select> <select name="month">
                            <option value="0">January</option>
                            <option value="1">February</option>
                            <option value="2">March</option>
                            <option value="3">April</option>
                            <option value="4">May</option>
                            <option value="5">June</option>
                            <option value="6">July</option>
                            <option value="7">August</option>
                            <option value="8">September</option>
                            <option value="9">October</option>
                            <option value="10">November</option>
                            <option value="11">December</option>
                        </select> <select name="year">
                            <option value="2010">2010</option>
                        </select></td></tr>
                <tr><td>Time: </td><td>
                        <select name="hour">
                            <option value="1">01</option>
                            <option value="2">02</option>
                            <option value="3">03</option>
                            <option value="4">04</option>
                            <option value="5">05</option>
                            <option value="6">06</option>
                            <option value="7">07</option>
                            <option value="8">08</option>
                            <option value="9">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select> :
                        <select name="minute">
                            <option value="0">00</option>
                            <option value="1">01</option>
                            <option value="2">02</option>
                            <option value="3">03</option>
                            <option value="4">04</option>
                            <option value="5">05</option>
                            <option value="6">06</option>
                            <option value="7">07</option>
                            <option value="8">08</option>
                            <option value="9">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="31">31</option>
                            <option value="32">32</option>
                            <option value="33">33</option>
                            <option value="34">34</option>
                            <option value="35">35</option>
                            <option value="36">36</option>
                            <option value="37">37</option>
                            <option value="38">38</option>
                            <option value="39">39</option>
                            <option value="40">40</option>
                            <option value="41">41</option>
                            <option value="42">42</option>
                            <option value="43">43</option>
                            <option value="44">44</option>
                            <option value="45">45</option>
                            <option value="46">46</option>
                            <option value="47">47</option>
                            <option value="48">48</option>
                            <option value="49">49</option>
                            <option value="50">50</option>
                            <option value="51">51</option>
                            <option value="52">52</option>
                            <option value="53">53</option>
                            <option value="54">54</option>
                            <option value="55">55</option>
                            <option value="56">56</option>
                            <option value="57">57</option>
                            <option value="58">58</option>
                            <option value="59">59</option>
                        </select>
                        <select name="ampm">
                            <option value="AM">AM</option>
                            <option value="PM">PM</option>
                        </select>
                    </td><td></td></tr>
                <tr><td>Maximum of players: </td><td><input type="text" name="maxPlayers" value="15"/></td><td></td></tr>
                <tr><td>Skill Level: </td><td><input type="text" name="skillLevel" value="Advanced"/></td><td></td></tr>
                <tr><td>Location: </td><td><input type="text" name="field" value="Hull Stadium"/></td><td></td></tr>
                <tr><td>Field Cost: </td><td><input type="text" name="fieldCost" value="450"/></td><td></td></tr>
                <tr><td>Address: </td><td><input type="text" name="address" value="42 Bedard"/></td><td></td></tr>
                <tr><td>City: </td><td><input type="text" name="city" value="Hull"/></td><td></td></tr>
                <tr><td>Notes: </td><td><input type="textarea" name="comments" value="vrwvrwbrw"/></td><td></td></tr>

                <tr><td></td><td align="right"><input type="submit" name="submit" value="create" /></td><td></td></tr>
            </table></div>
    </form>
    <p class="tags"><!--<strong>Tags:</strong> <a href="#">soccer</a> <a href="#">sports</a> <a href="#">pickup</a> <a href="#">team</a> <a href="#">players</a> <a href="#">group</a> <a href="#">enjoy</a> <a href="#">ball</a>--></p>

</div>