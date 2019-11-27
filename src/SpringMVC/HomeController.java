package SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Service.*;

@Controller
@RequestMapping("/Home")
public class HomeController
{
	UserService userService= new UserService();
	
	@RequestMapping(value="/Index")
	public String Index()
	{
		return "Index";	
	}
	
	//用户进行登录
	@RequestMapping(value="/Index",method=RequestMethod.POST)
	public String Index(String username,String password)
	{
		String result=userService.Login(username, password);
		
		if (result.equals("true"))
		{
			return "True";
		} 
		else
		{
			return "False";
		}
		
	}


	@RequestMapping(value="/Register")
	public String Register()
	{
		return "Register";
	}
	
	//用户进行注册
	@RequestMapping(value="/Register",method=RequestMethod.POST)
	public String Register(String username,String password)
	{
		String result=userService.Register(username, password);
		
		if (result.equals("true"))
		{
			return "True";
		}
		
		else 
		{
			return "False";
		}
	}
	
	
	
	
	@RequestMapping("/True")
	public String True()
	{
		return "True";
	}
	
	@RequestMapping("/False")
	public String False()
	{
		return "False";
	}
	

}
