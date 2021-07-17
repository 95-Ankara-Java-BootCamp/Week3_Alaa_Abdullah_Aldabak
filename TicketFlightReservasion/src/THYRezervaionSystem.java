//public class THYRezervaionSystem {
    import java.util.Scanner;

    public class THYRezervaionSystem extends FlightReservasionSystem {

        private int businessOrEconomic;
        private int businessSeatNumber;
        private int economicSeatNumber;
        private boolean[] thyİnit;
        // THY rezervasyon sınıfı constructor
        public THYRezervaionSystem() {

        }

        private Scanner input = new Scanner(System.in);

        // THY rezervasyon sınıfı constructor Overloading
        public THYRezervaionSystem(int seatCounts) {
            if (seatCounts < 10) {
                System.out.println("Koltuk sayısı hatalı.Otomatik olarak 10 yapıldı  ");
                seatCounts = 10;
            }
            thyİnit = new boolean[seatCounts];
            for (int i = 0; i < seatCounts; i++) {
                thyİnit[i] = false;
            }

        }

        // uçağın testi dolu mu

        public boolean isEmpty() {
            boolean isFound = false;
            for (int i = 0; i < getThyİnit().length; i++) {
                if (thyİnit[i] == false){
                    isFound= true;
                    break;
                }
            }
            return isFound;
        }

        // Business numarasının  boşsa yazması

        public void writeBusinessNumber() {
            for (int i = 0; i < 5; i++) {
                if (thyİnit[i] == false)
                    System.out.print((i + 1) + " ");
            }
        }
        // Economi numarasının  boşsa yazması
        public void writeEconomicNumber() {
            for (int i = 5; i < getThyİnit().length; i++) {
                if (thyİnit[i] == false)
                    System.out.print((i + 1) + " ");
            }


        }
        // seçtiği koltuk naumarası yazmak
        public boolean resultSelectedNumber(int selectedNumber) {
            boolean isFull = false;
            if (selectedNumber < getThyİnit().length + 1) {
                if (thyİnit[selectedNumber - 1] == false) {
                    System.out.println("Koltuk no: "+ selectedNumber+" adınıza rezerve edildi.");
                    thyİnit[selectedNumber - 1] = true;
                    isFull = true;
                    return isFull;
                } else {
                    System.out.println(" seçtiğiniz hatalıdır! Lütfen yazıldığı numaradan seçiniz!");
                    return isFull;
                }
            } else {
                System.out.println("seçtiğiniz hatalıdır! Lütfen yazıldığı numaradan seçiniz!");
                return isFull;
            }
        }

        public boolean isEconomicFull() {
            boolean isFull = true;
            for (int i = 6; i < getThyİnit().length; i++) {
                if (thyİnit[i] == false) {
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
                if (thyİnit[i] == false) {
                    isFull = false;
                    break;
                }
            }
            return isFull;
        }
        // THY economi için resgale koltuk numarası yapmak
        @Override
        public void takeRezervasion() {
            System.out.println("THY REZERVASYON Sistemine hoş geldiniz ! ");
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
                            System.out.println("Lütfen 0 yada 1 seçiniz! ");
                        }
                    }

                }catch (Exception e){
                    System.out.println("Girdiğinz sayı doğru değildir.Lütfen tekrar deneyiniz!");

                }
            }

            if (getBusinessOrEconomic() == 0) {
               if (!isEmpty()){
                   System.out.println("Maalesef uçak doludur, rezervasyon alamıyoruz");
               }else if (isBusinessFull()) {
                    System.out.println("Maalesef Business koltuklarımız doludur!rezervasyon alamıyor ");
                } else {
                    System.out.println("Aşağıdaki boş koltuklarından birini seçiniz! ");
                    writeBusinessNumber();
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
                        System.out.println("Aşağıdaki boş koltuklarından birini seçiniz! ");
                        writeEconomicNumber();
                        isNumberWrong = true;
                        inputCheck = "";
                        while (isNumberWrong) {
                            try {
                                inputCheck = input.next();
                                if (Integer.class.isInstance(Integer.parseInt(inputCheck))) {
                                    setEconomicSeatNumber(Integer.parseInt(inputCheck));
                                    if (getEconomicSeatNumber() > 5 && getEconomicSeatNumber() < getThyİnit().length + 1 ) {
                                        isNumberWrong = false;
                                    } else {
                                        System.out.println(" seçtiğiniz hatalıdır! Lütfen yazıldığı numaradan seçiniz!");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Girdiğinz sayı doğru değildir.Lütfen tekrar deneyiniz!");
                            }
                        }
                        resultSelectedNumber(getEconomicSeatNumber());
                    }

                }
        }
        // rezarvasyon almak
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

        public void setBusinessOrEconomic(int businessOrEconomic) {
            this.businessOrEconomic = businessOrEconomic;
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

        public boolean[] getThyİnit() {
            return thyİnit;
        }

        public void setThyİnit(boolean[] thyİnit) {
            this.thyİnit = thyİnit;
        }
    }

