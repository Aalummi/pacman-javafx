package projectpacman;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import projectpacman.Initializer.GameStarter;


public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        //  instanciates the game with the settings from GameSettings.Java //
        GameStarter initializer = new GameStarter();
        initializer.initialize(stage);
        //                                                                 //

    }

    public static void main(String[] args) throws IOException{
        launch(args);
    }
} 
