public class Main {
    public static double func1(float x, double func) {
        return Math.pow(Math.E, Math.tan(x)) /
                (Math.pow((1 - Math.asin(func)) / Math.PI, 2) + 1);
    }

    public static double func2(float x, double func) {
        return Math.cos(Math.pow(Math.atan(func), Math.pow(2 * x, 2)));
    }

    public static double func3(float x, double func) {
        return Math.pow(0.5 +
                        0.5 * Math.pow(2 * Math.pow((6 * x - 1) / (3 * x), 3), //посчитала разность под кубом
                                Math.cos(Math.pow(Math.E, x))),
                Math.pow(12 / (4 - Math.atan(func)), 3)); //домножила числитель и знаменатель на 4
    }

    public static void main(String[] args) {
        int[] w = new int[13];
        int k = 0;
        int MaxLength = 4;
        int Length = 4;
        for (int i = 12; i >= 0; i--) {
            w[k] = i + 5;
            k++;
        }
        /*for (int j : w) {
            System.out.println(j);
        }*/
        float[] x = new float[16];
        for (int i = 0; i < x.length; i++) {
            x[i] = (float) ((int) (Math.random() * (7 + 1)) - Math.random() * 11); //возвращает тип double, random - value [0; 1)
        }
        /*for (float j : x) {
            System.out.println(j);
        }*/
        double[][] z = new double[13][16];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 16; j++) {
                double func = (x[j] - 2) / 18;
                if (w[i] == 5) {
                    z[i][j] = func1(x[j], func);
                } else if ((w[i] > 7 && w[i] < 12) || (w[i] == 16) || (w[i] == 17)) {
                    z[i][j] = func2(x[j], func);
                } else {
                    z[i][j] = func3(x[j], func);
                }
                Length = String.valueOf((int) z[i][j]).length() + 3;
                if (z[i][j] > 123456789) {
                    Length = (int) Math.log10(z[i][j]) + 4;
                }
                if (Double.isNaN(z[i][j])) {
                    Length = 3;
                }
                if (Length > MaxLength) {
                    MaxLength = Length;
                }
                /*System.out.printf("%d ", Length);
                System.out.println();*/
            }
        }
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < z[i].length; j++) {
                Length = String.valueOf((int) z[i][j]).length() + 3;
                if (z[i][j] > 123456789) {
                    Length = (int) Math.log10(z[i][j]) + 4;
                }
                if (Double.isNaN(z[i][j])) {
                    Length = 3;
                }
                System.out.printf("%.2f ", z[i][j]);
                for (int a = 0; a < MaxLength - Length; a++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}