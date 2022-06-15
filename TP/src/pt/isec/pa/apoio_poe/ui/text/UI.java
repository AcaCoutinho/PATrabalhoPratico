package pt.isec.pa.apoio_poe.ui.text;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Estagio;
import pt.isec.pa.apoio_poe.model.data.Projeto;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;
import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.utils.*;

import java.io.IOException;
import java.util.ArrayList;

public class UI {
    private PhaseContext fsm;
    private boolean finish;

    public UI (PhaseContext fsm){
        this.fsm = fsm;
        finish = false;
    }

    public void start() throws IOException {
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
                fsm.insertPropostaFile(fileName);
            }
            case 2 -> {
                String al = PAInput.readString("ID da proposta a consultar: ", true);
                System.out.println(fsm.consultProposta(al));
            }
            case 3 -> {
                String al = PAInput.readString("ID da proposta a editar: ", true);
                fsm.editProposta(al);
            }
            case 4 -> {
                String al = PAInput.readString("ID da proposta a remover: ", true);
                fsm.removeProposta(al);
            }
        }
    }

    private void docentUI() {
        int option = PAInput.chooseOption("Configuracao Docente:", "Inserir docente", "Consultar docente",
                                            "Editar docente", "Eliminar docente");
        switch (option){
            case 1 -> {
                String fileName = PAInput.readString("Nome do ficheiro CSV com dados de docentes: ", true);
                fsm.insertDocenteFile(fileName);
            }
            case 2 -> {
                String al = PAInput.readString("Email do docente a consultar: ", true);
                System.out.println(fsm.consultDocente(al));
            }
            case 3 -> {
                String al = PAInput.readString("Email do docente a editar: ", true);
                fsm.editDocente(al);
            }
            case 4 -> {
                String al = PAInput.readString("Email do docente a remover: ", true);
                fsm.removeDocente(al);
            }
        }
    }

    private void studendUI() {
        int option = PAInput.chooseOption("Configuracao Estudante:", "Inserir estudante", "Consultar estudante",
                                            "Editar estudante", "Eliminar estudante");
        switch (option){
            case 1 -> {
                String fileName = PAInput.readString("Nome do ficheiro CSV com dados de alunos: ", true);
                fsm.insertAlunoFile(fileName);
            }
            case 2 -> {
                long n_aluno = (long) PAInput.readNumber("Número de aluno a consultar: ");
                System.out.println(fsm.consultAluno(n_aluno));
            }
            case 3 -> {
                long n_aluno = (long) PAInput.readNumber("Número de aluno a editar: ");
                fsm.editAluno(n_aluno);
            }
            case 4 -> {
                long n_aluno = (long) PAInput.readNumber("Número de aluno a remover: ");
                fsm.removeAluno(n_aluno);
            }
        }
    }

    public void phase2UI() {
        int option = PAInput.chooseOption("Fase 2 - Opções de Candidatura:","Inserir",
                                            "Consultar", "Lista de Alunos", "Lista de Propostas", "Fechar Fase", "Fase Anterior", "Proxima Fase");
        switch (option) {
            case 1 -> {
                String fileName = PAInput.readString("Nome do ficheiro CSV com dados de candidatura: ", true);
                fsm.insertCandidaturaFile(fileName);
            }
            case 2 -> {
                long n_aluno = (long) PAInput.readNumber("Numero do aluno da candidatura:");
                fsm.consultCandidatura(n_aluno);
            }
            case 3 -> {
                int option1 = PAInput.chooseOption("Lista de Alunos:", "Autoproposta", "Candidatura Registada",
                                                    "Sem Candidatura Registada");
                switch(option1){
                    case 1 -> System.out.println(fsm.listaAluno("autoproposta"));
                    case 2 -> System.out.println(fsm.listaAluno("candidatura"));
                    case 3 -> System.out.println(fsm.listaAluno("no_candidatura"));
                }
            }
            case 4 -> {
                int option1 = PAInput.chooseOption("Lista de Propostas:", "Autoproposta", "Proposta de Docentes",
                                                    "Propostas com Candidaturas", "Propostas sem Candidaturas");
                switch(option1){
                    case 1 -> System.out.println(fsm.listaProposta("autoproposta"));
                    case 2 -> System.out.println(fsm.listaProposta("docente"));
                    case 3 -> System.out.println(fsm.listaProposta("candidatura"));
                    case 4 -> System.out.println(fsm.listaProposta("no_candidatura"));
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
                                            "Lista de propostas", "Exportar", "Fechar Fase", "Fase Anterior", "Proxima Fase");
        switch (option) {
            case 1 -> fsm.assignment(0);
            case 2 -> fsm.assignment(1);
            case 5 -> {
                int option1 = PAInput.chooseOption("Lista de Alunos:", "Têm autoproposta associada", "Candidatura registada",
                                                    "Proposta Atribuida", "Não têm proposta atribuida");
                switch (option1){
                    case 1 -> System.out.println(fsm.listaAluno("autoproposta"));
                    case 2 -> System.out.println(fsm.listaAluno("candidatura"));
                    case 3 -> System.out.println(fsm.listaAluno("atribuida"));
                    case 4 -> System.out.println(fsm.listaAluno("no"));
                }
            }
            case 6 -> {
                int option1 = PAInput.chooseOption("Lista de Propostas:", "Autoproposta", "Proposta de Docentes",
                                                    "Propostas Disponiveis", "Propostas Atribuidas");
                switch(option1){
                    case 1 -> System.out.println(fsm.listaProposta("autoproposta"));
                    case 2 -> System.out.println(fsm.listaProposta("docente"));
                    case 3 -> System.out.println(fsm.listaProposta("disponiveis"));
                    case 4 -> System.out.println(fsm.listaProposta("atribuidas"));
                }
            }
            case 7 -> {
                String fileName = PAInput.readString("Nome do ficheiro CSV com dados de docentes: ", true);
                fsm.export(fileName);
            }
            case 8 -> fsm.closeState();
            case 9 -> fsm.previousPhase();
            case 10 -> fsm.nextPhase();
        }
    }

    public void phase4UI() {
        int option = PAInput.chooseOption("Fase 4 - Atribuição de Orientadores:","Automática (associação)",
                                            "Lista de Alunos", "Lista de Docentes", "Exportar", "Fechar Fase", "Fase Anterior", "Proxima Fase");
        switch (option) {
            case 1 -> fsm.assignment(0);
            case 2 -> {
                int option1 = PAInput.chooseOption("Lista de Alunos:", "Proposta Atribuida com Orientador",
                                                    "Proposta Atribuida sem Orientador");
                switch(option1){
                    case 1 -> System.out.println(fsm.listaAluno("associado"));
                    case 2 -> System.out.println(fsm.listaAluno("no_associado"));
                }
            }
            case 3 -> System.out.println(fsm.listaDocente(""));
            case 4 -> {
                String fileName = PAInput.readString("Nome do ficheiro CSV com dados de docentes: ", true);
                fsm.export(fileName);
            }
            case 5 -> fsm.closeState();
            case 6 -> fsm.previousPhase();
            case 7 -> fsm.nextPhase();
        }
    }

    public void phase5UI() {
        int option = PAInput.chooseOption("Fase 5 - Consulta:","Alunos",
                                            "Docentes", "Propostas", "Exportar", "Sair da Aplicação");
        switch (option) {
            case 1 -> {
                int option1 = PAInput.chooseOption("Lista de Propostas:", "Autoproposta", "Proposta de Docentes",
                        "Propostas Disponiveis", "Propostas Atribuidas");
                switch(option1){
                    case 1 -> System.out.println(fsm.listaAluno("atribuidas"));
                    case 2 -> System.out.println(fsm.listaAluno("candidatura"));
                }
            }
            case 2 -> System.out.println(fsm.listaDocente(""));
            case 3 -> {
                int option1 = PAInput.chooseOption("Lista de Propostas:", "Autoproposta", "Proposta de Docentes",
                        "Propostas Disponiveis", "Propostas Atribuidas");
                switch(option1){
                    case 1 -> System.out.println(fsm.listaProposta("disponiveis"));
                    case 2 -> System.out.println(fsm.listaProposta("atribuidas"));
                }
            }
            case 4 -> {
                String fileName = PAInput.readString("Nome do ficheiro CSV com dados de docentes: ", true);
                fsm.export(fileName);
            }
            case 5 -> finish = true;
        }
    }
}
