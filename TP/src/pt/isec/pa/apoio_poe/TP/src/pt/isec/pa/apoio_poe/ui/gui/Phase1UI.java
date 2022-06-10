package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.layout.BorderPane;
import pt.isec.pa.apoio_poe.model.PhaseManager;

public class Phase1UI extends BorderPane {
    PhaseManager phaseManager;

    public Phase1UI(PhaseManager phaseManager) {
        this.phaseManager = phaseManager;

        createView();
        registerHandlers();
        update();
    }

    private void createView() {

    }

    private void registerHandlers() {

    }

    private void update() {

    }
}
