package ch.makery.address.view;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import ch.makery.address.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 *
 *
 */
public class RootLayoutController {

    private static final Logger logger = Logger.getLogger(RootLayoutController.class.getName());

    // Reference to the main application
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Creates an empty address book.
     */
    @FXML
    private void handleNew() {
        logger.log(Level.INFO, "method called");
        mainApp.getPersonData().clear();
        mainApp.setPersonFilePath(null);
        logger.log(Level.INFO, "method end");
    }

    /**
     * Opens a FileChooser to let the user select an address book to load.
     */
    @FXML
    private void handleOpen() {
        logger.log(Level.INFO, "method called");
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadPersonDataFromFile(file);
        }
        logger.log(Level.INFO, "method end");
    }

    /**
     * Saves the file to the person file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     */
    @FXML
    private void handleSave() {
        logger.log(Level.INFO, "method called");
        File personFile = mainApp.getPersonFilePath();
        if (personFile != null) {
            mainApp.savePersonDataToFile(personFile);
        } else {
            handleSaveAs();
        }
        logger.log(Level.INFO, "method end");
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
        logger.log(Level.INFO, "method called");
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.savePersonDataToFile(file);
        }
        logger.log(Level.INFO, "method end");
    }

    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
        logger.log(Level.INFO, "method called");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("AddressApp");
        alert.setHeaderText("About");
        alert.setContentText("Author: Faisal Fawzi Jarkass\nWebsite: http://www.faisaljarkass.com");
        alert.showAndWait();
        logger.log(Level.INFO, "method end");
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        logger.log(Level.INFO, "method called");
        logger.log(Level.INFO, "Shuting down...");
        System.exit(0);
    }

    /**
     * Opens the birthday statistics.
     */
    @FXML
    private void handleShowBirthdayStatistics() {
        logger.log(Level.INFO, "method called");
        mainApp.showBirthdayStatistics();
        logger.log(Level.INFO, "method end");
    }

    /**
     * A test method from the RootLayout.fxml
     * @param actionEvent
     */
    @FXML
    public void testMethod(ActionEvent actionEvent) {
        logger.log(Level.INFO, "actionEvent:\n" + actionEvent.toString());
    }
}