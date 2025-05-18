package hello.springmvc.basic.request;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@Slf4j
public class RequestHeaderController {

    @GetMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value = "MyCookie", required = false) String cookie) {

       /* 쿠키 만들기
            if(cookie == null) {
            Cookie myCookie = new Cookie("MyCookie", "hello-Cookie");

            myCookie.setPath("/");
            myCookie.setMaxAge(60 * 60);
            response.addCookie(myCookie);
            log.info("쿠키 생성 완료");

            log.info("myCookie={}", cookie);
        }*/

        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);

        return "ok";
    }
}
