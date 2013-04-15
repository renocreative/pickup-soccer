package DAL;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import java.util.Date;

/**
 *
 * @author RBougueng
 */
public class DBHelper {

    Session session = null;

    public DBHelper() throws HibernateException{
        this.session = getCurrentSession();
    }

    public static Session getCurrentSession(){
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    //DB request against user objects
    public List<User> getAllUsers() throws HibernateException {
        List<User> userList = null;

        session = getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from User");
        userList = (List<User>) query.list();

        return userList;

    }

    public User getUser(String username) throws HibernateException {
        User user = null;
        List<User> userList = null;

        userList = getAllUsers();
        for(User u : userList){
            if(u.getEmail().equals(username))
                user = u;
        }
        return user;

        /*session = getCurrentSession();
        session.beginTransaction();
        String strQuery = "select U from User where U.username = :username";
        Query query = session.createQuery(strQuery);
        userList = (List<User>) query.list();

        return userList.get(0);*/
    }

    public boolean saveOrUpdateUser(User user) throws HibernateException {
        //Persist the User instance
        session = getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
        session.flush();
        tx.commit();

        return true;
    }

    public boolean deleteUser(String email) throws HibernateException {
        User user = getUser(email);

        //Delete the Game instance
        session = getCurrentSession();
        session.beginTransaction();
        session.delete(user);
        session.flush();

        return true;
    }

    public List<Game> getAllGames() throws HibernateException {
        List<Game> gameList = null;

        //DB request against game objects
        session = getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Game");
        gameList = (List<Game>) query.list();

        return gameList;
    }

    public Game getGame(int gameId) throws HibernateException {
        List<Game> gameList = null;

        session = getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Game where gameId =" + gameId);
        gameList = (List<Game>) query.list();

        return gameList.get(0);
    }

    public Game searchGame(String location, Date dateTime) throws HibernateException {
        List<Game> gameList = null;

        session = getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Game where location =" + location
                + " AND dateHeure =" + dateTime);
        gameList = (List<Game>) query.list();

        return gameList.get(0);
    }

    public boolean saveOrUpdateGame(Game game) throws HibernateException {

        game.setGameState(2);

        //Persist the Game instance
        session = getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.saveOrUpdate(game);
        session.flush();
        tx.commit();

        return true;
    }

    public boolean deleteGame(int gameId) throws HibernateException {
        Game game = getGame(gameId);

        //Delete the Game instance
        session = getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(game);
        session.flush();
        tx.commit();

        return true;
    }

    public List<Location> getLocations(String locationName) throws HibernateException {
        List<Location> locationList = null;

        session = getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Location");
        locationList = (List<Location>) query.list();

        return locationList;

    }

    public Location getLocation(String location, Date dateTime) throws HibernateException {
        List<Location> locationList = null;

        session = getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Location where fieldName =" + location
                + " AND dateHeure =" + dateTime);
        locationList = (List<Location>) query.list();

        return locationList.get(0);
    }
}
