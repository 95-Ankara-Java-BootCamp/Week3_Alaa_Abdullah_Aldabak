
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

public class PegasusRezervaionSystem extends FlightReservasionSystem {

    private int businessOrEconomic;
    private int businessSeatNumber;
    private int economicSeatNumber;
    private boolean[] pegasusİnit;
    private Scanner input = new Scanner(System.in);
    List<Integer> emptySeatList = new ArrayList<Integer>() ;
    private static int randomIndex;
    // Pegasus rezervasyon sınıfı constructor
    public PegasusRezervaionSystem() {

    }
    // Pegasus rezervasyon sınıfı constructor Overloading
    public PegasusRezervaionSystem(int seatCounts) {
        if (seatCounts < 10) {
            System.out.println("Koltuk sayısı hatalı.Otomatik olarak 10 yapıldı ");
            seatCounts = 10;
        }
        pegasusİnit = new boolean[seatCounts];
        for (int i = 0; i < seatCounts; i++) {
            pegasusİnit[i] = false;
        }

    }
// uçağın testi dolu mu
    public boolean isEmpty() {

        boolean isFound = false;
        for (int i = 0; i < getPegasusİnit().length; i++) {
            if (pegasusİnit[i] == false){
                isFound= true;
                break;
            }
        }

        return isFound;
    }

    // Business numarasının  boşsa yazması
    public void writeBusinessNumber() {
        for (int i = 0; i < 5; i++) {
            if (pegasusİnit[i] == false)
                System.out.print((i + 1) + " ");
        }
    }

    // seçtiği koltuk naumarası yazmak

    public boolean resultSelectedNumber(int selectedNumber) {
        boolean isFull = false;
        if (selectedNumber < getPegasusİnit().length + 1) {
            if (pegasusİnit[selectedNumber - 1] == false) {
                System.out.println("Koltuk no: "+ selectedNumber+" adınıza rezerve edildi.");
                pegasusİnit[selectedNumber - 1] = true;
                isFull = true;
                return isFull;
            } else {
                System.out.println("seçtiğiniz hatalıdır! Lütfen yazıldığı numaradan seçiniz!");
                return isFull;
            }
        } else {
            System.out.println("seçtiğiniz hatalıdır! Lütfen yazıldığı numaradan seçiniz!");
            return isFull;
        }
    }
    // economi testi dolu mu
    public boolean isEconomicFull() {
        boolean isFull = true;
        for (int i = 6; i < pegasusİnit.length; i++) {
            if (pegasusİnit[i] == false) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    // Business testi dolu mu
    public boolean isBusinessFull() {
        boolean isFull = true;
        for (int i = 0; i < 5; i++) {
            if (pegasusİnit[i] == false) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }
    // Pegasus economi için resgale koltuk numarası yapmak
    public static int getRandom(List<Integer> emptySeatList) {
        int rnd = new Random().nextInt(emptySeatList.size());
        randomIndex = rnd;
        return emptySeatList.get(rnd);
    }

// rezarvasyon almak
    @Override
    public void takeRezervasion() {
        System.out.println("Pegasus REZERVASYON Sistemine hoş geldiniz ! ");
        System.out.println("Business class uçmak için 0'a basınız , ekonomik class uçmak için 1'a basınız ");
        boolean isNumberWrong = true;
        String inputCheck = "";
        while (isNumberWrong) {
            try {
                inputCheck = input.next();
                if (Integer.class.isInstance(Integer.parseInt(inputCheck))) {
                    setBusinessOrEconomic(Integer.parseInt(inputCheck));
                    if (getBusinessOrEconomic() ==0 || getBusinessOrEconomic() ==1 ) {
                        isNumberWrong = false;
                    } else {
                        System.out.println("Lütfen 0 yada 1 seçiniz!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Girdiğinz sayı doğru değildir.Lütfen tekrar deneyiniz!");
            }
        }


        if (getBusinessOrEconomic() == 0) {
            if (!isEmpty()){
                System.out.println("Maalesef uçak doludur, rezervasyon alamıyoruz");
            }else if (isBusinessFull()) {
                System.out.println("Maalesef Business koltuklarımız doludur!rezervasyon alamıyor  ");
            } else {
                System.out.println("Aşağıdaki boş koltuklarından birini seçiniz!");
                writeBusinessNumber();
               // setBusinessSeatNumber(input.nextInt());
                isNumberWrong = true;
                inputCheck = "";
                while (isNumberWrong) {
                    try {
                        inputCheck = input.next();
                        if (Integer.class.isInstance(Integer.parseInt(inputCheck))) {
                            setBusinessSeatNumber(Integer.parseInt(inputCheck));
                            if (getBusinessSeatNumber() > 0 && getBusinessSeatNumber() < 6  ) {
                                isNumberWrong = false;
                            } else {
                                System.out.println(" seçtiğiniz hatalıdır! Lütfen yazıldığı numaradan seçiniz!");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Girdiğinz sayı doğru değildir.Lütfen tekrar deneyiniz!");
                    }
                }
                resultSelectedNumber(getBusinessSeatNumber());

            }

        } else if (getBusinessOrEconomic() == 1) {
            if (!isEmpty()){
                System.out.println("Maalesef uçak doludur, rezervasyon alamıyoruz");
            }else if (isEconomicFull()) {
                System.out.println("Maalesef Ekonomik koltuklarımız doludur!rezervasyon alamıyor");
            } else {

                for(int i=6; i<pegasusİnit.length; i++){
                    if(pegasusİnit[i]== false)
                        emptySeatList.add(i+1);
                }
                int randomNumber = getRandom(emptySeatList);

                resultSelectedNumber(randomNumber);
                emptySeatList.remove(randomIndex);
            }


            }


    }
    // Rezervasyon almak tekrarı
    public void repeatTakeRezervasion(){
        takeRezervasion();
        boolean ischeck = true;
        while (ischeck){
            System.out.println("Devam etmek için C'ye, çıkmak için herhangi başka bir tuşa basınız!");
            String selectedContinueOrStop = input.next();
             if (selectedContinueOrStop.equals("c") || selectedContinueOrStop.equals("C")){
                 takeRezervasion();
             }else {
                 System.out.println("Bizi seçtiğiniz teşekkürler");
                 ischeck = false;
             }
       }
    }

    public int getBusinessOrEconomic() {
        return businessOrEconomic;
    }

    public void setBusinessOrEconomic(int businessOrEkonomik) {
        this.businessOrEconomic = businessOrEkonomik;
    }

    public int getBusinessSeatNumber() {
        return businessSeatNumber;
    }

    public void setBusinessSeatNumber(int businessSeatNumber) {
        this.businessSeatNumber = businessSeatNumber;
    }

    public int getEconomicSeatNumber() {
        return economicSeatNumber;
    }

    public void setEconomicSeatNumber(int economicSeatNumber) {
        this.economicSeatNumber = economicSeatNumber;
    }

    public boolean[] getPegasusİnit() {
        return pegasusİnit;
    }

    public void setPegasusİnit(boolean[] pegasusİnit) {
        this.pegasusİnit = pegasusİnit;
    }
}
