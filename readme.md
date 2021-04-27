<h1 align="center">
  <br>
  Spring Boot 企业级开发
  <br>
</h1>

<p>run</p>
<p>mvn spring-boot:run</p>
<hr>
<p>1</p>
<artifactId>spring-boot-starter-web</artifactId><br>
@RestController
<hr>
<p>2</p>
<artifactId>spring-boot-starter-test</artifactId><br>
<artifactId>spring-boot-devtools</artifactId><br>
@RunWith(SpringRunner.class)<br>
@SpringBootTest<br>
@Test
<hr>
<p>3</p>
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

<p>4</p>
