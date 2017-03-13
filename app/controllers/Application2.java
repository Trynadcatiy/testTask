package controllers;

import models.Guest;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import static play.libs.Json.toJson;

/**
 * Created by brus on 12.03.17.
 */
public class Application2 extends Controller {

    public static Result addGuest(){
        Guest guest = Form.form(Guest.class).bindFromRequest().get();
        guest.save();
        return redirect(routes.Application2.getGuests());
    }
    public static Result getGuests(){
        List<Guest> guests = new Model.Finder<>(String.class, Guest.class).all();
        return ok(toJson(guests));
    }
}
