
class Joueur extends Thread{
public String nom;
public Ballon bln;
public Joueur(String nom , Ballon bln)
{
    this.nom = nom;
    this.bln = bln;
}

    @Override
    public void run() {
        super.run();
        while(true)
        {
                this.bln.Recoire(this);
                this.bln.lache(this);
        }
    }
}
class Ballon{
    public int numero;
    public Ballon(int num)
    {
        this.numero = num;
    }
    public synchronized void Recoire(Joueur joueur){
        try{
        System.out.println( joueur.nom +" recoit le ballon numero " + this.numero);
        Thread.sleep(500);
    }catch(InterruptedException ex){

    }
    }
    public synchronized void lache(Joueur joueur){
        System.out.println( joueur.nom +" lache le ballon numero " + this.numero+"\n\n");
    }
}


public class Jeu {
    public static void main(String[] args) {
        Ballon ballon = new Ballon(111);
        Joueur j1 = new Joueur("yassine", ballon);
        Joueur j2 = new Joueur("amine", ballon);
        j1.start();
        j2.start();

    }

}
