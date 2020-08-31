package net.evecom.common.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 登录设定
 */
@Data
public class LoginDto implements Serializable {

    @NotBlank(message = "账号不能为空")
    private String account;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "必须有用户类型")
    private String usertype;

    public String getUsertype(){
        return usertype;
    }

    public void setUsertype(){
        this.usertype = usertype;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

