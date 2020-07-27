package com.domain.HostMonitor.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "apikey")
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "key_hash")
    private String key_hash;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "apikey")
    private List<Host> hosts;

    public ApiKey() {
        super();
    }

    public ApiKey(String key_hash, String email, List<Host> hosts) {
        this.key_hash = key_hash;
        this.email = email;
        this.hosts = hosts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey_hash() {
        return key_hash;
    }

    public void setKey_hash(String key_hash) {
        this.key_hash = key_hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Host> getHosts() {
        return hosts;
    }

    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }
}
