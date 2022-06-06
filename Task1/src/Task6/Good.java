package Task6;

import java.util.ArrayList;
import java.util.List;

public class Good {
    public List<String> list;
    private Good(Builder builder){
        list = builder.list;
    }

    public static class Builder{
        public List<String> list = new ArrayList<>();

        public Builder addGood(String str) {
            list.add(str);
            return this;
        }
        public Good build(){
            return new Good(this);
        }
    }
}
