package hw3;

import static api.Orientation.*;

import static api.CellType.*;

import java.util.ArrayList;

import api.Cell;
import api.CellType;

/**
 * Utilities for parsing string descriptions of a grid.
 */
public class GridUtil {
	/**
	 * Constructs a 2D grid of Cell objects given a 2D array of cell descriptions.
	 * String descriptions are a single character and have the following meaning.
	 * <ul>
	 * <li>"*" represents a wall.</li>
	 * <li>"e" represents an exit.</li>
	 * <li>"." represents a floor.</li>
	 * <li>"[", "]", "^", "v", or "#" represent a part of a block. A block is not a
	 * type of cell, it is something placed on a cell floor. For these descriptions
	 * a cell is created with CellType of FLOOR. This method does not create any
	 * blocks or set blocks on cells.</li>
	 * </ul>
	 * The method only creates cells and not blocks. See the other utility method
	 * findBlocks which is used to create the blocks.
	 * 
	 * @param desc a 2D array of strings describing the grid
	 * @return a 2D array of cells the represent the grid without any blocks present
	 */
	public static Cell[][] createGrid(String[][] desc) {

		Cell[][] cell = new Cell[desc[0].length][desc.length];

		for (int i = 0; i < desc.length; i++) {

			for (int j = 0; j < desc[i].length; j++) {

				if (desc[i][j].equals("*")) {
					cell[i][j] = new Cell(WALL, i, j);

				} else if (desc[i][j].equals("e")) {

					cell[i][j] = new Cell(EXIT, i, j);
				} else if (desc[i][j].equals(".")) {

					cell[i][j] = new Cell(FLOOR, i, j);
				}
			}
		}

		return cell;
	}

	/**
	 * Returns a list of blocks that are constructed from a given 2D array of cell
	 * descriptions. String descriptions are a single character and have the
	 * following meanings.
	 * <ul>
	 * <li>"[" the start (left most column) of a horizontal block</li>
	 * <li>"]" the end (right most column) of a horizontal block</li>
	 * <li>"^" the start (top most row) of a vertical block</li>
	 * <li>"v" the end (bottom most column) of a vertical block</li>
	 * <li>"#" inner segments of a block, these are always placed between the start
	 * and end of the block</li>
	 * <li>"*", ".", and "e" symbols that describe cell types, meaning there is not
	 * block currently over the cell</li>
	 * </ul>
	 * 
	 * @param desc a 2D array of strings describing the grid
	 * @return a list of blocks found in the given grid description
	 */
	public static ArrayList<Block> findBlocks(String[][] desc) {

		ArrayList<Block> blockList = new ArrayList<Block>();

		for (int i = 0; i < desc.length; i++) {
			for (int j = 0; j < desc[i].length; j++) {

				int counter = 2;
				int counter2 = 2;

				if (desc[i][j].equals("[")) {

					outer: for (int k = i; k < desc.length; k++) {

						if (!desc[j][k].equals("]")) {

							if (desc[i][k].equals("#")) {

								counter++;

							}

						} else {
							break outer;
						}

					}
					Block hBlock = new Block(i, j, counter, HORIZONTAL);
					blockList.add(hBlock);

				}

				counter = 2;

				outer2: if (desc[i][j].equals("^")) {

					for (int l = j; l < desc[i].length; l++) {

						if (!desc[l][i].equals("v")) {

							if (desc[l][j].equals("#")) {
								counter2++;
							}

						}

						else {
							break outer2;
						}

					}

					Block vBlock = new Block(i, j, counter2, VERTICAL);
					blockList.add(vBlock);

				}

			}
		}

		return blockList;
	}
}
