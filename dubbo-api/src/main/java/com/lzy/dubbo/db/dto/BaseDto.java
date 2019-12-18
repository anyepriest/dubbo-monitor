package com.lzy.dubbo.db.dto;


import com.lzy.common.web.SerializableClass;

/**
 * 所有数据对象继承的基类,包含公共方法
 * 
 * @author Pangxy
 *
 */
public class BaseDto extends SerializableClass implements Cloneable
{
    private static final long serialVersionUID = 6050694257108608689L;

    public Object clone()
    {
        Object o = null;
        try
        {
            o = super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return o;
    }
}
