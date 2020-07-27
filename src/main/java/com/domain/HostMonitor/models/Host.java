package com.domain.HostMonitor.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "host")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "host_name")
    private String hostname;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "apikey_id")
    private ApiKey apikey;

    @OneToMany(mappedBy = "host")
    private List<Stats> stats;


    public Host() {
        super();
    }

    public Host(String hostname, String url, ApiKey apikey) {
        this.hostname = hostname;
        this.url = url;
        this.apikey = apikey;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ApiKey getApikey() {
        return apikey;
    }

    public void setApikey(ApiKey apikey) {
        this.apikey = apikey;
    }
}
