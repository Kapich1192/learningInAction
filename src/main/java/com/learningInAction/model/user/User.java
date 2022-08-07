package com.learningInAction.model.user;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {
    /*================================================= FIELDS =======================================================*/
    /*id*/
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    /*Main*/
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String tel;
    private String email;
    private boolean active ;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;
    /*================================================= CONSTRUCTORS =================================================*/
    public User() {}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, String name, String lastname, String tel, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.tel = tel;
        this.email = email;
    }
    /*================================================= GETTERS ======================================================*/

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getLastname() { return lastname; }
    public String getTel() { return tel; }
    public String getEmail() { return email; }
    public Set<Role> getRole() { return role; }
    public boolean getActive() { return active; }
    /*================================================= SETTERS ======================================================*/

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setName(String name) { this.name = name; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setTel(String tel) { this.tel = tel; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(Set<Role> role) { this.role = role; }
    public void setActive(boolean active) { this.active = active; }
    /*================================================= SYSTEM =======================================================*/
    /*================================================= METHODS ======================================================*/
}
