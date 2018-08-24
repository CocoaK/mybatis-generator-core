package org.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

import java.util.List;

public class MyCustomPlugin extends PluginAdapter {

    /**
     * 生成mapper
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType mapper = new FullyQualifiedJavaType("BaseMapper<" + introspectedTable.getBaseRecordType()	+ ">");
        // FullyQualifiedJavaType imp = new FullyQualifiedJavaType("com.BaseMapper");
        interfaze.addSuperInterface(mapper);// 添加 extends BaseMapper<T>
        //  interfaze.addImportedType(imp);// 添加import common.BaseMapper;
        interfaze.getMethods().clear();
        return true;
    }

//    @Override
//    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        topLevelClass.setSuperClass("BaseModel");
//        //topLevelClass.addImportedType("com.BaseModel");
//        Field field = new Field("createdTime",FullyQualifiedJavaType.getIntInstance());
//        List<Field> list = topLevelClass.getFields();
//        List<Field> fields = new ArrayList<Field>();
//        for(Field f : list){
//            if(!"createdTime".equals(f.getName())){
//                fields.add(f);
//            }
//        }
//        topLevelClass.getFields().clear();
//        topLevelClass.getFields().addAll(fields);
//        return super.modelExampleClassGenerated(topLevelClass,  introspectedTable);
//    }

    /**
     * 生成mapping 添加自定义sql
     */
    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {

        XmlElement parentElement = document.getRootElement();
        // 增加base_query
        XmlElement sql = new XmlElement("sql");
        sql.addAttribute(new Attribute("id", "Base_Query_Cause"));
        //在这里添加where条件
        XmlElement selectTrimElement = new XmlElement("trim"); //设置trim标签
        selectTrimElement.addAttribute(new Attribute("prefix", "WHERE"));
        selectTrimElement.addAttribute(new Attribute("prefixOverrides", "AND | OR")); //添加where和and
        StringBuilder sb = new StringBuilder();
        for(IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            XmlElement selectNotNullElement = new XmlElement("if"); //$NON-NLS-1$
            sb.setLength(0);
            sb.append(introspectedColumn.getJavaProperty());
            sb.append(" != null");
            selectNotNullElement.addAttribute(new Attribute("test", sb.toString()));
            sb.setLength(0);
            // 添加and
            sb.append(" and ");
            // 添加别名t
//            sb.append("t.");
            sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
            // 添加等号
            sb.append(" = ");
            sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
            selectNotNullElement.addElement(new TextElement(sb.toString()));
            selectTrimElement.addElement(selectNotNullElement);
        }
        sql.addElement(selectTrimElement);
        parentElement.addElement(sql);

        // 公用select
        sb.setLength(0);
        sb.append("select ");
        sb.append("t.* ");
        sb.append("from ");
        sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        sb.append(" t");
        TextElement selectText = new TextElement(sb.toString());

        // 公用include
        XmlElement include = new XmlElement("include");
        include.addAttribute(new Attribute("refid", "Base_Query_Cause"));

        //创建Select查询
        XmlElement select = new XmlElement("select");
        select.addAttribute(new Attribute("id", "getAll"));
        select.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        //select.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        select.addElement(new TextElement("select * from "+ introspectedTable.getFullyQualifiedTableNameAtRuntime()));

        //创建Select查询
        XmlElement list = new XmlElement("select");
        list.addAttribute(new Attribute("id", "getList"));
        list.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        list.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        list.addElement(new TextElement("select * from "+ introspectedTable.getFullyQualifiedTableNameAtRuntime()));
        list.addElement(include);

        //创建Select查询
        XmlElement pageList = new XmlElement("select");
        pageList.addAttribute(new Attribute("id", "getPageList"));
        pageList.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        pageList.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        pageList.addElement(new TextElement("select * from "+ introspectedTable.getFullyQualifiedTableNameAtRuntime()));
        pageList.addElement(include);

        //创建Select查询,不启用缓存
        XmlElement queryPageList = new XmlElement("select");
        queryPageList.addAttribute(new Attribute("id", "queryPageList"));
        queryPageList.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        queryPageList.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        queryPageList.addAttribute(new Attribute("useCache", "false"));
        queryPageList.addElement(new TextElement("select * from "+ introspectedTable.getFullyQualifiedTableNameAtRuntime()));
        queryPageList.addElement(include);

        //创建Select查询,不启用缓存
        XmlElement queryList = new XmlElement("select");
        queryList.addAttribute(new Attribute("id", "queryList"));
        queryList.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        queryList.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        queryList.addAttribute(new Attribute("useCache", "false"));
        queryList.addElement(new TextElement("select * from "+ introspectedTable.getFullyQualifiedTableNameAtRuntime()));
        queryList.addElement(include);

        parentElement.addElement(select);
        parentElement.addElement(list);
        parentElement.addElement(pageList);
        parentElement.addElement(queryPageList);
        parentElement.addElement(queryList);
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    private void test(){

    }
}
