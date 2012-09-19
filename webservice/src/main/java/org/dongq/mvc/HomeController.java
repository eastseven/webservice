package org.dongq.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is " + locale.toString());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
	 */

	@RequestMapping(value = "/test")
	public @ResponseBody Object test(HttpSession session) {
		Person p = new Person("EastSeven", 29);
		logger.debug(""+p);
		return p;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Object login(HttpServletRequest request) {
		String username = ServletRequestUtils.getStringParameter(request, "username", "username");
		String password = ServletRequestUtils.getStringParameter(request, "password", "password");
		User user = new User();
		user.setPerson(new Person("EastSeven", 29));
		user.setUsername(username);
		user.setPassword(password);
		
		JsonResult result = new JsonResult();
		if(username.equalsIgnoreCase("eastseven@foxmail.com") && password.equalsIgnoreCase("123")) {
			result.setData(user);
		} else {
			result.setSuccess(Boolean.FALSE);
			result.setMsg("账号或者密码错误");
		}
		
		logger.debug(""+result);
		
		return result;
	}
}
