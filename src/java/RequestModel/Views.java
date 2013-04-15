package RequestModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import DAL.*;

/**
 *
 * This class encapsulates all the logic of views pre-rendering.
 *
 * Each method represents the pre-rendering process of a specific view request of the web application.
 *
 * @author Renaud
 */
public class Views {
    /* Requestable Views */
    final public String MASTERPAGE = "/template.jsp";
    final public String LOGIN = "/login.jsp";
    final public String REGISTER_USER = "/register.jsp";
    final public String HOME = "/home.jsp";
    final public String GAME_LIST = "/games.jsp";
    final public String CREATE_GAME = "/createGame.jsp";
    final public String VIEW_GAME = "/viewGame.jsp";
    final public String EDIT_GAME = "/editGame.jsp";
    final public String ERROR = "/error.jsp";

    public String login( HttpServletRequest request, User user, String message ) {
        request.setAttribute( "user", user );
        request.setAttribute( "message", message );
        request.setAttribute( "title", "Login");
        return ( LOGIN );
    }

    public String registerUser( HttpServletRequest request, User user, String message ) {
        request.setAttribute( "user", user );
        request.setAttribute( "message", message );
        request.setAttribute( "title", "Login");
        return ( REGISTER_USER );
    }

    public String home( HttpServletRequest request, List<Game> games, String message ) {
        request.setAttribute( "games", games );
        request.setAttribute( "message", message );
        request.setAttribute( "title", "Home pickup");
        return ( HOME );
    }

    public String gameList( HttpServletRequest request, List<Game> games, String message ) {
        request.setAttribute( "games", games );
        request.setAttribute( "message", message );
        request.setAttribute( "title", "List of games");
        return ( GAME_LIST );
    }

    public String createGame( HttpServletRequest request, Game game, String message ) {
        request.setAttribute( "game", game );
        request.setAttribute( "message", message );
        request.setAttribute( "title", "Create a game");
        return ( CREATE_GAME );
    }

    public String viewGame( HttpServletRequest request, Game game, String message ) {
        request.setAttribute( "game", game );
        request.setAttribute( "message", message );
        request.setAttribute( "title", "View game");
        return ( VIEW_GAME );
    }

    public String editGame( HttpServletRequest request, Game game, String message ) {
        request.setAttribute( "game", game );
        request.setAttribute( "message", message );
        request.setAttribute( "title", "Edit game");
        return ( EDIT_GAME );
    }

    public String error( HttpServletRequest request, String message ) {
        request.setAttribute( "message", message );
        request.setAttribute( "title", "Error");
        return ( ERROR );
    }
}
