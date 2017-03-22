create table category
(
  id IDENTITY,
  name varchar(50),
  description varchar(255),
  image_url varchar(50),
  is_active BOOLEAN,
  
  CONSTRAINT pk_category PRIMARY KEY(id)


);