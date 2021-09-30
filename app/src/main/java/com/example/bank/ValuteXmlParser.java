package com.example.bank;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class ValuteXmlParser {
    private ArrayList<Valute> valutes;
    public ValuteXmlParser(){
        valutes = new ArrayList<>();
    }

    public ArrayList<Valute> getValutes() {
        return valutes;
    }
    public boolean parse(String xmlData){
        boolean status = true;
        Valute currentValutes = null;
        boolean isEntry = false;
        String textValue = "";
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(xmlData));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT){
                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if ("Valute".equalsIgnoreCase(tagName)){
                            isEntry = true;
                            currentValutes = new Valute();
                        }
                        break;
                        case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                        case XmlPullParser.END_TAG:
                            if (isEntry){
                                if ("Valute".equalsIgnoreCase(tagName)){
                                    valutes.add(currentValutes);
                                    isEntry = false;
                                }else if ("charCode".equalsIgnoreCase(tagName)){
                                    currentValutes.setCharCode(textValue);
                                }if ("Nominal".equalsIgnoreCase(tagName)){
                                    currentValutes.setNominal(textValue);
                                }if ("Name".equalsIgnoreCase(tagName)){
                                    currentValutes.setName(textValue);
                                }if ("Value".equalsIgnoreCase(tagName)){
                                    currentValutes.setValue(textValue);
                                }if ("NumCode".equalsIgnoreCase(tagName)){
                                    currentValutes.setNumCode(textValue);
                                }
                            }
                            break;
                    default:
                }
                eventType = xpp.next();
            }
        }
        catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }
}
