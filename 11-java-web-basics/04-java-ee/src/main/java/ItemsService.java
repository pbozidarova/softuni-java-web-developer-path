import java.util.List;

public class ItemsService {
    private final DataRepository repository;

    public ItemsService(DataRepository repository){
        this.repository = repository;
    }

    public List<String> getAll(){
        return repository.getAll();
    }

    public List<String> getAllByPattern(String pattern){
        return repository.getAll();
    }
}
