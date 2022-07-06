public interface IActions {

    String getName();
    boolean run(int meters, String obstacle);
    boolean jump(int height, String obstacle);

    default void printResult(String member, String[] action, boolean past, String obstacle, int meters, int limit) {
        if (past) {
            System.out.printf("%s %s %d meters\n", member, action[1], meters);
        } else {
            System.out.printf("%s %s limit is %d meters, but %s %s is %d meters\n", member, action[0], limit, obstacle, action[2], meters);
        }
    }
}