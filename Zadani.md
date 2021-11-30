<p align="center">
  <img src="https://engeto.cz/wp-content/uploads/2019/01/engeto-square.png" width="200" height="200">
</p>

# První projekt &mdash; Sazby DPH

Na prvním projektu byste si měli ověřit, že jste zvládli témata prvních šesti lekcí.

K&nbsp;projektu nebudete mít vzorové řešení.

Vaše řešení byste měli odevzdat v&nbsp;repozitáři, který si pro tento účel vytvoříte.

## Zadání

Naprogramuj aplikaci v&nbsp;Javě, která vypíše všechny státy Evropské unie, které mají sazbu daně z&nbsp;přidané hodnoty (DPH, VAT) vyšší, než 20&nbsp;% a&nbsp;nepoužívají speciální sazbu DPH/VAT.

Aktuální data o&nbsp;jednotlivých státech a&nbsp;jejich daních dostaneš v&nbsp;souboru &mdash; vzorový soubor je ke stažení zde: [vat-eu.csv](vat-eu.csv).

Vstupní soubor bude ve stejné složce, jako projekt aplikace.

## Formát vstupního souboru

Na každém řádku vstupního souboru jsou informace o&nbsp;jednom státu v&nbsp;následujícím formátu:

- zkratka státu (například `AT`)

- název státu (`Austria`)

- plná sazba daně z&nbsp;přidané hodnoty v&nbsp;procentech (`20`)

- snížená sazba daně z&nbsp;přidané hodnoty v&nbsp;procentech (`10`)

- informace o&nbsp;tom, jestli země používá speciální sazbu DPH pro některé produkty (`true`/`false`)

Jednotlivé hodnoty jsou odděleny vždy tabulátorem.

Příklad několika řádků souboru:
```
AT	Austria	20	10	true
BE	Belgium	21	12	true
BG	Bulgaria	20	9	false
CY	Cyprus	19	9	false
CZ	Czech Republic	21	15	false
```

> Poznámka:
> Všimni si, že v&nbsp;souboru jsou použity desetinné čárky.
>
> Je potřeba je buď:
> - nahradit za desetinné tečky (jednodušší varianta, hledej, jak nahradit v&nbsp;textovém řetězci znaky),
> - nebo k&nbsp;načítání desetinných čísel použít `Scanner`a vhodné národní nastavení.
>
> Je to trochu výzva — i&nbsp;v&nbsp;praxi mnohokrát potkáš situaci, kdy si nějaký kód musíš najít na webu. Věříme, že to zvládneš!

## Výstup aplikace

Postupně zpracuj tyto kroky:

1. Načti ze souboru všechna data do vhodné datové struktury (vytvoř třídu pro uložení dat).

2. Vypiš seznam všech států a&nbsp;u&nbsp;každého uveď základní sazbu daně z&nbsp;přidané hodnoty ve formátu podle vzoru:

    ```
    Název země (zkratka): základní sazba %
    ```
   Například:
    ```
    Austria (AT): 20 %
    Belgium (BE): 21 %
    ...
    ```

3. Vypište ve stejném formátu pouze státy, které mají základní sazbu daně z&nbsp;přidané hodnoty vyšší než 20&nbsp;% a&nbsp;přitom nepoužívají speciální sazbu daně.

4. Výpis z&nbsp;bodu 3. seřaď podle výše základní sazby DPH/VAT sestupně (nejprve státy s&nbsp;nejvyšší sazbou).

5. Pod výpis z&nbsp;bodu 3. doplň řádek s&nbsp;rovnítky pro oddělení a&nbsp;poté seznam zkratek států, které ve výpisu nefigurují. Opět dodrž formát podle vzoru (místo tří teček budou další státy):

    ```
    Sweden (SE):    25 % (12 %)
    Croatia (HR):   25 % (13 %)
    ...
    Finland (FI):   24 % (14 %)
    ...
    ====================
    Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: AT, CY, CZ,... 
    ```


5. Výsledný výpis zapiš také do souboru s&nbsp;názvem `vat-over-20.txt`. Výstupní soubor ulož do stejné složky, ve které byl vstupní soubor. (Výpis na obrazovku zůstává.)

6. Doplň možnost, aby uživatel z&nbsp;klávesnice zadal výši sazby DPH/VAT, podle které se má filtrovat. Vypíší se tedy státy se základní sazbou vyšší než ta, kterou uživatel zadal.
    - Pokud uživatel zmáčkne pouze Enter, jako výchozí hodnota se použij jako výchozí sazbu 20&nbsp;%.
    - Uprav název výstupního souboru tak, aby reflektoval zadanou sazbu daně. Například pro zadanou sazbu 17&nbsp;% se vygeneruje soubor `vat-over-17.txt` a&nbsp;pro sazbu 25&nbsp;% se vygeneruje soubor `vat-over-25.txt`.

## Zajímavé body zadání
1. Je dobré kód napsat tak, aby kód prošel jen jednou a&nbsp;rozdělil státy na „přes“ a&nbsp;„pod“.<br />(Aby nebylo potřeba procházet seznam dvakrát.)
2. Tvůj program by měl zvládnout vstup s&nbsp;desetinnými čísly s&nbsp;desetinnou čárkou.

## Veďte historii v Gitu
1. Během tvorby projektu odesílejte průběžné verze do Gitu a pište smysluplné „commit messages“ tak, aby se v historii dalo přehledně orientovat.

## Dotazy?

Pokud máš k&nbsp;zadání dotazy, nebo narazíš na problém, se kterým si delší dobu nevíte rady, obraťte se na lektora.

---

[Zpět na přehled akademie](https://github.com/ENGETO-Java-Akademie-2021/intro)
