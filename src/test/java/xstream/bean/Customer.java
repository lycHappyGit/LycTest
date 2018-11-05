package xstream.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * Created by beyondLi on 2017/6/14.
 */
@Data
@XStreamAlias("Customer")
public class Customer {
    private String commodity;
}