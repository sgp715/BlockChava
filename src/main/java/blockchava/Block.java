package blockchava;

import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.*;


public class Block {
	
	
	static public String calculateHash(Block someBlock) { 
		
		String someHash = DigestUtils.sha1Hex(someBlock.index + 
				someBlock.previousHash + 
				someBlock.timeStamp + 
				someBlock.data);
		
		return someHash;
	}
	
	
	int index;
	String previousHash;
	Date timeStamp;
	String data;
	String hash;
	
	
	public Block(int i, String ph, String d) {
		
		index = i;
		previousHash = ph;
		timeStamp = new Date();
		data = d;
		
		// need things to be strings before we can hash
		hash = DigestUtils.sha1Hex(
				index + 
				previousHash + 
				timeStamp + 
				data);
		
	}
	
	// TODO: overload constructor to create block from json
//	public Block(JSON json) {
//		
//	}
	
	
	// TODO: function that converts the object to json
	public String blockToJson() {
		
		JSONObject jsonBlock = new JSONObject();
		
		try {
			jsonBlock.put("index", index);
			jsonBlock.put("previous_hash", previousHash);
			jsonBlock.put("time_stamp", timeStamp);
			jsonBlock.put("data", data);
			jsonBlock.put("hash", hash);
		} catch (JSONException e) {
			System.out.print("There was an excpetion creating json from block");
//			e.printStackTrace();
		}		
		
		return jsonBlock.toString();
		
	}

	
}
