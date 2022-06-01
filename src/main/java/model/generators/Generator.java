package model.generators;

import java.util.HashSet;

public interface Generator{

    void generate(int entitiesNumber);

    default Object generate(){
        return generate(generateArguments());
    }

    Object generate(String[] args);

    String[] generateArguments();

    default void addNew(Object entity){
        get().add(entity);
    }

    HashSet<Object> get();

}
