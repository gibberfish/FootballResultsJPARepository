package mindbadger.football.domain;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "team_statistic")
@IdClass(SeasonDivisionTeamFixtureDateId.class)
public class TeamStatisticImpl implements TeamStatistic {
    private static final long serialVersionUID = 1L;

//    private String teamStatisticId;

    public TeamStatisticImpl () {
    }

    public TeamStatisticImpl (SeasonDivisionTeam seasonDivisionTeam, Calendar fixtureDate) {
        this.seasonDivisionTeam = seasonDivisionTeam;
        this.fixtureDate = fixtureDate;
        //this.teamStatisticId =
    }

    @Id
    @JoinColumns({
            @JoinColumn(name="ssn_num", referencedColumnName="ssn_num"),
            @JoinColumn(name="div_id", referencedColumnName="div_id"),
            @JoinColumn(name="team_id", referencedColumnName="team_id")
    })
    @ManyToOne(targetEntity=SeasonDivisionTeamImpl.class)//, cascade=CascadeType.DETACH)
    private SeasonDivisionTeam seasonDivisionTeam;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "fixture_date")
    private Calendar fixtureDate;

    @Id
    @Column(name = "statistic")
    private String statistic;

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

    @Override
    public SeasonDivisionTeam getSeasonDivisionTeam() {
        return this.seasonDivisionTeam;
    }

    @Override
    public void setSeasonDivisionTeam(SeasonDivisionTeam seasonDivisionTeam) {
        this.seasonDivisionTeam = seasonDivisionTeam;
    }

    @Override
    public Calendar getFixtureDate() {
        return this.fixtureDate;
    }

    @Override
    public void setFixtureDate(Calendar calendar) {
        this.fixtureDate = calendar;
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
