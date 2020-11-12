package unsw.gloriaromanus;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BasicMenuController extends MenuController{

    // https://stackoverflow.com/a/30171444
    @FXML
    private URL location; // has to be called location

    @FXML
    private Button buyInfraButton;

    @FXML
    private Button upgradeInfraButton;

    @FXML
    private Button buyTroopButton;

    @FXML
    private Button createUnitButton;

    @FXML
    private TextField unitName;

    @FXML
    private TextField troopqty;
    
    @FXML
    private ChoiceBox<String> Infrabuymenu;

    @FXML
    private ChoiceBox<String> infraupgrademenu;

    @FXML
    private ChoiceBox<String> trooptype;

    @FXML
    private ChoiceBox<String> trooptype1;

    @FXML
    private ChoiceBox<String> unitTypeMenu;

    @FXML
    private TextArea out_terminal;

    @FXML
	public void initialize() {
        ArrayList<String> infra = new ArrayList<String>();
        //getParent().getBuildCost();
        infra.add("Troop Production Building"); infra.add("Market"); infra.add("Mine"); infra.add("Port");
        infra.add("Road"); infra.add("Smiths"); infra.add("Wall"); infra.add("Farm");
        Infrabuymenu.getItems().addAll(infra);
        infraupgrademenu.getItems().addAll(infra);
        ArrayList<String> trooop = new ArrayList<String>();
        trooop.add("Cannon"); trooop.add("MissileMan"); trooop.add("HorseArcher"); trooop.add("Trebuchet"); trooop.add("Javelin");
        trooop.add("Crossbowman"); trooop.add("Hopitle"); trooop.add("Berserker"); trooop.add("Camel"); trooop.add("Pikeman");
        trooop.add("Chariot"); trooop.add("Elephant"); trooop.add("Swordsman"); trooop.add("Spearman"); trooop.add("Lancer");
        trooop.add("NetFighter"); trooop.add("Druid"); trooop.add("legionary"); 
        unitTypeMenu.getItems().addAll(trooop);
        //trooptype.getItems().addAll(getParent().retriveUnitName());
        //trooptype1.getItems().addAll(getParent().retriveUnitName());
	}

    public void appendToTerminal(String message) {
        out_terminal.appendText(message + "\n");
    }

    @FXML
    public void buyInfraButtonp2(ActionEvent e) throws IOException {
        getParent().buyInfraButton(e, Infrabuymenu.getValue(), 2);
    }

    @FXML
    public void buyInfraButton(ActionEvent e) throws IOException {
        getParent().buyInfraButton(e, Infrabuymenu.getValue(), 1);
    }

    @FXML
    public void upgradeInfraButtonp2(ActionEvent e) throws IOException {
        getParent().upgradeInfraButton(e, infraupgrademenu.getValue(), 2);
    }

    @FXML
    public void upgradeInfraButton(ActionEvent e) throws IOException {
        getParent().upgradeInfraButton(e, infraupgrademenu.getValue(), 1);
    }

    @FXML
    public void buyTroopButtonp2(ActionEvent e) throws IOException {
        try {
            int qty = Integer.parseInt(troopqty.getText());
            getParent().buyTroopButton(e, trooptype1.getValue(), 2, qty);
        } catch (NumberFormatException g) {
            out_terminal.appendText("Text entered should be a number");
        }
        
    }

    @FXML
    public void buyTroopButton(ActionEvent e) throws IOException {
        try {
            int qty = Integer.parseInt(troopqty.getText());
            getParent().buyTroopButton(e, trooptype.getValue(), 1, qty);
        } catch (NumberFormatException g) {
            out_terminal.appendText("Text entered should be a number");
        }
    }

    @FXML
    public void createUnitButtonp2(ActionEvent e) throws IOException {
        getParent().createUnitButton(e, unitTypeMenu.getValue(), 2, unitName.getText());
    }

    @FXML
    public void createUnitButton(ActionEvent e) throws IOException {
        getParent().createUnitButton(e, unitTypeMenu.getValue(), 1, unitName.getText());
    }

}