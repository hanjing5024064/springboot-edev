package com.itheima.config;

import com.itheima.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * @Classname SecurityConfig
 * @Description MVC Security管理配置的自定义WebSecurityConfigurerAdapter类
 * @Date 2019-3-5 14:52
 * @Created by CrazyStone
 */
@EnableWebSecurity  // 开启MVC security安全支持
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * 用户授权管理自定义配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 自定义用户授权管理
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                // 需要对static文件夹下静态资源进行统一放行
                .antMatchers("/login/**").permitAll()
                .antMatchers("/detail/common/**").hasRole("common")
                .antMatchers("/detail/vip/**").hasRole("vip")
                .anyRequest().authenticated();

        // 自定义用户登录控制
        http.formLogin()
                .loginPage("/userLogin").permitAll()
                .usernameParameter("name").passwordParameter("pwd")
                .defaultSuccessUrl("/")
                .failureUrl("/userLogin?error");

        // 自定义用户退出控制
        http.logout()
                .logoutUrl("/mylogout")
                .logoutSuccessUrl("/");
    }

    /**
         * 用户身份认证自定义配置
         * @param auth
         * @throws Exception
         */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //  密码需要设置编码器
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        // 1、使用内存用户信息，作为测试使用
//        auth.inMemoryAuthentication().passwordEncoder(encoder)
//                .withUser("shitou").password(encoder.encode("123456")).roles("common")
//                .and()
//                .withUser("李四").password(encoder.encode("123456")).roles("vip");

        // 2、使用JDBC进行身份认证
//        String userSQL ="select username,password,valid from t_customer " +
//                "where username = ?";
//        String authoritySQL="select c.username,a.authority from t_customer c,t_authority a,"+
//                "t_customer_authority ca where ca.customer_id=c.id " +
//                "and ca.authority_id=a.id and c.username =?";
//        auth.jdbcAuthentication().passwordEncoder(encoder)
//                .dataSource(dataSource)
//                .usersByUsernameQuery(userSQL)
//                .authoritiesByUsernameQuery(authoritySQL);

//         3、使用UserDetailsService进行身份认证
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

}

