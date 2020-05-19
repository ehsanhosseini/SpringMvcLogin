package com.mvcwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvcwebapp.login.UserValidationService;


//@Configuration // We dont use @Configuration we can use it but already defined in todo-servlet.xml " <context:component-scan base-package="com.mvcwebapp" />"
@Controller  // we need to tell spring this is controller. This would handle web request
public class LoginController {

	@Autowired
	UserValidationService service; 
	
	// add method to handle web request
	
	//This one just handle the get method. and when page load the request is get method 
	@RequestMapping(value = "/login" , method = RequestMethod.GET )  // mapping this url to this particular method 
	//@ResponseBody   // "Hello World" will send back as response, 
	public String showLoginPage1() {
		
		//return "Hello World";    // here we wnat to return just Hello World so we just used @ResponseBody
		
		return "login";    // we dont need @ResponseBody because we want to view the login.jsp. if I keep @ResponseBody then it just return login as a text.
							//here we use view controller to get to display the login.jsp.  We add the bean in web.xml for prefix and sufix
	}
	
	
	
	
	
	// Here we just handle post method. when we enter user and password so thoses request handle by Post method
	@RequestMapping(value = "/login" , method = RequestMethod.POST )
	public String handleLoginRequest(@RequestParam String name, 
								@RequestParam String password, ModelMap model) {  //Here we want to dispaly the name. the varibale is same as form(login.jsp) parameter "name".
																// In JavaEE servlet we used request.getParameter("name"); and set it in request.setAttribute("name", namee);
		
		boolean isValid = service.isUserValid(name, password);
		if(!isValid) {
			model.put("errormessage", "Invalide Cradentioal");
			return "login";
	}
		else {
			model.put("name", name);   //we use model to pass parameter between controller and view. whatever we want to be available for view we put it in model.
			model.put("password", password);
			return "welcome";
		}
	}
	}
	
