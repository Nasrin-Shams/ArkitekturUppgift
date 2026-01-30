package com.example.arkitektuppgit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Main extends Application {

    private ComboBox<String> tartTypeComboBox;
    private DatePicker datePicker;
    private TextField nameField, tartaField;
    private TextArea resultArea;
    private List<Bestallning> bestallnings;

    @Override
    public void start(Stage primaryStage) {
        bestallnings = new ArrayList<>();
        BorderPane root = new BorderPane();
        root.setCenter(createMainLayout());

        Scene scene = new Scene(root, 600, 700);
        primaryStage.setTitle("Wigells Bageri");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createMainLayout() {
        tartTypeComboBox = new ComboBox<>();
        tartTypeComboBox.getItems().addAll("Prinsesstårta", "Operatårta", "Chokladtårta");
        tartTypeComboBox.setPromptText("Välj tårttyp");

        nameField = new TextField();
        nameField.setPromptText("Ange ditt namn");

        tartaField = new TextField();
        tartaField.setPromptText("Ange antal tårtor");

        datePicker = new DatePicker();
        datePicker.setPromptText("Välj datum");

        Button bestallningButton = new Button("Bekräfta Beställning");
        bestallningButton.setOnAction(_ -> handleBestallning());
        bestallningButton.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));

        Button showBestallningsButton = new Button("Visa alla beställningar");
        showBestallningsButton.setOnAction(_ -> showAllBestallningar());
        showBestallningsButton.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));

        resultArea = new TextArea();
        resultArea.setEditable(false);

        HBox inputBox = new HBox(10, tartTypeComboBox, nameField, tartaField);
        inputBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20, inputBox, datePicker, bestallningButton, showBestallningsButton, resultArea);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setStyle("-fx-background-color: #E4D5D2");

        Label label = new Label("Välkommen till Wigells Bageri!");
        label.setFont(new Font("Tahoma", 20));
        layout.getChildren().add(0, label);

        return layout;
    }

    private void handleBestallning() {
        String name = nameField.getText().trim();
        String tartType = tartTypeComboBox.getValue();
        LocalDate bestallningsDatum = datePicker.getValue();
        String antalText = tartaField.getText().trim();

        if (name.isEmpty() || tartType == null || bestallningsDatum == null || antalText.isEmpty()) {
            resultArea.setText("Vänligen fyll i alla fält för att beställa.");
            return;
        }

        try {
            int antalTarta = Integer.parseInt(antalText);
            if (antalTarta <= 0) {
                resultArea.setText("Antal tårtor måste vara ett positivt heltal.");
                return;
            }

            Tarta tarta = createTarta(tartType);
            Customer kund = new Customer(name, antalTarta);
            int orderNummer = bestallnings.size() + 101010;
            double totalPrice = tarta.getPricePerOrder() * antalTarta;

            Bestallning bestallning = new Bestallning(orderNummer, kund, tarta, bestallningsDatum, antalTarta, totalPrice);
            bestallnings.add(bestallning);

            resultArea.setText("Beställning bekräftad!\n" +
                    "Beställnings-ID: " + orderNummer + "\n" +
                    "Antal tårtor: " + antalTarta + "\n" +
                    "Pris per tårta: " + tarta.getPricePerOrder() + " SEK\n" +
                    "Totalt pris: " + totalPrice + " SEK");

            clearInputFields();
        } catch (NumberFormatException e) {
            resultArea.setText("Antal tårtor måste vara ett heltal.");
        }
    }
    private Tarta createTarta(String tartType) {
        switch (tartType) {
            case "Prinsesstårta": return new Prinsesstarta("Prinsesstårta", 1200, "",0);
            case "Operatårta": return new Operatarta("Operatårta", 1200,"",0);
            case "Chokladtårta": return new Chokladtarta("Chokladtårta", 2000,"",0);
            default: throw new IllegalArgumentException("Ogiltig tårttyp: " + tartType);
        }
    }

    private void showAllBestallningar() {
        if (bestallnings.isEmpty()) {
            resultArea.setText("Inga beställningar finns ännu.");
            return;
        }

        StringBuilder result = new StringBuilder();
        bestallnings.forEach(bestallning -> result.append(bestallning).append("\n"));
        resultArea.setText(result.toString());
    }

    private void clearInputFields() {
        nameField.clear();
        tartTypeComboBox.getSelectionModel().clearSelection();
        datePicker.setValue(null);
        tartaField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
