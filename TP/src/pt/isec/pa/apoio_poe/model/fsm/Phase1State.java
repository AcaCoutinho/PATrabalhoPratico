package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.utils.PAInput;

public class Phase1State extends PhaseStateAdapter{
    protected Phase1State(Phase phase, PhaseContext context) {
        super(phase, context);
    }

    @Override
    public void insert(int i){
        boolean finish = false;
        if(i == 0){
            do{
                String nome = PAInput.readString("Nome: ", false);
                String siglaC = PAInput.readString("Sigla de curso: ", true);
                String siglaR = PAInput.readString("Sigla de ramo: ", true);
                double grade = PAInput.readNumber("Classificação do aluno: ");
                phase.adicionaAluno(new Aluno(nome, siglaC, siglaR, grade));
                if(PAInput.chooseOption("Pretende adicionar outro aluno?", "Sim", "Não") == 1){
                    continue;
                }else{
                    finish = true;
                }
            }while(!finish);
        }else if(i == 1){
            do{
                String nome = PAInput.readString("Nome: ", false);
                String email = PAInput.readString("Email: ", true);
                phase.adicionaDocente(new Docente(email, nome));
                if(PAInput.chooseOption("Pretende adicionar outro docente?", "Sim", "Não") == 1){
                    continue;
                }else{
                    finish = true;
                }
            }while(!finish);
        }else{
            do{
                int option = PAInput.chooseOption("TIPO", "Estágio", "Projeto", "Autoproposto");
                switch(option){
                    case 1 ->{
                        String titulo = PAInput.readString("Titulo", false);
                        String ad = PAInput.readString("Área de destino", true);
                        String entityId = PAInput.readString("Identificação da entidade", true);
                        if(PAInput.chooseOption("O estagio está atribuido a um aluno?", "Sim", "Não") == 1){
                            long n_alunoAt = (long) PAInput.readNumber("Numero de aluno");
                            while(phase.procuraAluno(n_alunoAt) == null){
                                n_alunoAt = (long) PAInput.readNumber("Aluno não encontrado, verifique o numero");
                            }
                            phase.adicionaProposta(new Estagio(titulo, ad, entityId, n_alunoAt));
                            break;
                        }
                        phase.adicionaProposta(new Estagio(titulo, ad, entityId));
                    }
                    case 2 ->{
                        String titulo = PAInput.readString("Titulo", false);
                        String rd = PAInput.readString("Ramo de destino", true);
                        String email = PAInput.readString("Email de docente proponente", true);
                        while(phase.procuraDocente(email) == null){
                            email = PAInput.readString("Docente não encontrado, verifique o email introduzido", true);
                        }
                        Docente proponente = phase.procuraDocente(email);
                        if(PAInput.chooseOption("O projeto está atribuido a um aluno?", "Sim", "Não") == 1){
                            long n_alunoAt = (long) PAInput.readNumber("Numero de aluno");
                            while(phase.procuraAluno(n_alunoAt) == null){
                                n_alunoAt = (long) PAInput.readNumber("Aluno não encontrado, verifique o numero");
                            }
                            phase.adicionaProposta(new Projeto(titulo, rd, proponente, n_alunoAt));
                            break;
                        }
                        phase.adicionaProposta(new Projeto(titulo, rd, proponente));
                    }
                    case 3 ->{
                        String titulo = PAInput.readString("Titulo", false);
                        long n_aluno = (long) PAInput.readNumber("Número de aluno proponente");
                        while(phase.procuraAluno(n_aluno) == null){
                            n_aluno = (long) PAInput.readNumber("Aluno não encontrado,verifique o número");
                        }
                        phase.adicionaProposta(new Autoproposto(titulo, n_aluno));
                    }
                }
                if(PAInput.chooseOption("Pretende adicionar outra proposta?", "Sim", "Não") == 1){
                    continue;
                }else{
                    finish = true;
                }
            }while(!finish);
        }
    }

    @Override
    public void consult(int i){
        boolean finish = false;
        if(i == 0){
            do{
                long n_aluno = (long) PAInput.readNumber("Numero de aluno a consultar");
                while(phase.procuraAluno(n_aluno) == null){
                    n_aluno = (long) PAInput.readNumber("Aluno não encontrado, verifique o numero");
                }
                System.out.println(phase.procuraAluno(n_aluno).toString());
                if(PAInput.chooseOption("Pretende procurar outro aluno?", "Sim", "Não") == 1){
                    continue;
                }else{
                    finish = true;
                }
            }while(!finish);
        }else if(i == 1){
            do{
                String email = PAInput.readString("Email de docente a consultar", true);
                while(phase.procuraDocente(email) == null){
                    email = PAInput.readString("Docente não encontrado, verifique o email", true);
                }
                System.out.println(phase.procuraDocente(email).toString());
                if(PAInput.chooseOption("Pretende procurar outro docente?", "Sim", "Não") == 1){
                    continue;
                }else{
                    finish = true;
                }
            }while(!finish);
        }else{
            do{
                String ca = PAInput.readString("Codigo de identificação de proposta a consultar", true);
                while(phase.procuraProposta(ca) == null){
                    ca = PAInput.readString("Proposta não encontrado, verifique o email", true);
                }
                System.out.println(phase.procuraProposta(ca).toString());
                if(PAInput.chooseOption("Pretende procurar outra proposta?", "Sim", "Não") == 1){
                    continue;
                }else{
                    finish = true;
                }
            }while(!finish);
        }
    }

    @Override
    public void edit(int i){
        boolean finish = false;
        if(i == 0){
            long n_aluno = (long) PAInput.readNumber("Numero de aluno a editar");
            while(phase.procuraAluno(n_aluno) == null){
                n_aluno = (long) PAInput.readNumber("Aluno não encontrado, verifique o numero");
            }
            Aluno aluno = phase.procuraAluno(n_aluno);
        }else if(i == 1){
            String email = PAInput.readString("Email de docente a editar", true);
            while(phase.procuraDocente(email) == null){
                email = PAInput.readString("Docente não encontrado, verifique email", true);
            }
            Docente docente = phase.procuraDocente(email);
        }else{
            String ca = PAInput.readString("Codigo de identificação de proposta a editar", true);
            while(phase.procuraProposta(ca) == null){
                ca = PAInput.readString("Proposta não encontrado, verifique email", true);
            }
            Proposta proposta = phase.procuraProposta(ca);
        }
    }

    @Override
    public void remove(int i){
        boolean finish = false;
        if(i == 0){
            do{
                long n_aluno = (long) PAInput.readNumber("Numero de aluno a remover");
                while(phase.procuraAluno(n_aluno) == null){
                    n_aluno = (long) PAInput.readNumber("Aluno não encontrado, por favor verifique o numero");
                }
                phase.removeAluno(n_aluno);
                if(PAInput.chooseOption("Pretende remover outro aluno?", "Sim", "Não") == 1){
                    continue;
                }
                else{
                    finish = true;
                }
            }while(!finish);
        }else if(i == 1){
            do{
                String email = PAInput.readString("Email de docente a remover", true);
                while(phase.procuraDocente(email) == null){
                    email= PAInput.readString("Docente não encontrado, por favor verifique o email", true);
                }
                phase.removeDocente(email);
                if(PAInput.chooseOption("Pretende remover outro docente?", "Sim", "Não") == 1){
                    continue;
                }
                else{
                    finish = true;
                }
            }while(!finish);
        }else{
            do{
                String ca = PAInput.readString("Codigo de identificação de docente a remover", true);
                while(phase.procuraProposta(ca) == null){
                    ca = PAInput.readString("Proposta não encontrada, por favor verifique o código", true);
                }
                phase.removeProposta(ca);
                if(PAInput.chooseOption("Pretende remover outra proposta?", "Sim", "Não") == 1){
                    continue;
                }
                else{
                    finish = true;
                }
            }while(!finish);
        }

    }

    @Override
    public boolean nextPhase(){
        return(changePhaseState(PhaseState.PHASE_2));
    }

    @Override
    public boolean previousPhase() {
        return false;
    }

    @Override
    public PhaseState getPhaseState() {
        return PhaseState.PHASE_1;
    }
}
