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
public class MrhaResult implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Fixture fixture;
    @OneToOne
    @ManyToOne
    private Team homeTeam;
    @OneToOne
    private Team awayTeam;
    private Integer goalsScored;
    private Integer goalsConceded;
    private String firstUmpire;
    private String secondUmpire;

    public MrhaResult() {
    }

    public MrhaResult(Fixture fixture, Team homeTeam, Integer goalsScored, Integer goalsConceded, String firstUmpire, String secondUmpire) {
        this.fixture = fixture;
        this.homeTeam = homeTeam;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.firstUmpire = firstUmpire;
        this.secondUmpire = secondUmpire;
    }

    
    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
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
    
    public Integer getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(Integer goalsScored) {
        this.goalsScored = goalsScored;
    }

    public Integer getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(Integer goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public String getFirstUmpire() {
        return firstUmpire;
    }

    public void setFirstUmpire(String firstUmpire) {
        this.firstUmpire = firstUmpire;
    }

    public String getSecondUmpire() {
        return secondUmpire;
    }

    public void setSecondUmpire(String secondUmpire) {
        this.secondUmpire = secondUmpire;
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
        if (!(object instanceof MrhaResult)) {
            return false;
        }
        MrhaResult other = (MrhaResult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getFixture().toString();
    }
    
}
