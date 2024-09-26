public class Main {
    public static void main(String[] args) {
        int[] w = new int[13];
        int k = 0;
        for (int i = 12; i >= 0; i--) {
            w[k] = i+5;
            k++;
        }
        /*for (int j : w) {
            System.out.println(j);
        }*/
        float[] x = new float[16];
        for (int i = 0; i < x.length; i++) {
            x[i] = (float)(Math.random()*7-Math.random()*11); //возвращает тип double, random - value [0; 1]
        }
        for (float j : x) {
            System.out.println(j);
        }
        double[][] z = new double[13][16];
        for (int i = 0; i < 13; i++){
            for (int j = 0; j < 16; j++){
                double func = (x[j] - 2) / 18;
                if (w[i] == 5){
                    z[i][j] = Math.pow( Math.E, Math.tan(x[j]) ) /
                            ( Math.pow( ( 1 - Math.asin(func) )/ Math.PI , 2 ) + 1);
                }
                else if ( (w[i] > 7 && w[i] < 12) || ( w[i] == 16 ) || ( w[i] == 17 ) ){
                    z[i][j] = Math.cos( Math.pow( Math.atan( func ), Math.pow( 2*x[j], 2 ) ) );
                }
                else{
                    z[i][j] = Math.pow(0.5 +
                                    0.5 * Math.pow( 2* Math.pow( (6*x[j] - 1) / (3*x[j]) , 3 ), //посчитала разность под кубом
                                            Math.cos( Math.pow(Math.E, x[j]) ) ),
                            Math.pow( 12 / (4 - Math.atan(func)) , 3) ); //домножила числитель и знаменатель на 4
                }
            }
        }
        for (int i = 0; i < z.length; i++){
            for (int j = 0; j < z[i].length; j++){
                System.out.printf("%.2f ", z[i][j]);
            }
            System.out.println();
        }
    }
}