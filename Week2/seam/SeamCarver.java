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

    private Picture picture;
    private int w;
    private int h;
    private Color value;
    public SeamCarver(Picture picture) {
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

    public double energy(int x, int y) {
        if (x == (width() - 1) || x == 0 || y == 0 || y == (height() - 1)) {
            return 1000.00;
        }
        if (x >= height() || x < 0 || y < 0 || y >= width()) {
            throw new IllegalArgumentException();
        }
        // return 0.0;
        return Math.sqrt(horizontal(x, y) + vertical(x, y));
    }

    public int[] rbg(int x, int y) {
        List<Integer> arrList = new ArrayList<Integer>();
        // List<Integer> arrlist = new ArrayList<Integer>();
        value = picture.get(x, y);
        arrList.add(value.getRed());
        arrList.add(value.getBlue());
        arrList.add(value.getGreen());
        int[] a = new int[3];
        // int[] a = new int[arrlist.size()];
        arrList.toArray();
        return a;
    }

    public double horizontal(int x, int y) {
        double dR, dG, dB;
        int left, right;
        left = x - 1;
        right = x + 1;
        // if (x == 0) {
        //     if (x == (width() - 1) || x == 0 || y == 0 || y == (height() - 1)) {
        //         return 1000;
        //     }
        //     if (x >= height() || x < 0 || y < 0 || y >= width()) {
        //         throw new IllegalArgumentException();
        //     }
        // }
        if (x == 0) {
            left = width() - 1;
        } else if(x == width() - 1) {
            right = 0;
        }
        int[] x1 = rbg(left, y);
        int[] x2 = rbg(right, y);
        dR = Math.abs(x1[0] - x2[0]);
        dB = Math.abs(x1[1] - x2[1]);
        dG = Math.abs(x1[2] - x2[2]);
        return dR * dR + dB * dB + dG * dG;
    }

    public double vertical(int x, int y) {
        double dR, dG, dB;
        int up, down;
        up = y - 1;
        down = y + 1;
        // if (y == 0) {
        //     if (x == (width() - 1) || x == 0 || y == 0 || y == (height() - 1)) {
        //         return 1000;
        //     }
        //     if (x >= height() || x < 0 || y < 0 || y >= width()) {
        //         throw new IllegalArgumentException();
        //     }
        // }
        if (y == 0) {
            up = height() - 1;
        } else if (y == height() - 1) {
            down = 0;
        }
        int[] y1 = rbg(x, up);
        int[] y2 = rbg(x, down);
        dR = Math.abs(y1[0] - y2[0]);
        dB = Math.abs(y1[1] - y2[1]);
        dG = Math.abs(y1[2] - y2[2]);
        return dR * dR + dB * dB + dG * dG;
    }

    public int[] findHorizontalSeam() {
        return null;
    }

    public int[] findVerticalSeam() {
        return null;
    }
    public void removeHorizontalSeam(int[] seam) {

    }

    public void removeVerticalSeam(int[] seam) {

    }

    // public static void main(String[] args) {
        
    // }
}
