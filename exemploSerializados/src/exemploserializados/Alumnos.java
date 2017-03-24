
package exemploserializados;

import java.io.Serializable;
import java.util.Objects;

public class Alumnos implements Serializable,Comparable{
    private String nome;
    private int nota;

    public Alumnos() {
    }

    public Alumnos(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + this.nota;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumnos other = (Alumnos) obj;
        if (this.nota != other.nota) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        Alumnos alu=(Alumnos)o;
    
        if(this.nome.compareToIgnoreCase(alu.nome)==0)
            return 0;
        else if(this.nome.compareToIgnoreCase(alu.nome)>0)
            return 1;
        else
            return -1;
    }
    
    
    
}
