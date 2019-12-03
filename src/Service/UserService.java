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
	 * �û����е�¼��ҵ��
	 * @param model �û���bean����
	 * @return ���ҵ����ȷ�򷵻� "true" ��������򷵻ش�����ʾ��Ϣ
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

	/**
	 *  �û�����ע���ҵ��
	 * @param model �û���bean����
	 * @return ���ҵ����ȷ�򷵻� "true" ��������򷵻ش�����ʾ��Ϣ
	 */
	public String Register(user model)
	{
			
		try
		{
			ResultSet result=Read("select * from user where username='"+model.getUsername()+"'");
			if (result.next())
			{
				return "���˻��Ѿ����ڣ���";
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
			return "�����д��󣡣�(������result.next()Ϊfalse)";
		}
		
	}
	
	/**
	 * �޸������ҵ��
	 * @param username �û���
	 * @param OldPassword ԭ����
	 * @param NewPassowrd ������
	 * @param ReNewPassword �ظ�������
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
	 *  ����ѯ����Resultת����List
	 * @param ResultSet ��ѯ���ص�ResultSet����
	 * @return ����user���͵�List usermodel
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
