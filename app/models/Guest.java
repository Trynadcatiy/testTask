package models;


import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Guest extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    public String firstName;
    public String lastName;
    public String email;
    public String telNum;
    public static Finder<Long, Guest> find = new Finder<Long, Guest>(Long.class, Guest.class);

    @ManyToMany (cascade = CascadeType.ALL)
    public List<Restaurant> restaurants = new ArrayList<Restaurant>();

    public Guest (String firstName, String lastName, String email, String telNum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telNum = telNum;

    }

    public void addRestaurant (Restaurant restaurant){
        restaurants.add(restaurant);
    }

    public List<Restaurant> getRestaurants(){
        return restaurants;
    }

    public static Guest findByFirstName(String firstName){
        return find.where().eq("firstName", firstName).findUnique();
    }


}
