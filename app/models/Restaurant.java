package models;

import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    public String name;
    public String legalName;
    public String inn;
    public String adress;
    public static Finder<Long, Restaurant> find = new Finder<Long, Restaurant>(Long.class, Restaurant.class);

    @ManyToMany (mappedBy = "restaurants", cascade = CascadeType.ALL)
    public List<Guest> guests = new ArrayList<Guest>();

    public Restaurant (String name, String legalName, String inn, String adress){
        this.name = name;
        this.legalName = legalName;
        this.inn = inn;
        this.adress = adress;
    }

    public void addGuest(Guest guest){ //добавляем связь ресторана с посетителем
        guests.add(guest); //добавляем гостя
    }

    public List getGuests() {
        return guests;
    }

    public static Restaurant findByName (String name){
        return find.where().eq("name", name).findUnique();
    }
}
