package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL
{
	private Connection connection;
	private Statement statement;

	/**
	 * �������ݿ������
	 */
	public void CreateConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123456");
			statement = connection.createStatement();

		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * �ر����ݿ�
	 */
	public void CloseConnection()
	{
		if (statement != null)
		{
			try
			{
				statement.close();
			} 
			
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}

		if (connection != null)
		{
			try
			{
				connection.close();
			} 
			
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}

	}

	/**
	 * �ύ���ݿ�
	 */
	public void CommitConnection()
	{
		try
		{
			connection.commit();
		} 
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ����sql��ѯ���
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet ExecuteQuery(String sql)
	{
		try
		{
			return statement.executeQuery(sql);
		} 
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ��������ɾ���Ĳ�����
	 * 
	 * @param sql
	 */
	public void ExecuteUpdate(String sql)
	{
		try
		{
			statement.executeUpdate(sql);
		} 
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
