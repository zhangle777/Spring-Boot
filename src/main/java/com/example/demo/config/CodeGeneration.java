package com.example.demo.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;

/**
 * 代码生成器
 */
public class CodeGeneration {


    private static String packageName="demo";    //文件路径
    private static String table="sc_user";                  //table名字
    private static String prefix="sc_";                     //table前缀
    private static File file = new File(packageName);
    private static String path = file.getAbsolutePath();

    public static void main(String[] args) {

        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(path+"/src/main/java");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("zhangle");// 作者

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sAction");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        autoGenerator.setGlobalConfig(gc);

        // 数据源配置
        com.baomidou.mybatisplus.generator.config.DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        autoGenerator.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
//        strategy.setTablePrefix(new String[] { "sys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] { "user" }); // 需要生成的表

        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        autoGenerator.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.ahut");
        pc.setController("action");
        pc.setService("service");
        pc.setServiceImpl("serviceImpl");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setXml("xml");
        autoGenerator.setPackageInfo(pc);

        // 执行生成
        autoGenerator.execute();

    }
}
