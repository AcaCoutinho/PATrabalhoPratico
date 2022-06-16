package pt.isec.pa.apoio_poe.model.data;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Phase {
    private ArrayList<Aluno> alunos;
    private ArrayList<Docente> docentes;
    private ArrayList<Proposta> propostas;
    private ArrayList<Candidatura> candidaturas;
    private HashMap<Aluno, Candidatura> alunoCandidatura;

    boolean isClosed1, isClosed2, isClosed3, isClosed4;

    public Phase() {
        alunos = new ArrayList<>();
        docentes = new ArrayList<>();
        propostas = new ArrayList<>();
        candidaturas = new ArrayList<>();
        alunoCandidatura = new HashMap<>();

        isClosed1 = false;
        isClosed2 = false;
        isClosed3 = false;
        isClosed4 = false;
    }

    public boolean getisClosed (int phase){
        if(phase == 1)
            return isClosed1;
        else if(phase == 2)
            return isClosed2;
        else if(phase == 3)
            return isClosed3;
        else
            return isClosed4;
    }

    public void setIsClosed(int phase, boolean isClosed) {
        switch (phase){
            case 1 -> isClosed1 = isClosed;
            case 2 -> isClosed2 = isClosed;
            case 3 -> isClosed3 = isClosed;
            case 4 -> isClosed4 = isClosed;
        }
    }

    public boolean adicionaAluno(Aluno aluno){
        if(alunos.contains(aluno)){
            return false;
        }else{
            alunos.add(aluno);
            return true;
        }
    }

    public void adicionaAlunoFile(String fileName) {
        ArrayList<String> dados = new ArrayList<>();
        try{
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(br);
            sc.useDelimiter(",|\\n");

            while(sc.hasNext()){
                dados.add(sc.next());
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        int i = 0;
        while(i < dados.size()){
            adicionaAluno(new Aluno(Long.parseLong(dados.get(i++)), dados.get(i++), dados.get(i++), dados.get(i++), dados.get(i++), Double.parseDouble(dados.get(i++)), Boolean.parseBoolean(dados.get(i++).trim())));
        }
    }

    public Aluno getAluno(long n_aluno){
        for(var i : alunos){
            if(i.getN_aluno() == n_aluno){
                return i;
            }
        }
        return null;
    }

    public boolean procuraAluno(long nAluno){
        for(var i : alunos){
            if(i.getN_aluno() == nAluno)
                return true;
        }
        return false;
    }

    public void editaAluno(long nAluno, String tipo, String dados) {
        if(!procuraAluno(nAluno))
            return;

        switch (tipo){
            case "nome" -> getAluno(nAluno).setNome(dados);
            case "siglaC" -> getAluno(nAluno).setSiglaC(dados);
            case "siglaR" -> getAluno(nAluno).setSiglaR(dados);
            case "grade" -> getAluno(nAluno).setGrade(Long.parseLong(dados));
            case "email" -> getAluno(nAluno).setEmail(dados);
        }
    }

    public boolean removeAluno(long n_aluno){
        for(var i : alunos){
            if(i.getN_aluno() == n_aluno){
                alunos.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean adicionaDocente(Docente docente){
        if(docentes.contains(docente)){
            return false;
        }else{
            docentes.add(docente);
            return true;
        }
    }

    public void adicionaDocenteFile(String fileName) {
        ArrayList<String> dados = new ArrayList<>();
        try{
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(br);
            sc.useDelimiter(",|\\n");

            while(sc.hasNext()){
                dados.add(sc.next());
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        int i = 0;
        while(i < dados.size()){
            adicionaDocente(new Docente(dados.get(i++), dados.get(i++).trim()));
        }
    }

    public boolean procuraDocente(String email){
        for(var i : docentes){
            if(i.getEmail() == email)
                return true;
        }
        return false;
    }

    public Docente getDocente(String email) {
        for (var i : docentes) {
            if (i.getEmail().equals(email)) {
                return i;
            }
        }
        return null;
    }

    public boolean removeDocente(String email){
        for(var i : docentes){
            if(i.getEmail().equals(email)){
                docentes.remove(i);
                return true;
            }
        }
        return false;
    }

    public void editDocente(String email, String tipo, String dados) {
        if(!procuraDocente(email)){
            return;
        }

        switch (tipo){
            case "nome" -> getDocente(email).setNome(dados);
            case "Orientador" -> getDocente(email).setOrientador(Boolean.parseBoolean(dados));
        }
    }

    public void adicionaProposta(Proposta proposta){
        if(propostas.contains(proposta))
            return;
        propostas.add(proposta);
    }

    public void adicionaPropostaFile(String fileName) {
        ArrayList<String> dados = new ArrayList<>();
        try{
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(br);
            sc.useDelimiter(",|\\n");

            while(sc.hasNext()){
                dados.add(sc.next());
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        int i = 0;
        while(i < dados.size()){
            if(dados.get(i).equals("T1")){
                i++;
                if(i >= dados.size()-4 || dados.get(i+4).equals("T1") || dados.get(i+4).equals("T2")  || dados.get(i+4).equals("T3")){
                    adicionaProposta(new Estagio(dados.get(i++), dados.get(i++), dados.get(i++), dados.get(i++).trim()));
                }else{
                    adicionaProposta(new Estagio(dados.get(i++), dados.get(i++), dados.get(i++), dados.get(i++), Long.parseLong(dados.get(i++).trim())));
                }
            }else if(dados.get(i).equals("T2")){
                i++;
                if(i >= dados.size()-4 || dados.get(i+4).equals("T1") || dados.get(i+4).equals("T2") || dados.get(i+4).equals("T3")){
                    adicionaProposta(new Projeto(dados.get(i++), dados.get(i++), dados.get(i++), getDocente(dados.get(i++).trim())));
                }else{
                    adicionaProposta(new Projeto(dados.get(i++), dados.get(i++), dados.get(i++), getDocente(dados.get(i++)), Long.parseLong(dados.get(i++).trim())));
                }
            }else{
                i++;
                adicionaProposta(new Autoproposto(dados.get(i++), dados.get(i++), Long.parseLong(dados.get(i++).trim())));
            }
        }
    }

    public Proposta getProposta(String ca){
        for(var i : propostas){
            if(i.getCa().equals(ca)){
                return i;
            }
        }
        return null;
    }

    public boolean procuraProposta(String ca) {
        for (var i : propostas){
            if(i.getCa().equals(ca))
                return true;
        }
        return false;
    }

    public void editProposta(String ca, String tipo, String dados) {
        if(!procuraProposta(ca)){
            return;
        }

        if(getProposta(ca) instanceof Estagio aux) {
            switch (tipo) {
                case "titulo" -> aux.setTitulo(dados);
                case "nAluno" -> aux.setN_alunoAt(Long.parseLong(dados));
                case "ad" -> aux.setAd(dados);
                case "entityID" -> aux.setEntityId(dados);
            }
        }
        if(getProposta(ca) instanceof Projeto aux) {
            switch (tipo) {
                case "titulo" -> aux.setTitulo(dados);
                case "nAluno" -> aux.setN_alunoAt(Long.parseLong(dados));
                case "rd" -> aux.setRd(dados);
            }
        }
        if(getProposta(ca) instanceof Autoproposto aux) {
            switch (tipo) {
                case "titulo" -> aux.setTitulo(dados);
                case "nAluno" -> aux.setN_alunoAt(Long.parseLong(dados));
            }
        }
    }

    public boolean removeProposta(String ca){
        for(var i : propostas){
            if(i.getCa().equals(ca)){
                propostas.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean adicionaCandidatura(Candidatura candidatura) {
        if(candidaturas.contains(candidatura)) {
            return false;
        } else {
            candidaturas.add(candidatura);
            return true;
        }
    }

    public void adicionaCandidaturaFile(String fileName) {
        ArrayList<String> dados = new ArrayList<>();
        long n_aluno;
        ArrayList<String> idPropostas = new ArrayList<>();
        Candidatura aux;

        try{
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(br);
            sc.useDelimiter(",|\\n");

            while(sc.hasNext()){
                dados.add(sc.next());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        int i = 0;
        while(i < dados.size()) {
            n_aluno = Long.parseLong(dados.get(i++));
            while(dados.get(i).contains("P")){
                idPropostas.add(dados.get(i).trim());
                if(i+1 == dados.size()){
                    i++;
                    break;
                }else{
                    i++;
                }
            }
            aux = new Candidatura(n_aluno);
            aux.adicionaId(idPropostas);
            adicionaCandidatura(aux);
            idPropostas.clear();
        }
        associaAlunoCandidatura();
    }

    public Candidatura getCandidatura(long n_aluno) {
        for (var i : candidaturas){
            if(i.getN_aluno() == n_aluno)
                return i;
        }
        return null;
    }

    public boolean procuraCandidatura(long nAluno) {
        for (var i : candidaturas)
            if (i.getN_aluno() == nAluno)
                return true;
        return false;
    }

    public void editCandidatura(Long nAluno, String tipo, ArrayList<String> dados) {
        if(!procuraCandidatura(nAluno))
            return;

        switch (tipo){
            case "idPropostaAdiciona" -> {
                if(getCandidatura(nAluno).getIdPropostas().contains(dados))
                    return;
                getCandidatura(nAluno).adicionaId(dados);
            }
            case "idPropostaRemove" -> {
                if(getCandidatura(nAluno).getIdPropostas().contains(dados))
                    getCandidatura(nAluno).getIdPropostas().removeAll(dados);
            }
        }
    }

    public boolean removeCandidatura(long n_aluno) {
        for (var i : candidaturas){
            if(i.getN_aluno() == n_aluno)
                candidaturas.remove(i);
                return true;
        }
        return false;
    }

    public ArrayList<Aluno> getAlunos(){
        ArrayList<Aluno> tmp = new ArrayList<>(alunos);
        return tmp;
    }

    public ArrayList<Docente> getDocentes(){
        ArrayList<Docente> tmp = new ArrayList<>(docentes);
        return tmp;
    }

    public ArrayList<Proposta> getPropostas(){
        ArrayList<Proposta> tmp = new ArrayList<>(propostas);
        return tmp;
    }

    public ArrayList<Candidatura> getCandidaturas(){
        ArrayList<Candidatura> tmp = new ArrayList<>(candidaturas);
        return tmp;
    }

    public HashMap<String, Long> getPropAndAlunos(){
        HashMap<String, Long> tmp = new HashMap<>();
        for(var i : propostas){
            tmp.put(i.getCa(), i.getN_alunoAt());
        }
        return tmp;
    }

    public void associaAlunoCandidatura(){
        for(var i : alunos){
            for(var j : candidaturas){
                if(i.getN_aluno() == j.getN_aluno()){
                    alunoCandidatura.put(i, j);
                }
            }
        }
    }

    public void mostraAlunosCandidaturas(){
        StringBuilder sb = new StringBuilder();
        for (var i : alunoCandidatura.keySet()) {
            sb.append("\n" + i.toString());
            sb.append("\n" + alunoCandidatura.get(i).toString());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public float getMediaOrientadores(){
        int count = 0;
        for (Docente docente : docentes) {
            if (docente.getOrientador()) {
                count++;
            }
        }
        return (count / docentes.size());
    }

    public void export(String fileName) {
        try{
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter br = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(br);

            for(int i = 0; i < alunos.size(); i++){
                pw.append(alunos.get(i).getNome() + "," + alunos.get(i).getN_aluno() + "," + alunos.get(i).getEmail()+","
                        + alunos.get(i).getSiglaC()+ "," + alunos.get(i).getSiglaR() + "," + alunos.get(i).getGrade());
                if(alunos.get(i).getPropAtribuida() != null){
                    pw.append("," + alunos.get(i).getPropAtribuida().getCa());
                }
                pw.append("\n");
            }
            pw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String listaAluno(String tipoLista){
        StringBuilder sb = new StringBuilder();
        Aluno aux;
        Proposta aux1;

        if(tipoLista.equals("autoproposta")){
            for(Proposta proposta : propostas){
                if(proposta instanceof Autoproposto autoproposto){
                    aux = getAluno(autoproposto.getN_alunoAt());
                    sb.append(aux.toString());
                }
            }
        }
        if(tipoLista.equals("candidatura")){
            for(Candidatura candidatura : candidaturas){
                aux = getAluno(candidatura.getN_aluno());
                sb.append(aux.toString());
            }
        }
        if(tipoLista.equals("no_candidatura")){
            ArrayList<Long> nAlunosCandidaturas = new ArrayList<>();
            ArrayList<Long> nAlunos = new ArrayList<>();

            for(Candidatura candidatura : candidaturas)
                nAlunosCandidaturas.add(candidatura.getN_aluno());
            for(Aluno aluno : alunos)
                nAlunos.add(aluno.getN_aluno());

            nAlunos.removeAll(nAlunosCandidaturas);
            for(int i = 0; i < nAlunos.size(); i++){
                sb.append(getAluno(nAlunos.get(i)).toString());
            }
        }
        if(tipoLista.equals("atribuida")){
            for(Proposta proposta : propostas){
                if(proposta instanceof Autoproposto autoproposto){
                    aux = getAluno(autoproposto.getN_alunoAt());
                    sb.append(aux.toString());
                }
                if(proposta instanceof Estagio estagio){
                    if(estagio.getN_alunoAt() != 0) {
                        aux = getAluno(estagio.getN_alunoAt());
                        sb.append(aux.toString());
                    }
                }
                if(proposta instanceof Projeto projeto){
                    if(projeto.getN_alunoAt() != 0) {
                        aux = getAluno(projeto.getN_alunoAt());
                        sb.append(aux.toString());
                    }
                }
            }
        }
        if(tipoLista.equals("no_atribuida")){
            ArrayList<Long> nAlunosAtribuida = new ArrayList<>();
            ArrayList<Long> nAlunos = new ArrayList<>();

            for(Aluno aluno : alunos)
                nAlunos.add(aluno.getN_aluno());
            for(Proposta proposta : propostas)
                nAlunosAtribuida.add(proposta.getN_alunoAt());

            nAlunos.remove(nAlunosAtribuida);
            for(int i = 0; i < nAlunos.size(); i++){
                aux = getAluno(nAlunos.get(i));
                sb.append(aux.toString());
            }
        }
        if(tipoLista.equals("associado")){
            for(Docente docente : docentes){
                if(docente.getOrientador()){
                    aux1 = docente.getProjeto();
                    aux = getAluno(aux1.getN_alunoAt());
                    sb.append(aux.toString());
                }
            }
        }
        if(tipoLista.equals("no_associado")){
            ArrayList<String> idsDocente = new ArrayList<>();
            ArrayList<String> ids = new ArrayList<>();

            for(Docente docente : docentes)
                idsDocente.add(docente.getProjeto().getCa());
            for(Proposta proposta : propostas)
                ids.add(proposta.getCa());

            ids.remove(idsDocente);
            for(int i = 0; i < ids.size(); i++){
                aux = getAluno(getProposta(ids.get(i)).getN_alunoAt());
                sb.append(aux.toString());
            }
        }
        return sb.toString();
    }

    public String listaDocente(String tipoLista){
        StringBuilder sb = new StringBuilder();

        sb.append("Em media um docente orienta " + getMediaOrientadores());
        for(Docente docente : docentes){
            sb.append(docente.toString());
        }
        return sb.toString();
    }

    public String listaProposta(String tipoLista){
        StringBuilder sb = new StringBuilder();
        if(tipoLista.equals("autoproposta")){
            for(Proposta proposta : propostas){
                if(proposta instanceof Autoproposto autoproposto){
                    sb.append(proposta.toString());
                }
            }
        }
        if(tipoLista.equals("docente")){
            for(Proposta proposta : propostas){
                if(proposta instanceof Projeto projeto)
                    sb.append(projeto.toString());
            }
        }
        if(tipoLista.equals("candidatura")){
            ArrayList<String> idsCandidatura = new ArrayList<>();
            ArrayList<String> idsPropostas = new ArrayList<>();

            for(Proposta proposta : propostas)
                idsPropostas.add(proposta.getCa());
            for(Candidatura candidatura : candidaturas)
                idsCandidatura.addAll(candidatura.getIdPropostas());

            idsPropostas.removeAll(idsCandidatura);
            for(int i = 0; i < idsPropostas.size(); i++){
                sb.append(getProposta(idsPropostas.get(i)).toString());
            }
        }
        if(tipoLista.equals("no_candidatura")){
            ArrayList<String> idsCandidatura = new ArrayList<>();
            ArrayList<String> idsPropostas = new ArrayList<>();

            for(Candidatura candidatura : candidaturas)
                idsCandidatura.addAll(candidatura.getIdPropostas());
            for(Proposta proposta : propostas)
                idsPropostas.add(proposta.getCa());

            idsPropostas.removeAll(idsCandidatura);
            for(int i = 0; i < idsPropostas.size(); i++){
                sb.append(getProposta(idsPropostas.get(i)).toString());
            }
        }
        if(tipoLista.equals("atribuida")){
            for(Proposta proposta : propostas){
                if(proposta instanceof Autoproposto aux){
                    sb.append(aux.toString());
                }
                if(proposta instanceof Estagio aux) {
                    if(aux.getN_alunoAt() != 0){
                        sb.append(aux.toString());
                    }
                }
                if(proposta instanceof Projeto aux) {
                    if(aux.getN_alunoAt() != 0){
                        sb.append(aux.toString());
                    }
                }
            }
        }
        if(tipoLista.equals("disponiveis")){
            for(Proposta proposta : propostas){
                if(proposta instanceof Estagio aux){
                    if(aux.getN_alunoAt() == 0){
                        sb.append(proposta.toString());
                    }
                }
                if(proposta instanceof Projeto aux){
                    if(aux.getN_alunoAt() == 0)
                        sb.append(aux.toString());
                }
            }
        }
        return sb.toString();
    }
}
