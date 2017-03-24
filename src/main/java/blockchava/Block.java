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
	String timeStamp;
	String data;
	String hash;
	
	
	public Block(int i, String ph, String d) {
		
		index = i;
		previousHash = ph;
		timeStamp = new Date().toString();
		data = d;
		
		// need things to be strings before we can hash
		hash = DigestUtils.sha1Hex(
				index + 
				previousHash + 
				timeStamp + 
				data);
		
	}
	
	// TODO: make these constructors use same code
	public Block(JSONObject jsonBlock) {
		
		try {
			index = jsonBlock.getInt("index");
			previousHash = jsonBlock.getString("previous_hash");
			timeStamp = jsonBlock.getString("time_stamp");
			data = jsonBlock.getString("data");
			hash = jsonBlock.getString("hash");
		} catch (JSONException e1) {
			System.out.println("Could not get values from json");
		}
		
	}
	
	
	public Block(String jsonStringBlock) {
		
		JSONObject jsonBlock;
		try {
			jsonBlock = new JSONObject(jsonStringBlock);
			index = jsonBlock.getInt("index");
			previousHash = jsonBlock.getString("previous_hash");
			timeStamp = jsonBlock.getString("time_stamp");
			data = jsonBlock.getString("data");
			hash = jsonBlock.getString("hash");
			
		} catch (JSONException e1) {
			System.out.println("Could not get json object from string");
		}		
				
	}
	
	
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
