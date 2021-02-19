import java.util.Scanner;
class AlgarvuRing{


    public static void main(String[] args) {
        Scanner loeb = new Scanner(System.in);
        System.out.print("Antud lähtekoht: ");
        int a = loeb.nextInt();
        algarvuRing(a);
        System.out.println("Ragnar Kadai " + new java.sql.Timestamp(System.currentTimeMillis()));
    }



        static boolean shuffle ( int arv){
            int x = String.valueOf(arv).length();
            int uusarv = arv;
            boolean edasi = true;
            for (int i = 0; i < x; i++) {
                if (check(uusarv) && arv >= uusarv) {
                    int viimane = uusarv % 10;
                    int esimene = uusarv / 10;
                    int oige = esimene + viimane * (int) Math.pow(10, (int) Math.log10(uusarv));
                    uusarv = oige;
                    check(oige);
                } else {
                    edasi = false;
                    return false;
                }
            }
            if (edasi) {
                System.out.println(uusarv);
                return true;
            }
            return false;
        }




        static boolean check ( int arv){
            boolean mittealgarv = false;
            for (int i = 2; i <= arv / 2; ++i) {
                if (arv % i == 0) {
                    mittealgarv = true;
                    break;
                }
            }
            if (!mittealgarv) {
                return true;
            } else {
                return false;
            }
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
