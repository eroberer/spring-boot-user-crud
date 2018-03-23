# Spring-boot-user-crud
User crud operation (Restful) with Spring-Boot and MySql

# Database
Db-name : springcrud

Table-name : user

## Create SQL
```sql

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_turkish_ci NOT NULL,
  `surname` varchar(255) COLLATE utf8_turkish_ci NOT NULL,
  `birth_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
```
