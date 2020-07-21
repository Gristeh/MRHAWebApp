/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Jamie
 */
@Entity
public class Fixture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fixtureDate;
    private String fixtureTime;
    private String location;
    @OneToOne
    private Team homeTeam;
    @OneToOne
    private Team awayTeam;
    @OneToOne
    private MrhaResult homeTeamResult;
    @OneToOne
    private MrhaResult awayTeamResult;
    private boolean completed;
    @ManyToOne
    private Division division;

    public Fixture() {
    }

    public Fixture(String fixtureDate, String fixtureTime, String location, Team homeTeam, Team awayTeam, Division division) {
        this.fixtureDate = fixtureDate;
        this.fixtureTime = fixtureTime;
        this.location = location;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamResult = null;
        this.awayTeamResult = null;
        this.completed = false;
        this.division = division;
    }
    
    public String getFixtureDate() {
        return fixtureDate;
    }

    public void setFixtureDate(String fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    public String getFixtureTime() {
        return fixtureTime;
    }

    public void setFixtureTime(String fixtureTime) {
        this.fixtureTime = fixtureTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public MrhaResult getHomeTeamResult() {
        return homeTeamResult;
    }

    public void setHomeTeamResult(MrhaResult homeTeamResult) {
        this.homeTeamResult = homeTeamResult;
    }

    public MrhaResult getAwayTeamResult() {
        return awayTeamResult;
    }

    public void setAwayTeamResult(MrhaResult awayTeamResult) {
        this.awayTeamResult = awayTeamResult;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
    
        

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fixture)) {
            return false;
        }
        Fixture other = (Fixture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getHomeTeam().getName() + " V " + this.getAwayTeam().getName();
    }
    
}
