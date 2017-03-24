package blockchava;

import java.util.ArrayList;

import org.json.*;


public class Chain {
	
	
	ArrayList<Block> chain;
	
	
	public Chain() {
		
		// TODO: initiate a list of peers
		chain = new ArrayList();
		
		// declare the genesis block and add it to the list
		Block gb = new Block(0, "0", "genesis");		
		chain.add(gb);	
		
	}
	
	
	public Block getLastBlock(ArrayList<Block> chain) {
		
		int lastElementIndex = chain.size() - 1;
		Block lastBlock = chain.get(lastElementIndex);
		
		return lastBlock;
		
	}
	
	
	public boolean isValidNewBlock(Block previousBlock, Block newBlock) {
		
		// checks if a block is valid 
		
		if (newBlock.index != (previousBlock.index + 1)) {
			System.out.println("Block has incorrect index");
			return false;
		} else if (!newBlock.previousHash.equals(previousBlock.hash)) {
			System.out.println("Block doesn't match previous hash");
			return false;
		} else if (Block.calculateHash(newBlock).equals(newBlock.hash)) {
			System.out.println("Block has invalid hash");
			return false;
		}
		
		return true;
	}
	
	
	public Block generateNextBlock(String data) {
		
		Block lastBlock = getLastBlock(chain);
		
		int nextBlockIndex = lastBlock.index + 1;
		String lastHash = lastBlock.hash;
		Block nextBlock = new Block(nextBlockIndex, lastHash, data);
		
		return nextBlock;
		
	}
	
	
	public void addBlock(Block newBlock) {
		
		Block lastBlock = getLastBlock(chain);
		
		if (isValidNewBlock(lastBlock, newBlock)) {
			chain.add(newBlock);
		} else {
			System.out.println("The block was not valid and could no be added to the chain");
		}
		
	}
	
	
	// TODO: handle chain whole chain from another peer
	public void handleNewChain(ArrayList<Block> newChain) {
		
		Block newChainLastBlock = getLastBlock(newChain);
		Block chainLastBlock = getLastBlock(chain);
		
		if (newChainLastBlock.index > chainLastBlock.index) {
			
			if (chainLastBlock.hash == newChainLastBlock.previousHash) {
				// simplest case: add a single block on
				System.out.println("Adding a new block");
				addBlock(newChainLastBlock);
				// TODO: have it broadcast to other nodes
			} 
//			else if () { 
//				// we have to get the rest of the chain
//				
//			} else {
//				// check that the chain is valid 
//			}
			
		} else {
			
			System.out.println("Recieved block is not longer so do nothing");
			
		}
		
	}
	
	
	// TODO: function that converts json to array of blocks (chain)
	
	
	public String chainToJson() {
		
		String[] jsonChainArray = new String[chain.size()];

		for (int i = 0; i < chain.size(); i++) {
			jsonChainArray[i] = chain.get(i).blockToJson();
		}	
			
		JSONObject chainJson = new JSONObject();
		try {
			chainJson.put("chain", jsonChainArray);
		} catch (JSONException e) {
			System.out.print("Could not create json chain");
			e.printStackTrace();
		}
		
		return chainJson.toString();
		
	}
	
		
}
