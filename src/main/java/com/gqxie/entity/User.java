/**  
 * Project Name:Dev  
 * File Name:User.java  
 * Package Name:com.gqxie.entity  
 * Date:2017年6月25日上午8:54:58  
 * Copyright (c) 2017, xie.coder@gmail.com All Rights Reserved.  
 *  
*/

package com.gqxie.entity;
/**  
 * ClassName:User <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年6月25日 上午8:54:58 <br/>  
 * @author   xie  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable
{
    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * 
     * @since JDK 1.8
     */
    private static final long serialVersionUID = 3427446400328367569L;

    private Long              id;

    private Long              userID;

    private String            account;

    private String            pwd;

    private Integer           gender;

    private Integer           age;

    private Integer           state;

    private Date              birthDay;

    private String            email;

    private String            phone;

    private String            nickName;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * userID.
     * 
     * @return the userID
     * @since JDK 1.8
     */
    public Long getUserID()
    {
        return userID;
    }

    /**
     * userID.
     * 
     * @param userID
     *            the userID to set
     * @since JDK 1.8
     */
    public void setUserID(Long userID)
    {
        this.userID = userID;
    }

    /**
     * account.
     * 
     * @return the account
     * @since JDK 1.8
     */
    public String getAccount()
    {
        return account;
    }

    /**
     * account.
     * 
     * @param account
     *            the account to set
     * @since JDK 1.8
     */
    public void setAccount(String account)
    {
        this.account = account;
    }

    /**
     * pwd.
     * 
     * @return the pwd
     * @since JDK 1.8
     */
    public String getPwd()
    {
        return pwd;
    }

    /**
     * pwd.
     * 
     * @param pwd
     *            the pwd to set
     * @since JDK 1.8
     */
    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    /**
     * gender.
     * 
     * @return the gender
     * @since JDK 1.8
     */
    public Integer getGender()
    {
        return gender;
    }

    /**
     * gender.
     * 
     * @param gender
     *            the gender to set
     * @since JDK 1.8
     */
    public void setGender(Integer gender)
    {
        this.gender = gender;
    }

    /**
     * age.
     * 
     * @return the age
     * @since JDK 1.8
     */
    public Integer getAge()
    {
        return age;
    }

    /**
     * age.
     * 
     * @param age
     *            the age to set
     * @since JDK 1.8
     */
    public void setAge(Integer age)
    {
        this.age = age;
    }

    /**
     * state.
     * 
     * @return the state
     * @since JDK 1.8
     */
    public Integer getState()
    {
        return state;
    }

    /**
     * state.
     * 
     * @param state
     *            the state to set
     * @since JDK 1.8
     */
    public void setState(Integer state)
    {
        this.state = state;
    }

    /**
     * birthDay.
     * 
     * @return the birthDay
     * @since JDK 1.8
     */
    public Date getBirthDay()
    {
        return birthDay;
    }

    /**
     * birthDay.
     * 
     * @param birthDay
     *            the birthDay to set
     * @since JDK 1.8
     */
    public void setBirthDay(Date birthDay)
    {
        this.birthDay = birthDay;
    }

    /**
     * email.
     * 
     * @return the email
     * @since JDK 1.8
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * email.
     * 
     * @param email
     *            the email to set
     * @since JDK 1.8
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * phone.
     * 
     * @return the phone
     * @since JDK 1.8
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * phone.
     * 
     * @param phone
     *            the phone to set
     * @since JDK 1.8
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * nickName.
     * 
     * @return the nickName
     * @since JDK 1.8
     */
    public String getNickName()
    {
        return nickName;
    }

    /**
     * nickName.
     * 
     * @param nickName
     *            the nickName to set
     * @since JDK 1.8
     */
    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "User [userID=" + userID + ", account=" + account + ", gender=" + gender + ", nickName=" + nickName
                + "]";
    }

    public enum Fields
    {
        userID, account, pwd, gender, age, state, birthDay, email, phone, nickName
    }

}
