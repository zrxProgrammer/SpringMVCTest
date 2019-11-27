package DAO;

import java.sql.ResultSet;
import model.BaseModel;

public class BaseDAO<T extends BaseModel> //��T����Լ��  t������baseModel����
{

	private MySQL Db = new MySQL();;

	public BaseDAO()
	{
		Db.CreateConnection();

	}

	/**
	 * �½����ݵĲ���
	 * @param sql 
	 */
	public void Create(String sql)
	{
		Db.ExecuteUpdate(sql);

	}


	/**
	 * �޸����ݵĲ���
	 */
	public void Update(String sql)
	{
		Db.ExecuteUpdate(sql);

	}
	
	/**
	 * ɾ�����ݵĲ���
	 */
	public void Delete(String sql)
	{
		Db.ExecuteUpdate(sql);

	}

	
	/**
	 * ��ѯ���ݿ�Ĳ���
	 */
	public ResultSet Read(String sql)
	{
		
		return Db.ExecuteQuery(sql);

	}
	
	


	
}
