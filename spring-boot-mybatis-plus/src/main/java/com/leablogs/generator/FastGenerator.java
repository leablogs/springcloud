package com.leablogs.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import io.micrometer.core.instrument.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FastGenerator {
    final static String dirPath = System.getProperty("user.dir");
    private static String url = "jdbc:mysql://leablogs.com:13307/sys?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "0205.leablogs.com";

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        methodA();
    }

    private static void methodA() {

        FastAutoGenerator.create(url, username, password)
                .globalConfig((scanner, builder) -> {
                    builder.author(scanner.apply("请输入作者名")) //set author
                            .fileOverride() // override has create file
                            .enableSwagger() // start swagger pattern
//                            .dateType()
                            .outputDir("D://mapper//");
                })
                .packageConfig((scanner, builder) -> {
                    builder.parent("com.leablogs") // 设置父级包名
//                            .entity()
//                            .controller()
//                            .service()
//                            .serviceImpl()
//                            .other()
                            .moduleName("user") // set parent module name
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://mapper//"));  //set mapperxml generate path
                })
                .strategyConfig((scanner, builder) -> {
                    builder.addInclude(getTables(scanner.apply("请输入表名，多个用，分割，所有请输入all")))
                            .addTablePrefix("lea_", "c_") //设置过滤表前缀
                            .controllerBuilder().enableRestStyle().enableHyphenStyle()
                            .entityBuilder().enableLombok().addTableFills(new Column("create_time", FieldFill.INSERT)).build();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用freeemark引擎模板 默认 velocity
                .execute();
    }

    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入").append("tip").append(":");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt))
                return ipt;
        }


        throw new MybatisPlusException("请输入正确的" + tip + "! ");
    }

    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

}























