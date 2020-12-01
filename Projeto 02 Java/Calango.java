
public class Calango{ 
    int energia;
    int maxEnergia;
    int numpatas;
    boolean estaVivo;
    boolean rabo;

    Calango(int energia, int numpatas){
        this.energia = energia;
        this.numpatas = numpatas;
        this.maxEnergia = energia;
        this.estaVivo = true;
        this.rabo = true;
    }

    void correr(){
        if(numpatas < 2){
            System.out.println("Estou temporariamente impossibilitado :(");
            return;
        }
        if(energia > 0){
            System.out.println("Dando uma carreira");
            energia -= 1;
        }else{
            System.out.println("Estou muito cansado");
        }    
    } 

    void briga(){
        if(numpatas > 0){
            numpatas -= 1;
            System.out.println("Arri égua!!! Perdi uma pata.");
        }else if(rabo){
            System.out.println("Perdi meu rabooooo!!!!");
            rabo = false;
        }else{
        System.out.println("Adeus, mundo crueel!!!");
        estaVivo = false;
        }
    }

    void regenerar(){
        if(estaVivo == false){
            System.out.println("R.I.P");
            return;
        }
        if(numpatas < 4){
            System.out.println("1 patinha de volta!!  :D");
            numpatas += 1;
            return;
        }else if(rabo == false){
            System.out.println("Regenerando meu rabinho");
            rabo = true;
            return;
        }else{
            System.out.println("Já estou todo completinho :)");
        }
    }

    void descansar(int turnos){
        System.out.println("Descansando...");
        energia += turnos;

        if(energia > maxEnergia){
        energia = maxEnergia;
        }
    }
    

    public String toString(){
        return "Calango: Energia:" + energia + " Patas:" + numpatas + " Rabo:" + rabo;
    }


    public static void main(String[] args) {
        System.out.println("Oi, eu sou o Calanguinho!");
        Calango deadpool = new Calango(10, 4);
        System.out.println(deadpool);

        for(int i = 0; i < 11; i ++){
            deadpool.correr();
        }

        System.out.println(deadpool);
        deadpool.descansar(5);
        
        deadpool.briga();
        deadpool.briga();
        deadpool.briga();
        deadpool.briga();
        deadpool.briga();
        deadpool.briga();

        deadpool.regenerar();
        System.out.println(deadpool);

    }
}