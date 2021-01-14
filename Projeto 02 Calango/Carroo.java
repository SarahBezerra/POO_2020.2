import java.util.Scanner;
public class Carroo {

    int pass;
    int maxpass;
    int gas;
    int maxgas;
    int km;

    Carroo(int pass, int gas, int km){
        this.pass = pass;
        this.maxpass = 2;
        this.gas = gas;
        this.maxgas = 100;
        this.km = km;
    }

    void in(){
        if(pass >= 0 && pass < maxpass){
            pass += 1;
        }else{
            System.out.println("fail: limite de pessoas atingido");
        }
    }

    void out(){
        if(pass > 0 && pass <= maxpass){
            pass -= 1;
        }else{
            System.out.println("não há ninguém no carro");
        }

    }

    void fuel(int abasteceu){
        gas += abasteceu;
        if(gas > maxgas){
            gas = maxgas;
        }
    }

    void drive(int percorreu){
        if(pass == 0){
            System.out.println("não há ninguém no carro");
        }if(gas == 0){
            System.out.println("tanque vazio");
        }else{
            if(gas >= percorreu){
                gas -= percorreu;
                km += percorreu;
            }else{
                km += gas;
                System.out.println("tanque vazio após andar "+gas+" km");
                gas = 0;
            }
        }
    }

    boolean equals(Carroo other){
        return nome.equals(other.nome);
    }

    public String toString(){
        return "Carro:  pass:"+pass+" gasolina:"+gas+" km:"+km; 
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Carroo car = new Carroo(0,0,0);

        while(true){
            String frase = scanner.nextLine();
            String[] comando = frase.split(" ");

            if(comando[0].equals("end")){
                break;
            }

            if(comando[0].equals("in")){
                car.in();
            }else if(comando[0].equals("out")){
                car.out();
            }else if(comando[0].equals("fuel")){
                car.fuel(Integer.parseInt(comando[1]));
            }else if(comando[0].equals("drive")){
                car.drive(Integer.parseInt(comando[1]));
            }else if(comando[0].equals("show")){
                System.out.println(car);
            }else{
                System.out.println("fail: comando inválido");
            }
        }



        scanner.close();
    }
}
