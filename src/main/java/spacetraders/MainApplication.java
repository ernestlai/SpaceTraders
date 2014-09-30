/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import spacetraders.model.*;

/**
 * The main application class. This class is run when the user opens the application.
 * @author Team Astrosnails
 */
public class MainApplication extends Application {
    
    private Stage mainStage;
    private Player player;
    private Universe universe;
    
    /**
    * Starts the application.
    * @param stage The JavaFX stage of the application
    */
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        goToWelcomeScreen();
        mainStage.show();
    }
    
    /**
    *  Opens in the welcome screen
    */
    public void goToWelcomeScreen() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("WelcomeScreen.fxml"));
        Parent root = myLoader.load();
        
        WelcomeScreenController controller = (WelcomeScreenController) myLoader.getController();
        controller.setMainApplication(this);
        
        Scene scene = new Scene(root);
        
        mainStage.setScene(scene);
    }
    
    /**
    *  Opens the new game dialog.
    */
    public void goToNewGameDialog() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Dialog.fxml"));
        Pane dialogPane = myLoader.load();

        NewGameDialogController controller = (NewGameDialogController) myLoader.getController();
        controller.setMainApplication(this);

        Scene scene = new Scene(dialogPane);
        mainStage.setScene(scene);
    }
    
    /**
    *  Initializes the game models and opens the game dashboard.
    */
    public void startNewGame(Player player) throws IOException {
        this.player = player;
        universe = Universe.getInstance();
        
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Parent root = myLoader.load();

        DashboardController controller = (DashboardController) myLoader.getController();
        controller.setMainApplication(this);

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
    }
    
    public void goToDashboard() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Pane dialogPane = myLoader.load();

        DashboardController controller = (DashboardController) myLoader.getController();
        controller.setMainApplication(this);

        Scene scene = new Scene(dialogPane);
        mainStage.setScene(scene);
    }
    
    public void goToMarketPlace() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("MarketPlace.fxml"));
        Pane dialogPane = myLoader.load();

        MarketPlaceController controller = (MarketPlaceController) myLoader.getController();
        controller.setMainApplication(this);

        Scene scene = new Scene(dialogPane);
        mainStage.setScene(scene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
    *  Get the Player
    *  @return The player
    */
    public Player getPlayer() {
        return player;
    }
    
}
