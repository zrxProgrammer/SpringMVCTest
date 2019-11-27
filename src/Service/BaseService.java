package Service;
import java.sql.ResultSet;

import DAO.*;
import model.BaseModel;

public class BaseService<T extends BaseModel>
{
	private BaseDAO<T> _baseDAO;
	
	 public BaseService(BaseDAO<T> baseDAO)
	{
		_baseDAO=baseDAO;
	}

	/**
	 * �������ݵ�ҵ��
	 * @param sql
	 */
	public void Create(String sql)
	{
		_baseDAO.Create(sql);

	}

	/**
	 * ��ѯ���ݵ�ҵ��
	 * @return 
	 */
	public ResultSet Read(String sql)
	{
		return _baseDAO.Read(sql);

	}
	/**
	 * �޸����ݵ�ҵ��
	 */
	public void Update(String sql)
	{
		_baseDAO.Update(sql);

	}

	/**
	 * ɾ�����ݵ�ҵ��
	 */
	public void Delete(String sql)
	{
		_baseDAO.Delete(sql);

	}
	

	

}
