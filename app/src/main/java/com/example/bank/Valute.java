package com.example.bank;

public class Valute {
    private String NumCode, CharCode, Nominal, Name, Value;

    public String getNumCode() {
        return NumCode;
    }
    public String getCharCode() {
        return CharCode;
    }
    public String getNominal() {
        return Nominal;
    }
    public String getName() {
        return Name;
    }
    public String getValue() {
        return Value;
    }
    
    
    public void setNumCode(String value){
        this.NumCode = value;
    }
    public void setCharCode(String value){
        this.CharCode = value;
    }
    public void setNominal(String value){
        this.Nominal = value;
    }
    public void setName(String value){
        this.Name = value;
    }
    public void setValue(String value){
        this.Value = value;
    }
}


