package com.example.IFANOW.model;

import javax.persistence.*;


import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@Entity
@Table(name = "user_event_info")
public class UserEventInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ApiModelProperty(notes = "Name of the userid", name = "userid", required = true, value = "test userid")
    private long userid;

    @ApiModelProperty(notes = "Name of the noun", name = "noun", required = true, value = "test noun")
    private String noun;

    @ApiModelProperty(notes = "Name of the ts", name = "ts", required = true, value = "test ts")
    private long ts;

    @ApiModelProperty(notes = "Name of the latlong", name = "latlong", required = true, value = "test latlong")
    private long latlong;

    @ApiModelProperty(notes = "Name of the verb", name = "verb", required = true, value = "test verb")
    private String verb;

    @ApiModelProperty(notes = "Name of the timespent", name = "timespent", required = true, value = "test timespent")
    private long timespent;

    private int amount;

  /*  @OneToMany(targetEntity=Properties.class, mappedBy="propertyid",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Properties properties;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getNoun() {
        return noun;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public long getLatlong() {
        return latlong;
    }

    public void setLatlong(long latlong) {
        this.latlong = latlong;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public long getTimespent() {
        return timespent;
    }

    public void setTimespent(long timespent) {
        this.timespent = timespent;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
