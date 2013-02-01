-- See the MySQL client session below for creation and use of a table for test data, and stored procedure to insert data into it

mysql> use test;
Database changed
mysql> create table `my_data` (`id` int NOT NULL, `name` varchar(255) NOT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDb;
Query OK, 0 rows affected (0.01 sec)

mysql> show create table my_data;
+---------+---------------------------------------------------------------------------------------------------------------------------------------------+
| Table   | Create Table                                                                                                                                |
+---------+---------------------------------------------------------------------------------------------------------------------------------------------+
| my_data | CREATE TABLE `my_data` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 |
+---------+---------------------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)

mysql> insert into my_data values(1, 'name-1');
Query OK, 1 row affected (0.00 sec)

mysql> select * from my_data;
+----+--------+
| id | name   |
+----+--------+
|  1 | name-1 |
+----+--------+
1 row in set (0.00 sec)

mysql> delete from my_data;
Query OK, 1 row affected (0.00 sec)

mysql> DELIMITER $$
mysql> CREATE PROCEDURE fill_numbers( IN cnt INT )
    -> BEGIN
    ->   fold: LOOP
    ->     IF cnt < 1 THEN
    ->       LEAVE fold;
    ->     END IF;
    ->
    ->     INSERT INTO my_data values(cnt, concat("name-", cnt));
    ->     SET cnt = cnt - 1;
    ->
    ->   END LOOP fold;
    -> END$$
Query OK, 0 rows affected (0.00 sec)

mysql> DELIMITER ;
mysql> CALL fill_numbers(10);
Query OK, 1 row affected (0.01 sec)

mysql> select * from my_data;
+----+---------+
| id | name    |
+----+---------+
|  1 | name-1  |
|  2 | name-2  |
|  3 | name-3  |
|  4 | name-4  |
|  5 | name-5  |
|  6 | name-6  |
|  7 | name-7  |
|  8 | name-8  |
|  9 | name-9  |
| 10 | name-10 |
+----+---------+
10 rows in set (0.00 sec)
