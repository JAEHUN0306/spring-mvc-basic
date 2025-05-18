package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController// 문자를 http 메시지 바디에 넣어서 반환
@Slf4j
public class MappingController {

    @RequestMapping(value = "/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mapping-get-v1");
        return "ok";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}") // 경로 변수
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    @GetMapping(value = "/mapping/{username}/{userId}") // 다중 경로 변수
    public String mappingPath(@PathVariable String username, @PathVariable Integer userId) {
        log.info("mappingPath username={}, username.type = {}", username, username.getClass());
        log.info("mappingPath userId={}, userId.type={}", userId, userId.getClass());
        return "ok";
    }
}
