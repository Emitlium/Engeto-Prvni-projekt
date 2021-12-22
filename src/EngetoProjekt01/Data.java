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
    private final List<Country> aboveVATnoPartialVat = new ArrayList<>();

    // == METHODS
    public List<Country> getListOfCountriesVAT() {
        return listOfCountriesVAT;
    }
    public List<Country> getAboveVATnoPartialVat() {
        return aboveVATnoPartialVat;
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

    // Metody k manipulování listů
    public void sortCountriesBasedOnVAT(BigDecimal bigDecimal){
        for (Country country : getListOfCountriesVAT()) {
            if (country.getFullVat().compareTo(bigDecimal) > 0 && !country.isHasPartialVat()){
                aboveVATnoPartialVat.add(country);
            }
        }
    }

    public void basePrint (boolean onlyAboveVatAndNoPartialVat, boolean sort, boolean code){
        if (onlyAboveVatAndNoPartialVat && sort) {
            List<String> temp = new ArrayList<>();
            getAboveVATnoPartialVat().sort(Comparator.comparing(Country::getFullVat).reversed());
            for (Country country : getAboveVATnoPartialVat()) {
                System.out.println(country.getNameCodeFullVat());
                temp.add(country.getCountryCode());
            }
            if (code){
                System.out.println("====================");
                System.out.println("Sazba VAT "+Filter.getVatFilter()+" % nebo nižší nebo používají speciální sazbu: ");

                temp.sort(Comparator.comparing(String::toString));
                for (String string : temp) {
                    System.out.print(string+", ");
                }
            }
        }

        else if (onlyAboveVatAndNoPartialVat) {
            for (Country country : getAboveVATnoPartialVat())
                System.out.println(country.getNameCodeFullVat());

        }

        else for (Country country : getListOfCountriesVAT()){
            System.out.println(country.getNameCodeFullVat());
        }
    }

    // == METHOD: EXPORT ==
    public void exportData(String file){
        List<String> temp = new ArrayList<>();
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            for (Country country : getAboveVATnoPartialVat()){
                if (country.getFullVat().doubleValue() > Filter.getVatFilter().doubleValue() && !country.isHasPartialVat()) {
                    writer.println(country.getNameCodeFullVat());
                } temp.add(country.getCountryCode());
            }
            writer.println("====================");
            writer.println("Sazba VAT "+ Filter.getVatFilter() +" % nebo nižší nebo používají speciální sazbu: ");
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
