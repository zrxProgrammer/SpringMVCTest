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
	 * �û����е�¼��ҵ��
	 * 
	 * @param username �û���
	 * @param password ����
	 * @return ���ҵ����ȷ�򷵻� "true" ��������򷵻ش�����ʾ��Ϣ
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
					return "�������";
				}
			}

			else
			{
				return "�˺Ų�����";
			}
		} 
		
		catch (Exception e)
		{
			return "�˺Ų�����";
		}

	}

	
	public String Register(String username, String password)
	{
		
		
		try
		{
			ResultSet result=Read("select * from user where username='"+username+"'");
			if (result.next())
			{
				System.out.println("���˻��Ѿ����ڣ���");
				return "���˻��Ѿ����ڣ���";
			}
			
			else
			{
				Create("insert into user (username,password) value('"+username+"','"+password+"')");
				return "true";
			}
			
			
		} 
		
		catch (SQLException e)
		{
				System.out.println("�����д��󣡣�(������result.next()Ϊfalse)");
			e.printStackTrace();
			return "�����д��󣡣�(������result.next()Ϊfalse)";
		}
		
	}
	
	
	
}
