select * from universities;
select * from students;

select
     students.name,
     students.course,
     students.budget,
     students.speciality,
     students.enroll_date,
     universities.name as "VUZ"
     from students
left join universities ON students.university_id = universities.id
where students.budget = true and speciality like '%1' and enroll_date > '03.09.2018';

