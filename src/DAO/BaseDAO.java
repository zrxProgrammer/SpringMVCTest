package DAO;

import java.sql.ResultSet;
import model.BaseModel;

public class BaseDAO<T extends BaseModel> //对T进行约束  t必须是baseModel类型
{

	private MySQL Db = new MySQL();;

	public BaseDAO()
	{
		Db.CreateConnection();

	}

	/**
	 * 新建数据的操作
	 * @param sql 
	 */
	public void Create(String sql)
	{
		Db.ExecuteUpdate(sql);

	}


	/**
	 * 修改数据的操作
	 */
	public void Update(String sql)
	{
		Db.ExecuteUpdate(sql);

	}
	
	/**
	 * 删除数据的操作
	 */
	public void Delete(String sql)
	{
		Db.ExecuteUpdate(sql);

	}

	
	/**
	 * 查询数据库的操作
	 */
	public ResultSet Read(String sql)
	{
		
		return Db.ExecuteQuery(sql);

	}
	
	


	
}
