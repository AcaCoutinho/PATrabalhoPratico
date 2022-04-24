package pt.isec.pa.apoio_poe.ui.text;

import pt.isec.pa.apoio_poe.model.fsm.PhaseState;
import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.utils.*;

public class UI {
    private PhaseContext fsm;
    private boolean finish;

    public UI (PhaseContext fsm){
        this.fsm = fsm;
        finish = false;
    }

    public void start() {
        while (!finish){
            switch (fsm.getState()){
               case PHASE_1 -> phase1UI();
               case PHASE_2 -> phase2UI();
               case PHASE_3 -> phase3UI();
               case PHASE_4 -> phase4UI();
               case PHASE_5 -> phase5UI();
            }
        }
    }

    public void phase1UI() {
        int option = PAInput.chooseOption("Fase 1 - Configuracao:","1 - Student", "2 - Docente", "3 - Proposta");
        switch (option) {

        }
    }

    public void phase2UI() {
        int option = PAInput.chooseOption("Fase 1 - Configuracao:","1 - Student", "2 - Docente", "3 - Proposta");
        switch (option) {

        }
    }

    public void phase3UI() {
        int option = PAInput.chooseOption("Fase 1 - Configuracao:","1 - Student", "2 - Docente", "3 - Proposta");
        switch (option) {

        }
    }

    public void phase4UI() {
        int option = PAInput.chooseOption("Fase 1 - Configuracao:","1 - Student", "2 - Docente", "3 - Proposta");
        switch (option) {

        }
    }

    public void phase5UI() {
        int option = PAInput.chooseOption("Fase 1 - Configuracao:","1 - Student", "2 - Docente", "3 - Proposta");
        switch (option) {

        }
    }
}
