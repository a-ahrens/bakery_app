-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

--CREATE USER final_capstone_owner
--WITH PASSWORD 'finalcapstone';
--
--GRANT ALL
--ON ALL TABLES IN SCHEMA public
--TO final_capstone_owner;
--
--GRANT ALL
--ON ALL SEQUENCES IN SCHEMA public
--TO final_capstone_owner;

CREATE USER bakery_owner
WITH PASSWORD 'bakeryowner';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO bakery_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO bakery_owner;



--CREATE USER final_capstone_appuser
--WITH PASSWORD 'finalcapstone';
--
--GRANT SELECT, INSERT, UPDATE, DELETE
--ON ALL TABLES IN SCHEMA public
--TO final_capstone_appuser;
--
--GRANT USAGE, SELECT
--ON ALL SEQUENCES IN SCHEMA public
--TO final_capstone_appuser;

CREATE USER bakery_appuser
WITH PASSWORD 'bakeryappuser';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO bakery_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO bakery_appuser;
