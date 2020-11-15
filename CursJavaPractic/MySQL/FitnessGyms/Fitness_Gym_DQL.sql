use fitness_gym;
select count(email) from customers inner join accounts on accounts.customers_id = customers.id ;