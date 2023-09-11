package hw3;

import java.util.ArrayList;

import api.Cell;
import api.Direction;
import api.Orientation;

public class Assignment3Test {

	public static void main(String[] args) {
		Block block = new Block(2,1,3,Orientation.VERTICAL);
		
		System.out.println("firstRow: " + block.getFirstRow());
		System.out.println("firstCol: " + block.getFirstCol());
		System.out.println("Length: " + block.getLength());
		System.out.println("Orientation: " + block.getOrientation());
		block.setFirstRow(5);
		System.out.println("New firstRow: " + block.getFirstRow());
		block.setFirstCol(6);
		System.out.println("New firstCol: " + block.getFirstCol());
		block.reset();
		System.out.println("reset firstRow: " + block.getFirstRow());
		System.out.println("reset firstCol: " + block.getFirstCol());
		block.move(Direction.DOWN);
		block.move(Direction.RIGHT);
		System.out.println("Don't move firstRow: " + block.getFirstRow());
		System.out.println("Move firstCol: " + block.getFirstCol());
		
		/*Block hblock = new Block(4,4,2,Orientation.HORIZONTAL);
		System.out.println("firstRow: " + hblock.getFirstRow());
		System.out.println("firstCol: " + hblock.getFirstCol());
		hblock.move(Direction.UP);
		hblock.move(Direction.LEFT);
		System.out.println("Move firstRow: " + hblock.getFirstRow());
		System.out.println("Don't move firstCol: " + hblock.getFirstCol());*/
		
		String[][] test = { { "*", "*", "*", "*", "*" },
				 { "*", ".", ".", ".", "*" },
				 { "*", "[", "]", ".", "e" },
				 { "*", ".", ".", ".", "*" },
				 { "*", "*", "*", "*", "*" } };
		
		String[][] test2 = { { "*", "*", "*", "*", "*" },
				 { "*", ".", ".", ".", "*" },
				 { "*", "[", "#", "]", "e" },
				 { "*", ".", ".", ".", "*" },
				 { "*", "*", "*", "*", "*" } };
		
		String[][] test3 = { { "*", "*", "*", "*", "*", "*" },
				 { "*", ".",  ".", ".", ".", "*" },
				 { "*", "[",  "#", "#", "]", "e" },
				 { "*", ".", ".", ".", ".", "*" }, 
				 { "*", ".", ".", ".", ".", "*" },
				 { "*", "*", "*", "*", "*", "*" } };
		
		String[][] test4 = { { "*", "*", "*", "*", "*", "*" },
				 { "*", ".",  "^", ".", ".", "*" },
				 { "*", ".",  "#", ".", ".", "e" },
				 { "*", ".", "#", ".", ".", "*" }, 
				 { "*", ".", "v", ".", ".", "*" },
				 { "*", "*", "*", "*", "*", "*" } };
		
		
		Cell[][] arr = GridUtil.createGrid(test3);
		
		ArrayList<Block> b = GridUtil.findBlocks(test3);
		
		System.out.println("Using testDescription1, number of blocks is "
				+ b.size() + ", expected is 1.");
				System.out.println("Using testDescription1, first block is length "
				+ b.get(0).getLength() + ", expected is 4.");
		
				
				
				
				
		//System.out.println("Using testDescription1, cell (2, 4) is an exit is "
		//+ arr[2][4].isExit() + ", expected is true.");
		
		
		
		

	}

}
