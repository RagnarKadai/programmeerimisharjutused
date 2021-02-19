// Programmeerimisharjutused. LTAT.03.007
// 2020/2021 kevadsemester
// Kodutöö. Ülesanne nr 1a
// Teema: Tsüklid
// Autor: Ragnar Kadai
// Inspiratsioon: Praktikum 1 ül 2

class AlgarvuRing {

    public static void main(String[] args) {
        //Argument käsurealt, mis töödeldakse täisarvuks ning rakendatakse meetodit algarvuRing(kasurida)
        int kasurida = Integer.parseInt(args[0]);
        System.out.println("Antud lähtekoht: "+ kasurida);
        System.out.println("Leitud algarvuringid:");
        algarvuRing(kasurida);
        System.out.println("Ragnar Kadai " + new java.sql.Timestamp(System.currentTimeMillis()));
    }

    public static void algarvuRing(int a){
        // Tingimusel, et arv on suurem kui 9 ja count ei ole 5 kontrollib, kas arv on algarv.
        // Kui arv on check läbinud (on algarv), siis läheb ta meetodi shuffle juurde, kus ta viimane arv läheb
        // esimeseks ja läbib uuesti kontrolli(check). Kui arv on iga kontrolli läbinud (igal ümberpaigutamisel
        // oli algarv), siis see algarvuringi arv prinditakse ning count tõuseb 1 võrra.
        // Kui arv ei läbi kuskil punktis testi, siis see arv unustatakse ja minnakse järgmise x-1 arvuga edasi.
        int count = 0; // Algarvuringide lugemiseks, et neid oleks 5
        for (int i = 1; i < a - 9 && count != 5; i++) {
            if (check(a - i)) { // Esialgne kontroll, kas baasarv on algarv, et edasi minna
                if (shuffle(a - i)) { // Arvu ümberpaigutamine ja edasine kontroll
                    count += 1; // Juhul, kui arv on läbinud kõik tingimused, siis shuffle meetodis prinditakse ta
                }               // ja count suureneb 1 võrra.
            }
        }
    }

    static boolean shuffle(int arv) {
        int x = String.valueOf(arv).length(); // teadmiseks mitu korda peab arvu ümber tõstma
        int uusarv = arv; //
        for (int i = 0; i < x; i++) {
            if (check(uusarv) && arv >= uusarv) { // Tingimus et eelnev arv oli algarv ja et ta ei olnud suurem
                int viimane = uusarv % 10;        // kui baasarv
                int esimene = uusarv / 10;
                int oige = esimene + viimane * (int) Math.pow(10, (int) Math.log10(uusarv));
                uusarv = oige;
                check(oige);
            }
            else {
                return false;
            }
        }
        System.out.println(uusarv);
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
