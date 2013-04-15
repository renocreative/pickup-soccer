/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestModel;

import DAL.Game;
import DAL.Location;
import DAL.Recurrentgame;
import DAL.User;
import DAL.Userprofile;
import java.util.Date;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * This class performs all the bindings between request map attributes and the appropriate business objects.
 *
 * @author Renaud
 */
public class ModelBinder {

    public ModelBinder() {
    }

    public Game getGame(HttpServletRequest request) {

        //Create a Game object from form inputs
        
        Map<String, String[]> gameAttrs = request.getParameterMap();
        int day = Integer.parseInt(request.getParameter("day"));
        int month = Integer.parseInt(request.getParameter("month"));
        int year = Integer.parseInt(request.getParameter("year"));

        //Extract time components
        int minute = Integer.parseInt(request.getParameter("minute"));
        int hour = Integer.parseInt(request.getParameter("hour"));
        String ampm = request.getParameter("ampm");

        //Extract location info
        String fieldName = request.getParameter("field");
        String address = request.getParameter("address") + ", " + request.getParameter("city");

        Location location = new Location(fieldName, "", address);


        Game game = new Game();
        Date date = new Date();

        int gameId;
        String strGameId = request.getParameter("gameId");

        if(strGameId != null){
            gameId = Integer.parseInt(strGameId);
            game.setGameId(gameId);
        }
        

        //Insert date info about the game in the date object
        date.setDate(day);
        date.setMonth(month);
        date.setYear(year - 1900);

        if (ampm.equals("PM")) {
            hour += 12;
        }
        if (hour == 24) {
            hour = 0;
        }

        //Insert Time in the date object
        date.setHours(hour);
        date.setMinutes(minute);
        date.setSeconds(0);

        //gameAttrs["dateTime"] = new String[]{date + time};

        try {
            BeanUtils.populate(game, gameAttrs);
            game.setDateHeure(date);
            game.setLocation(location);
            User u = (User)request.getSession().getAttribute("user");
            game.setUser(u);
        } catch (Exception e) {
            //System.err("CreateGame - Populating Bean - IllegalAccessException");
            e.printStackTrace();
        }
        return game;
    }

    public User getUser(HttpServletRequest request) {
        //Create a User object from form inputs
        Map<String, String[]> userAttrs = request.getParameterMap();
        String email = request.getParameter("email");
        email = StringEscapeUtils.escapeHtml(email);
        String password = request.getParameter("password");
        String username = email;

        User user = new User();

        //Insert date info about the game in the date object
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);

        try {
            BeanUtils.populate(user, userAttrs);
        } catch (Exception e) {
            //System.err("CreateUser - Populating Bean - IllegalAccessException");
            e.printStackTrace();
        }
        return user;
    }
    //public String ValidateGameAttrs)(){}
}
