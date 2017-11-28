package com.gqxie.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 */
public class TUser implements Serializable
{
    private Integer id;

    private Long userid;

    private String account;

    private String pwd;

    private Byte gender;

    private Integer age;

    private Integer state;

    private Date birthday;

    private String email;

    private String phone;

    private String nickname;

    private static final long serialVersionUID = 1L;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Long getUserid()
    {
        return userid;
    }

    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    public Byte getGender()
    {
        return gender;
    }

    public void setGender(Byte gender)
    {
        this.gender = gender;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public Integer getState()
    {
        return state;
    }

    public void setState(Integer state)
    {
        this.state = state;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object that)
    {
        if (this == that)
        {
            return true;
        }
        if (that == null)
        {
            return false;
        }
        if (getClass() != that.getClass())
        {
            return false;
        }
        TUser other = (TUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId())) && (
                this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid())) && (
                this.getAccount() == null ?
                        other.getAccount() == null :
                        this.getAccount().equals(other.getAccount())) && (this.getPwd() == null ?
                other.getPwd() == null :
                this.getPwd().equals(other.getPwd())) && (this.getGender() == null ?
                other.getGender() == null :
                this.getGender().equals(other.getGender())) && (this.getAge() == null ?
                other.getAge() == null :
                this.getAge().equals(other.getAge())) && (this.getState() == null ?
                other.getState() == null :
                this.getState().equals(other.getState())) && (this.getBirthday() == null ?
                other.getBirthday() == null :
                this.getBirthday().equals(other.getBirthday())) && (this.getEmail() == null ?
                other.getEmail() == null :
                this.getEmail().equals(other.getEmail())) && (this.getPhone() == null ?
                other.getPhone() == null :
                this.getPhone().equals(other.getPhone())) && (this.getNickname() == null ?
                other.getNickname() == null :
                this.getNickname().equals(other.getNickname()));
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getPwd() == null) ? 0 : getPwd().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        return result;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", account=").append(account);
        sb.append(", pwd=").append(pwd);
        sb.append(", gender=").append(gender);
        sb.append(", age=").append(age);
        sb.append(", state=").append(state);
        sb.append(", birthday=").append(birthday);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", nickname=").append(nickname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}