import java.util.Scanner;
class Pessoa{
    public String nome;
    public int idade;

    Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String toString(){
        return "[" + nome + ":" + idade + "]";
    }
}

public class Motoca {
    public int potencia;
    public int tempo;
    public Pessoa individuo;

    Motoca(int potencia){
        this.potencia = potencia;
        this.tempo = 0;
        this.individuo = null;
    }

    public void comprarTempo(int valor){
        this.tempo += valor;
    }

    public void subir(Pessoa pessoa){
        if(individuo != null){      // erro aqui, diz q a moto esta ocupada qnd ela esta mull, n deveria ser != ?
            System.out.println("Moto ocupada");
            return;
        }
        System.out.println("Pessoa subiu na motoca");
        individuo = pessoa;
    }

    public Pessoa descer(){
        if(individuo == null){
            System.out.println("Moto já está vazia");
            return null;
        }
        Pessoa aux = individuo;
        individuo = null;
        return aux;
    }

    public void dirigir(int min){
        if(individuo == null){
            System.out.println("Moto vazia");
            return;
        }
        if(individuo.idade > 10){
            System.out.println("Muito grande para andar na moto");
            return;
        }
        if(min > this.tempo){
            System.out.println("Andou " + this.tempo + " minutos e acabou o tempo");
            this.tempo = 0;
            return;
        }

        this.tempo -= min;
        System.out.println("Dirigindo...");
    }

    public String buzinar(){
        if(individuo == null){
            System.out.println(("Moto vazia"));
            return "";
        }
        String buzina = "Pe";
        for(int i=1; i<this.potencia; i++){
            buzina += "e";
        }
        buzina += "m";
        System.out.println(buzina);
        return "";
    }

    public String toString(){
        return "Potencia:" + potencia + "  Minutos:" + tempo + "  Pessoa:" + individuo;
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Motoca moto = new Motoca(4);
    
        while(true){
            String line = scanner.nextLine();
            String words[] = line.split(" ");

            if(words[0].equals("show")){
                System.out.println(moto);
            }else if(words[0].equals("buy")){
                moto.comprarTempo(Integer.parseInt(words[1]));
            }else if(words[0].equals("in")){
                Pessoa gente = new Pessoa(words[1], Integer.parseInt(words[2]));
                moto.subir(gente);
            }else if(words[0].equals("out")){
                moto.descer();
            }else if(words[0].equals("drive")){
                moto.dirigir(Integer.parseInt(words[1]));
            }else if(words[0].equals("buzinar")){
                moto.buzinar();
            }else if(words[0].equals("init")){
                //Motoca moto = new Motoca(Integer.parseInt(words[1]));
            }else if(words[0].equals("end")){
                break;
            }else{
                System.out.println("fail: comando inválido");
            }

        }


        scanner.close();
    }

}
