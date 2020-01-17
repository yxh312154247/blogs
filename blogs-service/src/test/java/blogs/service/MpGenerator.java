package blogs.service;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class MpGenerator {
    //数据库类型
    private static final DbType dbType = DbType.MYSQL;
    //数据库连结信息
    private static final String dbUrl = "jdbc:mysql://120.79.246.100:3306/rainbow?serverTimezone=GMT&useUnicode=true&characterEncoding=UTF-8&transformedBitIsBoolean=true&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String userName = "root";
    private static final String password = "Root12345";

    //项目名
    private static final String projectName = "blogs-service";
    //指定包名
    private static final String packageName = "blogs.service";
    //controller基础类
//    private static final String superControllerClass = packageName + ".common.BaseController";
    //entity基础类
//    private static final String superEntityClass = packageName + ".common.BaseEntity";
    //模块名 如果有模块名，则需在模块名前加. 例：.log
//    private static final String moduleName = "";
    //作者名
    private static final String author = "yangxianghua";
    //表前缀
//    private static final String[] tableNamesPrefix = new String[]{"sys_","ta_"};
    //指定生成的表名
    private static final String[] tableNames = new String[]{"user","sys_log","picture","message","link","category","article","article_link","article_picture"};

    /**
     * 根据表自动生成
     * @param serviceNameStartWithI 默认为false
     * @param packageName      包名
     * @param tableNames      表名
     */
    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        //配置数据源
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        // 策略配置
        StrategyConfig strategyConfig = getStrategyConfig(tableNames);
        //全局变量配置
        GlobalConfig globalConfig = getGlobalConfig(serviceNameStartWithI);
        //包名配置
        PackageConfig packageConfig = getPackageConfig(packageName);
        //自定义配置
        InjectionConfig injectioncfg = getInjectionConfig();
        //自动生成
        atuoGenerator(dataSourceConfig, strategyConfig, globalConfig, packageConfig,injectioncfg);
    }

    /**
     * 集成
     * @param dataSourceConfig 配置数据源
     * @param strategyConfig  策略配置
     * @param config      全局变量配置
     * @param packageConfig  包名配置
     */
    private static void atuoGenerator(DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig, GlobalConfig config, PackageConfig packageConfig,InjectionConfig  injectionConfig ) {

        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .setCfg(injectionConfig )
                //去除默认的xml文件，已改至相对路径
                .setTemplate(new TemplateConfig().setXml(null))
                .execute();
    }

    /**
     * 设置包名
     * @param packageName 父路径包名
     * @param packageName 模块名
     * @return PackageConfig 包名配置
     */
    private static PackageConfig getPackageConfig(String packageName) {
        return new PackageConfig()
                .setParent(packageName)
                .setEntity("pojo");
    }
    /**
     * 全局配置
     * @param serviceNameStartWithI false
     * @return GlobalConfig
     */
    private static GlobalConfig getGlobalConfig(boolean serviceNameStartWithI) {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                .setIdType(IdType.UUID)
                //XML ColumnList
                .setBaseColumnList(false)
                //XML ResultMap
                .setBaseResultMap(true)
                //XML 二级缓存
                .setEnableCache(false)
                //不需要ActiveRecord特性的请改为false
                .setActiveRecord(false)
                //作者
                .setAuthor(author)
                //设置输出路径
                .setOutputDir(getOutputDir())
                // 是否覆盖同名文件，默认是false
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            //设置service名
            globalConfig.setServiceName("%sService");
        }
        return globalConfig;
    }
    /**
     * 返回项目路径
     * @return 项目路径
     */
    private static String getOutputDir() {

//        String path = this.getClass().getClassLoader().getResource("").getPath();
//        int index = path.indexOf(projectName);
        return System.getProperty("user.dir") + "/" + projectName + "/src/test/java/";
    }
    /**
     * 策略配置
     * @param tableNames 表名
     * @return StrategyConfig
     */
    private static StrategyConfig getStrategyConfig(String... tableNames) {
        return new StrategyConfig()
                // 全局大写命名 ORACLE 注意
                .setCapitalMode(true)
                //从数据库表到文件的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                //表前缀
//                .setTablePrefix(tableNamesPrefix)
                //需要生成的的表名，多个表名传数组
                .setInclude(tableNames)
                //使用lombok
                .setEntityLombokModel(true)
                //rest风格
                .setRestControllerStyle(true);
    }

    /**
     * 自定义配置
     * @return InjectionConfig
     */
    private static InjectionConfig getInjectionConfig(){
        InjectionConfig icfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };

        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();

        // 自定义配置会被优先输出,配置mapper.xml
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //生成路径
                return System.getProperty("user.dir") + "/" + projectName + "/src/main/resources/mapper/" +tableInfo.getEntityName() + "Mapper";
            }
        });

        icfg.setFileOutConfigList(focList);
        return icfg;
    }
    /**
     * 配置数据源
     * @return 数据源配置 DataSourceConfig
     */
    private static DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig().setDbType(dbType)
                .setUrl(dbUrl)
                .setUsername(userName)
                .setPassword(password)
                .setDriverName(driver);
    }

    public static void main(String[] args) {
        generateByTables(false, packageName, tableNames);
    }
}
