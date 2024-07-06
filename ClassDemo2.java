class Computer
{
    public void playMusic()
    {
        System.out.println("Playing Music");
    }

    public String playGame(String gameName)
    {

        return "Playing Game " + gameName;
    }

}

public class ClassDemo2 {
    public static void main(String[] args) {
        Computer comp = new Computer();
        comp.playMusic();

        String gameplying = comp.playGame("Condition Zero");
        System.out.println(gameplying);
    }
}
