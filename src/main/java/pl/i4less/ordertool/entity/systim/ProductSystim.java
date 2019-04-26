package pl.i4less.ordertool.entity.systim;

import org.springframework.lang.Nullable;

public class ProductSystim extends Systim {

    private String nazwa;

    private double cenaBrutto;

    private double cenaNetto;

    private int idKategorii;

    private int stawkaVat;

    private int rodzaj;

    @Nullable
    private int idDodajacego;

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
    private String kodKreskowy;

    @Nullable
    private String kodProduktu;

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

    public double getCenaBrutto() {
        return cenaBrutto;
    }

    public void setCenaBrutto(double cenaBrutto) {
        this.cenaBrutto = cenaBrutto;
    }

    public double getCenaNetto() {
        return cenaNetto;
    }

    public void setCenaNetto(double cenaNetto) {
        this.cenaNetto = cenaNetto;
    }

    public int getIdKategorii() {
        return idKategorii;
    }

    public void setIdKategorii(int idKategorii) {
        this.idKategorii = idKategorii;
    }

    public int getStawkaVat() {
        return stawkaVat;
    }

    public void setStawkaVat(int stawkaVat) {
        this.stawkaVat = stawkaVat;
    }

    public int getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(int rodzaj) {
        this.rodzaj = rodzaj;
    }

    @Nullable
    public int getIdDodajacego() {
        return idDodajacego;
    }

    public void setIdDodajacego(@Nullable int idDodajacego) {
        this.idDodajacego = idDodajacego;
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
    public String getKodKreskowy() {
        return kodKreskowy;
    }

    public void setKodKreskowy(@Nullable String kodKreskowy) {
        this.kodKreskowy = kodKreskowy;
    }

    @Nullable
    public String getKodProduktu() {
        return kodProduktu;
    }

    public void setKodProduktu(@Nullable String kodProduktu) {
        this.kodProduktu = kodProduktu;
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

}