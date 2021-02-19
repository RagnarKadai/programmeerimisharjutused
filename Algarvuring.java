class AlgarvuRing {
    public static void main(String[] args) {
        algarvuRing(1000000);
        System.out.println("Ragnar Kadai " + new java.sql.Timestamp(System.currentTimeMillis()));
    }
    static boolean shuffle(int arv) {
        int x = String.valueOf(arv).length();
        int uusarv = arv;
        for (int i = 0; i < x; i++) {
            if (check(uusarv) && arv >= uusarv) {
                int viimane = uusarv % 10;
                int esimene = uusarv / 10;
                int oige = esimene + viimane * (int) Math.pow(10, (int) Math.log10(uusarv));
                uusarv = oige;
                check(oige);
            } else {
                return false;
            }
        }
        System.out.println(uusarv);
        return true;
    }
    static boolean check(int arv) {
        for (int i = 2; i <= Math.sqrt(arv)+1; i++) {
            if (arv % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void algarvuRing(int a){
        int count = 0;
        for (int i = 1; i < a - 9 && count != 5; i++) {
            if (check(a - i)) {
                if (shuffle(a - i)) {
                    count += 1;
                }
            }
        }
    }
}
