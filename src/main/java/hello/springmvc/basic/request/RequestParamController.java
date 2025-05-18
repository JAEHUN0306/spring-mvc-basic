package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller
@Slf4j
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}, age = {}", username, age);

        response.getWriter().write("OK");
    }

    @RequestMapping("/request-param-v2")
    @ResponseBody
    public String requestParamV2(
            @RequestParam("username") String username,
            @RequestParam("age") int age) {

        log.info("username = {}, age = {}", username, age);
        return "OK";
    }

    @RequestMapping("/request-param-v3")
    @ResponseBody
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {

        log.info("username = {}, age = {}", username, age);
        return "OK";
    }

    @RequestMapping("/request-param-v4")
    @ResponseBody
    public String requestParamV4(
            String username,
            int age) {

        log.info("username = {}, age = {}", username, age);
        return "OK";
    }


    @RequestMapping("/request-param-required")
    @ResponseBody
    public String requestParamRequired(
            @RequestParam String username,
            @RequestParam(required = false) Integer age) {

        log.info("username = {}, age = {}", username, age);
        return "OK";
    }

    @RequestMapping("/request-param-default")
    @ResponseBody
    public String requestParamDefault(
            @RequestParam(defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age) {

        log.info("username = {}, age = {}", username, age);
        return "OK";
    }

    @RequestMapping("/request-param-map")
    @ResponseBody
    public String requestParamDefault(@RequestParam Map<String, Object> paramMap) {
        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-basic")
    public String modelAttributeV1(@RequestParam String username, @RequestParam int age) {
        HelloData helloData = new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);

        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
        log.info("helloData = {}", helloData);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV2(@ModelAttribute HelloData helloData) {
        /*
        - HelloData 객체를 생성한다.
        - 요청 파라미터의 이름으로 HelloData 객체의 프로퍼티를 찾는다. 그리고 해당 프로퍼티의 setter를 호출해서
          파라미터 값을 입력한다.
         */
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
        log.info("helloData = {}", helloData);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV3(HelloData helloData) { //@ModelAttribute 생략 가능
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
        log.info("helloData = {}", helloData);

        return "ok";
    }
}
