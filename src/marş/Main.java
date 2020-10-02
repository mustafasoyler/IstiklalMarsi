package marş;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int toplamKarakterSayisi= 0;
        int toplamKelimeSayisi =0;
        int toplamSatirSayisi =0;
        HashMap<String,Integer> kelimeTekrariMap =new HashMap<>();


        try(BufferedReader okuyucu =new BufferedReader(new FileReader("istiklalmarsı.txt.txt"))) {

            String oankiSatir=okuyucu.readLine();
            while (oankiSatir !=null){
                toplamSatirSayisi++;

                String [] satirdakiKelimeDizisi =oankiSatir.toLowerCase().split(" ");
                toplamKelimeSayisi=toplamKelimeSayisi+satirdakiKelimeDizisi.length;

                for (String kelime : satirdakiKelimeDizisi){
                    if (kelimeTekrariMap.containsKey(kelime)){
                        kelimeTekrariMap.put(kelime,kelimeTekrariMap.get(kelime)+1);

                    }else
                    {
                        kelimeTekrariMap.put(kelime,1);

                    }

                    toplamKarakterSayisi=toplamKarakterSayisi+kelime.length();

                }


                oankiSatir= okuyucu.readLine();
            }
            System.out.println("Toplam satır sayısı "+toplamSatirSayisi);
            System.out.println("Toplam kelime sayısı "+toplamKelimeSayisi);
            System.out.println("Toplam karakter sayısı "+toplamKarakterSayisi);

            int tekrarSayisi =0;
            String encokKelimeTekrariEdenKelime=null;

            for (Map.Entry<String,Integer> temp : kelimeTekrariMap.entrySet()){
                if (temp.getValue() > tekrarSayisi && !temp.getKey().equals("")){
                    encokKelimeTekrariEdenKelime = temp.getKey();
                    tekrarSayisi=temp.getValue();

                }
            }
            System.out.println("En çok tekrar eden kelime :  " +encokKelimeTekrariEdenKelime+ " tekrar sayısı : " +tekrarSayisi);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
