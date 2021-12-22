package EngetoProjekt01;

import java.text.DecimalFormat;

public class Main {
    public static final String SEPARATOR = "\t";
    public static final String VAT_IMPORT = "vat-eu.csv";
    public static final String VAT_EXPORT_20 = "vat-over-20.txt";
    public static String VAT_EXPORT_DIF;

    public static void main(String[] args) {

        // 1. Načti ze souboru všechna data do vhodné datové struktury (vytvoř třídu pro uložení dat).
        Data data = new Data();
        data.importData(VAT_IMPORT,SEPARATOR);


        // 7.p1
        Filter.setVatFilter();
        data.sortCountriesBasedOnVAT(Filter.getVatFilter());
        DecimalFormat df = new DecimalFormat("#0.##");
        String temp = df.format(Filter.getVatFilter());
        VAT_EXPORT_DIF = "vat-over-"+temp+".txt";


        // 2. Vypiš seznam všech států a u každého uveď základní sazbu daně z přidané hodnoty ve formátu podle vzoru:
        System.out.println("\n2. Všechny státy ve formátu ze vzoru.");
        data.basePrint(false, false, false);
        System.out.println("\n---------\n");


        // 3. Vypište ve stejném formátu pouze státy, které mají základní sazbu daně z přidané hodnoty vyšší než 20 %
        // a přitom nepoužívají speciální sazbu daně.
        System.out.println("3. Pouze státy, které nepoužívají speciální sazbu daně a zároveň mají DPH vyšší než 20%");
        data.basePrint(true, false, false);
        System.out.println("\n---------\n");

//
//        //4. Výpis z bodu 3. seřaď podle výše základní sazby DPH/VAT sestupně (nejprve státy s nejvyšší sazbou).
        System.out.println("4. To samé, ale seřazeno od nejvyšší sazby po nejnižší");
        data.basePrint(true,true, false);
        System.out.println("\n---------\n");
//
//        //5. Pod výpis z bodu 3. doplň řádek s rovnítky pro oddělení a poté seznam zkratek států,
//        // které ve výpisu nefigurují. Opět dodrž formát podle vzoru.
        System.out.println("5. To samé + kódy zemí, které jsou POD 20% DPH nebo jají speciální sazbu");
        data.basePrint(true,true,true);
        System.out.println("\n---------\n");
//
//        //6. Výsledný výpis zapiš také do souboru s názvem vat-over-20.txt.
//        // Výstupní soubor ulož do stejné složky, ve které byl vstupní soubor. (Výpis na obrazovku zůstává.)
//        data.exportData(VAT_EXPORT_20);

        //7.p2 Doplň možnost, aby uživatel z klávesnice zadal výši sazby DPH/VAT, podle které se má filtrovat.
        // Vypíší se tedy státy se základní sazbou vyšší než ta, kterou uživatel zadal.
            //Pokud uživatel zmáčkne pouze Enter, jako výchozí hodnota se použij jako výchozí sazbu 20 %.
            //Uprav název výstupního souboru tak, aby reflektoval zadanou sazbu daně.
            // Například pro zadanou sazbu 17 % se vygeneruje soubor vat-over-17.txt a pro sazbu 25 % se vygeneruje soubor vat-over-25.txt.

        data.exportData(VAT_EXPORT_DIF);
    }
}
