// import java.lang.IllegalArgumentException;
import edu.princeton.cs.algs4.Picture;
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
    private static double[][] energyVal;
    private static double[][] energyData;
    private Color value;

    public SeamCarver(final Picture picture) {
        this.picture = picture;
        w = width();
        h = height();
        energyVal = new double[h][w];
        energyData = new double[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                energyVal[i][j] = energy(j, i);
                energyData[i][j] = energy(j, i);
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
        change();
        // energyVal = transpose(energyData);

        // findVerticalSeam();
        double[][] newEnergyDiff = new double[h][w];
        double[][] oldOne = energyData;
        for(int i = 0;i < h;i++){
            for(int j = 0;j < w;j++){
                newEnergyDiff[i][j] = energyData[j][i];
            }
        }
        energyVal = newEnergyDiff;
        int[] seamPathData2 = new int[energyVal.length];
        seamPathData2 = findVerticalSeam();
        return seamPathData2;
    }

    public int[] findVerticalSeam() {
        int[] seamPathData = new int[energyVal.length];
        
        // List<Integer> seamPathData = new ArrayList<Integer>();
        // int[][] resultSeam = new int[h][w];
        // for (int row = 0; row < height(); row++) {
        //     for (int col = 0; col < width(); col++) {
        //         // StdOut.printf("%9.02f ", energyVal[row][col]);
        //         if (row > 0 && col > 0 && col < width()-1) {
        //             check()
        //         }
        //     } 
        //     // StdOut.println();
        // }
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
        // System.out.println(min);
        // System.out.println(index);
        // for (int row = h; row < energyVal.length; row++) {
        //     for (int col = 0; col < energyVal[row].length; col++) {
        //         // StdOut.printf("%9.02f ", energyVal[row][col]);
                
        //     } 
        //     // StdOut.println();
        // }
        // int col = height() - 2;

        // while (height)
        int x = h;
        int y = index;
        // int i = 0;
        while (x > 0) {
            // System.out.println(y);
            // seamPathData.add(y);
            // for (int j = 0; j < energyVal[x - 1].length; j++) {
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
            // energyVal[i][j] = energyVal[i][j] + minm;
            // }
            index = y;
            // x--;
            // System.out.println(y);
            seamPathData[x-1] = y;
            x--;

        }

        // for (int i = 0; i < seamPathData.length; i++) {
        //     System.out.println(seamPathData[i]);
        // }

        return seamPathData;
    }

    private double check(double x1, double x2, double x3) {
        // Double[] arr = new Double[3];
        // arr = {};
        Double[] arr = {x1, x2, x3};
        Arrays.sort(arr);
        return arr[0];
    }

    private double check(double x1, double x2) {
        // Double[] arr = new Double[3];
        // arr = {};
        Double[] arr = {x1, x2};
        Arrays.sort(arr);
        return arr[0];
    }
    private void getCummulative() {
        // for (int row = 0; row < sc.height(); row++) {
        // for (int col = 0; col < sc.width(); col++)
        // StdOut.printf("%9.02f ", sc.energy(col, row));
        // StdOut.println();
        // }
        
        for (int i = 1; i < energyVal.length; i++) {
            // double minm = energyVal[i-1][0];
            if (i == 0 || i >= energyVal.length) {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < energyVal[i].length; j++) {
                // System.out.println(energyVal[i][j]);
                // string += array[i][j];
                // } System.out.println(string)
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
            // update(i, minm);
        }

        // for (int row = 0; row < energyVal.length; row++) {
        //     for (int col = 0; col < energyVal[row].length; col++) {
        //         StdOut.printf("%9.02f ", energyVal[row][col]);
        //     } 
        //     StdOut.println();
        // }
    }

    private void change() {
        int temp = w;
        w = h;
        h = temp;
    }

    // private static double[][] transpose(double[][] energyData2) {
    //     double[][] newArr = new double[energyData2[0].length][energyData2.length];
    //     for (int i = 0; i < energyData2.length; i++) {
    //         for (int j = i + 1; j < energyData2[0].length; j++) {
    //             newArr[j][i] = energyData2[i][j];
    //         }
    //     }
    //     return newArr;
    // }

    // private static void update(int i, Double minm) {
    //     if (i == energyVal.length - 1) {
    //         return;
    //     }
    //     for (int j = 0; j < energyVal[i+1].length; j++) {
    //         energyVal[i+1][j] = energyVal[i+1][j] + minm;
    //     }
    // }

    public void removeHorizontalSeam(final int[] seam) {
        // SeamRemover.removeHorizontalSeam(picture, findHorizontalSeam());
        // removeSeam(seam);
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
        // SeamRemover.removeVerticalSeam(picture, findVerticalSeam());
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

    // public static void main(String[] args) {

    //     Picture picture = new Picture(args[0]);
    //     // StdOut.printf("image is %d pixels wide by %d pixels high.\n", picture.width(), picture.height());

    //     SeamCarver sc = new SeamCarver(picture);

    //     // StdOut.printf("Printing energy calculated for each pixel.\n");

    //     // for (int row = 0; row < sc.height(); row++) {
    //     // for (int col = 0; col < sc.width(); col++)
    //     // StdOut.printf("%9.02f ", sc.energy(col, row));
    //     // StdOut.println();
    //     // }

    //     // for (int row = 0; row < energyVal.length; row++) {
    //     //     for (int col = 0; col < energyVal[row].length; col++) {
    //     //         StdOut.printf("%9.02f ", energyVal[row][col]);
    //     //     } 
    //     //     StdOut.println();
    //     // }
    //     // for (int row = 0; row < sc.height(); row++) {
    //     //     for (int col = 0; col < sc.width(); col++)
    //     //     StdOut.printf("%9.02f ", sc.energy(col, row));
    //     //     StdOut.println();
    //     // }
    //     StdOut.println("----------------------------------------------------------");
    //     // sc.getCummulative();
    //     sc.findVerticalSeam();
    //     StdOut.println("----------------------------------------------------------");
    //     sc.findHorizontalSeam();
    // }
}
