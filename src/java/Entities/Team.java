/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jamie
 */
@Entity
@Table(name = "TEAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
    @NamedQuery(name = "Team.findById", query = "SELECT t FROM Team t WHERE t.id = :id"),
    @NamedQuery(name = "Team.findByName", query = "SELECT t FROM Team t WHERE t.name = :name"),
    @NamedQuery(name = "Team.findByDivision", query = "SELECT t FROM Team t WHERE t.division = :division ORDER BY t.points desc")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Column(name = "WINS")
    private Integer wins = 0;
    @Column(name = "DRAWS")
    private Integer draws = 0;
    @Column(name = "LOSSES")
    private Integer losses = 0;
    @Column(name = "SCORED")
    private Integer scored = 0;
    @Column(name = "CONCEDED")
    private Integer conceded = 0;
    @Column(name = "GOALDIFFERENCE")
    private Integer goaldifference = 0;
    @Column(name = "POINTS")
    private Integer points = 0;
    
    @JoinColumn(name = "CLUB", referencedColumnName = "ID")
    @ManyToOne
    private Club club;
    @JoinColumn(name = "DIVISION", referencedColumnName = "ID")
    @ManyToOne
    private Division division;
    @OneToMany(mappedBy = "team")
    private List<User> teamCaptains;

    public Team() {
    }

    public Team(String name, Club club, Division division) {
        this.name = name;
        this.club = club;
        this.division = division;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getConceded() {
        return conceded;
    }

    public void setConceded(Integer conceded) {
        this.conceded = conceded;
    }

    public Integer getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public Integer getGoaldifference() {
        return goaldifference;
    }

    public void setGoaldifference(Integer goaldifference) {
        this.goaldifference = goaldifference;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getScored() {
        return scored;
    }

    public void setScored(Integer scored) {
        this.scored = scored;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @XmlTransient
    public List<User> getTeamCaptains() {
        return teamCaptains;
    }

    public void setTeamCaptains(List<User> teamCaptains) {
        this.teamCaptains = teamCaptains;
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
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
}
