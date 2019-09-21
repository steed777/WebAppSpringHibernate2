package konst;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRep extends CrudRepository<Message, Integer>{
List<Message> findByTag(String tag);
}
