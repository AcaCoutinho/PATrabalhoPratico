package pt.isec.pa.apoio_poe.model.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Phase {
    private ArrayList<Aluno> alunos;
    private ArrayList<Docente> docentes;
    private ArrayList<Proposta> propostas;
    private ArrayList<Candidatura> candidaturas;
    private HashMap<Aluno, Candidatura> alunoCandidatura;

    public Phase() {
        alunos = new ArrayList<>();
        docentes = new ArrayList<>();
        propostas = new ArrayList<>();
        candidaturas = new ArrayList<>();
        alunoCandidatura = new HashMap<>();
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

    public void editDocente() {

    }

    public boolean adicionaProposta(Proposta proposta){
        if(propostas.contains(proposta)){
            return false;
        }else{
            propostas.add(proposta);
            return true;
        }
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

    public void editProposta() {

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

    public void editCandidatura() {

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
        for(int i = 0; i < docentes.size(); i++){
            if(docentes.get(i).getOrientador()){
                count++;
            }
        }
        return (count / docentes.size());
    }
}
