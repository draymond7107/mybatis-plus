package com.draymond.mybatisplus;


import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

/**
 * @Auther: ZhangSuchao
 * @Date: 2019/11/5 21:30
 */
public class TestMp {

    /**
     * 代生成器
     */
    @Test
    public void testGeneral() {
        // 1全局配置
        //  2数据源配置
        //  3策略配置
        //  4包策略配置
        //  5整合配置

        // 1全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)//是否开启AR模式
                .setAuthor("zsc")
                .setOutputDir("E:\\idealProjects\\mybatis-plus\\src\\main\\java\\com\\draymond")   //生成路径
                .setFileOverride(true)//文件覆盖
                .setIdType(IdType.AUTO) //主键策略：自增
                .setServiceName("%sService") //设置生成的service接口的名字是否为 I（I代表接口） 不需要
                .setBaseResultMap(true)
                .setBaseColumnList(true)    //sql片段
        ;
        //  2数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/practice?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT")
                .setUsername("root")
                .setPassword("123456")
      ;

        //  3策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)   //全局大写命名
                .setDbColumnUnderline(true)     //表名，字段名 是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel)   //数据库表映射到实体的命名
                .setTablePrefix("tb_")  //表前缀
                .setInclude("tb_user") //要生成的表（重点，可传多张）
        ;


        //  4包策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("base")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("beans")
                .setXml("mapper");

        //  5整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config).setDataSource(dsConfig).setStrategy(stConfig).setPackageInfo(pkConfig);
        ag.setTemplateEngine(new FreemarkerTemplateEngine());
        ag.execute();   //执行

    }
}