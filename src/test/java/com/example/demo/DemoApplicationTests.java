package com.example.demo;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.example.demo.entity.User;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    UserInfoService userInfoService;

    @Test
    void contextLoads() {
        DataSource dataSourceMySql = applicationContext.getBean(DataSource.class);


        //生成文件配置
        EngineConfig engineConfig = EngineConfig.builder()
                //生成文件路径
                .fileOutputDir("E:\\SpringBoot")
                //打开目录
                .openOutputDir(false)
                //文件类型
                .fileType(EngineFileType.WORD)
                //生成模板实现
                .produceType(EngineTemplateType.freemarker).build();

        //生成文档配置(包含以下自定义版本号、描述等配置连接)
        Configuration config = Configuration.builder()
                .version("1.0.3")
                .description("springboot数据库说明")
                .dataSource(dataSourceMySql)
                .engineConfig(engineConfig)
                .produceConfig(getProcessConfig())
                .build();

        //执行生成
        new DocumentationExecute(config).execute();
    }
    public static ProcessConfig getProcessConfig(){
        //忽略表名
        List<String> ignoreTableName = Arrays.asList("aa","test_group");
        //忽略表前缀
        List<String> ignorePrefix = Arrays.asList("sys","C");
        //忽略表后缀
        List<String> ignoreSuffix = Arrays.asList("_test","czb_");

        return ProcessConfig.builder()
                //根据名称指定表生成
                .designatedTableName(new ArrayList<>())
                //根据表前缀生成
                .designatedTablePrefix(new ArrayList<>())
                //根据表后缀生成
                .designatedTableSuffix(new ArrayList<>())
                //忽略表名
                .ignoreTableName(ignoreTableName)
                //忽略表前缀
                .ignoreTablePrefix(ignorePrefix)
                //忽略表后缀
                .ignoreTableSuffix(ignoreSuffix).build();
    }

}
