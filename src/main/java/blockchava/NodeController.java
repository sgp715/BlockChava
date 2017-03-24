package blockchava;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class NodeController {
	
	Chain chain = new Chain();

    @RequestMapping("/blocks")
    public String index() {
        return chain.chainToJson();
    }

}
