
package ru.rs.testcase.phones.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Contact implements IsSerializable {
    
    private String name;
    
    private String phone;
    
    public Contact() {
    
    };
    
    public Contact(String name, String phone) {
    
        this.name = name;
        this.phone = phone;
    }
    
    /**
     * @return the name
     */
    public String getName() {
    
        return name;
    }
    
    /**
     * @return the phone
     */
    public String getPhone() {
    
        return phone;
    }
    
    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
    
        this.name = name;
    }
    
    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(String phone) {
    
        this.phone = phone;
    }
    
    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
    
        return "Contact [name=" + name + ", phone=" + phone + "]";
    }
    
}