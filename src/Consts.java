//class with most used constants

public final class Consts {
    public static final int CONGRESS_DAYS = 3;
    public static final int SESSIONS_PER_DAY = 12;
    public static final int SPEAKERS_PER_SESSION = 5;

    public static final int INT_SIZE = 4; //in bytes
    public static final int SOCKET_PORT = 6789;
    public static final int ARRAY_INIT_SIZE = 1024;
    public static final long SLEEP_TIME = 2000; //delay between each packet
    public static final long LOSS_CHANCE = 25; //in percentage
    public static final int SEQ_N_RANGE = 10;
    public static final int UDP_TIMEOUT = 5000; //in ms
    public static final String MULTICAST_ADDRESS = "230.0.0.0";
    public static final int READS_N = 10; //number of packets read from client
    public static final long TOTAL_RUNTIME = SLEEP_TIME * READS_N + UDP_TIMEOUT; //approximation of client runtime
}
