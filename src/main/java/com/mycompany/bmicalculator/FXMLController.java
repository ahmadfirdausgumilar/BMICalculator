package com.mycompany.bmicalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML private TextField txtBerat;
    @FXML private TextField txtTinggi;
    @FXML private Button btnHitung;
    @FXML private Label lblHasil;
    @FXML private Label lblKategori;

    @FXML
    private void hitungBMI(ActionEvent event) {
        try {
            double berat = Double.parseDouble(txtBerat.getText().trim());
            double tinggiCm = Double.parseDouble(txtTinggi.getText().trim());

            if (berat <= 0 || tinggiCm <= 0) {
                tampilkanError("Berat dan tinggi harus lebih dari 0.");
                return;
            }

            double tinggiM = tinggiCm / 100;
            double bmi = berat / (tinggiM * tinggiM);

            String kategori;
            if (bmi < 18.5) {
                kategori = "Kurus";
            } else if (bmi < 25) {
                kategori = "Normal";
            } else if (bmi < 30) {
                kategori = "Kelebihan berat badan";
            } else {
                kategori = "Obesitas";
            }

            lblHasil.setText(String.format("BMI: %.1f", bmi));
            lblKategori.setText("Kategori: " + kategori);

        } catch (NumberFormatException e) {
            tampilkanError("Masukkan angka yang valid (gunakan titik untuk desimal).");
        }
    }

    private void tampilkanError(String pesan) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input tidak valid");
        alert.setContentText(pesan);
        alert.show();
    }
}