package Service;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @return 如果业务正确则返回 "true" 如果错误则返回错误提示信息
	 */
	public String Login(String username, String password)
	{
		try
		{

			ResultSet result = Read("select * from user where username='" + username + "'");
			if (result.next())
			{
				if (password.equals(result.getString("password")))
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

	
	public String Register(String username, String password)
	{
		
		
		try
		{
			ResultSet result=Read("select * from user where username='"+username+"'");
			if (result.next())
			{
				System.out.println("该账户已经存在！！");
				return "该账户已经存在！！";
			}
			
			else
			{
				Create("insert into user (username,password) value('"+username+"','"+password+"')");
				return "true";
			}
			
			
		} 
		
		catch (SQLException e)
		{
				System.out.println("反正有错误！！(可能是result.next()为false)");
			e.printStackTrace();
			return "反正有错误！！(可能是result.next()为false)";
		}
		
	}
	
	
	
}
