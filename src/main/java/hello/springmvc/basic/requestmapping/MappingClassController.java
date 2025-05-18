package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String Users() {
        return "get Users";
    }

    @PostMapping
    public String addUser() {
        return "post User";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get UserId = " + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "patch UserId = " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userId = " + userId;
    }
}
