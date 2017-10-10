package com.crackingthecodinginterview;

public class PaintFill {

	enum COLOR {
		RED, GREEN, BLACK, WHITE, YELLOW
	}

	public static boolean paintFill(COLOR[][]screen, int r, int c, COLOR ocolor, COLOR ncolor) {
		if (r < 0 || c < 0 || r >= screen.length || c >= screen[0].length)
			return false;
		if (screen[r][c] == ocolor) {
			screen[r][c] = ncolor;
			System.out.println("coloring " + r + "," + c + " with Color " + ncolor);
			paintFill(screen, r - 1, c, ocolor, ncolor);
			paintFill(screen, r, c - 1, ocolor, ncolor);
			paintFill(screen, r + 1, c, ocolor, ncolor);
			paintFill(screen, r, c + 1, ocolor, ncolor);
		}
		return true;
	}

	public static boolean paintFill(COLOR[][] screen, int r, int c, COLOR col) {
		if (screen[r][c] == col)
			return false;
		return paintFill(screen, r, c, screen[r][c], col);
	}

	public static void main(String[] args) {
		COLOR[][] screen = new COLOR[10][10];
		for(int i = 0 ; i < 10;i++)
			for(int j = 0;j<10;j++)
				screen[i][j] = COLOR.GREEN;
		PaintFill.paintFill(screen, 4, 3, COLOR.BLACK);
	}
}
