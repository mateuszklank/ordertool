package pl.i4less.ordertool.entity.systim;

import org.springframework.lang.Nullable;
import pl.i4less.ordertool.ValueAnnotationBean;

public class Product extends Systim {

    private String nazwa;

    private double cena_brutto;

    private double cena_netto;

    private int id_kategorii;

    private int stawka_vat;

    private int rodzaj;

    @Nullable
    private int id_dodajacego;

    @Nullable
    private int ukryty;

    @Nullable
    private int naliczanie;

    @Nullable
    private String jednostka;

    @Nullable
    private int ilosc;

    @Nullable
    private String opis;

    @Nullable
    private String isbn;

    @Nullable
    private int kod_kreskowy;

    @Nullable
    private int kod_produktu;

    @Nullable
    private String pkwiu;

    @Nullable
    private String zalaczniki;

    @Nullable
    private String parametry;

    @Nullable
    private String zdjecie;

    @Nullable
    private String ceny;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena_brutto() {
        return cena_brutto;
    }

    public void setCena_brutto(double cena_brutto) {
        this.cena_brutto = cena_brutto;
    }

    public double getCena_netto() {
        return cena_netto;
    }

    public void setCena_netto(double cena_netto) {
        this.cena_netto = cena_netto;
    }

    public int getId_kategorii() {
        return id_kategorii;
    }

    public void setId_kategorii(int id_kategorii) {
        this.id_kategorii = id_kategorii;
    }

    public int getStawka_vat() {
        return stawka_vat;
    }

    public void setStawka_vat(int stawka_vat) {
        this.stawka_vat = stawka_vat;
    }

    public int getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(int rodzaj) {
        this.rodzaj = rodzaj;
    }

    @Nullable
    public int getId_dodajacego() {
        return id_dodajacego;
    }

    public void setId_dodajacego(@Nullable int id_dodajacego) {
        this.id_dodajacego = id_dodajacego;
    }

    @Nullable
    public int getUkryty() {
        return ukryty;
    }

    public void setUkryty(@Nullable int ukryty) {
        this.ukryty = ukryty;
    }

    @Nullable
    public int getNaliczanie() {
        return naliczanie;
    }

    public void setNaliczanie(@Nullable int naliczanie) {
        this.naliczanie = naliczanie;
    }

    @Nullable
    public String getJednostka() {
        return jednostka;
    }

    public void setJednostka(@Nullable String jednostka) {
        this.jednostka = jednostka;
    }

    @Nullable
    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(@Nullable int ilosc) {
        this.ilosc = ilosc;
    }

    @Nullable
    public String getOpis() {
        return opis;
    }

    public void setOpis(@Nullable String opis) {
        this.opis = opis;
    }

    @Nullable
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(@Nullable String isbn) {
        this.isbn = isbn;
    }

    @Nullable
    public int getKod_kreskowy() {
        return kod_kreskowy;
    }

    public void setKod_kreskowy(@Nullable int kod_kreskowy) {
        this.kod_kreskowy = kod_kreskowy;
    }

    @Nullable
    public int getKod_produktu() {
        return kod_produktu;
    }

    public void setKod_produktu(@Nullable int kod_produktu) {
        this.kod_produktu = kod_produktu;
    }

    @Nullable
    public String getPkwiu() {
        return pkwiu;
    }

    public void setPkwiu(@Nullable String pkwiu) {
        this.pkwiu = pkwiu;
    }

    @Nullable
    public String getZalaczniki() {
        return zalaczniki;
    }

    public void setZalaczniki(@Nullable String zalaczniki) {
        this.zalaczniki = zalaczniki;
    }

    @Nullable
    public String getParametry() {
        return parametry;
    }

    public void setParametry(@Nullable String parametry) {
        this.parametry = parametry;
    }

    @Nullable
    public String getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(@Nullable String zdjecie) {
        this.zdjecie = zdjecie;
    }

    @Nullable
    public String getCeny() {
        return ceny;
    }

    public void setCeny(@Nullable String ceny) {
        this.ceny = ceny;
    }

    public String toRequestString() {
        return "https://" + ValueAnnotationBean.getNumber() +
                ".systim.pl/jsonAPI.php?act=addProduct";
    }

    public String toParametersString() {
        return "&login=" + ValueAnnotationBean.getLogin() +
                "&pass=" + ValueAnnotationBean.getPass() +
                "&nazwa=" + getNazwa() +
                "&cena_brutto=" + getCena_brutto() +
                "&cena_netto=" + getCena_netto() +
                "&id_kategorii=" + getId_kategorii() +
                "&stawka_vat=" + + getStawka_vat() +
                "&rodzaj=" + getRodzaj() +
                "&opis=" + getOpis() +
                "&kod_kreskowy=" + getKod_kreskowy() +
                "&kod_produktu=" + getKod_produktu();
    }

}