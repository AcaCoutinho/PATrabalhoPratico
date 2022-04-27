package pt.isec.pa.apoio_poe.ui.text;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Docente;
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
        int option = PAInput.chooseOption("Fase 1 - Configuracao:","Student", "Docente",
                                            "Proposta", "Fechar Configuração", "Proxima Fase");
        switch (option) {
            case 1 -> studendUI();
            case 2 -> docentUI();
            case 3 -> propostaUI();
            case 4 -> fsm.closeState();
            case 5 -> fsm.nextPhase();
        }
    }

    private void propostaUI() {
        int option = PAInput.chooseOption("Configuracao Proposta:", "Inserir proposta", "Consultar proposta",
                                            "Editar proposta", "Eliminar proposta");
        switch (option){
            case 1 ->insertUI("proposta");
            case 2 ->consultUI("proposta");
            case 3 ->editUI("proposta");
            case 4 ->removeUI("proposta");
        }
    }

    private void docentUI() {
        int option = PAInput.chooseOption("Configuracao Docente:", "Inserir docente", "Consultar docente",
                                            "Editar docente", "Eliminar docente");
        switch (option){
            case 1 ->insertUI("docente");
            case 2 ->consultUI("docente");
            case 3 ->editUI("docente");
            case 4 ->removeUI("docente");
        }
    }

    private void studendUI() {
        int option = PAInput.chooseOption("Configuracao Estudante:", "Inserir estudante", "Consultar estudante",
                                            "Editar estudante", "Eliminar estudante");
        switch (option){
            case 1 ->insertUI("student");
            case 2 ->consultUI("student");
            case 3 ->editUI("student");
            case 4 ->removeUI("student");
        }
    }

    public void phase2UI() {
        int option = PAInput.chooseOption("Fase 2 - Opções de Candidatura:","",
                                            "", "Fechar Fase", "Fase Anterior", "Proxima Fase");
        switch (option) {
            //case 1 -> ;
            //case 2 -> ;
            case 3 -> fsm.closeState();
            case 4 -> fsm.previousPhase();
            case 5 -> fsm.nextPhase();
        }
    }

    public void phase3UI() {
        int option = PAInput.chooseOption("Fase 3 - Atribuição de Propostas:","1 - Student",
                                            "2 - Docente", "Fechar Fase", "Fase Anterior", "Proxima Fase");
        switch (option) {
            //case 1 -> ;
            //case 2 -> ;
            case 3 -> fsm.closeState();
            case 4 -> fsm.previousPhase();
            case 5 -> fsm.nextPhase();
        }
    }

    public void phase4UI() {
        int option = PAInput.chooseOption("Fase 4 - Atribuição de Orientadores:","1 - Student",
                                            "2 - Docente", "3 - Proposta", "Fechar Fase", "Fase Anterior", "Proxima Fase");
        switch (option) {
            //case 1 -> ;
            //case 2 -> ;
            //case 3 -> ;
            case 4 -> fsm.closeState();
            case 5 -> fsm.previousPhase();
            case 6 -> fsm.nextPhase();
        }
    }

    public void phase5UI() {
        int option = PAInput.chooseOption("Fase 5 - Consulta:","Student",
                                            "Docente", "Sair da Aplicação");
        switch (option) {
            case 3 -> finish = true;
        }
    }

    private void insertUI(String tipo) {
        boolean termino = false;
        if(tipo.equals("proposta")) {
            do {


                int option = PAInput.chooseOption("Que tipo de proposta é?",
                                                   "Estágio", "Projeto");
                switch (option) {
                    case 1 -> {

                    }
                    case 2 -> {}
                }

                if(PAInput.chooseOption("Pretende adicionar outra proposta?", "Sim", "Não") == 1) {
                    termino = true;
                }
            }
            while(!termino);
        }
        else if(tipo.equals("docente")){
            do {
                String nome = PAInput.readString("Nome: ", false);
                String email = PAInput.readString("Email: ", true);


                if(PAInput.chooseOption("Pretende adicionar outra proposta?", "Sim", "Não") == 1) {
                    termino = true;
                }
                Docente aux = new Docente(email, nome);
                fsm.insert(aux);
            }
            while(!termino);
        }
        else if(tipo.equals("student")) {
            do {
                String nome = PAInput.readString("Nome: ", false);
                String siglaC = PAInput.readString("Sigla de curso: ", true);
                String siglaR = PAInput.readString("Sigla de ramo: ", true);
                double grade = PAInput.readNumber("Classificação do aluno: ");

                Aluno aux = new Aluno(nome, siglaC, siglaR, grade);
                fsm.insert(aux);

                if (PAInput.chooseOption("Pretende adicionar outro aluno?", " 1 - Sim", "2 - Não") == 1){
                    termino = true;
                }
            } while(!termino);
        }
    }

    private void consultUI(String tipo) {
        if(tipo.equals("proposta")) {

        }
        else if(tipo.equals("docente")){

        }
        else if(tipo.equals("student")) {

        }
    }

    private void editUI(String tipo) {
        if(tipo.equals("proposta")) {

        }
        else if(tipo.equals("docente")){

        }
        else if(tipo.equals("student")) {

        }
    }

    private void removeUI(String tipo) {
        if(tipo.equals("proposta")) {

        }
        else if(tipo.equals("docente")){

        }
        else if(tipo.equals("student")) {

        }
    }
}
