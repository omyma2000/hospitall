/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
    public List<T> LoadAll()throws Exception ;
    public String insert()throws Exception;
    public String update()throws Exception;
    public String delete()throws Exception;
    public T getData(T t)throws Exception;
}
