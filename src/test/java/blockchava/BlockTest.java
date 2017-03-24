package blockchava;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

import org.json.*;


public class BlockTest {
	
	int index = 0;
	String previousHash = "dummyhash";
	String data = "Hello, Block ;)";
	
	// kind of stupid to unit test?
    @Test 
    public void testBasicBlock() {
    	
    	// kind of a stupid test but whatever
    	
    	
        Block block = new Block(index, previousHash, data);
        
        String date = block.timeStamp;
        
        String hash = DigestUtils.sha1Hex(index + previousHash + date + data);
        assertEquals(hash, block.hash);
        
    }
    
    @Test 
    public void testJsonBlock() {
    	
        JSONObject blockJson = new JSONObject();
        
        String dataJson = "json thing";
        int indexJson = 999;
        String prevJson = "blah blah";
        
        try {
        	
			blockJson.put("index", indexJson);
			blockJson.put("data", dataJson);
	        blockJson.put("previous_hash", prevJson);
	        blockJson.put("time_stamp", "some date");
	        blockJson.put("hash","hashing that shit");
	        
		} catch (JSONException e) {
			
			System.out.println("Could not create json for test");
			
		}
       
        Block block = new Block(blockJson.toString());
        
        assertEquals(indexJson, block.index);
        assertEquals(dataJson, block.data);
        assertEquals(prevJson, block.previousHash);
        
    }
    
   @Test
   public void testBlockToJson() {
	   Block block = new Block(index, previousHash, data);
	   String blockJsonString = block.blockToJson();
	   
	   JSONObject blockJson;
	   try {
		   blockJson = new JSONObject(blockJsonString);
		   assertEquals(blockJson.getInt("index"), index);
		   assertEquals(blockJson.getString("previous_hash"), previousHash);
		   assertEquals(blockJson.getString("data"), data);
		} catch (JSONException e1) {
			System.out.println("Could not make jsonobject from string");
		}
	   
   }
    
}
