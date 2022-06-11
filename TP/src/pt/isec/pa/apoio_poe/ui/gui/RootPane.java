package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.layout.BorderPane;
import pt.isec.pa.apoio_poe.model.PhaseManager;

public class RootPane extends BorderPane {
    PhaseManager phaseManager;

    public RootPane(PhaseManager phaseManager) {
        this.phaseManager = phaseManager;

        createView();
        registerHandlers();
        update();
    }

    private void createView(){

    }

    private void registerHandlers() {

    }

    private void update(){

    }
}
