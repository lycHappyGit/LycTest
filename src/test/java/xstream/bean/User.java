package xstream.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.List;

/**
 * Created by beyondLi on 2017/6/14.
 */
@Data
@XStreamAlias("User")
public class User {
    private String name;
    private Integer age;
    private List<Customer> customer;
}