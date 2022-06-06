package Task6;

import java.lang.reflect.Type;

public class Toy implements Copyable{
    private String name;

    public Toy(String str) {
        name = str;
        System.out.println(str + " was bought");
    }
    public Toy copy(){
        Toy toy = new Toy(name);
        return toy;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                '}';
    }
}
