// import java.lang.IllegalArgumentException;
import edu.princeton.cs.algs4.Picture;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *  This method is implemented to create a immutable data type.
 *  @author Prem
 *  @reference took help with piyush for implementing te remove horizontal and find horizontal methods.
 *  @reference algs4.
 */
public class SeamCarver {

    private Picture picture;
    // private int w;
    // private int h;
    // private static double[][] energyVal;
    // private static double[][] energyData;
    // private Color value;

    public SeamCarver(final Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException();
        }
        Picture picture2 = new Picture(picture);
        this.picture = picture2;
        // w = width();
        // h = height();
        double[][] energyVal = new double[picture.height()][picture.width()];
        // energyData = new double[h][w];
        for (int i = 0; i < picture.height(); i++) {
            for (int j = 0; j < picture.width(); j++) {
                energyVal[i][j] = energy(j, i);
                // energyData[i][j] = energy(j, i);
            }
        }
    }

    public Picture picture() {
        Picture picture2 = new Picture(this.picture);
        return picture2;
    }

    public int width() {
        return picture.width();

    }

    public int height() {
        return picture.height();

    }

    public double energy(final int x, final int y) {
        if (x >= width() || x < 0 || y < 0 || y >= height()) {
            throw new IllegalArgumentException();
        }
        if (x == (width() - 1) || x == 0 || y == 0 || y == (height() - 1)) {
            return 1000.00;
        }
        
        // return 0.0;
        return Math.pow((horizontal(x, y) + vertical(x, y)), 0.5);
    }

    private Integer[] rbg(final int x, final int y) {
        Color value;
        final List<Integer> arrList = new ArrayList<Integer>();
        // List<Integer> arrlist = new ArrayList<Integer>();
        value = picture.get(x, y);
        arrList.add(value.getRed());
        arrList.add(value.getBlue());
        arrList.add(value.getGreen());
        final Integer[] a = arrList.toArray(new Integer[3]);

        return a;
    }

    private double horizontal(final int x, final int y) {
        double dR, dG, dB;
        int left, right;
        left = x - 1;
        right = x + 1;

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

        final Integer[] y1 = rbg(x, up);
        final Integer[] y2 = rbg(x, down);
        dR = y2[0] - y1[0];
        dB = y2[1] - y1[1];
        dG = y2[2] - y1[2];
        return dR * dR + dB * dB + dG * dG;
    }

    public int[] findHorizontalSeam() {
        if (height() == 1) {
            // System.out.println(w);
            int[] x = new int[width()];
            Arrays.fill(x, 0);
            return x;
        }
        if (width() == 1) {
            int[] x = new int[width()];
            Arrays.fill(x, 0);
            return x;
        }
        int[] seamPathData = new int[picture.width()];
        double[][] seamData = getCummulativeHorizontal();
        int x = 0;
        double minimumenergy = 10000;
        for ( int j = 0; j < picture.height(); j++) {
            double energy = seamData[j][picture.width() - 1];
            if ( energy < minimumenergy) {
                minimumenergy = energy;
                x = j;
            }
        }
        seamPathData[picture.width() - 1] = x;
        for ( int i = picture.width() - 2; i >= 0; i--) {
            if ( x == 0) {
                if (seamData[x + 1][i] < seamData[x][i]) {
                    x++;
                }
            } else if (x == picture.height() - 1) {
                if (seamData[x - 1][i] <= seamData[x][i]) {
                    x--;
                }
            } else if (x > 0 && x < picture.height() - 1) {
                if (seamData[x - 1][i] <= seamData[x][i] && seamData[x - 1][i] <= seamData[x + 1][i]) {
                    x--;
                } else if (seamData[x + 1][i] < seamData[x][i] && seamData[x + 1][i] < seamData[x - 1][i]) {
                    x++;
                }
            }
            seamPathData[i] = x; 
        }
        return seamPathData;
    }

    public int[] findVerticalSeam() {
        double[][] energyVal = new double[picture.height()][picture.width()];
        // energyData = new double[h][w];
        for (int i = 0; i < picture.height(); i++) {
            for (int j = 0; j < picture.width(); j++) {
                energyVal[i][j] = energy(j, i);
                // energyData[i][j] = energy(j, i);
            }
        }
        if (width() == 1) {
            int[] x = new int[height()];
            Arrays.fill(x, 0);
            return x;
        }
        if (height() == 1) {
            int[] x = new int[height()];
            Arrays.fill(x, 0);
            return x;
        }
        int[] seamPathData = new int[energyVal.length];

        getCummulative();
        // StdOut.println("----------------------------------------------------------");
        double min = energyVal[energyVal.length-1][0];
        int index = 0;
        for (int col = 0; col < energyVal[0].length; col ++) {
            // min = energyVal[height()-1][col];
            if (min > energyVal[energyVal.length-1][col]) {
                min = energyVal[energyVal.length-1][col];
                index = col;
            }
        }

        int x = picture.height();
        int y = index;

        while (x > 0) {

            double minData = 0;
            if (energyVal[0].length == 1) {
                for (int i = 0; i <= energyVal.length; i++) {
                    seamPathData[i] = 0;
                }
                return seamPathData;
            }
            if (index >= energyVal[0].length) {
                throw new IllegalArgumentException();
            }
            if (x == 0 && index == 0) {
                throw new IllegalArgumentException();
            }
            if (index == 0) {
                minData = check(energyVal[x - 1][index], energyVal[x - 1][index + 1]);
                if (minData == energyVal[x - 1][index]) {
                    y = index;
                } else {
                    y = index + 1;
                }
            } else if (index == energyVal[0].length - 1) {
                minData = check(energyVal[x - 1][index], energyVal[x - 1][index - 1]);
                if (minData == energyVal[x - 1][index]) {
                    y = index;
                } else {
                    y = index - 1;
                }
            } else {
                minData = check (energyVal[x - 1][index - 1], energyVal[x - 1][index], energyVal[x - 1][index + 1]);
                if (minData == energyVal[x - 1][index - 1]) {
                    y = index - 1;
                } else if ( minData == energyVal[x - 1][index]){
                    y = index;
                } else {
                    y = index + 1;
                }
            }

            index = y;

            seamPathData[x-1] = y;
            x--;

        }


        return seamPathData;
    }

    private double check(double x1, double x2, double x3) {

        Double[] arr = {x1, x2, x3};
        Arrays.sort(arr);
        return arr[0];
    }

    private double check(double x1, double x2) {
        Double[] arr = {x1, x2};
        Arrays.sort(arr);
        return arr[0];
    }

    private void getCummulative() {
        double[][] energyVal = new double[picture.height()][picture.width()];
        // energyData = new double[h][w];
        for (int i = 0; i < picture.height(); i++) {
            for (int j = 0; j < picture.width(); j++) {
                energyVal[i][j] = energy(j, i);
                // energyData[i][j] = energy(j, i);
            }
        }
        
        for (int i = 1; i < energyVal.length; i++) {
            if (i == 0 || i >= energyVal.length) {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < energyVal[i].length; j++) {
                double minm = 0;
                if (j >= energyVal[i].length) {
                    throw new IllegalArgumentException();
                }
                if (j == 0) {
                    minm = check(energyVal[i - 1][j], energyVal[i - 1][j + 1]);
                } else if (j == energyVal[i].length - 1) {
                    minm = check(energyVal[i - 1][j], energyVal[i - 1][j - 1]);
                } else {
                    minm = check (energyVal[i - 1][j - 1], energyVal[i - 1][j], energyVal[i - 1][j + 1]);
                }
                energyVal[i][j] = energyVal[i][j] + minm;

                
            }
        }


    }

    private double[][] getCummulativeHorizontal() {
        double[][] energyVal = new double[picture.height()][picture.width()];
        // energyData = new double[h][w];
        for (int i = 0; i < picture.height(); i++) {
            for (int j = 0; j < picture.width(); j++) {
                energyVal[i][j] = energy(j, i);
                // energyData[i][j] = energy(j, i);
            }
        }
        double[][] horizontalenergy = energyVal;
        for ( int i = 0; i < picture.width(); i ++) {
            for (int j = 0; j < picture.height(); j ++) {
                if (i == 0) {
                    continue;
                } else if (j == 0) {
                    horizontalenergy[j][i] += check(horizontalenergy[j][i - 1], horizontalenergy[j + 1][i - 1]);
                } else if (j == picture.height() - 1) {
                    horizontalenergy[j][i] += check(horizontalenergy[j][i - 1], horizontalenergy[j - 1][i - 1]);
                } else {
                    double minimum = check(horizontalenergy[j - 1][i - 1], horizontalenergy[j][i - 1]);
                    minimum = check(minimum, horizontalenergy[j + 1][i - 1]);
                    horizontalenergy[j][i] += minimum;
                }
            }
        }
        return horizontalenergy;
    }


    public void removeHorizontalSeam(final int[] seam) {

        if(seam == null) {
            throw new IllegalArgumentException();
        }
        if(seam.length != picture.width()) {
            throw new IllegalArgumentException();
        }
        if(picture.height() <= 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i< seam.length; i++) {
            if (seam[i] < 0 || seam[i] >= picture.height()) {
                throw new IllegalArgumentException();
            }
            if ( i > 0 && !(Math.abs(seam[i] - seam[i - 1]) <= 1)) {
                throw new IllegalArgumentException();
            }
        }
        for (int i = 0; i < seam.length; i++) {
            for ( int j = seam[i]; j < picture.height() - 1; j++) {
                picture.set(i, j, picture.get(i, j+1));
            }
        }
        Picture resize = new Picture(picture.width(), picture.height() - 1);
        for (int i = 0; i < resize.width(); i++) {
            for ( int j = 0; j < resize.height(); j++) {
                resize.set(i, j, picture.get(i, j));
            }
        }
        picture = resize;
        
    }

    public void removeVerticalSeam(final int[] seam) {

        if(seam == null) {
            throw new IllegalArgumentException();
        }
        if(seam.length != picture.height()) {
            throw new IllegalArgumentException();
        }
        if(picture.width() <= 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i< seam.length; i++) {
            if (seam[i] < 0 || seam[i] >= picture.width()) {
                throw new IllegalArgumentException();
            }
            if ( i > 0 && !(Math.abs(seam[i] - seam[i - 1]) <= 1)) {
                throw new IllegalArgumentException();
            }
        }
        for (int i = 0; i < seam.length; i++) {
            for ( int j = seam[i]; j < picture.width() - 1; j++) {
                picture.set(j, i, picture.get(j+1, i));
            }
        }
        Picture resize = new Picture(picture.width() - 1, picture.height());
        for (int i = 0; i < resize.width(); i++) {
            for ( int j = 0; j < resize.height(); j++) {
                resize.set(i, j, picture.get(i, j));
            }
        }
        picture = resize;
    }

    public static void main(String[] args) {

        Picture picture = new Picture(args[0]);

        SeamCarver sc = new SeamCarver(picture);

        int[] xxx = sc.findHorizontalSeam();
        for(int i = 0; i < xxx.length; ++i) {
            System.out.println(xxx[i]);
        }
    }
}
