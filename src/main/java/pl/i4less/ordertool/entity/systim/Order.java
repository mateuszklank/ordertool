package pl.i4less.ordertool.entity.systim;

import org.springframework.lang.Nullable;

import java.util.List;

public class Order extends Systim {

    private String nazwa;

    private String kod;

    private String miejscowosc;

    private String ulica;

    private String nazwa_dostawy;

    private String kod_dostawy;

    private String miejscowosc_dostawy;

    private String ulica_dostawy;

    private int id_dostawy;

    @Nullable
    private List<Product> produkty;

    private int id_zamawiajacego;

    private String imie;

    private String nazwisko;

    @Nullable
    private int naliczanie_brutto;

    @Nullable
    private int id_kontrahenta;

    @Nullable
    private int id_wojewodztwa;

    @Nullable
    private String numer;

    @Nullable
    private int id_waluty;

    @Nullable
    private String opis;

    @Nullable
    private int id_statusu;

    @Nullable
    private int id_obslugujacego;

    @Nullable
    private String nip;

    @Nullable
    private String panstwo;

    @Nullable
    private String panstwo_dostawy;

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

    public String getNazwa_dostawy() {
        return nazwa_dostawy;
    }

    public void setNazwa_dostawy(String nazwa_dostawy) {
        this.nazwa_dostawy = nazwa_dostawy;
    }

    public String getKod_dostawy() {
        return kod_dostawy;
    }

    public void setKod_dostawy(String kod_dostawy) {
        this.kod_dostawy = kod_dostawy;
    }

    public String getMiejscowosc_dostawy() {
        return miejscowosc_dostawy;
    }

    public void setMiejscowosc_dostawy(String miejscowosc_dostawy) {
        this.miejscowosc_dostawy = miejscowosc_dostawy;
    }

    public String getUlica_dostawy() {
        return ulica_dostawy;
    }

    public void setUlica_dostawy(String ulica_dostawy) {
        this.ulica_dostawy = ulica_dostawy;
    }

    public int getId_dostawy() {
        return id_dostawy;
    }

    public void setId_dostawy(int id_dostawy) {
        this.id_dostawy = id_dostawy;
    }

    public List<Product> getProdukty() {
        return produkty;
    }

    public void setProdukty(List<Product> produkty) {
        this.produkty = produkty;
    }

    public int getId_zamawiajacego() {
        return id_zamawiajacego;
    }

    public void setId_zamawiajacego(int id_zamawiajacego) {
        this.id_zamawiajacego = id_zamawiajacego;
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
    public int getNaliczanie_brutto() {
        return naliczanie_brutto;
    }

    public void setNaliczanie_brutto(@Nullable int naliczanie_brutto) {
        this.naliczanie_brutto = naliczanie_brutto;
    }

    @Nullable
    public int getId_kontrahenta() {
        return id_kontrahenta;
    }

    public void setId_kontrahenta(@Nullable int id_kontrahenta) {
        this.id_kontrahenta = id_kontrahenta;
    }

    @Nullable
    public int getId_wojewodztwa() {
        return id_wojewodztwa;
    }

    public void setId_wojewodztwa(@Nullable int id_wojewodztwa) {
        this.id_wojewodztwa = id_wojewodztwa;
    }

    @Nullable
    public String getNumer() {
        return numer;
    }

    public void setNumer(@Nullable String numer) {
        this.numer = numer;
    }

    @Nullable
    public int getId_waluty() {
        return id_waluty;
    }

    public void setId_waluty(@Nullable int id_waluty) {
        this.id_waluty = id_waluty;
    }

    @Nullable
    public String getOpis() {
        return opis;
    }

    public void setOpis(@Nullable String opis) {
        this.opis = opis;
    }

    @Nullable
    public int getId_statusu() {
        return id_statusu;
    }

    public void setId_statusu(@Nullable int id_statusu) {
        this.id_statusu = id_statusu;
    }

    @Nullable
    public int getId_obslugujacego() {
        return id_obslugujacego;
    }

    public void setId_obslugujacego(@Nullable int id_obslugujacego) {
        this.id_obslugujacego = id_obslugujacego;
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
    public String getPanstwo_dostawy() {
        return panstwo_dostawy;
    }

    public void setPanstwo_dostawy(@Nullable String panstwo_dostawy) {
        this.panstwo_dostawy = panstwo_dostawy;
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

    @Override
    public String toString() {
        return "Order{" +
                "nazwa='" + nazwa + '\'' +
                ", kod='" + kod + '\'' +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nazwa_dostawy='" + nazwa_dostawy + '\'' +
                ", kod_dostawy='" + kod_dostawy + '\'' +
                ", miejscowosc_dostawy='" + miejscowosc_dostawy + '\'' +
                ", ulica_dostawy='" + ulica_dostawy + '\'' +
                ", id_dostawy=" + id_dostawy +
                ", produkty=" + produkty +
                ", id_zamawiajacego=" + id_zamawiajacego +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", naliczanie_brutto=" + naliczanie_brutto +
                ", id_kontrahenta=" + id_kontrahenta +
                ", id_wojewodztwa=" + id_wojewodztwa +
                ", numer='" + numer + '\'' +
                ", id_waluty=" + id_waluty +
                ", opis='" + opis + '\'' +
                ", id_statusu=" + id_statusu +
                ", id_obslugujacego=" + id_obslugujacego +
                ", nip='" + nip + '\'' +
                ", panstwo='" + panstwo + '\'' +
                ", panstwo_dostawy='" + panstwo_dostawy + '\'' +
                ", uwagi='" + uwagi + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }

}