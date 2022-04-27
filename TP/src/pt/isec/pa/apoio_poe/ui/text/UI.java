package pt.isec.pa.apoio_poe.ui.text;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Estagio;
import pt.isec.pa.apoio_poe.model.data.Projeto;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;
import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.utils.*;

import java.util.ArrayList;

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
                        String titulo = PAInput.readString("Titulo", false);
                        String ad = PAInput.readString("Área de destino", true);
                        String entityId = PAInput.readString("Identificação da entidade", true);
                        if(PAInput.chooseOption("O estagio está atribuido a um aluno?", "Sim", "Não") == 1){
                            long n_alunoAt = (long) PAInput.readNumber("Numero de aluno");
                            Estagio aux = new Estagio(titulo, ad, entityId, n_alunoAt);
                            fsm.insert(aux);
                        }else{
                            Estagio aux = new Estagio(titulo, ad, entityId);
                            fsm.insert(aux);
                        }
                    }
                    case 2 -> {
                        String titulo = PAInput.readString("Titulo", false);
                        String rd = PAInput.readString("Ramo de destino", true);
                        String email = PAInput.readString("Email de docente proponente", true);
                        String nome = PAInput.readString("Nome de docente proponente", false);
                        Docente proponente = new Docente(email, nome);
                        if(PAInput.chooseOption("O projeto está atribuido a um aluno?", "Sim", "Não") == 1){
                            long n_alunoAt = (long) PAInput.readNumber("Numero de aluno");
                            Projeto aux = new Projeto(titulo, rd, proponente, n_alunoAt);
                            fsm.insert(aux);
                        }else{
                            Projeto aux = new Projeto(titulo, rd, proponente);
                            fsm.insert(aux);
                        }
                    }
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

                Docente aux = new Docente(email, nome);
                fsm.insert(aux);

                if(PAInput.chooseOption("Pretende adicionar outra proposta?", "Sim", "Não") == 2) {
                    termino = true;
                }
            }
            while(!termino);
        }
        else if(tipo.equals("student")) {
            do {
                String nome = PAInput.readString("Nome: ", false);
                String email = PAInput.readString("Email: ", true);
                long n_aluno = (long) PAInput.readNumber("Número de aluno: ");
                String siglaC = PAInput.readString("Sigla de curso: ", true);
                String siglaR = PAInput.readString("Sigla de ramo: ", true);
                double grade = PAInput.readNumber("Classificação do aluno: ");

                Aluno aux = new Aluno(nome, siglaC, siglaR, grade, n_aluno, email);
                fsm.insert(aux);

                if (PAInput.chooseOption("Pretende adicionar outro aluno?", " 1 - Sim", "2 - Não") == 2){
                    termino = true;
                }
            } while(!termino);
        }
    }

    private void consultUI(String tipo) {
        if(tipo.equals("proposta")) {
            ArrayList<String> al = new ArrayList<>();
            al.add("proposta");al.add(PAInput.readString("Código de identificação da proposta a consultar", true));
            System.out.println(fsm.consult(al));
        }
        else if(tipo.equals("docente")){
            ArrayList<String> al = new ArrayList<>();
            al.add("docente");al.add(PAInput.readString("Email de docente a consultar", true));
            System.out.println(fsm.consult(al));
        }
        else if(tipo.equals("student")) {
            long n_aluno = (long) PAInput.readNumber("Número de aluno a consultar: ");
            String n_alunoS = String.valueOf(n_aluno);
            ArrayList<String> al = new ArrayList<>();
            al.add("student");al.add(n_alunoS);
            System.out.println(fsm.consult(al));
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
