package de.g8keeper.mykotlinfinal;

import java.util.Objects;

public class Person {

    private String vName;
    private String nName;
    private String strasse;
    private int hNr;
    private String ort;
    private String plz;
    private int alter;
    //private boolean isMitarbeiter;


    public Person(String vName, String nName, String strasse, int hNr, String ort, String plz, int alter) {
        this.vName = vName;
        this.nName = nName;
        this.strasse = strasse;
        this.hNr = hNr;
        this.ort = ort;
        this.plz = plz;
        this.alter = alter;
    }

    public Person(Person other) {
        this.vName = other.vName;
        this.nName = other.nName;
        this.strasse = other.strasse;
        this.hNr = other.hNr;
        ort = other.ort;
        this.plz = other.plz;
        this.alter = other.alter;
    }

    public String getVName() {
        return vName;
    }

    public void setVName(String vName) {
        this.vName = vName;
    }

    public String getNName() {
        return nName;
    }

    public void setNName(String nName) {
        this.nName = nName;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int gethNr() {
        return hNr;
    }

    public void sethNr(int hNr) {
        this.hNr = hNr;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    @Override
    public String toString() {
        return "Person{" +
                "vName='" + vName + '\'' +
                ", nName='" + nName + '\'' +
                ", strasse='" + strasse + '\'' +
                ", hNr=" + hNr +
                ", ort='" + ort + '\'' +
                ", plz='" + plz + '\'' +
                ", alter=" + alter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return hNr == person.hNr &&
                alter == person.alter &&
                Objects.equals(vName, person.vName) &&
                Objects.equals(nName, person.nName) &&
                Objects.equals(strasse, person.strasse) &&
                Objects.equals(ort, person.ort) &&
                Objects.equals(plz, person.plz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vName, nName, strasse, hNr, ort, plz, alter);
    }
}
