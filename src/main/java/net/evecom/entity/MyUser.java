package net.evecom.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 *用户实体
 * </p>
 *
 * @author gc
 * @since 2020-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("my_user")
public class MyUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "账号不为空")
    private String account;

    @NotBlank(message = "用户名不为空")
    private String username;

    @NotBlank(message = "密码不为空")
    private String password;

    private Integer phone;

    private String descrips;

    @Email(message = "邮箱格式不正确")
    private String email;

    private String condis;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime created;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime changed;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime lastLogin;

    private String avatar;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getDescrips() {
        return descrips;
    }

    public void setDescrips(String descrips) {
        this.descrips = descrips;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCondis() {
        return condis;
    }

    public void setCondis(String condis) {
        this.condis = condis;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getChanged() {
        return changed;
    }

    public void setChanged(LocalDateTime changed) {
        this.changed = changed;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", descrips='" + descrips + '\'' +
                ", email='" + email + '\'' +
                ", condis='" + condis + '\'' +
                ", created=" + created +
                ", changed=" + changed +
                ", lastLogin=" + lastLogin +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
