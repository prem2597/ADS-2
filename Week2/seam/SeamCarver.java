// import java.lang.IllegalArgumentException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *  This method is implemented to create a immutable data type.
 *  @author Prem
 */
public class SeamCarver {

    private final Picture picture;
    private final int w;
    private final int h;
    private Color value;

    public SeamCarver(final Picture picture) {
        this.picture = picture;
        w = width();
        h = height();

    }

    public Picture picture() {
        return picture;
    }

    public int width() {
        return picture.width();

    }

    public int height() {
        return picture.height();

    }

    public double energy(final int x, final int y) {
        if (x == (width() - 1) || x == 0 || y == 0 || y == (height() - 1)) {
            return 1000.00;
        }
        if (x >= width() || x < 0 || y < 0 || y >= height()) {
            throw new IllegalArgumentException();
        }
        // return 0.0;
        return Math.pow((horizontal(x, y) + vertical(x, y)), 0.5);
    }

    private Integer[] rbg(final int x, final int y) {
        final List<Integer> arrList = new ArrayList<Integer>();
        // List<Integer> arrlist = new ArrayList<Integer>();
        value = picture.get(x, y);
        arrList.add(value.getRed());
        arrList.add(value.getBlue());
        arrList.add(value.getGreen());
        final Integer[] a = arrList.toArray(new Integer[3]);
        // int[] a = new int[arrlist.size()];
        // a = arrList.toArray();
        return a;
    }

    private double horizontal(final int x, final int y) {
        double dR, dG, dB;
        int left, right;
        left = x - 1;
        right = x + 1;
        // if (x == 0) {
        // if (x == (width() - 1) || x == 0 || y == 0 || y == (height() - 1)) {
        // return 1000;
        // }
        // if (x >= height() || x < 0 || y < 0 || y >= width()) {
        // throw new IllegalArgumentException();
        // }
        // }
        // if (x == 0) {
        // left = width() - 1;
        // } else if(x == width() - 1) {
        // right = 0;
        // }
        final Integer[] x1 = rbg(left, y);
        final Integer[] x2 = rbg(right, y);
        dR = x2[0] - x1[0];
        dB = x2[1] - x1[1];
        dG = x2[2] - x1[2];
        return dR * dR + dB * dB + dG * dG;
    }

    private double vertical(final int x, final int y) {
        double dR, dG, dB;
        int up, down;
        up = y - 1;
        down = y + 1;
        // if (y == 0) {
        // if (x == (width() - 1) || x == 0 || y == 0 || y == (height() - 1)) {
        // return 1000;
        // }
        // if (x >= height() || x < 0 || y < 0 || y >= width()) {
        // throw new IllegalArgumentException();
        // }
        // }
        // if (y == 0) {
        // up = height() - 1;
        // } else if (y == height() - 1) {
        // down = 0;
        // }
        final Integer[] y1 = rbg(x, up);
        final Integer[] y2 = rbg(x, down);
        dR = y2[0] - y1[0];
        dB = y2[1] - y1[1];
        dG = y2[2] - y1[2];
        return dR * dR + dB * dB + dG * dG;
    }

    public int[] findHorizontalSeam() {
        return null;
    }

    public int[] findVerticalSeam() {
        return null;
    }

    public void removeHorizontalSeam(final int[] seam) {

    }

    public void removeVerticalSeam(final int[] seam) {

    }

    // public static void main(String[] args) {
        
    // }
}
