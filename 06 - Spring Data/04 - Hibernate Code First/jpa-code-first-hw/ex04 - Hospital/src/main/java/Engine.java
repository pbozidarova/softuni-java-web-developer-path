import javax.persistence.EntityManager;
import java.nio.file.Watchable;

public class Engine implements Runnable{
    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run() {

    }
}
