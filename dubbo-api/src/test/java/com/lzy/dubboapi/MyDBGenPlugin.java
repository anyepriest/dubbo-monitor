package com.lzy.dubboapi;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;
import java.util.Properties;

public class MyDBGenPlugin extends PluginAdapter
{
    private boolean customSerializable;

    @Override
    public void setProperties(Properties properties)
    {
        super.setProperties(properties);
        if (properties.getProperty("customSerializable") == null)
        {
            customSerializable = true;
        }
        else
        {
            customSerializable = Boolean.valueOf(properties.getProperty("customSerializable"));
        }
    }

    /**
     * 用于创建Record class（主Class）类
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
    {
        makeSerializableFiled(topLevelClass, introspectedTable);
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    /**
     * 用于创建主键（KeyClass）类
     */
    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
    {
        makeSerializableFiled(topLevelClass, introspectedTable);
        return true;
    }

    /**
     * 用于创建包含所有BLOB列的类
     */
    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
    {
        makeSerializableFiled(topLevelClass, introspectedTable);
        return true;
    }

    /**
     * 用于创建Example类
     */
    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
    {
        makeSerializableFiled(topLevelClass, introspectedTable);
        return true;
    }

    protected void makeSerializableFiled(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
    {
        if (customSerializable)
        {
            Field field = new Field();
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * 序列化默认编号");
            field.addJavaDocLine(" */");
            field.setFinal(true);
            field.setInitializationString("1L");
            field.setName("serialVersionUID");
            field.setStatic(true);
            field.setType(new FullyQualifiedJavaType("long"));
            field.setVisibility(JavaVisibility.PRIVATE);
            context.getCommentGenerator().addFieldComment(field, introspectedTable);
            topLevelClass.addField(field);
        }
    }
    @Override
    public boolean validate(List<String> warnings)
    {
        // TODO Auto-generated method stub
        return true;
    }

}
