public class MainRezervasyon {
    public static void main(String[] args) {
        THYRezervaionSystem thy = new THYRezervaionSystem(9);
        thy.repeatTakeRezervasion();
        PegasusRezervaionSystem pegasus = new PegasusRezervaionSystem(5);
        pegasus.repeatTakeRezervasion();



    }
}
