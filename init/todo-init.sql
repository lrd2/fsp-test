alter session set "_ORACLE_SCRIPT"=true;
CREATE USER todo IDENTIFIED BY todo;

GRANT create session TO todo;
GRANT create table TO todo;
GRANT create view TO todo;
GRANT create any trigger TO todo;
GRANT create any procedure TO todo;
GRANT create sequence TO todo;
GRANT create synonym TO todo;
