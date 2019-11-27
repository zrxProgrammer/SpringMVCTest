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
	 * 进行数据库的连接
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
	 * 关闭数据库
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
	 * 提交数据库
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
	 * 运行sql查询语句
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
	 * 运行增，删，改操作。
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
