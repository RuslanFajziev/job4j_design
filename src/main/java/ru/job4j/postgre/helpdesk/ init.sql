CREATE DATABASE helpdesk WITH OWNER = postgres ENCODING = 'UTF8' CONNECTION LIMIT = -1;

--update pg_database set datallowconn = 'false' where datname = 'helpdesk';
--select pg_terminate_backend(pg_stat_activity.pid) from pg_stat_activity where pg_stat_activity.datname = 'helpdesk' and pid <> pg_backend_pid();
--drop database helpdesk;