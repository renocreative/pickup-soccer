package BL;

import DAL.*;
import org.hibernate.HibernateException;
import java.util.List;

/**
 *
 * This class encapsulate all the business logic of the web application.
 *
 * Each method implements a specific business process, an action required by the interacting client.
 *
 * @author Renaud
 */
public class BusinessProcessor {

    DBHelper db = null;

    /**
     * Inits the business processor.
     */
    final public void init() throws BusinessException{
        try{
            db = new DBHelper();
        }catch(HibernateException e){
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * Authenticate the user against the system.
     *
     * @param user the user object to authenticate
     * @return true if the user is successfully authenticated, false otherwise
     * @throws BusinessException if a business-specific error occurs
     */
    public boolean authenticateUser(User user) throws BusinessException {
        if(user == null)
            return false;
        User authUser = retrieveUser(user.getUsername());
        if (authUser == null)
            return false;
        String authenticator = authUser.getPassword();
        String password = user.getPassword();
        return authenticator.equals(password);
    }

    /**
     * Register a new user in the system.
     *
     * @param user the user object to register
     * @return the user object of the newly registered user
     * @throws BusinessException if a business-specific error occurs
     */
    public User registerUser(User user) throws BusinessException {
        try{
            db.saveOrUpdateUser(user);
        }catch(HibernateException e){
            throw new BusinessException(e.getMessage());
        }
        return retrieveUser(user.getUsername());
    }

    /**
     * Update an existing user in the system.
     *
     * @param user the user object containing the new user info
     * @return the user object containing the updated user info
     * @throws BusinessException if a business-specific error occurs
     */
    public User updateUser(User user) throws BusinessException {
        try{
            db.saveOrUpdateUser(user);
        }catch(HibernateException e){
            throw new BusinessException(e.getMessage());
        }
        return retrieveUser(user.getUsername());
    }

    /**
     * Retrieve a specific user from the system.
     *
     * @param user the user object to be retrieved
     * @return the identified user object of the system
     * @throws BusinessException if a business-specific error occurs
     */
    public User retrieveUser(String username) throws BusinessException {
        User user = null;
        try{
            user = db.getUser(username);
        }catch(HibernateException e){
            throw new BusinessException(e.getMessage());
        }
        return user;
    }

    /**
     * Retrieve a specific games from the system.
     *
     * @param game the game object to be retrieved
     * @return a list of all the games of the system
     * @throws BusinessException if a business-specific error occurs
     */
    public Game retrieveGame(int gameId) throws BusinessException {
        Game game = null;
        try{
            game = db.getGame(gameId);
        }catch(HibernateException e){
            throw new BusinessException(e.getMessage());
        }
        return game;
    }

    /**
     * Retrieve all games from the system.
     *
     * @return a list of all the games of the system
     * @throws BusinessException if a business-specific error occurs
     */
    public List<Game> retrieveGames() throws BusinessException {
        List<Game> games = null;
        try{
            games = db.getAllGames();
        }catch(HibernateException e){
            throw new BusinessException(e.getMessage());
        }
        return games;
    }

    /**
     * Create a new game.
     *
     * @param game the game object containing the attributes of the game to be created
     * @return the game newly created
     * @throws BusinessException if a business-specific error occurs
     */
    public Game createGame(Game game) throws BusinessException {
        try{
            db.saveOrUpdateGame(game);
        }catch(HibernateException e){
            throw new BusinessException(e.getMessage());
        }
        return retrieveGame(game.getGameId());
    }

    /**
     * Update an existing game in the system.
     *
     * @param game the game object containing the new game attributes
     * @return the game object containing the updated game attributes
     * @throws BusinessException if a business-specific error occurs
     */
    public Game updateGame(Game game) throws BusinessException {
        try{
            Game g = db.getGame(game.getGameId());
            g.setComments(game.getComments());
            g.setDateHeure(game.getDateHeure());
            g.setFieldCost(game.getFieldCost());
            g.setMaxPlayers(game.getMaxPlayers());
            g.setSkillLevel(game.getSkillLevel());
            g.setLocation(game.getLocation());
            g.setRecurrentgame(game.getRecurrentgame());

            db.saveOrUpdateGame(g);
        }catch(HibernateException e){
            throw new BusinessException(e.getMessage());
        }
        return retrieveGame(game.getGameId());
    }
}
