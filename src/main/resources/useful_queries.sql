
-- Check the season division shapes
select	sd.ssn_num, d.div_name, count(*)
from 	season_division sd,
		season_division_team sdt,
        division d
where	sdt.ssn_num = sd.ssn_num
and		sdt.div_id = sd.div_id
and		d.div_id = sd.div_id
group by sd.ssn_num, d.div_name
order by sd.ssn_num desc, sd.div_pos;

-- Find how many fixtures don't have a date
select ssn_num, count(*)
from fixture where fixture_date is null
group by ssn_num
order by ssn_num;

select *
from fixture where fixture_date is null;


-- Find how many fixtures prior to today that have a fixture date, but no score
select *
from fixture where fixture_date is not null
and home_goals is null
and fixture_date <= curdate()
order by ssn_num;

-- Find fixtures that should exist, but don't
select	sd_h.ssn_num, d.div_name, ht.team_name, awt.team_name, count(*)
from 	season_division sd_h,
		season_division sd_a,
		season_division_team sdt_h,
        season_division_team sdt_a,
        division d,
        team ht,
        team awt
where	sdt_h.ssn_num = sd_h.ssn_num
and		sdt_a.ssn_num = sd_a.ssn_num
and		sd_h.ssn_num = sd_a.ssn_num
and		sdt_h.div_id = sd_h.div_id
and		sdt_a.div_id = sd_a.div_id
and		sd_a.div_id = sd_h.div_id
and		d.div_id = sd_h.div_id
and		ht.team_id = sdt_h.team_id
and		awt.team_id = sdt_a.team_id
and		sdt_h.team_id <> sdt_a.team_id
and		not exists (select 'x' from fixture f where f.ssn_num = sd_h.ssn_num and f.div_id = sd_h.div_id and f.home_team_id = sdt_h.team_id and f.away_team_id = sdt_a.team_id)
group by sd_h.ssn_num, d.div_name, ht.team_name, awt.team_name
order by sd_h.ssn_num desc, d.div_name, ht.team_name;


-- Count the number of fixtures for each team in a given season division
select	sdt.ssn_num, d.div_id, d.div_name, t.team_name, t.team_id, count(*)
from 	season_division_team sdt,
        division d,
        team t,
        fixture f
where	d.div_id = sdt.div_id
and sdt.ssn_num = 1995
and		t.team_id = sdt.team_id
and		f.ssn_num = sdt.ssn_num
and		f.div_id = sdt.div_id
and		(f.home_team_id = sdt.team_id or f.away_team_id = sdt.team_id)
group by sdt.ssn_num, d.div_id, d.div_name, t.team_name, t.team_id
order by sdt.ssn_num desc, sdt.div_id, sdt.team_id
;



-- Retrieve all fixtures for a season, in date, division and home team order
select	f.fixture_id, d.div_name, ht.team_name, at.team_name, f.fixture_date, f.home_goals, f.away_goals
from	fixture f,
		division d,
        team ht,
        team at,
        season_division sd
where	d.div_id = f.div_id
and		ht.team_id = f.home_team_id
and		at.team_id = f.away_team_id
and		sd.ssn_num = f.ssn_num
and		sd.div_id = f.div_id
and		f.ssn_num = 2016
order by	f.fixture_date, sd.div_pos, ht.team_name;

-- Retrieve all fixtures for a season that do not have a fixture date
select	f.fixture_id, f.ssn_num, d.div_name, ht.team_id, ht.team_name, at.team_id, at.team_name, f.fixture_date, f.home_goals, f.away_goals
from	fixture f,
		division d,
        team ht,
        team at,
        season_division sd
where	d.div_id = f.div_id
and		ht.team_id = f.home_team_id
and		at.team_id = f.away_team_id
and		sd.ssn_num = f.ssn_num
and		sd.div_id = f.div_id
and		f.fixture_date is null
order by	f.ssn_num desc, sd.div_pos, ht.team_name;

-- Retrieve all unplayed fixtures prior to today that have a fixture date, but no score
select	f.ssn_num, f.fixture_id, d.div_name, ht.team_name, at.team_name, f.fixture_date, f.home_goals, f.away_goals
from	fixture f,
		division d,
        team ht,
        team at,
        season_division sd
where	d.div_id = f.div_id
and		ht.team_id = f.home_team_id
and		at.team_id = f.away_team_id
and		sd.ssn_num = f.ssn_num
and		sd.div_id = f.div_id
and		f.fixture_date is not null
and		f.fixture_date < curdate()
and		f.home_goals is null
order by	f.fixture_date, sd.div_pos, ht.team_name;

-- Get the teams in each division in a season
select	sd.ssn_num, d.div_name, t.team_id, t.team_name
from	division d,
        team t,
        season_division sd,
        season_division_team sdt
where	sd.ssn_num = 2002
and		sdt.ssn_num = sd.ssn_num
and		sdt.div_id = sd.div_id
and		d.div_id = sd.div_id
and		t.team_id = sdt.team_id
order by	sd.ssn_num, t.team_name;

-- Find any teams that are in different divisions in the same season
select	sd.ssn_num, t.team_id, t.team_name, count(*)
from	division d,
        team t,
        season_division sd,
        season_division_team sdt
where	sdt.ssn_num = sd.ssn_num
and		sdt.div_id = sd.div_id
and		d.div_id = sd.div_id
and		t.team_id = sdt.team_id
group by sd.ssn_num, t.team_id, t.team_name
having count(*) > 1;

-- Show the duplicate divisions for each team found...
select	t.team_id, t.team_name, d.div_id, d.div_name
from	division d,
        team t,
        season_division sd,
        season_division_team sdt
where	sdt.ssn_num = sd.ssn_num
and		sdt.div_id = sd.div_id
and		d.div_id = sd.div_id
and		t.team_id = sdt.team_id
and		sd.ssn_num = 2002
and		t.team_id = 23;

-- Fill in the blanks for season division teams
insert into season_division_team
(ssn_num, div_id, team_id)
select distinct f.ssn_num, f.div_id, f.away_team_id
from fixture f
where f.ssn_num = 1995
and not exists (select 'x' from season_division_team sdt where sdt.ssn_num = f.ssn_num and sdt.div_id = f.div_id and sdt.team_id = f.away_team_id);

-- Find teams in division
select sd.ssn_num, d.div_name, t.team_name
from season_division_team sdt,
		season_division sd,
		division d,
        team t
where	sd.ssn_num = sdt.ssn_num
and		sd.div_id = sdt.div_id
and		d.div_id = sd.div_id
and		t.team_id = sdt.team_id
order by sd.ssn_num desc, sd.div_pos, t.team_name;



