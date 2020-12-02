import org.graalvm.compiler.nodes.FullInfopointNode;

public class Carro{
    int gas;
    int gasMax;
    int pass;
    int passMax;
    int km;


    Carro(int gas, int pass, int km){
        this.gas = gas;
        this.gasMax = 100;
        this.pass = pass;
        this.passMax = 2;
        this.km = km;
    }

    void in(){
        if(pass < 2){
            System.out.println("Entrou 1 pessoa");
            pass += 1;
        }else{
            System.out.println("fail: Limite de pessoas atingido");
        }
    }

    void out(){
        if(pass > 0){
            System.out.println("Saiu 1 pessoa");
            pass -= 1;
        }else{
            System.out.println("fail: Não há ninguém no carro");
        }
    }

    void fuel(int gasosa){
        gas = gas + gasosa;

        if(gas > gasMax){
            gas = gasMax;
            System.out.println("Alcançou o limite de combustivel");
        }else{
            System.out.println("No tanque há " + gas + " litros");
        }
    }

    void drive(int distance){
        if(pass > 0){
            if(gas > 0){
                if(gas - distance > 0){
                    gas -= distance;
                    km += distance;
                }else if(gas - distance <= 0){
                    km += gas;
                    System.out.println("Tanque vazio após andar " + gas + " km");
                    gas = 0;
                }
            }else{
                System.out.println("fail: Tanque vazio");
            }
        }else{
            System.out.println("fail: Não há ninguém no carro");
        }
    }

    public String toString(){
        return "Carro:   pass: " + pass + "   gas: " + gas + "   km: " + km;
    }

    public static void main(String[] args){
        Carro fusca = new Carro(0, 0, 0);
        System.out.println(fusca);

        fusca.in();
        fusca.out();
        fusca.in();
        fusca.in();

        fusca.fuel(60);
        System.out.println(fusca);

        fusca.fuel(50);
        System.out.println(fusca);

        fusca.drive(10);
        System.out.println(fusca);

        fusca.drive(50);
        System.out.println(fusca);

        fusca.drive(100);
        System.out.println(fusca);

        fusca.drive(10);
        System.out.println(fusca);
    





    }
}