###### **Exercise 1: Control Structures**



q1)

DECLARE

&#x20; cursor c1 is select customer\_id from customers where age >=60;

BEGIN 

&#x20; for c in c1 loop

&#x20;   update loans set interest\_rate = interest\_rate - 1 where customer\_id = c.customer\_id;

&#x20; end loop;

END;

/



q2)

DECLARE

&#x20; cursor c1 is select customer\_id from customers where balance >=10000;

BEGIN 

&#x20; for c in c1 loop

&#x20;   update customers set IsVIP = True where customer\_id = c.customer\_id;

&#x20; end loop;

END;

/



q3)

DECLARE

&#x20; v\_name customers.customer\_name%TYPE;

&#x20; cursor c1 is select customer\_id from loans where due\_date-SYSDATE <= 30;

BEGIN 

&#x20; for c in c1 loop

&#x20;   select customer\_name into v\_name from customers where customer\_id = c.customer\_id;

&#x20;   DBMS\_OUTPUT.PUT\_LINE(

&#x20;     'Reminder: Loan due soon for customer ' ||  v\_name

&#x20;   );

&#x20; end loop;

END;

/



###### **Exercise 3: Stored Procedures**



q1)

create or replace procedure ProcessMonthlyInterest

is

begin

&#x20;   update accounts set balance = balance + (balance \* 0.01) where account\_type = 'SAVINGS';

end;

/



q2)

create or replace procedure updateemployeebonus(

&#x20;   p\_department in varchar2,

&#x20;   p\_bonus\_percentage in number

)

is

begin

&#x20;   update employees set salary = salary + (salary \* p\_bonus\_percentage / 100) where department = p\_department;

end;

/



q3)

create or replace procedure transferfunds(

&#x20;   p\_from\_account in number,

&#x20;   p\_to\_account in number,

&#x20;   p\_amount in number

)

is

&#x20;   v\_balance number;

begin

&#x20;   select balance into v\_balance from accounts where account\_id = p\_from\_account;



&#x20;   if v\_balance >= p\_amount then

&#x20;       update accounts set balance = balance - p\_amount where account\_id = p\_from\_account;



&#x20;       update accounts set balance = balance + p\_amount where account\_id = p\_to\_account;



&#x20;   else

&#x20;       dbms\_output.put\_line('insufficient balance');



&#x20;   end if;

end;

/

