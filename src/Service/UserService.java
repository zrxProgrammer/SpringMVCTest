package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.UserDAO;
import model.user;

public class UserService extends BaseService<user>
{

	private static UserDAO userDAO = new UserDAO();

	public UserService()
	{
		super(userDAO);
	}

		
	/**
	 * 用户进行登录的业务
	 * @param model 用户的bean对象
	 * @return 如果业务正确则返回 "true" 如果错误则返回错误提示信息
	 */
	public String Login(user model)
	{
		try
		{

			ResultSet result = Read("select * from user where username='" + model.getUsername() + "'");
			if (result.next())
			{
				if (model.getPassword().equals(result.getString("password")))
				{
					return "true";
				} 
				
				else
				{
					return "密码错误";
				}
			}

			else
			{
				return "账号不存在";
			}
		} 
		
		catch (Exception e)
		{
			return "账号不存在";
		}

	}

	/**
	 *  用户进行注册的业务
	 * @param model 用户的bean对象
	 * @return 如果业务正确则返回 "true" 如果错误则返回错误提示信息
	 */
	public String Register(user model)
	{
			
		try
		{
			ResultSet result=Read("select * from user where username='"+model.getUsername()+"'");
			if (result.next())
			{
				return "该账户已经存在！！";
			}
			
			else
			{
				Create("insert into user (username,password) value('"+model.getUsername()+"','"+model.getPassword()+"')");
				return "true";
			}
						
		} 
		
		catch (SQLException e)
		{
			e.printStackTrace();
			return "反正有错误！！(可能是result.next()为false)";
		}
		
	}
	
	/**
	 * 修改密码的业务
	 * @param username 用户名
	 * @param OldPassword 原密码
	 * @param NewPassowrd 新密码
	 * @param ReNewPassword 重复新密码
	 * @return
	 */
	public String UpdatePwd(String username,String OldPassword,String NewPassowrd,String ReNewPassword) 
	{
		ResultSet result=Read("select * from user where username='"+username+"'");
		try
		{
			if (result.next())
			{
				if (result.getString("password").equals(OldPassword))
				{
					if (!OldPassword.equals(NewPassowrd))
					{
						if (NewPassowrd.equals(ReNewPassword))
						{
							Update("update user set password='"+NewPassowrd+"' where username='"+username+"'");
							return "true";
						}
					}
				}
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "false";
		
	}
	
	
	
	
	/**
	 *  将查询到的Result转换成List
	 * @param ResultSet 查询返回的ResultSet类型
	 * @return 返回user泛型的List usermodel
	 */
	public List<user> ResultsetToList(ResultSet ResultSet)
	{
	
			List<user> usermodel = new ArrayList<user>();
			try
			{
				while (ResultSet.next())
				{
					user currentUser = new user();
					currentUser.setUsername(ResultSet.getString("username"));
					currentUser.setPassword(ResultSet.getString("password"));
					currentUser.setId(ResultSet.getInt("id"));
					usermodel.add(currentUser);
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return usermodel;


	}
}
