/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import DAL.User;
import DAL.Game;
import BL.BusinessProcessor;
import BL.BusinessException;
import RequestModel.Actions;
import RequestModel.Views;
import RequestModel.ModelBinder;
import java.util.List;
import org.apache.commons.lang.StringEscapeUtils;

/**
 *
 * @author Renaud
 */
public class GameController extends HttpServlet {

    private BusinessProcessor business = null;
    private ModelBinder modelBinder = null;
    final private Views views = new Views();
    final private Actions actions = new Actions();
    private String encoding;

    /** 
     * Inits servlet.
     * @throws ServletException if a servlet-specific error occurs
     */
    @Override
    final public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        encoding = config.getInitParameter("PARAMETER_ENCODING");

        BusinessProcessor bp = new BusinessProcessor();
        //b.setDataDir( c.getInitParameter( "dataDir" ) );
        try {
            bp.init();
        } catch (BusinessException e) {
            throw new ServletException(e.getMessage());
        }
        business = bp;
        modelBinder = new ModelBinder();
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, UnsupportedEncodingException {
        if (encoding != null) {
            request.setCharacterEncoding(encoding);
        }

        try {
            String view = beforeAll(request);
            if (view == null) {
                view = processAction(request);
            }
            if (view != null) {
                view = beforeView(view, request);
            }
            if (view != null) {
                processView(view, request, response);
            }
        } catch (Throwable t) {
            String view = views.error(request, t.getMessage());
            if (view != null) {
                try {
                    processView(view, request, response);
                } catch (Throwable e) {
                    throw new ServletException(e);
                }
            }
        } finally {
            afterAll(request);
        }
    }

    /**
     * Identify the request type.
     *
     * The client request a view to be render or a action to be performed
     * A view request will have the servlet context path containing the string '.jsp' or '.jspx'
     * Otherwise, it is a action request
     *
     * @param request servlet request
     * @throws ServletException if a servlet-specific error occurs
     */
    protected String beforeAll(HttpServletRequest request)
            throws ServletException {
        // Get the current time
        request.setAttribute("timer", System.currentTimeMillis());

        String path = request.getPathInfo();

        String view = null;
        if (path.endsWith(".jsp") || path.endsWith(".jspx")) {
            //View Request
            view = path;
        } else {
            //Action Request
            view = null;
        }
        return view;
    }

    /**
     * Processes the request and performs the required action.
     * @param request servlet request
     * @return the name of the view to be rendered
     * @throws ServletException if a servlet-specific error occurs
     */
    protected String processAction(HttpServletRequest request)
            throws ServletException, UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getPathInfo();

        if (action.equals(actions.AUTHENTICATE)) {
            return doLogin(request);
        }
        if (action.equals(actions.LOGOUT)) {
            return doLogout(request);
        }
        if (action.equals(actions.REGISTER_USER)) {
            return doRegisterUser(request);
        }
        if (action.equals(actions.UPDATE_USER)) {
            return doUpdateUser(request);
        }
        if (action.equals(actions.CREATE_GAME)) {
            return doCreateGame(request);
        }
        if (action.equals(actions.UPDATE_GAME)) {
            return doUpdateGame(request);
        }
        // other actions
        throw new ServletException("Unknown action " + action + ".");
    }

    /**
     * Executes pre-process operations such as authentication and other pre-conditions check upon requests.
     * @param view the view to render
     * @param request servlet request
     * @throws ServletException if a servlet-specific error occurs
     */
    protected String beforeView(String view, HttpServletRequest request)
            throws ServletException {

        try {

            if (view.equals(views.LOGIN)) {
                if (isSessionOpened(request))
                    return views.HOME;
                if(request.getPathInfo().equals(actions.LOGOUT))
                    return views.login(request, new User(), (String)request.getAttribute("message"));
                return views.login(request, new User(), null);
            } else if (view.equals(views.HOME)) {
                List<Game> games = business.retrieveGames();
                //request.getSession().setAttribute("user", new User());
                return views.home(request, games, null);
            } else if (view.equals(views.REGISTER_USER)) {
                return views.registerUser(request, new User(), null);
            } else if (view.equals(views.GAME_LIST)) {
                List<Game> games = business.retrieveGames();
                if(request.getPathInfo().equals(actions.CREATE_GAME))
                    return views.gameList(request, games, (String)request.getAttribute("message"));
                views.gameList(request, games, null);
            } else if (view.equals(views.VIEW_GAME)) {
                int gameId = Integer.parseInt((String) request.getParameter("gameId"));
                Game game = business.retrieveGame(gameId);
                if(request.getPathInfo().equals(actions.UPDATE_GAME))
                    return views.viewGame(request, game, (String)request.getAttribute("message"));
                views.viewGame(request, game, null);
            } else if (view.equals(views.CREATE_GAME) || view.equals(views.EDIT_GAME)) {
                //Check authorization - the user should have been authentified
                // Perform authentication
                if (!isSessionOpened(request)) {
                    return views.login(request, new User(), "You must authenticate first !");
                }

                if (view.equals(views.CREATE_GAME)) {
                    views.createGame(request, new Game(), null);
                } else if (view.equals(views.EDIT_GAME)) {
                    int gameId = Integer.parseInt(request.getParameter("gameId"));
                    Game game = business.retrieveGame(gameId);
                    if (!isUserAuthorized(getSessionUser(request), game)) {
                        view = views.VIEW_GAME;
                        views.viewGame(request, game, "You are not allowed to edit this game !");
                    }else{
                        views.editGame(request, game, null);
                    }
                }
            } else {
                // page not found
                throw new ServletException("Page " + view + " not found.");
            }
        } catch (BusinessException e) {
            throw new ServletException(e.getMessage());
        }
        return view;
    }

    /**
     * Renders the view and dispatches the response.
     * @param view the view to render
     * @param request servlet request
     * @param response servlet reponse
     * @throws ServletException if a servlet-specific error occurs
     */
    protected void processView(String view, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (view.endsWith(".jsp") || view.endsWith(".jspx")) {
            // technologie JSP/JSPX
            if (view.equals(views.LOGIN) || 
                    view.equals(views.ERROR) ||
                    view.equals(views.REGISTER_USER)) { //Independent pages
                request.getRequestDispatcher(view).forward(request, response);

            } else { //Include in the masterpage
                request.setAttribute("view", view);

                User u = getSessionUser(request);
                if (u != null) {
                    String email = u.getEmail();
                    email = StringEscapeUtils.unescapeHtml(email);
                    u.setEmail(email);
                    request.getSession().setAttribute("user", u);
                }

                //encode url
                String urlEncoded = response.encodeURL(views.MASTERPAGE);
                request.getRequestDispatcher(urlEncoded).forward(request, response);
            }
        } else if (view.endsWith(".xsl")) {
            // technologie XSLT / JAXP
            //processXsltView( view, request, response );
        } else {
            // autres technologies
            throw new IllegalStateException("no view " + view);
        }
    }

    /**
     * Executes post-process operations.
     * @param view the view to render
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     */
    protected void afterAll(HttpServletRequest request)
            throws ServletException {
    }

    /**
     * Initiates a new client session or keep alive the existing one
     *
     * Adds the user object to the session each time.
     *
     * @param request servlet request
     * @param user the user object to be added to the session
     * @throws ServletException
     */
    public void openOrKeepAliveSession(HttpServletRequest request, User user) throws ServletException {
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
    }

    public boolean isSessionOpened(HttpServletRequest request) throws ServletException {
        return request.getSession(false) != null && getSessionUser(request) != null;
    }

    public User getSessionUser(HttpServletRequest request) throws ServletException {
        return (User) request.getSession().getAttribute("user");
    }

    /**
     * Performs authentication action.
     *
     * Authenticates the client from an existing session
     * or simply with user attributes pooled out from request
     *
     * @param request servlet request
     * @return the view to be rendered
     * @throws ServletException
     */
    public String doLogin(HttpServletRequest request) throws ServletException {
        User user = null;
        boolean authenticated = false;

        //Check if there is a current session
        HttpSession session = request.getSession(false);
        if (session != null) {
            try {
                //Get the current user
                user = getSessionUser(request);

                // Authenticate
                authenticated = business.authenticateUser(user);
            } catch (BusinessException e) {
                throw new ServletException(e.getMessage());
            }
            if (authenticated) {
                //Keep the session alive
                openOrKeepAliveSession(request, user);
                return views.HOME;
            }
        }

        // Bind user data from the request params
        user = modelBinder.getUser(request);

        // Check if no null parameter
        if (user.getEmail() == null || user.getPassword() == null) {
            return views.login(request, user, "Email and password should not be empty !");
        }

        // Check password validity
        if (user.getPassword().length() == 0) {
            return views.login(request, user, "Empty password !");
        }

        try {
            authenticated = business.authenticateUser(user);
            if (authenticated) {
                openOrKeepAliveSession(request, user);
                return views.HOME;
            }
            return views.login(request, user, "Wrong email or password !");
        } catch (BusinessException e) {
            throw new ServletException(e.getMessage());
        }
    }

    /**
     * Logs the user out of the web application
     *
     * @param request servlet request
     * @return the view to be rendered
     * @throws ServletException
     */
    public String doLogout(HttpServletRequest request) throws ServletException {
        request.getSession().setAttribute("user", null);
        return views.login(request, new User(), "Logout successful !");
    }

    /**
     *
     * Performs registration of a new user
     *
     * @param request servlet request
     * @return the view to be rendered
     * @throws ServletException
     */
    public String doRegisterUser(HttpServletRequest request) throws ServletException {
        User user = null;

        // Bind user data from the request params
        user = modelBinder.getUser(request);

        // Check if no null parameter
        if (user.getEmail() == null || user.getPassword() == null) {
            return views.login(request, user, "Email and password should not be empty !");
        }

        // Check password validity
        if (user.getPassword().length() == 0) {
            return views.login(request, user, "Empty password !");
        }

        boolean authenticated = false;
        try {
            //Register user
            user = business.registerUser(user);
            authenticated = business.authenticateUser(user);
            if (authenticated) {
                openOrKeepAliveSession(request, user);
                return views.HOME;
            }
            return views.error(request, "Problem occured during registration !");
        } catch (BusinessException e) {
            throw new ServletException(e.getMessage());
        }
    }

    /**
     * Updates the user out of the web application
     *
     * @param request servlet request
     * @return the view to be rendered
     * @throws ServletException
     */
    public String doUpdateUser(HttpServletRequest request) throws ServletException {
        throw new ServletException();
    }

    /**
     * creates a new game in the web application
     *
     * @param request servlet request
     * @return the view to be rendered
     * @throws ServletException
     */
    public String doCreateGame(HttpServletRequest request) throws ServletException {
        if (!isSessionOpened(request)) {
            return views.login(request, new User(), "You must login to create a game !");
        }

        Game game = modelBinder.getGame(request);
        try {
            business.createGame(game);
        } catch (BusinessException e) {
            throw new ServletException(e.getMessage());
        }
        return views.gameList(request, null, "Operation successful !");
    }

    /**
     * updates an existing game in the web application
     *
     * @param request servlet request
     * @return the view to be rendered
     * @throws ServletException
     */
    public String doUpdateGame(HttpServletRequest request) throws ServletException {
        if (!isSessionOpened(request)) {
            return views.login(request, new User(), "You must login to update the game !");
        }

        User user = getSessionUser(request);
        Game game = modelBinder.getGame(request);
        
        try{
            Game g = business.retrieveGame(game.getGameId());
            if (!isUserAuthorized(user, g)) {
                return views.editGame(request, game, "You are not allowed to edit this game !");
            }
            business.updateGame(game);
        } catch (BusinessException e) {
            throw new ServletException(e.getMessage());
        }
        return views.viewGame(request, game, "Operation successful !");
    }

    public boolean isUserAuthorized(User user, Game game) {
        return (user.getUsername().equals(game.getUser().getUsername()));
    }

    /** 
     * Handles the HTTP <code>GET</code> method..
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
