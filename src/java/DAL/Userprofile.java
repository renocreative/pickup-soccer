package DAL;
// Generated 18-Mar-2010 4:02:28 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Userprofile generated by hbm2java
 */
public class Userprofile  implements java.io.Serializable {


     private Integer userProfileId;
     private String firstName;
     private String lastName;
     private byte[] photo;
     private Set users = new HashSet(0);

    public Userprofile() {
    }

	
    public Userprofile(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Userprofile(String firstName, String lastName, byte[] photo, Set users) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.photo = photo;
       this.users = users;
    }
   
    public Integer getUserProfileId() {
        return this.userProfileId;
    }
    
    public void setUserProfileId(Integer userProfileId) {
        this.userProfileId = userProfileId;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public byte[] getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }




}

