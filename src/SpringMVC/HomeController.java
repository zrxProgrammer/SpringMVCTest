package SpringMVC;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import javax.servlet.http.HttpSession;

import Service.UserService;
import model.user;

@Controller
@RequestMapping("/Home")
public class HomeController
{
	UserService userService = new UserService();

	@RequestMapping(value = "/Index")
	public String Index()
	{
		return "Index";
	}

	// 用户登录页面
	@RequestMapping(value = "/Index", method = RequestMethod.POST)
	public ModelAndView Index(user model, HttpSession session)
	{
		String result = userService.Login(model);
		ModelAndView View = new ModelAndView();
		if (result.equals("true"))
		{
			session.removeAttribute("USERNAME");
			session.setAttribute("USERNAME", model.getUsername());
			System.out.println(session.getAttribute("USERNAME").toString());
			View.setViewName("redirect:True");

		}
		else
		{
			View.setViewName("redirect:False");
		}
		return View;
	}

	@RequestMapping(value = "/Register")
	public String Register()
	{
		return "Register";
	}

	// 用户注册页面
	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public String Register(user model)
	{

		String result = userService.Register(model);

		if (result.equals("true"))
		{
			return "redirect:True";
		}

		else
		{
			return "False";
		}
	}

	// 显示用户信息详情
	@RequestMapping(value = "/Details", method = RequestMethod.GET)
	public ModelAndView Details(String username) throws SQLException
	{
		// @RequestParam(name = "id", required = true) Integer id

		ResultSet result = userService.Read("select * from user where username='" + username + "'");

		ModelAndView View = new ModelAndView();

		if (result.next())
		{
			View.addObject("username", result.getString("username"));
			View.addObject("password", result.getString("password"));
		}
		View.setViewName("redirect:Details");
		return View;

	}

	// 删除用户
	@RequestMapping(value = "/Delete", method = RequestMethod.GET)
	public ModelAndView Delete(String username)
	{
		userService.Delete("delete from user where username='" + username + "'");

		return new ModelAndView("redirect:True");
	}

	@RequestMapping(value = "/UpdatePwd")
	public String UpdatePwd()
	{
		return "UpdatePwd";
	}

	// 修改密码
	@RequestMapping(value = "/UpdatePwd", method = RequestMethod.POST)
	public ModelAndView UpdatePwd(String OldPassword, String NewPassword, String ReNewPassword, HttpSession session)
	{
		String result = userService.UpdatePwd(session.getAttribute("USERNAME").toString(), OldPassword, NewPassword,ReNewPassword);
		if (result.equals("true"))
		{
			session.removeAttribute("USERNAME");
			return new ModelAndView("redirect:Index");
		}
		else
		{
			return new ModelAndView("redirect:UpdatePwd");
		}

	}

	@RequestMapping(value = "/True")
	public ModelAndView True(HttpSession session)
	{
		ModelAndView View = new ModelAndView();
		try
		{
			if (session.getAttribute("USERNAME").toString().equals(null))
			{
				View.setViewName("redirect:Index");
				return View;
			}
			else
			{
				// 展示数据
				ResultSet result = userService.Read("select * from user");

				// 增加代码可读性
				List<user> usermodel = userService.ResultsetToList(result);

				View.addObject("userDataList", usermodel);
				View.setViewName("True");
				return View;

			}

		}
		catch (Exception e)
		{
			View.setViewName("redirect:Index");
			return View;
		}

	}

	@RequestMapping("/False")
	public String False()
	{
		return "False";
	}

}
