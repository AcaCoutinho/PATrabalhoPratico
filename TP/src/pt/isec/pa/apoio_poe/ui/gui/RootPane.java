package pt.isec.pa.apoio_poe.ui.gui;


import javafx.scene.layout.*;
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
        phaseManager.addPropertyChangeListener(evt -> { update(); });
        StackPane stackPane = new StackPane(
                new Phase1UI(phaseManager),
                new Phase2UI(phaseManager)
        );

        this.setCenter(stackPane);
    }

    private void registerHandlers() {

    }

    private void update(){

    }
}
