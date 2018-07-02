/*1.1*/
select * from album where year(album.released) > 1970 order by album.released desc;
/*1.2*/
select * from album where album.album.label like 'Columbia';
/*1.3*/
select * from album.track where (album.track.duration/60) > 5;
/*1.4*/
select * from album.track where album.track.track_number = 1;
/*1.5*/
select SUM(album.track.duration) as sec,
       (SUM(album.track.duration)/60) AS minutes,
       ((SUM(album.track.duration)/60)/COUNT(*)) AS middle
from album.track where album_id = 11;

select id from album.track where duration in ((select MIN(album.track.duration) from album.track), (select MAX(album.track.duration) from album.track));

/*1.6*/
select * from album.track where title like '%Blues%';

/*1.7*/
select album.album.artist, album.album.title,
  album.track.track_number, album.track.title AS track_title,
  album.album.label from album
  join track where album.album.id = album.track.album_id order by album.album.title, track.track_number;

select album.album.artist, album.album.title,
  album.track.track_number, album.track.title AS track_title,
  album.album.label from album
  join track where album.album.id = album.track.album_id order by year(album.album.released) desc, track.track_number;

use world;
/*2.1*/
select * from city where city.Population > 5000000 limit 5 offset 5;
/*2.2*/
select * from country where Continent like '%Europe%' and IndepYear > 1990;
/*2.3*/
select * from country where (country.SurfaceArea > 5000000) or (country.Population> 10000000);
/*2.4*/
select country.Continent, COUNT(*) AS country_count from country group by continent order by country_count desc;
/*2.5*/
select * from country where continent = 'south america' and indepyear is not null order by indepyear limit 10;
/*2.6*/
select continent, country.name, count(*) as cities from country join city on country.code = city.countrycode where continent='Europe' group by city.countrycode order by cities desc limit 10;
/*2.7*/
select country.name, language, percentage from country join CountryLanguage on country.code = CountryLanguage.countrycode where language = 'spanish' and percentage > 50 order by percentage desc;

