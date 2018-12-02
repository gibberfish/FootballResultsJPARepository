package mindbadger.football.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "team_statistic")
@IdClass(TeamStatisticId.class)
public class TeamStatisticImpl implements TeamStatistic {
    private static final long serialVersionUID = 1L;

    public TeamStatisticImpl () {
    }

    public TeamStatisticImpl (SeasonDivisionTeam seasonDivisionTeam, Calendar fixtureDate, String statistic) {
        this.season = seasonDivisionTeam.getSeasonDivision().getSeason();
        this.division = seasonDivisionTeam.getSeasonDivision().getDivision();
        this.team = seasonDivisionTeam.getTeam();
        this.fixtureDate = fixtureDate;
        this.statistic = statistic;
    }

    @JsonManagedReference
    @Id
    @ManyToOne(targetEntity=SeasonImpl.class)
    @JoinColumn(name = "ssn_num", referencedColumnName="ssn_num")
    private Season season;

    @Id
    @ManyToOne(targetEntity=DivisionImpl.class)
    @JoinColumn(name = "div_id", referencedColumnName="div_id")
    private Division division;

    @Id
    @ManyToOne(targetEntity=TeamImpl.class)
    @JoinColumn(name = "team_id", referencedColumnName="team_id")
    private Team team;

//    @Id
//    @JoinColumns({
//            @JoinColumn(name="ssn_num", referencedColumnName="ssn_num"),
//            @JoinColumn(name="div_id", referencedColumnName="div_id"),
//            @JoinColumn(name="team_id", referencedColumnName="team_id")
//    })
//    @ManyToOne(targetEntity=SeasonDivisionTeamImpl.class)//, cascade=CascadeType.DETACH)
//    private SeasonDivisionTeam seasonDivisionTeam;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "fixture_date")
    private Calendar fixtureDate;

    @Id
    @Column(name = "statistic")
    private String statistic;

    @Column(name = "value")
    private Integer value;

//    @Override
//    public String getTeamStatisticId() {
//        String teamStatisticId = "";
//        teamStatisticId = teamStatisticId + seasonDivisionTeam.getSeasonDivision().getSeason().getSeasonNumber() + "_" +
//                seasonDivisionTeam.getSeasonDivision().getDivision().getDivisionId() + "_" +
//                seasonDivisionTeam.getTeam().getTeamId() + "_" +
//                fixtureDate;
//        //TODO Need to use a date format string here
//
//        return teamStatisticId;
//    }
//
//    @Override
//    public void setTeamStatisticId(String teamStatisticId) {
//        throw new UnsupportedOperationException("Can't set ID - composed of other field IDS");
//    }

//    @Override
//    public SeasonDivisionTeam getSeasonDivisionTeam() {
//        return this.seasonDivisionTeam;
//    }
//
//    @Override
//    public void setSeasonDivisionTeam(SeasonDivisionTeam seasonDivisionTeam) {
//        this.seasonDivisionTeam = seasonDivisionTeam;
//    }


    @Override
    public Season getSeason() {
        return this.season;
    }

    @Override
    public void setSeason(Season season) {
        this.season = season;
    }

    @Override
    public Division getDivision() {
        return this.division;
    }

    @Override
    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public Team getTeam() {
        return this.team;
    }

    @Override
    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public Calendar getFixtureDate() {
        return this.fixtureDate;
    }

    @Override
    public void setFixtureDate(Calendar fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    @Override
    public String getStatistic() {
        return this.statistic;
    }

    @Override
    public void setStatistic(String statistic) {
        this.statistic = statistic;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public void setValue(Integer value) {
        this.value = value;
    }
}
