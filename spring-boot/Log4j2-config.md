# log4j2 配置详解

## 介绍

log4j2.x版本不再支持像1.x中的.properties后缀的文件配置方式，2.x版本配置文件后缀名只能为".xml",".json"或者".jsn"。 配置文件的格式：log2j配置文件可以是xml格式的，也可以是json格式的。
配置文件的位置：log4j2默认会在classpath目录下寻找log4j2.xml、log4j.json、log4j.jsn等名称的文件。 系统选择配置文件的优先级(从先到后)如下：

1. classpath下的名为log4j2-test.json 或者log4j2-test.jsn的文件.
2. classpath下的名为log4j2-test.xml的文件.
3. .classpath下名为log4j2.json 或者log4j2.jsn的文件.
4. .classpath下名为log4j2.xml的文件. 我们一般默认使用log4j2.xml进行命名。

## 日志级别

| 级别       | 说明 |
|----------|-----| 
| trace    |追踪，就是程序推进一下，可以写个trace输出|
| debug    |调试，一般作为最低级别，trace基本不用。|
| info     |输出重要的信息，使用较多|
| warn     |警告，有些信息不是错误信息，但也要给程序员一些提示。|
| error    |错误信息。用的也很多。|
| fatal    |致命错误|

## 输出源

| 类别        | 说明     |
|-----------|--------|
| CONSOLE   | 输出到控制台 |
| FILE      |    输出到文件 |

## 格式

| 类别              |    说明|
|-----------------|---|
| SimpleLayout    |以简单的形式显示|
| HTMLLayout      |    以HTML表格显示|
| PatternLayout   |    自定义形式显示|

## PatternLayout自定义日志布局

| 格式                      |    说明  |
|-------------------------|-----|
| %d{HH:mm:ss.SSS}        |表示输出到毫秒的时间|
| %-5r                    |输出从JVM启动到创建日志事件所经过的毫秒数|
| %t/%thread              |输出当前线程名称|
| %-5level/%-5p           |输出日志级别，-5表示左对齐并且固定输出5个字符，如果不足在右边补0|
| %logger                 |输出logger名称|
| %msg /%m                |日志文本|
| %n                      |换行|
| %F                      |输出所在的类文件名，如Log4j2Test.java|
| %L                      |输出行号|
| %M                      |输出所在方法名|
| %l                      |输出语句所在的行数, 包括类名、方法名、文件名、行数|
| %c/%c{3}                | 记录器名称           |
| %x                      |输出与生成日志事件的线程相关联的线程上下文堆栈(也称为嵌套诊断上下文或NDC)|
| %X                      |输出与生成日志事件的线程相关联的线程上下文映射(也称为映射诊断上下文或MDC)|
| %u{RANDOM\TIME}/%uuid{} |依照一个随机数或当前机器的MAC和时间戳来随机生成一个UUID |
| %C                      | 输出类名|
| %c                      | 输出发布日志事件的日志程序的名称|
## pom依赖

```pom
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <exclusions>
            <exclusion>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-logging</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-log4j2</artifactId>
    </dependency>
```

## 去除logback日志框架依赖

### spring boot去除logback依赖

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <exclusions>
            <exclusion>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-logging</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-log4j</artifactId>
    </dependency>

## log4j2 配置文件路径

### log4j2.xml

配置路径部署在 src/main/resources 目录下

### log4j2.yml

# 日志配置 无特殊需求无需更改

```yaml
logging:
  config: classpath:log4j2.xml
  level:
    root: INFO
    javax.activation: info
    org.apache.catalina: INFO
    org.apache.commons.beanutils.converters: INFO
    org.apache.coyote.http11.Http11Processor: INFO
    org.apache.http: INFO
    org.apache.tomcat: INFO
    org.springframework: INFO
    com.chinamobile.cmss.bdpaas.resource.monitor: DEBUG
```

### 自定义部署位置

修改yml配置中的logging.config选项

## log4j2.xml配置详解

xml配置模板

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration>
    <!--<Configuration status="WARN" monitorInterval="30"> -->
    <properties>
        <property name="LOG_HOME">./service-logs</property>
    </properties>
    <Appenders>
        <!--*********************控制台日志***********************-->
        <Console name="consoleAppender" target="SYSTEM_OUT">
            <!--设置日志格式及颜色-->
            <PatternLayout
                    pattern="%style{%d{ISO8601}}{bright,green} %highlight{%-5level} [%style{%t}{bright,blue}] 
                    %style{%C{}}{bright,yellow}: %msg%n%style{%throwable}{red}"
                    disableAnsi="false" noConsoleNoAnsi="false"/>
        </Console>

        <!--*********************文件日志***********************-->
        <!--all级别日志-->
        <RollingFile name="allFileAppender"
                     fileName="${LOG_HOME}/all.log"
                     filePattern="${LOG_HOME}/$${date:yyyy-MM}/all-%d{yyyy-MM-dd}-%i.log.gz">
            <!--设置日志格式-->
            <PatternLayout>
                <pattern>%d %p %C{} [%t] %m%n</pattern>
            </PatternLayout>
            <Policies>
                <!-- 设置日志文件切分参数 -->
                <!--<OnStartupTriggeringPolicy/>-->
                <!--设置日志基础文件大小，超过该大小就触发日志文件滚动更新-->
                <SizeBasedTriggeringPolicy size="100 MB"/>
                <!--设置日志文件滚动更新的时间，依赖于文件命名filePattern的设置-->
                <TimeBasedTriggeringPolicy/>
            </Policies>
            <!--设置日志的文件个数上限，不设置默认为7个，超过大小后会被覆盖；依赖于filePattern中的%i-->
            <DefaultRolloverStrategy max="100"/>
        </RollingFile>

        <!--debug级别日志-->
        <RollingFile name="debugFileAppender"
                     fileName="${LOG_HOME}/debug.log"
                     filePattern="${LOG_HOME}/$${date:yyyy-MM}/debug-%d{yyyy-MM-dd}-%i.log.gz">
            <Filters>
                <!--过滤掉info及更高级别日志-->
                <ThresholdFilter level="info" onMatch="DENY" onMismatch="NEUTRAL"/>
            </Filters>
            <!--设置日志格式-->
            <PatternLayout>
                <pattern>%d %p %C{} [%t] %m%n</pattern>
            </PatternLayout>
            <Policies>
                <!-- 设置日志文件切分参数 -->
                <!--<OnStartupTriggeringPolicy/>-->
                <!--设置日志基础文件大小，超过该大小就触发日志文件滚动更新-->
                <SizeBasedTriggeringPolicy size="100 MB"/>
                <!--设置日志文件滚动更新的时间，依赖于文件命名filePattern的设置-->
                <TimeBasedTriggeringPolicy/>
            </Policies>
            <!--设置日志的文件个数上限，不设置默认为7个，超过大小后会被覆盖；依赖于filePattern中的%i-->
            <DefaultRolloverStrategy max="100"/>
        </RollingFile>

        <!--info级别日志-->
        <RollingFile name="infoFileAppender"
                     fileName="${LOG_HOME}/info.log"
                     filePattern="${LOG_HOME}/$${date:yyyy-MM}/info-%d{yyyy-MM-dd}-%i.log.gz">
            <Filters>
                <!--过滤掉warn及更高级别日志-->
                <ThresholdFilter level="warn" onMatch="DENY" onMismatch="NEUTRAL"/>
            </Filters>
            <!--设置日志格式-->
            <PatternLayout>
                <pattern>%d %p %C{} [%t] %m%n</pattern>
            </PatternLayout>
            <Policies>
            <!-- 设置日志文件切分参数 -->
            <!--<OnStartupTriggeringPolicy/>-->
            <!--设置日志基础文件大小，超过该大小就触发日志文件滚动更新-->
            <SizeBasedTriggeringPolicy size="100 MB"/>
            <!--设置日志文件滚动更新的时间，依赖于文件命名filePattern的设置-->
            <TimeBasedTriggeringPolicy interval="1" modulate="true />
            </Policies>
            <!--设置日志的文件个数上限，不设置默认为7个，超过大小后会被覆盖；依赖于filePattern中的%i-->
            <!--<DefaultRolloverStrategy max="100"/>-->
        
        
        
        
        </RollingFile>

        <!--warn级别日志-->
        <RollingFile name="warnFileAppender"
                     fileName="${LOG_HOME}/warn.log"
                     filePattern="${LOG_HOME}/$${date:yyyy-MM}/warn-%d{yyyy-MM-dd}-%i.log.gz">
            <Filters>
                <!--过滤掉error及更高级别日志-->
                <ThresholdFilter level="error" onMatch="DENY" onMismatch="NEUTRAL"/>
            </Filters>
            <!--设置日志格式-->
            <PatternLayout>
                <pattern>%d %p %C{} [%t] %m%n</pattern>
            </PatternLayout>
            <Policies>
                <!-- 设置日志文件切分参数 -->
                <!--<OnStartupTriggeringPolicy/>-->
                <!--设置日志基础文件大小，超过该大小就触发日志文件滚动更新-->
                <SizeBasedTriggeringPolicy size="100 MB"/>
                <!--设置日志文件滚动更新的时间，依赖于文件命名filePattern的设置-->
                <TimeBasedTriggeringPolicy/>
            </Policies>
            <!--设置日志的文件个数上限，不设置默认为7个，超过大小后会被覆盖；依赖于filePattern中的%i-->
            <DefaultRolloverStrategy max="100"/>
        </RollingFile>

        <!--error及更高级别日志-->
        <RollingFile name="errorFileAppender"
                     fileName="${LOG_HOME}/error.log"
                     filePattern="${LOG_HOME}/$${date:yyyy-MM}/error-%d{yyyy-MM-dd}-%i.log.gz">
            <!--设置日志格式-->
            <PatternLayout>
                <pattern>%d %p %C{} [%t] %m%n</pattern>
            </PatternLayout>
            <Policies>
                <!-- 设置日志文件切分参数 -->
                <!--<OnStartupTriggeringPolicy/>-->
                <!--设置日志基础文件大小，超过该大小就触发日志文件滚动更新-->
                <SizeBasedTriggeringPolicy size="100 MB"/>
                <!--设置日志文件滚动更新的时间，依赖于文件命名filePattern的设置-->
                <TimeBasedTriggeringPolicy/>
            </Policies>
            <!--设置日志的文件个数上限，不设置默认为7个，超过大小后会被覆盖；依赖于filePattern中的%i-->
            <DefaultRolloverStrategy max="100"/>
        </RollingFile>

        <!--json格式error级别日志-->
        <RollingFile name="errorJsonAppender"
                     fileName="${LOG_HOME}/error-json.log"
                     filePattern="${LOG_HOME}/error-json-%d{yyyy-MM-dd}-%i.log.gz">
            <JSONLayout compact="true" eventEol="true" locationInfo="true"/>
            <Policies>
                <SizeBasedTriggeringPolicy size="100 MB"/>
                <TimeBasedTriggeringPolicy interval="1" modulate="true"/>
            </Policies>
        </RollingFile>
    </Appenders>

    <Loggers>
        <!-- 根日志设置 -->
        <Root level="debug">
            <AppenderRef ref="allFileAppender" level="all"/>
            <AppenderRef ref="consoleAppender" level="debug"/>
            <AppenderRef ref="debugFileAppender" level="debug"/>
            <AppenderRef ref="infoFileAppender" level="info"/>
            <AppenderRef ref="warnFileAppender" level="warn"/>
            <AppenderRef ref="errorFileAppender" level="error"/>
            <AppenderRef ref="errorJsonAppender" level="error"/>
        </Root>

        <!--spring日志-->
        <Logger name="org.springframework" level="debug"/>
        <!--druid数据源日志-->
        <Logger name="druid.sql.Statement" level="warn"/>
        <!-- mybatis日志 -->
        <Logger name="com.mybatis" level="warn"/>
        <Logger name="org.hibernate" level="warn"/>
        <Logger name="com.zaxxer.hikari" level="info"/>
        <Logger name="org.quartz" level="info"/>
        <Logger name="com.andya.demo" level="debug"/>
    </Loggers>

</Configuration>
```

1. 根节点configuration，常用两个属性
    1. status：指定log4j的日志级别
    2. monitorterval：指定log4j自动重新检测读取配置内容的间隔时间，单位为秒最小值5s
2. properties
   ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <Configuration status="warn" name="MyApp" packages="">
      <properties>
         <property name="LOG_HOME">./service-logs</property>
      </properties>
      <Appenders>
        <File name="MyFile" fileName="${LOG_HOME}/app.log">
          <PatternLayout>
            <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
          </PatternLayout>
        </File>
      </Appenders>
      <Loggers>
        <Root level="error">
          <AppenderRef ref="MyFile"/>
        </Root>
      </Loggers>
    </Configuration>
    ``` 
    1. <property name="LOG_HOME">./service-logs</property>配置日志的路径，日志可以存放在前缀路径为./service-logs下
    2. <File name="myfile" fileName="${log_home}/app.log配置了前缀，app.log会存放于./service-logs目录下
3. Appenders
    1. Console
       ```xml
         <?xml version="1.0" encoding="UTF-8"?>
         <Configuration status="warn" name="MyApp" packages="">
           <Appenders>
             <Console name="STDOUT" target="SYSTEM_OUT">
               <PatternLayout pattern="%m%n"/>
             </Console>
           </Appenders>
           <Loggers>
             <Root level="error">
               <AppenderRef ref="STDOUT"/>
             </Root>
           </Loggers>
         </Configuration>
       ```
        1. Console节点用于定义输出控制台的Appender
        2. 属性
            1. name 用于指定Appender的名称
            2. target 用于指定输出目标，一般是SYSTEM_OUT/ SYSTEM_ERR 默认是SYSTEM_OUT
        3. 节点
            1. patternLayout 输出格式，不设置话默认为 :%m%n
4. File
   ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <Configuration status="warn" name="MyApp" packages="">
      <Appenders>
        <File name="MyFile" fileName="logs/app.log">
          <PatternLayout>
            <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
          </PatternLayout>
        </File>
      </Appenders>
      <Loggers>
        <Root level="error">
          <AppenderRef ref="MyFile"/>
        </Root>
      </Loggers>
    </Configuration>
    ```
    1. File节点用于将日志输出到指定文件，一般不用该节点，使用RollingFile节点
    2. 属性
        1. name： 用于指定Appender名称
        2. fileName：用于指定文件全路径
    3. 节点
        1. PattenLayout 指定输出格式，不设置默认 :%m%n
5. RollingFile
   ##### 用于实现日志文件更懂更新appender，当满足条件（日志大小，指定时间等）重命名或打包元日志进行归档，生成新日志文件用于存储日志写入
   ##### 可以设置 all、debug、info、warn、error级别的rollingFileAppender
    1. 基于大小的滚动策略
       ```xml
         <?xml version="1.0" encoding="UTF-8"?>
         <Configuration status="warn" name="MyApp" packages="">
           <Appenders>
             <RollingFile name="RollingFile" fileName="logs/app.log"
                          filePattern="logs/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.log.gz">
               <PatternLayout>
                 <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
               </PatternLayout>
               <Policies>
                 <TimeBasedTriggeringPolicy />
                 <SizeBasedTriggeringPolicy size="100 MB"/>
               </Policies>
               <DefaultRolloverStrategy max="10"/>
             </RollingFile>
           </Appenders>
           <Loggers>
             <Root level="error">
               <AppenderRef ref="RollingFile"/>
             </Root>
           </Loggers>
         </Configuration>
       ```
        1. 日志先写到logs/app.log中，每当文件大小达到100MB的时或经过1天，按照在logs/2020-09/目录下以app-2020-09-09-1格式对日志进行 压缩重命名归档，并生成新文件app.log进行写入
        2. filePatten 属性文件格式中%i类似于一个整数计数器，收到<DefaultRolloverStratergy max="10"/>
           控制，当文件达到10个是，循环覆盖前面已经归档的1-10个文件，若不设置，默认7个
    2. 基于时间间隔的滚动策略
       ```xml
         <?xml version="1.0" encoding="UTF-8"?>
         <Configuration status="warn" name="MyApp" packages="">
           <Appenders>
             <RollingFile name="RollingFile" fileName="logs/app.log"
                          filePattern="logs/$${date:yyyy-MM}/app-%d{yyyy-MM-dd-HH}.log.gz">
               <PatternLayout>
                 <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
               </PatternLayout>
               <Policies>
                 <TimeBasedTriggeringPolicy interval="6" modulate="true"/>
               </Policies>
             </RollingFile>
           </Appenders>
           <Loggers>
             <Root level="error">
               <AppenderRef ref="RollingFile"/>
             </Root>
           </Loggers>
         </Configuration>
 
       ```
        1. 每当文件时间间隔达到6个小时（由%d{yyyy-MM-dd-HH}决定，也可以设置成%d{yyyy-MM-dd-HH-mm}则间隔为分钟级别）出发rollover操作
        2. 如配置，10点的日志开始重启服务，则从11点触发一次rollover操作，生成2020-09-02.log.gz对日志进行压缩重命名并归档，并生成新的app.log 文件进行日志记录，然后间隔六个小时，触发一次
    3. 基于时间间隔和文件大小的滚动策略
       ```xml
         <?xml version="1.0" encoding="UTF-8"?>
         <Configuration status="warn" name="MyApp" packages="">
           <Appenders>
             <RollingFile name="RollingFile" fileName="logs/app.log"
                          filePattern="logs/$${date:yyyy-MM}/app-%d{yyyy-MM-dd-HH}-%i.log.gz">
               <PatternLayout>
                 <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
               </PatternLayout>
               <Policies>
                 <TimeBasedTriggeringPolicy interval="6" modulate="true"/>
                 <SizeBasedTriggeringPolicy size="100 MB"/>
               </Policies>
             </RollingFile>
           </Appenders>
           <Loggers>
             <Root level="error">
               <AppenderRef ref="RollingFile"/>
             </Root>
           </Loggers>
         </Configuration>
 
       ```
       日志先写入app.log中，每当文件大小达到100mb或是当时间间隔达到六个小时，触发rollover操作，按照在logs/2020-09/目录下以app-2020-09-09-1.log.gz
       对日志进行压缩重命名和归档，并生成新的app.log日志并写入
    4. 属性
        1. name 用于指定appender名称
        2. filename 指定日志文件的全路径
        3. filepattern 指定分割文件的日志全路径
    5. 节点
        1. patternLayout 指定输出格式，不设置默认： :%m%n
        2. policies 日志文件切割参数
        3. SizeBaseTriggeringPolicy policies子节点，用于设置基于日志文件大小触发的滚动策略，size 指定每个分割日志文件大小
        4. TimeBasedTriggeringPolicy policies子节点，用于设置基于时间间隔触发的滚动策略，interval属性用于指定滚动时间间隔，默认1小时，modulate
           用于对interval进行偏移量调节，默认false，为true时，第一次触发时是第一个小时触发，后续以interval时间间隔触发
        5. crontriggeringPolicy policies子节点，用于设置基于Cron表达式触发的滚动策略
        6. DefaultRolloverStrategy：设置默认策略设置
6. 采用邮件发送
7. 记录到数据库
8. Loggers节点 常见的有两种:Root和Logger
    * Root节点用来指定项目的根日志，如果没有单独指定Logger，那么就会默认使用该Root日志输出
   ```
   level:日志输出级别，共有8个级别，按照从低到高为：All < Trace < Debug < Info < Warn < Error < - AppenderRef：Root的子节点，用
       来指定该日志输出到哪个Appender.
   Logger节点用来单独指定日志的形式，比如要为指定包下的class指定不同的日志级别等。
   level:日志输出级别，共有8个级别，按照从低到高为：All < Trace < Debug < Info < Warn < Error < Fatal < OFF.
   name:用来指定该Logger所适用的类或者类所在的包全路径,继承自Root节点.
   AppenderRef：Logger的子节点，用来指定该日志输出到哪个Appender,如果没有指定，就会默认继承自Root.如果指定了，那么会在指定的这个
       Appender和Root的Appender中都会输出，此时我们可以设置Logger的additivity="false"只在自定义的Appender中进行输出
   ```
         
         
















