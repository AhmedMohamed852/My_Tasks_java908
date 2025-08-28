
SELECT employee_id, first_name, last_name, salary from employees WHERE rownum = 1;
SELECT employee_id, first_name, last_name, salary from employees WHERE rownum = 2;
SELECT employee_id, first_name, last_name, salary from employees WHERE rownum = 3;
SELECT employee_id, first_name, last_name, salary from employees WHERE rownum = 4;

--  الكود ده شغال *** 

SELECT * 
FROM (
    SELECT employee_id, first_name, last_name, salary, ROWNUM AS r  -- <==( علشان غيرت اسم ال rownum to r) + خليت الكود داخل Subquery  
    FROM employees
    WHERE department_id = 80
    ORDER BY salary DESC
)
WHERE r = 3;


--  الكود ده مش شغال ***  

SELECT * 
FROM (
    SELECT employee_id, first_name, last_name, salary, ROWNUM   -- <== #################################################
    FROM employees
    WHERE department_id = 80
    ORDER BY salary DESC
)
WHERE ROWNUM = 3;



/* ====> 

ROWNUM بيشتغل سيكوانس ، فلازم الصف الأول ياخد 1 قبل ما التاني ياخد 2.

عشان كده ماينفعش أجيب  الصف رقم 2 من غير ما أجيب 1.

لو حطيت الاستعلام الأصلي جوا قوسين (subquery) ==> Oracle بيحسب الأول كل الصفوف ويديلها ROWNUM.

بعدين في الاستعلام الخارجي أقدر أفلتر عادي ==> (WHERE r = 2) وهيجيبلي الصف اللي عايزه.

*/



