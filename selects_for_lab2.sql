use Labor_SQL;

select * from Laptop
where speed>=500 and price<800
order by price desc;

select distinct model from PC
where model like '%1%1%';

select name, displacement  from Ships
join Classes on classes.class = ships.class;

-- 4
select model, price from laptop
where price > (select max(price) as max from pc);

select distinct maker from Product
join laptop on laptop.model=product.model
where speed <= 500;

-- 6
select concat("Name: ", name) as Name, 
concat("Class: ", class) as Class,
concat("Launched: ", launched) as Launched
from ships;

select date, count(*) as trips from trip
join pass_in_trip on pass_in_trip.trip_no = trip.trip_no
where town_from = "Rostov"
group by date
order by trips desc
limit 1;

-- 8
select distinct maker from laptop
join product on product.model = laptop.model
where speed >= 600;

select distinct maker from product
where model in (select model from laptop where speed >= 600);

-- 9
with  ClassCond as (
	select classes.class,
	case numguns
		when 8 then 1 else 0
	end as C1,
	case bore
		when 15 then 1 else 0
	end as C2,
    case displacement
		when 32000 then 1 else 0
	end as C3,
    case type
		when "bb" then 1 else 0
	end as C4,
    case country
		when 'USA' then 1 else 0
	end as C5,
    case launched
		when 1915 then 1 else 0
	end as C6,
    case classes.class
		when 'Kongo' then 1 else 0
	end as C7
	from classes
	join ships on ships.class = classes.class
)
select distinct * from ClassCond
where c1+c2+c3+c4+c5+c6+c7>=3;

-- 10
select classes.class, count(*) from classes
left join ships on ships.class = classes.class
group by classes.class
having count(*)<=2;


