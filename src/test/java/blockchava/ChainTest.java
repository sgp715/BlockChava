package blockchava;

import org.junit.Test;
import static org.junit.Assert.*;


public class ChainTest {
	
	
	@Test 
	public void testChainConstructor(){
		Chain chain = new Chain();
		System.out.println(chain.chainToJson());
	}
	

}
