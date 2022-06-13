package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.layout.BorderPane;
import pt.isec.pa.apoio_poe.model.PhaseManager;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;

public class Phase2UI extends BorderPane {
    PhaseManager phaseManager;

    public Phase2UI(PhaseManager phaseManager){
        this.phaseManager = phaseManager;

        createViews();
        registerHandlers();
        update();
    }

    public void createViews() {

    }

    public void registerHandlers() {

    }

    public void update(){
        if(phaseManager.getPhaseState() != PhaseState.PHASE_2){
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
    }
}
