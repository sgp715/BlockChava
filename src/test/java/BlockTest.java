import org.junit.Test;
import static org.junit.Assert.*;

public class BlockTest {
	
    @Test 
    public void testBlockConstructor() {
    	
    	// initialize the block
    	int initial_index = 0;
    	String previousHash = "dummyhash";
    	String data = "Hello, Block ;)";
        Block block = new Block(initial_index, previousHash, data);
        
        // check that the fields were set...
        assertEquals(block.index, initial_index);
        assertEquals(block.previousHash, previousHash);
        assertEquals(block.data, data);
    }
    
}
