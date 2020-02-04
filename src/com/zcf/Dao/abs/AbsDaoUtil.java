package com.zcf.Dao.abs;

import java.util.Map;
import java.util.Objects;

/**
 * 方法集合
 */
abstract  class AbsDaoUtil {
    /**
     * 新增
     * @param username
     * @param password
     * @param name
     * @param gh
     * @param mobile
     * @return int
     */
    public  abstract  int  AddEidt(String username,String password,String name,String gh,String mobile);

    /**
     *删除
     * @param username
     * @return int
     */
    public  abstract  int  DeletEdit(String username);

    /**
     * 查询后返回该name的全部信息集合
     * @param username
     * @return map
     */
    public  abstract Map<Object, Objects>  UserMap(String username);

    /**
     * 登录查询发法
     * @param username
     * @param passwrod
     * @return int
     */
    public  abstract int Login(String username,String passwrod);

    /**
     * 修改数据
     * @param map
     * @return
     */
    public abstract  void  Update(Object map);


}
