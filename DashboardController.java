package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DashboardController {
    @FXML private Button logoutButton;

    @FXML
    private void handleLogout() {
        System.out.println("Logging out...");
        // Implement navigation back to Login Screen
    }
}
