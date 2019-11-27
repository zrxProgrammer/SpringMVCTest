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
	 * 增加数据的业务
	 * @param sql
	 */
	public void Create(String sql)
	{
		_baseDAO.Create(sql);

	}

	/**
	 * 查询数据的业务
	 * @return 
	 */
	public ResultSet Read(String sql)
	{
		return _baseDAO.Read(sql);

	}
	/**
	 * 修改数据的业务
	 */
	public void Update(String sql)
	{
		_baseDAO.Update(sql);

	}

	/**
	 * 删除数据的业务
	 */
	public void Delete(String sql)
	{
		_baseDAO.Delete(sql);

	}
	

	

}
