/**
 * 
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * 
 * Rectangle Area
 * Assume that the total area is never beyond the maximum possible value of int.
 * @author Shengyi
 *
 */
//Note: Note when the two squares are not over lap.

public class _223_Rectangle_Area {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return area(A, B, C, D) + area(E, F, G, H) - cover(A, B, C, D, E, F, G, H);
    }
	
	private int area(int A, int B, int C, int D) {
		return Math.abs(A - C) * Math.abs(B - D);
	}
	
	private int cover(int A, int B, int C, int D, int E, int F, int G, int H) {
		long a = Math.max(A, E);
		long b = Math.min(C, G);
		
		long h = b - a;
		
		long c = Math.max(B, F);
		long d = Math.min(D, H);
		
		long w = d - c;
		
		// 左下角取大的，右上角取晓得，如果右上角比左下角考下，就不相交
		if (w <= 0 || h <= 0) { 
			return 0;
		} else {
			return (int)w * (int)h;
		}
	}
}
