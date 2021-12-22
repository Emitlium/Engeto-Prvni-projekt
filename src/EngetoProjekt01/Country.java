package EngetoProjekt01;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Country {
    // == ATTRIBUTES ==
    private String countryCode, countryName;
    private BigDecimal fullVat, partialVat;
    private boolean hasPartialVat;

    // == CONSTRUCTOR ==
    public Country(String countryCode, String countryName, BigDecimal fullVat, BigDecimal partialVat, boolean hasPartialVat) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.fullVat = fullVat;
        this.partialVat = partialVat;
        this.hasPartialVat = hasPartialVat;
    }

    // == METHODS ==
    public String getCountry(){
        String s = "\t";
        return getCountryCode()+s+getCountryName()+s+getFullVat()+s+getPartialVat()+s+isHasPartialVat();
    }

    public String getNameCodeFullVat(){
        DecimalFormat df = new DecimalFormat("#0.##");
        return getCountryName()+" ("+getCountryCode()+"): "+df.format(getFullVat())+" %";
    }


    // == GET&SET ==
    public String getCountryCode() {
        return countryCode;
    }
    public String getCountryName() {
        return countryName;
    }
    public BigDecimal getFullVat() {
        return fullVat;
    }
    public BigDecimal getPartialVat() {
        return partialVat;
    }
    public boolean isHasPartialVat() {
        return hasPartialVat;
    }
}
