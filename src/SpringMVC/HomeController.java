package SpringMVC;

import java.sql.ResultSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import Service.UserService;
import model.user;

@Controller
@RequestMapping("/Home")
public class HomeController
{
	UserService userService = new UserService();

	@RequestMapping(value = "/Index")
	public ModelAndView Index()
	{
		// չʾ����
		ResultSet result = userService.Read("select * from user");

		//���Ӵ���ɶ��� 
		List<user> usermodel=userService.ResultsetToList(result);
		
		ModelAndView View = new ModelAndView();
		View.addObject("userDataList", usermodel);
		View.setViewName("Index");
		return View;
	}

	// �û���¼ҳ��
	@RequestMapping(value = "/Index", method = RequestMethod.POST)
	public String Index(user model)
	{
		String result = userService.Login(model);

		if (result.equals("true"))
		{
			return "True";
		}
		else
		{
			return "False";
		}

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
