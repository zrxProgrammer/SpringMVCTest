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

	// �û���¼ҳ��
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

	// �û�ע��ҳ��
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

	// ��ʾ�û���Ϣ����
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

	// ɾ���û�
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

	// �޸�����
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
				// չʾ����
				ResultSet result = userService.Read("select * from user");

				// ���Ӵ���ɶ���
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
