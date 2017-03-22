import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

public class Block {
	
	int index;
	String previousHash;
	Date timeStamp;
	String data;
	String hash;
	
	public Block(int index, String previousHash, String data) {
		
		this.index = index;
		this.previousHash = previousHash;
		this.timeStamp = new Date();
		this.data = data;
		
		// need things to be strings before we can hash
		this.hash = DigestUtils.sha1Hex(this.index + 
										this.previousHash + 
										this.timeStamp + 
										this.data);
		
		System.out.println("this is the hash " + this.hash);
		
	}

}
