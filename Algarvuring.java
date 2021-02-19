import java.util.Scanner;

class AlgarvuRing{

    public static void main(String[] args){
        Scanner loeb = new Scanner(System.in);
        System.out.print("Antud lähtekoht: ");
        int count = 0;
        int arv = loeb.nextInt();
        for(int i = 0; i<arv-9 && count != 5; i++) {
            if (check(arv - i)) {
                if (shuffle(arv-i)) {
                    count += 1;
                }
            }
        }
        System.out.println("Ragnar Kadai "  + new java.sql.Timestamp(System.currentTimeMillis()));

    }//main
    static boolean shuffle(int uusarv) {
        int x = String.valueOf(uusarv).length();
        boolean edasi = true;
        int arv = uusarv;
        for (int i = 0; i < x; i++) {
            if (check(arv)) {
                int viimane = uusarv % 10;
                int esimene = uusarv / 10;
                int oige = esimene + viimane * (int) Math.pow(10, (int) Math.log10(uusarv));
                arv = oige;
                check(oige);
            } else {
                edasi = false;
                break;
            }
        }
        if (edasi) {
            System.out.println(uusarv);
            return true;
        }
        return edasi;
    }
    static boolean check(int arv) {
        boolean algarv = false;
        for (int i = 2; i <= arv / 2; ++i) {
            if (arv % i == 0) {
                algarv = true;
                break;
            }
        }
        if (!algarv) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void algarvuRing(int a){
        //a - algarvuringi leidmise l�htekoht
        //v�ljastab 5 l�himat algarvuringi antud l�htekohast a v�iksemate arvude hulgas
        //v�ib juhtuda, et vastavaid ringe on v�hem kui 5. Siis v�ljasta ainult need
        //�hekohaliste arvude seast algarvuringe ei otsi
        //v�ljastab igale reale t�pselt �he algarvuringi algusarvu, v��rtuste kahanedes
        //ekraanile v�ljastuses ei tohi olla t�hikuid ega t�hje ridu
        //...


    }//algarvuRing

}//klass AlgarvuRing
