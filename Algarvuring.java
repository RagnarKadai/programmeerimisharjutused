/*****************************************************************************
 * Programmeerimisharjutused. LTAT.03.007
 * 2020/2021 kevadsemester
 *
 * Kodutöö. Ülesanne nr 1a
 * Teema: Tsüklid
 *
 * Autor: Ragnar Kadai
 *
 * Mõningane eeskuju:
 * Arvude ümberpaigutuseks: Praktikum 1 ül 2
 * Algarvu kontrollimiseks: https://www.programiz.com/java-programming/examples/prime-number
 *****************************************************************************/
class AlgarvuRing {

    public static void main(String[] args) {
        //Argument käsurealt, mis töödeldakse täisarvuks ning rakendatakse meetodit algarvuRing(kasurida)
        int kasurida = 20;
        System.out.println("Antud lähtekoht: "+ kasurida);
        System.out.println("Leitud algarvuringid:");
        algarvuRing(kasurida);
        System.out.println("Ragnar Kadai " + new java.sql.Timestamp(System.currentTimeMillis()));
    }

    public static void algarvuRing(int a){
        int count = 0; // Loeb algarvuringe
        for (int i = 1; i < a - 9 && count != 5; i++) {
            if (check(a - i)) { // Esialgne kontroll, et arv on algarv
                if (shuffle(a - i)) { // Arvu ümberpaigutamine ja edasine kontroll
                    count += 1; // Kui arv on läbinud kõik tingimused, siis ta prinditakse ning loend suureneb
                }
            }
        }
    }

    static boolean shuffle(int arv) {
        int x = String.valueOf(arv).length(); // teadmiseks mitu korda peab arvu ümber tõstma
        int uusarv = arv; // paindlik int väärtus edasiseks kontrolliks
        for (int i = 0; i != x; i++) {
            if (check(uusarv) && arv >= uusarv) { // Tingimus et eelnev arv oli algarv ja et ta ei olnud suurem
                int viimane = uusarv % 10;        // kui baasarv
                int esimene = uusarv / 10;
                uusarv = esimene + viimane * (int) Math.pow(10, (int) Math.log10(uusarv));
            }
            else {
                return false;
            }
        }
        System.out.println(arv); // Väljastab arvu, kui ta on kõik algarvu ümberpaigutamised läbinud
        return true;
    }

    static boolean check(int arv) { // Kontrollime, kas arv on algarv
        for (int i = 2; i <= Math.sqrt(arv)+1; i++) {
            if (arv % i == 0) {
                return false;
            }
        }
        return true;
    }
}
