package BPlusTree;

import java.util.ArrayList;
import java.util.List;


//class key
public class Key {

    double key;

//    The list of values for the key.
    List<String> values;

    public Key(double key, String value) {
        this.key = key;
        if (null == this.values) {
            values = new ArrayList<>();
        }
        this.values.add(value);
    }

    public Key(double key) {
        this.key = key;
        this.values = new ArrayList<>();
    }

    public double getKey() {
        return key;
    }

    public void setKey(double key) {
        this.key = key;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public String toString() {
        return "Key [key=" + key + ", values=" + values + "]";
    }

}