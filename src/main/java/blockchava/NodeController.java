package blockchava;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class NodeController {

    @RequestMapping("/")
    public String index() {
        return "Hello, Spring!";
    }

}
