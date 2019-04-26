package pl.i4less.ordertool.entity.systim;

import org.springframework.lang.Nullable;

public class OrderSystim extends Systim {

    private String nazwa;

    private String kod;

    private String miejscowosc;

    private String ulica;

    private String nazwaDostawy;

    private String kodDostawy;

    private String miejscowoscDostawy;

    private String ulicaDostawy;

    private int idDostawy;

    private int idMetodyDostawy;

    private ProductSystim produkty;

    private int idZamawiajacego;

    private String imie;

    private String nazwisko;

    @Nullable
    private int naliczanieBrutto;

    @Nullable
    private int idKontrahenta;

    @Nullable
    private int idWojewodztwa;

    @Nullable
    private String numer;

    @Nullable
    private int idWaluty;

    @Nullable
    private String opis;

    @Nullable
    private int idStatusu;

    @Nullable
    private int idObslugujacego;

    @Nullable
    private String nip;

    @Nullable
    private String panstwo;

    @Nullable
    private String panstwoDostawy;

    @Nullable
    private String uwagi;

    @Nullable
    private String email;

    @Nullable
    private String telefon;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNazwaDostawy() {
        return nazwaDostawy;
    }

    public void setNazwaDostawy(String nazwaDostawy) {
        this.nazwaDostawy = nazwaDostawy;
    }

    public String getKodDostawy() {
        return kodDostawy;
    }

    public void setKodDostawy(String kodDostawy) {
        this.kodDostawy = kodDostawy;
    }

    public String getMiejscowoscDostawy() {
        return miejscowoscDostawy;
    }

    public void setMiejscowoscDostawy(String miejscowoscDostawy) {
        this.miejscowoscDostawy = miejscowoscDostawy;
    }

    public String getUlicaDostawy() {
        return ulicaDostawy;
    }

    public void setUlicaDostawy(String ulicaDostawy) {
        this.ulicaDostawy = ulicaDostawy;
    }

    public int getIdDostawy() {
        return idDostawy;
    }

    public void setIdDostawy(int idDostawy) {
        this.idDostawy = idDostawy;
    }

    public int getIdMetodyDostawy() {
        return idMetodyDostawy;
    }

    public void setIdMetodyDostawy(int idMetodyDostawy) {
        this.idMetodyDostawy = idMetodyDostawy;
    }

    public ProductSystim getProdukty() {
        return produkty;
    }

    public void setProdukty(ProductSystim produkty) {
        this.produkty = produkty;
    }

    public int getIdZamawiajacego() {
        return idZamawiajacego;
    }

    public void setIdZamawiajacego(int idZamawiajacego) {
        this.idZamawiajacego = idZamawiajacego;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Nullable
    public int getNaliczanieBrutto() {
        return naliczanieBrutto;
    }

    public void setNaliczanieBrutto(@Nullable int naliczanieBrutto) {
        this.naliczanieBrutto = naliczanieBrutto;
    }

    @Nullable
    public int getIdKontrahenta() {
        return idKontrahenta;
    }

    public void setIdKontrahenta(@Nullable int idKontrahenta) {
        this.idKontrahenta = idKontrahenta;
    }

    @Nullable
    public int getIdWojewodztwa() {
        return idWojewodztwa;
    }

    public void setIdWojewodztwa(@Nullable int idWojewodztwa) {
        this.idWojewodztwa = idWojewodztwa;
    }

    @Nullable
    public String getNumer() {
        return numer;
    }

    public void setNumer(@Nullable String numer) {
        this.numer = numer;
    }

    @Nullable
    public int getIdWaluty() {
        return idWaluty;
    }

    public void setIdWaluty(@Nullable int idWaluty) {
        this.idWaluty = idWaluty;
    }

    @Nullable
    public String getOpis() {
        return opis;
    }

    public void setOpis(@Nullable String opis) {
        this.opis = opis;
    }

    @Nullable
    public int getIdStatusu() {
        return idStatusu;
    }

    public void setIdStatusu(@Nullable int idStatusu) {
        this.idStatusu = idStatusu;
    }

    @Nullable
    public int getIdObslugujacego() {
        return idObslugujacego;
    }

    public void setIdObslugujacego(@Nullable int idObslugujacego) {
        this.idObslugujacego = idObslugujacego;
    }

    @Nullable
    public String getNip() {
        return nip;
    }

    public void setNip(@Nullable String nip) {
        this.nip = nip;
    }

    @Nullable
    public String getPanstwo() {
        return panstwo;
    }

    public void setPanstwo(@Nullable String panstwo) {
        this.panstwo = panstwo;
    }

    @Nullable
    public String getPanstwoDostawy() {
        return panstwoDostawy;
    }

    public void setPanstwoDostawy(@Nullable String panstwoDostawy) {
        this.panstwoDostawy = panstwoDostawy;
    }

    @Nullable
    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(@Nullable String uwagi) {
        this.uwagi = uwagi;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(@Nullable String telefon) {
        this.telefon = telefon;
    }
    
}