package model.beans;

import java.io.Serializable;

/**
 *
 * @author skuarch
 */
public class AffiliateType implements Serializable {        
   
    private long id;    
    private String name;

    public AffiliateType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
