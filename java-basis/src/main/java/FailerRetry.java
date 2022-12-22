import java.nio.Buffer;

public class FailerRetry {
    public static void main(String[] args) {
        int retry = 0;
        while (true) {
            System.out.println("aaaaaaaaaaaa" + retry);
            if (retry > Integer.MAX_VALUE / 1000) {
                break;
            }
            if (retry % 2 == 0) {
                continue;
            }
            retry++;
        }
    }
}
