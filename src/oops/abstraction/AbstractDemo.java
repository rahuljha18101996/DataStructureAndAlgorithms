package oops.abstraction;

abstract class AbsFile {

}

class MusicCls extends AbsFile {
    public void playMusic() {
        System.out.println("Music Playing...");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        AbsFile a = new MusicCls();
        useInstanceOf(a);
    }

    private static void useInstanceOf(AbsFile a) {
        if (a instanceof MusicCls mc) {
            mc.playMusic();
        }
    }
}
