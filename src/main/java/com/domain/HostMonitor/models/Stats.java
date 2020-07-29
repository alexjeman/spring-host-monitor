package com.domain.HostMonitor.models;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stats")
public class Stats {

    @Hidden
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "code")
    private int code;

    @Column(name = "response_time")
    private int responsetime;

    @CreatedDate
    @Column(name = "time")
    private Date time;

    @Hidden
    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;

    public Stats() {
        super();
    }

    public Stats(int code, int responsetime, Date time, Host host) {
        this.code = code;
        this.responsetime = responsetime;
        this.time = time;
        this.host = host;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getResponsetime() {
        return responsetime;
    }

    public void setResponsetime(int responsetime) {
        this.responsetime = responsetime;
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
