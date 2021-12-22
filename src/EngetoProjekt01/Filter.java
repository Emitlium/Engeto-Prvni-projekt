package EngetoProjekt01;

import java.math.BigDecimal;
import java.util.Scanner;

public class Filter {
    static private BigDecimal vatFilter;
    static private Scanner scanner = new Scanner(System.in);

    public static BigDecimal getVatFilter() {
        return vatFilter;
    }

    static public void setVatFilter() throws NumberFormatException {
        String tempString;
        BigDecimal tempBigDecimal;

        System.out.println("Zadej svůj filtr pro VAT (pokud nic, base je 20%):");
        tempString = scanner.nextLine();

        if (tempString.isEmpty()){
            vatFilter = BigDecimal.valueOf(20);
            System.out.println("Nastavena base daň 20%");

        } else try {
            tempBigDecimal = BigDecimal.valueOf(Double.parseDouble(tempString.replaceAll(",", ".")));
            vatFilter = tempBigDecimal;
        } catch (NumberFormatException e){
            throw new NumberFormatException("Tohle není číslo!");}

//        if (vatFilter.compareTo(BigDecimal.valueOf(0)) <= 0){
        if (vatFilter.doubleValue() <= 0){
            vatFilter = null;
            throw new NumberFormatException("Nemůže být 0 a míň!");
        }
    }
}