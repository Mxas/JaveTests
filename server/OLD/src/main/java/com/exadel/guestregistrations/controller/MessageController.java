package com.exadel.guestregistrations.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

@RestController
@RequestMapping("api/messages")

@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {
	
	private MessageSource messageSource;
	
	private static Locale locale = Locale.getDefault();
	
	@Autowired
	LocaleResolver localeResolver;
	
	public MessageController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public static Locale getLocale() {
		return locale;
	}
	
	@RequestMapping(value="/lang")
	public ModelMap getLanguage() {
		ModelMap map = new ModelMap();
		
		map.addAttribute("language", locale);
		
		return map;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/lang")
	public void setLanguage(@RequestBody ModelMap map) {
		LocaleContextHolder.setLocale(new Locale(map.get("language").toString()));
		locale = LocaleContextHolder.getLocale();
	}
	
	@RequestMapping(value="/home")
	public ModelMap homeMessages() {
		ModelMap map = new ModelMap();
		
		map.addAttribute("text", messageSource.getMessage("Home.Text", null, locale));
		map.addAttribute("selfRegistration", messageSource.getMessage("Home.Button.SelfRegistration", null, locale));
		map.addAttribute("endRegistration", messageSource.getMessage("Home.Button.EndRegistration", null, locale));
		
		return map;
	}
	
	@RequestMapping(value="/header")
	public ModelMap loginMessages() {
		ModelMap map = new ModelMap();
		
		map.addAttribute("english", messageSource.getMessage("Language.English", null, locale));
		map.addAttribute("lithuanian", messageSource.getMessage("Language.Lithuanian", null, locale));
		map.addAttribute("russian", messageSource.getMessage("Language.Russian", null, locale));

		map.addAttribute("return", messageSource.getMessage("Form.Button.Return", null, locale));
		
		map.addAttribute("login", messageSource.getMessage("Login.Button.Login", null, locale));
		map.addAttribute("logout", messageSource.getMessage("Login.Button.Logout", null, locale));
		map.addAttribute("dashboard", messageSource.getMessage("Login.Button.Dashboard", null, locale));
		map.addAttribute("username", messageSource.getMessage("Login.Form.Username", null, locale));
		map.addAttribute("password", messageSource.getMessage("Login.Form.Password", null, locale));
		map.addAttribute("notLoggedIn", messageSource.getMessage("Login.NotLoggedIn", null, locale));
		map.addAttribute("message", messageSource.getMessage("Login.Message", null, locale));
		
		return map;
	}
	
	@RequestMapping(value="/dashboard")
	public ModelMap dashboardMessages() {
		ModelMap map = new ModelMap();
		
		map.addAttribute("guests", messageSource.getMessage("Dashboard.Guests", null, locale));
		map.addAttribute("users", messageSource.getMessage("Dashboard.Users", null, locale));
		map.addAttribute("offices", messageSource.getMessage("Dashboard.Offices", null, locale));
		map.addAttribute("cards", messageSource.getMessage("Dashboard.Cards", null, locale));
		map.addAttribute("events", messageSource.getMessage("Dashboard.Events", null, locale));
		
		return map;
	}
	
	@RequestMapping(value="/unauthorized")
	public ModelMap unauthorizedMessage() {
		ModelMap map = new ModelMap();
		
		map.addAttribute("unauthorized", messageSource.getMessage("Unauthorized.Alert", null, locale));
		
		return map;
	}
	
	@RequestMapping(value="/offices")
	public ModelMap officeMessages() {
		ModelMap map = new ModelMap();
		
		map.addAttribute("offices", messageSource.getMessage("Dashboard.Offices", null, locale));
		
		map.addAttribute("adress", messageSource.getMessage("Dashboard.Offices.Adress", null, locale));
		map.addAttribute("users", messageSource.getMessage("Dashboard.Offices.Users", null, locale));
		
		map.addAttribute("submit", messageSource.getMessage("Form.Button.Submit", null, locale));
		map.addAttribute("return", messageSource.getMessage("Form.Button.Return", null, locale));
		
		return map;
	}
	
	@RequestMapping(value="/users")
	public ModelMap userMessages() {
		ModelMap map = new ModelMap();
		
		map.addAttribute("users", messageSource.getMessage("Dashboard.Users", null, locale));
		
		map.addAttribute("edit", messageSource.getMessage("Dashboard.Edit", null, locale));
		map.addAttribute("delete", messageSource.getMessage("Dashboard.Delete", null, locale));
		
		map.addAttribute("office", messageSource.getMessage("Dashboard.Office", null, locale));
		map.addAttribute("name", messageSource.getMessage("Dashboard.Name", null, locale));
		map.addAttribute("surname", messageSource.getMessage("Dashboard.Surname", null, locale));
		map.addAttribute("activation", messageSource.getMessage("Dashboard.Users.Activation", null, locale));
		map.addAttribute("active", messageSource.getMessage("Dashboard.Users.Activation.Active", null, locale));
		map.addAttribute("inactive", messageSource.getMessage("Dashboard.Users.Activation.Inactive", null, locale));
		map.addAttribute("username", messageSource.getMessage("Login.Form.Username", null, locale));
		map.addAttribute("password", messageSource.getMessage("Login.Form.Password", null, locale));
		
		map.addAttribute("formAdd", messageSource.getMessage("Dashboard.Users.Form.Add", null, locale));
		map.addAttribute("formEdit", messageSource.getMessage("Dashboard.Users.Form.Edit", null, locale));
		map.addAttribute("selectOffice", messageSource.getMessage("Dashboard.Form.SelectOffice", null, locale));
		map.addAttribute("activationStatus", messageSource.getMessage("Dashboard.Users.Form.SelectActivation", null, locale));
		
		map.addAttribute("submit", messageSource.getMessage("Form.Button.Submit", null, locale));
		map.addAttribute("return", messageSource.getMessage("Form.Button.Return", null, locale));
		
		return map;
	}
	
	@RequestMapping(value="/guests")
	public ModelMap guestMessages() {
		ModelMap map = new ModelMap();
		
		map.addAttribute("guests", messageSource.getMessage("Dashboard.Guests", null, locale));
		
		map.addAttribute("showCurrent", messageSource.getMessage("Dashboard.Guests.ShowCurrent", null, locale));
		map.addAttribute("showAll", messageSource.getMessage("Dashboard.Guests.ShowAll", null, locale));
		map.addAttribute("office", messageSource.getMessage("Dashboard.Office", null, locale));
		map.addAttribute("name", messageSource.getMessage("Dashboard.Name", null, locale));
		map.addAttribute("surname", messageSource.getMessage("Dashboard.Surname", null, locale));
		map.addAttribute("email", messageSource.getMessage("Dashboard.Guests.Email", null, locale));
		map.addAttribute("cardNumber", messageSource.getMessage("Dashboard.Cards.CardNumber", null, locale));
		map.addAttribute("arrivalDate", messageSource.getMessage("Dashboard.Guests.ArrivalDate", null, locale));
		map.addAttribute("leavingDate", messageSource.getMessage("Dashboard.Guests.LeavingDate", null, locale));
		map.addAttribute("photo", messageSource.getMessage("Dashboard.Guests.Photo", null, locale));
		map.addAttribute("close", messageSource.getMessage("Dashboard.Guests.Photo.Close", null, locale));
		map.addAttribute("changePhoto", messageSource.getMessage("Dashboard.Guests.Photo.Change", null, locale));
		map.addAttribute("deletePhoto", messageSource.getMessage("Dashboard.Guests.Photo.Delete", null, locale));
		
		map.addAttribute("phoneNo", messageSource.getMessage("Dashboard.Guests.Form.PhoneNo", null, locale));
		map.addAttribute("selectOffice", messageSource.getMessage("Dashboard.Form.SelectOffice", null, locale));
		map.addAttribute("anyCard", messageSource.getMessage("Dashboard.Guests.Form.AnyCard", null, locale));
		map.addAttribute("arrivalPurpose", messageSource.getMessage("Dashboard.Guests.Form.ArrivalPurpose", null, locale));
		map.addAttribute("conference", messageSource.getMessage("Dashboard.Guests.Form.ArrivalPurpose.Conference", null, locale));
		map.addAttribute("courses", messageSource.getMessage("Dashboard.Guests.Form.ArrivalPurpose.Courses", null, locale));
		map.addAttribute("internship", messageSource.getMessage("Dashboard.Guests.Form.ArrivalPurpose.Internship", null, locale));
		map.addAttribute("work", messageSource.getMessage("Dashboard.Guests.Form.ArrivalPurpose.Work", null, locale));
		map.addAttribute("other", messageSource.getMessage("Dashboard.Guests.Form.ArrivalPurpose.Other", null, locale));
		map.addAttribute("photoUpload", messageSource.getMessage("Dashboard.Guests.Form.PhotoUpload", null, locale));
		
		map.addAttribute("submit", messageSource.getMessage("Form.Button.Submit", null, locale));
		map.addAttribute("return", messageSource.getMessage("Form.Button.Return", null, locale));
		
		return map;
	}
	
	@RequestMapping(value="/cards")
	public ModelMap cardMessages() {
		ModelMap map = new ModelMap();
		
		map.addAttribute("cards", messageSource.getMessage("Dashboard.Cards", null, locale));
		
		map.addAttribute("cardNumber", messageSource.getMessage("Dashboard.Cards.CardNumber", null, locale));
		map.addAttribute("holderName", messageSource.getMessage("Dashboard.Cards.HolderName", null, locale));
		map.addAttribute("holderSurname", messageSource.getMessage("Dashboard.Cards.HolderSurname", null, locale));
		map.addAttribute("validFrom", messageSource.getMessage("Dashboard.Cards.ValidFrom", null, locale));
		map.addAttribute("validTo", messageSource.getMessage("Dashboard.Cards.ValidTo", null, locale));
		
		map.addAttribute("submit", messageSource.getMessage("Form.Button.Submit", null, locale));
		map.addAttribute("return", messageSource.getMessage("Form.Button.Return", null, locale));
		
		return map;
	}
	
	@RequestMapping(value="/calendar")
	public ModelMap calendarMessages() {
		ModelMap map = new ModelMap();
		
		map.addAttribute("jan", messageSource.getMessage("Calendar.January", null, locale));
		map.addAttribute("feb", messageSource.getMessage("Calendar.February", null, locale));
		map.addAttribute("mar", messageSource.getMessage("Calendar.March", null, locale));
		map.addAttribute("apr", messageSource.getMessage("Calendar.April", null, locale));
		map.addAttribute("may", messageSource.getMessage("Calendar.May", null, locale));
		map.addAttribute("jun", messageSource.getMessage("Calendar.June", null, locale));
		map.addAttribute("jul", messageSource.getMessage("Calendar.July", null, locale));
		map.addAttribute("aug", messageSource.getMessage("Calendar.August", null, locale));
		map.addAttribute("sep", messageSource.getMessage("Calendar.September", null, locale));
		map.addAttribute("oct", messageSource.getMessage("Calendar.October", null, locale));
		map.addAttribute("nov", messageSource.getMessage("Calendar.November", null, locale));
		map.addAttribute("dec", messageSource.getMessage("Calendar.December", null, locale));
		
		map.addAttribute("monday", messageSource.getMessage("Calendar.Monday", null, locale));
		map.addAttribute("tuesday", messageSource.getMessage("Calendar.Tuesday", null, locale));
		map.addAttribute("wednesday", messageSource.getMessage("Calendar.Wednesday", null, locale));
		map.addAttribute("thursday", messageSource.getMessage("Calendar.Thursday", null, locale));
		map.addAttribute("friday", messageSource.getMessage("Calendar.Friday", null, locale));
		map.addAttribute("saturday", messageSource.getMessage("Calendar.Saturday", null, locale));
		map.addAttribute("sunday", messageSource.getMessage("Calendar.Sunday", null, locale));
		
		map.addAttribute("mo", messageSource.getMessage("Calendar.Mo", null, locale));
		map.addAttribute("tu", messageSource.getMessage("Calendar.Tu", null, locale));
		map.addAttribute("we", messageSource.getMessage("Calendar.We", null, locale));
		map.addAttribute("th", messageSource.getMessage("Calendar.Th", null, locale));
		map.addAttribute("fr", messageSource.getMessage("Calendar.Fr", null, locale));
		map.addAttribute("sa", messageSource.getMessage("Calendar.Sa", null, locale));
		map.addAttribute("su", messageSource.getMessage("Calendar.Su", null, locale));
		
		return map;
	}
	
	@RequestMapping(value="/registration")
	public ModelMap registrationMessages() {
		ModelMap map = new ModelMap();
		
		map.addAttribute("welcome", messageSource.getMessage("Registration.Welcome", null, locale));
		map.addAttribute("name", messageSource.getMessage("Registration.Enter.Name", null, locale));
		map.addAttribute("surname", messageSource.getMessage("Registration.Enter.Surname", null, locale));
		map.addAttribute("email", messageSource.getMessage("Registration.Enter.Email", null, locale));
		map.addAttribute("phoneNo", messageSource.getMessage("Registration.Enter.PhoneNo", null, locale));
		map.addAttribute("leavingDate", messageSource.getMessage("Registration.LeavingDate", null, locale));
		map.addAttribute("photo", messageSource.getMessage("Registration.Photo", null, locale));
		
		map.addAttribute("thankYou", messageSource.getMessage("Registration.ThankYou", null, locale));
		map.addAttribute("closed", messageSource.getMessage("Registration.Closed", null, locale));
		
		map.addAttribute("arrivalPurpose", messageSource.getMessage("Dashboard.Guests.Form.ArrivalPurpose", null, locale));
		map.addAttribute("conference", messageSource.getMessage("Dashboard.Guests.Form.ArrivalPurpose.Conference", null, locale));
		map.addAttribute("courses", messageSource.getMessage("Dashboard.Guests.Form.ArrivalPurpose.Courses", null, locale));
		map.addAttribute("internship", messageSource.getMessage("Dashboard.Guests.Form.ArrivalPurpose.Internship", null, locale));
		map.addAttribute("work", messageSource.getMessage("Dashboard.Guests.Form.ArrivalPurpose.Work", null, locale));
		map.addAttribute("other", messageSource.getMessage("Dashboard.Guests.Form.ArrivalPurpose.Other", null, locale));
		
		map.addAttribute("submit", messageSource.getMessage("Form.Button.Submit", null, locale));
		map.addAttribute("return", messageSource.getMessage("Form.Button.Return", null, locale));
		
		return map;
	}
}
