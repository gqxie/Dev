/**
 * Project Name:SpringLearnning
 * File Name:Computer.java
 * Package Name:com.gqxie.bean
 * Date:2017年6月3日下午3:14:26
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 * 
 */
/**
 * Project Name:SpringLearnning
 * File Name:Computer.java
 * Package Name:com.gqxie.bean
 * Date:2017年6月3日下午3:14:26
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 * 
 */

package com.gqxie.bean;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName:Computer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年6月3日 下午3:14:26 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.6
 * @see
 */
/**
 * ClassName: Computer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年6月3日 下午3:14:26 <br/>
 * 
 * @author xie
 * @version
 * @since JDK 1.6
 */
public class MessageBean
{
    private String name;
    private int age;
    private Date birth;
    private List<String> friends;
    private Set<String> cities;
    private Map<String, String> books;

    public void show()
    {
        System.out.println("name=" + name);
        System.out.println("age=" + age);
        System.out.println("birth=" + birth);
        for (String friend : friends)
        {
            System.out.println(friend);
        }
        for (String city : cities)
        {
            System.out.println(city);
        }
        Set<java.util.Map.Entry<String, String>> bookSet = books.entrySet();
        for (java.util.Map.Entry<String, String> e : bookSet)
        {
            System.out.println(e.getKey() + e.getValue());
        }
    }

    /**
     * name.
     * 
     * @return the name
     * @since JDK 1.6
     */
    public String getName()
    {
        return name;
    }

    /**
     * name.
     * 
     * @param name the name to set
     * @since JDK 1.6
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * age.
     * 
     * @return the age
     * @since JDK 1.6
     */
    public int getAge()
    {
        return age;
    }

    /**
     * age.
     * 
     * @param age the age to set
     * @since JDK 1.6
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * birth.
     * 
     * @return the birth
     * @since JDK 1.6
     */
    public Date getBirth()
    {
        return birth;
    }

    /**
     * birth.
     * 
     * @param birth the birth to set
     * @since JDK 1.6
     */
    public void setBirth(String birth)
    {
        Date date = Date.valueOf(birth);
        this.birth = date;
    }

    /**
     * friends.
     * 
     * @return the friends
     * @since JDK 1.6
     */
    public List<String> getFriends()
    {
        return friends;
    }

    /**
     * friends.
     * 
     * @param friends the friends to set
     * @since JDK 1.6
     */
    public void setFriends(List<String> friends)
    {
        this.friends = friends;
    }

    /**
     * cities.
     * 
     * @return the cities
     * @since JDK 1.6
     */
    public Set<String> getCities()
    {
        return cities;
    }

    /**
     * cities.
     * 
     * @param cities the cities to set
     * @since JDK 1.6
     */
    public void setCities(Set<String> cities)
    {
        this.cities = cities;
    }

    /**
     * books.
     * 
     * @return the books
     * @since JDK 1.6
     */
    public Map<String, String> getBooks()
    {
        return books;
    }

    /**
     * books.
     * 
     * @param books the books to set
     * @since JDK 1.6
     */
    public void setBooks(Map<String, String> books)
    {
        this.books = books;
    }

}
