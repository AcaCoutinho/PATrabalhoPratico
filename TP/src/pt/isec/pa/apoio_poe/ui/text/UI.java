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
            case 1 -> {
                String fileName = PAInput.readString("Nome do ficheiro CSV com dados de propostas: ", true);
                fsm.insert("proposta", fileName);
            }
            case 2 -> {
                ArrayList<String> al = new ArrayList<>();
                al.add("proposta");
                al.add(PAInput.readString("ID da proposta a consultar: ", true));
                System.out.println(fsm.consult(al));
            }
            case 3 -> fsm.edit();
            case 4 -> fsm.remove();
        }
    }

    private void docentUI() {
        int option = PAInput.chooseOption("Configuracao Docente:", "Inserir docente", "Consultar docente",
                                            "Editar docente", "Eliminar docente");
        switch (option){
            case 1 -> {
                String fileName = PAInput.readString("Nome do ficheiro CSV com dados de docentes: ", true);
                fsm.insert("docente", fileName);
            }
            case 2 -> {
                ArrayList<String> al = new ArrayList<>();
                al.add("docente");
                al.add(PAInput.readString("Email do docente a consultar: ", true));
                System.out.println(fsm.consult(al));
            }
            case 3 -> fsm.edit();
            case 4 -> fsm.remove();
        }
    }

    private void studendUI() {
        int option = PAInput.chooseOption("Configuracao Estudante:", "Inserir estudante", "Consultar estudante",
                                            "Editar estudante", "Eliminar estudante");
        switch (option){
            case 1 -> {
                String fileName = PAInput.readString("Nome do ficheiro CSV com dados de alunos: ", true);
                fsm.insert("student", fileName);
            }
            case 2 -> {
                long n_aluno = (long) PAInput.readNumber("Número de aluno a consultar: ");
                String n_alunoS = String.valueOf(n_aluno);
                ArrayList<String> al = new ArrayList<>();
                al.add("student");
                al.add(n_alunoS);
                System.out.println(fsm.consult(al));
            }
            case 3 -> fsm.edit();
            case 4 -> fsm.remove();
        }
    }

    public void phase2UI() {
        int option = PAInput.chooseOption("Fase 2 - Opções de Candidatura:","Inserir",
                                            "Consultar", "Lista de Alunos", "Lista de Propostas", "Fechar Fase", "Fase Anterior", "Proxima Fase");
        switch (option) {
            case 1 -> {
                String fileName = PAInput.readString("Nome do ficheiro CSV com dados de candidatura: ", true);
                fsm.insert("candidatura", fileName);
            }
            case 2 -> {
                long n_aluno = (long) PAInput.readNumber("Numero do aluno da candidatura:");
                String n_alunoS = String.valueOf(n_aluno);
                ArrayList<String> al = new ArrayList<>();
                al.add(n_alunoS);
                fsm.consult(al);
            }
            case 3 -> {
                ArrayList<String> al = new ArrayList<>();
                al.add("student");
                int option1 = PAInput.chooseOption("Lista de Alunos:", "Autoproposta", "Candidatura Registada",
                                                    "Sem Candidatura Registada");
                switch(option1){
                    case 1 -> {
                        al.add("autoproposta");
                        System.out.println(fsm.lista(al));
                    }
                    case 2 -> {
                        al.add("candidatura");
                        System.out.println(fsm.lista(al));
                    }
                    case 3 -> {
                        al.add("no_candidatura");
                        System.out.println(fsm.lista(al));
                    }
                }
            }
            case 4 -> {
                ArrayList<String> al = new ArrayList<>();
                al.add("proposta");
                int option1 = PAInput.chooseOption("Lista de Propostas:", "Autoproposta", "Proposta de Docentes",
                                                    "Propostas com Candidaturas", "Propostas sem Candidaturas");
                switch(option1){
                    case 1 -> {
                        al.add("autoproposta");
                        System.out.println(fsm.lista(al));
                    }
                    case 2 -> {
                        al.add("docente");
                        System.out.println(fsm.lista(al));
                    }
                    case 3 -> {
                        al.add("candidatura");
                        System.out.println(fsm.lista(al));
                    }
                    case 4 -> {
                        al.add("no_candidatura");
                        System.out.println(fsm.lista(al));
                    }
                }
            }
            case 5 -> fsm.closeState();
            case 6 -> fsm.previousPhase();
            case 7 -> fsm.nextPhase();
        }
    }

    public void phase3UI() {
        int option = PAInput.chooseOption("Fase 3 - Atribuição de Propostas:","Automática (associação)",
                                            "Automática (sem atribuições)", "Manual", "Remover", "Lista de alunos",
                                            "Lista de propostas", "Fechar Fase", "Fase Anterior", "Proxima Fase");
        switch (option) {
            case 1 -> fsm.assignment(0);
            case 2 -> fsm.assignment(1);
            case 5 -> {
                ArrayList<String> al = new ArrayList<>();
                al.add("student");
                int option1 = PAInput.chooseOption("Lista de Alunos:", "Têm autoproposta associada", "Candidatura registada",
                                                    "Proposta Atribuida", "Não têm proposta atribuida");
                switch (option1){
                    case 1 -> {
                        al.add("autoproposta");
                        System.out.println(fsm.lista(al));
                    }
                    case 2 -> {
                        al.add("candidatura");
                        System.out.println(fsm.lista(al));
                    }
                    case 3 -> {
                        al.add("atribuida");
                        System.out.println(fsm.lista(al));
                    }
                    case 4 -> {
                        al.add("no");
                        System.out.println(fsm.lista(al));
                    }
                }
            }
            case 6 -> {
                ArrayList<String> al = new ArrayList<>();
                al.add("proposta");
                int option1 = PAInput.chooseOption("Lista de Propostas:", "Autoproposta", "Proposta de Docentes",
                                                    "Propostas Disponiveis", "Propostas Atribuidas");
                switch(option1){
                    case 1 -> {
                        al.add("autoproposta");
                        System.out.println(fsm.lista(al));
                    }
                    case 2 -> {
                        al.add("docente");
                        System.out.println(fsm.lista(al));
                    }
                    case 3 -> {
                        al.add("disponiveis");
                        System.out.println(fsm.lista(al));
                    }
                    case 4 -> {
                        al.add("atribuidas");
                        System.out.println(fsm.lista(al));
                    }
                }
            }
            case 7 -> fsm.closeState();
            case 8 -> fsm.previousPhase();
            case 9 -> fsm.nextPhase();
        }
    }

    public void phase4UI() {
        int option = PAInput.chooseOption("Fase 4 - Atribuição de Orientadores:","Automática (associação)",
                                            "Lista de Alunos", "Lista de Docentes", "Fechar Fase", "Fase Anterior", "Proxima Fase");
        switch (option) {
            case 1 -> fsm.assignment(0);
            case 2 -> {
                ArrayList<String> al = new ArrayList<>();
                al.add("student");
                int option1 = PAInput.chooseOption("Lista de Alunos:", "Proposta Atribuida com Orientador",
                                                    "Proposta Atribuida sem Orientador");
                switch(option1){
                    case 1 -> {
                        al.add("associado");
                        System.out.println(fsm.lista(al));
                    }
                    case 2 -> {
                        al.add("no_associado");
                        System.out.println(fsm.lista(al));
                    }
                }
            }
            case 3 -> {
                ArrayList<String> al = new ArrayList<>();
                al.add("docente");
                System.out.println(fsm.lista(al));
            }
            case 4 -> fsm.closeState();
            case 5 -> fsm.previousPhase();
            case 6 -> fsm.nextPhase();
        }
    }

    public void phase5UI() {
        int option = PAInput.chooseOption("Fase 5 - Consulta:","Alunos",
                                            "Docentes", "Propostas", "Sair da Aplicação");
        switch (option) {
            case 1 -> {
                ArrayList<String> al = new ArrayList<>();
                al.add("student");
                int option1 = PAInput.chooseOption("Lista de Propostas:", "Autoproposta", "Proposta de Docentes",
                        "Propostas Disponiveis", "Propostas Atribuidas");
                switch(option1){
                    case 1 -> {
                        al.add("atribuidas");
                        fsm.lista(al);
                    }
                    case 2 -> {
                        al.add("candidatura");
                        fsm.lista(al);
                    }
                }
            }
            case 2 -> {
                ArrayList<String> al = new ArrayList<>();
                al.add("docente");
                System.out.println(fsm.lista(al));
            }
            case 3 -> {
                ArrayList<String> al = new ArrayList<>();
                al.add("proposta");
                int option1 = PAInput.chooseOption("Lista de Propostas:", "Autoproposta", "Proposta de Docentes",
                        "Propostas Disponiveis", "Propostas Atribuidas");
                switch(option1){
                    case 1 -> {
                        al.add("disponiveis");
                        fsm.lista(al);
                    }
                    case 2 -> {
                        al.add("atribuidas");
                        fsm.lista(al);
                    }
                }
            }
            case 4 -> finish = true;
        }
    }
}
