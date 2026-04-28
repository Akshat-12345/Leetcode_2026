select distinct email 
from Person p1
where exists (
    select *
    from Person p2
    where p1.email = p2.email and p1.id != p2.id
);

-- select email
-- from person 
-- group by(email)
-- having count(email) > 1;