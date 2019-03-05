#### 一些常用注释

1. **@PropertySource**：指定配置文件的路径，用来加载额外的配置文件，通过设置*ignoreResourceNotFound*属性来指定是否忽略文件为空的情况，例子:

```java
@SpringBootApplication
@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)
public class Chapter2Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter2Application.class, args);
    }

}
```

这里指定了外部数据库配置文件。

2. **@ConfigurationProperties**：用于配置文件中的字段的应用问题，属性填字段的首部单词，后面会自动根据全限定名来判断对应的属性，例子：

```java
@Component
@ConfigurationProperties("database")
public class DataBaseProperties {

    private String driverName = null;
    private String url = null;
    private String username = null;
    private String password = null;
    //get and set.....
```

这里对应的属性就为*database.driverName*等等。这个属性的对应也可以使用**@Value**来指定特殊的字段，运用${....}来应用特殊的属性字段，例如：

```java
public class DataBaseProperties {
     @Value("${database.driverName}")
     private String driverName = null;
 }
```

3. **@Scope**：用来指定*bean*是单例模式还是非单例模式，不指定的话默认为单例模式，例如：

```java
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ScopeBean {
}
```

4. **@Profile**：用来指定对应的开发环境中对应的配置。实际操作中我们还可以运用*properties*文件来进行生产环境的指定，在java运行环境中指定参数***-Dspring.profile.active={profile}***。

5. 
