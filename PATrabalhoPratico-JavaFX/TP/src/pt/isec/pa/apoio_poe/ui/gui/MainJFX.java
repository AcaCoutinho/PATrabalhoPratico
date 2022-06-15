package pt.isec.pa.apoio_poe.ui.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.PhaseManager;


public class MainJFX extends Application {
    PhaseManager phaseManager;

    @Override
    public void init() throws Exception{
        super.init();
        phaseManager = new PhaseManager();
    }

    @Override
    public void start(Stage stage) throws Exception {
        RootPane root = new RootPane(phaseManager);
        Scene scene = new Scene(root, 700, 400);
        stage.setScene(scene);
        stage.setTitle("PATrabalhoPratico");
        stage.setMinWidth(700);
        stage.setMinHeight(400);
        stage.show();
    }
}
