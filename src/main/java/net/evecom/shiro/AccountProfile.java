package net.evecom.shiro;

import lombok.Data;
import java.io.Serializable;

/**
 * id确认
 */
@Data
public class AccountProfile implements Serializable {

    private Long id;
    private String account;
    /*private String descrips;*/
    /*private String email;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}

