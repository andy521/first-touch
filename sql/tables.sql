--------------------------create
--book
CREATE TABLE book(
  bookId INT NOT NULL AUTO_INCREMENT,
  bookName VARCHAR(50) NOT NULL ,
  bookAuthor VARCHAR (50) ,
  bookLanguage VARCHAR (20) ,
  bookVersion TINYINT ,
  bookDepreciation TINYINT ,
  bookPrice INT NOT NULL ,
  bookStock INT NOT NULL ,
  bookTags VARCHAR(255) ,
  bookImageUrl VARCHAR(255) ,
  bookDescription VARCHAR(255) ,
  bookCreateTime DATETIME ,
  PRIMARY KEY (bookId)
);


--------------------------drop
DROP TABLE book;