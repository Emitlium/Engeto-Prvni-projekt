package EngetoProjekt01;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Data {
    // == ATTRIBUTES ==
    private final List<Country> listOfCountriesVAT = new ArrayList<>();

    // == METHODS
    public List<Country> getListOfCountriesVAT() {
        return listOfCountriesVAT;
    }

    // == METHOD: IMPORT ==
    public List<Country> importData(String fileName, String separator) {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().replaceAll(",", ".").split(separator);
                Country temp = new Country(
                        line[0].trim(),
                        line[1].trim(),
                        BigDecimal.valueOf(Double.parseDouble(line[2].trim())),
                        BigDecimal.valueOf(Double.parseDouble(line[3].trim())),
                        Boolean.parseBoolean(line[4].trim()));
                listOfCountriesVAT.add(temp);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listOfCountriesVAT;
    }

    // Vše v formátu "Název země (zkratka): základní sazba %"
    public void printNameCodeFullVat(){
        for (Country country : getListOfCountriesVAT()){
            System.out.println(country.getNameCodeFullVat());
        }
    }

    // Nad 20% full vat + bez partial vat, formát "Název země (zkratka): základní sazba %"
    public void printNCFullVat(){
        for (Country country : getListOfCountriesVAT()){
            if (country.getFullVat().doubleValue() > 20 && !country.isHasPartialVat()) {
                System.out.println(country.getNameCodeFullVat());
            }
        }
    }

    // Nad 20% full vat + bez partial vat, formát "Název země (zkratka): základní sazba %" + sort
    public void printNCFullVatSorted(){
        getListOfCountriesVAT().sort(Comparator.comparing(Country::getFullVat).reversed());
        printNCFullVat();
    }

    public void printNCFullVatSortedAndCC(){
        List<String> temp = new ArrayList<>();
        for (Country country : getListOfCountriesVAT()){
            if (country.getFullVat().doubleValue() > 20 && !country.isHasPartialVat()) {
                System.out.println(country.getNameCodeFullVat());
            } temp.add(country.getCountryCode());
        }
        System.out.println("====================");
        System.out.println("Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: ");
        temp.sort(Comparator.comparing(String::toString));
        for (String string : temp) {
            System.out.print(string+", ");
        }
    }

    public void exportPrintNCFullVatSortedAndCC(String file){
        List<String> temp = new ArrayList<>();
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            for (Country country : getListOfCountriesVAT()){
                if (country.getFullVat().doubleValue() > 20 && !country.isHasPartialVat()) {
                    writer.println(country.getNameCodeFullVat());
                } temp.add(country.getCountryCode());
            }
            writer.println("====================");
            writer.println("Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: ");
            temp.sort(Comparator.comparing(String::toString));
            for (String string : temp) {
                writer.print(string+", ");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
