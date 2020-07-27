package com.domain.HostMonitor.models;

import io.swagger.v3.oas.annotations.Hidden;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "apikey")
public class ApiKey {

    @Hidden
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Hidden
    @Column(name = "key_hash")
    private String keyhash;

    @Column(name = "email")
    private String email;

    @Hidden
    @OneToMany(mappedBy = "apikey")
    private List<Host> host;

    public ApiKey() {
        super();
    }

    public ApiKey(String keyhash, String email, List<Host> host) {
        this.keyhash = keyhash;
        this.email = email;
        this.host = host;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKeyhash() {
        return keyhash;
    }

    public void setKeyhash(String keyhash) {
        this.keyhash = keyhash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Host> getHost() {
        return host;
    }

    public void setHost(List<Host> host) {
        this.host = host;
    }
}
