package learn.spring.manualdependency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ManualDependencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManualDependencyApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring!";
    }

}
