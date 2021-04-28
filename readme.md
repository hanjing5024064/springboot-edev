<h1 align="center">
  <br>
  Spring Boot 企业级开发
  <br>
</h1>

<p>run</p>
<p>mvn spring-boot:run</p>
<hr>
<p>ch1</p>
<artifactId>spring-boot-starter-web</artifactId><br>
@RestController

<artifactId>spring-boot-starter-test</artifactId><br>
<artifactId>spring-boot-devtools</artifactId><br>
@RunWith(SpringRunner.class)<br>
@SpringBootTest<br>
@Test
<hr>
<p>ch2</p>
@Component<br>
@ConfigurationProperties(prefix = "person") // 将配置文件中以person开头的属性注入到该类中<br>
@Autowire<br>
application.properties<br>
application.yaml
<p>如果是SpringBoot默认提供的属性，如server.port，
框架会自动扫描并读取该属性。用户自定义属性需要通过
@ConfigurationProperties和@Value注入<br>
@Value("${person.id}")，在属性上加注解
</p>
<hr>

<p>ch3</p>
<p>修改依赖后，需要右键项目-maven-reload</p>
<p>修改类、配置文件，需要Build-rebuild project</p>

<p>删除Run/Edit Configurations and Maven-reload</p>

<p>ch5</p>
 <p>实现WebMvcConfigurer接口，扩展MVC功能，addViewControllers实现请求跳转，简洁。
 但无法获取后台数据，只适合五参数视图get方式的请求跳转。</p>
