package blockchava;

import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class NodeController {
	
	Chain chain = new Chain();

	@RequestMapping(value="/blocks", method = RequestMethod.GET)
    public String getBlocks() {    		
        return chain.chainToJson();
    }
	
    @RequestMapping(value="/blocks", method = RequestMethod.POST)
    public void addBlocks(@RequestBody JSONObject blockJson) {  
    	
    	System.out.print("BLOCK JSON");
    	System.out.println(blockJson);
    	Block newBlock = new Block(blockJson);
    	chain.addBlock(newBlock);
    	
    }

}
