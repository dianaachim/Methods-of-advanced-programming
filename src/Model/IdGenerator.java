package Model;

public class IdGenerator {
    private static int count = 0;
    public static int generateID() {
        return count++;
    }
}
