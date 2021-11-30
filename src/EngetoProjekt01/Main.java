package EngetoProjekt01;

public class Main {
    public static final String SEPARATOR = "\t";
    public static final String VAT_IMPORT = "vat-eu.csv";
    public static final String VAT_EXPORT = "vat-over-20.txt";

    public static void main(String[] args) {
	// write your code here

        // 1. Načti ze souboru všechna data do vhodné datové struktury (vytvoř třídu pro uložení dat).
        Data data = new Data();
        data.importData(VAT_IMPORT,SEPARATOR);

        //2. Vypiš seznam všech států a u každého uveď základní sazbu daně z přidané hodnoty ve formátu podle vzoru:
        System.out.println("\nVšechny státy ve formátu ze vzoru.");
        data.printNameCodeFullVat();
        System.out.println("\n---------\n");

        //3. Vypište ve stejném formátu pouze státy, které mají základní sazbu daně z přidané hodnoty vyšší než 20 % a přitom nepoužívají speciální sazbu daně.
        System.out.println("Pouze státy, které nepoužívají speciální sazbu daně a zároveň mají DPH vyšší než 20%");
        data.printNCFullVat();
        System.out.println("\n---------\n");

        //4. Výpis z bodu 3. seřaď podle výše základní sazby DPH/VAT sestupně (nejprve státy s nejvyšší sazbou).
        System.out.println("To samé, ale seřazeno od nejvyšší sazby po nejnižší");
        data.printNCFullVatSorted();
        System.out.println("\n---------\n");

        //5. Pod výpis z bodu 3. doplň řádek s rovnítky pro oddělení a poté seznam zkratek států,
        // které ve výpisu nefigurují. Opět dodrž formát podle vzoru.
        System.out.println("To samé + kódy zemí, které jsou POD 20% DPH nebo jají speciální sazbu");
        data.printNCFullVatSortedAndCC();
        System.out.println("\n---------\n");

        //6. Výsledný výpis zapiš také do souboru s názvem vat-over-20.txt.
        // Výstupní soubor ulož do stejné složky, ve které byl vstupní soubor. (Výpis na obrazovku zůstává.)
        data.exportPrintNCFullVatSortedAndCC(VAT_EXPORT);






    }
}
