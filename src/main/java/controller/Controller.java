package controller;

import java.util.StringTokenizer;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;

public class Controller {

    public Controller(){}

    public StringEllenorzo stringellenorzo = new StringEllenorzo();
    public String beirtszoveg;
    public String uzenet;
    public StringTokenizer strtkn;
	
	@FXML
	private TextField bevitel;
	
	@FXML
	private Button ellenorzogomb;
	
	@FXML
	private Label eredmeny;
	
	@FXML
	private Button torles;
	
	@FXML
	private Button kilepes;
	
	@FXML
    public void initialize() { }
	
	@FXML
    private void ellenorzoGombAction(ActionEvent event){
        //beirtszoveg = bevitel.getText();
        //stringellenorzo.stringEllenorzese(beirtszoveg);
        //stringEllenorzese();
        controll();
    }

    @FXML
    private void torlesGombAction(ActionEvent event){
        bevitel.clear();
        //bevitel.
    }
	
	/*public void stringEllenorzese(){


		if(aBeirtKarakterekSzamaNulla(beirtszoveg)){
            return;
        }

		if(aBeirtKarakterekSzamaMaxTizennyolcLehet(beirtszoveg)){
		    return;
        }

        if(aBeirtSzovegSzokoztTartalmaz(beirtszoveg)){
            return;
        }

		if(nemMegengedettKaraktertTartalmaz(beirtszoveg)){
		    return;
        }

		if(azEgyHosszusaguHelyrajziSzamCsakNemNullaSzamLehet(beirtszoveg)){
		    return;
        }

		if(nemKezdodhetKetNullaval(beirtszoveg)){
		    return;
        }

        if(ketPerjelNemLehetEgymasMellett(beirtszoveg)){
            return;
        }

		if(maxHaromPerjelLehetBenne(beirtszoveg)){
		    return;
        }

		if(betuEsSzamjegyNemLehetEgymasMellett(beirtszoveg)){
		    return;
        }*/
    public void controll(){

        beirtszoveg = bevitel.getText();
        uzenet = stringellenorzo.stringEllenorzese(beirtszoveg);
        if(!uzenet.equals("OK")){
            eredmeny.setText(uzenet);
            return;
        }

		Kereses kereses = new Kereses();


        List<Hrsz> hrsz = kereses.readHrszBy(beirtszoveg);
        //eredmeny.setText(hrsz.get(0).getCim());
        //System.out.println(hrsz.get(0).getCim());
        //List<String> uzi = new List<String>();
        StringBuilder uzi = new StringBuilder();

		if(hrsz.isEmpty()){
		    eredmeny.setText("Nincs címe a nyilvántartásban.");
		    return;
        }
		else{
		    for(int i=0; i<hrsz.size();++i){
		        uzi.append(hrsz.get(i).getCim());
		        uzi.append("   (");
		        uzi.append(hrsz.get(i).getVarosresz());
		        uzi.append("   )\n");
		        //uzi =  + "  (" +  + "   )\n";
                    //    add(i, ;
            //hrsz.get(i).getCim() + "  (" + hrsz.get(i).getVarosresz() + "   )";
            }
		    eredmeny.setText(uzi.toString());
		    //eredmeny.setText(hrsz.toString());
		    return;
        }



	}
/*
    public boolean aBeirtKarakterekSzamaNulla(String str){
	    if(str.isEmpty()){
	        eredmeny.setText("A beírt karakterek száma nulla!");
	        return true;
        }
	    return false;
    }


    public boolean aBeirtKarakterekSzamaMaxTizennyolcLehet(String str){
        if(str.length() > 18){
            eredmeny.setText("A beírt karakterek száma maximum 18 lehet!");
            return true;
        }
            return false;
    }

    public boolean aBeirtSzovegSzokoztTartalmaz(String str){
        if(str.contains(" ")){
            eredmeny.setText("A beírt szöveg szóközt tartalmaz!");
            return true;
        }
        return false;
    }

    public boolean nemMegengedettKaraktertTartalmaz(String str){
        str = str.toUpperCase();
        for (int i=0; i<str.length(); ++i){
            int kodszam = str.codePointAt(i);
            if(!(karakterTipusaPerjel(kodszam) || karakterTipusaSzamjegy(kodszam) ||
                    karakterTipusaMegengedettBetu(kodszam) )){
                eredmeny.setText("Csak megengedett karaktereket tartalmazhat!");
                return true;
            }
        }
        return false;
    }

    public boolean azEgyHosszusaguHelyrajziSzamCsakNemNullaSzamLehet(String str){
	    if(str.length()==1 && !(str.codePointAt(0)>48 && str.codePointAt(0)<=57)){
	        eredmeny.setText("Az egy karakteres helyrajzi-szám csak számjegy lehet!");
	        return true;
        }
        return false;
    }

    public boolean nemKezdodhetKetNullaval(String str){
	    if(str.length()>1 && str.codePointAt(0)==48 && str.codePointAt(1)==48){
	        eredmeny.setText("Nem kezdődhet két nullával!");
	        return true;
        }
	    return false;
    }


    public boolean ketPerjelNemLehetEgymasMellett(String str){
        if(str.contains("//")){
            eredmeny.setText("Ket perjel nem lehet egymás mellett!");
            return true;
        }
        return false;
    }

    public boolean maxHaromPerjelLehetBenne(String str){
        int p = 0;
        for(int i = 0; i<str.length(); ++i){
            if(karakterTipusaPerjel(str.codePointAt(i))){
                ++p;
            }
            if(p>3){
                eredmeny.setText("Maximum 3 perjel lehet benne!");
                return true;
            }
        }
        return false;
    }


    public boolean betuEsSzamjegyNemLehetEgymasMellett(String str){
	    str = str.toUpperCase();
	    if(str.length()>1) {
            for (int i = 0; i < str.length()-1; ++i) {
                int kodszam = str.codePointAt(i);
                int kodszamPluszEgy = str.codePointAt(i + 1);
                if ( (karakterTipusaSzamjegy(kodszam) && karakterTipusaMegengedettBetu(kodszamPluszEgy)) ||
                        (karakterTipusaMegengedettBetu(kodszam) && karakterTipusaSzamjegy(kodszamPluszEgy))) {
                    eredmeny.setText("Betű és számjegy nem állhat egymás után!");
                    return true;
                }
            }
        }
	    return false;
    }



    public boolean karakterTipusaPerjel(int karakterkod){
        if(karakterkod == 47){
            return true;
        }
        return false;
    }

    public boolean karakterTipusaSzamjegy(int karakterkod){
        if(karakterkod >= 48 && karakterkod <= 57){
            return true;
        }
        return false;
    }

    public boolean karakterTipusaMegengedettBetu(int karakterkod){
        if( karakterkod >= 65 && karakterkod <=86 && karakterkod != 81){
            return true;
        }
        return false;
    }*/


}
