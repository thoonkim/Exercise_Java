1.의의

        - 스프링은 기본적으로 인증과 인가 등 보안 라이브러리를 제공한다.
        - 보안과 관련하여 의존이  추가되면  Spring Security 초기화 작업과 보안 작업이 일어난다.
        - 이러한 보안 작업은 기본적으로 자동으로 이루어진다.
        - 첫시간이기 때문에 먼저 일반적인 스프링 프로젝트와 보안 기능이 적용된 스프링 프로젝트를 생성해서 비교해 보겠다.

        2.기본적인 스프링 프로젝트

        - 의존성에 Spring Web만 선택하여 프로젝트를 만든다.

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c72238a8-8607-421c-b8a3-b9c726d93500/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c72238a8-8607-421c-b8a3-b9c726d93500/Untitled.png)

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fbe086f8-1651-4d5d-b2fc-a5865d4b848a/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fbe086f8-1651-4d5d-b2fc-a5865d4b848a/Untitled.png)


        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6a7557fd-2c3d-47c7-8372-9884660829b6/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6a7557fd-2c3d-47c7-8372-9884660829b6/Untitled.png)

        - [SecurityController.java](http://securitycontroller.java) 파일을 만들고 localhost:8090으로 접속하면 정상적으로 메세지가 출력된다.

        ```java
        package io.security.basicsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/")
    public String index() {
        return "home";

    }
}
```

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/917354b9-8f26-41bf-a6b7-b458cc9c39bb/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/917354b9-8f26-41bf-a6b7-b458cc9c39bb/Untitled.png)

        3. spring security 기본 인증

        1)porm.xml에 의존성을 추가 한다.

        ```java
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-security</artifactId>
</dependency>
        ```

        - 의존성을 추가해서 톰캣을 재부팅 하면 콘솔 창에 Using generated security password: 8a35cd24-3252-4747-83a7-e6ec83787ee8이 보일 것이다.


        [32m :: Spring Boot :: [39m              [2m (v2.4.5)[0;39m

        [2m2021-05-08 16:21:44.320[0;39m [32m INFO[0;39m [35m13992[0;39m [2m---[0;39m [2m[           main][0;39m [36mi.s.b.Ch01BasicSurityApplication        [0;39m [2m:[0;39m Starting Ch01BasicSurityApplication using Java 15.0.2 on DESKTOP-IDK35GO with PID 13992 (C:\Development\workspace_SpringSecurity\Ch01_BasicSecurity\target\classes started by HelloWorld in C:\Development\workspace_SpringSecurity\Ch01_BasicSecurity)
        [2m2021-05-08 16:21:44.322[0;39m [32m INFO[0;39m [35m13992[0;39m [2m---[0;39m [2m[           main][0;39m [36mi.s.b.Ch01BasicSurityApplication        [0;39m [2m:[0;39m No active profile set, falling back to default profiles: default
[2m2021-05-08 16:21:45.115[0;39m [32m INFO[0;39m [35m13992[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.s.b.w.embedded.tomcat.TomcatWebServer [0;39m [2m:[0;39m Tomcat initialized with port(s): 8090 (http)
        [2m2021-05-08 16:21:45.126[0;39m [32m INFO[0;39m [35m13992[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.apache.catalina.core.StandardService  [0;39m [2m:[0;39m Starting service [Tomcat]
        [2m2021-05-08 16:21:45.126[0;39m [32m INFO[0;39m [35m13992[0;39m [2m---[0;39m [2m[           main][0;39m [36morg.apache.catalina.core.StandardEngine [0;39m [2m:[0;39m Starting Servlet engine: [Apache Tomcat/9.0.45]
        [2m2021-05-08 16:21:45.202[0;39m [32m INFO[0;39m [35m13992[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.a.c.c.C.[Tomcat].[localhost].[/]      [0;39m [2m:[0;39m Initializing Spring embedded WebApplicationContext
        [2m2021-05-08 16:21:45.203[0;39m [32m INFO[0;39m [35m13992[0;39m [2m---[0;39m [2m[           main][0;39m [36mw.s.c.ServletWebServerApplicationContext[0;39m [2m:[0;39m Root WebApplicationContext: initialization completed in 838 ms
        [2m2021-05-08 16:21:45.389[0;39m [32m INFO[0;39m [35m13992[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.s.s.concurrent.ThreadPoolTaskExecutor [0;39m [2m:[0;39m Initializing ExecutorService 'applicationTaskExecutor'
        [2m2021-05-08 16:21:45.588[0;39m [32m INFO[0;39m [35m13992[0;39m [2m---[0;39m [2m[           main][0;39m [36m.s.s.UserDetailsServiceAutoConfiguration[0;39m [2m:[0;39m

        Using generated security password: 8a35cd24-3252-4747-83a7-e6ec83787ee8

        [2m2021-05-08 16:21:45.703[0;39m [32m INFO[0;39m [35m13992[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.s.s.web.DefaultSecurityFilterChain    [0;39m [2m:[0;39m Will secure any request with [org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@66223d94, org.springframework.security.web.context.SecurityContextPersistenceFilter@35b17c06, org.springframework.security.web.header.HeaderWriterFilter@7f9e8421, org.springframework.security.web.csrf.CsrfFilter@f29353f, org.springframework.security.web.authentication.logout.LogoutFilter@640cc04b, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter@62cba181, org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter@630bf683, org.springframework.security.web.authentication.ui.DefaultLogoutPageGeneratingFilter@2bc7db89, org.springframework.security.web.authentication.www.BasicAuthenticationFilter@20999517, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@9f674ac, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@7e62cfa3, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@479ac2cb, org.springframework.security.web.session.SessionManagementFilter@168b4cb0, org.springframework.security.web.access.ExceptionTranslationFilter@4a8ffd75, org.springframework.security.web.access.intercept.FilterSecurityInterceptor@54a2d96e]
        [2m2021-05-08 16:21:45.788[0;39m [32m INFO[0;39m [35m13992[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.s.b.w.embedded.tomcat.TomcatWebServer [0;39m [2m:[0;39m Tomcat started on port(s): 8090 (http) with context path ''
        [2m2021-05-08 16:21:45.798[0;39m [32m INFO[0;39m [35m13992[0;39m [2m---[0;39m [2m[           main][0;39m [36mi.s.b.Ch01BasicSurityApplication        [0;39m [2m:[0;39m Started Ch01BasicSurityApplication in 1.869 seconds (JVM running for 2.729)


        - 다시  localhost:8090으로 접속 한다.
        - login 페이지로 자동으로 넘어가는 것을 확인 할 수 있을 것이다.
        - 이것은 스프링 프레임워크에서 자동으로 제공해주는 페이지 이다.

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/20da6087-4029-4123-b31c-8ad431e1e585/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/20da6087-4029-4123-b31c-8ad431e1e585/Untitled.png)

        - 기본적으로 user 가 있고, 콘솔창에서 제공된 패스워드 8a35cd24-3252-4747-83a7-e6ec83787ee8

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e3fe5916-e796-4b5c-bedb-b5d5a4937470/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e3fe5916-e796-4b5c-bedb-b5d5a4937470/Untitled.png)

        2)스프링의 보안 의존성(spring-boot-starter-security) 추가 후 변경되  것들은 다음과 같다

        - 모든 요청은 인증 되어야 자원에 접근이 가능하다.
        - 인증 방식은 Form login방식과 httpbasic 로그인 방식을 제공한다.
        - 기본적으로 한 개의  계정(user)과 랜덤 비밀번호가 제공 된다.
        - 기본적인 것들만 제공되며 추후계정 추가, 권한 추가, DB 연동 등에 관해서는 따로 보안 설정을 해야 한다.