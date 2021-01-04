package com.vip.file.config;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * 代码生成器
 *
 * @author LEON
 * @date 2020/03/26 12:04
 */
public class MyCodeGenerator {

    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        /**
         * TODO 继承BaseEntity的表
         */
        String[] tableNames = {"tb_files"};
        /**
         * TODO 不继承BaseEntity的表
         */
        String[] tableNames2 = {};

        for (String tableName : tableNames) {
            generator(tableName, true);
        }
        if (tableNames2.length > 0) {
            for (String tableName : tableNames2) {
                generator(tableName, false);
            }
        }
    }

    /**
     * 代码自动生成主类
     *
     * @param tableName       表名
     * @param isExtBaseEntity 是否继承基础实体
     */
    private static void generator(String tableName, boolean isExtBaseEntity) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        /**
         * 全局策略配置
         */
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        // TODO 换为相应所在项目名
        gc.setOutputDir(projectPath + "/src/main/java");
        // TODO 作者
        gc.setAuthor("LEON");
        // 是否覆盖 默认false
        gc.setFileOverride(true);
        // 是否打开输出目录
        gc.setOpen(false);
        //启用swagger2注解
        gc.setSwagger2(true);
        // 是否在生成的Mapper文件中加入BaseColumnList
        gc.setBaseColumnList(true);
        // 注入全局策略配置
        mpg.setGlobalConfig(gc);

        /**
         * 数据源配置
         */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.25.93:3306/vip_file_manager?useUnicode=true&amp;characterEncoding=UTF-8");
        dsc.setSchemaName("vip_file_manager");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        /**
         * 包配置
         */
        PackageConfig pc = new PackageConfig();
        // TODO 生成的代码所在父包
        pc.setParent("com.vip.file");
        mpg.setPackageInfo(pc);

        /**
         * 模板配置
         */
        TemplateConfig templateConfig = new TemplateConfig();
        // TODO Mapper XML包名、Mapper包名、Controller包名、Service包名、ServiceImpl包名，null表示不生成， 默认生成
        templateConfig.setMapper(null);
        templateConfig.setController(null);
        templateConfig.setService(null);
        templateConfig.setXml(null);
        templateConfig.setServiceImpl(null);
        mpg.setTemplate(templateConfig);

        /**
         * 策略配置
         */
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 是否为lombok模型 默认false
        strategy.setEntityLombokModel(true);
        // controller类是否直接返回json
        strategy.setRestControllerStyle(true);
        // 需要包含的表名
        strategy.setInclude(tableName);
        // 命名规则：驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 生成实体继承BaseEntity，根据参数isExtBaseEntity判断是否继承
        if (isExtBaseEntity) {
            strategy.setSuperEntityClass("com.vip.file.entity.BaseEntity");
            strategy.setSuperEntityColumns("id", "created_time", "modified_time", "delete_status");
        }
        // TODO 生成的entity、service、controller去除前缀
        strategy.setTablePrefix("tb_");
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
