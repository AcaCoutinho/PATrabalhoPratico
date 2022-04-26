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
            case 1 -> studendUI();
            case 2 -> docentUI();
            case 3 -> propostaUI();
        }
    }

    private void propostaUI() {
        int option = PAInput.chooseOption("Configuracao Proposta:", "1 - Inserir proposta", "2 - Consultar proposta",
                "3 - Editar proposta", "4 - Eliminar proposta");
        switch (option){
            case 1 ->fsm.insert(2);
            case 2 ->fsm.consult(2);
            case 3 ->fsm.edit(2);
            case 4 ->fsm.remove(2);
        }
    }

    private void docentUI() {
        int option = PAInput.chooseOption("Configuracao Docente:", "1 - Inserir docente", "2 - Consultar docente",
                "3 - Editar docente", "4 - Eliminar docente");
        switch (option){
            case 1 ->fsm.insert(1);
            case 2 ->fsm.consult(1);
            case 3 ->fsm.edit(1);
            case 4 ->fsm.remove(1);
        }
    }

    private void studendUI() {
        int option = PAInput.chooseOption("Configuracao Estudante:", "1 - Inserir estudante", "2 - Consultar estudante",
                "3 - Editar estudante", "4 - Eliminar estudante");
        switch (option){
            case 1 ->fsm.insert(0);
            case 2 ->fsm.consult(0);
            case 3 ->fsm.edit(0);
            case 4 ->fsm.remove(0);
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
