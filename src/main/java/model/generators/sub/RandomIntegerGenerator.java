package model.generators.sub;

import java.util.ArrayList;

public interface RandomIntegerGenerator{

    default int getRandomIndex(ArrayList<?> list){
        return getRandomInteger(list.size());
    }

    default int getRandomInteger(int edge){
        return (int)(Math.random()*edge);
    }

    default int getRandomIntegerIncludingEdge(int edge){
        return getRandomInteger(edge+1);
    }

}
