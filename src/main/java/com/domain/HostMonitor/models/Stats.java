package com.domain.HostMonitor.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stats")
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "response_time")
    private int response_time;

    @CreatedDate
    @Column(name = "time")
    private Date time;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;

    public Stats() {
        super();
    }

    public Stats(String code, int response_time, Date time, Host host) {
        this.code = code;
        this.response_time = response_time;
        this.time = time;
        this.host = host;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getResponse_time() {
        return response_time;
    }

    public void setResponse_time(int response_time) {
        this.response_time = response_time;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }
}
