package Algorithms;
import java.util.*;

public class Arrays_Strings {

//	Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
//	An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
//	You may assume all four edges of the grid are all surrounded by water.
//  Solve this with a classical DFS
	char[][] visited;
	public int numIslands(char[][] grid) {
		visited = grid.clone();
		int count = 0;

		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				if (grid[i][j] == '1' && visited[i][j] != 'x') {
					count++;
					runOutIsland(i, j);
				}
			}
		}
		return count;
	}
	public void runOutIsland(int x, int y) {
		visited[x][y] = 'x';
		if (x > 0) {
			if (visited[x-1][y] == '1')
				runOutIsland(x-1, y);
		}
		if (y > 0) {
			if (visited[x][y-1] == '1')
				runOutIsland(x,y-1);
		}
		if (x < visited.length - 1) {
			if (visited[x+1][y] == '1')
				runOutIsland(x+1, y);
		}
		if (y < visited[x].length - 1) {
			if (visited[x][y+1] == '1')
				runOutIsland(x,y+1);
		}
	}
	
//	Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//	A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
	public List<String> solution = new ArrayList<String>();
    public String[][] letters = new String[][]{{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},
    												{"p","q","r","s"},{"t","u","v"},{"w","x","y", "z"}};
     public List<String> letterCombinations(String digits) { 
         if (digits.equals("")) {
             return solution;
         }
         letterCombinationsHelp(digits, "");
         return solution;
     }
    
    public void letterCombinationsHelp(String digits, String solutionS) {
        
        if (digits.length() == 0) {
            solution.add(solutionS);
            return;
        }
        Integer currentDigit = Integer.parseInt(digits.substring(0,1));
        for (int i = 0; i < letters[currentDigit].length; i++) {
            letterCombinationsHelp(digits.substring(1),solutionS+letters[currentDigit][i]);
        }    
    }
    
//    You are playing a simplified Pacman game. You start at the point (0, 0), and your destination is (target[0], target[1]). There are several ghosts on the map, the i-th ghost starts at (ghosts[i][0], ghosts[i][1]).
//    Each turn, you and all ghosts simultaneously *may* move in one of 4 cardinal directions: north, east, west, or south, going from the previous point to a new point 1 unit of distance away.
//    You escape if and only if you can reach the target before any ghost reaches you (for any given moves the ghosts may take.)  If you reach any square (including the target) at the same time as a ghost, it doesn't count as an escape.
//    Return True if and only if it is possible to escape.
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        return areCloser(ghosts,target);
    }

    public static boolean areCloser(int[][]ghost, int[] target) {
        int yourD =  Math.abs(target[0]) + Math.abs(target[1]);    
        for (int i = 0; i < ghost.length; i++) {
            int ghostD = Math.abs(target[0] - ghost[i][0]) + Math.abs(target[1] - ghost[i][1]);
            if (ghostD < yourD)
                return false;
        }
        return true;
    }
    
}
