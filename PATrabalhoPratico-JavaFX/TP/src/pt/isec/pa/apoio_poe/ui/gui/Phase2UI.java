package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import pt.isec.pa.apoio_poe.model.PhaseManager;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;

public class Phase2UI extends BorderPane {
    PhaseManager phaseManager;

    Button test;

    public Phase2UI(PhaseManager phaseManager){
        this.phaseManager = phaseManager;

        createViews();
        registerHandlers();
        update();
    }

    public void createViews() {
        test = new Button("Teste");
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
