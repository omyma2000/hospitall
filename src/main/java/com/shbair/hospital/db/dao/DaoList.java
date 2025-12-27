
package com.shbair.hospital.db.dao;

import java.util.List;

/**
 *
 * @author LCS
 * @param <T>
 */
// abstact class
public interface DaoList<T>  // generic 
{
    //عشان ندير منها  IMPLEMENT وقت نحتاجها 
    public List<T> LoadAll()throws Exception ;// ABSTRACT
    public int insert(T t)throws Exception;
    public int update(T t)throws Exception;
    public int delete(T t)throws Exception;
    public T getData(T t)throws Exception;
    public T getDataById(int id)throws Exception;
}
