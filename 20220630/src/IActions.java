public interface IActions {

    String getName();
    void run();
    void jump();
    boolean ran(Obstacle o);
    boolean jumped(Obstacle o);

    default void printResult(String member, String action, boolean past, int meters, int limit) {
        if (past) {
            System.out.printf("%s %s %d meters\n", member, action, meters);
        } else {
            String obstacle;
            if (action.equals("ran")) {
                action = "ran maximal";
                obstacle = "Treadmill";
            } else {
                action = "jump maximum";
                obstacle = "Wall";
            }
            System.out.printf("%s can %s %d meters, but %s is %d meters\n", member, action, limit, obstacle, meters);
        }
    }
}